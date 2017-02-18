/**
 * Created by xiaof on 2017/2/18.
 */
'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', []);

App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/api/list', {
        templateUrl: '/src/stock/list.html',
        controller: listController
    })

    $routeProvider.otherwise({redirectTo: '/api/list'});
}])
