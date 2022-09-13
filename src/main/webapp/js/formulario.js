const formulario=document.getElementById('formulario');
const inputs=document.querySelectorAll('#formulario input')

const expresiones = {
	cedula: /^\d{10}$/,// 10 numeros.
	nombre:/^[a-zA-Z0]{3,20}$/,
	usuario: /^[a-zA-Z0-9\_\-]{4,16}$/, // Letras, numeros, guion y guion_bajo//
	gmail: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
	password: /^.{4,12}$/, // 4 a 12 digitos.
	telefono: /^\d{10}$/ // 7 a 14 numeros.
}
const campos={
	cedula:false,
	nombre:false,
	gmail:false,
	usuario:false,
	password:false,
	
	
}
const validarformulario =(e)=>{
	switch(e.target.name){
		case"cedula":
		    validarCampo(expresiones.cedula, e.target, 'cedula');
		break;
		case"nombre":
		      validarCampo(expresiones.nombre, e.target, 'nombre');
		break;
		case"gmail":
		      validarCampo(expresiones.gmail, e.target, 'gmail');
		break;
		
		case"usuario":
		    validarCampo(expresiones.usuario, e.target, 'usuario');
		
		break;
		
		case"password":
		      validarCampo(expresiones.password, e.target, 'password');
			  validarpassword2();
		break;
		case"password2":
		     validarpassword2();
		break;
		
	}
	
}
const validarCampo=(expresion,input,campo)=>{
	  if (expresion.test(input.value)){
			document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-incorrecto');
		    document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-correcto');
            document.querySelector(`#grupo__${campo} i`).classList.add('fa-check-circle');
            document.querySelector(`#grupo__${campo} i`).classList.remove('fa-times-circle');
            document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
			campos[campo] = true;
	 } else{
		   document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-incorrecto');
 		   document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-correcto');
		   document.querySelector(`#grupo__${campo} i`).classList.add('fa-times-circle');
           document.querySelector(`#grupo__${campo} i`).classList.remove('fa-check-circle');
           document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
           campos[campo] = false;
   }

}

const validarpassword2=()=>{
	const inputpassword1= document.getElementById('password');
	const inputpassword2= document.getElementById('password2');
	
	if(inputpassword1.value !== inputpassword2.value){
		 document.getElementById(`grupo__password2`).classList.add('formulario__grupo-incorrecto');
 		 document.getElementById(`grupo__password2`).classList.remove('formulario__grupo-correcto');
		 document.querySelector(`#grupo__password2 i`).classList.add('fa-times-circle');
         document.querySelector(`#grupo__password2 i`).classList.remove('fa-check-circle');
         document.querySelector(`#grupo__password2 .formulario__input-error`).classList.add('formulario__input-error-activo');
	     campos['password'] = false;
	}
	else{
		 document.getElementById(`grupo__password2`).classList.remove('formulario__grupo-incorrecto');
 		 document.getElementById(`grupo__password2`).classList.add('formulario__grupo-correcto');
		 document.querySelector(`#grupo__password2 i`).classList.remove('fa-times-circle');
         document.querySelector(`#grupo__password2 i`).classList.add('fa-check-circle');
         document.querySelector(`#grupo__password2 .formulario__input-error`).classList.remove('formulario__input-error-activo');
		campos['password'] = true;
		
	}
}

inputs.forEach((input) =>{
	input.addEventListener('keyup', validarformulario);
	input.addEventListener('blur', validarformulario);
});

formulario.addEventListener('submit',()=>{
	if (campos.cedula && campos.nombre && campos.gmail && campos.usuario && campos.password){
		
	}
});
