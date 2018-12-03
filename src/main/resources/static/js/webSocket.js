var stompClient = null;
console.log("ma olen siin");

function connect() {

    var socket = new SockJS('/my-websocket');
    console.log("ma olen connectionis1");
    stompClient = Stomp.over(socket);
    console.log("ma olen connectionis2");
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/subscriptions', function (greeting) {
            console.log(subscription);
            showNotification(subscription);
        });
    });
}

function showNotification(subscription) {
    console.log("terererererer");
}

$(function () {
    connect();
});