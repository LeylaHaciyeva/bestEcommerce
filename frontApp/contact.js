let contactForm = document.querySelector(".contact-form")
contactForm.addEventListener("submit", async (e) => {
    e.preventDefault();
    let form = e.target;
    let formFirstName = form.firstname.value
    let formLastName = form.lastname.value
    let formEmail = form.email.value
    let formPassword = form.password.value
    let data = await fetch("http://localhost:8080/contact/post", {
        method: "POST",
        mode: "cors",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            userFirstName:"dfgfhfghfgh",
            userLastName:"dfgdfg",
            userEmail:"hgjhgj.com",
            userSubject:"khkj",
            userMessage:"messs"
        }),
    })
    let resp = await data.json()
    console.log(resp);
})