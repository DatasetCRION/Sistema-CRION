app.service('usuarioService', function($http, $window){
	
	var url = "rest/usuario/";
	
	
	this.validaEmail = function(id,cpf,callback){
		$http.get(url+"validaemail/"+cpf+"/"+(id ? id : 0)).success(function(response){
			if(callback)
				callback(response);
		}).error(function(response){
			if(callback)
				callback(false);
		});
	};
	
});