app.controller('Agenda', ['$scope', '$route', 'init',
    function ($scope, $route, init) {
        init();
    }]);
function initAgenda() {
    console.log("initAgenda");
    $('#calendar').fullCalendar({
        locale: "pt-br",
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        defaultDate: '2014-06-12',
        defaultView: 'basicWeek',
        editable: true,
        events: [
            {
                title: 'Folga',
                start: '2014-06-01'
            },
            {
                title: 'Cirurgia',
                start: '2014-06-07',
                end: '2014-06-10'
            },
            {
                id: 999,
                title: 'Atendimento Unimed',
                start: '2014-06-09T16:00:00'
            },
            {
                id: 999,
                title: 'Atendimento particular',
                start: '2014-06-16T16:00:00'
            },
            {
                title: 'Meeting',
                start: '2014-06-12T10:30:00',
                end: '2014-06-12T12:30:00'
            },
            {
                title: 'Almoço',
                start: '2014-06-12T12:00:00'
            },
            {
                title: 'Birthday Party',
                start: '2014-06-13T07:00:00'
            },
            {
                title: 'Click for Google',
                url: 'http://google.com/',
                start: '2014-06-28'
            }
        ]
    });
}