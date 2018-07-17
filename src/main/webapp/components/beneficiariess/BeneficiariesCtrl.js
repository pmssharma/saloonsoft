(function() {


angular.module('beneficiariesController', ['beneficiariesDetailController'])
	.controller('BeneficiariesCtrl', function($scope, $http, $uibModal, $state) {

		$state.params.equityId

		$scope.loadingEquity = false;
		$scope.loadingEquityError = false;

	})



}());