app.factory('Usuario', function(){
	
	var Usuario = function(){
        
		this.id = null;
    	this.nome = null;
    	this.email = null;
    	this.senha = null;
    	this.perfis = null;
    	this.confSenha = null;
    	this.novaSenha = null;
    }
    
    return Usuario;
});