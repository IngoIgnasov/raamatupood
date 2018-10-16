function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();

    var name = document.getElementById("name");
    //name.innerHTML = profile.getName();
    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.

    $.ajax({
        url: '/addKasutaja',
        type: 'POST',
        data: jQuery.param({id: profile.getId(), nimi: profile.getName(),email:profile.getEmail(),pilt:profile.getImageUrl()}),
        dataType: "json",
        success: function (response) {
            console.log(response);
        },
        error: function () {
            alert("error");
            $("#result").html('Some kind of error :( !');
        }
    });
}