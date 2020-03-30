angular.module('thread', [])

	.component('thread', {
		templateUrl: 'q/thread.html',
		controller: 'threadController'
	})

	.controller('threadController',
		function ($scope, $http, $route, $routeParams) {
			var id = $routeParams.id;
			console.log(id);

			$http
				.get('http://localhost:8080/q/' + id)
				.then(
					function success(response) {
						console.log(response.data);

						$scope.title = response.data.question.title;
						$scope.text = response.data.question.text;

						var count = response.data.answers.length;
						switch (count) {
							case 0: $scope.count = 'No answers'; break;
							case 1: $scope.count = '1 answer'; break;
							default: $scope.count = count + ' answers';
						}

						$scope.answers_list = response.data.answers;

					},
					function error(response) {
						console.log('error', response);
					}
				);

			$scope.postAnswer = function (text) {

				if (text) {

					var answer = {
						text: text
					}
					$http.post('http://localhost:8080/q/' + id + '/a/new', answer)
						.then(function success() {
							console.log("ok");
							$scope.answer = '';
							$route.reload();

						}, function error() {
							console.log("error");

						})

				}

			}
		}
	)

	.filter('formatDate', function () {
		return function (full_date) {
			var day = full_date.substring(8, 10);
			var month = full_date.substring(5, 7);
			var year = full_date.substring(0, 4);
			var date = month + "/" + day + "/" + year;
			return date;
		}
	})
	;
