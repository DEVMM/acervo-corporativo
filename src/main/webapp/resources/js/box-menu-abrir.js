$(window).load(function() {
	 
	
$(".account-perfil").click(function()
		{
		var y=$(this).attr('id');

		if(y==1)
		{
		$(".submenu-perfil").hide();
		$(this).attr('id', '0');	
		}
		else
		{

		$(".submenu-perfil").show();
		$(this).attr('id', '1');
		}
			
		});

		//Mouseup textarea false
		$(".submenu-perfil").mouseup(function()
		{
		return false;
		});
		$(".account-perfil").mouseup(function()
		{
		return false;
		});


		//Textarea without editing.
		$(document).mouseup(function()
		{
		$(".submenu-alert").hide();
		$(".account-perfil").attr('id', '');
		
		});	
				
		
		
		$(".account-alert").click(function()
				{
				var y=$(this).attr('id');

				if(y==1)
				{
				$(".submenu-alert").hide();
				$(this).attr('id', '0');	
				}
				else
				{

				$(".submenu-alert").show();
				$(this).attr('id', '1');
				}
					
				});

				//Mouseup textarea false
				$(".submenu-alert").mouseup(function()
				{
				return false;
				});
				$(".account-alert").mouseup(function()
				{
				return false;
				});
	
				
				//Textarea without editing.
				$(document).mouseup(function()
				{
				$(".submenu-perfil").hide();
				$(".account-alert").attr('id', '');
				
				});	
});