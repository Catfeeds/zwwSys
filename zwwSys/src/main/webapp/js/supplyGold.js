/**
 * 
 */

// var baseUrl = "http://47.96.130.239:8081/zwwSys";

$(document).ready(function() {
	supplyGold();
});


function supplyGold() {
	
	var  obj;
	
	$('#supplyBtn').click(function() {
		var userId = $('#id').val();
		var gold = $('#gold').val();
		
		$('.fl input[name="nickname"]').val(userId);
		$('.fl input[name="phone"]').val(gold);
		
		obj =  {
				 "userId": userId,
			     "gold": gold
			};
	});
	
	$('.submitBtn').click(function() {
		
		if (obj.userId.replace(/(^s*)|(s*$)/g, "").length ==0 ||
				obj.gold.replace(/(^s*)|(s*$)/g, "").length ==0) { 
			$.tooltip('数据不能为空, 出错啦！！！'); 
		} 
		
		$.ajax({
			cache: false,
			type: "POST",
			dataType: "JSON",
			data: JSON.stringify(obj),
			contentType : 'application/json',
			url: 'supply/gold/modify',
			async: true,
			success: function(data) {
				if (data.data > 0) {
					window.location.href = "supplyGold.html";
				}else {
					$.tooltip('参数出错啦！！！');
				}
			},
			error : function() {
				window.location.href = "404.html";
			}
		});
	});
};


