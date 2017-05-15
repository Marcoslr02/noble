$('#estado').click(function() {

    //Se verifica si la opcion del select esta vacia
    if ($('#estado').val().trim() === '') {
        alert('Debes seleccionar una opcion');
    } else {
        alert('Campo correcto');
    }
});

function validarletynum(e){
  var teclad =(document.all) ? e.keyCode: e.which;
  if(teclad===8) return true;
  var patron = /[a-zA-Z0-9]/;
  tec=String.fromCharCode(teclad);
  return patron.test(tec);            
}
function validarlet(e){
  var teclad =(document.all) ? e.keyCode: e.which;
  if(teclad===8) return true;
  var patron = /[a-zA-ZnÑ]/;
  tec=String.fromCharCode(teclad);
  return patron.test(tec);            
}
function validarcorreo(e){
  var teclad =(document.all) ? e.keyCode: e.which;
  if(teclad===8) return true;
  var patron = /[a-zA-Z0-9@.]/;
  tec=String.fromCharCode(teclad);
  return patron.test(tec);            
}
function validarcomen(e){
  var teclad =(document.all) ? e.keyCode: e.which;
  if(teclad===8) return true;
  var patron = /[a-zA-Z0-9@. ]/;
  tec=String.fromCharCode(teclad);
  return patron.test(tec);            
}

function validarnum(e){
  var teclad =(document.all) ? e.keyCode: e.which;
  if(teclad===8) return true;
  var patron = /[0-9]/;
  tec=String.fromCharCode(teclad);
  return patron.test(tec);            
}