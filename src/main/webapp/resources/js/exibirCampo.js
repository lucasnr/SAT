/*
 * INFO4M - 20161164010034
 * @author Anderson dos Santos Lucio
 */

$(".divUnidade").hide();

function perfilOnChangeAction() {
	var valor = $(".perfil").val();

	if (valor == 'ALUNO') {
		console.log("aluno")
		alunoRemoteCommand();
	} else if (valor == 'INSTRUTOR') {
		console.log("instrutor")
		instrutorRemoteCommand();
	} else if (valor == 'COORDENADOR_UNIDADE') {
		console.log("coordenador de unidade")
		coordenadorUnidadeRemoteCommand();
	} else if (valor == 'COORDENADOR_GERAL') {
		console.log("coordenador geral")
		coordenadorGeralRemoteCommand();
	}

	// toggle unidade
	if (valor == 'INSTRUTOR' || valor == 'COORDENADOR_UNIDADE') {
		$(".divUnidade").show();
	} else if (valor == 'ALUNO' || valor == 'COORDENADOR_GERAL') {
		$(".divUnidade").hide();
	}
};
