<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>login-aos-cuidados</title>
	<link rel="stylesheet" type="text/css" href="css/global.css">
	<link rel="stylesheet" type="text/css" href="css/css-listbox/reveal.css">
	<!-- Owl Carousel Assets -->
	<link href="css/owl.carousel.css" rel="stylesheet">
	<link href="css/owl.theme.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/reset.css" />

<script type="text/javascript">
    var $JQuery = jQuery.noConflict()
</script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
	<script src="js/jquery-ui-1.10.4.custom.js"></script>
	<script src="js/cadastro.js"></script>    

		 <!--list box -->
	<script src="js/js-listbox/jquery.reveal.js"></script>
	<script src="js/js-listbox/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
	<script type="text/javascript" src="js/js-listbox/jquery.reveal.js"></script>
	<!-- End List Box -->

	<!----------------------------------------------- Carrocel --------------------------------------------> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/banner.js"></script>
<!--
	<script src="js/valida-listbox/jquery.validate.min.js"></script>
	<script src="js/valida-listbox/validacao.js"></script>
-->
<!-- --------------------------------------------- Carrocel --------------------------------------------> 

	<script>
		function enviaLog() {
			window.open("visualizar-assinaturas.html");
			}
	
	</script>

</head>
<body class="bg-cadastro">
<!-- Barra Grupo M&M -->
<div id="barra-grupoMM">
	<div class="barra-conteudo">
	<form action="" method="post" id="form_login">
    	<h1><a href="#" title="#"><img src="images/logoGrupoMM-barra.png" alt="Grupo M&amp;M" height="24" width="104"></a></h1>
        <ul class="barra-menu">
        	<li class="azul"><a href="http://www.meioemensagem.com.br" title="Meio &amp; Mensagem"><span>Meio &amp; Mensagem</span></a></li>
            <li class="rosa"><a href="http://www.proxxima.com.br" title="Proxxima"><span>ProXXIma</span></a></li>
            <li class="roxo"><a href="#" title="Eventos"><span>Eventos</span></a></li>
        </ul>
		
		<ul class="barra-access" id="div_login">
        	<li><a href="#" title=""><span>assine</span></a></li>
            <li><a href="#" title=""><span>anuncie</span></a></li>
            <li><a href="#" title=""><span class="none-border">fale conosco</span></a></li>
       </ul>	
        </form>

    </div>
</div>



<div id="tlLogin">
		<section class="lado1-login">
		    <article class="banner-login">
		    	<!-- aqui vai ter um carrocel -->

        <div class="destaque-noticia" style="width:600px; margin:0 auto;">
		
            <div id="owl-demo">
                <div class="item darkCyan">
					<a href="home-galery.php"><img src="images/banner-colorido.jpg" alt="Exemplo destaque" /></a>
                    <div class="info-destaque">
					</div> 
                </div>
                <div class="item darkCyan">
					<a href="home-galery.php"><img src="images/banner2.jpg" alt="Exemplo destaque" /></a>
                    <div class="info-destaque">
						</div> 
                </div>
                <div class="item darkCyan">					
					<a href="home-galery.php"><img src="images/banner3.jpg" alt="Exemplo destaque" /></a>					
                    <div class="info-destaque">
					</div> 
                </div>
                <div class="item darkCyan">
					<a href="home-galery.php"><img src="images/banner4.jpg" alt="Exemplo destaque" /></a>
					<div class="info-destaque">
					</div> 
                </div>

            </div>
    </div><!--End div container -->

		    </article>
		    <h1><strong class="corD">Bem-vindo ao</strong> Grupo Meio e Mensagem</h1>
		    <p>Usuários que possuem perfíl completo tem acesso príveligiado em toda plataforma Meio e Mensagem! perfíl completo tem acesso príveligiado em toda plataforma Meio e Mensagem!</p>
		</section>
		<aside class="Alogin">
			<article class="cx-acesso">			
				<h1><span>ASSINATURAS</h1>
				<p>Você precisa criar sua conta para ter acesso ao controle de assinaturas</p>
				<form>
					<fieldset class="LemailCuidados">
						<label for="email">Email</label>
						<input type="password" id="campos-cuidado" name="email" class="arraPasso">
					</fieldset>
					<fieldset class="LemailCuidados">
						<label for="senha">Senha</label>
						<input type="password" id="campos-cuidado" name="senha" class="arraPasso">
					</fieldset>
					<fieldset class="LemailCuidados">
						<label for="c-senha">Confirma<span class="diskS">Senha</span></label>
						<input type="password" id="campos-cuidado" name="c-senha">
					</fieldset>
					<a href="javascript:validarLoginCuida()">
					    <img src="images/btn-login.png" class="conectar-btn" >
					</a>
					
				</form>
			</article>

		</aside>
		<br clear="all" />
		
		<div id="myModalEmal" class="reveal-modal">
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
		</div>
		<br clear="all" />

		<br clear="all" /> <br clear="all" /> <br clear="all" />
		<!--<form id="form_validacao">
			<input type="text" id="nome" name="nome" />
			<input type="submit" value="enviar" />
		</form>-->

		<div id="myModal" class="reveal-modal">
					<a class="close-reveal-modal">&#215;</a>
					
			<section class="tarjaApareGra">
				<article>
					<form>
						<h2>recuperar Meu ID <span class="raquo2">&raquo</span></h2>
						<label for="txt_id">E-mail</label>
						<input type="text" name="nome" id="campos-login" />
						<input type="radio" id="cpfA" name="documento" value="A" class="mx-rad" / ><span class="txt-rad">CPF</span>
		                <input type="radio" id="cnpjB" name="documento"  value="B"/><span class="txt-rad">CNPJ</span> 
		                <br clear="all" />
						<label for="cpf">CPF&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
						<input type="text" name="cpf" id="campos-login" />
						<a href="javascript:validarLogin()" class="nnvoBTN" >
						    <img src="images/recuperar-id.png" />
						</a>
						<!--<a class="btn-prosseguir" href="javascript:validarFormJuridico()" title="Prosseguir">Finalizar</a>-->
					</form>
				</article>
			</section>


		 	</div>

 		 
	</div><br clear="all" />




</body>
</html>