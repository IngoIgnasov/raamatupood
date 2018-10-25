$(document).ready(function () {

    $('#testbtn').click(function () {
        $.ajax({
            url: '/byCategory',
            type: 'POST',
            dataType: "json",
            success: function (response) {

                console.log(response);
            },
            error: function () {
                alert("error");
                $("#result").html('Some kind of error :( !');
            }
        });
    });
})