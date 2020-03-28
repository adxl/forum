var thread = angular.module('thread', []);

thread.component('thread', {
  templateUrl: 'q/thread.html',
  controller: function($scope, $routeParams) {
    $scope.id = $routeParams.id;
  }
});
