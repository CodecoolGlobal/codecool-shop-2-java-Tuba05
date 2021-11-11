import {cardFactory} from "./cardFactory.js";
import {putProductToShoppingCart} from './shoppingCart.js';

const forCards = document.querySelector("#products");

export function getAllProductsByCategory(category) {
    fetch(`/api/get_all_product_by_category?category=${category}`)
        .then(response => response.json())
        .then(data => {
            cardFactory.init(forCards, data, category, "product");
            putProductToShoppingCart()

        })
}
