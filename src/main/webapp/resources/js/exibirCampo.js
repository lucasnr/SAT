/*
 * INFO4M - 20161164010034
 * @author Anderson dos Santos Lucio
 */

$(".divUnidade").hide(0);
$(".divTurma").hide(0);

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

	// toggle unidade e turma
	if (valor == 'INSTRUTOR' || valor == 'COORDENADOR_UNIDADE') {
		$(".divUnidade").show(1000);
		$(".divTurma").hide(1000);
	} else if (valor == 'ALUNO') {
		$(".divUnidade").hide(1000);
		$(".divTurma").show(1000);
	} else if (valor == 'COORDENADOR_GERAL') {
		$(".divUnidade").hide(1000);
		$(".divTurma").hide(1000);
	} else if (valor == 'null') {
		$(".divUnidade").hide(1000);
		$(".divTurma").hide(1000);
	}
};

/* Limpar o campo perfil quando error */

$('.perfil', '.cadastrarUsuariosForm').not(':button').val('')
		.removeAttr('checked').removeAttr('selected');
