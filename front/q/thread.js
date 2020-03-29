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
				.get('http://localhost:8080/q/' + 2)
				.then(
					function success(response) {
						$scope.tab_title = "Question"
						$scope.title = response.data.question.title;
						$scope.text = response.data.question.text;
					},
					function error(response) {
						console.log('error', response);
					}
				);
		}
	);
