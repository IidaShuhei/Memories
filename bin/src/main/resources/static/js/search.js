/**
 * 
 *チェックボックスの変更に合わせて入力フォームも変更する
 */

$(function() {
	$("#name").hide();
	$("#content").hide();
	
	$("#find").on("change", function() {

		if ($("#find").val() == "title") {
			$("#title").show();
			$("#name").hide();
			$("#content").hide();
		} else if ($("#find").val() == "name") {
			$("#title").hide();
			$("#name").show();
			$("#content").hide();
		} else if ($("#find").val() == "content") {
			$("#title").hide();
			$("#name").hide();
			$("#content").show();
		}

	});

});