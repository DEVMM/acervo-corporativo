<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div class="column2" id="pessoaFisicaSucesso">
	<input type="hidden" value="${pessoaFisica.CPF}" name="cpfPessoa" /> 
		<div class="form-profissional">
			<h5>
				<strong class="icon-lado"></strong>responsável pela empresa
			</h5>
			<div class="input-box">
	                     <label for="cpf" style="padding-top: 10px">CPF</label>
	                     <input class="cep campo inputNcep" type="text" id="cpf" value ="${pessoaFisica.CPF}"name="CPF" />
	                     <span class="localizarCep"> <a href="#" onclick="localizarResponsavel()">Localizar Responsável</a></span>
	                 </div>
			<div class="input-box">
				<label for="empresa" style="padding-top: 10px">Nome</label>
				<input type="text" id="campos-valide" name="nome" maxlength="200" value="${pessoaFisica.nome}" readonly="readonly" /> </div>
			<!-- end input-box -->
			<div class="input-box">
				<label for="empresa" style="padding-top: 10px">Sobrenome</label>
				<input type="text" id="campos-valide" name="Sobrenome" maxlength="200" value="${pessoaFisica.sobrenome}"  readonly="readonly"/> </div>
			<!-- end input-box -->
			<div class="input-box">
				<label for="e-mail" style="padding-top: 10px">E-mail</label>
				<c:forEach var="email" items="${pessoaFisica.pessoa.emails}" end="0">
					<c:if test="${email.principal}">
						<input type="text" id="campos-valide" name="e-mail" maxlength="100" value="${email.email}"  readonly="readonly"/>
					</c:if>
				</c:forEach>
			</div>
			<!-- end input-box -->
		</div>
		<div class="form-endereco" id='form-endereco'>
			<h4>&nbsp;</h4>
			<div class="input-box">
				<label for="celular" style="padding-top: 10px">Celular</label>
				<c:forEach var="telefone" items="${pessoaFisica.pessoa.telefones}" end="0">
					<c:if test="${telefone.tipo == 'celular'}">
						<input type="text" id="campos-valide" name="celular" maxlength="100" value="${telefone.numero}"  readonly="readonly"/>
					</c:if>
				</c:forEach>
			</div>
			<div class="input-box">
				<label for="areaatuacao" style="padding-top: 10px">área de atuação</label>
				<select class="campoestado" id="campos-valide" name="areaatuacao" disabled="disabled">
					<option value="${pessoaFisica.area}">${pessoaFisica.area.descricao}</option>
					<c:forEach var="area" items="${listarAreas}">
						<option value="${area}">${area.descricao}</option>
					</c:forEach>
				</select>
			</div>
			<div class="input-box">
				<label for="nivelhieraquico" style="padding-top: 10px">nível hierárquico </label>
				<select class="campopais" id="pais" name="nivelhieraquico" disabled="disabled">
					<option value="${pessoaFisica.nivel}">${pessoaFisica.nivel.descricao}</option>
					<c:forEach var="nivel" items="${listarNiveis}">
						<option value="${nivel}">${nivel.descricao}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
