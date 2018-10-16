$(document).ready(function () {
    var namefield = $("#name");
    var emailfield = $("#email");
    var img = $("#image")
    if (sessionStorage.length > 0) {
        namefield.html(sessionStorage.accountName);
        emailfield.html(sessionStorage.accountEmail);
        img.attr("src",sessionStorage.accountIMG);
    }
})