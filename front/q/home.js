var home = angular.module('home', []);

home.component('home', {
	templateUrl: 'q/home.html',
	controller: 'homeController'
});

home.controller('homeController', ['$http', '$scope', 'orderByFilter', function ($http, $scope, orderBy) {

	$http.get('http://localhost:8080/q/')
		.then(function success(response) {

			$scope.filter = 'Questions'
			$scope.newest = 'Newest'
			$scope.thread_list = response.data;

		}, function error(response) {
			console.log(response);
		})

	$scope.sortBy = function (order) {


		switch (order) {
			case 'newest': $scope.thread_list = orderBy($scope.thread_list, '-');
				if ($scope.newest == 'Newest') {
					$scope.newest = 'Oldest'
					$scope.filter = 'Latest questions'
				}
				else {
					$scope.newest = 'Newest'
					$scope.filter = 'Old questions'
				}
				break;
			case 'most': $scope.thread_list = orderBy($scope.thread_list, 'answers.length', true);
				$scope.filter = 'Questions with most answers'
				break;
			case 'least': $scope.thread_list = orderBy($scope.thread_list, 'answers.length', false);
				$scope.filter = 'Questions with least answers'
		}

	}
}]);

app.filter('formatDate', function () {
	return function (full_date) {
		var dd = full_date.substring(8, 10);
		var MM = full_date.substring(5, 7);
		var yyyy = full_date.substring(0, 4);

		console.log(full_date);

		var hh = full_date.substring(11, 13)
		var mm = full_date.substring(14, 16)


		var date = MM + "/" + dd + "/" + yyyy + "  " + hh + ":" + mm;
		return date;
	}
})

app.filter('limitToWords', function () {
	return function (string, limit) {
		if (limit) {
			return string
				.split(' ')
				.splice(0, limit)
				.join(' ');
		} else {
			return string;
		}
	};
});
