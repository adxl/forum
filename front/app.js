var app = angular.module('forum', ['ngRoute', 'home', 'thread', 'ask']);

app.controller('mainController', function mainController($scope, $route, $location, $http) {

  $scope.randomQuestion = function () {

    $http.get("http://localhost:8080/q/")
      .then(function success(response) {

        var items = response.data;
        var id = items[Math.floor(Math.random() * items.length)].id;

        $location.url("/q/" + id);
      })
  }
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
