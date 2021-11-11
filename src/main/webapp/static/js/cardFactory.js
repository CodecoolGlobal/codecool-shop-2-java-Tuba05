import {utils} from "./utils.js";
import HtmlFactory from "./HtmlFactory.js";

export const cardFactory = {
    init : function (node, data, str, type){
        utils.clearHtml(node);
        data.forEach(department => {
            const html = this.whichType(type, department, str);
            node.innerHTML += html;
        })
    },
    whichType : function (type, department, str){
        if(type === "department"){
            return new HtmlFactory(department, str).createHtmlForDepartment();
        } else if(type === "category"){
            return new HtmlFactory(department, str).createHtmlForCategory();
        } else {
            return new HtmlFactory(department, str).createHtmlForProduct();
        }
    }
}