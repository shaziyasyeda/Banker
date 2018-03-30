'use strict'

var module = angular.module('banker.controllers', []);

module.controller("BankController", ["$scope", "BankService",

    function($scope, BankService) {
        $scope.cities = ["Mumbai", "Hyderabad", "Bangalore", "Chennai", "Delhi"];
        $scope.selectedCity = "";
        $scope.branches = [];

        $scope.bankFilter = "";
        $scope.filteredBranches = [];

        $scope.getBranchesByCity = function() {
            console.log("city", $scope.selectedCity);
            BankService.getBranchesByCity($scope.selectedCity).then(function(branches) {
                $scope.branches = branches && branches.data? branches.data: [];
                $scope.filteredBranches = $scope.branches.slice();
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        }

        $scope.filterByBank = function() {
            let allBranches = $scope.branches.slice();
            if($scope.bankFilter && $scope.bankFilter != "") {
                let bankFilter = $scope.bankFilter;
                let filteredBranches = [];
                filteredBranches = allBranches.filter(function (branch) {
                   return branch.bank.name.toLowerCase().includes(bankFilter.toLowerCase());
                });
                $scope.filteredBranches = filteredBranches;
            } else {
                $scope.filteredBranches = allBranches;
            }
        }


    }

]);