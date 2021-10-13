function init() {
    fetch(`/api/get_all_category`)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            //cardFactory(data);
        })
}

// function cardFactory(data) {
//     const forCards = document.querySelector("#products");
//     forCards.innerHTML = "";
//     data.forEach(item => {
//         forCards.innerHTML += htmlFactory(item);
//         console.log(item);
//     })
// }

init()