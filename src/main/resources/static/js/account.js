function onSignIn(googleUser) {
    var id_token = googleUser.getAuthResponse().id_token;
    console.log(id_token);


    $.ajax({
        url: '/addKasutaja',
        type: 'POST',
        data: jQuery.param({token: id_token}),
        success: function () {
            console.log("korras");
        },
        error: function () {
            console.log("tokenit ei saadetud")
        }
    });
}