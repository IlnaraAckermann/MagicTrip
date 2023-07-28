const btnEscuro = document.getElementById('btnEscuro');
const btnClaro = document.getElementById('btnClaro');

btnEscuro.addEventListener('click', checkedRadio);
btnClaro.addEventListener('click', checkedRadio);


function lightToDark() {
    const lightTheme = document.querySelectorAll('.bg-light, .text-dark');

  lightTheme.forEach(e => {
    console.log('troca')
    e.classList.replace('bg-light', 'bg-dark');
    e.classList.replace('text-dark', 'text-white');
    e.classList.add('navbar-dark');
  });
}

function darkToLight() {
    const darkTheme = document.querySelectorAll('.bg-dark, .text-white, .navbar-dark');

    darkTheme.forEach(e => {
    console.log('troca')
    e.classList.replace('bg-dark', 'bg-light');
    e.classList.replace('text-white', 'text-dark');
    e.classList.remove('navbar-dark');
  });
}

function checkedRadio() {
  if (btnClaro.checked) {
    darkToLight();
  } else  {
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

//animando ao entrar na tela
const card = document.querySelectorAll('.card');
console.log(card)

let windowHeight = window.innerHeight;

function animatedCard() {
  card.forEach((card)=>{
    let bounding = card.getBoundingClientRect();
    if (bounding.top < windowHeight) {
      card.classList.add('cardAnimation')
    } 
  })
}

document.addEventListener("scroll", function () {
  animatedCard();
  document.removeEventListener("scroll", this);
});

window.addEventListener("resize", function () {
  windowHeight = window.innerHeight;
  window.removeEventListener("resize", this);
});

window.addEventListener("DOMContentLoaded", function () {
  animatedCard();
  window.removeEventListener("DOMContentLoaded", this);
});


const form = document.querySelector('form'); //

form.addEventListener('submit', function(event) {
  event.preventDefault(); 
  
  form.reset(); 
});


