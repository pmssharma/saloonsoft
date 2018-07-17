(function() {


	angular.module('beneficiariesDetailController', ['chart.js', 'ngAnimate'])
		.controller('BeneficiariesDetailCtrl', function($scope, $http, $uibModal, SalonSoftUser, $state) {

			$scope.user = SalonSoftUser;
			$scope.asyncSelectedComparison = "";
			$scope.loadingComparison = false;;
			$scope.loadingComparisonError = false;;
			$scope.comparisonList = [];
			$scope.performancePercent = 0;

			$scope.disableSell = true;
			$scope.sellAvailability = null;

			$scope.equityData = null;
			$scope.labels = [];
			//$scope.series = [];
			$scope.chartYears = '3';
			$scope.chartDate = function(number){
				$scope.chartYears = number;
			}
			$scope.performanceData = [];
			$scope.chartOptions = {showTooltips: true, scaleShowGridLines:false, pointDot:false, pointHitDetectionRadius : 0, pointDotRadius : 2, animation : false}
			$scope.originalPerformanceData = [];
			$scope.colours = ['#01aaad','#f08d0e', {
				fillColor: 'transparent',
				strokeColor: "rgba(220,0,0,1)",
				pointColor: "rgba(220,0,0,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(220,220,220,1)"
			}];

			$scope.loadingEquity = false;
			$scope.loadingEquityError = false;

			$scope.chartDate = function(number) {
				$scope.chartYears = number;
			}

			$scope.gogogo = function(item){
				$scope.equityData.price++
				$scope.equityData.bidPrice1++
				$scope.equityData.bidVolume3++

			}

			$scope.comparisonSelect = function(item){
				event.preventDefault();
				window.stop();
				document.execCommand("Stop");
				return false;
			}

			$scope.colours = ['#01aaad','#f08d0e', {
				fillColor: 'transparent',
				strokeColor: "rgba(220,0,0,1)",
				pointColor: "rgba(220,0,0,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(220,220,220,1)"
			}];

		})

		.directive('animateOnChange', function($animate,$timeout) {
			return function(scope, elem, attr) {
				scope.$watch(attr.animateOnChange, function(nv,ov, scope) {
					if ((nv != ov) && (angular.isUndefined(ov) == false)) {
						var c
						if(nv > ov){
							c = 'change-up';
						}else{
							c = 'change';
						}
						$animate.addClass(elem,c).then(function() {
							$timeout(function() {$animate.removeClass(elem,c);});
						});
					}
				});
			};

		});

}());