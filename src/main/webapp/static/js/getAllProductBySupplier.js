import {cardFactory} from "./cardFactory.js";

const forCards = document.querySelector("#products");

function init(supplier) {
    fetch(`/api/get_all_product_by_supplier?supplier=${supplier}`)
        .then(response => response.json())
        .then(data => {
            cardFactory.init(forCards, data, supplier, "product");
        })
}

init();