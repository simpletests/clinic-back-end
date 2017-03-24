var app = angular.module('myApp', ['ngRoute'])
        .config(['$routeProvider',
            function ($routeProvider) {
                $routeProvider
                        .when('/dashboard', {
                            controller: 'Dashboard',
                            templateUrl: 'dashboard.html',
                            resolve: {
                                init: function () {
                                    return initDashboard;
                                }
                            }
                        })
                        .when("/agenda", {
                            controller: "Agenda",
                            templateUrl: "agenda.html",
                            resolve: {
                                init: function () {
                                    return initAgenda;
                                }
                            }
                        })
                        .when("/financeiro", {
                            controller: "Dashboard",
                            templateUrl: "financeiro.html",
                            resolve: {
                                init: function () {
                                    return initFinanceiro;
                                }
                            }
                        })
                        .when("/pacienteList", {
                            controller: "Paciente",
                            templateUrl: "pacienteList.html",
                            resolve: {
                                init: function () {
                                    return initPacienteList;
                                }
                            }
                        })
                        .when("/pacienteForm", {
                            controller: "Paciente",
                            templateUrl: "pacienteForm.html",
                            resolve: {
                                init: function () {
                                    return initPacienteForm;
                                }
                            }
                        })
                        .when("/relatorios", {
                            controller: "Relatorio",
                            templateUrl: "relatorios.html",
                            resolve: {
                                init: function () {
                                    return initRelatorio;
                                }
                            }
                        });
            }
        ]);


