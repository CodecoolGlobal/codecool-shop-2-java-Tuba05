import {Department} from "/static/js/Department.js";

export default class HtmlFactory {
    constructor(department, title) {
        this.department = new Department(department.id, department.name);
        this.title = title;
    }

    createHtml(){
        return `
        <div class="col col-sm-12 col-md-6 col-lg-4">
            <div class="card" id="${this.department.name}">
                <img class="" style="width:100%;height:300px;" src="/static/img/Department/${this.department.name}.jpg"/>
                <div class="card-header">
                    <h4 class="card-title">${this.department.name}</h4>
                </div>
                <div class="card-body">
                    <div class="card-btn">
                        <a class="btn btn-success" id="see-all" data-department="${this.department.name}" style="background: #ffd900; color: #333333; border-color: #ffd900">${this.title}</a>
                    </div>
                </div>
            </div>
            </div>
    `
    }

}