$(function () {
    $("#smartIdButton").click(function (e) {
        e.preventDefault();
        $.ajax({
            url: '/smart-id/authentication/start',
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {
                $("#verification-code-text").text(data.code);
                console.log("Success");
                console.log(data);
                pollResult();
            },
            error: function (data) {
                console.log("Failure");
                console.log(data);
                $("#verification-code-text").text("XXXX");
            },
            data: JSON.stringify(getFormData())
        });
    })
});

function pollResult() {
    console.log("ootan tulemust!")
    $.ajax({
        url: '/smart-id/authentication/poll',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            console.log("Success");
            console.log(data);
            console.log("redirect here");
            window.location.href = "/";
        },
        error: function (data) {
            console.log("Failure");
            console.log(data.responseJSON);
            $("#main-text").text(data.responseJSON.errorMessage);
            $("#verification-code-text").text("XXXX");
        }
    });
}

function getFormData() {
    var formDataAsJSON = {};
    $.each($("form").serializeArray(), function (index, value) {
        formDataAsJSON[value.name] = value.value;
    });
    return formDataAsJSON;
}

