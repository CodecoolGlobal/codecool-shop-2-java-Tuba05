import {getAllProductsByCategory} from "./getAllProductByCategory.js";
import {getAllCategory} from "./getAllCategoryByDepartment.js";
import {init} from "./getAllDepartment.js";

const departments = document.querySelectorAll(".department-button");
departments.forEach(department => {
    department.addEventListener('click', () => {
        getAllCategory(department.dataset.name)
    });
})

const categories = document.querySelectorAll(".category-button");
const homeButton = document.querySelector(".home-button");
const loginButton = document.querySelector(".login-button");
const modal = document.getElementById('id01');

homeButton.addEventListener('click', event => {
        init();
    }
)

loginButton.addEventListener('click', event => {
    modal.style.display = "block";
    }
)

categories.forEach(category => {
    category.addEventListener('click', () => {
        getAllProductsByCategory(category.innerHTML);
    })
})





