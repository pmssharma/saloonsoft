(function() {


angular.module('productsController', [])
	.controller('ProductsCtrl', function($scope, $http, $uibModal, SalonSoftPortfolioService, $state, SalonSoftSiteConfigService) {

		$scope.tradeDisplay = 'all'

		$scope.loadingOrders = false;
		$scope.loadingOrdersError = false;

		$scope.orders = [];
		$scope.displayedOrders = [].concat($scope.orders);

		$scope.changeTradeDisplay = function(type){
			$scope.tradeDisplay = type;
		}

		$scope.loadOrderDetail = function(row){

			$uibModal.open({
				templateUrl: 'orderDetail.html.inline',
				controller: 'ProductsDetailDetailModalControllerCtrl',
				size: 'md',
				resolve: {
					rowParameter: function () {
						return row;
					},
					parentController : function () {
						return $scope;
					}
				}
			});

		}

		$scope.getOrders = function(){
			$scope.loadingOrders = true;
			SalonSoftPortfolioService.getOrders($scope.getOrdersCallback)
		}

		$scope.accounts = [];
		$scope.displayedAccounts = [];
		$scope.getOrdersCallback = function(data){
			//debugger
			var shareSring = "";
			$scope.loadingOrders = false;
			if (data.status == "ERROR") {
				$scope.loadingOrdersError = true;
			} else {
				$scope.loadingOrdersError = false;

				var firstIteration = 0;
				var newAccs = []
				for (var x in data) {
					if(firstIteration > 0){
						shareSring += ","
					}
					newAccs = newAccs.concat(data[x]);//.push(data[x]);
					for(var i=0; i< data[x].length; i++){
						shareSring += data[x][i].shareCode;
						if(i != data[x].length - 1){
							shareSring += ",";
						}
					}
					firstIteration++;
				}

				$scope.orders = newAccs;
				$scope.displayedOrders = [].concat($scope.orders);
				$scope.accounts = data;
				$scope.displayedAccounts = [].concat($scope.accounts);
			}

			//return sendRequest(shareSring);
		}


		$scope.$on("$destroy", function() {
			//if (ws) {
			//	ws.onmessage = function(message) {};
			//	ws.onopen = function(){}
			//	ws.close();
			//	ws = null;
			//}
		});

		$scope.getOrders()
	}
)


	angular.module('productsController')
		.controller('ProductsDetailDetailModalControllerCtrl', function($scope, $http, $uibModal, $uibModalInstance, rowParameter, parentController) {

			$scope.equity = rowParameter;
			$scope.parent = parentController;

			$scope.closeLoginFail = function(){
				$uibModalInstance.dismiss('cancel');
			}

		}
	)

}());