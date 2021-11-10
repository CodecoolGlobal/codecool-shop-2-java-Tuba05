import {getAllCategory} from "/static/js/getAllCategoryByDepartment.js";
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
        data.forEach(item => {
            forCards.innerHTML += this.htmlFactory(item);
        })
    },

    htmlFactory: function (item){
        return `
        <div class="col col-sm-12 col-md-6 col-lg-4">
            <div class="card" id="${item.name}">
                <img class="" style="width:100%;height:300px;" src="/static/img/Department/${item.name}.jpg"/>
                <div class="card-header">
                    <h4 class="card-title">${item.name}</h4>
                </div>
                <div class="card-body">
                    <div class="card-btn">
                        <a class="btn btn-success" id="see-all" data-department="${item.name}" style="background: #ffd900; color: #333333; border-color: #ffd900"
                        >See all</a>
                    </div>
                </div>
            </div>
            </div>
    `
    },
    addEventListenerToButton: function (){
        const seeAllButtons = document.querySelectorAll("#see-all");
        seeAllButtons.forEach(button => {
            button.addEventListener('click', () => {
                console.log("clicked");
                let department = button.dataset.department;
                getAllCategory(department)
            })
        })
    }
}

