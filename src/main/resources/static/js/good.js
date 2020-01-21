/**
 * 
 */
//いいねボタン
$("#articleId").on('click',function(){
	var articleId = $('#articleId').val();;
	var userId = $('#userId').val();
	
	console("記事ID : " + aricleId);
	console("ユーザーID : " + userId);
	
	$.ajax({
		type:'POST',
		url:'/good',
		data: { articleId : articleId , userId : userId },
		dataType : 'json'
	}).done(function(data) {
		alert("成功です");
	})
});