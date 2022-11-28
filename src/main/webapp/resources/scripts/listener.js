import {bindValidation} from "./validator.js";
import {listenButtons} from "./buttons.js";

export function listenUserChanges() {
    listenButtons()
    bindValidation()
}
