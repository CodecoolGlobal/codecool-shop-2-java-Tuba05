export default class HtmlFactoryForProduct {
    constructor(product, category) {
        this.product = product;
        this.category = category;
    }

    createHtml(){
        return `
        <div class="col col-sm-12 col-md-6 col-lg-4">
            <div class="card" id="${this.product.id}">
                <img class="" style="width:100%;height: 300px" src="/static/img/${this.category}/${this.product.name}.jpg"/>
                <div class="card-header">
                    <h4 class="card-title">${this.product.name}</h4>
                    <p class="card-text">${this.product.description}</p>
                </div>
                <div class="card-body">
                    <div class="card-text">
                        <p class="lead">${this.product.defaultPrice} $</p>
                    </div>
                    <div class="card-btn" id="${this.product.id}">
                        <a class="btn btn-success" style="background: #ffd900; color: #333333; border-color: #ffd900">Add to cart</a>
                    </div>
                </div>
            </div>
            </div>
    `
    }

}