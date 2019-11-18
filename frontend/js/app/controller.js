angular.module('principal')
.controller('Controller', ['$scope',  '$http', 
	function ($scope, $http) {

    $scope.$itens = null;
    $scope.tela = 0;

    $scope.mudarTela = function(tela){
      $scope.tela = tela;
    }

    init = function() {
        $http.get("https://jsonplaceholder.typicode.com/todos/1")
          .then(function(response) {
            $scope.itens = response.data;
        });


    };

	init();
}]);