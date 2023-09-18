// let container = document.querySelectorAll('.outer-container');
// let navLinks = document.querySelectorAll('nav ul li a');

// window.onscroll = () => {
//     container.forEach(con => {
//         let top = window.scrollY;
//         let offset = con.offsetTop - 300;
//         let height = con.offsetHeight;
//         let id = con.getAttribute('id');
//         if (top >= offset && top < offset + height) {
//             navLinks.forEach(links => {
//                 links.classList.remove('active');
//                 document.querySelector('nav ul li a[href*=' + id + ']').classList.add('active');
//             })
//         }
//     })
// }
const tabsBtn = document.querySelectorAll('.btn')
const outerContainer = document.querySelectorAll('.outer-container')
tabsBtn.forEach((tab, index) => {
    tab.addEventListener('click', () => {
        tabsBtn.forEach(tab => { tab.classList.remove('active') });
        tab.classList.add('active');
        outerContainer.forEach(container=>{container.classList.remove('show')})
        outerContainer[index].classList.add('show');
    })
})