var API_URL = "http://localhost:8080/";

$(document).ready(function () {
    var pathname = window.location.search;
    var id = pathname.split('=')[1];

    function getFlat() {
        $.ajax({
            url: API_URL + "flats/"+id
        }).done (function(flat) {
            showFlat(flat);
        })
    }

    function showFlat(flat) {
        var flatName = $('#flat-name');
        flatName.text('Nazwa: ' + flat.name + '| adres: ' + flat.address);
        flat.rooms.forEach(function(room, i) {
            if(room.enable) {
                var roomsDetails = $('<tr>' +
                    '<td>' + (i + 1) + '</td>' +
                    '<td>' + room.rent + '</td>' +
                    '<td>' + room.area + '</td>' +
                    '<td>' + showTenant(room.tenant) + '</td>' +
                    '<td><a href="rooms.html?id=' + room.id + '">Szczegóły</a> ' +
                    '<a href="rooms-edit.html?id='+ room.id +'">Edycja</a> '+
                    '<a href="" id ="delete">Usuń</a>'+
                    '</td>' +
                    '</tr>');
                flatName.parent().parent().next().append(roomsDetails);
            }
        })
    }

    function showTenant(tenants) {
        var tenantsDiv = '<ul>';
        tenants.forEach(function (tenant) {
            tenantsDiv += '<li>'+tenant.firstName + ' ' + tenant.lastName+'</li>';
        })
        tenantsDiv += '</ul>';
        return tenantsDiv;
    }

    var addFlat = $('#add-symbol');

    addFlat.on('click', function(e) {
        var addForm = $('#add-form');
        if(addForm.css('display') === 'inline') {
            addForm.css('display', 'none');
        } else {
            addForm.css('display', 'initial');
        }
    })

    var buttonSave = $('#save');

    buttonSave.on('click', function (e) {
        e.preventDefault();
        var roomArea = $('#area').val();
        var roomRent = $('#rent').val();


        var objToSave = {
            id: 0,
            area: roomArea,
            rent: roomRent,
            flatId: id
        }

        var myHeaders = new Headers({
            'Content-Type': 'application/json'
        });

        var myInit = {
            method: 'POST',
            headers: myHeaders,
            cache: 'default',
            body: JSON.stringify(objToSave)
        }

        fetch(API_URL + "rooms", myInit).then(function (response) {

        })
    })

    getFlat();
})