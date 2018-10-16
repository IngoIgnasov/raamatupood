$(document).ready(function () {
    var namefield = $("#name");
    if (sessionStorage.length > 0) {
        namefield.html("ID on" + sessionStorage.accountID)
    }
})