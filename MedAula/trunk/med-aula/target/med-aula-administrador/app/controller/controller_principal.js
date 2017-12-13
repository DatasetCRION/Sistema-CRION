app.controller('ctrl_principal', function($scope,$rootScope,$timeout,$interval, genericService){
	
	var ng = $scope;
	
        Highcharts.chart('totalbanco', {
    chart: {
        type: 'bar'
    },
    title: {
        text: 'Base de teste'
    },
    subtitle: {
        text: 'Source: <a href="textAutor">Dados CRION</a>'
    },
    xAxis: {
        categories: ['Tweets'],
        title: {
            text: null
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Quantidade',
            align: 'high'
        },
        labels: {
            overflow: 'justify'
        }
    },
    tooltip: {
        valueSuffix: ''
    },
    plotOptions: {
        bar: {
            dataLabels: {
                enabled: true
            }
        }
    },
    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'top',
        x: -40,
        y: 80,
        floating: true,
        borderWidth: 1,
        backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
        shadow: true
    },
    credits: {
        enabled: false
    },
    series: [{
        name: 'Fácil',
        data: [8672]
    },{
        name: 'Média',
        data: [2128]
    }, {
        name: 'Difícil',
        data: [4192]
    }, {
        name: 'Total',
        data: [20000]
    }]
});


Highcharts.chart('cidades', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Números de crimes por cidade'
    },
    subtitle: {
        text: 'Source: <a href="cidades">Dataset Crion</a>'
    },
    xAxis: {
        type: 'category',
        labels: {
            rotation: -45,
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Quantidade'
        }
    },
    legend: {
        enabled: false
    },
    tooltip: {
        pointFormat: 'Quantidade de crime: <b>{point.y:.1f}</b>'
    },
    series: [{
        name: 'Population',
        data: [
            ['Belo Horizonte', 23],
            ['São Paulo', 10],
            ['Rio de Janeiro', 14.2],
            ['Vitória', 11.1],
            ['Goiana', 10.5],
            ['Distrito Federal', 10.4],
            ['Cuiaba', 10.0],
            ['Campo Grande', 9.3],
            ['Porto Alegre', 9.3],
            ['Florianópolis', 16],
            ['Curitiba', 15],
            ['Salvador', 14],
            ['Recife', 13],
            ['Natal', 12],
            ['Fortaleza', 11],
            ['Aracaju', 10],
            ['João Pessoa', 10.4],
            ['Rio Branco', 10.0],
            ['Maceió', 9.3],
            ['Macapá', 9.3],
            ['Manaus', 16],
            ['São Luís', 15],
            ['Belém', 14],
            ['Teresina', 13],
            ['Porto Velho', 11],
            ['Boa Vista', 12],
            ['Palmas', 10]
        ],
        dataLabels: {
            enabled: true,
            rotation: -90,
            color: '#FFFFFF',
            align: 'right',
            format: '{point.y:.1f}', // one decimal
            y: 10, // 10 pixels down from the top
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    }]
});

 
 Highcharts.chart('classificacaoCrime', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: 'Tipos de crime'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.y:.1f}',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            }
        }
    },
    series: [{
        name: 'Brands',
        colorByPoint: true,
        data: [{
            name: 'Furto',
            y: 528
        }, {
            name: 'Roubo',
            y: 323
        }, {
            name: 'Assalto',
            y: 724,
            sliced: true,
            selected: true
        }, {
            name: 'Calúnia',
            y: 40
        }, {
            name: 'Preconceito',
            y: 432
        }, {
            name: 'Apologia ao Crime',
            y: 58
        }, {
            name: 'Pedofilia',
            y: 23
        }]
    }]
});
 
Highcharts.chart('qtdcrime', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: 0,
        plotShadow: false
    },
    title: {
        text: 'Quantidade<br>Crime',
        align: 'center',
        verticalAlign: 'middle',
        y: 40
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.y:.1f}</b>'
    },
    plotOptions: {
        pie: {
            dataLabels: {
                enabled: true,
                distance: -50,
                style: {
                    fontWeight: 'bold',
                    color: 'white'
                }
            },
            startAngle: -90,
            endAngle: 90,
            center: ['50%', '75%']
        }
    },
    series: [{
        type: 'pie',
        name: 'Quantidade',
        innerSize: '50%',
        data: [
            ['Crime',2128],
            ['Não Crime',6544],
            {
                name: 'Proprietary or Undetectable',
                y: 0.2,
                dataLabels: {
                    enabled: false
                }
            }
        ]
    }]
}); 
 
});