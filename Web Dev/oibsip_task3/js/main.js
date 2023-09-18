const num = document.querySelector('#num');
const unit = document.querySelector('#unit');
const convertBtn = document.querySelector('#convertBtn');
const output = document.querySelector('#output');

// num.addEventListener('change', () => {
//     console.log('here are');
//     if (num.value <= '0' && num.value >= 0) {
//         num.style.backgroundColor = "red";
//     }
// })
convertBtn.addEventListener('click', () => {
    if (num.value <= '9' && num.value >= '0') {
        num.style.backgroundColor = "white";
        if (unit.value == 'cel') {
            let ans = ((num.value * 9) / 5) + 32;
            ans = ans.toFixed(2);
            output.value = `${ans} °Farenheit`
        } else {
            let ans = (num.value - 32) / 1.8;
            ans = ans.toFixed(2);
            output.value = `${ans} °Celcius`
        }
    } else {
        num.style.backgroundColor = "#FFA07A";
        output.value = "";
    }

})