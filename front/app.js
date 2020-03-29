var app = angular.module('forum', ['ngRoute', 'home', 'thread']);

app.controller('mainController', function mainController($scope, $route) {
});

//CONFIG

app.config(function ($routeProvider, $locationProvider) {
  $routeProvider
    .when('/q', {
      template: '<home></home>',
    })
    .when('/q/:id', {
      template: '<thread></thread>'
    })
    .otherwise('/q');
  $locationProvider.html5Mode(true);
});
