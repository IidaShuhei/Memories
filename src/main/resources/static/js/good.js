/**
 * 
 */
//いいねボタン
$("#id").on('click',function(){
	var good = 1;
	var id = $('#id').val();
	
	$.ajax({
		type:'POST',
		url:'/good',
		data: { good : good , id : id },
		dataType : 'json'
	}).done(function(data) {
		$("#good").empty();
		$("#good").append("<span>"+data.good+"</span>");
	})
});