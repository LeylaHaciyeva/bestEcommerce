let cardRow = document.querySelector(".card-row")
let fetchAllWishlists = () => {
    let a = ""
    fetch(`http://localhost:8080/wishlist/${localStorage.getItem("token")}`)
        .then((data) => data.json())
        .then((wishlists) => {
            console.log(wishlists);
            wishlists.map((wishlist) => {
                a += `        
                    <div class="col-lg-4 col-md-4 card-col">
                    <div class="card">
                        <div class="img-div">
                             <img class="card-img-top" src='${wishlist.productImage}' alt='${wishlist.productName}'>
                        </div>
                        <div class="card-body text-center">
                            <div class="card-tittle">
                                        ${wishlist.productName}
                                <p>
                                        ${wishlist.productDesc}
                                </p>
                                <span>
                                        Price: ${wishlist.productPrice}$
                                </span>
                                <div class="card-buttons">
                                    <button class="card-button">
                                        Add to Basket
                                    </button>
                                    <a data-item=${wishlist.id} href="" class="card-button wishlist-remove_btn d-flex justify-content-center" >Remove from Wishlist</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                    `
                cardRow.innerHTML = a

                document.querySelectorAll(".wishlist-remove_btn").forEach(element => {
                    element.addEventListener("click", (e) => {
                        let selectedProductId = +e.target.getAttribute("data-item")
                        console.log(selectedProductId);
                        let deleteFromBasket = async () => {
                            let data = await fetch(`http://localhost:8080/wishlist/delete/${selectedProductId}?token=${localStorage.getItem("token")}`, {
                                method: "DELETE",
                            })
                        }
                        deleteFromBasket()

                    })
                })

            })
        })
}



fetchAllWishlists()