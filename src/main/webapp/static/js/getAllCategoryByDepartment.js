import {getAllProducts} from "./getAllProducts.js";
const forCards = document.querySelector("#products");

export function getAllCategory() {
    fetch(`/api/get_all_category?department=Accessories`)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            cardFactory(data);
        })
}

function cardFactory(data) {
    forCards.innerHTML = "";
    data.forEach(item => {
        forCards.innerHTML += htmlFactory(item);
    })
}

function htmlFactory(item) {
    console.log(item.name);
    return `
        <div class="col col-sm-12 col-md-6 col-lg-4">
            <div class="card" id="${item.name}">
                <img class="" style="width:100%;height:300px;" src="/static/img/${item.name}.jpg"/>
                <div class="card-header">
                    <h4 class="card-title">${item.name}</h4>
                </div>
                <div class="card-body">
                    <div class="card-btn">
                        <a class="btn btn-success" id="see-all-product" data-department="${item.name}" >See products</a>
                    </div>
                </div>
            </div>
            </div>
    `
}

function addEventListenerToButton() {
    const seeAllButtons = document.querySelectorAll("#see-all-product");
    console.log(seeAllButtons);
    seeAllButtons.forEach(button => {
        button.addEventListener('click', event => {
            console.log("clicked");
            getAllProducts()
        })
    })
}

getAllCategory();
setTimeout(addEventListenerToButton, 200);