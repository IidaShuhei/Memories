/**
 * 
 */

// 記事投稿のタイトル
$(function() {
	// 初期状態での文字数取得・表示
	var txt = $('input#input_text').val(), new_txt = $.trim(txt.replace(/\n/g,
			"")), couter = new_txt.length;
	$('.count_num').html("現在" + couter + "文字");
	// 入力時の文字数取得・表示、アラート表示
	$('input#input_text').bind(
			'keydown keyup keypress change',
			function() {
				var txt = $(this).val(), new_txt = $.trim(txt
						.replace(/\n/g, "")), couter = new_txt.length;
				$('.count_num').html("現在" + couter + "文字");
				if (couter > 25) {
					$('.count_alert').html("25文字を超えています");
				} else {
					$('.count_alert').html("");
				}
			});
});

$(function() {
    $('.side').hover(
    function(){
      $(this).animate({'marginRight':'140px'},500);
    },
    function () {
      $(this).animate({'marginRight':'0'},500);
    }
  );
});

//▼①ファイル選択フォームの更新イベントに処理を追加
$(function() {

	document.getElementById("filesend").addEventListener('change',
			function(e) {
				var files = e.target.files;
				previewUserFiles(files);
			});
	// ▼②選択画像をプレビュー
	 function previewUserFiles(files) {
		// 一旦リセットする
		resetPreview();
		// 選択中のファイル1つ1つを対象に処理する
		for (var i = 0; i < files.length; i++) {
			// i番目のファイル情報を得る
			var file = files[i];
			// 選択中のファイルが画像かどうかを判断
			if (file.type.indexOf("image") < 0) {
				/* 画像以外なら無視 */
				continue;
			}
			// ファイル選択ボタンのラベルに選択個数を表示
			document.getElementById("selectednum").innerHTML = (i + 1)
					+ "個選択中";
			// 画像プレビュー用のimg要素を動的に生成する
			var img = document.createElement("img");
			img.classList.add("previewImage");
			img.file = file;
			img.height = 80; // プレビュー画像の高さ
			// 生成したimg要素を、プレビュー領域の要素に追加する
			document.getElementById('previewbox').appendChild(img);
			// 画像をFileReaderで非同期に読み込み、先のimg要素に紐付けする
			var reader = new FileReader();
			reader.onload = (function(tImg) {
				return function(e) {
					tImg.src = e.target.result;
				};
			})(img);
			reader.readAsDataURL(file);
		}
	}
	// ▼③プレビュー領域をリセット
	function resetPreview() {
		// プレビュー領域に含まれる要素のすべての子要素を削除する
		var element = document.getElementById("previewbox");
		while (element.firstChild) {
			element.removeChild(element.firstChild);
		}
		// ファイル選択ボタンのラベルをデフォルト状態に戻す
		document.getElementById("selectednum").innerHTML = "選択";
	}
});

//スクロール
