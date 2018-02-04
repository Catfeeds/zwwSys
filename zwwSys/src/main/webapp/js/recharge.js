/**
 * 
 */
$(document).ready(function() {
	refresh();
});
 
// var baseUrl = "http://47.96.130.239:8081/zwwSys";

function refresh() {
	
	$.ajax({
		cache: false,
		type: "POST",
		dataType: "JSON",
		contentType : 'application/json',
		url: 'pay/now/totals',
		async: true,
		success: function(data) {
			$('#recharges strong').html(data.data.totals);
		},
		error : function() {
			window.location.href = "404.html";
		}

	});
	
	
	var result = "";

	$.ajax({
		cache: false,
		type: "POST",
		dataType: "JSON",
		contentType : 'application/json',
		url: 'pay/everyday/totals',
		async: true,
		success: function(data) {
			var obj = data.data;
			
			for (var i = 0; i < obj.length; i++) {
				result += 
					'<tr class="text-c">' +
						'<td><input type="checkbox" value="" name=""></td>' +
						'<td>'+obj[i].id+'</td>'+
						'<td class="text-l">'+obj[i].amount+'</td>' +
						'<td>'+obj[i].date+'</td>' +
					'</tr>'
			}
			$('#dataTotals strong').html(obj.length);
			$('.table-responsive tbody').html(result);
			
		},
		error : function() {
			window.location.href = "404.html";
		}

	});
};



