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
    <link rel="stylesheet" type="text/css" href="${myUrl}resources/css/css-listbox/reveal.css">
    <!-- Owl Carousel Assets -->
    <link href="${myUrl}resources/css/owl.carousel.css" rel="stylesheet">
    <link href="${myUrl}resources/css/owl.theme.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${myUrl}resources/css/reset.css" />
    <link rel="stylesheet" type="text/css" href="${myUrl}resources/css/calendario/jquery-ui-1.8.20.custom.css" />


    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
    <script src="${myUrl}resources/js/jquery-ui-1.10.4.custom.js"></script>
    <script src="${myUrl}resources/js/cadastro.js"></script>    
    
    <!----------------------------------------------- Carrocel --------------------------------------------> 
    <!--list box -->
    <script src="${myUrl}resources/js/js-listbox/jquery.reveal.js"></script>
    <script src="${myUrl}resources/js/js-listbox/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="${myUrl}resources/js/js-listbox/jquery.reveal.js"></script>
    <!-- End List Box -->

    <!--Calendario -->
    <script type="text/javascript" src="${myUrl}resources/js/calendario/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${myUrl}resources/js/calendario/jquery-ui-1.8.20.custom.min.js"></script>
    <script type="text/javascript" src="${myUrl}resources/js/calendario/calendario.js"></script>
 

<!-- --------------------------------------------- Carrocel --------------------------------------------> 
