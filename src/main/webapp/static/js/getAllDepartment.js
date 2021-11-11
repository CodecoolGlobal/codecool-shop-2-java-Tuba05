import {cardFactory} from "./cardFactory.js";
import {addEventListenerToButton} from "./addEventListenerToButton.js";

const querySelectors = {
    forCards: document.querySelector("#products"),
    seeAllButtons: document.querySelectorAll("#see-all")
}

export const getAllDepartment = {
    init: function () {
        fetch(`/api/get_all_department`)
            .then(response => response.json())
            .then(data => {
                cardFactory.init(querySelectors.forCards, data, "See all", "department");
                const seeAllButtons = document.querySelectorAll("#see-all")
                addEventListenerToButton(seeAllButtons, "department");
            })
    },
}

