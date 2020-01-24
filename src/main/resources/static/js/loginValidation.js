/**
 * 
 */
// Emailのバリデーション
$('#loginEmail').keyup(function(){
	var email = $('#loginEmail').val();
	
	if(email !=""){
		if(email.match(/^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/)){
			$.ajax({
				type:'POST',
				url:'/judge',
				data: { email :$('#loginEmail').val() } ,
				dataType : 'json'
				
			  // 成功
			}).done(function(data){
				    if(data.email != null){
				    	$("#login").prop("disabled",false);
				    	$("#err1").remove();
				    	$("#err2").remove();
			　// 失敗
				    }else if(data.email==null){
				    	$("#err").html('<span style="color:red" id="err1">メールアドレスが登録されていません</span>');
				    	$("#login").prop("disabled",true);
				    }
			})
		}else{
			$("#err").html('<span style="color:red" id="err2">メールアドレスの形式が異なります</span>');
		}        
	}
});

$('#loginPass').keyup(function(){
	var password = $('#loginPass').val();
if(password !=""){
	if(password.match(/^([a-zA-Z0-9]{8,})$/)){
        $.ajax({
        	type:'POST',
        	url:'/judgePass',
        	data: { password :$('#loginPass').val() },
        	dataType : 'json'
        		
        	// 成功
        		
        }).done(function(data){
        	if(data.email != null){
        		$("#login").prop("disabled",false);
        		$("#loginErr1").remove();
        		$("#loginErr2").remove();
        		
        	}else if(data.password == null){
        		$("#loginErr").html('<span style="color:red" id="loginErr1">パスワードが間違っています</span>');
        		$("#login").prop("disabled",true);
        	}
        })
	
       }else{
    	   $("#loginErr").html('<span style="color:red" id="loginErr2">パスワードが違います</span>');
       }
    }
});




