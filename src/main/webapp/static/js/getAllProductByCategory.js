import {cardFactory} from "./productFactory.js";

function init() {
    fetch(`/api/get_all_product_by_category?category=Glasses`)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            cardFactory(data);
        })
}

init();