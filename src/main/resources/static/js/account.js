function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();

    var id = profile.getId();
    var id_token = googleUser.getAuthResponse().id_token;
    var nimi = profile.getName();
    var email = profile.getEmail();
    var pilt = profile.getImageUrl();


    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.

/*
    var id = "kala";
    var nimi = "on";
    var email = "sees@hotmai.com";
    var pilt  = "pilt";
*/
    console.log(id);
    console.log(nimi);
    console.log(email);
    console.log(pilt);
    console.log(id_token);

    $.ajax({
        url: '/addKasutaja',
        type: 'POST',
        data: jQuery.param({id: id_token, nimi: nimi,email:email,pilt:pilt}),
        success: function () {
            console.log("korras");
        },
        error: function () {
            alert("error");
            $("#result").html('Some kind of error :( !');
        }
    });
}

function tere(){
    console.log("tere");
}