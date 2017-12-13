app.config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {

        // Use $urlRouterProvider to configure any redirects (when) and
        // invalid urls (otherwise).
        $urlRouterProvider.when('/principal', '/')
                .when('index.jsp', '/').otherwise('/');

        $stateProvider

                .state("erro", {
                    url: "/erro",
                    templateUrl: 'app/view/erros/erro.html'
                }).state("erro.404", {
            url: "/404",
            templateUrl: 'app/view/erros/404.html'
        }).state("erro.403", {
            url: "/403",
            templateUrl: 'app/view/erros/403.html'
        })

                .state("restricted", {
                    abstract: true,
                    url: "",
                    views: {
                        'main_header': {
                            templateUrl: 'app/view/templates/header.html',
                            controller: 'ctrl_header'
                        },
                        'main_sidebar': {
                            templateUrl: 'app/view/templates/menu.html',
                            controller: 'ctrl_menu'
                        },
                        '': {
                            templateUrl: 'app/view/restricted.html'
                        }
                    }
                })

                .state("restricted.principal", {
                    url: "/",
                    templateUrl: 'app/view/principal.html',
                    controller: 'ctrl_principal',
                    data: {
                        pageTitle: 'Dashboard'
                    }
                })

                .state("restricted.cadastro", {
                    url: "/cadastro",
                    templateUrl: 'app/view/cadastro/cadastro.html',
                    controller: 'ctrl_cadastro',
                    data: {
                        pageTitle: 'Cadastro'
                    }
                })
                .state("restricted.cadastro.especialidade", {
                    url: "/tweet",
                    templateUrl: 'app/view/cadastro/especialidade.html',
                    controller: 'ctrl_tweet',
                    data: {
                        pageTitle: 'Tweet'
                    }
                })

    }]);
