angular.module('principal')
.controller('Controller', ['$scope',  '$http', 
	function ($scope, $http) {

    $scope.itens = null;
    $scope.tela = 'lista';
    $scope.quantidade = 0;

    $scope.mudarTela = function(tela){
      $scope.tela = tela;
    }

    $scope.somarUm = function(){
      $scope.quantidade++;
    }

    $scope.subtrairUm = function(){
      $scope.quantidade--;
    }

    init = function() {
        $http.get("http://localhost:8080/produtos")
          .then(function(response) {
            $scope.itens = response.data;
        });


    };

	init();
}]);