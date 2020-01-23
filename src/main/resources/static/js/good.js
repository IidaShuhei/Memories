/**
 * 
 */
//いいねボタン
$("#articleId").on('click',function(){
	var articleId = $('#articleId').val();;
	var userId = $('#userId').val();
	
	console.log("記事ID : " + aricleId);
	console.log("ユーザーID : " + userId);
	
	$.ajax({
		type:'POST',
		url:'/good',
		data: { articleId : articleId , userId : userId },
		dataType : 'json'
	}).done(function(data) {
		alert("成功です");
	})
});