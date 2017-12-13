app.service('commonsService', function($http){

	this.getUsuarioLoado = function(callback){
		$http.get('rest/commons/usuario').success(function(usuario){
			if(callback)
				callback(usuario);
		});
	};

	
	this.getModulos = function(callback){
		$http.get('rest/commons/modulos').success(function(modulos){
			if(callback)
				callback(modulos);
		});
	};
	
	
	this.getEnderecoByCep =function(cep, callback)  {
		 
		 $.getJSON("//viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {
             if (!("erro" in dados)) {
            	 callback(dados);
             } 
             else {
            	 callback(false);
             }
         });
	};
	
	this.getEstados = function(callback){
		$http.get('rest/commons/estados').success(function(modulos){
			if(callback)
				callback(modulos);
		});
	};
	
	this.getCidades = function(uf, callback){
		$http.get('rest/commons/cidades/' +uf).success(function(modulos){
			if(callback)
				callback(modulos);
		});
	};
	
});