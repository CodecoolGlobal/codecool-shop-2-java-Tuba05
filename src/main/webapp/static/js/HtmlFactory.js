export default class HtmlFactory {
    constructor(item, str) {
        this.item = item;
        this.str = str;
    }

    createHtmlForDepartment(){
        return `
        <div class="col col-sm-12 col-md-6 col-lg-4">
            <div class="card" id="${this.item.id}">
                <img class="" style="width:100%;height:300px;" src="/static/img/Department/${this.item.name}.jpg"/>
                <div class="card-header">
                    <h4 class="card-title">${this.item.name}</h4>
                </div>
                <div class="card-body">
                    <div class="card-btn">
                        <a class="btn btn-success" id="see-all" data-department="${this.item.name}" style="background: #ffd900; color: #333333; border-color: #ffd900">${this.str}</a>
                    </div>
                </div>
            </div>
            </div>
    `
    }

    createHtmlForCategory(){
        return `
        <div class="col col-sm-12 col-md-6 col-lg-4">
            <div class="card" id="${this.item.name}">
                <img class="" style="width:100%;height:300px;" src="/static/img/${this.item.name}.jpg"/>
                <div class="card-header">
                    <h4 class="card-title">${this.item.name}</h4>
                </div>
                <div class="card-body">
                    <div class="card-btn">
                        <a class="btn btn-success see-all-product" data-category="${this.item.name}" style="background: #ffd900; color: #333333; border-color: #ffd900" >${this.str}</a>
                    </div>
                </div>
            </div>
            </div>`
    }

    createHtmlForProduct(){
        return `
        <div class="col col-sm-12 col-md-6 col-lg-4">
            <div class="card" id="${this.item.id}">
                <img class="" style="width:100%;height: 300px" src="/static/img/${this.str}/${this.item.name}.jpg"/>
                <div class="card-header">
                    <h4 class="card-title">${this.item.name}</h4>
                    <p class="card-text">${this.item.description}</p>
                </div>
                <div class="card-body">
                    <div class="card-text">
                        <p class="lead">${this.item.defaultPrice} $</p>
                    </div>
                    <div class="card-btn" id="${this.item.id}">
                        <a class="btn btn-success" style="background: #ffd900; color: #333333; border-color: #ffd900">${this.str}</a>
                    </div>
                </div>
            </div>
            </div>
    `
    }
}