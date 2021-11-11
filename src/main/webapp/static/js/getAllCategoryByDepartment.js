import {getAllProductsByCategory} from "./getAllProductByCategory.js";
import HtmlFactory from "./HtmlFactory.js";
import {utils} from "./utils.js";

const forCards = document.querySelector("#products");

export const init = {
    getAllCategory : function (department){
        fetch(`/api/get_all_category?department=${department}`)
            .then(response => response.json())
            .then(data => {
                console.log(data);
                this.cardFactory(data);
                utils.setTimeOutToAddEventListener(this.addEventListenerToButton);
            })
    },

    cardFactory: function (data){
        utils.clearHtml(forCards);
        data.forEach(item => {
            const html = new HtmlFactory(item, "See products").createHtmlForCategory();
            forCards.innerHTML += html;
        })
    },

    addEventListenerToButton: function (){
        const seeAllButtons = document.querySelectorAll(".see-all-product");
        seeAllButtons.forEach(button => {
            button.addEventListener('click', () => {
                let category = button.dataset.category;
                getAllProductsByCategory(category)
            })
        })
    }
}

