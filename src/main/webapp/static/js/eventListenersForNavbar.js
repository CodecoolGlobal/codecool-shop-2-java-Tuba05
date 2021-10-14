import {getAllProductsByCategory} from "./getAllProductByCategory.js";
import {init} from "./getAllDepartment.js";


const categories = document.querySelectorAll(".category-button");
const homeButton = document.querySelector(".home-button");

homeButton.addEventListener('click', event => {
    init();
    }
)

categories.forEach(category => {
    category.addEventListener('click', () => {
        getAllProductsByCategory(category.innerHTML);
    })
})





