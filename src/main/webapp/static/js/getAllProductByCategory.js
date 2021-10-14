import {cardFactory} from "./productFactory.js";

export function init(category) {
    fetch(`/api/get_all_product_by_category?category=${category}`)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            cardFactory(data);
        })
}

init();