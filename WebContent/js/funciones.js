$(document).ready(function(){
	
	
	$(".btnDelete").click(function(){
		var idp = $(this).parent().find(".idp").val();
		swal({
			title:"Estas seguro de eliminar?",
			text:"Una vez borrado, usted lo puede agregar de nuevo",
			icon: "warning",
			buttons:true,
			dengerMode: true,
		}).then((willDelete)=>{
			if(willDelete){
				eliminar(idp);
				swal("archivo borrado!", {
					icon: "success",
				}).then((willDelete)=>{
					if(willDelete){
						parent.location.href="Controlador?accion=Carrito";
					}
				})
			}else{
				swal("Registor no eliminado!!");
			}	
		})
	});
	
	function eliminar(idp){
		var url = "Controlador?accion=Delete";
		$.ajax({
			type:"post",
			url: url,
			data: "idp=" + idp,
			succes: function(data,textStatus,jqXHr){
				
			}
		})
	}
	
	
	$(".Cantidad").click(function(){
		
		var idp = $(this).parent().find(".idpro").val();
		var cantidad = $(this).parent().find(".Cantidad").val();
		var url = "Controlador?accion=ActualizarCantidad";
		
		$.ajax({
			type:"post",
			url: url,
			data: "idp=" + idp + "&cantidad=" + cantidad,
			success: function(data,textStatus,jqXHr){
				location.href="Controlador?accion=Carrito";	
			}
		})
	});
	
	
	
})