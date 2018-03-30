'use strict'

var bankerApp = angular.module('banker', ['banker.controllers', 'banker.services']);

bankerApp.constant("CONSTANTS", {

    getBranchesByCity: "/bank/branches?city="

});