export function cardFactory(data, category) {
    const forCards = document.querySelector("#products");
    forCards.innerHTML = "";
    data.forEach(item => {
        forCards.innerHTML += htmlFactory(item, category);
    })
}

function htmlFactory(item, category) {
    return `
        <div class="col col-sm-12 col-md-6 col-lg-4">
            <div class="card" id="${item.id}">
                <img class="" style="width:100%;height: 300px" src="/static/img/${category}/${item.name}.jpg"/>
                <div class="card-header">
                    <h4 class="card-title">${item.name}</h4>
                    <p class="card-text">${item.description}</p>
                </div>
                <div class="card-body">
                    <div class="card-text">
                        <p class="lead">${item.defaultPrice} $</p>
                    </div>
                    <div class="card-btn" id="${item.id}">
                        <a class="btn btn-success" style="background: #ffd900; color: #333333; border-color: #ffd900">Add to cart</a>
                    </div>
                </div>
            </div>
            </div>
    `
}