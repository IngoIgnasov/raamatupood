function myMap() {
    var mapProp= {
        center:new google.maps.LatLng(58.3784817,26.7130022),
        zoom:14
    };
    var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
    var marker = new google.maps.Marker({position:{lat : 58.3782485, lng: 26.7124846}});
    var marker2 = new google.maps.Marker({position:{lat : 58.3857244, lng: 26.725783}});
    var infowindow = new google.maps.InfoWindow({content:"Liivi 2"});
    var infowindow2 = new google.maps.InfoWindow({content:"Delta"});
    infowindow.open(map,marker);
    infowindow2.open(map,marker2)
    marker.setMap(map);
    marker2.setMap(map);

}
