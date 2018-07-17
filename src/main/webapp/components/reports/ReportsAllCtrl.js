(function() {


angular.module('reportsAllController', [])
	.controller('ReportsAllCtrl', function($scope, $http, $uibModal, SalonSoftPortfolioService, SalonSoftUser, $state) {

		$scope.userData = SalonSoftUser.userData;
		$scope.accounts = [];
		$scope.accounts2 = [];
		$scope.totalValue = 0;
		$scope.chartYears = '3';

		$scope.loadingPortfolio = false;
		$scope.loadingPortfolioError = false;

		$scope.classClick = false;

		$scope.chartOptions = {showTooltips: true, scaleShowGridLines:false, pointDot:false, pointHitDetectionRadius : 0, pointDotRadius : 2, animation : false}

		$scope.chartYears = '3';
		$scope.chartDate = function(number){
			$scope.chartYears = number;
		}
		$scope.showAcc = function(accNumber){
			var newData = [];
			var isShowing = $scope.accounts2[accNumber].isShowing;
			$scope.accounts2[accNumber].isShowing = !isShowing;

			for(var i = 0; i < $scope.accounts.length; i++){
				if($scope.accounts[i].isShowing){
					newData.push($scope.performanceDataRaw[$scope.accounts[i].bda]);
				}
			}

			$scope.performanceData = newData;
		}

		$scope.labels = [];
		$scope.series = [];
		$scope.performanceData = [];
		$scope.performanceDataRaw = [];

		$scope.handlePerformanceData = function(newData){
			var newPerfData = [];
			$scope.totalValue = 0;
			var plotPoints;
			for(var i = 0; i < newData.length; i++){

				var thisItem = newData[i];
				var newAcc = {"name": thisItem.name, "bda": thisItem.bda, "totalValue" : thisItem.totalValue, "isShowing" : true}

				$scope.accounts.push(newAcc);
				$scope.accounts2[String(thisItem.bda)] = newAcc;
				$scope.series.push(thisItem.name);
				$scope.totalValue += thisItem.totalValue;

				plotPoints = [];
				var newPerfItems = [];
				for(var j = 0; j < thisItem.history.length; j++){
					newPerfItems.push(thisItem.history[j].total);
					//$scope.labels.push(new Date(thisItem.history[j].date).toLocaleDateString())
					plotPoints.push("");
				}
				newPerfData.push(newPerfItems);
				$scope.performanceDataRaw[String(thisItem.bda)] = newPerfItems;
			}
			$scope.labels = plotPoints;
			$scope.performanceData = newPerfData
		}

		$scope.colours = ['#43629d','#7490c4', {
			fillColor: 'transparent',
			strokeColor: "rgba(220,0,0,1)",
			pointColor: "rgba(220,0,0,1)",
			pointStrokeColor: "#fff",
			pointHighlightFill: "#fff",
			pointHighlightStroke: "rgba(220,220,220,1)",
		}];

		$scope.getPortfolioData = function(){
			$scope.loadingPortfolio = true;
			$scope.loadingPortfolioError = false;
			SalonSoftPortfolioService.getPortfolioPerrformance($scope.getPortfolioPerformanceCallback)
		};

		$scope.getPortfolioPerformanceCallback = function(data){
			$scope.loadingPortfolio = false;
			if (data.status == "ERROR") {
				$scope.loadingPortfolioError = true;
			} else {
				$scope.handlePerformanceData(data);
			}
		};

		$scope.getPortfolioData();

	});


}());