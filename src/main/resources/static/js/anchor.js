$(window).load(function(){
var anchor = document.location;
anchor = String(anchor);
anchor = anchor.split("#");

console.log(anchor);

//kui on juba ankur küljes, vaatleme seda
if (anchor.length > 1) {
    anchor = anchor[1];
} else {
    anchor = anchor[0];
}

console.log(anchor);
switch(anchor) {
    case "Matilda":
        var img = $('<img id="dynamic">');
        img.attr("width", "200");
        img.attr("src", localStorage.bookIMGsrc);
        img.appendTo("#result");

        break;

        //TODO teine raamat
    case "section2":
        var img = $('<img id="dynamic">');
        img.attr("width", "200");
        img.attr("src", "data:image/jpeg;base64," + response[0].pilt);
        img.appendTo("#result");
        break;
        //TODO kolmas raamat
    case "section3":
        var img = $('<img id="dynamic">');
        img.attr("width", "200");
        img.attr("src", "data:image/jpeg;base64," + response[0].pilt);
        img.appendTo("#result");
        break;

    default:
        // ei tee midagi, kuna puudus ankur
        break;
}});