		$(document).ready(function() {		 
		    $("#owl-demo").owlCarousel({
				autoPlay : 5000,
				paginationSpeed : 1000,
				goToFirstSpeed : 1000,
				singleItem : true,
				autoHeight : true,
			  });		 
		});
		



	
	$.noConflict();jQuery(document).ready(function($){
		$("#carousel-image-and-text").touchCarousel({
			pagingNav:false,snapToItems:false,itemsPerMove:1,scrollToLast:false,loopItems:false,scrollbar:true
		});
		$("#carousel-image-and-footer").touchCarouselFooter({
			pagingNav:false,snapToItems:false,itemsPerMove:1,scrollToLast:false,loopItems:false,scrollbar:true
		});
	});
