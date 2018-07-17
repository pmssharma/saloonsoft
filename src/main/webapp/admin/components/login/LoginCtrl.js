(function() {


angular.module('loginController', [])
	.controller('LoginCtrl', function($scope, $http, $uibModal, $state, SalonSoftUser, SalonSoftSiteConfigService) {


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
					controller: 'LoginModalFailCtrl',
					size: 'sm',
					backdrop: 'static'
				});
			}else{
				$state.go('loggedIn.home');

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


		$scope.forgotPassword = function(){
			$scope.modalInstance = $uibModal.open({
				templateUrl: 'loginForgotPassword.html.inline',
				controller: 'LoginModalForgotPasswordCtrl',
				size: 'sm',
				backdrop: 'static'
			});
		}

		$scope.oldInternet = function(){
			$scope.modalInstance = $uibModal.open({
				templateUrl: 'oldInternet.html.inline',
				controller: 'LoginModalOldInternetCtrl',
				//size: 'sm',
				backdrop: 'static'
			});
		}
		$scope.doNotUse = function(){
			$scope.modalInstance = $uibModal.open({
				templateUrl: 'doNotUse.html.inline',
				controller: 'LoginModalDoNotUseCtrl',
				//size: 'sm',
				backdrop: 'static'
			});
		}
		$scope.receivedMyProfileID = function(){
			$scope.modalInstance = $uibModal.open({
				templateUrl: 'receivedMyProfileID.html.inline',
				controller: 'LoginModalReceivedMyProfileIDCtrl',
				//size: 'sm',
				backdrop: 'static'
			});
		}
		$scope.noConfirmation = function(){
			$scope.modalInstance = $uibModal.open({
				templateUrl: 'noConfirmation.html.inline',
				controller: 'LoginModalNoConfirmationCtrl',
				//size: 'sm',
				backdrop: 'static'
			});
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

		$scope.message = "";
		var myDate = new Date();
		/* hour is before noon */
		if (myDate.getHours() < 12) {
			$scope.message = "Good morning ";
		}
		else  /* Hour is from noon to 5pm (actually to 5:59 pm) */
		if (myDate.getHours() >= 12 && myDate.getHours() <= 17) {
			$scope.message = "Good afternoon ";
		}
		else  /* the hour is after 5pm, so it is between 6pm and midnight */
		if (myDate.getHours() > 17 && myDate.getHours() <= 24) {
			$scope.message = "Good evening ";
		}
		else  /* the hour is not between 0 and 24, so something is wrong */ {
			$scope.message = "Hello ";
		}

	});


	angular.module('loginController')
		.controller('LoginModalFailCtrl', function($scope, $http, $uibModal, $uibModalInstance) {

			$scope.submitForgotPassword = function(){
				$uibModalInstance.dismiss('cancel');
			}

			$scope.closeLoginFail = function(){
				$uibModalInstance.dismiss('cancel');
			}
		}
	)


	angular.module('loginController')
		.controller('LoginModalForgotPasswordCtrl', function($scope, $http, $uibModal, $uibModalInstance) {

			$scope.submitForgotPassword = function(){
				$uibModalInstance.dismiss('cancel');
			}

			$scope.closeLoginFail = function(){
				$uibModalInstance.dismiss('cancel');
			}
		}
	)


	angular.module('loginController')
		.controller('LoginModalOldInternetCtrl', function($scope, $http, $uibModal, $uibModalInstance) {

			$scope.values = {};
			$scope.defaultSlide = true;
			$scope.nextSlide = false;
			$scope.processing = false;

			$scope.submitUpdate = function(){
				$scope.defaultSlide = false;
				$scope.nextSlide = false;
				$scope.processing = true;
			}
			$scope.getNextSlide = function(){
				$scope.defaultSlide = false;
				$scope.nextSlide = true;
				$scope.processing = false;
			}

			$scope.closeLoginFail = function(){
				$uibModalInstance.dismiss('cancel');
			}

		}
	)


	angular.module('loginController')
		.controller('LoginModalDoNotUseCtrl', function($scope, $http, $uibModal, $uibModalInstance) {

			$scope.closeLoginFail = function(){
				$uibModalInstance.dismiss('cancel');
			}

		}
	)


	angular.module('loginController')
		.controller('LoginModalReceivedMyProfileIDCtrl', function($scope, $http, $uibModal, $uibModalInstance) {

			$scope.closeLoginFail = function(){
				$uibModalInstance.dismiss('cancel');
			}

		}
	)


	angular.module('loginController')
		.controller('LoginModalNoConfirmationCtrl', function($scope, $http, $uibModal, $uibModalInstance) {

			$scope.closeLoginFail = function(){
				$uibModalInstance.dismiss('cancel');
			}

		}
	)
}());