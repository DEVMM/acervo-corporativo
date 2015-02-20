<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Visualizar Assinatura</title>
    <link rel="stylesheet" type="text/css" href="css/global.css" />
    <link rel="stylesheet" type="text/css" href="css/css-listbox/reveal.css">
    <link rel="stylesheet" type="text/css" href="css/reset.css" />
    <link href="css/smoothness/jquery-ui-1.10.4.custom.css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="css/calendario/custom-theme/jquery-ui-1.8.20.custom.css" />

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
    <script src="js/jquery-ui-1.10.4.custom.js"></script>
    <script src="js/cadastro.js"></script>    

    <!--list box -->
    <script src="js/js-listbox/jquery.reveal.js"></script>
    <script src="js/js-listbox/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="js/js-listbox/jquery.reveal.js"></script>
    <!-- End List Box -->

    <script type="text/javascript" src="js/calendario/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="js/calendario/jquery-ui-1.8.20.custom.min.js"></script>
    <script type="text/javascript" src="js/calendario/calendario.js"></script>
    <script>
    function checkAll(o){
        var boxes = document.getElementsByTagName("input");
        for (var x=0;x<boxes.length;x++){
            var obj = boxes[x];
            if (obj.type == "checkbox"){
                if (obj.name!="chkAll") obj.checked = o.checked;
            }
        }
    }
    </script>
    <link rel="stylesheet" href="css/calendario/daterangepicker.css" />
    <script src="js/calendario/personalizado/jquery-1.5.1.min.js"></script>
    <script src="js/calendario/personalizado/moment.min.js"></script>
    <script src="js/calendario/personalizado/jquery.daterangepicker.js"></script>
    <script src="js/calendario/personalizado/principal.js"></script>

    <script type="text/javascript">
        function alterarC() {
            confirm("Tem ceteza que deseja mudar todos os endereços para o endereço padrão da empresa?");
        }

        function alterarDadosEdi() {
            confirm("Você tem certeza que deseja alterar os dados ?");
        }

        //trava o campo select pois não permite que seu valor seja alterado
        function travarCampoSelect(obj){
        var index = obj.selectedIndex;
        obj.onkeypress=function() {
        obj.options[index].selected = true;
        return false;
        };
        obj.onclick=function() {
        obj.options[index].selected = true;
        return false;
        };
        obj.onchange=function() {
        obj.options[index].selected = true;
        return false;
        };
        }

    </script>
</head>

<body>

<!--<script type='text/javascript' src="js/jquery-1.7.1.js"></script>-->
<div id="content">
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
            <li><a class="uppercase" href="javascript:chamarAlert()" title="Inscreva-se"><span>Cadastre-se</span></a></li>
            <li><a class="uppercase account" href="#" title=""><span class="right">Login</span></a>
                <ul class="submenu" style="display: none;">
                    <li><label>Login</label> 
                    <img src="images/pic-up.png" /></li>
                    <li>
                        <span>E-mail</span>
                        
                        <input type="text" name="E-mail" id="E-mail" valor="" placeholder="Digite seu login!" onblur="verificarEmailLogin()" />
                        <div id="resultado-email-login"></div>
                    </li>
                    <li>
                        <span>Senha</span>
                        <input type="password" name="senha_login" id="senha_login" valor="" placeholder="Digite sua senha!" />
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
                
            </li>
            
            
       </ul>    
        </form>

    </div>

    </div><!-- Fim Barra -->
    <h1 class="txt-cfechadovisu">Assinaturas <span class="raquo">»</span></h1>
	<form action=""><!-- fomulario Geral -->
    <section class="v-assinaturas">	
            <article class="divAssinatura">
                <h1>José Carvalho dos Santos </h1>
                <h2>Responsável: <strong class="apertaStrong">Francisco Lopes</strong></h2>
                <small class="alterarMM"><a href="#" data-reveal-id="myModalResponsavelEdi" data-animation="fade">Alterar</a></small><br clear="all" />
                <h3>Códido do assinante: <strong>58052</strong></h3>
                <h2 class="txtAssi">Total de assinaturas: <strong>20</strong></h2><br clear="all" />
                <article class="checkboxVisu">
                    <input type="checkbox" name="chkAll" onClick="checkAll(this)" /><small>selecionar tudo</small>
                </article>
                      <div class="input-box">
                        <!--<label for="ramo-atividade">Ramo de atividade</label>-->
                        <select class="selecNN" id="ramo-atividade" name="ramo-atividade" onchange="this.options[1].selected = true;">
                            <option value="">ações em massa</option>
							<option value="">endereço padrão</option>
                        </select><input type="image" src="images/btn-alterar.png" class="btnAlterar" onclick="alterarC()"/><br clear="all" />
                    </div><!-- end input-box -->
               
            </article>
            <article class="divAssinaturaLado">
                <!--<h3><a href="#">Adicionar Nova Assitura</a></h3>-->
                <article class="segbtns">
                    <div class="btn-adx">
                        <a href="juridicos.html">
                           <img src="images/ad-assinatura.png" />
                        </a>
                    </div>
                    <div>
                        <a href="#">
                            <img src="images/exportar-rela.png" />
                        </a>
                    </div>
                </article><br clear="all" />
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
                                <input type="text" id="date-range0" name="data-nascimento" placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Defina um período:" class="classNINput data"/>
                            </li>
                            <li class="segundo">ativos</li>
                             <li class="terceiro">Pendentes</li>
                            <li class="quarto">inativos</li>
                        </ul>
                    </article> 
                    </section> 
                </div>
                </article><!-- end Div Relatorio -->

     
             
                </article>
            </article>
            <br clear="all" />
            <section class="tabGeral">
                                
                        
                    
            <table border="0" class="tabelaAssi">
                <thead>
                <tr>
                    <th width="48"><img src="images/seta-baixo.png" /></th>
                    <th width="65" heght="45">id</th>
                    <th width="220" height="45">Data de Criação</th>
                    <th width="260">Nome</th>
                    <th width="360">Empresa</th>
                    <th width="80" >Tipo</th>
                    <th width="145">Aos Cuidados</th>
                    <th width="98">Status</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                <td width="48"><input type="checkbox"></td>
                <td width="58" heght="45">1345</td>
                    <td width="116">11/08/1988</td>
                    <td width="260">
                        <section class="segUpper">
                          <ul class="sobreUpper">
                               <li><a href="#"><div align="center">Fabio Castro Ribeiro</div></a>
                                 <ul>
                                <li><article class="divMostra">
                                    <div class="Tabfuncao"><span class="calss">
                                    <a href="#" data-reveal-id="myModalCuidados" data-animation="fade" class="borderM">Aos Cuidados</a></span>
                                    <span class="calss"> <a href="juridicos.html" class="borderM">Editar</a></span>
                                    <strong class="calss"><a href="#" data-reveal-id="myModal" data-animation="fade" border="0" class="borderM">Inativar</a></strong><small class="calss"><a href="#" data-reveal-id="myModalCad" data-animation="fade">Visualizar</a></small></div>    
                                     </article> 
                                </li>
                            </ul>
                            </li>
                          </ul>
                        </section> 
                    </td>
                    <td width="360">Meio e Mensagem</td>
                    <td width="80" >Diaria</td>
                    <td width="145">Fabio Castro </td>
                    <td width="78">
                       <section class="segUpper">
                          <ul class="DuvUpper">
                               <li><a href="#"><img src="images/check-yellom.png" class="mxCheck" /></a>
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
                </tbody>
                <tbody>
                <tr>
                    <td width="48"><input type="checkbox"></td>
                <td width="58" heght="45">1345</td>
                    <td width="116">11/08/1988</td>
                    <td width="260">                  
                        <section class="segUpper">
                          <ul class="sobreUpper">
                               <li><a href="#">Fabio Castro Ribeiro</a>
                                 <ul>
                                <li><article class="divMostra">
                                    <div class="Tabfuncao"><span class="calss">
                                    <a href="#" data-reveal-id="myModalCuidados" data-animation="fade" class="borderM">Aos Cuidados</a></span>
                                    <span class="calss"> <a href="juridicos.html" class="borderM">Editar</a></span>
                                    <strong class="calss"><a href="#" data-reveal-id="myModal" data-animation="fade" border="0" class="borderM">Inativar</a></strong><small class="calss"><a href="#" data-reveal-id="myModalCad" data-animation="fade">Visualizar</a></small></div>     
                                     </article> 
                                </li>
                            </ul>
                            </li>
                          </ul>
                        </section>
                    </td>
                    <td width="360">Meio e Mensagem</td>
                    <td width="80" >Semanal</td>
                    <td width="145">Fabio Castro</td>
                    <td width="78">
                        <section class="segUpper">
                          <ul class="DuvUpper">
                               <li><a href="#"><img src="images/check-verde.png" class="mxCheck" /></a>
                                 <ul>
                                <li>
                                    <article class="divAviso">
                                        <strong>ativo&nbsp;&nbsp;</strong>  
                                        <p>sua assinatura
                                            está completa!</p>
                                     </article> 
                                </li>
                            </ul>
                            </li>
                          </ul>
                        </section>  
                    </td>
                </tr>
                </tbody>
                 <tbody>
                <tr>
                    <td width="48"><input type="checkbox"></td>
                    <td width="58" heght="45">1345</td>
                    <td width="116">11/08/1988</td>
                    <td width="260">
                        <section class="segUpper">
                              <ul class="sobreUpper">
       
                                <li><a href="#">Fabio Castro Ribeiro</a>
                                     <ul>
                                    <li><article class="divMostra">
                                    <div class="Tabfuncao"><span class="calss">
                                    <a href="#" data-reveal-id="myModalCuidados" data-animation="fade" class="borderM">Aos Cuidados</a></span>
                                    <span class="calss"> <a href="juridicos.html" class="borderM">Editar</a></span>
                                    <strong class="calss"><a href="#" data-reveal-id="myModal" data-animation="fade" border="0" class="borderM">Inativar</a></strong><small class="calss"><a href="#" data-reveal-id="myModalCad" data-animation="fade">Visualizar</a></small></div>    
                                         </article> 
                                    </li>
                                </ul>
                                </li>
                            </ul>
                       </section>                 
                    </td>
                    <td width="360">Meio e Mensagem</td>
                    <td width="80" >mensal</td>
                    <td width="145">Fabio Castro</td>
                    <td width="78">
                        <section class="segUpper">
                          <ul class="DuvUpper">
                               <li><a href="#"><img src="images/check-menos.png" class="mxCheck" /></a>
                                 <ul>
                                <li>
                                    <article class="divAviso">
                                        <strong>inativo</strong>  
                                        <p>a assinatura
                                            foi inativada.</p>
                                     </article> 
                                </li>
                            </ul>
                            </li>
                          </ul>
                        </section>  
                    </td>
                </tr>
                </tbody>
                <tbody>
                <tr>
                    <td width="48"><input type="checkbox"></td>
                    <td width="58" heght="45">1345</td>
                    <td width="116">11/08/1988</td>
                    <td width="260">
                         <section class="segUpper">
                          <ul class="sobreUpper">
                               <li><a href="#">Fabio Castro Ribeiro</a>
                                 <ul>
                                <li><article class="divMostra">
                                                       <div class="Tabfuncao"><span class="calss">
                                     <a href="#" data-reveal-id="myModalCuidados" data-animation="fade" class="borderM">Aos Cuidados</a></span>
                                    <span class="calss"> <a href="juridicos.html" class="borderM">Editar</a></span>
                                    <strong class="calss"><a href="#" data-reveal-id="myModal" data-animation="fade" border="0" class="borderM">Inativar</a></strong><small class="calss"><a href="#" data-reveal-id="myModalCad" data-animation="fade">Visualizar</a></small></div>     
                                     </article> 
                                </li>
                            </ul>
                            </li>
                          </ul>
                        </section>             
                    </td>
                    <td width="360">Meio e Mensagem</td>
                    <td width="80" >Diaria</td>
                    <td width="145">Fabio Castro</td>
                    <td width="78">
                        <section class="segUpper">
                          <ul class="DuvUpper">
                               <li><a href="#"><img src="images/check-verde.png" class="mxCheck" /></a>
                                 <ul>
                                <li>
                                    <article class="divAviso">
                                        <strong>ativo&nbsp;&nbsp;</strong>  
                                        <p>sua assinatura
                                            está completa!</p>
                                     </article> 
                                </li>
                            </ul>
                            </li>
                          </ul>
                        </section>

                    </td>
                </tr>
                </tbody>

            </table>
            </section> 
            </form><!--Fim do Formulario geral -->

            <div id="myModal" class="reveal-modal">
                <a class="close-reveal-modal closeN">&#215;</a>
                <section class="vAssinatura">
                    <h1>Inativar Assinatura</h1>
                    <span class="raquo3">&raquo</span>
                    <h2 class="txtPoup">Você tem certeza que deseja inativar essa assinatura?</h2>
                    <a href="#">
                        <a href="#" class="btnsim">Sim</a>
                    </a>
                    <a href="#">
                        <a href="#" class="btnao">Não</a>
                        <!--<small class="bacV"><img src="images/btn-nao.png" class="strongbtn" /></small>-->
                    </a><br clear="all" /><br clear="all" /><br clear="all" />
                    <span>Descreva o Motivo:</span>
                    <textarea rows="8" cols="60" class="txtTextarea" id="campos-valide"></textarea>
                    <strong class="txt-inati">* Inativação sujeita à validação do SAC</strong>
                    <input type="image" src="images/btn-enviar.png" class="btn_envar" />
                </section>
             </div>

            <!--<div id="myModalMensagem" class="reveal-modalMensagem">
                <a class="close-reveal-modal closeN">&#215;</a>
                <section class="vAssinaturaOu">
                    <h1>Alterar Dados</h1>
                    <h2 class="txtPoup">Você tem certeza que deseja alterar os dados ?</h2>
                    <a href="#">
                        <a href="#" class="btnsim">Sim</a>
                    </a>
                    <a href="#">
                        <a href="#" class="btnao">Não</a>
                    </a><br clear="all" /><br clear="all" /><br clear="all" />
               
                </section>
             </div>-->
  


	</section>
    <div id="myModalCuidados" class="reveal-modal-cuidados">
                <a class="close-reveal-modal closeCad">&#215;</a>

    <div class="content-cadastro">  
    
       <!-- MENU TOPO DE NAVEGAÇÃO -->      
       
        <form id="form-dadosPessoais" name="form-dadosPessoais" action="" method="post">
        <input type="hidden" name="id_veiculo" id="id_veiculo" value="1"/>
        <input type="hidden" name="id_endereco" id="id_endereco" />
                

         

              <div class="column2">            
                <!-- Formulário Dados Profissionais -->
                <div class="form-profissional" id="form-profissional">
                    <h5><strong class="icon-lado"></strong>deixar aos cuidados de: </h5>
                    <!--<a class="btn-depois" id="disable2"  title="Preencher depois">Preencher depois</a>
                    <a class="btn-depois" id="disable3"  title="Preencher agora">Preencher agora</a>-->
                    <div class="input-box">
                        <label for="empresa" style="padding-top: 10px">Nome</label>
                        <input type="text" name="nome" maxlength="200" disabled value="Ricardo Almeida" valor="" placeholder="Digite seu nome!" />
                    </div><!-- end input-box -->   
                </div><!-- end form-profissional -->
                
                <!-- ENDEREÇO DE ENTREGA -->
                <div class="form-endereco" id='form-endereco'>
                  <h4>&nbsp;</h4>
                  <div class="input-box">
                        <label for="e-mail" style="padding-top: 10px">E-mail</label>
                        <input type="text" id="campos-valide" disabled name="e-mail" value="ralmeida@grupomm.com.br" maxlength="100" valor="" placeholder="Digite seu e-mail" onblur="verEmail()" />
                  </div><!-- end input-box --> <br clear="all" />
                  <div class="segBoxCheck">
                        <p>O responsável pela assinatura poderá editar o endereço de entrega: </p>
                           <input type="checkbox" checked /><span class="tdCheck">Sim</span>
                           <input type="checkbox" /><span class="tdCheck">Não</span>
                  </div><!-- end input-box -->
                    <div class="btn-cadastroUm">
                        <a class="btn-prosseguir" href="#" onclick="alterarDadosEdi()">Editar</a>
                    </div><!-- end btn-cadastro -->
                      <div class="btn-cadastroDois">
                        <a class="btn-prosseguir" href="#" title="Prosseguir">enviar</a>
                    </div><!-- end btn-cadastro -->  
                  </div><!-- end form-endereco -->         
                
            </div><!-- end column-right -->

          


        </form> 
            
    </div><!-- content-cadastro -->

    </div>

<br clear="all" />
    <div id="myModalResponsavelEdi" class="reveal-modal-RespoEdi">
                <a class="close-reveal-modal closeCad">&#215;</a>

    <div class="content-cadastro">  
    
       <!-- MENU TOPO DE NAVEGAÇÃO -->      
       
        <form id="form-dadosPessoais" name="form-dadosPessoais" action="" method="post">
        <input type="hidden" name="id_veiculo" id="id_veiculo" value="1"/>
        <input type="hidden" name="id_endereco" id="id_endereco" />
                

         

              <div class="column2">            
                <!-- Formulário Dados Profissionais -->
                <div class="form-profissional" id="form-profissional">
                    <h5><strong class="icon-lado"></strong>Responsável: </h5>
                    <!--<a class="btn-depois" id="disable2"  title="Preencher depois">Preencher depois</a>
                    <a class="btn-depois" id="disable3"  title="Preencher agora">Preencher agora</a>-->
                    <div class="input-box">
                        <label for="empresa" style="padding-top: 10px">Nome</label>
                        <input type="text" name="nome" maxlength="200" value="Francisco Lopes" valor="" placeholder="Digite seu nome!" />
                    </div><!-- end input-box -->   
                </div><!-- end form-profissional -->
                
                <!-- ENDEREÇO DE ENTREGA -->
                <div class="form-endereco" id='form-endereco'>
                  <h4>&nbsp;</h4>
                  <div class="input-box">
                        <label for="e-mail" style="padding-top: 10px">E-mail</label>
                        <input type="text" id="campos-valide" name="e-mail" value="francisco-lopes@grupomm.com.br" maxlength="100" valor="" placeholder="Digite seu e-mail" onblur="verEmail()" />
                  </div><!-- end input-box --> <br clear="all" /><br clear="all" /><br clear="all" />
                    <div class="btn-cadastroUm">
                        <a class="btn-prosseguir" href="#" onclick="alterarDadosEdi()">Editar</a>
                    </div><!-- end btn-cadastro -->
                      <div class="btn-cadastroDois">
                        <a class="btn-prosseguir" href="#" title="Prosseguir">enviar</a>
                    </div><!-- end btn-cadastro -->  
                  </div><!-- end form-endereco -->         
                
            </div><!-- end column-right -->

          


        </form> 
            
    </div><!-- content-Editar -->

    </div>

  
<!-- Lixtbox de cadastro do juridico -->
            <div id="myModalCad" class="reveal-modal-cad">
                <a class="close-reveal-modal closeCad">&#215;</a>
      
<div class="content-cadastro">  
    
       <!-- MENU TOPO DE NAVEGAÇÃO -->      
       
        <form id="form-dadosPessoais" name="form-dadosPessoais" action="" method="post">
        <input type="hidden" name="id_veiculo" id="id_veiculo" value="1"/>
        <input type="hidden" name="id_endereco" id="id_endereco" />
                
            <div class="column">                  
                          <!-- Formulário Dados pessoais -->
                <div class="form-perfil form-profissional" >
                    <h3><strong class="icon-lado"></strong>dados corporativos</h3> 
                    <div class="input-box">
                        <label for="empresa" style="padding-top: 10px">Empresa</label>
                        <input type="text" id="campos-valide" name="nome" value="Meio e Mensagem" maxlength="200" disabled valor="" placeholder="Digite seu nome!" />
                    </div><!-- end input-box --> 
                    <div class="input-box">
                        <label for="empresa" style="padding-top: 10px">CNPJ</label>
                        <input type="text" id="campos-valide" name="cnpj" value="40.4545.445-99" maxlength="200" disabled valor="" placeholder="Digite seu CNPJ" />
                    </div><!-- end input-box --> 
                    <div class="input-box">
                        <label for="inscri-estadual">Inscrição Estadual</label>
                        <select class="campo1" id="inscri-estadual" name="inscri-estadual">
                            <option value="">54.101.829/0001-00</option>
                        </select>
                    </div><!-- end input-box -->
                    <div class="input-box">
                        <label for="porte-empresa">Porte da empresa</label>
                        <select class="campo1" id="porte-empresa" name="porte-empresa">
                            <option value="">1 a 100 Funcionarios</option>
                        </select>
                    </div><!-- end input-box -->
                    <div class="input-box">
                        <label for="ramo-atividade">Ramo de atividade</label>
                        <select class="campo1" id="ramo-atividade" name="ramo-atividade">
                            <option value="">veículo de comunicação</option>
                        </select>
                    </div><!-- end input-box -->
                    <div class="input-box">
                        <label for="e-mail" style="padding-top: 10px">E-mail</label>
                        <input type="text" id="e-mail" name="e-mail" value="grupomm@grupomm.com.br" disabled maxlength="100" valor="" placeholder="Digite seu e-mail" onblur="verEmail()" />
                    </div>      

                </br></br></br>
                
                </div>


                <!-- end form-perfil --> 
                    <!-- ENDEREÇO DE ENTREGA -->
                <div class="form-endereco" id='form-endereco'>
                    <h4>&nbsp;</h4>
                    <div class="input-box">
                        <label for="email-alternativo" style="padding-top: 10px">E-mail Segundario</label>
                         <input type="text" id="email-alternativo" value="publicidade@grupomm.com.br" disabled name="e-mail-alternativo" maxlength="200" valor="" 
                         placeholder="Digite um e-mail alternativo" />    
                     </div><!-- end input-box -->
                       <div class="input-box">
                        <label for="telefone" style="padding-top: 10px">Telefone</label>
                        <input type="text" id="telefone" name="telefone" value="(11) 3768-3500" disabled maxlength="200" valor="" placeholder="Digite Telefone" />
                    </div><!-- end input-box -->
                         <div class="input-box">
                        <label for="telefone-comercial" style="padding-top: 10px">Telefone Comercial</label>
                        <input type="text" id="telefone-comercial" value="(11) 3768-3500" disabled name="telefone-comercial" maxlength="200" valor="" placeholder="Digite Telefone Comercial" />
                    </div><!-- end input-box -->
                    <div class="input-box">
                        <label for="celular" style="padding-top: 10px">Celular</label>
                        <input type="text" id="celular" value="(11) 3768-3500" name="celular" disabled maxlength="200" valor="" placeholder="Digite Celular" />
                    </div><!-- end input-box -->
                </div><!-- end form-endereco --> 
                
            </div>          
            
            <div class="column2">            
                <!-- Formulário Dados Profissionais -->
                <div class="form-profissional" id="form-profissional">
                    <h5><strong class="icon-lado"></strong>responsável pela empresa</h5>
                    <!--<a class="btn-depois" id="disable2"  title="Preencher depois">Preencher depois</a>
                    <a class="btn-depois" id="disable3"  title="Preencher agora">Preencher agora</a>-->
                    <div class="input-box">
                        <label for="empresa" style="padding-top: 10px">Nome</label>
                        <input type="text" id="campos-valide" name="nome" value="José" disabled maxlength="200" valor="" placeholder="Digite seu nome!" />
                    </div><!-- end input-box --> 
                    <div class="input-box">
                        <label for="empresa" style="padding-top: 10px">Sobrenome</label>
                        <input type="text" id="campos-valide" name="Sobrenome" disabled value="Carvalho dos Santos" maxlength="200" valor="" placeholder="Digite seu CNPJ" />
                    </div><!-- end input-box --> 
                  <div class="input-box">
                        <label for="e-mail" style="padding-top: 10px">E-mail</label>
                        <input type="text" id="campos-valide" name="e-mail" disabled value="jcarvalho@grupomm.com.br" maxlength="100" valor="" placeholder="Digite seu e-mail" onblur="verEmail()" />
                    </div><!-- end input-box -->      
                </div><!-- end form-profissional -->
                
                
                         <!-- ENDEREÇO DE ENTREGA -->
                <div class="form-endereco" id='form-endereco'>
                    <h4>&nbsp;</h4>
                     <div class="input-box">
                        <label for="celular" style="padding-top: 10px">Celular</label>
                        <input type="text" id="campos-valide" name="celular" disabled value="(11) 98574-8512" maxlength="200" valor="" placeholder="Digite Celular" />
                    </div><!-- end input-box -->
                    
                    <div class="input-box">
                        <label for="areaatuacao" style="padding-top: 10px">área de atuação</label>
                        <select class="campoestado" id="campos-valide" name="areaatuacao">
                            <option value="">Administração</option>
                        </select>
                    </div><!-- end input-box -->
                    <div class="input-box">
                        <label for="nivelhieraquico" style="padding-top: 10px">nível hierárquico</label>
                        <select class="campopais" id="pais" name="nivelhieraquico">
                            <option value="">Diretor</option>
                        </select>
                    </div><!-- end input-box -->
                </div><!-- end form-endereco -->         
                
            </div><!-- end column-right -->

              <div class="column2">            
                <!-- Formulário Dados Profissionais -->
                <div class="form-profissional" id="form-profissional">
                    <h5><strong class="icon-lado"></strong>deixar aos cuidados de:

                    </h5>
                    <!--<a class="btn-depois" id="disable2"  title="Preencher depois">Preencher depois</a>
                    <a class="btn-depois" id="disable3"  title="Preencher agora">Preencher agora</a>-->
                    <div class="input-box">
                        <label for="empresa" style="padding-top: 10px">Nome</label>
                        <input type="text" name="nome" maxlength="200" disabled value="Ricardo Almeida" valor="" placeholder="Digite seu nome!" />
                    </div><!-- end input-box -->   
                </div><!-- end form-profissional -->
                
                <!-- ENDEREÇO DE ENTREGA -->
                <div class="form-endereco" id='form-endereco'>
                  <h4>&nbsp;</h4>
                  <div class="input-box">
                        <label for="e-mail" style="padding-top: 10px">E-mail</label>
                        <input type="text" id="campos-valide" disabled name="e-mail" value="ralmeida@grupomm.com.br" maxlength="100" valor="" placeholder="Digite seu e-mail" onblur="verEmail()" />
                  </div><!-- end input-box --> <br clear="all" />
                  <div class="segBoxCheck">
                        <p>O responsável pela assinatura poderá editar o endereço de entrega: </p>
                           <input type="checkbox" checked /><span class="tdCheck">Sim</span>
                           <input type="checkbox" /><span class="tdCheck">Não</span>
                  </div><!-- end input-box -->   
                  </div><!-- end form-endereco -->         
                
            </div><!-- end column-right -->

                        <div class="column2">            
                <!-- Formulário Dados Profissionais -->
                <div class="form-profissional" id="form-profissional">
                    <h5><strong class="icon-lado"></strong>Endereço</h5>
                    <!--<a class="btn-depois" id="disable2"  title="Preencher depois">Preencher depois</a>
                    <a class="btn-depois" id="disable3"  title="Preencher agora">Preencher agora</a>-->
                    <div class="input-box">
                        <label for="cep" style="padding-top: 10px">CEP</label>
                        <input class="cep campo inputNcep" type="text" value="06580 0000" id="cep" name="cep" onblur="buscarCep()" placeholder="Digite seu cep"  />
                        <span class="localizarCep"><a href="#">Localizar Cep</a></span>
                    </div><!-- end input-box -->
                    <div class="input-box">
                        <label for="logradouro" style="padding-top: 10px">Logradouro</label>
                        <input class="campo" type="text" value="Avenida" disabled id="campos-valide" name="logradouro" />
                    </div><!-- end input-box -->
                    <div class="input-box">
                        <label for="Endereço" style="padding-top: 10px">Endereço</label>
                        <input class="campo" type="text" value="Jaguaré" disabled id="campos-valide" name="endereco" />
                    </div><!-- end input-box -->
                    <div class="input-box">
                        <label for="numero" style="padding-top: 10px">Número</label>
                        <input class="campo" type="text" value="1485 / 87" disabled id="campos-valide" name="numero" />
                    </div><!-- end input-box -->
                    <div class="input-box">
                        <label for="numero" style="padding-top: 10px">Complemento</label>
                        <input class="campo" type="text" id="campos-valide" value="Padaria" disabled name="complemento" />
                    </div><!-- end input-box -->        
                </div><!-- end form-profissional -->
                
                
                         <!-- ENDEREÇO DE ENTREGA -->
                <div class="form-endereco" id='form-endereco'>
                    <h4>&nbsp;</h4>
                                     <div class="input-box">
                        <label for="bairro" style="padding-top: 10px">bairro</label>
                        <select class="campoestado" id="Jaguaré" name="bairro">
                            <option value="">Jaguaré</option>
                        </select>
                    </div><!-- end input-box -->
                    <div class="input-box">
                        <label for="cidade" style="padding-top: 10px">Cidade</label>                       
                        <select class="campocidade" id="Cidade" name="Cidade">
                            <option value="">São Paulo</option>
                        </select>
                    </div><!-- end input-box -->
                    <div class="input-box">
                        <label for="estado" style="padding-top: 10px">Estado</label>
                        <select class="campoestado" id="estado" name="estado">
                            <option value="">São Paulo</option>
                        </select>
                    </div><!-- end input-box -->
                    <div class="input-box">
                        <label for="pais" style="padding-top: 10px">País</label>
                        <select class="campopais'" id="pais" name="pais">
                            <option value="">Brasil</option>
                        </select>
                    </div><!-- end input-box -->
                </div><!-- end form-endereco --> 

                    <!-- Botões Continuar depois / Prosseguir -->
                    <div style="clear: both;"></div>       
                
            </div><!-- end column-right -->


        </form> 
            
    </div><!-- content-cadastro -->
    </div>
    <!--End de cadastro Juridico -->
</div><!-- End Efeito -->

  
</div>
 <script type='text/javascript' src="js/seleciona.js"></script>
</body>
</html>