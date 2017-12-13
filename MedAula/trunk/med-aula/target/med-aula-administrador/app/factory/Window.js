app.factory('Window', function(){
	
	var Window = function(){
		this.titulo="";
		this.mostrarBtnSalvar=false;
		this.mostrarBtnNovo=false;
		this.view = "";
		this.isLoading=false;
		this.agurdandoResposta=false;
    }
    return Window;
});