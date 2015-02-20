<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Grupo M&amp;M - Cadastro Pessoa Física</title>
	<%@ include file="componentes/header/head.jsp" %>
	<script type="text/javascript">
		function atualizacep() {
			var cep = document.getElementById('campo-cep').value;
			cep = cep.replace(/\D/g, "");
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
		}
	</script>
</head>

<body>
	<div id="content">
		<%@ include file="componentes/header/menu-bar.jsp" %>
			<h1 class="txt-cfechado">
			Assinaturas <span class="raquo">&raquo;</span>
		</h1>
			<div class="content-cadastro">
				<!-- MENU TOPO DE NAVEGAÃ‡ÃƒO -->
				<form action="/GrupoMMDBM/dbm/cadastrar-usuario/salvar" method="POST">
					<div class="column">
						<div class="form-perfil form-profissional">
							<h3>
							<strong class="icon-lado"></strong>Dados Perfil
						</h3>
							<div class="input-box">
								<label style="padding-top: 10px">Nome</label>
								<input type="text" name="nome" maxlength="200" placeholder="Digite seu nome!" /> </div>
							<!-- end input-box -->
							<div class="input-box">
								<label style="padding-top: 10px">Sobrenome</label>
								<input type="text" name="sobrenome" maxlength="200" placeholder="Digite seu Sobrenome" /> </div>
							<!-- end input-box -->
							<div class="input-box">
								<div id="notification"></div>
								<label>Sexo</label>
								<input type="radio" id="sexoF" name="sexo" value="F" /><span class="text-radio">Feminino</span>
								<input type="radio" id="sexoM" name="sexo" value="M" /><span class="text-radio">Masculino</span> </div>
							<!-- end input-box -->
							<div class="input-box">
								<label style="padding-top: 10px">CPF</label>
								<input type="text" name="CPF" value="" placeholder="Digite seu CPF" /> </div>
							<!-- end input-box -->
							<div class="input-box">
								<label style="padding-top: 10px">E-mail</label>
								<input type="text" name="email" maxlength="100" placeholder="Digite seu e-mail" /> </div>
							<!-- end input-box -->
							<div class="input-box">
								<label style="padding-top: 10px">E-mail Segundario</label>
								<input type="text" name="emailSecundario" maxlength="200" placeholder="Digite um e-mail alternativo" /> </div>
							<!-- end input-box -->
							<br />
							<br />
							<br /> </div>
						<!-- end form-perfil -->
						<!-- ENDEREÃ‡O DE ENTREGA -->
						<div class="form-endereco" id='form-endereco'>
							<h4>&nbsp;</h4>
							<div class="input-box">
								<label style="padding-top: 10px">Telefone</label>
								<input type="text" name="telefoneResidencial" maxlength="200" placeholder="Digite Telefone" /> </div>
							<!-- end input-box -->
							<div class="input-box">
								<label style="padding-top: 10px">Telefone Comercial</label>
								<input type="text" name="telefoneComercial" maxlength="200" placeholder="Digite Telefone Comercial" /> </div>
							<!-- end input-box -->
							<div class="input-box">
								<label style="padding-top: 10px">Celular</label>
								<input type="text" name="celular" maxlength="200" placeholder="Digite Celular" /> </div>
							<!-- end input-box -->
							<div class="input-box">
								<label for="data">Data de nascimento</label>
								<input type="text" name="dtNascimento" placeholder="Digite sua data de nescimento" class="data" /> </div>
						</div>
					</div>
					<div class="column2">
						<div class="form-profissional" id="form-profissional">
							<h5>
								<strong class="icon-lado"></strong>Endereço Residencial
							</h5>
							<div class="input-box">
								<label for="cep" style="padding-top: 10px">CEP</label>
								<input class="cep campo inputNcep" id="campo-cep" type="text" name="enderecoResidencial.cep" onblur="atualizacep()" placeholder="Digite seu cep" /> <span class="localizarCep"><a href="#"
								onclick="atualizacep()">Localizar Cep</a></span> </div>
							<!-- end input-box -->
							<div class="input-box">
								<label for="logradouro" style="padding-top: 10px">Logradouro</label>
								<input class="campo" type="text" id="logradouro" name="enderecoResidencial.logradouro" /> </div>
							<!-- end input-box -->
							<div class="input-box">
								<label for="numero" style="padding-top: 10px">Número</label>
								<input class="campo" type="text" name="enderecoResidencial.numero" /> </div>
							<!-- end input-box -->
							<div class="input-box">
								<label for="numero" style="padding-top: 10px">Complemento</label>
								<input class="campo" type="text" name="enderecoResidencial.complemento" /> </div>
							<!-- end input-box -->
						</div>
						<!-- end form-profissional -->
						<!-- ENDEREÃ‡O DE ENTREGA -->
						<div class="form-endereco" id='form-endereco'>
							<h4>&nbsp;</h4>
							<div class="input-box">
								<label for="bairro" style="padding-top: 10px">Bairro</label>
								<input class="campo" type="text" id="bairro" name="enderecoResidencial.bairro" /> </div>
							<!-- end input-box -->
							<div class="input-box">
								<label for="cidade" style="padding-top: 10px">Cidade</label>
								<input class="campo" type="text" id="cidade" name="enderecoResidencial.cidade" /> </div>
							<!-- end input-box -->
							<div class="input-box">
								<label for="estado" style="padding-top: 10px">Estado</label>
								<select name="enderecoResidencial.estado" id="estado">
									<option value="">Selecione</option>
									<option value="AC">Acre</option>
									<option value="AL">Alagoas</option>
									<option value="AP">Amapá</option>
									<option value="AM">Amazonas</option>
									<option value="BA">Bahia</option>
									<option value="CE">Ceará</option>
									<option value="DF">Distrito Federal</option>
									<option value="ES">Espirito Santo</option>
									<option value="GO">Goiás</option>
									<option value="MA">Maranhão</option>
									<option value="MS">Mato Grosso do Sul</option>
									<option value="MT">Mato Grosso</option>
									<option value="MG">Minas Gerais</option>
									<option value="PA">Pará</option>
									<option value="PB">Paraíba</option>
									<option value="PR">Paraná</option>
									<option value="PE">Pernambuco</option>
									<option value="PI">Piauí</option>
									<option value="RJ">Rio de Janeiro</option>
									<option value="RN">Rio Grande do Norte</option>
									<option value="RS">Rio Grande do Sul</option>
									<option value="RO">Rondônia</option>
									<option value="RR">Roraima</option>
									<option value="SC">Santa Catarina</option>
									<option value="SP">São Paulo</option>
									<option value="SE">Sergipe</option>
									<option value="TO">Tocantins</option>
								</select>
							</div>
							<!-- end input-box -->
							<div class="input-box">
								<label for="pais" style="padding-top: 10px">País</label>
								<select class="campopais" id="pais" name="enderecoResidencial.pais">
									<option value="">Selecione</option>
									<option value="África do Sul">África do Sul</option>
									<option value="Albânia">Albânia</option>
									<option value="Alemanha">Alemanha</option>
									<option value="Andorra">Andorra</option>
									<option value="Angola">Angola</option>
									<option value="Anguilla">Anguilla</option>
									<option value="Antigua">Antigua</option>
									<option value="Arábia Saudita">Arábia Saudita</option>
									<option value="Argentina">Argentina</option>
									<option value="Armênia">Armênia</option>
									<option value="Aruba">Aruba</option>
									<option value="Austrália">Austrália</option>
									<option value="Áustria">Áustria</option>
									<option value="Azerbaijão">Azerbaijão</option>
									<option value="Bahamas">Bahamas</option>
									<option value="Bahrein">Bahrein</option>
									<option value="Bangladesh">Bangladesh</option>
									<option value="Barbados">Barbados</option>
									<option value="Bélgica">Bélgica</option>
									<option value="Benin">Benin</option>
									<option value="Bermudas">Bermudas</option>
									<option value="Botsuana">Botsuana</option>
									<option value="Brasil">Brasil</option>
									<option value="Brunei">Brunei</option>
									<option value="Bulgária">Bulgária</option>
									<option value="Burkina Fasso">Burkina Fasso</option>
									<option value="botão">botão</option>
									<option value="Cabo Verde">Cabo Verde</option>
									<option value="Camarões">Camarões</option>
									<option value="Camboja">Camboja</option>
									<option value="Canadá">Canadá</option>
									<option value="Cazaquistão">Cazaquistão</option>
									<option value="Chade">Chade</option>
									<option value="Chile">Chile</option>
									<option value="China">China</option>
									<option value="Cidade do Vaticano">Cidade do Vaticano</option>
									<option value="Colômbia">Colômbia</option>
									<option value="Congo">Congo</option>
									<option value="Coréia do Sul">Coréia do Sul</option>
									<option value="Costa do Marfim">Costa do Marfim</option>
									<option value="Costa Rica">Costa Rica</option>
									<option value="Croácia">Croácia</option>
									<option value="Dinamarca">Dinamarca</option>
									<option value="Djibuti">Djibuti</option>
									<option value="Dominica">Dominica</option>
									<option value="EUA">EUA</option>
									<option value="Egito">Egito</option>
									<option value="El Salvador">El Salvador</option>
									<option value="Emirados Árabes">Emirados Árabes</option>
									<option value="Equador">Equador</option>
									<option value="Eritréia">Eritréia</option>
									<option value="Escócia">Escócia</option>
									<option value="Eslováquia">Eslováquia</option>
									<option value="Eslovênia">Eslovênia</option>
									<option value="Espanha">Espanha</option>
									<option value="Estônia">Estônia</option>
									<option value="Etiópia">Etiópia</option>
									<option value="Fiji">Fiji</option>
									<option value="Filipinas">Filipinas</option>
									<option value="Finlândia">Finlândia</option>
									<option value="França">França</option>
									<option value="Gabão">Gabão</option>
									<option value="Gâmbia">Gâmbia</option>
									<option value="Gana">Gana</option>
									<option value="Geórgia">Geórgia</option>
									<option value="Gibraltar">Gibraltar</option>
									<option value="Granada">Granada</option>
									<option value="Grécia">Grécia</option>
									<option value="Guadalupe">Guadalupe</option>
									<option value="Guam">Guam</option>
									<option value="Guatemala">Guatemala</option>
									<option value="Guiana">Guiana</option>
									<option value="Guiana Francesa">Guiana Francesa</option>
									<option value="Guiné-bissau">Guiné-bissau</option>
									<option value="Haiti">Haiti</option>
									<option value="Holanda">Holanda</option>
									<option value="Honduras">Honduras</option>
									<option value="Hong Kong">Hong Kong</option>
									<option value="Hungria">Hungria</option>
									<option value="Iêmen">Iêmen</option>
									<option value="Ilhas Cayman">Ilhas Cayman</option>
									<option value="Ilhas Cook">Ilhas Cook</option>
									<option value="Ilhas Curaçao">Ilhas Curaçao</option>
									<option value="Ilhas Marshall">Ilhas Marshall</option>
									<option value="Ilhas Turks & Caicos">Ilhas Turks &amp; Caicos</option>
									<option value="Ilhas Virgens (brit.)">Ilhas Virgens (brit.)</option>
									<option value="Ilhas Virgens(amer.)">Ilhas Virgens(amer.)</option>
									<option value="Ilhas Wallis e Futuna">Ilhas Wallis e Futuna</option>
									<option value="Índia">Índia</option>
									<option value="Indonésia">Indonésia</option>
									<option value="Inglaterra">Inglaterra</option>
									<option value="Irlanda">Irlanda</option>
									<option value="Islândia">Islândia</option>
									<option value="Israel">Israel</option>
									<option value="Itália">Itália</option>
									<option value="Jamaica">Jamaica</option>
									<option value="Japão">Japão</option>
									<option value="Jordânia">Jordânia</option>
									<option value="Kuwait">Kuwait</option>
									<option value="Latvia">Latvia</option>
									<option value="Líbano">Líbano</option>
									<option value="Liechtenstein">Liechtenstein</option>
									<option value="Lituânia">Lituânia</option>
									<option value="Luxemburgo">Luxemburgo</option>
									<option value="Macau">Macau</option>
									<option value="Macedônia">Macedônia</option>
									<option value="Madagascar">Madagascar</option>
									<option value="Malásia">Malásia</option>
									<option value="Malaui">Malaui</option>
									<option value="Mali">Mali</option>
									<option value="Malta">Malta</option>
									<option value="Marrocos">Marrocos</option>
									<option value="Martinica">Martinica</option>
									<option value="Mauritânia">Mauritânia</option>
									<option value="Mauritius">Mauritius</option>
									<option value="México">México</option>
									<option value="Moldova">Moldova</option>
									<option value="Mônaco">Mônaco</option>
									<option value="Montserrat">Montserrat</option>
									<option value="Nepal">Nepal</option>
									<option value="Nicarágua">Nicarágua</option>
									<option value="Niger">Niger</option>
									<option value="Nigéria">Nigéria</option>
									<option value="Noruega">Noruega</option>
									<option value="Nova Caledônia">Nova Caledônia</option>
									<option value="Nova Zelândia">Nova Zelândia</option>
									<option value="Omã">Omã</option>
									<option value="Palau">Palau</option>
									<option value="Panamá">Panamá</option>
									<option value="Papua-nova Guiné">Papua-nova Guiné</option>
									<option value="Paquistão">Paquistão</option>
									<option value="Peru">Peru</option>
									<option value="Polinésia Francesa">Polinésia Francesa</option>
									<option value="Polônia">Polônia</option>
									<option value="Porto Rico">Porto Rico</option>
									<option value="Portugal">Portugal</option>
									<option value="Qatar">Qatar</option>
									<option value="Quênia">Quênia</option>
									<option value="Rep. Dominicana">Rep. Dominicana</option>
									<option value="Rep. Tcheca">Rep. Tcheca</option>
									<option value="Reunion">Reunion</option>
									<option value="Romênia">Romênia</option>
									<option value="Ruanda">Ruanda</option>
									<option value="Rússia">Rússia</option>
									<option value="Saipan">Saipan</option>
									<option value="Samoa Americana">Samoa Americana</option>
									<option value="Senegal">Senegal</option>
									<option value="Serra Leone">Serra Leone</option>
									<option value="Seychelles">Seychelles</option>
									<option value="Singapura">Singapura</option>
									<option value="Síria">Síria</option>
									<option value="Sri Lanka">Sri Lanka</option>
									<option value="St. Kitts & Nevis">St. Kitts &amp; Nevis</option>
									<option value="St. Lúcia">St. Lúcia</option>
									<option value="St. Vincent">St. Vincent</option>
									<option value="Sudão">Sudão</option>
									<option value="Suécia">Suécia</option>
									<option value="Suiça">Suiça</option>
									<option value="Suriname">Suriname</option>
									<option value="Tailândia">Tailândia</option>
									<option value="Taiwan">Taiwan</option>
									<option value="Tanzânia">Tanzânia</option>
									<option value="Togo">Togo</option>
									<option value="Trinidad & Tobago">Trinidad &amp; Tobago</option>
									<option value="Tunísia">Tunísia</option>
									<option value="Turquia">Turquia</option>
									<option value="Ucrânia">Ucrânia</option>
									<option value="Uganda">Uganda</option>
									<option value="Uruguai">Uruguai</option>
									<option value="Venezuela">Venezuela</option>
									<option value="Vietnã">Vietnã</option>
									<option value="Zaire">Zaire</option>
									<option value="Zâmbia">Zâmbia</option>
									<option value="Zimbábue">Zimbábue</option>
								</select>
							</div>
							<!-- end input-box -->
						</div>
						<!-- end form-endereco -->
					</div>
					<!-- end column-right -->
					<!-- BotÃµes Continuar depois / Prosseguir -->
					<div style="clear: both;"></div>
					<div class="btn-cadastro">
						<input type="submit" class="btn-prosseguir" value="Finalizar"> </div>
					<!-- end btn-cadastro -->
				</form>
				<!-- Fim do Form -->
			</div>
			<!-- content-cadastro -->
	</div>
</body>

</html>