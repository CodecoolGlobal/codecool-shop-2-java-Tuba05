import {cardFactory} from "./productFactory.js";
import { putProductToShoppingCart } from './shoppingCart.js';

export function getAllProductsByCategory(category) {
    fetch(`/api/get_all_product_by_category?category=${category}`)
        .then(response => response.json())
        .then(data => {
           // console.log(data);
            cardFactory(data, category);
            putProductToShoppingCart()

        })
}
