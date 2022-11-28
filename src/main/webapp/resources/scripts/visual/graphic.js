import {drawOnCanvas, listenUserClicks, drawCircle, clearCanvas} from "./canvas.js";

export function processGraphicElements() {
    drawOnCanvas()
    listenUserClicks()
}

export function drawShotsFromJson(json) {
    clearCanvas()
    drawOnCanvas()
    let resp = JSON.parse(json)
    for (let i = 0; i < resp['shots'].length; i++) {
        let shot = resp['shots'][i]
        drawCircle(shot['x'], shot['y'], shot['r'], shot['result'])
    }
}