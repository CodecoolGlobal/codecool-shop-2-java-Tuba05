import HtmlFactoryForProduct from "./HtmlFactoryForProduct.js";
import {utils} from "./utils.js";

export function cardFactory(data, category) {
    const forCards = document.querySelector("#products");
    utils.clearHtml(forCards);
    data.forEach(product => {
        const html = new HtmlFactoryForProduct(product, category).createHtml();
        forCards.innerHTML += html;
    })
}