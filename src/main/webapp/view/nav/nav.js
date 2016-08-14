'use strict';

angular.module('app.nav', ['ngRoute'])
    .controller('NavCtrl', ['$scope', '$location', function($scope, $location) {

        $scope.pages = [
            {
                "title": "Home",
                "url": "/",
                "icon": "glyphicon glyphicon-home"
            }
            //{
            //    "title": "Running Jobs",
            //    "url": "/jobs",
            //    "icon": "glyphicon glyphicon-play"
            //},
            //{
            //    "title": "Create a Config",
            //    "url": "/configs",
            //    "icon": "glyphicon glyphicon-play"
            //}
        ];

        $scope.isPageActive = function(url) {
            return (url === $location.path());
        }

    }]);
