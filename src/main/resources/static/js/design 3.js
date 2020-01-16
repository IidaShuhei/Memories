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