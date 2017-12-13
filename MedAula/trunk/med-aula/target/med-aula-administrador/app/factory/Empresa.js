app.factory('Empresa', function(){
	
	var Empresa = function(){
        
		this.id = null;
    	this.bairro= null;
    	this.cep= null;
    	this.cnpj= null;
    	this.complemento= null;
    	this.responsavel= null;
    	this.email= null;
    	this.inscricaoEstadual= null;
    	this.logradouro= null;
    	this.nomeFantasia= null; 
    	this.numero= null;
    	this.razaoSocial = null;
    	this.telefone= null;
    	this.idCidade= "";
    	this.idEmpresaPai= null;
    	this.tiposNegocio = [];
    }
    
    return Empresa;
});