import {cardFactory} from "./cardFactory.js";

const forCards = document.querySelector("#products");

export function getAllProducts() {
    fetch(`/api/get_all_products`)
        .then(response => response.json())
        .then(data => {
            cardFactory.init(forCards, data, "Add to cart", "product");
        })
}
