export function putProductToShoppingCart(){
    let url = "/shoppingcart?id=1";
    fetch(url)
        .then(r=>r.json())
        .then(data=>shoppingCartContentCreator(data));

}

function shoppingCartContentCreator(data){
    console.log(data);
    let contentField = document.getElementById("content");
    contentField.innerHTML +=
        `<a>${data.name}</a><a>${data.defaultPrice}</a>`

}