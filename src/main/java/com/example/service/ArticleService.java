package com.example.service;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Article;
import com.example.domain.LoginUser;
import com.example.repository.ArticleRepository;

@Service
@Transactional
public class ArticleService {

	@Autowired
	private ArticleRepository repository;
	
	@Autowired
	public HttpSession session;
	
	/**
	 * 記事一覧を表示する.
	 * 
	 * @return 記事一覧
	 */
	public List<Article> findAll(){
		return repository.findAll();
	}
	
	/**
	 * 記事をタイトルから曖昧検索する.
	 * 
	 * @param title タイトル
	 * @return 全件検索結果、曖昧検索結果
	 */
	public List<Article> showArticleListFindByTitle(String title) {
		return repository.findByTitle(title);
	}
	
	/**
	 * 記事を投稿者名から曖昧検索する.
	 * 
	 * @param name 名前
	 * @return 全件検索結果、曖昧検索結果
	 */
	public List<Article> showArticleListFindByName(String name) {
		return repository.findByName(name);
	}
	
	/**
	 * 記事を内容から曖昧検索する.
	 *
	 * @param content 内容
	 * @return 全件検索結果、曖昧検索結果
	 */
	public List<Article> showArticleListFindByContent(String content) {
		return repository.findByContent(content);
	}
	
	/**
	 *記事を登録する.
	 *
	 * @param article
	 */
	public void registerArticle(Article article, @AuthenticationPrincipal LoginUser loginUser) {
		repository.insert(article);
	}
	
	/**
	 * 記事詳細を表示する.
	 * 
	 * @param id　ID
	 * @return 記事ID
	 */
	public Article showDetail(Integer id) {
		return repository.load(id);
	}
	
	/**
	 * 記事を更新する.
	 * 
	 * @param article 記事
	 */
	public void update(Article article) {
		repository.update(article);
	}
	
	/**
	 * 記事を削除する.
	 * 
	 * @param id ID
	 */
	public void delete(Integer id) {
		repository.delete(id);
	}
	
	/**
	 * ページング用メソッド.
     * @param page 表示させたいページ数
	 * @param size １ページに表示させる記事数
	 * @param employeeList 絞り込み対象リスト
	 * @return １ページに表示されるサイズ分の記事一覧情報
	 */
	public Page<Article> showListPaging(int page, int size,List<Article> articleList){
//		 表示させたいページ数を-1しなければうまく動かない
		page--;
//		 どの記事から表示させるかと言うカウント値
		int startItemCount = page * size;
//		 絞り込んだ後の記事リストが入る変数
		List<Article> list;
		
    	if(articleList.size()<startItemCount) {
//			 (ありえないが)もし表示させたい記事カウントがサイズよりも大きい場合は空のリストを返す
			list= Collections.emptyList();
		}else {
//			 該当ページに表示させる記事一覧を作成
			int toIndex = Math.min(startItemCount + size, articleList.size());
			list = articleList.subList(startItemCount, toIndex);
		}
		
		Page<Article> articlePage = new PageImpl<Article>(list, PageRequest.of(page,size),articleList.size());
    	return articlePage;
	}
	
	 /* オートコンプリート用にJavaScriptの配列の中身を文字列で作ります.
	 * 
	 * @param articleList 記事一覧
	 * @return オートコンプリート用JavaScriptの配列の文字列
	 */
	public StringBuilder getArticleListForAutocomplete(List<Article> articleList) {
		StringBuilder articleListForAutocomplete = new StringBuilder();
		for (int i = 0; i < articleList.size(); i++) {
			if (i != 0) {
				articleListForAutocomplete.append(",");
			}
			Article article = articleList.get(i);
			articleListForAutocomplete.append("\"");
			articleListForAutocomplete.append(article.getName());
			articleListForAutocomplete.append("\"");
		}
		return articleListForAutocomplete;
	}
}
