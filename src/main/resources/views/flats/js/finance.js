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
            getIncomes();
        })
    }
    var valueUnregulated = 0;
    var valueRegulated = 0;

    function showFinances(finances) {
        var financeTable = $('#flat-table tbody');
        var i = 1;
        finances.forEach(function (finance) {
            finance.forEach(function(financeOne){
                var tableRow = $('<tr data-id="'+financeOne.id+'">'+
                    '<th scope="row">'+i+'</th>'+
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
                i++;
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

    function getIncomes() {
        $.ajax({
            url: API_URL + "finances/incomes"
        }).done(function (turnover) {
            console.log(turnover);
            showTurnover(turnover);
        })
    }

    function showTurnover(turnover) {
        var totalCosts = valueUnregulated + valueUnregulated;
        var financeTable = $('#flat-table tbody');
        var incomeRow = $('<tr>'+
            '<td colspan="4">Dochód (rzeczywisty/szacowany)</td>'+
            '<td colspan="2">'+turnover.actualTurnover+'/'+ turnover.possibleTurnover +'</td>'+
            '</tr><tr>' +
            '<td colspan="4">Całkowity zysk</td>'+
            '<td colspan="2">'+(turnover.actualTurnover - totalCosts)+'</td>'+
            '</tr><tr>' +
            '<td colspan="4">Całkowity możliwy zysk</td>'+
            '<td colspan="2">'+(turnover.possibleTurnover - totalCosts)+'</td>'+
            '</tr>');
        financeTable.append(incomeRow);
    }

    getFinances();


})