/**
 * 登录
 */


$('#loginBtn').click(function() {
	var  obj =  {
			 "account": $('#account').val(),
		     "password": $('#password').val()
		};
	
	$.ajax({
		cache: false,
		type: "POST",
		dataType: "JSON",
		contentType : 'application/json',
		data: JSON.stringify(obj),
		url: 'admin/login',
		async: true,
		success: function(data) {
			window.location.href = "index_2.html";
		},
		error : function() {
			window.location.href = "404.html";
		}

	});
	
});

