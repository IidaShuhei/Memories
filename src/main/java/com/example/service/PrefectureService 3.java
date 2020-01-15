package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Article;
import com.example.repository.PrefectureRepository;

/**
 * 各都道府県を表示する.
 * 
 * @author iidashuhei
 *
 */
@Service
@Transactional
public class PrefectureService {

	@Autowired
	private PrefectureRepository repository;

	/**
	 * 北海道を表示する.
	 * 
	 * @return 北海道
	 */
	public List<Article> findHokkaido() {
		return repository.findHokkaido();
	}

	/**
	 * 青森を表示する.
	 * 
	 * @return 青森
	 */
	public List<Article> findAomori() {
		return repository.findAomori();
	}

	/**
	 * 岩手を表示する.
	 * 
	 * @return 岩手
	 */
	public List<Article> findIwate() {
		return repository.findIwate();
	}

	/**
	 * 宮城を表示する.
	 * 
	 * @return 宮城
	 */
	public List<Article> findMiyagi() {
		return repository.findMiyagi();
	}

	/**
	 * 秋田を表示する.
	 * 
	 * @return 秋田
	 */
	public List<Article> findAkita() {
		return repository.findAkita();
	}

	/**
	 * 山形を表示する.
	 * 
	 * @return 山形
	 */
	public List<Article> findYamagata() {
		return repository.findYamagata();
	}

	/**
	 * 福島を表示する.
	 * 
	 * @return 福島
	 */
	public List<Article> findFukushima() {
		return repository.findFukushima();
	}

	/**
	 * 茨城を表示する.
	 * 
	 * @return 茨城
	 */
	public List<Article> findIbaraki() {
		return repository.findIbaraki();
	}

	/**
	 * 栃木を表示する.
	 * 
	 * @return 栃木
	 */
	public List<Article> findTochigi() {
		return repository.findTochigi();
	}

	/**
	 * 群馬を表示する.
	 * 
	 * @return 群馬
	 */
	public List<Article> findGunma() {
		return repository.findGunma();
	}

	/**
	 * 埼玉を表示する.
	 * 
	 * @return 埼玉
	 */
	public List<Article> findSaitama() {
		return repository.findSaitama();
	}

	/**
	 * 千葉を表示する.
	 * 
	 * @return 千葉
	 */
	public List<Article> findChiba() {
		return repository.findChiba();
	}

	/**
	 * 東京を表示する.
	 * 
	 * @return 東京
	 */
	public List<Article> findTokyo() {
		return repository.findTokyo();
	}

	/**
	 * 神奈川を表示する.
	 * 
	 * @return 神奈川
	 */
	public List<Article> findKanagawa() {
		return repository.findKanagawa();
	}

	/**
	 * 新潟を表示する.
	 * 
	 * @return 新潟
	 */
	public List<Article> findNigata() {
		return repository.findNigata();
	}

	/**
	 * 富山を表示する.
	 * 
	 * @return 富山
	 */
	public List<Article> findToyama() {
		return repository.findToyama();
	}

	/**
	 * 石川を表示する.
	 * 
	 * @return 石川
	 */
	public List<Article> findIshikawa() {
		return repository.findIshikawa();
	}

	/**
	 * 福井を表示する.
	 * 
	 * @return 福井
	 */
	public List<Article> findFukui() {
		return repository.findFukui();
	}

	/**
	 * 山梨を表示する.
	 * 
	 * @return 山梨
	 */
	public List<Article> findYamanashi() {
		return repository.findYamanashi();
	}

	/**
	 * 長野を表示する.
	 * 
	 * @return 長野
	 */
	public List<Article> findNagano() {
		return repository.findNagano();
	}

	/**
	 * 岐阜を表示する.
	 * 
	 * @return 岐阜
	 */
	public List<Article> findGihu() {
		return repository.findGihu();
	}

	/**
	 * 静岡を表示する.
	 * 
	 * @return 静岡
	 */
	public List<Article> findShizuoka() {
		return repository.findShizuoka();
	}

	/**
	 * 愛知を表示する.
	 * 
	 * @return 愛知
	 */
	public List<Article> findAichi() {
		return repository.findAichi();
	}

	/**
	 * 三重を表示する.
	 * 
	 * @return 三重
	 */
	public List<Article> findMie() {
		return repository.findMie();
	}

	/**
	 * 滋賀を表示する.
	 * 
	 * @return 滋賀
	 */
	public List<Article> findShiga() {
		return repository.findShiga();
	}

	/**
	 * 京都を表示する.
	 * 
	 * @return 京都
	 */
	public List<Article> findKyoto() {
		return repository.findKyoto();
	}

	/**
	 * 大阪を表示する.
	 * 
	 * @return 大阪
	 */
	public List<Article> findOsaka() {
		return repository.findOsaka();
	}

	/**
	 * 兵庫を表示する.
	 * 
	 * @return 兵庫
	 */
	public List<Article> findHyogo() {
		return repository.findHyogo();
	}

	/**
	 * 奈良を表示する.
	 * 
	 * @return 奈良
	 */
	public List<Article> findNara() {
		return repository.findNara();
	}

	/**
	 * 和歌山を表示する.
	 * 
	 * @return 和歌山
	 */
	public List<Article> findWakayama() {
		return repository.findWakayama();
	}

	/**
	 * 鳥取を表示する.
	 * 
	 * @return 鳥取
	 */
	public List<Article> findTottori() {
		return repository.findTottori();
	}

	/**
	 * 島根を表示する.
	 * 
	 * @return 島根
	 */
	public List<Article> findShimane() {
		return repository.findShimane();
	}

	/**
	 * 岡山を表示する.
	 * 
	 * @return 岡山
	 */
	public List<Article> findOkayama() {
		return repository.findOkayama();
	}

	/**
	 * 広島を表示する.
	 * 
	 * @return 広島
	 */
	public List<Article> findHiroshima() {
		return repository.findHiroshima();
	}

	/**
	 * 山口を表示する.
	 * 
	 * @return 山口
	 */
	public List<Article> findYamaguchi() {
		return repository.findYamaguchi();
	}

	/**
	 * 徳島を表示する.
	 * 
	 * @return 徳島
	 */
	public List<Article> findTokushima() {
		return repository.findTokushima();
	}

	/**
	 * 香川を表示する.
	 * 
	 * @return 香川
	 */
	public List<Article> findKagawa() {
		return repository.findKagawa();
	}

	/**
	 * 愛媛を表示する.
	 * 
	 * @return 愛媛
	 */
	public List<Article> findEhime() {
		return repository.findEhime();
	}

	/**
	 * 高知を表示する.
	 * 
	 * @return 高知
	 */
	public List<Article> findKochi() {
		return repository.findKochi();
	}

	/**
	 * 福岡を表示する.
	 * 
	 * @return 福岡
	 */
	public List<Article> findFukuoka() {
		return repository.findFukuoka();
	}

	/**
	 * 佐賀を表示する.
	 * 
	 * @return 佐賀
	 */
	public List<Article> findSaga() {
		return repository.findSaga();
	}

	/**
	 * 長崎を表示する.
	 * 
	 * @return 長崎
	 */
	public List<Article> findNagasaki() {
		return repository.findNagasaki();
	}

	/**
	 * 熊本を表示する.
	 * 
	 * @return 熊本
	 */
	public List<Article> findKumamoto() {
		return repository.findKumamoto();
	}

	/**
	 * 大分を表示する.
	 * 
	 * @return 大分
	 */
	public List<Article> findOita() {
		return repository.findOita();
	}

	/**
	 * 宮崎を表示する.
	 * 
	 * @return 宮崎
	 */
	public List<Article> findMiyazaki() {
		return repository.findMiyazaki();
	}

	/**
	 * 鹿児島を表示する.
	 * 
	 * @return 鹿児島
	 */
	public List<Article> findKagoshima() {
		return repository.findKagoshima();
	}

	/**
	 * 沖縄を表示する.
	 * 
	 * @return 沖縄
	 */
	public List<Article> findOkinawa() {
		return repository.findOkinawa();
	}
}
