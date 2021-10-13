window.onload = (event) => {
    init();
}

function init() {
    fetch(`/api/get_all_department`)
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
    console.log(item.name);
    return `
        <div class="col col-sm-12 col-md-6 col-lg-4">
            <div class="card" id="${item.name}">
                <img class="" src="/static/img/department/${item.name}.jpg"/>
                <div class="card-header">
                    <h4 class="card-title">${item.name}</h4>
                </div>
                <div class="card-body">
                    <div class="card-btn">
                        <a class="btn btn-success" id="${item.name}" >See all</a>
                    </div>
                </div>
            </div>
            </div>
    `
}
