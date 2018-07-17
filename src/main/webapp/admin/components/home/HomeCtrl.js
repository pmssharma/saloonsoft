(function() {


angular.module('homeController', [])
	.controller('HomeCtrl', function($scope, $rootScope, $http, $uibModal, $state, SalonSoftUser,SalonSoftSiteConfigService) {

		$scope.showEntityButton = false;
		$scope.showDealButton = false;
		$scope.tabData = {};
		$scope.tabData.tabs = [
			{ heading:'Schedule', route : 'loggedIn.home'},
			{ heading:'Products', route : 'loggedIn.products'},
			{ heading:'Reports', route : 'loggedIn.reports'}
		];

		$scope.logout = function(){
			$state.go('login');
		};

		$scope.searchForm = {};
		$scope.searchForm.query = "";

		$scope.setEntitySearch = function(entityId){
			$scope.$parent.entity = entityId;
		}






		/*
		 -------
		 */
		$scope.asyncSelected = "";
		$scope.onSelect = function(item, model, label, event) {
			$scope.asyncSelected = "";
			//$state.go('default.loggedIn.equity.home', {equityId : item.substring(0, item.search(" - "))});
		}

		$scope.getLocation = function(val) {
			//return $http.get(SalonSoftSiteConfigService.searchUrl + val)
			return $http.get(SalonSoftSiteConfigService.searchUrl)
				.then(function(response){
					return response.data.data.map(function(item){
						return item.code + " - " + item.longName;
					});
				});
		};

		/*
		 -------
		 */


		$scope.performingLogin = false;
		$scope.loggedIn = SalonSoftUser.userIsLoggedIn;

		$scope.userLoginData = {};
		$scope.userData = SalonSoftUser.userData;

		$scope.loginCallback = function(data){
			if(angular.isUndefined(data) || data.status == "ERROR"){
				$scope.modalInstance = $uibModal.open({
					templateUrl: 'loginFail.html.inline',
					controller: 'LoginModalCtrl',
					size: 'sm',
					backdrop: 'static'
				});
			}else{
				$state.go('default.loggedIn.home');

				$scope.userData = SalonSoftUser.userData;
			}
			$scope.performingLogin = false;
			$scope.loggedIn = SalonSoftUser.userIsLoggedIn;
		}

		$scope.performLogin = function(){
			$scope.performingLogin = true;

			SalonSoftUser.userLogin($scope.userLoginData.userName, $scope.userLoginData.password, $scope.loginCallback);
			$scope.userLoginData = {};
		}

		$scope.logout = function(){

			SalonSoftUser.logout();

			$scope.loggedIn = false;
			$scope.performingLogin = false;
			$state.go('default.anonymous');
		}


		$scope.stockInterval  = 2500;
		$scope.stockWrapSlides = false;
		$scope.stocks = [];
		$scope.dataLoadingFail = false;
		$scope.dataLoading = true;







		$rootScope.$on('$stateChangeSuccess',
			function(event, toState, toParams, fromState, fromParams){
				//resolveEntity();
			}
		);
		//resolveEntity();

	}
)

.config(['$stateProvider', function($stateProvider, $scope) {



	}]);

})()
