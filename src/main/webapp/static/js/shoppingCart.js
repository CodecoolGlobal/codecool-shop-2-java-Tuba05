export function putProductToShoppingCart() {

    let putCartButton = document.querySelectorAll(".card-btn")

    for (let successButton of putCartButton) {
        successButton.addEventListener("click", () => {
            let url = `/shoppingcart?id=${successButton.id}`;
            productFetch(url);

        })
    }
}

function shoppingCartContentCreator(data){
    let counter = 0;
    counter++;
    productInCartCounter(counter);
    let contentField = document.getElementById("cart-content");
    contentField.innerHTML +=
        `<tr><td>
                <div class="row" >
                    <div class="col-lg-2 Product-img">
                        <img src="https://images.unsplash.com/photo-1562106783-b9ca87a40fc7?ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=60" alt="..." class="img-responsive" />
                    </div>
                    <div class="col-lg-10">
                        <h4 class="nomargin">${data.name}</h4>
                    </div>
                </div>
            </td>
            <td> ${data.defaultPrice} </td>
            <td data-th="Quantity">
                <input type="number" class="form-control text-center" value="1">
            </td>
            <td>12,000</td>
            <td id="${data.id}" class="actions" data-th="" style="width:10%;">
                <button class="btn btn-warning btn-sm" type="submit"><i class="fa fa-refresh"></i></button>
                <button id="delete-button" class="btn btn-danger btn-sm" type="submit"><i class="fa fa-trash-o"></i></button>
            </td>
        </tr>`
    deleteProductFromCart();
}

function productFetch(url){
    fetch(url)
        .then(r=>r.json())
        .then(data=>shoppingCartContentCreator(data));

}

function productInCartCounter(number){
    let counter = document.getElementById("productnumber");
    // counter.parentElement.style.background = rgb();
    let currentNumber = parseInt(counter.innerText);
    counter.innerHTML = (currentNumber + number);

}

export function deleteProductFromCart(){
    let deleteButtons = document.querySelectorAll("#delete-button")
    for (let deleteButton of deleteButtons) {
        deleteButton.addEventListener("click", () => {
            console.log(deleteButton.parentElement.id)
            deleteButton.parentElement.parentElement.remove();
            // let url = `/shoppingcart?id=${successButton.id}`;
            // productFetch(url);
        })
    }
}
