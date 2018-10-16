function proov() {
    $.ajax({
        url: '/addKasutaja',
        type: 'POST',
        data: jQuery.param({id: "1", nimi: "2",email:"3",pilt:"4"}),
        success: function () {
            console.log("korras");
            window.location.href = "/";
        },
        error: function () {
            alert("Error while sending data");
            $("#result").html('Some kind of error :( !');
            window.location.href = "/";
        }

    });
}