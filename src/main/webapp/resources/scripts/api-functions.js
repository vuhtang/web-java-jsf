import {DOMElements} from "../utils/const/DOMElements.js";

export const api = {

    fetchShot: function (x, y) {
        DOMElements.coordXHidden.value = x
        DOMElements.coordYHidden.value = y
        DOMElements.fireButtonHidden.click()
    }
}