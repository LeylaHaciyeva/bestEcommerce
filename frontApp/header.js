let button = document.querySelector(".menu-button")
let navigation = document.querySelector(".navigation")
let headerTop = document.querySelector(".header-top")
let headerBottom = document.querySelector(".header-bottom")
let close = document.querySelector(".close-icon")



button.addEventListener("click", function () {
  navigation.style.display = "block"
})


close.addEventListener("click", function () {
  navigation.style.display = "none"
})
// click=0
// length=1
// button.addEventListener("click",function () {
//     for (let i = 0; i < length; i++) {
//         if (click%2==0) {
//             navigation.style.display="block"
//             navigation.style.right=0+"px"
//         }
//         else{
//             navigation.style.display="none"

//         }
//         click++
//     }
// })


window.onscroll = function () {
  myFunction()
};

function myFunction() {
  if (document.documentElement.scrollTop > 50) {
    headerTop.style.display = "none";
    headerBottom.style.position = "fixed"
    headerBottom.style.top = 0
    headerBottom.style.right = 0
    headerBottom.style.left = 0
    headerBottom.style.backgroundColor = "white"
  } else if (document.documentElement.scrollTop < 50) {
    headerTop.style.display = "block";
    headerBottom.style.position = "relative"
  }
}