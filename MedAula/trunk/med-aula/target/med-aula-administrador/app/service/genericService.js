app.service('genericService', function($http){
	
	var GenericService = function(pUrl){
		
		var url = "rest/"+pUrl;
		
		this.salvar = function(object,callback, callbackErro){
			$http.post(url, object).success(function(response){
				if(callback)
					callback(response);
			}).error(function(response){
				if(callbackErro)
					callbackErro(response);
			});
		};
		
		this.get = function(id,callback){
			$http.get(url+"/"+id).success(function(response){
				if(callback)
					callback(response);
			}).error(function(response){
				if(callback)
					callback(false);
			});;
		};
		
		
		this.getAll = function(callback){
			$http.get(url).success(function(response){
				if(callback)
					callback(response);
			}).error(function(response){
				if(callback)
					callback(false);
			});;
		};
		
		this.getAllReduzido = function(callback){
			$http.get(url+"/reduzido").success(function(response){
				if(callback)
					callback(response);
			}).error(function(response){
				if(callback)
					callback(false);
			});;
		};
		
		this.remover = function(id,callback, callbackError){
			$http.delete(url+"/"+id).success(function(response){
				if(callback)
					callback(response);
			}).error(function(response){
				if(callbackError)
					callback(response);
			});;
		};
        
    }
    
    return GenericService;
	
});