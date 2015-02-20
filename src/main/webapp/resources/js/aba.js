$.quickTabs = function ()
{
 
	/* Elements */
 
	var tabs = 'p#tabs';
	var contents = 'ul#contents';
 
	/* Hide all tabs */
 
	$(contents + ' li').hide();
 
	/* Display the first tab */
 
	$(contents + ' li:first-child').show();
 
	/* When user click a tab */
 
	$(tabs + ' a').click(function()
	{
 
		/* Remove selected class on all tabs */
 
		$(tabs + ' a').removeClass('selected');
 
		/* Add a selected tab class */
 
		$(this).addClass('selected');
 
		/* Hide all opened tags */
 
		$(contents + ' li').hide();
 
		/* Display the clickec tab */
 
		$(contents +  ' ' + $(this).attr('href')).show();
 
		/* End :D */
 
		return false;
 
	});
 
};
 
/* When all is ready */
 
$(document).ready(function()
{
 
	/* Start function */
 
	$.quickTabs();
 
});
