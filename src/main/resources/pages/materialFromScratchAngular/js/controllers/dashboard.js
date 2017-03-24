app.controller('Dashboard', ['$scope', '$route', 'init',
    function ($scope, $route, init) {
        init();
    }
]);
function initDashboard() {
    google.charts.load('current', {'packages': ['timeline']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
        var container = document.getElementById('timeline');
        var chart = new google.visualization.Timeline(container);
        var dataTable = new google.visualization.DataTable();
        dataTable.addColumn({type: 'string', id: 'President'});
        dataTable.addColumn({type: 'date', id: 'Start'});
        dataTable.addColumn({type: 'date', id: 'End'});
        dataTable.addRows([
            ['Dr. Carlos Silva Santos', new Date(2017, 3, 13, 14, 0), new Date(2017, 3, 13, 15, 0)],
            ['Dr. Carlos Silva Santos', new Date(2017, 3, 13, 17, 30), new Date(2017, 3, 13, 18, 0)],
            ['Dr. Paulo Silva Santos', new Date(2017, 3, 13, 15, 0), new Date(2017, 3, 13, 16, 0)],
            ['Dr. Paulo Silva Santos', new Date(2017, 3, 13, 13, 0), new Date(2017, 3, 13, 14, 0)],
            ['Dra. Silvia Silva Santos', new Date(2017, 3, 13, 16, 0), new Date(2017, 3, 13, 17, 30)]]);
        chart.draw(dataTable);
    }
    $(window).resize(function () {
        drawChart();
    });
}