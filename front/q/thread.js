angular.module('thread', [])

	.component('thread', {
		templateUrl: 'q/thread.html',
		controller: 'threadController'
	})

	.controller('threadController',
		function ($scope, $http, $routeParams) {
			var id = $routeParams.id;
			console.log(id);

			$http
				.get('http://localhost:8080/q/' + id)
				.then(
					function success(response) {
						$scope.id = response.data.id;
						$scope.title = response.data.question.title;
						$scope.text = response.data.question.text;
					},
					function error(response) {
						console.log('error', response);
					}
				);
		}
	);
