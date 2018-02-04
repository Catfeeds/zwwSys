/**
 * 
 */

// var baseUrl = "http://localhost:8080/zwwSys";

$(document).ready(function() {
	supplyAward();
});

function supplyAward() {
	
	var  obj;
	
	$('.dialog').hDialog({box: '#HBox'});

	$('.slide').hDialog({
		title: '请确认补发',
		height: 300, 
		width: 480,
		isOverlay: true
		});
	
	var result;

	$.ajax({
		cache: false,
		type: "POST",
		dataType: "JSON",
		contentType : 'application/json',
		url: 'supply/prize/show',
		async: true,
		success: function(data) {
			var prizes = data.data;
			for (var i = 0; i < prizes.length; i++) {
				result +=
					'<option value=' + prizes[i].machineId +'>' +
						'<ul class="chouseData">' +
						'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
						'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
						'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
							'&nbsp;&nbsp;&nbsp;&nbsp;<li>' + prizes[i].machineId +'</li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
							'&nbsp;&nbsp;&nbsp;&nbsp;<li>' + prizes[i].prizeName + '</li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
							'&nbsp;&nbsp;&nbsp;&nbsp;<li>' + prizes[i].consume + '</li>&nbsp;&nbsp;&nbsp;&nbsp;' +
							'&nbsp;&nbsp;&nbsp;&nbsp;<li>' + prizes[i].exchange + '</li>'
						'</ul>' +
					'</option>'
			}
			$('#macs').append(result);
		},
		error : function() {
			window.location.href = "404.html";
		}
	});
	
	$('#macs').change(function() {
		$('#gold').val($(this).val());
	});
	
	$('#supplyBtn').click(function() {
		var userId = $('#id').val();
		var machineId = $('#gold').val();
		
		$('.fl input[name="nickname"]').val(userId);
		$('.fl input[name="phone"]').val(machineId);
		
		obj =  {
				 "userId": userId,
			     "machineId": machineId
			};
	});
	
	$('.submitBtn').click(function() {
		
		if (obj.userId.replace(/(^s*)|(s*$)/g, "").length ==0 ||
				obj.machineId.replace(/(^s*)|(s*$)/g, "").length ==0) { 
			$.tooltip('数据不能为空, 出错啦！！！'); 
		} 
		
		$.ajax({
			cache: false,
			type: "POST",
			dataType: "JSON",
			data: JSON.stringify(obj),
			contentType : 'application/json',
			url: 'supply/award/modify',
			async: true,
			success: function(data) {
				if (data.data > 0) {
					window.location.href = "supplyAward.html";
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







