
let cardRow=document.querySelector(".card-row")
let fetchAllProducts = () => {
  let a=""
  fetch("http://localhost:8080/api/getProducts")
    .then((data) => data.json())
    .then((products) => {
      products.map((product)=>{
        a+=`
        <div class="col-lg-4 col-md-4 card-col">
        <div class="card">
            <div class="img-div">
                <img class="card-img-top" src='${product.productImage}' alt='${product.productName}'>
            </div>
            <div class="card-body text-center">
                <div class="card-tittle">
                ${product.productName}
                    <p>
                    ${product.productDesc}
                    </p>
                    <span>
                    Price: ${product.productPrice}$
                    </span>
                    <div class="card-buttons">
                        <button class="card-button">Add to Favourite</button>
                        <button class="view-button"><a href="">View details</a></button>
  
                    </div>
                </div>
            </div>
        </div>
    </div>
        `
        cardRow.innerHTML=a
      })
      
    })
}
fetchAllProducts()