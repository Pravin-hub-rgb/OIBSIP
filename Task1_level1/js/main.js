hamburger = document.querySelector('.ham')
navbar = document.querySelector('.navbar')
firstSec=document.querySelector('.firstSec')
secondSec=document.querySelector('.secondSec')
hamburger.addEventListener('click',()=>{
    firstSec.classList.toggle('hide-item')
    secondSec.classList.toggle('hide-item')
    navbar.classList.toggle('hide-nav')
})