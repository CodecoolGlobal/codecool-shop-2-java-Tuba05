import {getAllCategory} from "/static/js/getAllCategoryByDepartment.js";
const forCards = document.querySelector("#products");

 window.onload = (event) => {
    init();
    setTimeout(addEventListenerToButton, 200);
 }

export function init() {
    fetch(`/api/get_all_department`)
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
                <img class="" style="width:100%;height:300px;" src="/static/img/department/${item.name}.jpg"/>
                <div class="card-header">
                    <h4 class="card-title">${item.name}</h4>
                </div>
                <div class="card-body">
                    <div class="card-btn">
                        <a class="btn btn-success" id="see-all" data-department="${item.name}" >See all</a>
                    </div>
                </div>
            </div>
            </div>
    `
}

function addEventListenerToButton() {
    const seeAllButtons = document.querySelectorAll("#see-all");
    console.log(seeAllButtons);
    seeAllButtons.forEach(button => {
        button.addEventListener('click', event => {
            console.log("clicked");
            getAllCategory()
        })
    })
}

