export const utils = {
    clearHtml: function (node){
        node.innerHTML = "";
    },

    setTimeOutToAddEventListener: function (eventListener){
        setTimeout(eventListener, 200);
    }
}

