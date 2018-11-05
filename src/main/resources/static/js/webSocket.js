var stompClient = null;




console.log("ma olen siin");

function connect() {
    console.log("ma olen connectionis");
    var socket = new SockJS('/my-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/subscriptions', function (greeting) {
            var subscription = JSON.parse(greeting.body);
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