var app = angular.module('forum', ['ngRoute', 'home', 'thread', 'ask']);

app.controller('mainController', function mainController($scope, $route) {
});

//CONFIG

app.config(function ($routeProvider, $locationProvider) {
  $routeProvider
    .when('/q', {
      template: '<home></home>',
      // template: '<thread></thread>'
    })
    .when('/q/:id', {
      template: '<thread></thread>'
    })
    .when('/ask', {
      template: '<ask></ask>'
    })
    .otherwise('/q');
  $locationProvider.html5Mode(true);
});
