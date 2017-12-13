app.service('dataTableLanguageService', function(){

	this.portugues = function(){
		return {
		    "sEmptyTable":     "Nenhum registro encontrado",
		    "sInfo":           "Mostrando _START_ até _END_ de _TOTAL_ registros",
		    "sInfoEmpty":      "Mostrando 0 até 0 de 0 registros",
		    "sInfoFiltered":   "(filtrado de _MAX_ total registros)",
		    "sInfoPostFix":    "",
		    "sInfoThousands":  ",",
		    "sLengthMenu":     "Mostrando _MENU_ registros",
		    "sLoadingRecords": "Carregando...",
		    "sProcessing":     "Processando...",
		    "sSearch":         "Pesquisar:",
		    "sZeroRecords":    "Nenhum registro correspondente encontrado",
		    "oPaginate": {
		        "sFirst":    "Primeria",
		        "sLast":     "Última",
		        "sNext":     "Próxima",
		        "sPrevious": "Anterior"
		    },
		    "oAria": {
		        "sSortAscending":  ": ativar ordem crescente",
		        "sSortDescending": ": ativar ordem descrescente"
		    }
		}
	}
	
	
});