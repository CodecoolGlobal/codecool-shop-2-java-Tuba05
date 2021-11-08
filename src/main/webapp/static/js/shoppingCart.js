export function putProductToShoppingCart() {

    let putCartButton = document.querySelectorAll(".card-btn")
    console.log(putCartButton)
    for (let successButton of putCartButton) {
        successButton.addEventListener("click", () => {
            let url = `/shoppingcartadd?id=${successButton.id}`;
            productFetch(url);

        })
    }
}

function shoppingCartContentCreator(data){
    let counter = 1;
    // counter++;
    productInCartCounter(counter);
    let contentField = document.getElementById("cart-content");
    contentField.innerHTML +=
        `<tr id="${data.id}"><td>
                <div class="row" >
                    <div class="col-lg-10">
                        <h4 class="nomargin">${data.name}</h4>
                    </div>
                </div>
            </td>
            <td id="current-price${data.id}" class="price">${data.defaultPrice}</td>
            <td data-th="Quantity" id="quantity">
                <input id="quantity-changer" type="number" class="form-control text-center" value="1">
            </td>
           <td><a id="all-price${data.id}">${data.defaultPrice}</a></td>
            <td id="${data.id}" class="actions" data-th="" style="width:10%;">
                <button id="delete-button" class="btn btn-danger btn-sm" type="submit"><i class="fa fa-trash-o"></i></button>
            </td>
        </tr>`
    deleteProductFromCart()
    amountCounter()
    // checkOut()
}

function productFetch(url){
    fetch(url)
        .then(r=>r.json())
        .then(data=>shoppingCartContentCreator(data));

}

function productInCartCounter(number){
    let counter = document.getElementById("productnumber");
    let currentNumber = parseInt(counter.innerText);

    if(number>0){
        counter.innerHTML = (currentNumber + number);
    }
    if(number<0){
        counter.innerHTML = (currentNumber + number);
    }

}

export function deleteProductFromCart(){
    let deleteButtons = document.querySelectorAll("#delete-button")
    for (let deleteButton of deleteButtons) {
        deleteButton.addEventListener("click", () => {
            deleteButton.parentElement.parentElement.remove();
            let url = `/shoppingcartdelete?id=${deleteButton.parentElement.id}`;
            productFetch(url);
            productInCartCounter(-1);
        })
    }
}

function amountCounter(){
    let allPrice = document.querySelectorAll(".price");
    let totalPriceInCartVisual = document.getElementById("total-price");
    // console.log(sumPrice);
    let sumPrice = 0;
    for(let productPrice of allPrice){
        totalPriceInCartVisual.innerHTML = "";
        sumPrice += parseInt(productPrice.innerText);
        // sumPrice.toString();
        console.log(sumPrice);
        totalPriceInCartVisual.innerHTML += `Total: ${sumPrice} $`;

    }
    // document.getElementById('.quantity-changer').forEach(item => item.addEventListener("change",));

        // console.log(amountField);
        // amountField.addEventListener("change", ()=>{
        //     let productId = amountField.id;
        //     let currentAmount = amountField.value;
        //     let currentPrice = document.getElementById(`current-price${productId}`)
        //     let currentField = document.getElementById(`all-price${productId}`)
        //     currentField.innerHTML = "";
        //     let actuelPrice = (currentPrice * currentAmount);
        //     currentField.innerHTML = `${actuelPrice}`;
        // })
}

export function checkOut(){
    let checkOutButton = document.getElementById("check-out");
    let cartContent = document.getElementById("cart-content");
    let cartAmountConter = document.getElementById("productnumber");
    let totalPriceInCartVisual = document.getElementById("total-price");
    checkOutButton.addEventListener("click", ()=>{
        cartContent.innerHTML = "";
        cartAmountConter.innerHTML = 0;
        totalPriceInCartVisual.innerHTML = `Total: 0 $`;
        alert("Thank you for your buying!!");

    })
}
