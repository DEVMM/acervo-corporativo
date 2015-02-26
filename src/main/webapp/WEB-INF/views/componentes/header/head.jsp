<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 
    prefix="fn" %> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 

<link rel="icon"  type="image/png"  href="${myUrl}resources/images/favicon.ico">

<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${fn:replace(req.requestURL, fn:substring(req.requestURI, 1, fn:length(req.requestURI)), req.contextPath)}" />
<c:set var="string1" value="${baseURL}/${MyID}"/>
<c:set var="string2" value="${fn:replace(string1, 
                                '8080//', '8080/')}" />
<c:url var="myUrl" value="${string2}" />    
 
    <link rel="stylesheet" type="text/css" href="${myUrl}resources/css/global.css">
    <link rel="stylesheet" type="text/css" href="${myUrl}resources/css/reset.css" />
    
    <!-- jQuery plugins -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
 	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>


 	<!--------------------------------------------- validaçao do formulario   ----------------------------->
 	<script type="text/javascript" src="${myUrl}resources/js/validacao.js"></script>
 	
	<!--------------------------------------------- Esses script são para mascaras ------------------------>
	<script src="${myUrl}resources/js/jquery-1.2.6.pack.js"></script>
	<script src="${myUrl}resources/js/jquery.maskedinput-1.1.4.pack.js"></script>
	<script src="${myUrl}resources/js/mascaras.js"></script>
	
	<!--list box -->
    <script src="${myUrl}resources/js/js-listbox/jquery.reveal.js"></script>
    <script src="${myUrl}resources/js/js-listbox/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="${myUrl}resources/js/js-listbox/jquery.reveal.js"></script>
    <link rel="stylesheet" type="text/css" href="${myUrl}resources/css/css-listbox/reveal.css">
    <!-- End List Box -->
 	