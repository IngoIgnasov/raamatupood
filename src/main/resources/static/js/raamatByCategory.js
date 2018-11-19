$(window).load(function () {


    if (!(navigator.onLine))
        $("#resultdiv").append($('<p style="font-size:30px">Teil pole internetti! Ühendage internetiga ja proovige uuesti!</p>'));
    else {
        var anchor = document.location;
        anchor = String(anchor);
        anchor = anchor.split("#");

//kui on juba ankur küljes, vaatleme seda
        if (anchor.length > 1) {
            anchor = anchor[1];
        } else {
            anchor = anchor[0];
        }

        console.log(anchor);
        if (anchor === "all") {
            $.ajax({
                url: '/allraamatud',
                type: 'POST',
                dataType: "json",
                success: function (response) {
                    var length = response.length;
                    console.log(response);
                    for (i = 0; i < length; i++) {

                        var div = $('<div style=" padding-right:20px; display:flex;align-items:center;" id="dynamic">');
                        var div2 = $('<div style="padding-bottom:10px; width: 100%;" id="dynamic">');
                        var div3 = $('<div style="padding-left:20px" ALIGN="center" id="dynamic">');

                        //loome pildi ja lisame result divi
                        var img = $('<img ALIGN="left" id="dynamic">');
                        img.attr("width", "200");
                        img.attr("src", "data:image/jpeg;base64," + response[i].pilt)
                        img.appendTo(div2);
                        $(div3).append($('<p></p><b style="font-size:30px">"' + response[i].pealkiri + '"</b></p>'));
                        $(div3).append($('<p>"' + response[i].autor + '"</p>'));
                        $(div3).append($('<p>10€</p>'));
                        $(div3).append($('<p>"' + response[i].lk + '" lk</p>'));
                        $(div3).append($('<p>Laos: "' + response[i].kogus + '"</p>'));

                        div3.appendTo(div2);
                        div2.appendTo(div);
                        div.appendTo("#resultdiv");
                    }
                },
                error: function () {
                    alert("error");
                    $("#result").html('Some kind of error :( !');
                }
            });
        } else {
            console.log(anchor);
            console.log(2);
            $.ajax({
                url: '/bookByCategory',
                type: 'POST',
                data: jQuery.param({category: anchor}),
                dataType: "json",
                success: function (response) {
                    var length = response.length;
                    console.log(response);
                    for (i = 0; i < length; i++) {

                        var div = $('<div style=" padding-right:20px; display:flex;align-items:center;" id="dynamic">');
                        var div2 = $('<div style="padding-bottom:10px; width: 100%;" id="dynamic">');
                        var div3 = $('<div style="padding-left:20px" ALIGN="center" id="dynamic">');

                        //loome pildi ja lisame result divi
                        var img = $('<img ALIGN="left" id="dynamic">');
                        img.attr("width", "200");
                        img.attr("src", "data:image/jpeg;base64," + response[i].pilt)
                        img.appendTo(div2);
                        $(div3).append($('<p></p><b style="font-size:30px">"' + response[i].pealkiri + '"</b></p>'));
                        $(div3).append($('<p>"' + response[i].autor + '"</p>'));
                        $(div3).append($('<p>10€</p>'));
                        $(div3).append($('<p>"' + response[i].lk + '" lk</p>'));
                        $(div3).append($('<p>Laos: "' + response[i].kogus + '"</p>'));

                        div3.appendTo(div2);
                        div2.appendTo(div);
                        div.appendTo("#resultdiv");
                    }
                },
                error: function () {
                    alert("error");
                    $("#result").html('Some kind of error :( !');
                }
            });
        }
    }
});