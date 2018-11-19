$(document).ready(function () {
    $('form').submit(function (evt) {
        evt.preventDefault();
        //puhastan div
        $("#result").html('');
        //võtan formidelt andmed
        var title = $("#title").val();
        var author = $("#author").val();
        console.log(title);
        console.log(author);
        //teen ajaxiga query ja kuvan pildi lehele
        $.ajax({
            url: '/postraamat',
            type: 'POST',
            data: jQuery.param({name: title, author: author}),
            dataType: "json",
            success: function (response) {
                console.log(response);
                //loome pildi ja lisame result divi
                var img = $('<img id="dynamic">');
                img.attr("width", "200");
                img.attr("src", "data:image/jpeg;base64," + response[0].pilt);
                img.appendTo("#result");

                //lisan urlile ankru
                window.location = '#' + response[0].pealkiri;
                //salvestan andmed kliendi arvutisse, ajaxi viite jaoks
                localStorage.bookIMGsrc = "data:image/jpeg;base64," + response[0].pilt
            },
            error: function () {
                alert("error");
                $("#result").html('Some kind of error :( !');
            }
        });
        $(this).trigger("reset");

    });

    //nupu vajutusel kuvan kõik raamatud
    $('#btn').click(function () {
        if (navigator.onLine){
            $("#result").append($('<p style="font-size:30px">Teil pole internetti! Ühendage internetiga ja proovige uuesti!</p>'));
        }
        else {
            //puastan vastuse divi ära
            $("#result").empty();
            $.ajax({
                url: '/allraamatud',
                type: 'POST',
                data: jQuery.param({name: "Matilda", author: "Roald Dahl"}),
                dataType: "json",
                success: function (response) {

                    console.log(response);

                    //teeme for loopi JSON-i paele, loome iga raamatu kohta uue img elemendi ja lisame selle div-i
                    var length = response.length;
                    var i;
                    for (i = 0; i < length; i++) {
                        var img = $('<img id="dynamic">');
                        img.attr("width", "200");
                        img.attr("src", "data:image/jpeg;base64," + response[i].pilt);
                        img.appendTo("#result");
                    }
                },
                error: function () {
                    alert("error");
                    $("#result").html('Some kind of error :( !');
                }
            });
        }
    });
})