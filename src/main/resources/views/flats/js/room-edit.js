var API_URL = "http://localhost:8080/";

$(document).ready(function () {
    var pathname = window.location.search;
    var id = pathname.split('=')[1];

    function getRoom() {
        $.ajax({
            url: API_URL + "rooms/"+id
        }).done (function(room) {
            showRoomInInput(room);
        })

    }


    function showRoomInInput(room) {
        var roomArea = $('#area');
        var roomRent = $('#rent');

        roomArea.val(room.area);
        roomRent.val(room.rent);
    }

    var updadeButton = $('button');

    updadeButton.on('click', function(e) {
        e.preventDefault();
        var roomArea = $('#area').val();
        var roomRent = $('#rent').val();

        var objToSave = {
            id: id,
            area: roomArea,
            rent: roomRent,
            flatId: 0
        }

        var myHeaders = new Headers({
            'Content-Type': 'application/json'
        });

        var myInit = {
            method: 'PUT',
            headers: myHeaders,
            cache: 'default',
            body: JSON.stringify(objToSave)
        }

        fetch(API_URL + "rooms/"+id, myInit).then(function (response) {
            console.log(response);
        })
    })


    getRoom();
})