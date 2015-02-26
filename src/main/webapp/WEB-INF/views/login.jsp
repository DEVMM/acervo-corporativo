<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Grupo M&amp;M - Cadastro Pessoa Física</title>
	<%@ include file="componentes/header/head.jsp" %>
</head>

<body>
	<div id="content">
		<%@ include file="componentes/header/menu-bar.jsp" %>
			<h1 class="txt-cfechado">
			Assinaturas <span class="raquo">&raquo;</span>
		</h1>
			<div id="tlLogin">
				<section class="lado1-login">
					<article class="banner-login">
						<!-- aqui vai ter um carrocel -->
						<div class="destaque-noticia" style="width:600px; margin:0 auto;">
							<!-- <div id="owl-demo">
								<div class="item darkCyan">
									<a href="home-galery.php"><img src="resources/images/banner-colorido.jpg" alt="Exemplo destaque" /> </a>
									<div class="info-destaque"> </div>
								</div>
								<div class="item darkCyan">
									<a href="home-galery.php"><img src="resources/images/banner2.jpg" alt="Exemplo destaque" /> </a>
									<div class="info-destaque"> </div>
								</div>
								<div class="item darkCyan">
									<a href="home-galery.php"><img src="resources/images/banner3.jpg" alt="Exemplo destaque" /> </a>
									<div class="info-destaque"> </div>
								</div>
								<div class="item darkCyan">
									<a href="home-galery.php"><img src="resources/images/banner4.jpg" alt="Exemplo destaque" /> </a>
									<div class="info-destaque"> </div>
								</div>
							</div> -->
						</div>
						<!--End div container -->
					</article>
					<h1><strong class="corD">Bem-vindo ao</strong> Grupo Meio e Mensagem</h1>
					<p>UsuÃ¡rios que possuem perfíl completo tem acesso príveligiado em toda plataforma Meio e Mensagem! perfíl completo tem acesso príveligiado em toda plataforma Meio e Mensagem!</p>
				</section>
				<aside class="Alogin">
					<article class="cx-acesso">
						<h1><span>ASSINATURAS</span></h1>
						<form>
							<fieldset class="Lemail">
								<label for="id">ID</label>
								<input type="text" id="campo-id" name="id"> </fieldset>
							<a href="javascript:validarLoginCapa()"> <img src="resources/images/btn-login.png" class="conectar-btn"> </a>
							<section class="ladoEsqueci"> <span>
							<a href="#" class="txt-loginN" data-reveal-id="myModal" data-animation="fade"><span class="aspE">&raquo;</span>Recuperar Meu ID</a>
								</span>
							</section>
						</form>
					</article>
				</aside>
				<br clear="all" />
				<!--<div id="myModalEmal" class="reveal-modal">
		<a class="close-reveal-modal">&#215;</a>
			<section class="tarjaApare">
				<article>
					<form>
						<h2>recuperar meu email <span class="raquo2">&raquo</span></h2>
						<label for="txt_id">id</label>
						<input type="text" name="nome" id="nome" />
						<input type="image" src="images/btn_recuperar-email.png" />
					</form>
				</article>
			</section>
		</div>-->
				<br clear="all" />
				<div id="myModal" class="reveal-modal">
					<!--<a class="close-reveal-modal">&#215;</a>-->
					<section class="tarjaApareGra">
						<div id="box">
							<!-- tabs -->
							<p id="tabs"> <a href="#tab1" class="selected">pessoa física</a> <a href="#tab2">pessoa jurídica</a> </p>
							<!-- Tabs content -->
							<ul id="contents">
								<!-- tab 1 -->
								<li id="tab1">
									<article>
										<form>
											<h2>recuperar Meu ID <span class="raquo2">&raquo;</span></h2>
											<div class="input-box">
												<label for="txt_cpf" class="tlabel">CPF</label>
												<input type="text" name="cpf" id="campos-login" /> </div>
											<br clear="all" />
											<div class="input-box">
												<label for="txt_codigo" class="tlabel">Codigo</label>
												<input type="text" name="codigo" id="campos-login" /> </div>
											<br clear="all" />
											<div class="input-box">
												<label for="txt_id" class="tlabel">Nome</label>
												<input type="text" name="email" id="campos-login" /> </div>
											<br clear="all" />
											<div class="input-box">
												<label for="txt_id" class="tlabel">E-mail</label>
												<input type="text" name="email" id="campos-login" /> </div>
											<a href="javascript:validarLogin()" class="nnvoBTN"> <img src="resources/images/recuperar-id.png" /> </a>
											<!--<a class="btn-prosseguir" href="javascript:validarFormJuridico()" title="Prosseguir">Finalizar</a>-->
										</form>
									</article>
								</li>
								<!-- tab 2 -->
								<li id="tab2">
									<article>
										<form>
											<h2>recuperar Meu ID <span class="raquo2">&raquo;</span></h2>
											<div class="input-box">
												<label for="txt_cnpj" class="tlabel">CNPJ</label>
												<input type="text" name="cnpj" id="campos-login" /> </div>
											<br clear="all" />
											<div class="input-box">
												<label for="txt_codigo" class="tlabel">Codigo</label>
												<input type="text" name="codigo" id="campos-login" /> </div>
											<br clear="all" />
											<div class="input-box">
												<label for="txt_id" class="tlabel">Nome</label>
												<input type="text" name="email" id="campos-login" /> </div>
											<br clear="all" />
											<div class="input-box">
												<label for="txt_id" class="tlabel">E-mail</label>
												<input type="text" name="email" id="campos-login" /> </div>
											<a href="javascript:validarLogin()" class="nnvoBTN"> <img src="resources/images/recuperar-id.png" /> </a>
											<!--<a class="btn-prosseguir" href="javascript:validarFormJuridico()" title="Prosseguir">Finalizar</a>-->
										</form>
									</article>
								</li>
							</ul>
						</div>
					</section>
				</div>
				<!-- end lixtbox -->
			</div>
	</div>
</body>

</html>