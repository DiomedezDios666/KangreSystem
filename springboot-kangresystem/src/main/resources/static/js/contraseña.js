// Validacion de formulario con Bootstrap
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

// Validacion de formulario con JavaScript
(function (){
    var formulario = document.getElementById('contraseña'),
        alerta = document.getElementById('alerta'),
        elementos = formulario.elements,
        boton = document.getElementById('btn');

    var validarPass1 = function(e){
        if (formulario.pass1.value.length == 0) {
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Escriba la Contraseña</div>';
            e.preventDefault();
            formulario.pass1.focus();
            formulario.pass1.select();        
        }
    };
    var validarPass2 = function(e){
        if (formulario.pass2.value.length == 0) {
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a> Confirma contraseña</div>';
            e.preventDefault();
            formulario.pass2.focus();
            formulario.pass2.select();        
        }
    };   

    var validar = function(e){
        validarPass2(e);
        validarPass1(e);
        // validarPass(e);
    };

    formulario.addEventListener('submit', validar);
}())

(function(){
    var formulario = document.getElementById('contraseña'),
    elementos = formulario.elements;

    var confirmarPass = function(e){
        if (formulario.pass1.value !== formulario.pass2.value) {
            alerta.innerHTML = '<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Contraseñas no coinciden</div>';
            e.preventDefault();
        }
    };

    var confirmar = function(e){
        confirmarPass(e);
    };

    formulario.addEventListener('submit', confirmar);
}())