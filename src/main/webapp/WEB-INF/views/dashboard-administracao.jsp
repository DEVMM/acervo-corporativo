<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL"
	value="${fn:replace(req.requestURL, fn:substring(req.requestURI, 1, fn:length(req.requestURI)), req.contextPath)}" />
<c:set var="string1" value="${baseURL}/${MyID}" />
<c:set var="string2"
	value="${fn:replace(string1, 
	'8080//', '8080/')}" />
<c:url var="myUrl" value="${string2}" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Grupo M&amp;M - DBM Administra��o</title>
		<%@ include file="componentes/header/head.jsp"%>
		<script type="text/javascript">
			function incluirAssinatura() {
				var methodURL= "incluirAssinatura"
				$.ajax({
					type : "POST",
					url : methodURL,
					success : function(response) {
						$("#formularioAdicionarAssinatura").html(response);
					},
					error : function(e) {
						alert("Falha ao carregar os Dados");
					}
				});
			}
		</script>
	</head>
	<body>
		<div id="content">
			<%@ include file="componentes/header/menu-bar.jsp"%>
			<h1 class="txt-cfechadovisu">Administra��o <span class="raquo">�</span></h1>
			<form action="">
				<!-- fomulario Geral -->
				<section class="v-assinaturas">
					<article class="divAssinatura">
						<c:if test="${pf != null}">
							<h1>${pf.nome} ${pf.sobrenome}</h1>
							<br clear="all" />
							<h3>
							</h3>
						</c:if>
						<article class="checkboxVisu">
							<input type="checkbox" name="chkAll" /><small>selecionar tudo</small>
							<select class="selecNN" id="ramo-atividade" name="ramo-atividade">
								<option value="">a��es em massa</option>
								<option value="">endere�o padr�o</option>
							</select>
							<input type="image" src="${myUrl}resources/images/btn-alterar.png" class="btnAlterar" />
						</article>
					</article>
					<article class="divAssinaturaLado">
						<article class="segbtns">
							<div class="btn-adx">
								<a href="#" data-reveal-id="modalAdicionarAssinatura" data-animation="fade" onclick="incluirAssinatura()">
								<img src="${myUrl}resources/images/add-assinatura.png" />
								</a>
							</div>
							<div id="modalAdicionarAssinatura" class="reveal-modal-cad">
								<div id="formularioAdicionarAssinatura"></div>
							</div>
							<div>
								<a href="#">
								<img src="${myUrl}resources/images/exportar-rela.png" />
								</a>
							</div>
						</article>
						<br clear="all" />
						<article class="divRelatorio">
							<div class="divsegM">
								<section class="segCampoBusca">
									<article class="campoBuscaAssi">
										<input type="text" name="busca" id="busca" placeholder="BUSCAR" />
										<input type="submit" value="OK" />
									</article>
								</section>
							</div>
							<div class="divsegM">
								<span>filtrar por: </span>
								<section class="segBGlista">
									<article class="arrendoFiltra">
										<ul>
											<li class="arreSBorda primeiro" >
												todos
											</li>
											<li>
												<input type="text" id="date-range0" name="data-nascimento" placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Defina um per�odo:" class="classNINput data"/>
											</li>
											<li class="segundo">ativos</li>
											<li class="terceiro">Pendentes</li>
											<li class="quarto">inativos</li>
										</ul>
									</article>
								</section>
							</div>
						</article>
						<!-- end Div Relatorio -->
					</article>
					<br clear="all" />
					<section class="tabGeral">
						<table class="tabelaAssi">
							<thead>
								<tr>
									<th width="48"><img src="${myUrl}resources/images/seta-baixo.png" /></th>
									<th width="65" height="45">id</th>
									<th width="220" height="45">Data de Cria��o</th>
									<th width="360">Empresa</th>
									<th width="80" >Tipo</th>
									<th width="145">Aos Cuidados</th>
									<th width="98">Status</th>
								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="empresa" items="${listarEmpresas}">
									<c:forEach var="assinatura" items="${empresa.assinaturas}">
										<c:if test="${empty assinatura.assinaturaPai}">
											<tr>
												<td width="48"><input type="checkbox"></td>
												<td width="58" height="45"></td>
												<td width="116">
													<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${assinatura.dataCriacao}" />
												</td>
												<td width="260">
													<section class="segUpper">
														<ul class="sobreUpper">
															<li>
																<div align="center">
																	<a>${empresa.razaoSocial}</a>
																</div>
																<ul>
																	<li>
																		<article class="divMostra">
																			<div class="Tabfuncao"><span class="calss">
																				<a href="#" data-reveal-id="myModalCuidados" data-animation="fade" class="borderM">Aos Cuidados</a></span>
																				<span class="calss"> <a href="juridicos.html" class="borderM">Editar</a></span>
																				<strong class="calss"><a href="#" data-reveal-id="myModal" data-animation="fade" class="borderM">Inativar</a></strong><small class="calss"><a href="#" data-reveal-id="myModalCad" data-animation="fade">Visualizar</a></small>
																			</div>
																		</article>
																	</li>
																</ul>
															</li>
														</ul>
													</section>
												</td>
												<td width="80" >Diaria</td>
												<td width="145">Fabio Castro </td>
												<td width="78">
													<section class="segUpper">
														<ul class="DuvUpper">
															<li>
																<a href="#"><img src="${myUrl}resources/images/check-yellom.png" class="mxCheck" /></a>
																<ul>
																	<li>
																		<article class="divAviso">
																			<strong>pedente</strong>  
																			<p>assinatura incompleta!</p>
																		</article>
																	</li>
																</ul>
															</li>
														</ul>
													</section>
												</td>
											</tr>
										</c:if>
									</c:forEach>
								</c:forEach>
							</tbody>
						</table>
					</section>
				</section>
			</form>
		</div>
	</body>
</html>