function init() {
    fetch(`/api/get_all_products`)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            cardFactory(data);
        })
}

function cardFactory(data) {
    const forCards = document.querySelector("#products");
    forCards.innerHTML = "";
    data.forEach(item => {
        forCards.innerHTML += htmlFactory(item);
    })
}

function htmlFactory(item) {
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
                    <div class="card-btn">
                        <a class="btn btn-success" id="${item.id}" >Add to cart</a>
                    </div>
                </div>
            </div>
            </div>
    `
}

init()

