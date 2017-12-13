app.controller('ctrl_tweet', function ($scope, $rootScope, $compile, $timeout, $interval, genericService,
        DTOptionsBuilder, DTColumnDefBuilder, dataTableLanguageService, commonsService, Upload) {

    var ng = $scope;

    $rootScope.page_full_height = true;
    $rootScope.headerDoubleHeightActive = true;

    ng.activeTabIndex = 0;
    ng.showForm = false;
    $formValidate = null;
    ng.showData = true;
    ng.dtColumnDefs = [
        DTColumnDefBuilder.newColumnDef(2).notSortable()
    ];
    ng.dtInstance = {};
    ng.service = new genericService("tweet");
    ng.init = function () {
        ng.getTweet();
    };
//  PARA VOTO

    ng.voto = function (tweet, votar) {

        var usuarioLogado = {};
        commonsService.getUsuarioLoado(function (retorno) {
            usuarioLogado = retorno;
            var voto = {
                usuario: {id: usuarioLogado.id},
                tweet: {id:tweet.id},
                crime: (votar ? 1 : 0),
                naocrime: (!votar ? 1 : 0),
                flag: 1
            };
            var callback = function (data) {
                console.log(data);
            };
            var callbackErro = function (erro) {
                console.log(erro);
            };
            ng.serviceVoto = new genericService("voto");
            ng.serviceVoto.salvar(voto, callback, callbackErro);
        });

    };
//    FIM VOTO
    ng.visualizar = function (index) {
        ng.listaT = ng.lista[index];
        ng.showData = false;
        console.log(ng.listaT);
    };
    ng.dtOptions = DTOptionsBuilder
            .newOptions()
            .withPaginationType('full_numbers')
            .withOption('initComplete', function () {
                $timeout(function () {

                    // md inputs
                    $compile($('.dt-uikit .md-input'))($scope);
                });
            }).withLanguage(
            dataTableLanguageService.portugues()
            );

    ng.lista = [];

    ng.novo = function () {
        ng.unidade = {
        };
        ng.showForm = true;
    };

    ng.getTweet = function () {
        ng.service.getAll(function (response) {
            ng.lista = response;
        });
    };

    ng.salvar = function () {
        if ($formValidate.parsley().validate()) {
            if (ng.unidade.cnpj) {
                ng.padronizaDateTime();
                ng.service.salvar(ng.unidade, function (response) {
                    UIkit.modal("#modalCadastroUnidade").hide();
                    ng.showForm = false;
                    ng.getTweet();
                    ng.sucesso(LABEL_SUCESSO, MSG_REGISTRO_SALVO_SUCESSO);

                }, function () {

                });
            } else {
                ng.prepareDataToErr(dateTime);
                ng.alerta(LABEL_ATENCAO, "Tweet Inválido");
            }

        }
    };
    ng.cancelar = function () {
        ng.showForm = false;
    };

    ng.inicializaForm = function () {
        $formValidate = $('#form_unidade');
        $formValidate
                .parsley()
                .on('form:validated', function () {
                    if (!$scope.$$phase) {
                        $scope.$apply();
                    }
                })
                .on('field:validated', function (parsleyField) {
                    if ($(parsleyField.$element).hasClass('md-input')) {

                        if (!$scope.$$phase) {
                            $scope.$apply();
                        }
                    }
                });
    };

    ng.init();
});