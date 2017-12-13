app.factory('Voto', function(){
	
	var Voto = function(){
        
        this.idvoto = null;
    	this.id_usuario = null;
    	this.id_tweet = null;
        this.crime= null;
    	this.naocrime= null;
    	this.flag= null;        
    }
    
    return Voto;
});