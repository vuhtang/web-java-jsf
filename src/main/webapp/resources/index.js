import {listenUserChanges} from "./scripts/listener.js";
import {processGraphicElements, drawShotsFromJson} from "./scripts/visual/graphic.js";

document.addEventListener("DOMContentLoaded", () => {
    startApplication()
})

window.drawShots = drawShotsFromJson;

const startApplication = () => {
    processGraphicElements()
    listenUserChanges()
}
