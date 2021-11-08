import {getAllProductsByCategory} from "./getAllProductByCategory.js";

const forCards = document.querySelector("#products");

export function getAllCategory(department) {
    fetch(`/api/get_all_category?department=${department}`)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            cardFactory(data);
            addEventListenerToButton();
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
                        <a class="btn btn-success see-all-product" data-category="${item.name}" style="background: #ffd900; color: #333333; border-color: #ffd900" >See products</a>
                    </div>
                </div>
            </div>
            </div>`

}

function addEventListenerToButton() {
    const seeAllButtons = document.querySelectorAll(".see-all-product");
    console.log(seeAllButtons);

    seeAllButtons.forEach(button => {
        button.addEventListener('click', event => {
            console.log("clicked");
            let category = button.dataset.category;
            console.log(button);
            console.log(category)
            getAllProductsByCategory(category)
        })
    })
}

