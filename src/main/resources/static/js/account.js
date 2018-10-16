function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();

    var name = document.getElementById("name");
    //name.innerHTML = profile.getName();


    var id = profile.getId();
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

    $.ajax({
        url: '/addKasutaja',
        type: 'POST',
        data: jQuery.param({id: id, nimi: nimi,email:email,pilt:pilt}),
        success: function () {
            console.log("korras");
        },
        error: function () {
            alert("error");
            $("#result").html('Some kind of error :( !');
        }
    });
}