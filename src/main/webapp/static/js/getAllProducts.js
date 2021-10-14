
import {cardFactory} from "./productFactory.js";

function init() {
export function getAllProducts() {
    fetch(`/api/get_all_products`)
        .then(response => response.json())
        .then(data => {
            cardFactory(data);
        })
}

init()