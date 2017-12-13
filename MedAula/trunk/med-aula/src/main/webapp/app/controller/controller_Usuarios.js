app.controller('ctrl_usuarios', function ($scope, $rootScope, $compile, $timeout, usuarios, perfis, $interval, genericService,
        DTOptionsBuilder, DTColumnDefBuilder, dataTableLanguageService, commonsService, usuarioService) {

    var ng = $scope;

    $rootScope.page_full_height = true;
    $rootScope.headerDoubleHeightActive = true;

    ng.showForm = false;
    $formValidate = null;

    ng.dtColumnDefs = [
        DTColumnDefBuilder.newColumnDef(3).notSortable()
    ];
    ng.dtInstance = {};

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
    ng.service = new genericService("usuario");

    ng.listUsuarios = usuarios;
    ng.listPerfis = perfis;

    ng.novo = function () {
        ng.usuario = {};
        ng.showForm = true;
    };
    ng.perfisConfig = {
        maxItems: 1,
        placeholder: 'Selecione o Perfil',
        valueField: 'id',
        labelField: 'nome',
        searchField: 'nome'
    };

    ng.getUsuarios = function () {
        ng.service.getAll(function (response) {
            ng.listUsuarios = response;
        });
    };

    ng.salvar = function () {

        if ($formValidate.parsley().validate()) {
            usuarioService.validaEmail(ng.usuario.id, ng.usuario.email, function (response) {
                if (response.valido == "true") {
                    ng.service.salvar(ng.usuario, function (response) {
                        UIkit.modal("#modalCadastroUsuario").hide();
                        ng.showForm = false;
                        ng.getUsuarios();
                        ng.sucesso(LABEL_SUCESSO, MSG_REGISTRO_SALVO_SUCESSO);

                    }, function () {

                    });
                } else {
                    ng.alerta(LABEL_ERRO, "E-mail já cadastrado");
                }
            });
        } else {
            ng.alerta(LABEL_ATENCAO, MSG_VERIFIQUE_CAMPOS_OBRIGATORIOS);
        }
    };

    ng.editar = function (id) {
        ng.showForm = true;
        ng.service.get(id, function (response) {
            ng.usuario = response;
        });
    };

    ng.remover = function (id) {
        ng.confirmacao(MSG_CONFIRMACAO_EXCLUSAO,
                function () {
                    ng.service.remover(id, function (response) {
                        ng.sucesso(LABEL_SUCESSO, response.msg);
                        ng.getUsuarios();
                    }, function (response) {
                        ng.erro(LABEL_ERRO, response.msg);
                    });
                }
        );
    };

    ng.inicializaForm = function () {

        $formValidate = $('#form_usuario');

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
});