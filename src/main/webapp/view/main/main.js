'use strict'

angular.module('app.main', ['ngRoute'])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
            templateUrl: 'view/main/main.html',
            controller: 'MainCtrl'
        });
    }])

angular.module('app.main')
    .controller('MainCtr', ["$scope", "$resource", function($scope, $resource) {
        $scope.msg = "This is a test message"
    }]);