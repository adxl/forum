var home = angular.module('home', []);

home.component('home', {
	templateUrl: 'q/home.html',
	controller: 'homeController'
});

home.controller('homeController', function($scope, $http) {
	$http({
		method: 'GET',
		url: 'http://localhost:8080/q/'
	}).then(
		function success(response) {
			$scope.tab_title = 'Home';
			$scope.thread_list = response.data;
		},
		function error(response) {
			console.log('error', response);
		}
	);
});

app.filter('formatDate', function () {
  return function (full_date) {
    var day = full_date.substring(8,10);
    var month = full_date.substring(5,7);
    var year = full_date.substring(0,4);
    var date = month + "/" + day + "/" + year;
    return date;
  }
})

app.filter('limitToWords', function() {
	return function(string, limit) {
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
