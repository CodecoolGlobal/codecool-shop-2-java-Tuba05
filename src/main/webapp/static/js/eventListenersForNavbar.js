import {getAllProductsByCategory} from "./getAllProductByCategory.js";


const categories = document.querySelectorAll(".category-button");
categories.forEach(category => {
    category.addEventListener('click', () => {
        getAllProductsByCategory(category.innerHTML);
    })
})





