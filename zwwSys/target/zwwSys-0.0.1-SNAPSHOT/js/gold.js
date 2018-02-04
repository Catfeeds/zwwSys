/**
 * 
 */
// var baseUrl = "http://localhost:8080/zwwSys";

$(document).ready(function() {
	refresh();
});

var myChart = echarts.init(document.getElementById('mt-20'));

//过渡---------------------
myChart.showLoading({
    text: '正在努力的读取数据中...',    //loading话术
});

function refresh() {
	
	$.ajax({
		cache: false,
		type: "POST",
		dataType: "JSON",
		contentType : 'application/json',
		url: 'plat/gold/totals',
		async: true,
		success: function(data) {
			var obj = data.data;
			
			var option = {
				    title : {
				        text: '平台金币数据',
				        subtext: '',
				        x:'center'
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    legend: {
				        orient : 'vertical',
				        x : 'left',
				        data:['平台','红包']
				    },
				    toolbox: {
				        show : true,
				        feature : {
				            mark : {show: false},
				            dataView : {show: true, readOnly: true},
				            magicType : {
				                show: true, 
				                type: ['pie', 'funnel'],
				                option: {
				                    funnel: {
				                        x: '25%',
				                        width: '50%',
				                        funnelAlign: 'left',
				                        max: 1548
				                    }
				                }
				            },
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
				    calculable : true,
				    series : [
				        {
				            name:'金币来源',
				            type:'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            data:[obj[0], obj[1]]
				        }
				    ]
				};
			myChart.hideLoading();
			myChart.setOption(option);
			
		},
		error : function() {
			window.location.href = "404.html";
		}
	});
};












