
$(document).ready(function(){
	$('#form_validacao').validate({
		rules:{
			// O campo nome da ativação é de preenchimento obrigatório (required) e tamanho mínimo de 2 caracteres
			cidade:{
				required: true,
				minlength: 2
			},
			// O campo sobre Nome da ativação é de preenchimento obrigatório (required) e tamanho mínimo de 2 caracteres
			sobrenome:{
				required: true,
				minlength: 2
			},
			// O campo sobre empresa da ativação é de preenchimento obrigatório (required) e tamanho mínimo de 2 caracteres
			empresa:{
				required: true,
				minlength: 2
			},
			// O campo deve ser selecionado da ativação é de preenchimento obrigatório (required) e tamanho mínimo de 2 caracteres
			ramoati:{
				required: true,
				minlength: 2
			},
			// O campo Apelido da ativação é de preenchimento obrigatório (required) e tamanho mínimo de 2 caracteres
			apelido:{
				required: true,
				minlength: 2
			},
			// O campo Apelido da ativação é de preenchimento obrigatório (required) e tamanho mínimo de 2 caracteres
			cargo:{
				required: true,
				minlength: 2
			},
			// O campo Apelido da ativação é de preenchimento obrigatório (required) e tamanho mínimo de 2 caracteres
			telefonecomer:{
				required: true,
				minlength: 2
			},
			// O campo Nome é de preenchimento obrigatório (required) e tamanho mínimo de 2 caracteres
			nome:{
				required: true,
				minlength: 2
			},
			// O campo email segundario é de preenchimento obrigatório (required) e o email precisa ser válido
			mails: {
				required: true,
				email: true
			},
			// O campo Email é de preenchimento obrigatório (required) e o email precisa ser válido
			email: {
				required: true,
				email: true
			},
			// O campo Ramo de atividade, é de preenchimento obrigatório (required)
			ramo_ati: {
				required: true
			},
			// O campo selecione, é de preenchimento obrigatório (required)
			selecione_empre: {
				required: true
			},
			// O campo selecione, é de preenchimento obrigatório (required)
			selecione_nivel: {
				required: true
			},
			// O campo selecione, é de preenchimento obrigatório (required)
			selecione_atua: {
				required: true
			},
			// O campo Observação, é de preenchimento obrigatório (required)
			// 3 é o mínimo de caracteres e 10 é o máximo de caracteres que podem ser digitados
			comentarios: {
				required: true,
				minlength: 3,
				maxlength: 300
			},
			// O campo Senha é de preenchimento obrigatório (required)
			senha: {
				required: true
			},
			// O campo Confirma Senha é de preenchimento obrigatório (required) 
			// e deve ser igual ao campo Senha (equalTo)
			repete_senha:{
				required: true,
				equalTo: "#senha"
			},
			"pessoa.cpf" : {  
                cpf: 'both' //valida tanto Formatação como os Digitos  
                //caso não queira validar a formatação use => cpf: 'valid'  
                //caso só queira validar a formatação use => cpf: 'format'  
            },
			// O campo Termo é de preenchimento obrigatório (required) 
			example2: "required",
			faleconosco: "required"
		},
		// Aqui fica as mensagens de erro das regras acima,
		// que serão apresentadas caso alguma regra seja desobedecida
		messages:{
			cidade:{
				required: "*",
				minlength: "*"
			},
			sobrenome:{
				required: "*",
				minlength: "*"
			},
			empresa:{
				required: "O campo Empresa é obrigatório.",
				minlength: "O campo Nome deve conter no mínimo 3 caracteres."
			},
			ramoati:{
				required: "O campo precisa ser selecionado.",
			},
			apelido:{
				required: "O campo Apelido é obrigatório.",
				minlength: "O campo Nome deve conter no mínimo 3 caracteres."
			},
			telefonecomer:{
				required: "O campo Telefone é obrigatório.",
				minlength: "O campo Nome deve conter no mínimo 3 caracteres."
			},
			cargo:{
				required: "O campo cargo é obrigatório.",
				minlength: "O campo Cargo deve conter no mínimo 3 caracteres."
			},
			nome:{
				required: "*",
				minlength: "*"
			},
			email: {
				required: "*",
				email: "*"
			},
			mails: {
				required: " - Digite o email segundario.",
				email: " - O campo deve conter um email válido."
			},
			ramo_ati:{
				required: "Seleciona o Ramo de atividade."
			},
			selecione_empre:{
				required: "Seleciona o Porte da empresa."
			},
			selecione_nivel:{
				required: "Seleciona o Nível hierárquico."
			},
			selecione_atua:{
				required: "Seleciona a Área de atuação."
			},
			comentarios:{
				required: "O campo Observação é obrigatório.",
				minlength: "O campo Observação deve conter no mínimo 300 caracteres.",
				maxlength: "O campo Observação deve conter no máximo 300 caracteres."
			},
			senha: {
				required: "O campo Senha é obrigatório."
			},
			repete_senha:{
				required: "O campo Confirma Senha é obrigatório.",
				equalTo: "O campo Confirma Senha deve ser idêntico ao campo Senha."
			},
			example2: " - É necessário selecionar qual newsletter deseja receber.",
			faleconosco: " - É necessário selecionar qual departamento deseja falar"

		}

	});
});

$(document).ready(function() {

	
	$("#example2").prettyCheckbox({ 'class' : 'darkCheckbox' }); // overwrite the class
	

});
$(document).ready(function() {

	
	$("#example3").prettyCheckbox({ 'class' : 'darkCheckbox' }); // overwrite the class
	

});
