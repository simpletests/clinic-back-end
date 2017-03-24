app.controller('Paciente', ['$scope', '$route', 'init',
    function ($scope, $route, init) {
        init($scope);
    }]);

function initPacienteList($scope) {
    console.log("initPacienteList");
    $scope.pacientes = [{       //rest('getPacientes',10,10,'filtro');
            nome: "Tomas",
            email: "tomaslm@hotmail.com",
            rua: "Rua Prudente de Morais, 554 apto 74",
            sexo: "M",
            idade: 45
        }, {
            nome: "Carlos Da Silva Sauro",
            email: "carlos@hotmail.com",
            rua: "Avenida 7 de Setembro, 925 apto 51",
            sexo: "M",
            idade: 90
        }, {
            nome: "José da Silva Santos",
            email: "jose@hotmail.com",
            rua: "Rua Marcos Markarian, 565 apto 105",
            sexo: "M",
            idade: 22
        }];
}

function initPacienteForm($scope) {
    console.log("initPacienteForm");
}

function toggleSorting(obj) {
    var asc = 'mdl-data-table__header--sorted-ascending';
    var desc = 'mdl-data-table__header--sorted-descending';
    if (obj.hasClass(asc)) {
        obj.removeClass(asc);
        obj.addClass(desc);
    } else {
        obj.removeClass(desc);
        obj.addClass(asc);
    }
}