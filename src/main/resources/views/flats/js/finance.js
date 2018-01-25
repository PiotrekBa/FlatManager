var API_URL = "http://localhost:8080/";

$(document).ready(function () {
    var pathname = window.location.search;
    var ownerId = pathname.split('=')[1];

    function getFinances() {
        $.ajax({
            url: API_URL + "finances/owner/"+ownerId
        }).done(function (finances) {
            console.log(finances);
            showFinances(finances);
        })
    }
    var valueUnregulated = 0;
    var valueRegulated = 0;

    function showFinances(finances) {
        var financeTable = $('#flat-table tbody');
        finances.forEach(function (finance, i) {
            finance.forEach(function(financeOne, j){
                var tableRow = $('<tr data-id="'+financeOne.id+'">'+
                    '<th scope="row">'+(i+j+1)+'</th>'+
                    '<td>'+financeOne.name+'</td>'+
                    '<td>'+getData(financeOne.day,financeOne.month, financeOne.year)+'</td>'+
                    '<td>'+financeOne.flatName+'</td>'+
                    '<td>'+financeOne.value+'</td>'+
                    '<td>'+getStringFromBoolean(financeOne.regulated)+'</td>'+
                    '</tr>');
                financeTable.append(tableRow);
                if(financeOne.regulated) {
                    valueRegulated += financeOne.value;
                } else {
                    valueUnregulated += financeOne.value;
                }
            })
        })
        var summaryRow = $('<tr>'+
            '<td colspan="4">Rachunku do zapłacenia</td>'+
            '<td colspan="2">'+valueUnregulated+'</td>'+
            '</tr><tr>' +
            '<td colspan="4">Wszystkie rachunki</td>'+
            '<td colspan="2">'+(valueUnregulated + valueUnregulated)+'</td>'+
            '</tr>');
        financeTable.append(summaryRow);
    }

    function getData(day, month, year) {
        return day+'/'+month+'/'+year;
    }

    function getStringFromBoolean(regulated) {
        if (regulated != false) {
    return 'Tak';
}
        return 'Nie';
    }
    getFinances();


})