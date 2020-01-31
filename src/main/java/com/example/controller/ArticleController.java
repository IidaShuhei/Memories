package com.example.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.domain.Comment;
import com.example.domain.LoginUser;
import com.example.form.ArticleForm;
import com.example.form.CommentForm;
import com.example.form.SearchForm;
import com.example.service.ArticleDetailService;
import com.example.service.ArticleService;
import com.example.service.CommentService;
import com.example.service.UserService;

/**
 * 記事を表示するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/")
public class ArticleController {

	// 1ページに表示する記事数は9
	private static final int VIEW_SIZE = 9;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private ArticleDetailService detailService;
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	private ArticleForm setUpForm() {
		return new ArticleForm();
	}
	
	@Autowired
	public HttpSession session;

	/**
	 * 記事を全件検索する.
	 * 
	 * @param model モデル
	 * @return 全件検索結果
	 */
	@RequestMapping("")
	public String findAll(Model model, Integer page,@AuthenticationPrincipal LoginUser loginUser) {
		
		Integer userId = null;
		Integer preUserId = null;
		
		//登録してあるID
		if (loginUser != null) {
			userId = loginUser.getUser().getUserId();
			
		//セッションに入っているID
		} else if (session.getAttribute("userId") != null) {
			preUserId = (Integer) session.getAttribute("userId");
			
		//自動採番のID
		} else {
			String source = session.getId();
			preUserId = source.hashCode();
		}
		
		model.addAttribute("userId", userId);
		model.addAttribute("preUserId", preUserId);
		
		//ログインユーザーがあればアイコンを出す
		if(loginUser != null) {
			model.addAttribute("image", userService.findImageById(userId).getImage());
		}
		
		List<Article> articleList = articleService.findAll();
		// ページング機能追加
		if (page == null) {
			// ページ数の指定が無い場合は1ページ目を表示させる
			page = 1;
		}
		// 表示させたいページ数、ページサイズ、従業員リストを渡し１ページに表示させる従業員リストを絞り込み
		Page<Article> articlePage = articleService.showListPaging(page, VIEW_SIZE, articleList);
		model.addAttribute("articlePage", articlePage);

		// ページングのリンクに使うページ数をスコープに格納 (例)28件あり1ページにつき10件表示させる場合→1,2,3がpageNumbersに入る
		List<Integer> pageNumbers = calcPageNumbers(model, articlePage);
		model.addAttribute("pageNumbers", pageNumbers);

		// オートコンプリート用にJavaScriptの配列の中身を文字列で作ってスコープへ格納
		StringBuilder articleListForAutocomplete = articleService
				.getArticleListForAutocomplete(articleService.findAll());
		model.addAttribute("articleListForAutocomplete", articleListForAutocomplete);
		
		return "article_list";
	}

	/**
	 * 記事をタイトル、投稿者名、内容のいずれかで曖昧検索する
	 * 
	 * @param title
	 * @param name
	 * @param content
	 * @param model
	 * @return
	 */
	@RequestMapping("/findByInfo")
	public String findByTitleOrNameOrContent(SearchForm searchForm, Model model, Integer page) {
		List<Article> articleList = null;
		if (searchForm.getSearch() == 1) {
			articleList = articleService.showArticleListFindByTitle(searchForm.getContents());
		} else if (searchForm.getSearch() == 2) {
			articleList = articleService.showArticleListFindByName(searchForm.getContents());
		} else if (searchForm.getSearch() == 3) {
			articleList = articleService.showArticleListFindByContent(searchForm.getContents());
		}
		model.addAttribute("articlePage", articleList);
		return "article_list";

	}

	/**
	 * 記事を投稿する画面.
	 * 
	 * @return 記事を投稿する画面へ遷移
	 */
	@RequestMapping("/insert")
	public String insert() {
		return "insertArticle";
	}

	/**
	 * 記事を投稿する.
	 * 
	 * @param articleForm 記事フォーム
	 * @param model       モデル
	 * @return 記事一覧
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/registerArticle")
	public String RegisterArticle(@Validated ArticleForm articleForm, BindingResult result, Model model,@AuthenticationPrincipal LoginUser loginUser)
			throws IOException, ParseException {
		
		if (result.hasErrors()) {
			return insert();
		}
		Article article = new Article();
		article.setUserId(loginUser.getUser().getUserId());
		article.setTitle(articleForm.getTitle());
		article.setName(articleForm.getName());
		article.setPrefecture(articleForm.getPrefecture());
		article.setContent(articleForm.getContent());
		LocalDate localDate = LocalDate.now();
		java.util.Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		article.setPostDate(date);
		article.setTripStartDate(Date.valueOf(articleForm.getTripStartDate().replace("/", "-")));
		article.setTripEndDate(Date.valueOf(articleForm.getTripEndDate().replace("/", "-")));
		

		byte[] encoded = Base64.getEncoder().encode(articleForm.getImagePath().getBytes());
		Charset charset = StandardCharsets.UTF_8;

		String base64 = new String(encoded, charset);
		String fileExtension = articleForm.getImagePath().getOriginalFilename()
				.substring(articleForm.getImagePath().getOriginalFilename().length() - 3);
		StringBuilder base64image = new StringBuilder();
		if ("jpg".equals(fileExtension)) {
			base64image.append("data:image/jpeg;base64,");
		}
		if ("png".equals(fileExtension)) {
			base64image.append("data:image/png;base64,");
		}
		base64image.append(base64);
		article.setImagePath(base64image.toString());
		article.setTransportation(articleForm.getTransportation());
		if (!(articleForm.getFare().equals(""))) {
			article.setFare(Integer.parseInt(articleForm.getFare()));
		}
		if (!(articleForm.getHotelName().equals(""))) {
			article.setHotelName(articleForm.getHotelName());

		}
		if (!(articleForm.getHotelFee().equals(""))) {
			article.setHotelFee(Integer.parseInt(articleForm.getHotelFee()));

		}
		if (!(articleForm.getMealFee().equals(""))) {
			article.setMealFee(Integer.parseInt(articleForm.getMealFee()));

		}
		if (!(articleForm.getOtherAmount().equals(""))) {

			article.setOtherAmount(Integer.parseInt(articleForm.getOtherAmount()));
		}
		if (!(articleForm.getTotalFee().equals(""))) {

			article.setTotalFee(Integer.parseInt(articleForm.getTotalFee()));
		}
		articleService.registerArticle(article,loginUser);
		return "forward:/";
	}

	/**
	 * コメントを挿入する.
	 * 
	 * @param commentForm コメントフォーム
	 * @return 記事一覧表示画面
	 */
	@RequestMapping("/insertComment")
	public String insertComment(CommentForm commentForm) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentForm, comment);
		comment.setArticleId(Integer.parseInt(commentForm.getArticleId()));
		commentService.insert(comment);
		return "redirect:/";
	}

	/**
	 * 更新画面へ遷移.
	 * 
	 * @return 更新画面
	 */
	@RequestMapping("/updateScreen")
	public String updateScreen(Integer id, Model model, ArticleForm articleForm) {
		Article article = detailService.showArticleDetail(id);
		BeanUtils.copyProperties(article, articleForm);
		model.addAttribute("article", article);
		return "updateArticle";
	}

	/**
	 * 記事を更新する.
	 * 
	 * @param articleForm 記事フォーム
	 * @param model       モデル
	 * @return 編集画面
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping("/update")
	public String update(ArticleForm articleForm, Model model) throws ParseException, IOException {
		Article article = new Article();
		BeanUtils.copyProperties(articleForm, article);
		article.setId(Integer.parseInt(articleForm.getId()));
		LocalDate localDate = LocalDate.now();
		java.util.Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		article.setPostDate(date);

		byte[] encoded = Base64.getEncoder().encode(articleForm.getImagePath().getBytes());
		Charset charset = StandardCharsets.UTF_8;

		String base64 = new String(encoded, charset);
		String fileExtension = articleForm.getImagePath().getOriginalFilename()
				.substring(articleForm.getImagePath().getOriginalFilename().length() - 3);
		StringBuilder base64image = new StringBuilder();
		if ("jpg".equals(fileExtension)) {
			base64image.append("data:image/jpeg;base64,");
		}
		if ("png".equals(fileExtension)) {
			base64image.append("data:image/png;base64,");
		}
		base64image.append(base64);
		article.setImagePath(base64image.toString());
		
		
		article.setTripStartDate(Date.valueOf(articleForm.getTripStartDate().replace("/", "-")));
		article.setTripEndDate(Date.valueOf(articleForm.getTripEndDate().replace("/", "-")));
		article.setTransportation(articleForm.getTransportation());
		article.setFare(Integer.parseInt(articleForm.getFare()));
		article.setHotelName(articleForm.getHotelName());
		article.setHotelFee(Integer.parseInt(articleForm.getHotelFee()));
		article.setMealFee(Integer.parseInt(articleForm.getMealFee()));
		article.setOtherAmount(Integer.parseInt(articleForm.getOtherAmount()));
		article.setTotalFee(Integer.parseInt(articleForm.getTotalFee()));

		articleService.update(article);
		return "forward:/";
	}

	/**
	 * 記事を削除する.
	 * 
	 * @param id ID
	 * @return 記事表示
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) {
		articleService.delete(id);
		return "redirect:/";
	}

	/**
	 * 検索用日本地図表示.
	 * 
	 * @return 日本地図
	 */
	@RequestMapping("/prefecture")
	public String index2() {
		return "japan";
	}

	/**
	 * ページングのリンクに使うページ数をスコープに格納 (例)28件あり1ページにつき10件表示させる場合→1,2,3がpageNumbersに入る
	 * 
	 * @param model       モデル
	 * @param articlePage ページング情報
	 */
	private List<Integer> calcPageNumbers(Model model, Page<Article> articlePage) {
		int totalPages = articlePage.getTotalPages();
		List<Integer> pageNumbers = null;
		if (totalPages > 0) {
			pageNumbers = new ArrayList<Integer>();
			for (int i = 1; i <= totalPages; i++) {
				pageNumbers.add(i);
			}
		}
		return pageNumbers;
	}
}