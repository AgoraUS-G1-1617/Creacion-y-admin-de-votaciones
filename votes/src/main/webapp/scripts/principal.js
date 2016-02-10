

function ocultarTodo(){
	var texto = document.querySelectorAll("#divTexto")[0];
	var imagenes = document.querySelectorAll("#divImagenes")[0];
	var fechaFin = document.querySelectorAll("#fechaFin")[0];
	addClass(texto,"hidden");
	addClass(imagenes,"hidden");
	addClass(fechaFin,"hidden");
}
function actualizar_opciones(){
	var texto = document.querySelectorAll("#divTexto")[0];
	var imagenes = document.querySelectorAll("#divImagenes")[0];
	if(document.querySelectorAll("#texto")[0].checked==true){
		addClass(imagenes,"hidden");
		removeClass(texto,"hidden");
	}else if(document.querySelectorAll("#imagenes")[0].checked==true){
		addClass(texto,"hidden");
		removeClass(imagenes,"hidden");
	}
	return false;
}
function actualiza_opcionFecha(s){
	var fechaFin = document.querySelectorAll("#fechaFin")[0];
	if(s.value=="si"){
		removeClass(fechaFin,"hidden");
	}else{
		addClass(fechaFin,"hidden");
	}
}
function removeClass(obj,cls){
	var miExpReg = /./;
    var exp =new RegExp('(\\s|^)'+cls+'(\\s|$)');
    obj.className=obj.className.replace(exp,"");
}
function addClass(obj,cls){
    obj.className+=" "+cls;
}