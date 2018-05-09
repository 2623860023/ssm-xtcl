<%--
  Created by IntelliJ IDEA.
  User: zlh
  Date: 2018/4/30
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="<%=request.getContextPath()%>/code/highcharts.js"></script>
<script src="<%=request.getContextPath()%>/code/modules/data.js"></script>
<script src="<%=request.getContextPath()%>/code/modules/drilldown.js"></script>
<div id="container2" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script>
    $(function(){
        $.ajax({
            url:"<%=request.getContextPath()%>/roleController/queryCountTree.do",
            dataType:"json",
            type:"post",
            success:function(res) {
                Highcharts.chart('container2', {
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
                        data:res,/*[{
                         name: 'admin',
                         y: 33,

                         }, {
                         name: 'guest',
                         y: 33,

                         }, {
                         name: 'superGuest',
                         y: 33,
                         }]*/
                    }]/*,
                     drilldown: {
                     series: [{
                     name: 'Microsoft Internet Explorer',
                     id: 'Microsoft Internet Explorer',
                     data: [
                     [
                     'v11.0',
                     24.13
                     ],
                     [
                     'v8.0',
                     17.2
                     ],
                     [
                     'v9.0',
                     8.11
                     ],
                     [
                     'v10.0',
                     5.33
                     ],
                     [
                     'v6.0',
                     1.06
                     ],
                     [
                     'v7.0',
                     0.5
                     ]
                     ]
                     }, {
                     name: 'Chrome',
                     id: 'Chrome',
                     data: [
                     [
                     'v40.0',
                     5
                     ],
                     [
                     'v41.0',
                     4.32
                     ],
                     [
                     'v42.0',
                     3.68
                     ],
                     [
                     'v39.0',
                     2.96
                     ],
                     [
                     'v36.0',
                     2.53
                     ],
                     [
                     'v43.0',
                     1.45
                     ],
                     [
                     'v31.0',
                     1.24
                     ],
                     [
                     'v35.0',
                     0.85
                     ],
                     [
                     'v38.0',
                     0.6
                     ],
                     [
                     'v32.0',
                     0.55
                     ],
                     [
                     'v37.0',
                     0.38
                     ],
                     [
                     'v33.0',
                     0.19
                     ],
                     [
                     'v34.0',
                     0.14
                     ],
                     [
                     'v30.0',
                     0.14
                     ]
                     ]
                     }, {
                     name: 'Firefox',
                     id: 'Firefox',
                     data: [
                     [
                     'v35',
                     2.76
                     ],
                     [
                     'v36',
                     2.32
                     ],
                     [
                     'v37',
                     2.31
                     ],
                     [
                     'v34',
                     1.27
                     ],
                     [
                     'v38',
                     1.02
                     ],
                     [
                     'v31',
                     0.33
                     ],
                     [
                     'v33',
                     0.22
                     ],
                     [
                     'v32',
                     0.15
                     ]
                     ]
                     }, {
                     name: 'Safari',
                     id: 'Safari',
                     data: [
                     [
                     'v8.0',
                     2.56
                     ],
                     [
                     'v7.1',
                     0.77
                     ],
                     [
                     'v5.1',
                     0.42
                     ],
                     [
                     'v5.0',
                     0.3
                     ],
                     [
                     'v6.1',
                     0.29
                     ],
                     [
                     'v7.0',
                     0.26
                     ],
                     [
                     'v6.2',
                     0.17
                     ]
                     ]
                     }, {
                     name: 'Opera',
                     id: 'Opera',
                     data: [
                     [
                     'v12.x',
                     0.34
                     ],
                     [
                     'v28',
                     0.24
                     ],
                     [
                     'v27',
                     0.17
                     ],
                     [
                     'v29',
                     0.16
                     ]
                     ]
                     }]*/
                    /*}*/
                });
            }
        })
    })

</script>
</body>
</html>
