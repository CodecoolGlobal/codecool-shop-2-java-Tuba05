import {getAllCategory} from "./getAllCategoryByDepartment.js";
import {getAllProductsByCategory} from "./getAllProductByCategory.js";

export function addEventListenerToButton(node, datasetType) {
    node.forEach(button => {
        button.addEventListener('click', () => {
            if (datasetType === "department") {
                let department = button.dataset.department;
                getAllCategory.init(department);
            } else {
                let category = button.dataset.category;
                getAllProductsByCategory(category)
            }
        })
    })
}