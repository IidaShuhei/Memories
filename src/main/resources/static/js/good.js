/**
 * 
 */
//いいねボタン
$("#article").on('click',function(){
	var articleId = $('#article').val();;
	var userId = $('#user').val();
	
	console.log("記事ID : " + articleId);
	console.log("ユーザーID : " + userId);
	
	$.ajax({
		type:'POST',
		url:'/good',
		data: { id : articleId , userId : userId },
		dataType : 'json'
	}).done(function(data) {
	})
});