/**
 * 
 */
$(function(){
	$("#address").on("click",function(){	
		AjaxZip3.zip2addr('zipcode','','prefecture','city');
	});
});