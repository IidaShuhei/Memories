/**
 * 
 */
// いいねボタン
$("#article").on('click', function() {
	var articleId = $('#article').val();
	var userId = $('#user').val();
	
	console.log("ユーザー : " + userId)
	console.log(articleId)
	
	$.ajax({
		type : 'POST',
		url : '/good',
		data : {
			id : articleId,
			userId : userId
		},
		dataType : 'json'
	}).done(function(data) {
		var id = $('#article').val();
		$.ajax({
			type : 'POST',
			url : '/countGood',
			data : {
				articleId : id
			},
			dataType : 'json'
		}).done(function(data) {
			$("#textGood").html("<span>" + data + "</span>");
		})
	})
});
