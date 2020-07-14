(function(){

    var formulario = document.getElementById('codigoContraseña'),
        elementos = formulario.elements;
        
    var validarCodigo = function(e){
        if (formulario.valor1.value == "" || formulario.valor2.value == "" || formulario.valor3.value == "" || formulario.valor4.value == "" || formulario.valor5.value == "") {
            document.getElementById('alerta').innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el codigo</div>';
            e.preventDefault();
            formulario.valor1.focus();
            formulario.select();
        }
    };

    var validar = function(e){
        validarCodigo(e);
    };
    
    formulario.addEventListener('submit', validar);
}())