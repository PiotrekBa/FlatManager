var API_URL = "http://localhost:8080/";

$(document).ready(function () {
    var pathname = window.location.search;
    var id = pathname.split('=')[1];

    function getFlat() {
        $.ajax({
            url: API_URL + "flats/"+id
        }).done (function(flat) {
            console.log(flat);
            showFlatInInput(flat);
        })

    }


    function showFlatInInput(flat) {
        var flatName = $('#name');
        var flatAddress = $('#address');
        var flatId = $('#id');

        flatName.val(flat.name);
        flatAddress.val(flat.address);
        flatId.val(flat.id);
        console.log(flatName);
        console.log(flatAddress);
    }

    var updadeButton = $('button');

    updadeButton.on('click', function(e) {
        e.preventDefault();
        var flatName = $('#name').val();
        var flatAddress = $('#address').val();
        var flatId = $('#id').val();

        var objToSave = {
            id: flatId,
            name: flatName,
            address: flatAddress,
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

        fetch(API_URL + "flats/"+flatId, myInit).then(function (response) {
            console.log(response);
        })
    })

    console.log(updadeButton);

    // function showFlat(flat) {
    //     var flatName = $('#flat-name');
    //     flatName.text('Nazwa: ' + flat.name + '| adres: ' + flat.address);
    //     flat.rooms.forEach(function(room, i) {
    //         var roomsDetails = $('<tr>'+
    //             '<td>'+(i+1)+'</td>'+
    //             '<td>'+room.rent+'</td>'+
    //             '<td>'+room.area+'</td>'+
    //             '<td>'+showTenant(room.tenant)+'</td>'+
    //             '<td><a href="room/room.html?id=' + room.id +'">Szczegóły</a></td>'+
    //             '</tr>');
    //         flatName.parent().parent().next().append(roomsDetails);
    //     })
    // }
    //
    // function showTenant(tenants) {
    //     var tenantsDiv = '<ul>';
    //     tenants.forEach(function (tenant) {
    //         tenantsDiv += '<li>'+tenant.firstName + ' ' + tenant.lastName+'</li>';
    //     })
    //     tenantsDiv += '</ul>';
    //     return tenantsDiv;
    // }

    getFlat();
})