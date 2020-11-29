export const uniqueArr = arr => {
    let newArr = []
    arr.forEach(value => {
        if (newArr.indexOf(value) === -1) {
            newArr.push(value)
        }
    })
    return newArr
}

export const setCookie = (name, value, day) => {
    let cookieText = encodeURIComponent(name) + '=' + encodeURIComponent(value)
    if (day) {
        var oDate = new Date()
        oDate.setDate(oDate.getDate() + day)
        cookieText += oDate
    }
    document.cookie = cookieText
}
export const removeCookie = (name) => {
    setCookie(encodeURIComponent(name), 1, -1)
}

export const getCookie = name => {
    let arr = document.cookie.split('; ')
    for(let i in arr) {
        let arrName = arr[i].split('=')
        if(arrName[0] = name) return arrName[1]
    }
}