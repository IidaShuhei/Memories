/**
 * 
 */

$(function(){
    jQuery("#form").validationEngine();
  });

$('#email').blur(function(){
	var email = $('#email').val();
	if(email != ""){
		if(email.match(/^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/)){
			$.ajax({
				type:'POST',
				url:'/judge',
				data: { email : $('#email').val() },
				dataType : 'json'
					
				//失敗
			}).done(function(data){
					if(data.email != null){
						$("#err").html('<span style="color:red" id="err1">メールアドレスが重複しています</span>');
						$("#register").prop("disabled",true);
				//成功
					} else if(data.email == null){
						$("#register").prop("disabled",false);
						$("#err1").remove();
						$("#err2").remove();
					}
				})
		} else {
			$("#err").html('<span style="color:red" id="err2">メールアドレスの形式が異なります</span>');
			}
	}
			
});