app.factory('Evento', function(){
	
	var Evento = function(){
        
		this.id = null;
    	this.descricao = null;
    	this.cor = null;
    	this.dataHoraInicio = null;
    	this.dataHoraFim = null;
    	this.tipoEvento = null;
    }
    
    return Evento;
});