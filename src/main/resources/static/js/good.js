/**
 * 
 */
//いいねボタン
$("#good").on('click',function(){
	var good = $('#good').val();
	if(good == null){
		good = 1;
	} else {
		good += + 1;
	}
	console.log("1 : " + good);
	
	$.ajax({
		type:'POST',
		url:'/good',
		data: { good : good },
		dataType : 'json'
	}).done(function(data) {
		
		console.log("2 : " + data)
		
		alert('success');
	})
});