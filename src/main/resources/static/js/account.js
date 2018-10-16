function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();

    var id = profile.getId();
    var id_token = googleUser.getAuthResponse().id_token;
    var nimi = profile.getName();
    var email = profile.getEmail();
    var pilt = profile.getImageUrl();

    //Sessiooni andmete salvestamine
    sessionStorage.accountID = id;
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