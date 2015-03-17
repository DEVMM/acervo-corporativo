<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ include file="../componentes/header/head.jsp"%>
<form action="/GrupoMMDBM/solicitacoes/novaAssinatura" name="cadastro" method="POST">
<div class="column2">
	<a class="close-reveal-modal closeCad">&#215;</a>
	<div class="form-profissional" id="form-profissional">
		<h5>
			<strong class="icon-lado"></strong>Adicionar Nova Assinatura
		</h5>
		<div class="input-box">
			<label for="empresa" class="espacoNNN">Nome</label> <input
				type="text" name="nome" placeholder="Digite seu nome!" />
		</div>
		<!-- end input-box -->
		<div class="input-box">
			<label for="empresa" class="espacoNNN">Sobrenome</label> <input
				type="text" name="sobrenome" placeholder="Digite seu Sobre Nome" />
		</div>
	</div>
	<div class="form-endereco" id='form-endereco'>
		<h4>&nbsp;</h4>
		<!-- end input-box -->
		<div class="input-box">
			<label for="e-mail" class="espacoNNN">E-mail</label> <input
				type="text" name="email" placeholder="Digite seu e-mail" /> <input
				type="hidden" name="principal" value="1">
		</div>
		<div class="input-box">
			<label for="e-mail" class="espacoNNN">CPF</label> <input type="text"
				name="CPF" class="cpf" placeholder="Digite seu e-mail" />
		</div>
	</div>
</div>
<!-- end input-box -->
<br clear="all" />

<div class="column2">
	<div class="form-profissional" id="form-profissional">
		<h5>
			<strong class="icon-lado"></strong>Endere�o de Entrega
		</h5>
		<div id="loadingCEP" style="display: none">
								<img alt="" src="${myUrl}resources/images/AjaxLoader.gif">
							</div>
		<div class="input-box">
			<label for="cep" style="padding-top: 10px">CEP</label> <input
				class="cep campo inputNcep" id="campo-cep" type="text"
				name="enderecoEntrega.cep" onblur="atualizacep()"
				placeholder="Digite seu cep" /> <span class="localizarCep"><a
				href="#" onclick="atualizacep()">Localizar Cep</a></span>
		</div>
		<!-- end input-box -->
		<div class="input-box">
			<label for="logradouro" style="padding-top: 10px">Logradouro</label>
			<input class="campo" type="text" id="logradouro"
				name="enderecoEntrega.logradouro" />
		</div>
		<!-- end input-box -->
		<div class="input-box">
			<label for="numero" style="padding-top: 10px">N�mero</label> <input
				class="campo" type="number" name="enderecoEntrega.numero" id="num"
				required="required" />
		</div>
		<!-- end input-box -->
		<div class="input-box">
			<label for="numero" style="padding-top: 10px">Complemento</label> <input
				class="campo" type="text" name="enderecoEntrega.complemento"
				class="complemento" required="required" />
		</div>
		<!-- end input-box -->
	</div>
	<!-- end form-profissional -->
	<!-- ENDEREÃ‡O DE ENTREGA -->
	<div class="form-endereco" id='form-endereco'>
		<h4>&nbsp;</h4>
		<div class="input-box">
			<label for="bairro" style="padding-top: 10px">Bairro</label> <input
				class="campo" type="text" id="bairro" name="enderecoEntrega.bairro" />
		</div>
		<!-- end input-box -->
		<div class="input-box">
			<label for="cidade" style="padding-top: 10px">Cidade</label> <input
				class="campo" type="text" id="cidade" name="enderecoEntrega.cidade" />
		</div>
		<!-- end input-box -->
		<div class="input-box">
			<label for="estado" style="padding-top: 10px">Estado</label> <select
				name="enderecoEntrega.estado" id="estado">
				<option value="">Selecione</option>
				<option value="AC">Acre</option>
				<option value="AL">Alagoas</option>
				<option value="AP">Amap�</option>
				<option value="AM">Amazonas</option>
				<option value="BA">Bahia</option>
				<option value="CE">Cear�</option>
				<option value="DF">Distrito Federal</option>
				<option value="ES">Espirito Santo</option>
				<option value="GO">Goi�s</option>
				<option value="MA">Maranh�o</option>
				<option value="MS">Mato Grosso do Sul</option>
				<option value="MT">Mato Grosso</option>
				<option value="MG">Minas Gerais</option>
				<option value="PA">Par�</option>
				<option value="PB">Para�ba</option>
				<option value="PR">Paran�</option>
				<option value="PE">Pernambuco</option>
				<option value="PI">Piau�</option>
				<option value="RJ">Rio de Janeiro</option>
				<option value="RN">Rio Grande do Norte</option>
				<option value="RS">Rio Grande do Sul</option>
				<option value="RO">Rond�nia</option>
				<option value="RR">Roraima</option>
				<option value="SC">Santa Catarina</option>
				<option value="SP">S�o Paulo</option>
				<option value="SE">Sergipe</option>
				<option value="TO">Tocantins</option>
			</select>
		</div>
		<!-- end input-box -->
		<div class="input-box">
			<label for="pais" style="padding-top: 10px">Pa�s</label> <select
				class="campopais" id="pais" name="enderecoEntrega.pais">
				<option value="">Selecione</option>
				<option value="A�frica do Sul">A�frica do Sul</option>
				<option value="Alb�nia">Alb�nia</option>
				<option value="Alemanha">Alemanha</option>
				<option value="Andorra">Andorra</option>
				<option value="Angola">Angola</option>
				<option value="Anguilla">Anguilla</option>
				<option value="Antigua">Antigua</option>
				<option value="Ar�bia Saudita">Ar�bia Saudita</option>
				<option value="Argentina">Argentina</option>
				<option value="Arm�nia">Arm�nia</option>
				<option value="Aruba">Aruba</option>
				<option value="Austr�lia">Austr�lia</option>
				<option value="Áustria">Áustria</option>
				<option value="Azerbaij�o">Azerbaij�o</option>
				<option value="Bahamas">Bahamas</option>
				<option value="Bahrein">Bahrein</option>
				<option value="Bangladesh">Bangladesh</option>
				<option value="Barbados">Barbados</option>
				<option value="B�lgica">B�lgica</option>
				<option value="Benin">Benin</option>
				<option value="Bermudas">Bermudas</option>
				<option value="Botsuana">Botsuana</option>
				<option value="Brasil">Brasil</option>
				<option value="Brunei">Brunei</option>
				<option value="Bulg�ria">Bulg�ria</option>
				<option value="Burkina Fasso">Burkina Fasso</option>
				<option value="Bot�o">Bot�o</option>
				<option value="Cabo Verde">Cabo Verde</option>
				<option value="Camar�es">Camar�es</option>
				<option value="Camboja">Camboja</option>
				<option value="Canad�">Canad�</option>
				<option value="Cazaquist�o">Cazaquist�o</option>
				<option value="Chade">Chade</option>
				<option value="Chile">Chile</option>
				<option value="China">China</option>
				<option value="Cidade do Vaticano">Cidade do Vaticano</option>
				<option value="Col�mbia">Col�mbia</option>
				<option value="Congo">Congo</option>
				<option value="Cor�ia do Sul">Cor�ia do Sul</option>
				<option value="Costa do Marfim">Costa do Marfim</option>
				<option value="Costa Rica">Costa Rica</option>
				<option value="Cro�cia">Cro�cia</option>
				<option value="Dinamarca">Dinamarca</option>
				<option value="Djibuti">Djibuti</option>
				<option value="Dominica">Dominica</option>
				<option value="EUA">EUA</option>
				<option value="Egito">Egito</option>
				<option value="El Salvador">El Salvador</option>
				<option value="Emirados ��rabes">Emirados ��rabes</option>
				<option value="Equador">Equador</option>
				<option value="Eritr�ia">Eritr�ia</option>
				<option value="Esc�cia">Esc�cia</option>
				<option value="Eslov�quia">Eslov�quia</option>
				<option value="Eslov�nia">Eslov�nia</option>
				<option value="Espanha">Espanha</option>
				<option value="Est�nia">Est�nia</option>
				<option value="Eti�pia">Eti�pia</option>
				<option value="Fiji">Fiji</option>
				<option value="Filipinas">Filipinas</option>
				<option value="Finl�ndia">Finl�ndia</option>
				<option value="Fran�a">Fran�a</option>
				<option value="Gab�o">Gab�o</option>
				<option value="G�mbia">G�mbia</option>
				<option value="Gana">Gana</option>
				<option value="Ge�rgia">Ge�rgia</option>
				<option value="Gibraltar">Gibraltar</option>
				<option value="Granada">Granada</option>
				<option value="Gr�cia">Gr�cia</option>
				<option value="Guadalupe">Guadalupe</option>
				<option value="Guam">Guam</option>
				<option value="Guatemala">Guatemala</option>
				<option value="Guiana">Guiana</option>
				<option value="Guiana Francesa">Guiana Francesa</option>
				<option value="Guin�-bissau">Guin�-bissau</option>
				<option value="Haiti">Haiti</option>
				<option value="Holanda">Holanda</option>
				<option value="Honduras">Honduras</option>
				<option value="Hong Kong">Hong Kong</option>
				<option value="Hungria">Hungria</option>
				<option value="I�men">I�men</option>
				<option value="Ilhas Cayman">Ilhas Cayman</option>
				<option value="Ilhas Cook">Ilhas Cook</option>
				<option value="Ilhas Cura�ao">Ilhas Cura�ao</option>
				<option value="Ilhas Marshall">Ilhas Marshall</option>
				<option value="Ilhas Turks & Caicos">Ilhas Turks &amp;
					Caicos</option>
				<option value="Ilhas Virgens (brit.)">Ilhas Virgens (brit.)</option>
				<option value="Ilhas Virgens(amer.)">Ilhas Virgens(amer.)</option>
				<option value="Ilhas Wallis e Futuna">Ilhas Wallis e Futuna</option>
				<option value="Índia">Índia</option>
				<option value="Indon�sia">Indon�sia</option>
				<option value="Inglaterra">Inglaterra</option>
				<option value="Irlanda">Irlanda</option>
				<option value="Isl�ndia">Isl�ndia</option>
				<option value="Israel">Israel</option>
				<option value="It�lia">It�lia</option>
				<option value="Jamaica">Jamaica</option>
				<option value="Jap�o">Jap�o</option>
				<option value="Jord�nia">Jord�nia</option>
				<option value="Kuwait">Kuwait</option>
				<option value="Latvia">Latvia</option>
				<option value="L�bano">L�bano</option>
				<option value="Liechtenstein">Liechtenstein</option>
				<option value="Litu�nia">Litu�nia</option>
				<option value="Luxemburgo">Luxemburgo</option>
				<option value="Macau">Macau</option>
				<option value="Maced�nia">Maced�nia</option>
				<option value="Madagascar">Madagascar</option>
				<option value="Mal�sia">Mal�sia</option>
				<option value="Malaui">Malaui</option>
				<option value="Mali">Mali</option>
				<option value="Malta">Malta</option>
				<option value="Marrocos">Marrocos</option>
				<option value="Martinica">Martinica</option>
				<option value="Maurit�nia">Maurit�nia</option>
				<option value="Mauritius">Mauritius</option>
				<option value="M�xico">M�xico</option>
				<option value="Moldova">Moldova</option>
				<option value="M�naco">M�naco</option>
				<option value="Montserrat">Montserrat</option>
				<option value="Nepal">Nepal</option>
				<option value="Nicar�gua">Nicar�gua</option>
				<option value="Niger">Niger</option>
				<option value="Nig�ria">Nig�ria</option>
				<option value="Noruega">Noruega</option>
				<option value="Nova Caled�nia">Nova Caled�nia</option>
				<option value="Nova Zel�ndia">Nova Zel�ndia</option>
				<option value="Om�">Om�</option>
				<option value="Palau">Palau</option>
				<option value="Panam�">Panam�</option>
				<option value="Papua-nova Guin�">Papua-nova Guin�</option>
				<option value="Paquist�o">Paquist�o</option>
				<option value="Peru">Peru</option>
				<option value="Polin�sia Francesa">Polin�sia Francesa</option>
				<option value="Pol�nia">Pol�nia</option>
				<option value="Porto Rico">Porto Rico</option>
				<option value="Portugal">Portugal</option>
				<option value="Qatar">Qatar</option>
				<option value="Qu�nia">Qu�nia</option>
				<option value="Rep. Dominicana">Rep. Dominicana</option>
				<option value="Rep. Tcheca">Rep. Tcheca</option>
				<option value="Reunion">Reunion</option>
				<option value="Rom�nia">Rom�nia</option>
				<option value="Ruanda">Ruanda</option>
				<option value="R�ssia">R�ssia</option>
				<option value="Saipan">Saipan</option>
				<option value="Samoa Americana">Samoa Americana</option>
				<option value="Senegal">Senegal</option>
				<option value="Serra Leone">Serra Leone</option>
				<option value="Seychelles">Seychelles</option>
				<option value="Singapura">Singapura</option>
				<option value="S�ria">S�ria</option>
				<option value="Sri Lanka">Sri Lanka</option>
				<option value="St. Kitts & Nevis">St. Kitts &amp; Nevis</option>
				<option value="St. L�cia">St. L�cia</option>
				<option value="St. Vincent">St. Vincent</option>
				<option value="Sud�o">Sud�o</option>
				<option value="Su�cia">Su�cia</option>
				<option value="Sui�a">Sui�a</option>
				<option value="Suriname">Suriname</option>
				<option value="Tail�ndia">Tail�ndia</option>
				<option value="Taiwan">Taiwan</option>
				<option value="Tanz�nia">Tanz�nia</option>
				<option value="Togo">Togo</option>
				<option value="Trinidad & Tobago">Trinidad &amp; Tobago</option>
				<option value="Tun�sia">Tun�sia</option>
				<option value="Turquia">Turquia</option>
				<option value="Ucr�nia">Ucr�nia</option>
				<option value="Uganda">Uganda</option>
				<option value="Uruguai">Uruguai</option>
				<option value="Venezuela">Venezuela</option>
				<option value="Vietn�">Vietn�</option>
				<option value="Zaire">Zaire</option>
				<option value="Z�mbia">Z�mbia</option>
				<option value="Zimb�bue">Zimb�bue</option>
			</select>
		</div>
		<!-- end input-box -->
		<div class="btn-cadastro">
			<input type="submit" class="btn-prosseguir" value="Finalizar">
		</div>
	</div>
</div>
</form>