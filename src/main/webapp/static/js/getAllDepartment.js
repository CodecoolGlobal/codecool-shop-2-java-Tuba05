import {getAllCategory} from "/static/js/getAllCategoryByDepartment.js";
import HtmlFactory from "./HtmlFactory.js";

const forCards = document.querySelector("#products");

export const getAllDepartment = {
    init: function () {
        fetch(`/api/get_all_department`)
            .then(response => response.json())
            .then(data => {
                this.cardFactory(data);
                setTimeout(this.addEventListenerToButton, 200);
            })
    },

    cardFactory: function (data){
        forCards.innerHTML = "";
        data.forEach(department => {
            const html = new HtmlFactory(department, "See all").createHtml();
            forCards.innerHTML += html;
        })
    },


    addEventListenerToButton: function (){
        const seeAllButtons = document.querySelectorAll("#see-all");
        seeAllButtons.forEach(button => {
            button.addEventListener('click', () => {
                let department = button.dataset.department;
                getAllCategory(department)
            })
        })
    }
}

