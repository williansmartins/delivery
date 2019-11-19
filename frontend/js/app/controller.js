angular.module('principal')
.controller('Controller', ['$scope',  '$http', 
	function ($scope, $http) {

    $scope.produtos = null;
    $scope.tela = 'pedido';

    $scope.mudarTela = function(tela){
      $scope.tela = tela;
    }

    $scope.somarUm = function(batata){
      batata.quantidade++;
    }

    $scope.subtrairUm = function(batata){
      batata.quantidade--;
    }

    var inicializarProdutos = function(){
        angular.forEach($scope.produtos, function(value, key){
            value.quantidade = 0;
        });
    }

    init = function() {
        $http.get("http://localhost:8080/produtos")
          .then(function(response) {
            $scope.produtos = response.data;
            inicializarProdutos();
        });


    };

	init();
}]);