export function cardFactory(data) {
    const forCards = document.querySelector("#products");
    forCards.innerHTML = "";
    data.forEach(item => {
        forCards.innerHTML += htmlFactory(item);
    })
}

export function htmlFactory(item) {
    return `
        <div class="col col-sm-12 col-md-6 col-lg-4">
            <div class="card" id="${item.id}">
                <img class="" src="/static/img/product_${item.id}.jpg"/>
                <div class="card-header">
                    <h4 class="card-title">${item.name}</h4>
                    <p class="card-text">${item.description}</p>
                </div>
                <div class="card-body">
                    <div class="card-text">
                        <p class="lead">${item.defaultPrice} $</p>
                    </div>
                    <div class="card-btn" id="${item.id}">
                        <a class="btn btn-success">Add to cart</a>
                    </div>
                </div>
            </div>
            </div>
    `
}