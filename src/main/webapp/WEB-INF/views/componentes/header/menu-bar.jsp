<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div id="barra-grupoMM">
    <div class="barra-conteudo">
    <form action="" method="post" id="form_login">
        <h1>
            <a href="#" title="#"><img src="${myUrl}resources/images/logoGrupoMM-barra.png" alt="Grupo M&amp;M" height="24" width="104"></a>
        </h1>
        
        <ul class="barra-menu">
            <li class="azul"><a href="http://www.meioemensagem.com.br" title="Meio &amp; Mensagem"><span>Meio &amp; Mensagem</span></a></li>
            <li class="rosa"><a href="http://www.proxxima.com.br" title="Proxxima"><span>ProXXIma</span></a></li>
            <li class="roxo"><a href="#" title="Eventos"><span>Eventos</span></a></li>
        </ul>
        
        <ul class="barra-access" id="div_login">
            <li><a href="#" title=""><span>assine</span></a></li>
            <li><a href="#" title=""><span>anuncie</span></a></li>
            <li><a href="#" title=""><span class="none-border">fale conosco</span></a></li>
            <li><a class="uppercase" href="javascript:chamarAlert()" title="Inscreva-se"><span>Cadastre-se</span></a></li>
            <li><a class="uppercase account" href="#" title=""><span class="right">Login</span></a>
            <ul class="submenu" style="display: none;">
                    <li>
                        <label>Login</label> 
                        <img src="${myUrl}resources/images/pic-up.png" />
                    </li>
                    <li>
                        <span>E-mail</span>
                        
                        <input type="text" name="E-mail" id="E-mail" value="" placeholder="Digite seu login!" onblur="verificarEmailLogin()" />
                        <div id="resultado-email-login"></div>
                    </li>
                    <li>
                        <span>Senha</span>
                        <input type="password" name="senha_login" id="senha_login" value="" placeholder="Digite sua senha!" />
                    </li>
                    <li>
                     <div class="btn-cadastro">
                        <a class="btn-parar"  id="btn_login_social"href="javascript:login_LD()" title="Conectar Social Media">Conectar Social Media</a>
                        <a class="btn-parar" id="btn_login" href="javascript:login()" title="Login">Login</a>
                        
                    </div>
                    </li>
                    <li class="lembrete">
                        <a href="javascript:alert_recupera()">Esqueci minha senha</a>
                    </li>
                    <li class="lembrete">
                        <a href="javascript:alert_recupera_login()">Esqueci meu login</a>
                    </li>
                </ul>
            <li><a href="<c:url value="/j_spring_security_logout"/>">Sair <i class="entypo-logout right"></i></a></li>
       </ul>    
        </form>

    </div>

    </div><!-- Fim Barra -->