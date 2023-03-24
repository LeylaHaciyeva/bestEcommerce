let contactForm = document.querySelector(".contact-form")
contactForm.addEventListener("submit", async (e) => {
    e.preventDefault();
    let form = e.target;
    let formFirstName = form.userName.value
    let formLastName = form.userLastName.value
    let formEmail = form.userEmail.value
    let formSub = form.userSubject.value
    let formMessage= form.userMessage.value

    let data = await fetch("http://localhost:8080/contact/post", {
        method: "POST",
        mode: "cors",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            userFirstName:formFirstName,
            userLastName:formLastName,
            userEmail:formEmail,
            userSubject:formSub,
            userMessage:formMessage
        }),
    })
    if(data.status==201){
        Swal.fire({
            title: '<strong>Message sent</strong>',
            icon: 'info',
          })           
        form.userName.value=""
        form.userLastName.value=""
        form.userEmail.value=""
        form.userSubject.value=""
        form.userMessage.value=""
    }
  
})