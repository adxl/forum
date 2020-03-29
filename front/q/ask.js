angular.module('ask', [])

    .component('ask', {
        templateUrl: 'q/ask.html',
        controller: 'askController'
    })

    .controller('askController', function ($scope, $http) {

        $scope.postQuestion = function (title, text) {

            // console.log(title + "\n" + text);

            if (title != null) {
                if (text == null) {
                    text = "";
                }
                var data = {
                    title: title,
                    text: text
                }

                $http
                    .post('http://localhost:8080/q/new', data)
                    .then(function success() {
                        console.log("ok");

                    }, function error() {
                        console.log("error");

                    })
            }
        }
    })