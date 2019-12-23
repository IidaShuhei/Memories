package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.service.PrefectureService;

/**
 * 各都道府県を表示するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/prefecture")
public class PrefectureController {

	@Autowired
	private PrefectureService service;

	/**
	 * 北海道を表示する.
	 * 
	 * @param model　モデル
	 * @return　北海道
	 */
	@RequestMapping("/hokkaido")
	public String findHokkaido(Model model) {
		List<Article> hokkaidoList = service.findHokkaido();
		model.addAttribute("hokkaidoList", hokkaidoList);
		return "hokkaido";
	}
	/**
	 * 青森を表示する.
	 * 
	 * @param model　モデル
	 * @return 青森
	 */
	@RequestMapping("/aomori")
	public String findAomori(Model model) {
		List<Article> aomoriList = service.findAomori();
		model.addAttribute("aomoriList", aomoriList);
		return "aomori";
	}
	/**
	 * 岩手を表示する.
	 * 
	 * @param model　モデル
	 * @return 岩手
	 */
	@RequestMapping("/iwate")
	public String findIwate(Model model) {
		List<Article> iwateList = service.findIwate();
		model.addAttribute("iwateList", iwateList);
		return "iwate";
	}
	
	/**
	 * 宮城を表示する.
	 * 
	 * @param model　モデル
	 * @return 宮城
	 */
	@RequestMapping("/miyagi")
	public String findMiyagi(Model model) {
		List<Article> miyagiList = service.findMiyagi();
		model.addAttribute("miyagiList", miyagiList);
		return "miyagi";
	}
	
	/**
	 * 秋田を表示する.
	 * 
	 * @param model　モデル
	 * @return 秋田
	 */
	@RequestMapping("/akita")
	public String findAkita(Model model) {
		List<Article> akitaList = service.findAkita();
		model.addAttribute("akitaList", akitaList);
		return "akita";
	}
	
	/**
	 * 山形を表示する.
	 * 
	 * @param model　モデル
	 * @return 山形
	 */
	@RequestMapping("/yamagata")
	public String findYamagata(Model model) {
		List<Article> yamagataList = service.findYamagata();
		model.addAttribute("yamagataList", yamagataList);
		return "yamagata";
	}
	/**
	 * 福島を表示する.
	 * 
	 * @param model　モデル
	 * @return 福島
	 */
	@RequestMapping("/fukushima")
	public String findFukushima(Model model) {
		List<Article> fukushimaList = service.findFukushima();
		model.addAttribute("fukushimaList", fukushimaList);
		return "fukushima";
	}
	
	/**
	 * 茨城を表示する.
	 * 
	 * @param model　モデル
	 * @return 茨城
	 */
	@RequestMapping("/ibaraki")
	public String findIbaraki(Model model) {
		List<Article> ibarakiList = service.findIbaraki();
		model.addAttribute("ibarakiList", ibarakiList);
		return "ibaraki";
	}
	
	/**
	 * 栃木を表示する.
	 * 
	 * @param model　モデル
	 * @return 栃木
	 */
	@RequestMapping("/tochigi")
	public String findTochigi(Model model) {
		List<Article> tochigiList = service.findTochigi();
		model.addAttribute("tochigiList", tochigiList);
		return "tochigi";
	}
	
	/**
	 * 群馬を表示する.
	 * 
	 * @param model　モデル
	 * @return 群馬
	 */
	@RequestMapping("/gunma")
	public String findGunma(Model model) {
		List<Article> gunmaList = service.findGunma();
		model.addAttribute("gunmaList",gunmaList);
		return "gunma";
	}
	
	/**
	 * 埼玉を表示する.
	 * 
	 * @param model　モデル
	 * @return 埼玉
	 */
	@RequestMapping("/saitama")
	public String findSaitama(Model model) {
		List<Article> saitamaList = service.findSaitama();
		model.addAttribute("saitamaList", saitamaList);
		return "saitama";
	}
	
	/**
	 * 千葉を表示する.
	 * 
	 * @param model　モデル
	 * @return 千葉
	 */
	@RequestMapping("/chiba")
	public String findChiba(Model model) {
		List<Article> chibaList = service.findChiba();
		model.addAttribute("chibaList", chibaList);
		return "chiba";
	}
	
	/**
	 * 東京を表示する.
	 * 
	 * @param model　モデル
	 * @return 東京
	 */
	@RequestMapping("/tokyo")
	public String findTokyo(Model model) {
		List<Article> tokyoList = service.findTokyo();
		model.addAttribute("tokyoList", tokyoList);
		return "tokyo";
	}
	
	/**
	 * 神奈川を表示する.
	 * 
	 * @param model　モデル
	 * @return 神奈川
	 */
	@RequestMapping("/kanagawa")
	public String findKanagawa(Model model) {
		List<Article> kanagawaList = service.findKanagawa();
		model.addAttribute("kanagawaList", kanagawaList);
		return "kanagawa";
	}
	
	/**
	 * 新潟を表示する.
	 * 
	 * @param model　モデル
	 * @return 新潟
	 */
	@RequestMapping("/nigata")
	public String findNigata(Model model) {
		List<Article> nigataList = service.findNigata();
		model.addAttribute("nigataList", nigataList);
		return "nigata";
	}
	
	/**
	 * 富山を表示する.
	 * 
	 * @param model　モデル
	 * @return 富山
	 */
	@RequestMapping("/toyama")
	public String findToyama(Model model) {
		List<Article> toyamaList = service.findToyama();
		model.addAttribute("toyamaList", toyamaList);
		return "toyama";
	}
	
	/**
	 * 石川を表示する.
	 * 
	 * @param model　モデル
	 * @return 石川
	 */
	@RequestMapping("/ishikawa")
	public String findIshikawa(Model model) {
		List<Article> ishikawaList = service.findIshikawa();
		model.addAttribute("ishikawaList", ishikawaList);
		return "ishikawa";
	}
	
	/**
	 * 福井を表示する.
	 * 
	 * @param model　モデル
	 * @return 福井
	 */
	@RequestMapping("/fukui")
	public String findFukui(Model model) {
		List<Article> fukuiList = service.findFukui();
		model.addAttribute("fukuiList", fukuiList);
		return "fukui";
	}
	
	/**
	 * 山梨を表示する.
	 * 
	 * @param model　モデル
	 * @return 山梨
	 */
	@RequestMapping("/yamanashi")
	public String findYamanashi(Model model) {
		List<Article> yamanashiList = service.findYamanashi();
		model.addAttribute("yamanashiList", yamanashiList);
		return "yamanashi";
	}
	
	/**
	 * 長野を表示する.
	 * 
	 * @param model　モデル
	 * @return 長野
	 */
	@RequestMapping("/nagano")
	public String findNagano(Model model) {
		List<Article> naganoList = service.findNagano();
		model.addAttribute("naganoList", naganoList);
		return "nagano";
	}
	
	/**
	 * 岐阜を表示する.
	 * 
	 * @param model　モデル
	 * @return 岐阜
	 */
	@RequestMapping("/gihu")
	public String findGihu(Model model) {
		List<Article> gihuList = service.findGihu();
		model.addAttribute("gihuList", gihuList);
		return "gihu";
	}
	
	/**
	 * 静岡を表示する.
	 * 
	 * @param model　モデル
	 * @return 静岡
	 */
	@RequestMapping("/shizuoka")
	public String findShizuoka(Model model) {
		List<Article> shizuokaList = service.findShizuoka();
		model.addAttribute("shizuokaList", shizuokaList);
		return "shizuoka";
	}
	
	/**
	 * 愛知を表示する.
	 * 
	 * @param model　モデル
	 * @return 愛知
	 */
	@RequestMapping("/aichi")
	public String findAichi(Model model) {
		List<Article> aichiList = service.findAichi();
		model.addAttribute("aichiList", aichiList);
		return "aichi";
	}
	
	/**
	 * 三重を表示する.
	 * 
	 * @param model　モデル
	 * @return 三重
	 */
	@RequestMapping("/mie")
	public String findMie(Model model) {
		List<Article> mieList = service.findMie();
		model.addAttribute("mieList", mieList);
		return "mie";
	}
	
	/**
	 * 滋賀を表示する.
	 * 
	 * @param model　モデル
	 * @return 滋賀
	 */
	@RequestMapping("/shiga")
	public String findShiga(Model model) {
		List<Article> shigaList = service.findShiga();
		model.addAttribute("shigaList", shigaList);
		return "shiga";
	}
	
	/**
	 * 京都を表示する.
	 * 
	 * @param model　モデル
	 * @return 京都
	 */
	@RequestMapping("/kyoto")
	public String findKyoto(Model model) {
		List<Article> kyotoList = service.findKyoto();
		model.addAttribute("kyotoList", kyotoList);
		return "kyoto";
	}
	
	/**
	 * 大阪を表示する.
	 * 
	 * @param model　モデル
	 * @return 大阪
	 */
	@RequestMapping("/osaka")
	public String findOsaka(Model model) {
		List<Article> osakaList = service.findOsaka();
		model.addAttribute("osakaList", osakaList);
		return "osaka";
	}
	
	/**
	 * 兵庫を表示する.
	 * 
	 * @param model　モデル
	 * @return 兵庫
	 */
	@RequestMapping("/hyogo")
	public String findHyogo(Model model) {
		List<Article> hyogoList = service.findHyogo();
		model.addAttribute("hyogoList", hyogoList);
		return "hyogo";
	}
	
	/**
	 * 奈良を表示する.
	 * 
	 * @param model　モデル
	 * @return 奈良
	 */
	@RequestMapping("/nara")
	public String findNara(Model model) {
		List<Article> naraList = service.findNara();
		model.addAttribute("naraList", naraList);
		return "nara";
	}
	
	/**
	 * 和歌山を表示する.
	 * 
	 * @param model　モデル
	 * @return 和歌山
	 */
	@RequestMapping("/wakayama")
	public String findWakayama(Model model) {
		List<Article> wakayamaList = service.findWakayama();
		model.addAttribute("wakayamaList", wakayamaList);
		return "wakayama";
	}
	
	/**
	 * 鳥取を表示する.
	 * 
	 * @param model　モデル
	 * @return 鳥取
	 */
	@RequestMapping("/tottori")
	public String findTottori(Model model) {
		List<Article> tottoriList = service.findTottori();
		model.addAttribute("tottoriList", tottoriList);
		return "tottori";
	}
	
	/**
	 * 島根を表示する.
	 * 
	 * @param model　モデル
	 * @return 島根
	 */
	@RequestMapping("/shimane")
	public String findShimane(Model model) {
		List<Article> shimaneList = service.findShimane();
		model.addAttribute("shimaneList", shimaneList);
		return "shimane";
	}
	
	/**
	 * 岡山を表示する.
	 * 
	 * @param model　モデル
	 * @return 岡山
	 */
	@RequestMapping("/okayama")
	public String findOkayama(Model model) {
		List<Article> okayamaList = service.findOkayama();
		model.addAttribute("okayamaList", okayamaList);
		return "okayama";
	}
	
	/**
	 * 広島を表示する.
	 * 
	 * @param model　モデル
	 * @return 広島
	 */
	@RequestMapping("/hiroshima")
	public String findHiroshima(Model model) {
		List<Article> hiroshimaList = service.findHiroshima();
		model.addAttribute("hiroshimaList", hiroshimaList);
		return "hiroshima";
	}
	
	/**
	 * 山口を表示する.
	 * 
	 * @param model　モデル
	 * @return 山口
	 */
	@RequestMapping("/yamaguchi")
	public String findYamaguchi(Model model) {
		List<Article> yamaguchiList = service.findYamaguchi();
		model.addAttribute("yamaguchiList", yamaguchiList);
		return "yamaguchi";
	}
	
	/**
	 * 徳島を表示する.
	 * 
	 * @param model　モデル
	 * @return 徳島
	 */
	@RequestMapping("/tokushima")
	public String findTokushima(Model model) {
		List<Article> tokushimaList = service.findTokushima();
		model.addAttribute("tokushimaList", tokushimaList);
		return "tokushima";
	}
	
	/**
	 * 香川を表示する.
	 * 
	 * @param model　モデル
	 * @return 香川
	 */
	@RequestMapping("/kagawa")
	public String findKagawa(Model model) {
		List<Article> kagawaList = service.findKagawa();
		model.addAttribute("kagawaList", kagawaList);
		return "kagawa";
	}
	
	/**
	 * 愛媛を表示する.
	 * 
	 * @param model　モデル
	 * @return 愛媛
	 */
	@RequestMapping("/ehime")
	public String findEhime(Model model) {
		List<Article> ehimeList = service.findEhime();
		model.addAttribute("ehimeList", ehimeList);
		return "ehime";
	}
	
	/**
	 * 高知を表示する.
	 * 
	 * @param model　モデル
	 * @return 高知
	 */
	@RequestMapping("/kochi")
	public String findKochi(Model model) {
		List<Article> kochiList = service.findKochi();
		model.addAttribute("kochiList", kochiList);
		return "kochi";
	}
	
	/**
	 * 福岡を表示する.
	 * 
	 * @param model　モデル
	 * @return 福岡
	 */
	@RequestMapping("/fukuoka")
	public String findFukuoka(Model model) {
		List<Article> fukuokaList = service.findFukuoka();
		model.addAttribute("fukuokaList", fukuokaList);
		return "fukuoka";
	}
	
	/**
	 * 佐賀を表示する.
	 * 
	 * @param model　モデル
	 * @return 佐賀
	 */
	@RequestMapping("/saga")
	public String findSaga(Model model) {
		List<Article> sagaList = service.findSaga();
		model.addAttribute("sagaList", sagaList);
		return "saga";
	}
	
	/**
	 * 長崎を表示する.
	 * 
	 * @param model　モデル
	 * @return 長崎
	 */
	@RequestMapping("/nagasaki")
	public String findNagasaki(Model model) {
		List<Article> nagasakiList = service.findNagasaki();
		model.addAttribute("nagasakiList", nagasakiList);
		return "nagasaki";
	}
	
	/**
	 * 熊本を表示する.
	 * 
	 * @param model　モデル
	 * @return 熊本
	 */
	@RequestMapping("/kumamoto")
	public String findKumamoto(Model model) {
		List<Article> kumamotoList = service.findKumamoto();
		model.addAttribute("kumamotoList", kumamotoList);
		return "kumamoto";
	}
	
	/**
	 * 大分を表示する.
	 * 
	 * @param model　モデル
	 * @return 大分
	 */
	@RequestMapping("/oita")
	public String findOita(Model model) {
		List<Article> oitaList = service.findOita();
		model.addAttribute("oitaList", oitaList);
		return "oita";
	}
	
	/**
	 * 宮崎を表示する.
	 * 
	 * @param model　モデル
	 * @return 宮崎
	 */
	@RequestMapping("/miyazaki")
	public String findMiyazaki(Model model) {
		List<Article> miyazakiList = service.findMiyazaki();
		model.addAttribute("miyazakiList", miyazakiList);
		return "miyazaki";
	}
	
	/**
	 * 鹿児島を表示する.
	 * 
	 * @param model　モデル
	 * @return 鹿児島
	 */
	@RequestMapping("/kagoshima")
	public String findKagoshima(Model model) {
		List<Article> kagoshimaList = service.findKagoshima();
		model.addAttribute("kagoshimaList", kagoshimaList);
		return "kagoshima";
	}
	
	/**
	 * 沖縄を表示する.
	 * 
	 * @param model　モデル
	 * @return 沖縄
	 */
	@RequestMapping("/okinawa")
	public String findOkinawa(Model model) {
		List<Article> okinawaList = service.findOkinawa();
		model.addAttribute("okinawaList", okinawaList);
		return "okinawa";
	}
	
}
