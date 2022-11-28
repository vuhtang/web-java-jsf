const time = document.getElementById("time")
const date = document.getElementById("date")

function clock() {
    let today = new Date()

    let h = String(today.getHours())
    let m = String(today.getMinutes())
    let s = String(today.getSeconds())

    if (h.length < 2) h = "0" + h
    if (m.length < 2) m = "0" + m
    if (s.length < 2) s = "0" + s

    time.textContent = h + ":" + m + ":" + s

    let dd = String(today.getDate()).padStart(2, '0')
    let mm = String(today.getMonth() + 1).padStart(2, '0')
    let yyyy = today.getFullYear()

    date.textContent = dd + "/" + mm + "/" + yyyy
}

clock()
setInterval(clock, 1000)