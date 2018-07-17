(function() {


angular.module('loginContentController', [])
	.controller('LoginContentCtrl', function($scope, $http, $uibModal, $rootScope) {


		$scope.myInterval = 5000;
		$scope.noWrapSlides = false;
		$scope.slides = [];
		$scope.slides.push(
			{
				image: 'img/advert/1.png'
			},
			{
				image: 'img/advert/2.png'
			},
			{
				image: 'img/advert/3.png'
			},
			{
				image: 'img/advert/4.png'
			},
			{
				image: 'img/advert/5.png'
			}
		);


		$scope.stockInterval  = 2500;
		$scope.stockWrapSlides = false;
		$scope.stocks = [];

		$scope.dataLoadingFail = false;
		$scope.dataLoading = true;

		$scope.go = function(){
			alert();
		}

	}
)



})()
