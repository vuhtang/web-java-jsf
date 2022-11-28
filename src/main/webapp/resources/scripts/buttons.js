import {DOMElements} from "../utils/const/DOMElements.js";
import {drawOnCanvas, clearCanvas} from "./visual/canvas.js"

export function listenButtons() {

    DOMElements.clearButton.addEventListener('click', function (event) {
        event.preventDefault()
        DOMElements.coordinateY.value = 0
        clearCanvas()
        drawOnCanvas()
    })

}