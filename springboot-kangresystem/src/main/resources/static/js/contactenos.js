// Validacion de Formularios con Bootstrap
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

// Validacion de Formularios con JavaScript
  (function(){

    var formulario = document.getElementById('contacto'),
        alerta = document.getElementById('alerta'),
        elementos = formulario.elements,
        boton = document.getElementById('btn');

    var validarDestino = function(e){
        if(formulario.destino.value == 0){
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Selecciona un Destinatario</div>';
            e.preventDefault();
            formulario.destino.focus();
            formulario.destino.select();
        }
    }
    var validarNombres = function(e){
        if(formulario.nombres.value.length == 0){
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo Nombres</div>';
            e.preventDefault();
            formulario.nombres.focus();
            formulario.nombres.select();
        }
    }
    var validarTelefono = function(e){
        if(formulario.telefono.value.length == 0){
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo Teléfono</div>';
            e.preventDefault();
            formulario.telefono.focus();
            formulario.telefono.select();
        }
    }
    var validarCorreo = function(e){
        if(formulario.correo.value.length == 0){
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo E-mail</div>';
            e.preventDefault();
            formulario.correo.focus();
            formulario.correo.select();
        }
    }
    var validarCiudad = function(e){
        if(formulario.ciudad.value == 0 || formulario.ciudad.value == null){
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Selecciona una Cuidad</div>';
            e.preventDefault();
            formulario.ciudad.focus();
            formulario.ciudad.select();
        }
    }
    var validarMensaje = function(e){
        if(formulario.mensaje.value.length == 0){
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Completa el campo Mensaje</div>';
            e.preventDefault();
            formulario.mensaje.focus();
            formulario.mensaje.select();
        }
    }
    var validar = function(e){
        validarDestino(e);
        validarNombres(e);
        validarTelefono(e);
        validarCorreo(e);
        validarCiudad(e);
        validarMensaje(e);
    };

    formulario.addEventListener('submit' ,validar);

  }())