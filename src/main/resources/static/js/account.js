function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();

    var name = document.getElementById("name");
    //name.innerHTML = profile.getName();
    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + name);
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
}