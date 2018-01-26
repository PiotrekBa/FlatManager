var API_URL = "http://localhost:8080/";

$(document).ready(function () {
    var pathname = window.location.search;
    var id = pathname.split('=')[1];

    function getRoom() {
        $.ajax({
            url: API_URL + "rooms/"+id
        }).done (function(room) {
            console.log(room);
            showRoom(room);
        })
    }

    function showRoom(room) {
        var roomTable = $('#flat-name');
        roomTable.text('Powierzchnia: ' + room.area + '| Cena: ' + room.rent);
        room.tenant.forEach(function(tenant, i) {
                var roomsDetails = $('<tr>' +
                    '<td>' + (i + 1) + '</td>' +
                    '<td>' + tenant.firstName + '</td>' +
                    '<td>' + tenant.lastName + '</td>' +
                    '<td>' + tenant.phone + '</td>' +
                    '<td>' + tenant.email + '</td> ' +
                    '<td>' +
                    '<a href="tenant-edit.html?id='+ room.id +'">Edycja</a> '+
                    '<a href="" id ="delete">Usuń</a>'+
                    '</td>' +
                    '</tr>');
                roomTable.parent().parent().next().append(roomsDetails);

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
        var firstName = $('#firstName').val();
        var lastName = $('#lastName').val();
        var phone = $('#phone').val();
        var email = $('#email').val();

        var objToSave = {
            id: 0,
            firstName: firstName,
            lastName: lastName,
            phone: phone,
            email: email,
            roomId: id
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

        fetch(API_URL + "tenants", myInit).then(function (response) {

        })
    })

    getRoom();
})