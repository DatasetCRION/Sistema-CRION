var app = angular.module(
		"app",
		[ 'ngRoute', 
		  'datatables', 
		  'ui-notification',
		  'ngSanitize', 
		  'ui.mask',
		  'ui.router',
		  'ngAnimate',
		  'blockUI',
		  'ngHttpStatus',
		  'kendo.directives',
		  'ui.mask',
		  'ngMask',
		  'selectize',
		  'idf.br-filters',
		  'datatables.tabletools',
		  'ui.calendar',
		  'NgSwitchery',
		  'angular-chartist',
		  'datePicker',
		  'icheck',
		  'truncate',
		  '720kb.tooltips',
		  'angular-peity',
		  'angular-img-cropper',
		  'tc.chartjs',
		  'ui.utils.masks',
                  'vTabs',
                  'angularFileUpload',
                  'ngFileUpload'
             
		  ]).config(
		function(NotificationProvider) {
			NotificationProvider.setOptions({
				delay : 10000,
				startTop : 5,
				startRight : 10,
				verticalSpacing : 20,
				horizontalSpacing : 20,
				positionX : 'center',
				positionY : 'top'
			});
		}).config(function(blockUIConfig) {
	  // Change the default overlay message
	  blockUIConfig.message = '';
	  // Change the default delay to 100ms before the blocking is visible
	  blockUIConfig.delay = 100;
});


app.constant('variables', {
    header__main_height: 48,
    easing_swiftOut: [ 0.4,0,0.2,1 ],
    bez_easing_swiftOut: $.bez([ 0.4,0,0.2,1 ])
});

app.run(function($rootScope, $state, $stateParams,$http,$window, $timeout, variables, blockUIConfig){
	
	
		blockUIConfig.requestFilter = function(config) {
			
			if( $rootScope.pageLoading)
				return false;
		};
	
	 $rootScope.$state = $state;
     $rootScope.$stateParams = $stateParams;

     $rootScope.$on('$stateChangeSuccess', function () {
         // scroll view to top
         $("html, body").animate({
             scrollTop: 0
         }, 200);

         $timeout(function() {
             $rootScope.pageLoading = false;
             $($window).resize();
         },300);

         $timeout(function() {
             $rootScope.pageLoaded = true;
             $rootScope.appInitialized = true;
         },600);

     });

     $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
         // main search
         $rootScope.mainSearchActive = false;
         // single card
         $rootScope.headerDoubleHeightActive = false;
         // top bar
         $rootScope.toBarActive = false;
         // page heading
         $rootScope.pageHeadingActive = false;
         // top menu
         $rootScope.topMenuActive = false;
         // full header
         $rootScope.fullHeaderActive = false;
         // full height
         $rootScope.page_full_height = false;
         // secondary sidebar
         $rootScope.sidebar_secondary = false;
         $rootScope.secondarySidebarHiddenLarge = false;

         if($($window).width() < 1220 ) {
             // hide primary sidebar
             $rootScope.primarySidebarActive = false;
             $rootScope.hide_content_sidebar = false;
         }
         if(!toParams.hasOwnProperty('hidePreloader')) {
             $rootScope.pageLoading = true;
             $rootScope.pageLoaded = false;
         }

     });

     // fastclick (eliminate the 300ms delay between a physical tap and the firing of a click event on mobile browsers)
     FastClick.attach(document.body);

     // modernizr
     $rootScope.Modernizr = Modernizr;

     // get window width
     var w = angular.element($window);
     $rootScope.largeScreen = w.width() >= 1220;

     w.on('resize', function() {
         return $rootScope.largeScreen = w.width() >= 1220;
     });

     // show/hide main menu on page load
     $rootScope.primarySidebarOpen = ($rootScope.largeScreen) ? true : false;

     $rootScope.pageLoading = true;
     
     moment.locale('pt-br')
	
});

const DEFAULT_TIME_FORMAT = "HH:mm:ss";
const DEFAULT_DATE_FORMAT = "DD/MM/YYYY";
const LABEL_SUCESSO ="Sucesso";
const LABEL_ERRO ="Erro";
const LABEL_ATENCAO ="Atenção";
const MSG_PREENCHIMENTO_OBRIGATORIO ="Preenchimento obrigatório";
const MSG_REGISTRO_SALVO_SUCESSO ="Registro salvo com sucesso";
const MSG_STATUS_ALTERADO_SUCESSO ="Status alterado com sucesso";
const MSG_CONFIRMACAO_APROVACAO_CADASTRO ="Confirma a aprovação do cadastro?";
const MSG_REGISTRO_SALVO_ERRO="Erro ao salvar registro";
const MSG_REGISTRO_EXCLUIDO_SUCESSO ="Registro excluído com sucesso";
const MSG_CONFIRMACAO_EXCLUSAO="Deseja realmente excluir este registro?";
const MSG_VERIFIQUE_CAMPOS_OBRIGATORIOS="Verifique os campos obrigatórios";
const MSG_NENHUM_REGISTRO_ENCONTRADO="Nenhum registro encontrado";
