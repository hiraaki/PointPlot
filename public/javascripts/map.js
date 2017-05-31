/**
 * Created by mhi on 24/03/17.
 */
var map;
var booladd=false;
function addble() {

    if(booladd==false){
        map.addListener('click', function(event) {
            addMarker(event.latLng);
        });
        booladd=true;
    }else{
        google.maps.event.clearListeners(map, 'click');
        booladd=false;
    }
}

var markers = [];
var id=-1;
var exit=false;
function addMarker(location){
    var marker = new google.maps.Marker({
        position: location,
        map: map,
        id: id+1
    });
    markers.push(marker);
    id = id +1;
    var content = "Primeira Rua:<input type='text' id='pRua'/> <br/>Segunda Rua:<input type='text' id='sRua'/> <br />" +
                "<input type = 'button' onclick = 'salvar(" + marker.id+ ");' value = 'Salvar' />";


    var infoWindow = new google.maps.InfoWindow({
        content: content
    });
    infoWindow.open(map, marker);
    if(exit==true){
        infoWindow.close(map, marker);
    }

}


function salvar(id) {
    var X = document.getElementById("pRua").value;
    var Y = document.getElementById("sRua").value;

    for (var i = 0; i < markers.length; i++) {
        if (markers[i].id == id) {
           markers[i].setTitle(X+"|"+Y);
           savePonto(markers[i],X,Y);
        }
    }

}

function savePonto(marker,rua1,rua2){
    var obj;
    obj={
        "Id":marker.id,
        "Rua1":rua1,
        "Rua2":rua2,
        "Latitude":marker.position.lat,
        "Longitude":marker.position.lng
    };
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        dataType: 'json',
        async: false,
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8",
        url: '/savePoint',
        success: function (json) {
             var objt=json;
            for(var i = 0; i < objt.length; i++ ) {
                window.alert("yes recivede!!" + objt[i].Esquina.Rua1);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Erro");
        }
    });
}


function removable(){
    for(var i =0; i< markers.length;i++){
        addDelListeners(markers[i]);
    }
}



function addDelListeners(marker) {
    google.maps.event.addListener(marker, "click", function (e) {
        var content = "Latitude: " + marker.position.lat() + "<br />Longitude: " + marker.position.lng()
                    + "<br /><input type = 'button' onclick = 'DeleteMarker(" + marker.id + ");' value = 'Delete' />";

        var infoWindow = new google.maps.InfoWindow({
            content: content
        });
        infoWindow.open(map, marker);
    });

}


function DeleteMarker(id) {
    //Find and remove the marker from the Array
    for (var i = 0; i < markers.length; i++) {
        if (markers[i].id == id) {
            //Remove the marker from Map
            markers[i].setMap(null);

            //Remove the marker from array.
            markers.splice(i, 1);
            return;
        }
    }
};




function recenter() {
    var X =document.getElementById("Rua1");
    var y =document.getElementById("Rua2");
}


function initMap() {

    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 14,
        center: {lat: -24.9554503, lng: -53.4552361},
        mapTypeControl: true,
        mapTypeId: google.maps.MapTypeId.SATELLITE
    });
}