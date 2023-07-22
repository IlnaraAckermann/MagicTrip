// const darkTheme = document.querySelectorAll('.bg-dark, .text-white, .navbar-dark');
// const lightTheme = document.querySelectorAll('.bg-light, .text-dark');
const btnEscuro = document.getElementById('btnEscuro');
const btnClaro = document.getElementById('btnClaro');

btnEscuro.addEventListener('click', checkedRadio);
btnClaro.addEventListener('click', checkedRadio);

// function darkToLight() {
//   darkTheme.forEach(e => {
//     console.log("Função darkToLight")
//     console.log("----------------")
//     e.classList.replace('bg-dark', 'bg-light');
//     e.classList.replace('text-white', 'text-dark');
//     if (!e.classList.contains('navbar-dark')){
//     e.classList.add('navbar-dark');}
//   });
// }

function lightToDark() {
    const lightTheme = document.querySelectorAll('.bg-light, .text-dark');
    console.log("Função lightToDark")
    console.log("----------------")
  lightTheme.forEach(e => {
    console.log('troca')
    e.classList.replace('bg-light', 'bg-dark');
    e.classList.replace('text-dark', 'text-white');
    e.classList.add('navbar-dark');
  });
}

function darkToLight() {
    const darkTheme = document.querySelectorAll('.bg-dark, .text-white, .navbar-dark');
    console.log("Função darkToLight")
    console.log("----------------")
    darkTheme.forEach(e => {
    console.log('troca')
    e.classList.replace('bg-dark', 'bg-light');
    e.classList.replace('text-white', 'text-dark');
    e.classList.remove('navbar-dark');
  });
}

function checkedRadio() {
    console.log("Função CheckedRadio")
    console.log("----------------")
  if (btnClaro.checked) {
    //   console.log("Mudando tema" + btnClaro.checked + " tema claro") 
    //   console.log("----------------")
    darkToLight();
  } else  {
    //   console.log("Mudando tema  " + btnEscuro.checked + " tema escuro")
    //   console.log("----------------")
    lightToDark();
  }
}

function checkUserPreference() {
  const prefersLightTheme = window.matchMedia('(prefers-color-scheme: light)').matches;

  if (prefersLightTheme) {
    btnEscuro.checked = false;
    btnClaro.checked = true;
  } else {
    btnClaro.checked = false;
    btnEscuro.checked = true;
  }
  checkedRadio() 
}

checkUserPreference();
// console.log("escuro: " + btnEscuro.checked)
// console.log("claro: " + btnClaro.checked)