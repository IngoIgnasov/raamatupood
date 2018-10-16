function proov() {
    $.ajax({
        url: '/addKasutaja',
        type: 'POST',
        data: jQuery.param({id: "1", nimi: "2",email:"3",pilt:"4"}),
        success: function () {
            console.log("korras");
            location.assign("URL");
        },
        error: function () {
            alert("Error while sending data");
            $("#result").html('Some kind of error :( !');
            location.assign("URL");
        }

    });
}