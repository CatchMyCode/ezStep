'use strict';

angular.module('app', [

    // deps
    'ngRoute',
    'ngResource',

    // app
    'app.directives',

    'app.nav',
    'app.main'

]).config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode(false).hashPrefix('!');
}])
