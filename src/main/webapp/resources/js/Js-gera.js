// var pageWidth =screen.availWidth;
// var pageHeight = screen.availHeight;
// var url = "http://localhost:8080/FormBuilder/Cadastro";


	var url = window.location;
	
	var urlString = url.toString();
	var urlArray = urlString.split("/");
	var tag = urlArray[urlArray.length-1];
	urv = "";
	for(var i=0; i<urlArray.length-2; i++){
		urv+=urlArray[i]+"/";
		}

var url = "http://localhost:8080/FormBuilder/Cadastro";
url = urv+"Cadastro";

qr = url.toString().substring(url.toString().lastIndexOf("?")+1, url.toString().length);
if(qr.indexOf("&")!=-1){
	ar = qr.split("&");
	met = ar[0].substring(4);
	fn = ar[1].substring(3);
	ln = ar[2].substring(3);
	em = ar[3].substring(3);
	dt = ar[4].substring(3,13);

	
	
}
	


$(function() {
	pageWidth = $(document).width();
	pageHeight = $(document).height();
	$( "#data-nascimento" ).datepicker({
		changeMonth: true,
	      changeYear: true,
	      minDate: "-120Y", maxDate: "-10Y",
	      yearRange: "-110:+110",
	      dateFormat: 'dd/mm/y',
	      showAnim: 'slideDown'
		});

	getPorte();
	getRamo();
	getNivel();
	getArea(); 
	var fn;
	var ln;
	var em;
	var dt;
	var met='k';
	var url2 = window.top.location;
	var urlString = url2.toString();
	
	

qr = url2.toString().substring(url2.toString().lastIndexOf("?"), url2.toString().length);
if(qr.indexOf("&")!=-1){
	ar = qr.split("&");
	met = ar[0].substring(5);
	fn = ar[1].substring(3);
	ln = ar[2].substring(3);
	em = ar[3].substring(3);
	dt = ar[4].substring(3,13);
	document.getElementById('nome').value = fn;
	document.getElementById('sobrenome').value = ln;
	document.getElementById('data-nascimento').value = dt;
	document.getElementById('e-mail').value = em;
$("#div_social").empty();
$("#email-alternativo").focus();

	
}


	
	
	/** autocomplete */

	var cache = {};
	$("#empresa").autocomplete({
		minLength : 2,
		source : function(request, response) {
			var term = request.term;
			if (term in cache) {
				response(cache[term]);
				return;
			}

			$.getJSON(url + "?met=auto", request, function(data, status, xhr) {
				cache[term] = data;
				response(data);
			});
		}
	});

	var cache2 = {};
	$("#cargo").autocomplete({
		minLength : 2,
		source : function(request, response) {
			var term = request.term;
			if (term in cache2) {
				response(cache2[term]);
				return;
			}

			$.getJSON(url + "?met=cargo", request, function(data, status, xhr) {
				cache2[term] = data;
				response(data);
			});
		}
	});
	/** autocomlete */

// 	alert("altura: "+$(document).height()+" winlar: "+$(window).height());

	
// 	$("html, body").animate({ scrollTop: $(document).height() }, 1000);
	$("html, body").animate({ scrollTop: 0 }, 1000);


		
	
});


$(document).ready(function(){
	$("#cpf").mask("999.999.999-99");
});

