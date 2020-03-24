var app = angular.module("forum", []);

app.controller("afController", [
  "$http",
  "$scope",
  function afcontroller($http, $scope) {
    $http({
      method: "GET",
      url: "http://localhost:8080/q/"
    }).then(
      function success(response) {
        $scope.thread_list = response.data;
      },
      function error(response) {
        console.log("error", response);
      }
    );
  }
]);

app.filter("limitToWords", function() {
  return function(string, limit) {
    if (limit) {
      return string
        .split(" ")
        .splice(0, limit)
        .join(" ");
    } else {
      return string;
    }
  };
});
