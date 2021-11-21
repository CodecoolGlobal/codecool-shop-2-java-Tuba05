import {cardFactory} from "./cardFactory.js";
import {addEventListenerToButton} from "./addEventListenerToButton.js";

const forCards = document.querySelector("#products");

export const getAllCategory = {
    init: function (department) {
        fetch(`/api/get_all_category?department=${department}`)
            .then(response => response.json())
            .then(data => {
                cardFactory.init(forCards, data, "See products", "category")
                const seeAllButtons = document.querySelectorAll(".see-all-product");
                addEventListenerToButton(seeAllButtons, "category")
            })
    }
}

