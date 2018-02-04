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
		url: 'user/now/totals',
		async: true,
		success: function(data) {
			$('#users strong').html(data.data.totals);
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
		url: 'user/everyday/totals',
		async: true,
		success: function(data) {
			var obj = data.data;
			for (var i = 0; i < obj.length; i++) {
				result += 
					'<tr class="text-c">' +
						'<td><input type="checkbox" value="" name=""></td>' +
						'<td>'+obj[i].id+'</td>'+
						'<td class="text-l">'+obj[i].number+'</td>' +
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

// 注册用户统计页面，刷新按钮处理
$('#refresh').click(function() {
	var myDate = new Date();
	var year = myDate.getFullYear();
	var month = myDate.getMonth() + 1;
	var date = myDate.getDate();
	// yyyy-mm-dd
	var formatDate = year + "-" + (month < 10 ? "0" + month : month) + "-" + (date < 10 ? "0" + date : date);
    var  obj =  {
        "date": formatDate
    };

    $.ajax({
        cache: false,
        type: "POST",
        dataType: "JSON",
        contentType : 'application/json',
        data: JSON.stringify(obj),
        url: 'user/insert',
        async: true,
        success: function(data) {
            refresh();
        },
        error : function() {
            window.location.href = "404.html";
        }

    });

});



