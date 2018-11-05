$(window).on('load', function () {
    $.ajax({
        url: '/byCategory',
        type: 'POST',
        dataType: "json",
        success: function (response) {
            console.log(response);
            var length = response.length;
            var i;
            for (i = 0; i < length; i++) {
                var category = response[i].kategooria;
                var amount = response[i].arv;
                $("#licategory").append($("<li>").append($('<a id="'+category+'" onclick=location.reload() >').attr('href', '/raamatMainPage#'+category).text(category + "    - " + amount)));
            }
        },
        error: function () {
            alert("error");
            $("#result").html('Some kind of error :( !');
        }
    });
})

