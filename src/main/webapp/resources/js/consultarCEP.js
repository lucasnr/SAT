/*
* INFO4M - 20161164010034
* @author Anderson dos Santos Lucio
*/

$(document).ready(
		function() {

			function limpa_formulário_cep() {
				$(".bairro").val("");
				$(".logradouro").val("");
			}

			$(".cep").blur(
					function() {
						var cep = $(this).val().replace(/\D/g, '');

						if (cep != "") {

							var validacep = /^[0-9]{8}$/;

							if (validacep.test(cep)) {

								$.getJSON("https://viacep.com.br/ws/" + cep
										+ "/json/?callback=?", function(dados) {

									if (!("erro" in dados)) {
										$(".bairro").val(dados.bairro);
										$(".logradouro").val(dados.logradouro);
									} // end if.
									else {
										limpa_formulário_cep();
										alert("CEP não encontrado");
									}
								});
							} 
							else {
								limpa_formulário_cep();
								alert("Formato de CEP inválido");
							}
						} 
						else {
							limpa_formulário_cep();
						}
					});
		});
