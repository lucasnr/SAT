/*
* INFO4M - 20161164010034
* @author Anderson dos Santos Lucio
*/

 $(".divUnidade").hide();

function exibir_ocultar() {
    var valor = $(".perfil").val();

    if(valor == 'INSTRUTOR' || valor == 'COORDENADOR_UNIDADE') {
    	$(".divUnidade").show();
     } else if(valor == 'ALUNO' || valor == 'COORDENADOR_GERAL') {
    	 $(".divUnidade").hide();
     } 
};