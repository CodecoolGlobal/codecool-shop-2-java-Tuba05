import {getAllProductsByCategory} from "./getAllProductByCategory.js";
import {getAllCategory} from "./getAllCategoryByDepartment.js";
import {getAllDepartment} from "./getAllDepartment.js";

const querySelectors = {
    departments: document.querySelectorAll(".department-button"),
    categories: document.querySelectorAll(".category-button"),
    homeButton: document.querySelector(".home-button"),
    loginButton: document.querySelector(".login-button"),
    modal: document.getElementById('id01')
}

querySelectors.departments.forEach(department => {
    department.addEventListener('click', () => {
        getAllCategory.init(department.dataset.name)
    });
})

querySelectors.homeButton.addEventListener('click', () => {
        getAllDepartment.init();
    }
)

querySelectors.loginButton.addEventListener('click', () => {
        querySelectors.modal.style.display = "block";
    }
)

querySelectors.categories.forEach(category => {
    category.addEventListener('click', () => {
        getAllProductsByCategory(category.innerHTML);
    })
})





