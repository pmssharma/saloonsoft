(function() {

	var SalonSoftGlobalServiceObj = function($http, $q, $window, $location){
		var factory = {
			entityDisplayName: 'tempName'
		}
		return  factory
	}

	var SalonSoftPortfolioServiceObj = function($http, $q, $window, $location, SalonSoftSiteConfigService){

		var factory = {
			getOrders: function (callback) {
				return $http.get(SalonSoftSiteConfigService.ordersUrl, {
				}).then(function (response) {

					if (response.status === 200) {
						callback(response.data.data, response.status);
					}else{
						callback({
							status: "ERROR",
							message: message.data.message || "Unable..."
						});
					}
				}, function error(message) {
					if (message && message.data) {
						callback({
							status: "ERROR",
							message: message.data.message || "Unable to authenticate."
						});
					} else {
						callback({
							status: "ERROR",
							message: "Active Directory is unreachable. Unable to authenticate your credentials."
						});
					}
				});
			},
			getPortfolioPerrformance: function (callback) {
				return $http.get(SalonSoftSiteConfigService.portfolioPerformanceUrl, {
				}).then(function (response) {

					if (response.status === 200) {
						callback(response.data.data, response.status);
					}else{
						callback({
							status: "ERROR",
							message: message.data.message || "Unable..."
						});
					}
				}, function error(message) {
					if (message && message.data) {
						callback({
							status: "ERROR",
							message: message.data.message || "Unable to authenticate."
						});
					} else {
						callback({
							status: "ERROR",
							message: "Active Directory is unreachable. Unable to authenticate your credentials."
						});
					}
				});
			}
		};
		return factory;
	};

var SalonSoftAuthorizationObj = function($rootScope, $state, SalonSoftUser){
	return {
		validateUserAndBootstrap: function() {
			var returnVal;
			if(SalonSoftUser.isLoggedIn()){
				returnVal = true;
			}else {
				returnVal = SalonSoftUser.userValidation()
					.then(function () {
						var isAuthenticated = SalonSoftUser.isAuthenticated();
						if (isAuthenticated) {
							// Get bootstrap stuff
						} else {
							$rootScope.returnToState = $rootScope.toState;
							$rootScope.returnToStateParams = $rootScope.toStateParams;

							$state.go('default.loggedOutNotice');
						}
					});
			}

			return returnVal;
		}
	};
}
var SalonSoftUserObj = function($q, $http, $timeout, SalonSoftSiteConfigService){

	var _identity = undefined,
		_authenticated = false,
		_userIsLoggedIn = false;

	var factory = {
		userData: {},
		userIsLoggedIn : false,
		isAuthenticated: function() {
			return _authenticated;
		},
		isLoggedIn: function() {
			return _userIsLoggedIn;
		},
		userValidation: function(force) {
			var deferred = $q.defer();

			if (force === true) _identity = undefined;

			$http.get(SalonSoftSiteConfigService.loginVerificationUrl, { ignoreErrors: true })
				.success(function(data) {
					_identity = data.data;
					_authenticated = true;
					_userIsLoggedIn = true;

					factory.userIsLoggedIn = true;
					factory.userData = data.data;
					deferred.resolve(_identity);
				})
				.error(function () {
					_identity = undefined;
					_authenticated = false;
					_userIsLoggedIn = false;

					factory.userIsLoggedIn = false;
					factory.userData = {};
					deferred.resolve(_identity);
				});

			return deferred.promise;
		},
		logout: function (userName, password, callback) {
			_identity = undefined;
			_authenticated = false;
			_userIsLoggedIn = false;

			factory.userData = {};
			factory.userIsLoggedIn = false;
		},
		userLogin: function (userName, password, callback) {
			return $http.get(SalonSoftSiteConfigService.loginUrl,
				{
					userName: userName, password: password
				}
			).then(function (response) {
				if (response.status === 200) {
					_userIsLoggedIn = true;
					_authenticated = true;
					factory.userIsLoggedIn = true;

					_identity = response.data.data;
					factory.userData = response.data.data;
					callback(response.data.data, response.status);
				}
			}, function error(message) {
				_identity = undefined;
				_authenticated = false;
				_userIsLoggedIn = false;
				factory.userData = {};
				factory.userIsLoggedIn = false;
				if (message && message.data) {
					callback({
						status: "ERROR",
						message: message.data.message || "Unable to authenticate."
					});
				} else {
					callback({
						status: "ERROR",
						message: "Active Directory is unreachable. Unable to authenticate your credentials."
					});
				}
			});
		}
	};
	return factory
}








var SalonSoftApp = angular.module('salonSoftApp', [ 'ui.router',
													'ui.bootstrap',
													'ui.router.tabs',
													'ngCookies',
													'ngAnimate',
													'ngMessages',
													'loginController',
													'homeController',
													'homeContentController',
													'scheduleController',
													'clientsController',
													'loginContentController',
													'reportsController',
													'productsController'
										])
.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {

	$stateProvider.state('default', {
		abstract:true,
		url: '',
		templateUrl: 'components/login/login1.html',
		controller: 'LoginCtrl',
		redirectTo: 'default.anonymous'
	})
	.state('default1', {
		abstract:true,
		url: '/',
		templateUrl: 'components/login/login1.html',
		controller: 'LoginCtrl',
		redirectTo: 'default.anonymous'
	})
	.state('default.anonymous', {
		url: '/',
		templateUrl: 'components/login/loginContent.html',
		controller: 'LoginContentCtrl'
	})


	.state('default.loggedOutNotice', {
		url: '/loggedOut',
		templateUrl: 'components/login/loginFail.html',
		controller: 'LoginContentCtrl'
	})

	.state('loggedIn', {
		abstract:true,
		templateUrl: 'components/home/home-container.html',
		controller: 'HomeCtrl',
		params : {accountId : ''},
		resolve: {
			authorize: ['SalonSoftAuthorizationService',
				function(SalonSoftAuthorizationService) {
					return SalonSoftAuthorizationService.validateUserAndBootstrap();
				}
			]
		}
	})

	.state('loggedIn.home', {
		url: '/home',
		redirectTo: 'loggedIn.home.schedule',
		templateUrl: 'components/home/home-content.html',
		controller: 'HomeContentCtrl',
		params : {accountId : ''}
	})
	.state('loggedIn.home.schedule', {
		url: '/schedule',
		templateUrl: 'components/home/schedule2.html',
		controller: 'ScheduleCtrl',
		params : {accountId : ''}
	})
	.state('loggedIn.home.clients', {
		url: '/clients',
		templateUrl: 'components/home/clients.html',
		controller: 'ClientsCtrl',
		params : {accountId : ''}
	})
	.state('loggedIn.home.individual', {
		url: '/individual',
		templateUrl: 'components/home/individual.html',
//		controller: 'HomeContentCtrl',
		params : {accountId : ''}
	})
	.state('loggedIn.reports', {
		url: '/reports',
		redirectTo: 'loggedIn.reports.all',
		controller: 'ReportsCtrl',
		templateUrl: 'components/reports/reports.html',
		params : {accountId : ''}
	})
		.state('loggedIn.reports.all', {
			url: '/',
			controller: 'ReportsAllCtrl',
			templateUrl: 'components/reports/reportsOverview.html'
		})

	.state('loggedIn.beneficiaries', {
		url: '/beneficiaries',
		redirectTo: 'loggedIn.beneficiaries.home',
		controller: 'BeneficiariesCtrl',
		templateUrl: 'components/beneficiaries/beneficiaries.html',
		params : {equityId : ''}
	})
		.state('loggedIn.beneficiaries.home', {
			url: '/{equityId}',
			controller: 'BeneficiariesDetailCtrl',
			templateUrl: 'components/beneficiaries/beneficiariesDetail.html',
			params : {equityId : ''}
		})

	.state('loggedIn.products', {
		url: '/products',
		redirectTo: 'loggedIn.products.all',
		controller: 'ProductsCtrl',
		templateUrl: 'components/products/products.html',
		params : {}
	})
	.state('loggedIn.products.all', {
		url: '/all',
		//redirectTo: 'loggedIn.equity.home',
		controller: 'ProductsCtrl',
		templateUrl: 'components/products/products.html',
		params : {state : 'all'}
	});

	$urlRouterProvider.otherwise('/');
}])

	.run(function ($rootScope, $state, $location, SalonSoftAuthorizationService, SalonSoftUser, $uibModalStack) {

		$rootScope.$on('$stateChangeStart', function(evt, to, params, $scope) {
			if (to.redirectTo) {
				evt.preventDefault();
				$state.go(to.redirectTo, params)
			}
			//if (!SalonSoftUser.isIdentityResolved()){
			//	//alert()
			//	SalonSoftAuthorizationService.authorize();
			//}

			if ($uibModalStack) {
				$uibModalStack.dismissAll('close');
			}

		});


	})
.factory('SalonSoftSiteConfigService', function(){
		return {
			loginUrl : 'components/testSvc/login.js',
			loginVerificationUrl : 'components/testSvc/login.js',
			portfolioPerformanceUrl : 'components/testSvc/portfolio.js',
			ordersUrl: 'components/testSvc/ordersOpen.js',
			searchUrl : 'components/testSvc/search.js',
			scheduleUrl: '/api/appointment/v1/getAppointmentByDate?appDate=2018-07-05'
		};
	})
.factory('SalonSoftGlobalService', SalonSoftGlobalServiceObj)
.factory('SalonSoftPortfolioService', SalonSoftPortfolioServiceObj)
.factory('SalonSoftAuthorizationService', SalonSoftAuthorizationObj)
.factory('SalonSoftUser', SalonSoftUserObj)

}());