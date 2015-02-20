var idVeiculo = 1;
var nome;
var email;
var cpfT;

$(document).ready(function() {
	$(document).keyup(function(e) {
		if (e.which == 27) {
			parent.$('#janela_modal').fadeOut("fast", 0, function() {
				$(this).remove();
			});// PARA REMOVER O EFEITO
			parent.$('#overlay').fadeOut("fast", 0, function() {
				$(this).remove();
			});// PARA REMOVER O EFEITO
			redirectHome();
		}
	});
});

function split(val) {
	return val.split(/,\s*/);
}
function extractLast(term) {
	return split(term).pop();
}

function mask(id, mask) {
	$("#" + id).mask(mask);
}

function ocultar(id) {
	if ($("#" + id).is(":hidden")) {
		$("#" + id).show("slow");
	} else {
		$("#" + id).slideUp("slow");
	}
}

function getPorte_meu_perfil() {
	$.ajax({
		type : "POST",
		url : url_meu_perfil,
		data : {
			met : "porte",
			location : "Boston"
		},
		dataType : "html"
	}).done(function(msg) {
		document.getElementById('porte-empresa').innerHTML = msg;

	}).fail(function(jqXHR, textStatus) {
		// alert( "Request failed: " + textStatus );
	});

}
function getPorte() {
	$.ajax({
		type : "POST",
		url : url,
		data : {
			met : "porte",
			location : "Boston"
		},
		dataType : "html"
	}).done(function(msg) {
		document.getElementById('porte-empresa').innerHTML = msg;

	}).fail(function(jqXHR, textStatus) {
		// alert( "Request failed: " + textStatus );
	});

}

function getRamo() {
	$.ajax({
		type : "POST",
		url : url,
		data : {
			met : "ramo"
		},
		dataType : "html"
	}).done(function(msg) {
		document.getElementById('ramo-atividade').innerHTML = msg;

	}).fail(function(jqXHR, textStatus) {
		// alert( "Request failed: " + textStatus );
	});

}
function getRamo_meu_perfil() {
	$.ajax({
		type : "POST",
		url : url_meu_perfil,
		data : {
			met : "ramo"
		},
		dataType : "html"
	}).done(function(msg) {
		document.getElementById('ramo-atividade').innerHTML = msg;

	}).fail(function(jqXHR, textStatus) {
		// alert( "Request failed: " + textStatus );
	});

}
function getNivel() {
	$.ajax({
		type : "POST",
		url : url,
		data : {
			met : "nivel"
		},
		dataType : "html"
	}).done(function(msg) {
		document.getElementById('nivel-hierarquico').innerHTML = msg;
	}).fail(function(jqXHR, textStatus) {
		// alert( "Request failed: " + textStatus );
	});

}
function getNivel_meu_perfil() {
	$.ajax({
		type : "POST",
		url : url_meu_perfil,
		data : {
			met : "nivel"
		},
		dataType : "html"
	}).done(function(msg) {
		document.getElementById('nivel-hierarquico').innerHTML = msg;
	}).fail(function(jqXHR, textStatus) {
		// alert( "Request failed: " + textStatus );
	});

}
function getArea() {
	$.ajax({
		type : "POST",
		url : url,
		data : {
			met : "area"
		},
		dataType : "html"
	}).done(function(msg) {
		document.getElementById('area-atuacao').innerHTML = msg;
	}).fail(function(jqXHR, textStatus) {
		// alert( "Request failed: " + textStatus );
	});

}
function getArea_meu_perfil() {
	$.ajax({
		type : "POST",
		url : url_meu_perfil,
		data : {
			met : "area"
		},
		dataType : "html"
	}).done(function(msg) {
		document.getElementById('area-atuacao').innerHTML = msg;
	}).fail(function(jqXHR, textStatus) {
		// alert( "Request failed: " + textStatus );
	});

}

function getNews() {
	
	$.ajax({
		type : "POST",
		url : url,
		data : {
			met : "newsletters"
		},
		dataType : "html"
	}).done(function(msg) {
		document.getElementById('content_news_cad').innerHTML = msg;
	}).fail(function(jqXHR, textStatus) {
		// alert( "Request failed: " + textStatus );
	});

}
function getNews_meu_perfil() {
	$.ajax({
		type : "POST",
		url : url_meu_perfil,
		data : {
			met : "newsletters"
		},
		dataType : "html"
	}).done(function(msg) {
		document.getElementById('content_news_meu_perfil').innerHTML = msg;
	}).fail(function(jqXHR, textStatus) {
		// alert( "Request failed: " + textStatus );
	});

}

function verEmail() {
	email = $("#e-mail").val();
	var cpfL = $("#cpf").val();
	if (!validarEmail()){
		return false;
	}
	
	var cpf = $("#cpf").val().replace('.', '');
	cpf = cpf.replace('-', '');
	if (!TestaCPF(cpf)) {
		return false;
	}
	$('#form-dadosPessoais')[0].reset();

	$.ajax({
				type : "POST",
				url : url,
				data : {
					met : "verEmail",
					email : email, cpf : cpf
				},
				dataType : "html"
			})
			.done(
					function(msg) {
						document.getElementById('e-mail').value = email;
						document.getElementById('cpf').value = cpfL;
						if (msg != "ok") {
							
							
							
							
							$('input[name=e-mail]').css('color', '#0076bc');
							var vet = msg.split("|");
							if ("null" != vet[0] && (undefined != vet[0])){
								document.getElementById('nome').value = vet[0];
							}else{
								document.getElementById('nome').value = "";
							}
								
							if ("null" != vet[1] && (undefined != vet[1])){
								document.getElementById('sobrenome').value = vet[1];
							}else{
								document.getElementById('sobrenome').value = "";
							}
								
							if ("null" != vet[2] && (undefined != vet[2])){
								document.getElementById('cpf').value = vet[2];
							}else{
								document.getElementById('cpf').value = "";
							}
								
							if ("null" != vet[3] && (undefined != vet[3])){
								document.getElementById('data-nascimento').value = vet[3];
							}else{
								document.getElementById('data-nascimento').value = "";
								}
								

							if ("null" != vet[4] && (undefined != vet[4])) {
								if (vet[4] == 'M' || vet[4] == 'm') {
									document.getElementById("sexoM").checked = true;
								} else {
									document.getElementById("sexoM").checked = true;
								}
							}else{
								document.getElementById("sexoM").checked = false;
							}

							if ("null" != vet[5]) {
								var vet2 = vet[5].split("#");
								if ((undefined != vet2[1]))
									$('#area-atuacao').append(
											'<option value="' + vet2[0]
													+ '" selected="selected">'
													+ vet2[1] + '</option>');
							}else{
								$("#area-atuacao").selectedIndex = 1;
							}
							if ("null" != vet[6]) {
								var vet2 = vet[6].split("#");
								if ((undefined != vet2[1]))
									$('#nivel-hierarquico').append(
											'<option value="' + vet2[0]
													+ '" selected="selected">'
													+ vet2[1] + '</option>');
							}else{
								$("#nivel-hierarquico").selectedIndex = 1;
							}
							if ("null" != vet[7]) {
								var vet2 = vet[7].split("#");
								if ((undefined != vet2[1]))
									document.getElementById('empresa').value = vet2[1];
							}else{
								document.getElementById('empresa').value = "";
							}
							if ("null" != vet[8]) {
								var vet2 = vet[8].split("#");
								if ((undefined != vet2[1]))
									$('#ramo-atividade').append(
											'<option value="' + vet2[0]
													+ '" selected="selected">'
													+ vet2[1] + '</option>');
							}else{
								$("#ramo-atividade").selectedIndex = 1;
							}
							if ("null" != vet[9]) {
								var vet2 = vet[9].split("#");
								if ((undefined != vet2[1]))
									$('#porte-empresa').append(
											'<option value="' + vet2[0]
													+ '" selected="selected">'
													+ vet2[1] + '</option>');
							}else{
								$("#porte-empresa").selectedIndex = 1;
							}
							if ("null" != vet[10]) {
								var vet2 = vet[10].split("#");
								if ((undefined != vet2[1]))
									document.getElementById('cargo').value = vet2[1];
							}else{
								document.getElementById('cargo').value = "";
							}
							if ("null" != vet[11]) {
								var vet2 = vet[11].split("#");
								if ("null" != vet2[0] && (undefined != vet2[0])){
									document.getElementById('bairro').value = vet2[0];
								}else{
									document.getElementById('bairro').value ="";
								}
									
								if ("null" != vet2[1] && (undefined != vet2[1])){
									document.getElementById('endereco').value = vet2[1];
								}else{
									document.getElementById('endereco').value = "";
								}									
								if ("null" != vet2[2] && (undefined != vet2[2])){
									document.getElementById('numero').value = vet2[2];
								}else{
									document.getElementById('numero').value ="";
								}
									
								if ("null" != vet2[3] && (undefined != vet2[3])){
									document.getElementById('complemento').value = vet2[3];
								}else{
									document.getElementById('complemento').value = "";
								}
									
								if ("null" != vet2[4] && (undefined != vet2[4])){
									document.getElementById('cidade').value = vet2[4];
								}else{
									document.getElementById('cidade').value = "";
								}
									
								if ("null" != vet2[5] && (undefined != vet2[5])){
									document.getElementById('estado').value = vet2[5];
								}else{
									document.getElementById('estado').value ="";
								}
									
								if ("null" != vet2[6] && (undefined != vet2[6])){
									document.getElementById('pais').value = vet2[6];
								}else{
									document.getElementById('pais').value = "";
								}
									
								if (("null" != vet2[7])
										&& (undefined != vet2[7])) {
									document.getElementById('cep').value = vet2[7];
								}else{
									document.getElementById('cep').value ="";
								}
								if (("null" != vet2[8])
										&& (undefined != vet2[8])) {
									document.getElementById('id_endereco').value = vet2[8];
								}else{
									document.getElementById('id_endereco').value = "";
								}
							}
							if ("null" != vet[12]) {
								document.getElementById('email-alternativo').value = vet[12];
							}else{
								document.getElementById('email-alternativo').value ="";
							}
							
						}
					}).fail(function(jqXHR, textStatus) {
				// alert( "Request failed: " + textStatus );
			});

}


function verEmail_meu_perfil() {
	if (!validarEmail())
		return false;

	$.ajax({
				type : "POST",
				url : url_meu_perfil,
				data : {
					met : "verEmail",
					email : $("#e-mail").val()
				},
				dataType : "html"
			})
			.done(
					function(msg) {

						if (msg != "ok") {
							$('input[name=e-mail]').css('color', '#0076bc');
							var vet = msg.split("|");
							if ("null" != vet[12]) {
								document.getElementById('email-alternativo').value = vet[12];
							}
							if ("null" != vet[0] && (undefined != vet[0]))
								document.getElementById('nome').value = vet[0];
							if ("null" != vet[1] && (undefined != vet[1]))
								document.getElementById('sobrenome').value = vet[1];
							if ("null" != vet[2] && (undefined != vet[2]))
								document.getElementById('cpf').value = vet[2];
							if ("null" != vet[3] && (undefined != vet[3]))
								document.getElementById('data-nascimento').value = vet[3];

							if ("null" != vet[4] && (undefined != vet[4])) {
								if (vet[4] == 'M' || vet[4] == 'm') {
									document.getElementById("sexoM").checked = true;
								} else {
									document.getElementById("sexoM").checked = true;
								}
							}

							if ("null" != vet[5]) {
								var vet2 = vet[5].split("#");
								if ((undefined != vet2[1]))
									$('#area-atuacao').append(
											'<option value="' + vet2[0]
													+ '" selected="selected">'
													+ vet2[1] + '</option>');
							}
							if ("null" != vet[6]) {
								var vet2 = vet[6].split("#");
								if ((undefined != vet2[1]))
									$('#nivel-hierarquico').append(
											'<option value="' + vet2[0]
													+ '" selected="selected">'
													+ vet2[1] + '</option>');
							}
							if ("null" != vet[7]) {
								var vet2 = vet[7].split("#");
								if ((undefined != vet2[1]))
									document.getElementById('empresa').value = vet2[1];
							}
							if ("null" != vet[8]) {
								var vet2 = vet[8].split("#");
								if ((undefined != vet2[1]))
									$('#ramo-atividade').append(
											'<option value="' + vet2[0]
													+ '" selected="selected">'
													+ vet2[1] + '</option>');
							}
							if ("null" != vet[9]) {
								var vet2 = vet[9].split("#");
								if ((undefined != vet2[1]))
									$('#porte-empresa').append(
											'<option value="' + vet2[0]
													+ '" selected="selected">'
													+ vet2[1] + '</option>');
							}
							if ("null" != vet[10]) {
								var vet2 = vet[10].split("#");
								if ((undefined != vet2[1]))
									document.getElementById('cargo').value = vet2[1];
							}
							if ("null" != vet[11]) {
								var vet2 = vet[11].split("#");
								if ("null" != vet2[0] && (undefined != vet2[0]))
									document.getElementById('bairro').value = vet2[0];
								if ("null" != vet2[1] && (undefined != vet2[1]))
									document.getElementById('endereco').value = vet2[1];
								if ("null" != vet2[2] && (undefined != vet2[2]))
									document.getElementById('numero').value = vet2[2];
								if ("null" != vet2[3] && (undefined != vet2[3]))
									document.getElementById('complemento').value = vet2[3];
								if ("null" != vet2[4] && (undefined != vet2[4]))
									document.getElementById('cidade').value = vet2[4];
								if ("null" != vet2[5] && (undefined != vet2[5]))
									document.getElementById('estado').value = vet2[5];
								if ("null" != vet2[6] && (undefined != vet2[6]))
									document.getElementById('pais').value = vet2[6];
								if (("null" != vet2[7])
										&& (undefined != vet2[7])) {
									document.getElementById('cep').value = vet2[7];
								}
								if (("null" != vet2[8])
										&& (undefined != vet2[8])) {
									document.getElementById('id_endereco').value = vet2[8];
								}
							}
							
						}
					}).fail(function(jqXHR, textStatus) {
				// alert( "Request failed: " + textStatus );
			});

}

function buscarCep() {
	$.ajax({
		type : "POST",
		url : url,
		data : {
			met : "cep",
			cep : $("#cep").val()
		},
		dataType : "html"
	}).done(function(msg) {
		var vet = msg.split("|");
		if (vet[0] == "ok") {
			document.getElementById('bairro').value = vet[3];
			document.getElementById('endereco').value = vet[2];
			document.getElementById('cidade').value = vet[4];
			document.getElementById('estado').value = vet[5];
			document.getElementById('pais').value = vet[6];
		} else {
			// alert(vet[1]+": "+vet[2]);
		}

	});

}
function buscarCep_meu_perfil() {
	$.ajax({
		type : "POST",
		url : url_meu_perfil,
		data : {
			met : "cep",
			cep : $("#cep").val()
		},
		dataType : "html"
	}).done(function(msg) {
		var vet = msg.split("|");
		if (vet[0] == "ok") {
			document.getElementById('bairro').value = vet[3];
			document.getElementById('endereco').value = vet[2];
			document.getElementById('cidade').value = vet[4];
			document.getElementById('estado').value = vet[5];
			document.getElementById('pais').value = vet[6];
		} else {
			// alert(vet[1]+": "+vet[2]);
		}

	});

}
function getEmail() {
	$.ajax({
		type : "POST",
		url : url_meu_perfil,
		data : {
			met : "get_email"
		},
		dataType : "html"
	}).done(function(msg) {
		txt = msg.split("|");
		
		document.getElementById('e-mail').value = txt[0];
		document.getElementById('cpf').value = txt[1];
		email = txt[0];
		cpfT = txt[1];
		verEmail_meu_perfil();

	});

}
function verificarEmailLogin() {
	var email = $("#E-mail").val();
	var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	if ((email != "") && (filtro.test(email))) {

		$('input[name=E-mail]').css('background', '#fff');
		$('input[name=E-mail]').css('border', '1px solid #0076bc');
		$('input[name=E-mail]').css('color', '#7e807a');
		$('input[name=E-mail]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[name=E-mail]').css('font-size', '14px');
		$('input[name=E-mail]').css('text-transform', 'lowercase');

		return true;
	} else {
		$('input[name=E-mail]').css('background', '#fff');
		$('input[name=E-mail]').css('border', '1px solid red');
		$('input[name=E-mail]').css('color', '#000');
		$('input[name=E-mail]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[name=E-mail]').css('font-size', '14px');
		$('input[name=E-mail]').css('text-transform', 'lowercase');
		$('input[name=E-mail]').addClass('txtempty');
		$('input[name=E-mail]').attr('placeholder', 'digite um e-mail v\u00e1lido!');
		return false;
	}
}

function verificarSenha(senha, id){
	if($("#"+id).val().length < 3){
		$('input[id='+id+']').css('background', '#fff');
		$('input[id='+id+']').css('border', '1px solid red');
		$('input[id='+id+']').css('color', '#7e807a');
		$('input[name=senha_login]').addClass('txtempty');
		$('input[name=senha_login]').attr('placeholder', 'digite uma senha v\u00e1lida!');
		return false;
	}else{
		return true;		
	}
	
}

function login() {
	if (verificarEmailLogin() && (verificarSenha($("#senha_login").val(), 'senha_login'))) {
		var frm = $('#form_login').serialize();
		$.ajax({
			type : "POST",
			url : url + "?met=login&veiculo=" + idVeiculo,
			data : frm,
			dataType : "html"
		}).done(function(msg) {
			txt = msg.split("|");
			if (txt[0] == "ok") {
				email = txt[0];
				cpfT = txt[1];
				location.reload();
			} else {
//				alert(txt[0] + " - usuario nao localizado");
				alert_default('Login', 'O e-mail ou a senha inseridos est&atilde;o incorretos');
			}
			redirectHome();
		});
	}

}
function validarEmail() {
	var email = $("#e-mail").val();
	if (email != "") {
		var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		if (filtro.test(email)) {
			$('input[name=e-mail]').css('background', '#fff');
			$('input[name=e-mail]').css('border', '1px solid #0076bc'); 
			$('input[name=e-mail]').css('color', '#7e807a');
			$('input[name=e-mail]').css('border-radius', '30px');
			$('input[name=e-mail]').css('font-family',
					'flama-basic, Arial, Helvetica, sans-serif');
			$('input[name=e-mail]').css('font-size', '14px');
			$('input[name=e-mail]').css('margin-left', '24px');
			$('input[name=e-mail]').css('padding', '9px 27px');
			$('input[name=e-mail]').css('text-transform', 'lowercase');
			$('input[name=e-mail]').css('width', '250px');
			return true;
		} else {
			$('input[name=e-mail]').css('background', '#fff');
			$('input[name=e-mail]').css('border', '1px solid red');
			$('input[name=e-mail]').css('color', '#000');
			$('input[name=e-mail]').css('border-radius', '30px');
			$('input[name=e-mail]').css('font-family',
					'flama-basic, Arial, Helvetica, sans-serif');
			$('input[name=e-mail]').css('font-size', '14px');
			$('input[name=e-mail]').css('margin-left', '24px');
			$('input[name=e-mail]').css('padding', '9px 27px');
			$('input[name=e-mail]').css('text-transform', 'lowercase');
			$('input[name=e-mail]').css('width', '250px');
			$('input[name=e-mail]').addClass('txtempty');
			$('input[name=e-mail]').attr('placeholder', 'digite um e-mail v\u00e1lido!');
			return false;
		}
	} else {
		$('input[name=e-mail]').css('background', '#fff');
		$('input[name=e-mail]').css('border', '1px solid red');
		$('input[name=e-mail]').css('color', '#000');
		$('input[name=e-mail]').css('border-radius', '30px');
		$('input[name=e-mail]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[name=e-mail]').css('font-size', '14px');
		$('input[name=e-mail]').css('margin-left', '24px');
		$('input[name=e-mail]').css('padding', '9px 27px');
		$('input[name=e-mail]').css('text-transform', 'lowercase');
		$('input[name=e-mail]').css('width', '250px');
		$('input[name=e-mail]').addClass('txtempty');
		$('input[name=e-mail]').attr('placeholder', 'digite um e-mail v\u00e1lido!');
		return false;
	}
}




	var nome = $("#nome").val().replace('.', '');
	nome = nome.replace('-', '');
	if (!($("#nome").val().length >= 2)) {
		$("#nome").focus();
		$('input[id=nome]').css('background', '#fff');
		$('input[id=nome]').css('border', '1px solid red');
		$('input[id=nome]').css('color', '#000');
		$('input[id=nome]').css('border-radius', '30px');
		$('input[id=nome]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=nome]').css('font-size', '14px');
		$('input[id=nome]').css('margin-left', '24px');
		$('input[id=nome]').css('padding', '9px 27px');
		$('input[id=nome]').css('text-transform', 'lowercase');
		$('input[id=nome]').css('width', '250px');
		$('input[id=nome]').addClass('txtempty');
		$('input[id=nome]').attr('placeholder', 'digite um nome v\u00e1lido!');
		val = false;
	} else {
		$('input[id=nome]').css('background', '#fff');
		$('input[id=nome]').css('border', '1px solid #ccc');
		$('input[id=nome]').css('color', '#7e807a');
		$('input[id=nome]').css('border-radius', '30px');
		$('input[id=nome]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=nome]').css('font-size', '14px');
		$('input[id=nome]').css('margin-left', '24px');
		$('input[id=nome]').css('padding', '9px 27px');
		$('input[id=nome]').css('text-transform', 'lowercase');
		$('input[id=nome]').css('width', '250px');
	}



			if (!($("#nome").val().length >= 2)) {
		$("#nome").focus();
		$('input[id=nome]').css('background', '#fff');
		$('input[id=nome]').css('border', '1px solid red');
		$('input[id=nome]').css('color', '#000');
		$('input[id=nome]').css('border-radius', '30px');
		$('input[id=nome]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=nome]').css('font-size', '14px');
		$('input[id=nome]').css('margin-left', '24px');
		$('input[id=nome]').css('padding', '9px 27px');
		$('input[id=nome]').css('text-transform', 'lowercase');
		$('input[id=nome]').css('width', '250px');
		$('input[id=nome]').addClass('txtempty');
		$('input[id=nome]').attr('placeholder', 'digite seu Logrfffgfgadouro');
		val = false;
	} else {
		$('input[id=nome]').css('background', '#fff');
		$('input[id=nome]').css('border', '1px solid #ccc');
		$('input[id=nome]').css('color', '#7e807a');
		$('input[id=nome]').css('border-radius', '30px');
		$('input[id=nome]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=nome]').css('font-size', '14px');
		$('input[id=nome]').css('margin-left', '24px');
		$('input[id=nome]').css('padding', '9px 27px');
		$('input[id=nome]').css('text-transform', 'lowercase');
		$('input[id=nome]').css('width', '250px');
	}




function validarForm() {
	var val = true;
	if (!validarEmail()) {
		$("#empresa").focus();
		val = false;
	}
	if (!($("#sobrenome").val().length >= 2)) {
		$("#sobrenome").focus();
		$('input[id=sobrenome]').css('background', '#fff');
		$('input[id=sobrenome]').css('border', '1px solid red');
		$('input[id=sobrenome]').css('color', '#000');
		$('input[id=sobrenome]').css('border-radius', '30px');
		$('input[id=sobrenome]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=sobrenome]').css('font-size', '14px');
		$('input[id=sobrenome]').css('margin-left', '24px');
		$('input[id=sobrenome]').css('padding', '9px 27px');
		$('input[id=sobrenome]').css('text-transform', 'lowercase');
		$('input[id=sobrenome]').css('width', '250px');
		$('input[id=sobrenome]').addClass('txtempty');
		$('input[id=sobrenome]').attr('placeholder', 'digite um sobrenome v\u00e1lido!');
		val = false;
	} else {
		$('input[id=sobrenome]').css('background', '#fff');
		$('input[id=sobrenome]').css('border', '1px solid #cc');
		$('input[id=sobrenome]').css('color', '#7e807a');
		$('input[id=sobrenome]').css('border-radius', '30px');
		$('input[id=sobrenome]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=sobrenome]').css('font-size', '14px');
		$('input[id=sobrenome]').css('margin-left', '24px');
		$('input[id=sobrenome]').css('padding', '9px 27px');
		$('input[id=sobrenome]').css('text-transform', 'lowercase');
		$('input[id=sobrenome]').css('width', '250px');
	}
	

	
	if (!($("#email-alternativo").val().length >= 2)) {
		$("#email-alternativo").focus();
		$('input[id=email-alternativo]').css('background', '#fff');
		$('input[id=email-alternativo]').css('border', '1px solid red');
		$('input[id=email-alternativo]').css('color', '#000');
		$('input[id=email-alternativo]').css('border-radius', '30px');
		$('input[id=email-alternativo]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=email-alternativo]').css('font-size', '14px');
		$('input[id=email-alternativo]').css('margin-left', '24px');
		$('input[id=email-alternativo]').css('padding', '9px 27px');
		$('input[id=email-alternativo]').css('text-transform', 'lowercase');
		$('input[id=email-alternativo]').css('width', '250px');
		$('input[id=email-alternativo]').addClass('txtempty');
		$('input[id=email-alternativo]').attr('placeholder', 'digite um e-mail alternativo v\u00e1lido!');
		val = false;
	} else {
		$('input[id=email-alternativo]').css('background', '#fff');
		$('input[id=email-alternativo]').css('border', '1px solid #cc');
		$('input[id=email-alternativo]').css('color', '#7e807a');
		$('input[id=email-alternativo]').css('border-radius', '30px');
		$('input[id=email-alternativo]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=email-alternativo]').css('font-size', '14px');
		$('input[id=email-alternativo]').css('margin-left', '24px');
		$('input[id=email-alternativo]').css('padding', '9px 27px');
		$('input[id=email-alternativo]').css('text-transform', 'lowercase');
		$('input[id=email-alternativo]').css('width', '250px');
	}	
	
	
	if (!($("#cep").val().length >= 2)) {
		$("#cep").focus();
		$('input[id=cep]').css('background', '#fff');
		$('input[id=cep]').css('border', '1px solid red');
		$('input[id=cep]').css('color', '#000');
		$('input[id=cep]').css('border-radius', '30px');
		$('input[id=cep]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=cep]').css('font-size', '14px');
		$('input[id=cep]').css('margin-left', '24px');
		$('input[id=cep]').css('padding', '9px 27px');
		$('input[id=cep]').css('text-transform', 'lowercase');
		$('input[id=cep]').css('width', '250px');
		$('input[id=cep]').addClass('txtempty');
		$('input[id=cep]').attr('placeholder', 'digite um CEP v\u00e1lido!');
		val = false;
	} else {
		$('input[id=cep]').css('background', '#fff');
		$('input[id=cep]').css('border', '1px solid #ccc');
		$('input[id=cep]').css('color', '#7e807a');
		$('input[id=cep]').css('border-radius', '30px');
		$('input[id=cep]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=cep]').css('font-size', '14px');
		$('input[id=cep]').css('margin-left', '24px');
		$('input[id=cep]').css('padding', '9px 27px');
		$('input[id=cep]').css('text-transform', 'lowercase');
		$('input[id=cep]').css('width', '250px');
	}
	if (!($("#endereco").val().length >= 2)) {
		$("#endereco").focus();
		$('input[id=endereco]').css('background', '#fff');
		$('input[id=endereco]').css('border', '1px solid red');
		$('input[id=endereco]').css('color', '#000');
		$('input[id=endereco]').css('border-radius', '30px');
		$('input[id=endereco]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=endereco]').css('font-size', '14px');
		$('input[id=endereco]').css('margin-left', '24px');
		$('input[id=endereco]').css('padding', '9px 27px');
		$('input[id=endereco]').css('text-transform', 'lowercase');
		$('input[id=endereco]').css('width', '250px');
		$('input[id=endereco]').addClass('txtempty');
		$('input[id=endereco]').attr('placeholder', 'digite seu endereco                                                                                                                                                                                                                                                                                      o');
		val = false;
	} else {
		$('input[id=endereco]').css('background', '#fff');
		$('input[id=endereco]').css('border', '1px solid #ccc');
		$('input[id=endereco]').css('color', '#7e807a');
		$('input[id=endereco]').css('border-radius', '30px');
		$('input[id=endereco]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=endereco]').css('font-size', '14px');
		$('input[id=endereco]').css('margin-left', '24px');
		$('input[id=endereco]').css('padding', '9px 27px');
		$('input[id=endereco]').css('text-transform', 'lowercase');
		$('input[id=endereco]').css('width', '250px');
	}



		if (!($("#endereco").val().length >= 2)) {
		$("#endereco").focus();
		$('input[id=complemento]').css('background', '#fff');
		$('input[id=complemento]').css('border', '1px solid red');
		$('input[id=complemento]').css('color', '#000');
		$('input[id=complemento]').css('border-radius', '30px');
		$('input[id=complemento]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=complemento]').css('font-size', '14px');
		$('input[id=complemento]').css('margin-left', '24px');
		$('input[id=complemento]').css('padding', '9px 27px');
		$('input[id=complemento]').css('text-transform', 'lowercase');
		$('input[id=complemento]').css('width', '250px');
		$('input[id=complemento]').addClass('txtempty');
		$('input[id=complemento]').attr('placeholder', 'digite seu complemento                                                                                                                                                                                                                                                                                      o');
		val = false;
	} else {
		$('input[id=complemento]').css('background', '#fff');
		$('input[id=complemento]').css('border', '1px solid #ccc');
		$('input[id=complemento]').css('color', '#7e807a');
		$('input[id=complemento]').css('border-radius', '30px');
		$('input[id=complemento]').css('font-family',
				'flama-complemento, Arial, Helvetica, sans-serif');
		$('input[id=complemento]').css('font-size', '14px');
		$('input[id=complemento]').css('margin-left', '24px');
		$('input[id=complemento]').css('padding', '9px 27px');
		$('input[id=complemento]').css('text-transform', 'lowercase');
		$('input[id=complemento]').css('width', '250px');
	}


		if (!($("#logradouro").val().length >= 2)) {
		$("#endereco").focus();
		$('input[id=logradouro]').css('background', '#fff');
		$('input[id=logradouro]').css('border', '1px solid red');
		$('input[id=logradouro]').css('color', '#000');
		$('input[id=logradouro]').css('border-radius', '30px');
		$('input[id=logradouro]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=logradouro]').css('font-size', '14px');
		$('input[id=logradouro]').css('margin-left', '24px');
		$('input[id=logradouro]').css('padding', '9px 27px');
		$('input[id=logradouro]').css('text-transform', 'lowercase');
		$('input[id=logradouro]').css('width', '250px');
		$('input[id=logradouro]').addClass('txtempty');
		$('input[id=logradouro]').attr('placeholder', 'digite seu Logradouro');
		val = false;
	} else {
		$('input[id=logradouro]').css('background', '#fff');
		$('input[id=logradouro]').css('border', '1px solid #ccc');
		$('input[id=logradouro]').css('color', '#7e807a');
		$('input[id=logradouro]').css('border-radius', '30px');
		$('input[id=logradouro]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=logradouro]').css('font-size', '14px');
		$('input[id=logradouro]').css('margin-left', '24px');
		$('input[id=logradouro]').css('padding', '9px 27px');
		$('input[id=logradouro]').css('text-transform', 'lowercase');
		$('input[id=logradouro]').css('width', '250px');
	}


			if (!($("#numero").val().length >= 2)) {
		$("#numero").focus();
		$('input[id=numero]').css('background', '#fff');
		$('input[id=numero]').css('border', '1px solid red');
		$('input[id=numero]').css('color', '#000');
		$('input[id=numero]').css('border-radius', '30px');
		$('input[id=numero]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=logradouro]').css('font-size', '14px');
		$('input[id=numero]').css('margin-left', '24px');
		$('input[id=numero]').css('padding', '9px 27px');
		$('input[id=numero]').css('text-transform', 'lowercase');
		$('input[id=numero]').css('width', '250px');
		$('input[id=numero]').addClass('txtempty');
		$('input[id=numero]').attr('placeholder', 'digite o numero');
		val = false;
	} else {
		$('input[id=numero]').css('background', '#fff');
		$('input[id=numero]').css('border', '1px solid #ccc');
		$('input[id=numero]').css('color', '#7e807a');
		$('input[id=numero]').css('border-radius', '30px');
		$('input[id=numero]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=numero]').css('font-size', '14px');
		$('input[id=numero]').css('margin-left', '24px');
		$('input[id=numero]').css('padding', '9px 27px');
		$('input[id=numero]').css('text-transform', 'lowercase');
		$('input[id=numero]').css('width', '250px');
	} 

	if (!($("#bairro").val().length >= 2)) {
		$("#bairro").focus();
		$('input[id=bairro]').css('background', '#fff');
		$('input[id=bairro]').css('border', '1px solid red');
		$('input[id=bairro]').css('color', '#000');
		$('input[id=bairro]').css('border-radius', '30px');
		$('input[id=bairro]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=bairro]').css('font-size', '14px');
		$('input[id=bairro]').css('margin-left', '24px');
		$('input[id=bairro]').css('padding', '9px 27px');
		$('input[id=bairro]').css('text-transform', 'lowercase');
		$('input[id=bairro]').css('width', '250px');
		$('input[id=bairro]').addClass('txtempty');
		$('input[id=bairro]').attr('placeholder', 'digite seu Bairro');
		val = false;
	} else {
		$('input[id=bairro]').css('background', '#fff');
		$('input[id=bairro]').css('border', '1px solid #ccc');
		$('input[id=bairro]').css('color', '#7e807a');
		$('input[id=bairro]').css('border-radius', '30px');
		$('input[id=bairro]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=bairro]').css('font-size', '14px');
		$('input[id=bairro]').css('margin-left', '24px');
		$('input[id=bairro]').css('padding', '9px 27px');
		$('input[id=bairro]').css('text-transform', 'lowercase');
		$('input[id=bairro]').css('width', '250px');
	}


		if (!($("#empresa").val().length >= 2)) {
		$("#empresa").focus();
		$('input[id=empresa]').css('background', '#fff');
		$('input[id=empresa]').css('border', '1px solid red');
		$('input[id=empresa]').css('color', '#000');
		$('input[id=empresa]').css('border-radius', '30px');
		$('input[id=empresa]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=empresa]').css('font-size', '14px');
		$('input[id=empresa]').css('margin-left', '24px');
		$('input[id=empresa]').css('padding', '9px 27px');
		$('input[id=empresa]').css('text-transform', 'lowercase');
		$('input[id=empresa]').css('width', '250px');
		$('input[id=empresa]').addClass('txtempty');
		$('input[id=empresa]').attr('placeholder', 'digite o nome da sua empresa');
		val = false;
	} else {
		$('input[id=empresa]').css('background', '#fff');
		$('input[id=empresa]').css('border', '1px solid #ccc');
		$('input[id=empresa]').css('color', '#7e807a');
		$('input[id=empresa]').css('border-radius', '30px');
		$('input[id=empresa]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=empresa]').css('font-size', '14px');
		$('input[id=empresa]').css('margin-left', '24px');
		$('input[id=empresa]').css('padding', '9px 27px');
		$('input[id=empresa]').css('text-transform', 'lowercase');
		$('input[id=empresa]').css('width', '250px');
	}

		if (!($("#cargo").val().length >= 2)) {
		$("#cargo").focus();
		$('input[id=cargo]').css('background', '#fff');
		$('input[id=cargo]').css('border', '1px solid red');
		$('input[id=cargo]').css('color', '#000');
		$('input[id=cargo]').css('border-radius', '30px');
		$('input[id=cargo]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=cargo]').css('font-size', '14px');
		$('input[id=cargo]').css('margin-left', '24px');
		$('input[id=cargo]').css('padding', '9px 27px');
		$('input[id=cargo]').css('text-transform', 'lowercase');
		$('input[id=cargo]').css('width', '250px');
		$('input[id=cargo]').addClass('txtempty');
		$('input[id=cargo]').attr('placeholder', 'digite seu Cargo');
		val = false;
	} else {
		$('input[id=cargo]').css('background', '#fff');
		$('input[id=cargo]').css('border', '1px solid #ccc');
		$('input[id=cargo]').css('color', '#7e807a');
		$('input[id=cargo]').css('border-radius', '30px');
		$('input[id=cargo]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=cargo]').css('font-size', '14px');
		$('input[id=cargo]').css('margin-left', '24px');
		$('input[id=cargo]').css('padding', '9px 27px');
		$('input[id=cargo]').css('text-transform', 'lowercase');
		$('input[id=cargo]').css('width', '250px');
	} 


	
	
	

	
	if (!($("#data-nascimento").val().length >= 2)) {
		$("#data-nascimento").focus();
		$('input[id=data-nascimento]').css('background', '#fff');
		$('input[id=data-nascimento]').css('border', '1px solid red');
		$('input[id=data-nascimento]').css('color', '#000');
		$('input[id=data-nascimento]').css('border-radius', '30px');
		$('input[id=data-nascimento]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=data-nascimento]').css('font-size', '14px');
		$('input[id=data-nascimento]').css('margin-left', '24px');
		$('input[id=data-nascimento]').css('padding', '9px 27px');
		$('input[id=data-nascimento]').css('text-transform', 'lowercase');
		$('input[id=data-nascimento]').css('width', '250px');
		$('input[id=data-nascimento]').addClass('txtempty');
		$('input[id=data-nascimento]').attr('placeholder', 'digite uma data de nascimento v\u00e1lida!');
		val = false;
	} else {
		$('input[id=data-nascimento]').css('background', '#fff');
		$('input[id=data-nascimento]').css('border', '1px solid #cc');
		$('input[id=data-nascimento]').css('color', '#7e807a');
		$('input[id=data-nascimento]').css('border-radius', '30px');
		$('input[id=data-nascimento]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=data-nascimento]').css('font-size', '14px');
		$('input[id=data-nascimento]').css('margin-left', '24px');
		$('input[id=data-nascimento]').css('padding', '9px 27px');
		$('input[id=data-nascimento]').css('text-transform', 'lowercase');
		$('input[id=data-nascimento]').css('width', '250px');
	}
		
	
	var cpf = $("#cpf").val().replace('.', '');
	cpf = cpf.replace('-', '');
	if (!TestaCPF(cpf)) {
		$("#cpf").focus();
		$('input[id=cpf]').css('background', '#fff');
		$('input[id=cpf]').css('border', '1px solid red');
		$('input[id=cpf]').css('color', '#000');
		$('input[id=cpf]').css('border-radius', '30px');
		$('input[id=cpf]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=cpf]').css('font-size', '14px');
		$('input[id=cpf]').css('margin-left', '24px');
		$('input[id=cpf]').css('padding', '9px 27px');
		$('input[id=cpf]').css('text-transform', 'lowercase');
		$('input[id=cpf]').css('width', '250px');
		$('input[id=cpf]').addClass('txtempty');
		$('input[id=cpf]').attr('placeholder', 'digite um CPF v\u00e1lido!');
		val = false;
	} else {
		$('input[id=cpf]').css('background', '#fff');
		$('input[id=cpf]').css('border', '1px solid #cc');
		$('input[id=cpf]').css('color', '#7e807a');
		$('input[id=cpf]').css('border-radius', '30px');
		$('input[id=cpf]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=cpf]').css('font-size', '14px');
		$('input[id=cpf]').css('margin-left', '24px');
		$('input[id=cpf]').css('padding', '9px 27px');
		$('input[id=cpf]').css('text-transform', 'lowercase');
		$('input[id=cpf]').css('width', '250px');	

	}

	var cpfu = $("#cpfu").val().replace('.', '');
	cpfu = cpfu.replace('-', '');
	if (!TestaCPF(cpfu)) {
		$("#cpf").focus();
		$('input[id=cpfu]').css('background', '#fff');
		$('input[id=cpfu]').css('border', '1px solid red');
		$('input[id=cpfu]').css('color', '#000');
		$('input[id=cpfu]').css('border-radius', '30px');
		$('input[id=cpfu]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=cpfu]').css('font-size', '14px');
		$('input[id=cpfu]').css('margin-left', '24px');
		$('input[id=cpfu]').css('padding', '9px 27px');
		$('input[id=cpfu]').css('text-transform', 'lowercase');
		$('input[id=cpfu]').css('width', '250px');
		$('input[id=cpfu]').addClass('txtempty');
		$('input[id=cpf]').attr('placeholder', 'digite um CPF v\u00e1lido!');
		val = false;
	} else {
		$('input[id=cpfu]').css('background', '#fff');
		$('input[id=cpfu]').css('border', '1px solid #cc');
		$('input[id=cpfu]').css('color', '#7e807a');
		$('input[id=cpfu]').css('border-radius', '30px');
		$('input[id=cpfu]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=cpfu]').css('font-size', '14px');
		$('input[id=cpfu]').css('margin-left', '24px');
		$('input[id=cpfu]').css('padding', '9px 27px');
		$('input[id=cpfu]').css('text-transform', 'lowercase');
		$('input[id=cpfu]').css('width', '250px');	

	}	
		
	
	
	if (!($("#senha").val().length >= 3)
			|| ($("#senha").val() != $("#confirmar-senha").val())) {
		$("#senha").focus();
		$('input[id=senha]').css('background', '#fff');
		$('input[id=senha]').css('border', '1px solid red');
		$('input[id=senha]').css('color', '#000');
		$('input[id=senha]').css('border-radius', '30px');
		$('input[id=senha]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=senha]').css('font-size', '14px');
		$('input[id=senha]').css('margin-left', '24px');
		$('input[id=senha]').css('padding', '9px 27px');
		$('input[id=senha]').css('text-transform', 'lowercase');
		$('input[id=senha]').css('width', '250px');
		$('input[id=senha]').addClass('txtempty');
		$('input[id=senha]').attr('placeholder', 'digite uma senha v\u00e1lida!');

		$('input[id=confirmar-senha]').css('background', '#fff');
		$('input[id=confirmar-senha]').css('border', '1px solid red');
		$('input[id=confirmar-senha]').css('color', '#000');
		$('input[id=confirmar-senha]').css('border-radius', '30px');
		$('input[id=confirmar-senha]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=confirmar-senha]').css('font-size', '14px');
		$('input[id=confirmar-senha]').css('margin-left', '24px');
		$('input[id=confirmar-senha]').css('padding', '9px 27px');
		$('input[id=confirmar-senha]').css('text-transform', 'lowercase');
		$('input[id=confirmar-senha]').css('width', '250px');
		$('input[id=confirmar-senha]').addClass('txtempty');
		$('input[id=confirmar-senha]').attr('placeholder', 'digite uma confirma\u00e7\u00e3o de senha v\u00e1lida!');
		val = false;
	} else {
		$('input[id=senha]').css('background', '#fff');
		$('input[id=senha]').css('border', '1px solid #ccc');
		$('input[id=senha]').css('color', '#7e807a');
		$('input[id=senha]').css('border-radius', '30px');
		$('input[id=senha]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=senha]').css('font-size', '14px');
		$('input[id=senha]').css('margin-left', '24px');
		$('input[id=senha]').css('padding', '9px 27px');
		$('input[id=senha]').css('text-transform', 'lowercase');
		$('input[id=senha]').css('width', '250px');

		$('input[id=confirmar-senha]').css('background', '#fff');
		$('input[id=confirmar-senha]').css('border', '1px solid #ccc');
		$('input[id=confirmar-senha]').css('color', '#7e807a');
		$('input[id=confirmar-senha]').css('border-radius', '30px');
		$('input[id=confirmar-senha]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=confirmar-senha]').css('font-size', '14px');
		$('input[id=confirmar-senha]').css('margin-left', '24px');
		$('input[id=confirmar-senha]').css('padding', '9px 27px');
		$('input[id=confirmar-senha]').css('text-transform', 'lowercase');
		$('input[id=confirmar-senha]').css('width', '250px');

	}
	
	
	if (!$('input[name=sexo]').is(':checked')) {
		$("#sexo").focus();
		$('input[name=sexo]').css('outline-color', 'red');
		$('input[name=sexo]').css('outline-style', 'solid');
		$('input[name=sexo]').css('outline-width', 'thin');
		$('input[id=sexo]').css('outline-radius', '30px');
		val = false;
	} else {
		$('input[name=sexo]').css('outline-color', '');
		$('input[name=sexo]').css('outline-style', '');
		$('input[name=sexo]').css('outline-width', '');
	}

	if (val)
		enviar();

}

//
function validarForm_meu_perfil() {
	var val = true;
	if (!validarEmail()) {
		$("#e-mail").focus();
		val = false;
	}
	if (!($("#nome").val().length >= 2)) {
		$("#nome").focus();
		$('input[id=nome]').css('background', '#fff');
		$('input[id=nome]').css('border', '1px solid red');
		$('input[id=nome]').css('color', '#000');
		$('input[id=nome]').css('border-radius', '30px');
		$('input[id=nome]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=nome]').css('font-size', '14px');
		$('input[id=nome]').css('margin-left', '24px');
		$('input[id=nome]').css('padding', '9px 27px');
		$('input[id=nome]').css('text-transform', 'lowercase');
		$('input[id=nome]').css('width', '250px');
		val = false;
	} else {
		$('input[id=nome]').css('background', '#fff');
		$('input[id=nome]').css('border', '1px solid #ccc');
		$('input[id=nome]').css('color', '#7e807a');
		$('input[id=nome]').css('border-radius', '30px');
		$('input[id=nome]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=nome]').css('font-size', '14px');
		$('input[id=nome]').css('margin-left', '24px');
		$('input[id=nome]').css('padding', '9px 27px');
		$('input[id=nome]').css('text-transform', 'lowercase');
		$('input[id=nome]').css('width', '250px');
		$('input[id=nome]').addClass('txtempty');
		$('input[id=nome]').attr('placeholder', 'digite um nome v\u00e1lido!');
	}
	if (!($("#sobrenome").val().length >= 2)) {
		$("#sobrenome").focus();
		$('input[id=sobrenome]').css('background', '#fff');
		$('input[id=sobrenome]').css('border', '1px solid red');
		$('input[id=sobrenome]').css('color', '#000');
		$('input[id=sobrenome]').css('border-radius', '30px');
		$('input[id=sobrenome]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=sobrenome]').css('font-size', '14px');
		$('input[id=sobrenome]').css('margin-left', '24px');
		$('input[id=sobrenome]').css('padding', '9px 27px');
		$('input[id=sobrenome]').css('text-transform', 'lowercase');
		$('input[id=sobrenome]').css('width', '250px');
		$('input[id=sobrenome]').addClass('txtempty');
		$('input[id=sobrenome]').attr('placeholder', 'digite um sobrenome v\u00e1lido!');
		val = false;
	} else {
		$('input[id=sobrenome]').css('background', '#fff');
		$('input[id=sobrenome]').css('border', '1px solid #cc');
		$('input[id=sobrenome]').css('color', '#7e807a');
		$('input[id=sobrenome]').css('border-radius', '30px');
		$('input[id=sobrenome]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=sobrenome]').css('font-size', '14px');
		$('input[id=sobrenome]').css('margin-left', '24px');
		$('input[id=sobrenome]').css('padding', '9px 27px');
		$('input[id=sobrenome]').css('text-transform', 'lowercase');
		$('input[id=sobrenome]').css('width', '250px');
		
		
		
		
		
		

		if (!($("#data-nascimento").val().length >= 2)) {
			$("#data-nascimento").focus();
			$('input[id=data-nascimento]').css('background', '#fff');
			$('input[id=data-nascimento]').css('border', '1px solid red');
			$('input[id=data-nascimento]').css('color', '#000');
			$('input[id=data-nascimento]').css('border-radius', '30px');
			$('input[id=data-nascimento]').css('font-family',
					'flama-basic, Arial, Helvetica, sans-serif');
			$('input[id=data-nascimento]').css('font-size', '14px');
			$('input[id=data-nascimento]').css('margin-left', '24px');
			$('input[id=data-nascimento]').css('padding', '9px 27px');
			$('input[id=data-nascimento]').css('text-transform', 'lowercase');
			$('input[id=data-nascimento]').css('width', '250px');
			$('input[id=data-nascimento]').addClass('txtempty');
			$('input[id=data-nascimento]').attr('placeholder', 'digite uma data de nascimento v\u00e1lida!');
			val = false;
		} else {
			$('input[id=data-nascimento]').css('background', '#fff');
			$('input[id=data-nascimento]').css('border', '1px solid #cc');
			$('input[id=data-nascimento]').css('color', '#7e807a');
			$('input[id=data-nascimento]').css('border-radius', '30px');
			$('input[id=data-nascimento]').css('font-family',
					'flama-basic, Arial, Helvetica, sans-serif');
			$('input[id=data-nascimento]').css('font-size', '14px');
			$('input[id=data-nascimento]').css('margin-left', '24px');
			$('input[id=data-nascimento]').css('padding', '9px 27px');
			$('input[id=data-nascimento]').css('text-transform', 'lowercase');
			$('input[id=data-nascimento]').css('width', '250px');
		}
			
		
		
		
		
		
		
		
		
		
		
	}	
	
	var cpf = $("#cpf").val().replace('.', '');
	cpf = cpf.replace('-', '');
	if (!TestaCPF(cpf)) {
		$("#cpf").focus();
		$('input[id=cpf]').css('background', '#fff');
		$('input[id=cpf]').css('border', '1px solid red');
		$('input[id=cpf]').css('color', '#000');
		$('input[id=cpf]').css('border-radius', '30px');
		$('input[id=cpf]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=cpf]').css('font-size', '14px');
		$('input[id=cpf]').css('margin-left', '24px');
		$('input[id=cpf]').css('padding', '9px 27px');
		$('input[id=cpf]').css('text-transform', 'lowercase');
		$('input[id=cpf]').css('width', '250px');
		$('input[id=cpf]').addClass('txtempty');
		$('input[id=cpf]').attr('placeholder', 'digite um CPF v\u00e1lido!');
		val = false;
	} else {
		$('input[id=cpf]').css('background', '#fff');
		$('input[id=cpf]').css('border', '1px solid #cc');
		$('input[id=cpf]').css('color', '#7e807a');
		$('input[id=cpf]').css('border-radius', '30px');
		$('input[id=cpf]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=cpf]').css('font-size', '14px');
		$('input[id=cpf]').css('margin-left', '24px');
		$('input[id=cpf]').css('padding', '9px 27px');
		$('input[id=cpf]').css('text-transform', 'lowercase');
		$('input[id=cpf]').css('width', '250px');

	}
	if (!($("#senha").val().length >= 3)
			|| ($("#senha").val() != $("#confirmar-senha").val())) {
		$("#senha").focus();
		$('input[id=senha]').css('background', '#fff');
		$('input[id=senha]').css('border', '1px solid red');
		$('input[id=senha]').css('color', '#000');
		$('input[id=senha]').css('border-radius', '30px');
		$('input[id=senha]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=senha]').css('font-size', '14px');
		$('input[id=senha]').css('margin-left', '24px');
		$('input[id=senha]').css('padding', '9px 27px');
		$('input[id=senha]').css('text-transform', 'lowercase');
		$('input[id=senha]').css('width', '250px');
		$('input[id=senha]').addClass('txtempty');
		$('input[id=senha]').attr('placeholder', 'digite uma senha v\u00e1lida!');

		$('input[id=confirmar-senha]').css('background', '#fff');
		$('input[id=confirmar-senha]').css('border', '1px solid red');
		$('input[id=confirmar-senha]').css('color', '#000');
		$('input[id=confirmar-senha]').css('border-radius', '30px');
		$('input[id=confirmar-senha]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=confirmar-senha]').css('font-size', '14px');
		$('input[id=confirmar-senha]').css('margin-left', '24px');
		$('input[id=confirmar-senha]').css('padding', '9px 27px');
		$('input[id=confirmar-senha]').css('text-transform', 'lowercase');
		$('input[id=confirmar-senha]').css('width', '250px');
		$('input[id=confirmar-senha]').addClass('txtempty');
		$('input[id=confirmar-senha]').attr('placeholder', 'digite uma confirma\u00e7\u00e3o de senha v\u00e1lida!');
		val = false;
	} else {
		$('input[id=senha]').css('background', '#fff');
		$('input[id=senha]').css('border', '1px solid #ccc');
		$('input[id=senha]').css('color', '#7e807a');
		$('input[id=senha]').css('border-radius', '30px');
		$('input[id=senha]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=senha]').css('font-size', '14px');
		$('input[id=senha]').css('margin-left', '24px');
		$('input[id=senha]').css('padding', '9px 27px');
		$('input[id=senha]').css('text-transform', 'lowercase');
		$('input[id=senha]').css('width', '250px');

		$('input[id=confirmar-senha]').css('background', '#fff');
		$('input[id=confirmar-senha]').css('border', '1px solid #ccc');
		$('input[id=confirmar-senha]').css('color', '#7e807a');
		$('input[id=confirmar-senha]').css('border-radius', '30px');
		$('input[id=confirmar-senha]').css('font-family',
				'flama-basic, Arial, Helvetica, sans-serif');
		$('input[id=confirmar-senha]').css('font-size', '14px');
		$('input[id=confirmar-senha]').css('margin-left', '24px');
		$('input[id=confirmar-senha]').css('padding', '9px 27px');
		$('input[id=confirmar-senha]').css('text-transform', 'lowercase');
		$('input[id=confirmar-senha]').css('width', '250px');

	}
	if (!$('input[name=sexo]').is(':checked')) {
		$("#sexo").focus();
		$('input[name=sexo]').css('outline-color', 'red');
		$('input[name=sexo]').css('outline-style', 'solid');
		$('input[name=sexo]').css('outline-width', 'thin');
		$('input[id=sexo]').css('outline-radius', '30px');
		val = false;
	} else {
		$('input[name=sexo]').css('outline-color', '');
		$('input[name=sexo]').css('outline-style', '');
		$('input[name=sexo]').css('outline-width', '');
		$('#notification').fadeIn("slow").delay(3000).fadeOut("slow");
	}

	if (val)
		enviar_meu_perfil();

}



function enviar() {
	var frm = $('#form-dadosPessoais').serialize();
	
	ur = window.location;
	
	$.ajax({
		type : "POST",
		url : url + "?met=cad&url=http://"+window.location.host+"/GMMFormBuilder/cadastro/",
		data : frm,
		dataType : "html"
	}).done(function(msg) {
		if (msg == "ok") {
			nome = $("#nome").val();
			email = $("#e-mail").val();			
			abrir_pagina('2-cadastroNewsletter.html');
			
		} else {
			alert(msg);
		}
	})
}
function enviar_meu_perfil() {
	
	var frm = $('#form-dadosPessoais').serialize();
	$.ajax({
		type : "POST",
		url : url_meu_perfil + "?met=cad&url=http://"+window.location.host+"/GMMFormBuilder/cadastro/",
		data : frm,
		dataType : "html"
	}).done(function(msg) {
		if (msg == "ok") {
			abrir_pagina2('2-cadastroNewsletter.html');			
		} else {
			alert(msg);
		}
	});
}

function assinarNews(idNewsLetter) {
	var ur = window.location;
	ur = ur.toString();
	var n = ur.split("/");
	var uri = url;
	if(n[n.length-2]=="meu_perfil"){
		uri = url_meu_perfil;
	}else{
		uri = url;
	}
	jQuery.ajax({
		type : "POST",
		url : uri,
		dataType : "html",
		data : {
			met : "assinarNews",
			idNews : idNewsLetter,
			veiculo : idVeiculo
		},
		success : function(data) {
			if(n[n.length-2]=="meu_perfil"){
				getNews_meu_perfil();
			}else{
				getNews();
			}
			
			$("#content_news").slideUp(1000, function() {
				$("#content_news").empty();
				$("#content_news").append(data);
				$("#content_news").show(1000);
				
			});

		}
	});
}
function removerNews(idNewsLetter) {	
	var ur = window.location;
	ur = ur.toString();
	var n = ur.split("/");
	
	if(n[n.length-2]=="meu_perfil"){
		uri = url_meu_perfil;
	}else{
		uri = url;
	}
	jQuery.ajax({
		type : "POST",
		url : uri,
		dataType : "html",
		data : {
			met : "removerNews",
			idNews : idNewsLetter,
			veiculo : idVeiculo
		},
		success : function(data) {
			if(n[n.length-2]=="meu_perfil"){
				getNews_meu_perfil();
			}else{
				getNews();
			}
			$("#content_news").slideUp(1000, function() {
				$("#content_news").empty();
				$("#content_news").append(data);
				$("#content_news").show(1000);
				
				
			});

		}
	});
}
function abrir_pagina(url) {
	jQuery.ajax({
		type : "GET",
		url : url,
		dataType : "html",
		success : function(data) {
			var ur = window.location;
			ur = ur.toString();
			var n = ur.split("/");
			
			
			$("#content").slideUp(0, function() {
				$("#content").empty();
				$("#content").append(data);
				$("#content").show(0);

				if(n[n.length-2]!="meu_perfil"){
					if (url == "2-cadastroNewsletter.html" || url == "3-cadastroAplicativos.html" || "4-cadastroEventos.html"){
						document.getElementById('nome_cad').innerHTML = nome;
						document.getElementById('email_cad').innerHTML = email;
					}
					
				}
				if(n[n.length-2]!="meu_perfil"){				
					if(url == "2-cadastroNewsletter.html")
					getNews();
				}
				
			});

		}
	});
}


function abrir_pagina2(url) {
	jQuery.ajax({
		type : "GET",
		url : url,
		dataType : "html",
		success : function(data) {
			$("#content").slideUp(0, function() {
				$("#content").empty();
				$("#content").append(data);
				$("#content").show(0);
				getNews_meu_perfil();
			});

		}
	});
}
function TestaCPF(strCPF) {
	strCPF = strCPF.replace('.', '');
	strCPF = strCPF.replace(',', '');
	strCPF = strCPF.replace('-', '');
	var Soma;
	var Resto;
	Soma = 0;
	if (strCPF == "00000000000")
		return false;
	for (i = 1; i <= 9; i++)
		Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
	Resto = (Soma * 10) % 11;
	if ((Resto == 10) || (Resto == 11))
		Resto = 0;
	if (Resto != parseInt(strCPF.substring(9, 10)))
		return false;
	Soma = 0;
	for (i = 1; i <= 10; i++)
		Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
	Resto = (Soma * 10) % 11;
	if ((Resto == 10) || (Resto == 11))
		Resto = 0;
	if (Resto != parseInt(strCPF.substring(10, 11)))
		return false;
	return true;
}

function alerta_admin(largura, altura) {
	// window.scroll(0,0);

	pageWidth = $(document).width();
	pageHeight = $(document).height();

	var overlay = '<div id="overlay"></div>';
	var overlayCSS = {
			/*
		'width' : (largura - 30) + 'px',
		'height' : (altura - 30) + 'px',
		'left' : '0',
		'top' : '0',
		'background-color' : '#FFF',

		'left' : '0',
		'top' : '0',
		'position' : 'absolute',
		'opacity' : '0.6',
		'filter' : 'alpha(opacity=99)',
		'display' : 'none',
		'z-index' : '99999990'
		*/
		
	};
	var janela = '<div id="janela_modal"></div>';
	var janelaCSS = {
			/*
		'position' : 'absolute',
		'top' : '50%',
		'left' : '50%',
		'width' : largura - 15 + 'px',
		'height' : (altura) + 'px',
		'margin-left' : (((largura) / 2) * -1) + 'px',
		'margin-top' : ((altura / 2) * -1) + 'px',
		'background-color' : '#FFF',
		'padding' : '2px',
		'display' : 'none',
		'background-position' : '50% 50%',
		'opacity' : '0.9',
		'filter' : 'alpha(opacity=100)',
		'z-index' : '99999997',
		'color' : '#CCC',
		'-webkit-box-shadow' : '10px -10px 3px #EEE'
		*/
	};
	var cssinterno = {
		'opacity' : '1',
		'height' : '100px'
	}
	var iframe = "<table id='interno_pop' width='100%' height='180px'>	<tr>	<td align='right' valign='top' colspan='2'><a href='#' onclick='fechar()'><img src='img/FecharX.png' border=''0' 'alt='Fechar' title='Fechar'></img></a></td>	</tr>	<tr>		<td colspan='2' valign='bottom' align='center' height='80%' width='100%'></br>Usuário não cadastrado!</center></td>	</tr></table>";
	var iframe = '<iframe id="interno_pop" src="1-cadastroPerfil.html" height="'
			+ altura + 'px" width="100%" scrolling="yes"></iframe>';
	$("body").append(overlay);
	$("body").append(janela);
	$("#overlay").css(overlayCSS).fadeIn(0, function() {
	
		$("#janela_modal").append(iframe);
		
		// $("#interno_pop").css(cssinterno).fadeIn("fast", function(){});
		$("#janela_modal").css(janelaCSS).fadeIn(0, function() {
			
		});
	});
	if(met == 1){
//		alert(fn);
//		document.getElementById('nome').value=fn;
//		parent.document.getElementById('nome').innerHTML="koto";
//		var valor = $('#nome', window.parent.interno_pop.document).val('koto'); 
//		alert(valor);
//	 $(this).children("#interno_pop").fadeOut();
//		$("#nome").val(fn);
		
		}
//	getPorte();
//	getRamo();
//	getNivel();
//	getArea(); 

	


}

function alerta_meu_perfil() {
	// window.scroll(0,0);
//
	pageWidth2 = $(document).width();
	pageHeight2 = $(document).height();

	var overlay = '<div id="overlay"></div>';
	var overlayCSS = {
			/*
		'position' : 'absolute',
		'width' : (pageWidth2 - 30) + 'px',
		'height' : (pageHeight2 - 30) + 'px',
		'left' : '0',
		'top' : '0',
		'background-color' : '#FFF',

		'opacity' : '0.6',
		'filter' : 'alpha(opacity=99)',
		'display' : 'none',
		'z-index' : '99999990'
		*/
	};
	var janela = '<div id="janela_modal"></div>';
	var janelaCSS = {
			/*
		'position' : 'absolute',
		'top' : '50%',
		'left' : '50%',
		'width' : pageWidth2 - 15 + 'px',
		'height' : (pageHeight2) + 'px',
		'margin-left' : (((pageWidth2) / 2) * -1) + 'px',
		'margin-top' : ((pageHeight2 / 2) * -1) + 'px',
		'background-color' : '#FFF',
		'padding' : '2px',
		'display' : 'none',
		'background-position' : '50% 50%',
		'opacity' : '0.9',
		'filter' : 'alpha(opacity=100)',
		'z-index' : '99999997',
		'color' : '#CCC',
		'background' : '#f3f3f3'
		*/
	};
	var cssinterno = {
		'opacity' : '1',
		'height' : '100px'
	}
	var iframe = "<table id='interno_pop' width='100%' height='180px'>	<tr>	<td align='right' valign='top' colspan='2'><a href='#' onclick='fechar()'><img src='img/FecharX.png' border=''0' 'alt='Fechar' title='Fechar'></img></a></td>	</tr>	<tr>		<td colspan='2' valign='bottom' align='center' height='80%' width='100%'></br>Usuário não cadastrado!</center></td>	</tr></table>";
	var iframe = '<iframe id="interno_pop" src="meu_perfil/1-cadastroPerfil.html" height="'
			+ pageHeight2 + 'px" width="100%" scrolling="yes"></iframe>';
	$("body").append(overlay);
	$("body").append(janela);
	$("#overlay").css(overlayCSS).fadeIn("fast", function() {
		$("#janela_modal").append(iframe);
		// $("#interno_pop").css(cssinterno).fadeIn("fast", function(){});
		$("#janela_modal").css(janelaCSS).fadeIn("fast", function() {
		});
	});

}


function recupera_senha() {
	jQuery.ajax({
		type : "POST",
		url : url,
		dataType : "html",
		data : {
			met : "recupera_senha",
			email : $("#recupera_email").val(),
			veiculo : idVeiculo
		},
		success : function(data) {
			if(data=="false"){
				$("#ret_rec").html("<table id='interno_pop' width='410px' align='right'>" +
						"<tr><td align='right' valign='top'><a href='#' onclick='fechar()'><img src='images/fechar.png' border='0' alt='Fechar' title='Fechar' style='margin:0 -20px 0 0;''></a></td>	</tr>" +
						"<tr><td valign='bottom' align='center'  width='100%'>Usu&aacute;rio n&atilde;o cadastrado em nossa base.</td></tr></table>" +
						"");
			}else{
				
				$("#ret_rec").html("<table id='interno_pop' width='410px' align='right'>" +
						"<tr><td align='right' valign='top'><a href='#' onclick='fechar()'><img src='images/fechar.png' border=''0' 'alt='Fechar' title='Fechar' style='margin:0 -20px 0 0;' /></a></td>	</tr>" +
						"<tr><td valign='bottom' align='center'  width='100%'>Sua nova senha foi enviada para o email informado.</td></tr></table>" +
						"");
			}
			
			

		}
	});
}

function recupera_login() {
	jQuery.ajax({
		type : "POST",
		url : url,
		dataType : "html",
		data : {
			met : "recupera_login",
			cpf : $("#recupera_login").val(),
			veiculo : idVeiculo
		},
		success : function(data) {
			if(data=="|false"){
				$("#ret_rec").html("<table id='interno_pop' width='400px' align='right'>" +
						"<tr><td align='right' valign='top'><a href='#' onclick='fechar()'><img src='images/fechar.png' border=''0' 'alt='Fechar' title='Fechar' style='margin:0 -20px 0 0;' /></a></td>	</tr>" +
						"<tr><td valign='bottom' align='center'  width='100%'>CPF n&atilde;o cadastrado em nossa base.<br/>Por favor, clique em cadastre-se</td></tr></table>" +
						"");
			}else{
				txt = data.split("|");
				$("#ret_rec").html("<table id='interno_pop' width='400px' align='right'>" +
						"<tr><td align='right' valign='top'><a href='#' onclick='fechar()'><img src='images/fechar.png' border=''0' 'alt='Fechar' title='Fechar' style='margin:0 -20px 0 0;' /></a></td>	</tr>" +
						"<tr><td valign='bottom' align='center'  width='100%'>Login: "+txt[1]+".</td></tr></table>" +
						"");
			}
			
			

		}
	});
}

function alert_esqueci(largura, altura) {
	// window.scroll(0,0);

	pageWidth = $(document).width();
	pageHeight = $(document).height();

	var overlay = '<div id="overlay"></div>';
	var overlayCSS = {
			
		'position' : 'absolute',
		'width' : (largura - 30) + 'px',
		'height' : (altura - 30) + 'px',
		'left' : '0',
		'top' : '0',
		'background-color' : '#FFF',

		'opacity' : '0.6',
		'filter' : 'alpha(opacity=99)',
		'display' : 'none',
		'z-index' : '99999990'
		
	};
	var janela = '<div id="janela_modal"></div>';
	var janelaCSS = {
			
		'position' : 'absolute',
		'top' : '50%',
		'left' : '50%',
		'width' : '400px',
		'margin-left' : '-190px',
		'margin-top' : '-50px',
		'background-color' : '#FFF',
		'padding' : '0 20px 20px 20px',
		'display' : 'none',
		'background-position' : '50% 50%',
		'opacity' : '0.9',
		'filter' : 'alpha(opacity=100)',
		'z-index' : '99999997',
		'color' : '#333',
		'background' : '#f5f6f0',
		'border' : '6px solid #e7e8df',
		
		
	};
	var cssinterno = {
		'opacity' : '1',
		'height' : '100px'
	}
	var iframe = "<div id='ret_rec'><table id='interno_pop' valign='top' align='left'>	"
			+ "<tr><td align='right' valign='top' colspan='2'><a href='#' onclick='fechar()'><font color='#666' size='2' style='font-style:italic; font-size:14px;'>Fechar</h3></font></td>	</tr>	"
			+ "<tr><td valign='top' colspan='2'><h3 style='font-family: flama-semibold-italic, Arial, Helvetica, sans-serif; font-size: 19px'>Recuperar senha</h3><br/><p style='font-size: 14px;'>Uma mensagem ser&aacute; enviada para o seu e-mail com a sua nova senha.</p></td></tr><tr><td colspan='2' height='10'></td></tr><br/> "
			+ "<tr><td align='right' >Email:</td><td valign='bottom' align='center'  width='100%'> <input type='text' id='recupera_email' style='width: 300px; border-radius: 17px; border: 1px solid #bbb; font-size: 14px; padding: 8px 14px;' /></center></td></tr>"
			+ "<tr><td colspan='2' valign='bottom' align='center'  width='100%'><center><br/><input type='button' value='Recuperar Senha' id='recupera_btn' style='color: #fff!important; font-family: flamamedium-italic, Arial, Helvetica; text-transform: uppercase; font-size: 12px; border-radius: 30px; margin-left: 5px; padding: 9px 17px 9px 38px; border: none; cursor: pointer; background:#0462a0 url(images/next-white.png) 10px 8px no-repeat; float:right;' onClick='recupera_senha()'/></center></td>	</tr></table></div>";
	// var iframe = '<iframe id="interno_pop" src="1-cadastroPerfil.html"
	// height="'+altura+'px" width="100%" scrolling="yes"></iframe>';
	$("body").append(overlay);
	$("body").append(janela);
	$("#overlay").css(overlayCSS).fadeIn("fast", function() {
		$("#janela_modal").append(iframe);
		// $("#interno_pop").css(cssinterno).fadeIn("fast", function(){});
		$("#janela_modal").css(janelaCSS).fadeIn("fast", function() {
		});
	});

}

function alert_esqueci_login(largura, altura){
	pageWidth = $(document).width();
	pageHeight = $(document).height();

	var overlay = '<div id="overlay"></div>';
	var overlayCSS = {
			
		'position' : 'absolute',
		'width' : (largura - 30) + 'px',
		'height' : (altura - 30) + 'px',
		'left' : '0',
		'top' : '0',
		'background-color' : '#FFF',

		'opacity' : '0.6',
		'filter' : 'alpha(opacity=99)',
		'display' : 'none',
		'z-index' : '99999990'
		
	};
	var janela = '<div id="janela_modal"></div>';
	var janelaCSS = {
			
		'position' : 'absolute',
		'top' : '50%',
		'left' : '50%',
		'width' : '400px',
		'margin-left' : '-190px',
		'margin-top' : '-50px',
		'background-color' : '#FFF',
		'padding' : '0 20px 20px 20px',
		'display' : 'none',
		'background-position' : '50% 50%',
		'opacity' : '0.9',
		'filter' : 'alpha(opacity=100)',
		'z-index' : '99999997',
		'color' : '#333',
		'background' : '#f5f6f0',
		'border' : '6px solid #e7e8df',
		
		
	};
	var cssinterno = {
		'opacity' : '1',
		'height' : '100px'
	}
	var iframe = "<div id='ret_rec'><table id='interno_pop' valign='top' align='left'>	"
			+ "<tr><td align='right' valign='top' colspan='2'><a href='#' onclick='fechar()'><font color='#666' size='2' style='font-style:italic; font-size:14px;'>Fechar</h3></font></td>	</tr>	"
			+ "<tr><td valign='top' colspan='2'><h3 style='font-family: flama-semibold-italic, Arial, Helvetica, sans-serif; font-size: 19px'>Recuperar login</h3><br/><p style='font-size: 14px;'>Digite seu CPF cadastrado para recuperar seu login.<br/> Caso ainda n&atilde;o o tenha cadastrado, clique em inscreva-se.</p></td></tr><tr><td colspan='2' height='10'></td></tr><br/> "
			+ "<tr><td align='right' >CPF:</td><td valign='bottom' align='center'  width='100%'> <input type='text' id='recupera_login' style='width: 300px; border-radius: 17px; border: 1px solid #bbb; font-size: 14px; padding: 8px 14px;' /></center></td></tr>"
			+ "<tr><td colspan='2' valign='bottom' align='center'  width='100%'><center><br/><input type='button' value='Recuperar Login' id='recupera_btn_login' style='color: #fff!important; font-family: flamamedium-italic, Arial, Helvetica; text-transform: uppercase; font-size: 12px; border-radius: 30px; margin-left: 5px; padding: 9px 17px 9px 38px; border: none; cursor: pointer; background:#0462a0 url(images/next-white.png) 10px 8px no-repeat; float:right;' onClick='recupera_login()'/></center></td>	</tr></table></div>";
	// var iframe = '<iframe id="interno_pop" src="1-cadastroPerfil.html"
	// height="'+altura+'px" width="100%" scrolling="yes"></iframe>';
	$("body").append(overlay);
	$("body").append(janela);
	$("#overlay").css(overlayCSS).fadeIn("fast", function() {
		$("#janela_modal").append(iframe);
		// $("#interno_pop").css(cssinterno).fadeIn("fast", function(){});
		$("#janela_modal").css(janelaCSS).fadeIn("fast", function() {
		});
	});
	
}


function fechar() {
	// alert($(this).html());
	// $('#janela_modal').append('koto');
	parent.$('#janela_modal').fadeOut("fast", 0, function() {
		$(this).remove();
	});// PARA REMOVER O EFEITO
	parent.$('#overlay').fadeOut("fast", 0, function() {
		$(this).remove();
	});// PARA REMOVER O EFEITO
	redirectHome();
}

function VerificaLogin() {
	$.ajax({
		type : "POST",
		url : url,
		data : {
			met : "verificaLogin",
			veiculo : idVeiculo
		},
		dataType : "html"
	}).done(function(msg) {
		if (msg != "false" && msg != "")
			document.getElementById('div_login').innerHTML = msg;

		
	}).fail(function(jqXHR, textStatus) {
		// alert( "Request failed: " + textStatus );
	});

}

function logOut() {
	$.ajax({
		type : "POST",
		url : url,
		data : {
			met : "logOut"
		},
		dataType : "html"
	}).done(function(msg) {
		location.reload();
		redirectHome();
	}).fail(function(jqXHR, textStatus) {
		// alert( "Request failed: " + textStatus );
	});

}

function login_social() {
fechar_login_cad();
	

}
function login_LD() {
	parent.location = "../LD?url=" + window.location + "&veiculo="	+ idVeiculo+"&met=login_social_cad";
	parent.$('#janela_modal').fadeOut("fast", 0, function() {
		$(this).remove();
	});// PARA REMOVER O EFEITO
	parent.$('#overlay').fadeOut("fast", 0, function() {
		
		$(this).remove();
		
	});// PARA REMOVER O EFEITO

	}

function fechar_login_cad() {
	// alert($(this).html());
	// $('#janela_modal').append('koto');
	parent.location = "../LoginLD?url=" + window.location + "&veiculo="	+ idVeiculo+"&met=login_social_cad";
	parent.$('#janela_modal').fadeOut("fast", 0, function() {
		$(this).remove();
	});// PARA REMOVER O EFEITO
	parent.$('#overlay').fadeOut("fast", 0, function() {
		
		$(this).remove();
		
	});// PARA REMOVER O EFEITO
	
}
function redirectHome(){
	ur = window.location;
	if(ur.toString().indexOf("?")!=-1){
		uri = ur.toString().substring(0, ur.toString().indexOf("?"));
		location.href = uri;
	}
}

function alert_default(titulo,str){
	$("html, body").animate({ scrollTop: 0 }, 500);
	pageWidth = $(document).width();
	pageHeight = $(document).height();

	var overlay = '<div id="overlay"></div>';
	var overlayCSS = {
		'position' : 'absolute',
		'width' : (pageWidth - 30) + 'px',
		'height' : (pageHeight - 30) + 'px',
		'left' : '0',
		'top' : '0',
		'background-color' : '#FFF',

		'opacity' : '0.8',
		'filter' : 'alpha(opacity=99)',
		'display' : 'none',
		'z-index' : '99999990'
	};
	var janela = '<div id="janela_modal"></div>';
	var janelaCSS = {
		'position' : 'absolute',
		'top' : '50%',
		'left' : '50%',
		'width' : '400px',
		'margin-left' : '-190px',
		'margin-top' : '-50px',
		'background-color' : '#FFF',
		'padding' : '0 20px 20px 20px',
		'display' : 'none',
		'background-position' : '50% 50%',
		'opacity' : '0.9',
		'filter' : 'alpha(opacity=100)',
		'z-index' : '99999997',
		'color' : '#333',
		'background' : '#f5f6f0',
		'border' : '6px solid #e7e8df',
		
	};
	var cssinterno = {
		'opacity' : '1',
		'height' : '100px'
	}
	var iframe = "<div id='ret_rec'><table id='interno_pop' valign='top' align='left'>	"
			+ "<tr><td align='right' valign='top' width=460 colspan='2'><a href='#' onclick='fechar()'><font color='#666' size='2' style='font-style:italic; font-size:14px;'>Fechar</h3></font></td>	</tr>	"
			+ "<tr><td valign='top' colspan='2'><h3 style='font-family: flama-semibold-italic, Arial, Helvetica, sans-serif; font-size: 19px'>"+titulo+"</h3><br/><p style='font-size: 14px;'>"+str+"</p></td></tr><tr><td colspan='2' height='10'></td></tr><br/> "
			+ ""
			+ "</table></div>";
	// var iframe = '<iframe id="interno_pop" src="1-cadastroPerfil.html"
	// height="'+altura+'px" width="100%" scrolling="yes"></iframe>';
	$("body").append(overlay);
	$("body").append(janela);
	$("#overlay").css(overlayCSS).fadeIn("fast", function() {
		$("#janela_modal").append(iframe);
		// $("#interno_pop").css(cssinterno).fadeIn("fast", function(){});
		$("#janela_modal").css(janelaCSS).fadeIn("fast", function() {
		});
	});
	
}
$(window).load(function() {
	
	$(".account").click(function()
			{
			var y=$(this).attr('id');
	
			if(y==1)
			{
			$(".submenu").hide();
			$(this).attr('id', '0');	
			}
			else
			{
	
			$(".submenu").show(); 
			$(this).attr('id', '1');
			}
				
			});
	
			//Mouseup textarea false
			$(".submenu").mouseup(function()
			{
			return false;
			});
			$(".account").mouseup(function()
			{
			return false;
			});			
	});




$(window).load(function() {
	 
	
$(".account-perfil").live('click', function()
		
		{
		var y=$(this).attr('id');

		if(y==1)
		{
		$(".submenu-perfil").hide();
		$(this).attr('id', '0');	
		}
		else
		{

		$(".submenu-perfil").show();
		$(this).attr('id', '1');
		}
			
		});

		//Mouseup textarea false
		$(".submenu-perfil").mouseup(function()
		{
		return false;
		});
		$(".account-perfil").mouseup(function()
		{
		return false;
		});


		//Textarea without editing.
		$(document).mouseup(function()
		{
		$(".submenu-alert").hide();
		$(".account-perfil").attr('id', '');
		
		});	
				
		
		
		$(".account-alert").live('click', function()
				{
				var y=$(this).attr('id');

				if(y==1)
				{
				$(".submenu-alert").hide();
				$(this).attr('id', '0');	
				}
				else
				{

				$(".submenu-alert").show();
				$(this).attr('id', '1');
				}
					
				});

				//Mouseup textarea false
				$(".submenu-alert").mouseup(function()
				{
				return false;
				});
				$(".account-alert").mouseup(function()
				{
				return false;
				});
	
				
				//Textarea without editing.
				$(document).mouseup(function()
				{
				$(".submenu-perfil").hide();
				$(".account-alert").attr('id', '');
				
				});	
});




$(document).ready(function() {
	$("#disable").click(function (){
     
        // desabilitando o campo 
		$('.campo').attr("disabled", true);
        // mudando a cor do campo
        $('.campo').css("background-color", "#cccccc");
        $('#disable').hide();
        $('#disable1').show();
        
       
        
	});
    $("#disable1").click(function (){
     
        // desabilitando o campo 
		$('.campo').removeAttr('disabled');
         $('.campo').css("background-color", "#fff");
        $('#disable').attr("disabled", true);
        $('#disable1').hide();
        $('#disable').show();
        
        
       
        
	});
});

$(document).ready(function() {
	$("#disable2").click(function (){
     
        // desabilitando o campo 
		$('.campo1').attr("disabled", true);
        // mudando a cor do campo
        $('.campo1').css("background", "#cccccc");
        $('#disable2').hide();
        $('#disable3').show();
        
       
        
	});
    $("#disable3").click(function (){
     
        // desabilitando o campo 
		$('.campo1').removeAttr('disabled');
         $('.campo1').css("background-color", "#fff");
        $('#disable2').attr("disabled", true);
        $('#disable3').hide();
        $('#disable2').show();
        
        
       
        
	});
});
