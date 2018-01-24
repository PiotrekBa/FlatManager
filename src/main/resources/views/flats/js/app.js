var API_URL = "http://localhost:8080/";

$(document).ready(function () {

    function getFlats() {
        $.ajax({
            url: API_URL + "flats"
        }).done(function (flats) {
            console.log(flats);
            showFlats(flats);
        })
    }

    function showFlats(flats) {
        var flatName = $('#flats #content');
        flats.forEach(function (flat) {
            if (flat) {
                var row = $('<div class="flat" data-id="' + flat.id + '">' +
                    '<p class="name">' + flat.name + '</p>' +
                    '<p class="address">' + flat.address + '</p>');
                flatName.append(row);
            }
        })
    }

    function clearFlatsList() {
        var divFlats = $('.flat');
        divFlats.remove();
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