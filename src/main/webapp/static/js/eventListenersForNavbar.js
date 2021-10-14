import {getAllProductsByCategory} from "./getAllProductByCategory.js";
import {getAllCategory} from "./getAllCategoryByDepartment.js";

const departments = document.querySelectorAll(".department-button");
departments.forEach(department => {
    department.addEventListener('click', ()=> {
        getAllCategory(department.dataset.name)});
})

const categories = document.querySelectorAll(".category-button");
categories.forEach(category => {
    category.addEventListener('click', () => {
        console.log(category.innerHTML)
        getAllProductsByCategory(category.innerHTML);
    })
})





