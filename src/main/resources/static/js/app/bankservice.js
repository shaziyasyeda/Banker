'use strict'

angular.module('banker.services', []).factory('BankService',
    ["$http", "CONSTANTS", function($http, CONSTANTS) {

    var service = {};
    service.getBranchesByCity = function(city) {
        var url = CONSTANTS.getBranchesByCity + city;

        return $http.get(url);

    }

    return service;

}]);