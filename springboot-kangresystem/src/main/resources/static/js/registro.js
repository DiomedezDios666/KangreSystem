// Validacion de formulario con bootstrap
(function() {
    'use strict';
    window.addEventListener('load', function() {
      // Fetch all the forms we want to apply custom Bootstrap validation styles to
      var forms = document.getElementsByClassName('needs-validation');
      // Loop over them and prevent submission
      var validation = Array.prototype.filter.call(forms, function(form) {
        form.addEventListener('submit', function(event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }
          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  })();



// Validacion del formulario con JavaScript    
(function (){
    
    var formulario = document.getElementsByName('formRegistro')[0],
        alerta = document.getElementById('alerta'),
        elementos = formulario.elements,
        boton = document.getElementById('btn-enviar');
    
    var validarNombres = function(evento){
        if (formulario.nombres.value.length == 0) {
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo Nombre(s)</div>';
            evento.preventDefault();
            formulario.nombres.focus();
            formulario.nombres.select();
        }
    };
    var validarApellidos = function (evento){
        if (formulario.apellidos.value.length == 0) {
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo Apellidos(s)</div>';
            evento.preventDefault();
            formulario.apellidos.focus();
            formulario.apellidos.select();
        }
    };
    var validarTipoDocumento = function(evento){
        if (formulario.tipoDocumento.value == 0 || formulario.tipoDocumento.value == null) {
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo Tipo de Documento</div>';
            evento.preventDefault();
            formulario.tipoDocumento.focus();
            formulario.tipoDocumento.select();
        }
    };
    var validarNumeroDocumento = function(evento){
        if (formulario.numeroDocumento.value.length == 0) {
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo Numero de Documento</div>';
            evento.preventDefault();
            formulario.numeroDocumento.focus();
            formulario.numeroDocumento.select();
        }
    };
    var validarCelular = function(evento){
        if (formulario.celular.value.length == 0) {
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo Celular</div>';
            evento.preventDefault();
            formulario.celular.focus();
            formulario.celular.select();
        }
    };
    var validarGenero = function(evento){
        if (formulario.genero[0].checked == true || formulario.genero[1].checked == true || formulario.genero[2].checked == true) {
        }else{
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo Genero</div>';
            evento.preventDefault();
            formulario.genero[0].focus();
            formulario.genero[0].select();
        }
    };
    var validarDireccion = function(evento){
        if (formulario.direccion.value.length == 0) {
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo Dirección</div>';
            evento.preventDefault();
            formulario.direccion.focus();
            formulario.direccion.select();
        }
    };
    var validarEmail1 = function(evento){
        if (formulario.email1.value.length == 0) {
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo E-mail</div>';
            evento.preventDefault();
            formulario.email1.focus();
            formulario.email1.select();
        }
    };
    var validarEmail2 = function(evento){
        if (formulario.email2.value.length == 0) {
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo Confirmar E-mail</div>';
            evento.preventDefault();
            formulario.email2.focus();
            formulario.email2.select();
        }
    };
    var validarCorreos = function(evento){
        if (formulario.email1.value !== formulario.email2.value) {
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Los campos E-mail no coinciden</div>';
            evento.preventDefault();
        }
    };
    var validarFechaNacimiento = function(evento){
        if (document.getElementById('fechaNacimiento').value == 0 || document.getElementById('fechaNacimiento').value == null) {
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo Fecha de Nacimiento</div>';
            evento.preventDefault();
            formulario.fechaNacimiento.focus();
            formulario.fechaNacimiento.select();
        }
    };
        var validar = function(evento){
            validarNombres(evento);
            validarApellidos(evento);
            validarTipoDocumento(evento);
            validarNumeroDocumento(evento);
            validarCelular(evento);
            validarGenero(evento);
            validarDireccion(evento);
            validarEmail1(evento);
            validarEmail2(evento);
            validarCorreos(evento);
            validarFechaNacimiento(evento);
        };
        
        formulario.addEventListener('submit',validar);
    }())