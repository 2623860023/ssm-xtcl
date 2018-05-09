<%--
  Created by IntelliJ IDEA.
  User: zlh
  Date: 2018/4/30
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>highcharts</title>
</head>
<body>
<script src="<%=request.getContextPath()%>/code/highcharts.js"></script>
<script src="<%=request.getContextPath()%>/code/modules/data.js"></script>
<script src="<%=request.getContextPath()%>/code/modules/drilldown.js"></script>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script>
    $(function(){
        $.ajax({
            url:"<%=request.getContextPath()%>/roleController/queryCountRole.do",
            dataType:"json",
            type:"post",
            success:function(res) {
                Highcharts.chart('container', {
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Browser market shares. January, 2015 to May, 2015'
                    },
                    subtitle: {
                        text: 'Click the columns to view versions. Source: <a href="http://netmarketshare.com">netmarketshare.com</a>.'
                    },
                    xAxis: {
                        type: 'category'
                    },
                    yAxis: {
                        title: {
                            text: 'Total percent market share'
                        }

                    },
                    legend: {
                        enabled: false
                    },
                    plotOptions: {
                        series: {
                            borderWidth: 0,
                            dataLabels: {
                                enabled: true,
                                format: '{point.y:.1f}%'
                            }
                        }
                    },

                    tooltip: {
                        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
                    },

                    series: [{
                        name: 'Brands',
                        colorByPoint: true,
                        data:res,
                });
            }
        })
    })

</script>
</body>
</html>
