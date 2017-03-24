app.controller('Financeiro', ['$scope', '$route', 'init',
    function ($scope, $route, init) {
        init();
    }
]);

function initFinanceiro() {
    console.log("initFinanceiro");
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Year', 'Rendimentos', 'Despesas'],
            ['2004', 1000, 400],
            ['2005', 1170, 460],
            ['2006', 660, 1120],
            ['2007', 1030, 540]
        ]);

        var options = {
            title: 'Gastos da clínica',
            curveType: 'function',
            legend: {position: 'bottom'}
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
    }
    $(window).resize(function () {
        drawChart();
    });
}