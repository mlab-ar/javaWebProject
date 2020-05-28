 
$(document).ready(function(){
	
//	$(".myAnchor").click(function(){
//		event.preventDefault();
//		 
//	});
	
	$(".btnDelete").click(function(e){
		e.preventDefault();
		var idp = $(this).parent().find(".idp").val();
		var test = $(this);
		swal({
			title:"Estas seguro de eliminar?",
			text:"Una vez borrado, usted lo puede agregar de nuevo",
			icon: "warning",
			buttons:true,
			dengerMode: true,
		}).then((willDelete)=>{
			if(willDelete){
				eliminar(idp, test);
				swal("archivo borrado!", {
					icon: "success",
				}).then((willDelete)=>{
					if(willDelete){
						//parent.location.href="carrito.jsp";
					}
				})
			}else{
				swal("Registor no eliminado!!");
			}	
		})
	});
	
	function eliminar(idp,elem){
		var url = "edit?accion=Delete";
		$.ajax({
			type:"post",
			url: url,
			data:"idp=" + idp,
			success: function(data){
				elem.parent().parent().remove();
				var elementosTabla = $("#shop-table tr");
				 console.log(data);
				if(elementosTabla.length <= 1){
					$(".container").append("<h2>No hay articulos en el carro</h2>");
					//location.href="edit?accion=Carrito";
				}
				//location.href="edit?accion=Carrito";
				$(".misProd").text(data[0])
				$("#text-subtotal").val(data[1]);
				$("#text-total").val(data[1]);
			}
		})
	}
	
	$(".Cantidad").click(function(){
		
		var idp = $(this).parent().find(".idpro").val();
		var cantidad = $(this).parent().find(".Cantidad").val();
		var url = "edit?accion=ActualizarCantidad";
		console.log(idp);
		$.ajax({
			type:"post",
			url: url,
			data: "idp=" + idp + "&cantidad=" + cantidad,
			success: function(data){
				location.href="edit?accion=Carrito";
			}
		})
	});
	
	
	
})