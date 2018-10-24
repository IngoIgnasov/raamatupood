$(window).load(function () {
    var namefield = $("#name");
    var emailfield = $("#email");
    var img = $("#image")
    if (sessionStorage.length > 0) {
        namefield.html(sessionStorage.accountName);
        emailfield.html(sessionStorage.accountEmail);
        img.attr("src", sessionStorage.accountIMG);
    }
    img.attr("src", "https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg?auto=compress&cs=tinysrgb&h=350")
})