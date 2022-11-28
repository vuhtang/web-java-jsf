export const DOMElements = {
    form: document.getElementById("shot"),
    fireButton: document.querySelectorAll("input[value='FIRE']")[0],
    table: document.getElementsByTagName('tbody')[0],
    canvas: document.getElementById("area-image"),
    fireButtonHidden: document.querySelectorAll("#graph-click input[type='submit']")[0],

    //y
    coordinateY: document.querySelectorAll(".graph input[type='text']")[0],
    coordinateYWarning: document.getElementById("y_warning"),

    //x
    coordinateXWarning: document.getElementById("x_warning"),
    coordinatesX: document.querySelectorAll("input[type='radio']"),
    coordXHidden: document.getElementById("graph-click:coordinate-x-hidden"),
    coordYHidden: document.getElementById("graph-click:coordinate-y-hidden"),

    //r
    buttonsRVisible: document.querySelectorAll(".r-buttons"),
    currentRVisible: document.getElementById("shot:r-visible"),

    //clear
    clearButton: document.querySelectorAll("#history input[type='submit']")[0]
}
