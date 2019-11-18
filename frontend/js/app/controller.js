angular.module('principal')
.controller('Controller', ['$scope',  '$http', 
	function ($scope, $http) {

    $scope.itens = null;
    $scope.tela = 'lista';

    $scope.mudarTela = function(tela){
      $scope.tela = tela;
    }

    init = function() {
        $http.get("http://localhost:8080/produtos")
          .then(function(response) {
            $scope.itens = response.data;
        });


    };

	init();
}]);