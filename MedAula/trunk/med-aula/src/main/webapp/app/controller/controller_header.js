app.controller('ctrl_header', function($timeout,$scope,$window, commonsService,HttpCodes){
	
	$('#menu_top').children('[data-uk-dropdown]').on('show.uk.dropdown', function(){
         $timeout(function() {
             $($window).resize();
         },280)
     });
	 
	 var ng = $scope;
	 ng.usuario =  {} 
	 
	 
	 ng.alterarSenha = function(){
	    	if($formValidate.parsley().validate()){
	    		UIkit.modal("#modalAlterarSenha").hide()
	    		commonsService.alterarSenha(ng.usuario, function(response){
	    			
	    			if(response.status == HttpCodes.OK){
		   				ng.sucesso(LABEL_SUCESSO, response.msg);
		   			}else{
		   				ng.erro(LABEL_ERRO, response.msg);
		   			}
	    		});
	    	}
	  };
	  
	
});