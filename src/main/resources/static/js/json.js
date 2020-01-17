/**
 * 
 */
jQuery(document).ready(function(){
   jQuery('#form').validationEngine();
});

$('#inputEmail').blur(function(){
	var inputEmail = $('#inputEmail').val();
	//メールが入力されたら重複チェック開始
	if(inputEmail != ""){
		if(inputEmail.match(/^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/)){
			$.ajax({
				type:'POST',
				url:'/judge',
				date: { email : inputEmail },
				dateType : 'json'
				//失敗
			}).done(function(date){
				console.log(date);
					if(date != null){
						$("#err").html('<span style="color:red">メールアドレスが重複しています</span>');
				//成功
					} else if(date == null){
						
						$('#form').submit();
					}
				});
			
		} else {
			$("#err").html('<span style="color:red">メールの形式が異なります</span>');
		}
	}
	
	
});