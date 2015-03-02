		function atualizacep() {
			var cep = document.getElementById('campo-cep').value;
			cep = cep.replace(/\D/g, "");
			document.getElementById('loadingCEP').style.display = "block";
			loadingCEP
			var methodURL = "http://cep.correiocontrol.com.br/" + cep + ".js";
			s = document.createElement('script')
			s.setAttribute('charset', 'utf-8')
			s.src = methodURL
			document.querySelector('head').appendChild(s)
		}

		function correiocontrolcep(valor) {
			if (valor.erro) {
				alert('Cep não encontrado');
				return;
			};
			document.getElementById('logradouro').value = valor.logradouro
			document.getElementById('bairro').value = valor.bairro
			document.getElementById('cidade').value = valor.localidade
			document.getElementById('estado').value = valor.uf
			document.getElementById('pais').value = 'Brasil'
			document.getElementById('loadingCEP').style.display = "none"
		}
		
		/*Campo sobreNome */
		document.addEventListener("DOMContentLoaded", function() {
	      var elements = document.getElementsByClassName("nome");
	      for (var i = 0; i < elements.length; i++) {
	          elements[i].oninvalid = function(e) {
	              e.target.setCustomValidity("");
	              if (!e.target.validity.valid) {
	                  e.target.setCustomValidity("Preencha seu Nome!");
	              }
	          };
	          elements[i].oninput = function(e) {
	              e.target.setCustomValidity("");
	          };
	      }
	  });
		
	/* Campo sobreNome */
		document.addEventListener("DOMContentLoaded", function() {
		      var elements = document.getElementsByClassName("sobreNome");
		      for (var i = 0; i < elements.length; i++) {
		          elements[i].oninvalid = function(e) {
		              e.target.setCustomValidity("");
		              if (!e.target.validity.valid) {
		                  e.target.setCustomValidity("Preencha esse Sobrenome!");
		              }
		          };
		          elements[i].oninput = function(e) {
		              e.target.setCustomValidity("");
		          };
		      }
		  });
		
		/* Campo Email */
		document.addEventListener("DOMContentLoaded", function() {
		      var elements = document.getElementsByClassName("email");
		      for (var i = 0; i < elements.length; i++) {
		          elements[i].oninvalid = function(e) {
		              e.target.setCustomValidity("");
		              if (!e.target.validity.valid) {
		                  e.target.setCustomValidity("Preencha seu Email!");
		              }
		          };
		          elements[i].oninput = function(e) {
		              e.target.setCustomValidity("");
		          };
		      }
		  });
			
		/* Campo Telefone*/
		document.addEventListener("DOMContentLoaded", function() {
		      var elements = document.getElementsByClassName("tel");
		      for (var i = 0; i < elements.length; i++) {
		          elements[i].oninvalid = function(e) {
		              e.target.setCustomValidity("");
		              if (!e.target.validity.valid) {
		                  e.target.setCustomValidity("Preencha seu Telefone!");
		              }
		          };
		          elements[i].oninput = function(e) {
		              e.target.setCustomValidity("");
		          };
		      }
		  });
		
		
		/* Campo Telefone Comercial*/
		document.addEventListener("DOMContentLoaded", function() {
		      var elements = document.getElementsByClassName("telcom");
		      for (var i = 0; i < elements.length; i++) {
		          elements[i].oninvalid = function(e) {
		              e.target.setCustomValidity("");
		              if (!e.target.validity.valid) {
		                  e.target.setCustomValidity("Preencha o Telefone comercial!");
		              }
		          };
		          elements[i].oninput = function(e) {
		              e.target.setCustomValidity("");
		          };
		      }
		  });
		
		/* Campo Telefone Comercial*/
		document.addEventListener("DOMContentLoaded", function() {
		      var elements = document.getElementsByClassName("cel");
		      for (var i = 0; i < elements.length; i++) {
		          elements[i].oninvalid = function(e) {
		              e.target.setCustomValidity("");
		              if (!e.target.validity.valid) {
		                  e.target.setCustomValidity("Preencha seu Celular!");
		              }
		          };
		          elements[i].oninput = function(e) {
		              e.target.setCustomValidity("");
		          };
		      }
		  });
		
		/* Campo data de nascimento*/
		document.addEventListener("DOMContentLoaded", function() {
		      var elements = document.getElementsByClassName("data");
		      for (var i = 0; i < elements.length; i++) {
		          elements[i].oninvalid = function(e) {
		              e.target.setCustomValidity("");
		              if (!e.target.validity.valid) {
		                  e.target.setCustomValidity("Preencha a Data de Nascimento!");
		              }
		          };
		          elements[i].oninput = function(e) {
		              e.target.setCustomValidity("");
		          };
		      }
		  });
		
		/* Campo data de numero*/
		document.addEventListener("DOMContentLoaded", function() {
		      var elements = document.getElementById("num");
		      for (var i = 0; i < elements.length; i++) {
		          elements[i].oninvalid = function(e) {
		              e.target.setCustomValidity("");
		              if (!e.target.validity.valid) {
		                  e.target.setCustomValidity("Preencha o Numero!");
		              }
		          };
		          elements[i].oninput = function(e) {
		              e.target.setCustomValidity("");
		          };
		      }
		  });
		
		/*Campo razao social*/
		document.addEventListener("DOMContentLoaded", function() {
	      var elements = document.getElementsByClassName("razaoS");
	      for (var i = 0; i < elements.length; i++) {
	          elements[i].oninvalid = function(e) {
	              e.target.setCustomValidity("");
	              if (!e.target.validity.valid) {
	                  e.target.setCustomValidity("Preencha esse Campo!");
	              }
	          };
	          elements[i].oninput = function(e) {
	              e.target.setCustomValidity("");
	          };
	      }
	  });
		
		/*Campo nome Fantasia */
		document.addEventListener("DOMContentLoaded", function() {
	      var elements = document.getElementsByClassName("fantasia");
	      for (var i = 0; i < elements.length; i++) {
	          elements[i].oninvalid = function(e) {
	              e.target.setCustomValidity("");
	              if (!e.target.validity.valid) {
	                  e.target.setCustomValidity("Preencha o Nome Fantasia!");
	              }
	          };
	          elements[i].oninput = function(e) {
	              e.target.setCustomValidity("");
	          };
	      }
	  });
		
		/*Campo nome CNPJ */
		document.addEventListener("DOMContentLoaded", function() {
	      var elements = document.getElementsByClassName("cnpj");
	      for (var i = 0; i < elements.length; i++) {
	          elements[i].oninvalid = function(e) {
	              e.target.setCustomValidity("");
	              if (!e.target.validity.valid) {
	                  e.target.setCustomValidity("Preencha o CNPJ!");
	              }
	          };
	          elements[i].oninput = function(e) {
	              e.target.setCustomValidity("");
	          };
	      }
	  });
		
		function TestaCPF(cpf) {
			cpf = cpf.replace(/[^\d]+/g,'');

			if(cpf == '') return false;

			// Elimina CPFs invalidos conhecidos
			if (cpf.length != 11 || cpf == "00000000000" || cpf == "11111111111" || cpf == "22222222222" || cpf == "33333333333" || cpf == "44444444444" || cpf == "55555555555" || cpf == "66666666666" || cpf == "77777777777" || cpf == "88888888888" || cpf == "99999999999")
				return false;
			
			// Valida 1o digito
			add = 0;
			for (i=0; i < 9; i ++)
				add += parseInt(cpf.charAt(i)) * (10 - i);
			rev = 11 - (add % 11);
			if (rev == 10 || rev == 11)
				rev = 0;
			if (rev != parseInt(cpf.charAt(9)))
				return false;
			
			// Valida 2o digito
			add = 0;
			for (i = 0; i < 10; i ++)
				add += parseInt(cpf.charAt(i)) * (11 - i);
			rev = 11 - (add % 11);
			if (rev == 10 || rev == 11)
				rev = 0;
			if (rev != parseInt(cpf.charAt(10)))
				return false;
				
			return true;
		}

		function validarCPF() {
			var methodURL= "validarCPF"
			var cpf = document.getElementById("cpf").value;
			cpf = cpf.replace(/\./g,'');
			cpf = cpf.replace(/-/g,'');
			if (TestaCPF(cpf)) {
				$.ajax({
					type : "POST",
					url : methodURL,
					data : "cpf="+cpf,
					success : function(response) {
						if (response == "true") {
							document.getElementById("cpf").className = "borda-validacao";
							//alert("CPF Já esta cadastrado!!!");
						} else {
							document.getElementById("cpf").className = "";
						}
					},
					error : function(e) {
						console.log("Falha ao carregar os Dados");
					}
				});	
			} else {
				document.getElementById("cpf").className = "borda-validacao";
				//alert("CPF invalido");
			}
			
		}
		
		function validarEmail() {
			var methodURL= "validarEmail"
			var email = document.getElementById("email").value;
				$.ajax({
					type : "POST",
					url : methodURL,
					data : "email="+email,
					success : function(response) {
						if (response == "true") {
							document.getElementById("email").className = "borda-validacao";
						} else {
							document.getElementById("email").className = "";
						}
					},
					error : function(e) {
						console.log("Falha ao carregar os Dados");
					}
				});	
		}
		
		function validarEmailSecundario() {
			var methodURL= "validarEmail"
			var email = document.getElementById("email").value;
			var emailSec = document.getElementById("emailSec").value;
			
			if (email == emailSec) {
				document.getElementById("emailSec").className = "borda-validacao";
			} else {
				$.ajax({
					type : "POST",
					url : methodURL,
					data : "email="+emailSec,
					success : function(response) {
						if (response == "true") {
							document.getElementById("emailSec").className = "borda-validacao";
						} else {
							document.getElementById("emailSec").className = "";
						}
					},
					error : function(e) {
						console.log("Falha ao carregar os Dados");
					}
				});
			}
		}
		
		function localizarResponsavel() {
			var methodURL= "localizarResponsavel"
			var cpf = document.getElementById("cpf").value;
			cpf = cpf.replace(/\./g,'');
			cpf = cpf.replace(/-/g,'');
			
			$.ajax({
				type : "POST",
				url : methodURL,
				data : "CPF="+cpf,
				success : function(response) {
					$("#localizarResposanvel").html(response);
				},
				error : function(e) {
					alert("Falha ao carregar os Dados");
				}
			});
		}
		
		function validarCNPJ() {
			var methodURL= "validarCNPJ"
			var cnpj = document.getElementById("cnpj").value;
			$.ajax({
				type : "POST",
				url : methodURL,
				data : "cnpj="+cnpj,
				success : function(response) {
					if (response == "true") {
						alert("CNPJ Já esta cadastrado!!!");
					}
				},
				error : function(e) {
					alert("Falha ao carregar os Dados");
				}
			});
		}