var API_URL = "http://localhost:8080/";

$(document).ready(function () {

    function getFlats() {
        $.ajax({
            url: API_URL + "flats"
        }).done(function (flats) {
            console.log(flats);
            showFlats(flats);
            deleteLink();
        })
    }

    function showFlats(flats) {
        var flatName = $('#flat-table tbody');
        var i = 1;
        flats.forEach(function (flat) {
            if (flat.enable) {
                var tableRow = $('<tr data-id="'+flat.id+'">'+
                    '<th scope="row">'+i+'</th>'+
                    '<td>'+flat.name+'</td>'+
                    '<td>'+flat.rooms.length+'</td>'+
                    '<td>'+tenantCounter(flat.rooms)+'</td>'+
                    '<td>'+rentCounter(flat.rooms)+'</td>'+
                    '<td><a href="flats-details.html?id='+flat.id+'">Szczegóły</a>  ' +
                    '<a href="flats-edit.html?id='+flat.id+'">Edytuj</a>  '+
                    '<a href="" class="delete">Usuń</a></td>' +
                    '</tr>');
                flatName.append(tableRow);
                i++;
            }
        })
    }

    function rentCounter(rooms) {
        var actuallyRent = 0;
        var posibilityRent = 0;
        rooms.forEach(function(room) {
            if(room.tenant.length !== 0) {
                actuallyRent += room.rent;
                posibilityRent += room.rent;
            } else {
                posibilityRent += room.rent;
            }
        })
        return actuallyRent + '/' + posibilityRent;
    }

    function tenantCounter(rooms) {
        var counter = 0;
        rooms.forEach(function (room) {
            counter = counter + room.tenant.length;
        })
        return counter;
    }

    function clearFlatsList() {
        var flatsRow = $('#flat-table tbody tr');
        flatsRow.remove();
    }

    function deleteLink() {
        var links = $('.delete');
        links.on('click', function(e) {
            e.preventDefault();
            var id = $(e.target).parent().parent().data('id');

            var myHeaders = new Headers({
                'content-type': 'application/json'
            });

            var myInit = {
                method: 'DELETE',
                headers: myHeaders,
                cache: 'default'
            };

            fetch(API_URL+ 'flats/' + id, myInit).then(function (response) {
                clearFlatsList();
                getFlats();
            });
        })
    }

    var buttonSave = $('#save');

    buttonSave.on('click', function (e) {
        e.preventDefault();
        var flatName = $('#name').val();
        var address = $('#address').val();

        var objToSave = {
            id: 0,
            name: flatName,
            address: address,
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

        fetch(API_URL + "flats", myInit).then(function (response) {
            clearFlatsList();
            getFlats();
        })
    })

    var addFlat = $('#add-symbol');

    addFlat.on('click', function(e) {
        var addForm = $('#add-form');
        if(addForm.css('display') === 'inline') {
            addForm.css('display', 'none');
        } else {
            addForm.css('display', 'initial');
        }
    })

    getFlats();


})