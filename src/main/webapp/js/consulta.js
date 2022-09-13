

$(document).ready(function(){



$('.usu').on('click',function(){
	alert("click en el boton");
consultarusuarios();
});



function consultarusuarios(){
	
$.ajax({
  url: "consultasgenerales",
  type:"post",
  dataType:"json",
  success: function( result ) {
  console.log(result);
  let tb=document.querySelector('#tabla');
  console.log(tb);
  tb.innerHTML="";
  tb.innerHTML=`<tr><th>Cedula</th>
                    <th>Nombre</th>
					<th>correo</th>
					<th>Usuario</th>
					<th>Password</th>
               </tr>`;
 for(let i of result){
	tb.innerHTML+=`<tr> <td>${i.Cedula_Usuario}</td> 
						 <td>${i.Nombre_Usuario}</td>
						 <td>${i.Email_Usuario}</td>
					     <td>${i.Usuario}</td>  
						 <td>${i.Password}</td>  
						</tr>`;
          }
      }
 });	
	
	
}
$('.cli').on('click',function(){
	alert("click en el boton")
	consultarclientes();
});

function consultarclientes(){

$.ajax({
	url: "consultasgeneralesclientes",
	type:"post",
	dataType:"json",
	success: function( result ) {
	console.log(result);
	let tab=document.querySelector('#tabla');	
	console.log(tab);
	tab.innerHTML="";
	tab.innerHTML=`<tr><th>Cedula</th>
	                   <th>Nombre</th>
					   <th>Correo</th>
					   <th>Direcion</th>
					   <th>Telefono</th>
	              </tr>`;
for(let i of result){
	tab.innerHTML+=`<tr> <td>${i.Cedula_Cliente}</td>
						 <td>${i.Nombre_Cliente}</td>
						 <td>${i.Email_Cliente}</td>
					     <td>${i.Direccion_Cliente}</td>
                         <td>${i.Telefono_Cliente}</td>
					</tr>`
           }
     	}
	
    });
		
 }
$('.ven').on('click',function(){
	alert("click en el boton")
	consultarventas();
});


function consultarventas(){

$.ajax({
	url:"consultageneralventas",
	type:"post",
	dataType:"json",
	success: function(result){
		console.log(result);
		let t=document.querySelector('#tabla');
		console.log(t);
		t.innerHTML="";
		t.innerHTML=`<tr><th>Cedua</th>
					      <th>Nombre</th>
						  <th>Tolal Ventas</th>
					 </tr>`;
for(let i of result){
	console.log(i)
	t.innerHTML+=`<tr> <td>${i.cedula}</td>
	                   <td>${i.Nombre}</td>
                       <td>${i.totalventas}</td>
                       
	              </tr>`;
            }
	     }
      });
   }
});
