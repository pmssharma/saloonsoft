(function() {


	angular.module('clientsController', [])
		.controller('ClientsCtrl', function($scope, $rootScope, $http, $uibModal, $state, SalonSoftSiteConfigService) {


			$scope.appoiuntmentDetails = function(num) {
				$scope.modalInstance = $uibModal.open({
					templateUrl: 'scheduleItem.html.inline',
					controller: 'AppointmentDetailsModalCtrl',
					size: 'md',
					resolve: {
						parentController : function () {
							return $scope;
						}
					}
				});
			}

			function getSchedule () {
				return $http.get(SalonSoftSiteConfigService.scheduleUrl, {}).then(function (response) {
					if (response.status === 200) {
						callback(response.data.data, response.status);
					} else {
						callbackError({
							status: "ERROR",
							message: message.data.message || "Unable..."
						});
					}
				}, function error(message) {
					if (message && message.data) {
						callbackError({
							status: "ERROR",
							message: message.data.message || "Unable to authenticate."
						});
					} else {
						callbackError({
							status: "ERROR",
							message: "Active Directory is unreachable. Unable to authenticate your credentials."
						});
					}
				});
			}


			$scope.startHour = 7;
			$scope.startTime = "7:00";
			$scope.numberOfHours = 12;
			$scope.getNumber = function(num) {
				$scope.startHour = $scope.startHour - 1;
				$scope.startHour++;
				return new Array(num);
			}

			$scope.scheduleData = {};
			function callback(response) {
				var newList = [];
				var newHashList = [];

				var appointmentStartTime;
				var dayStartTime;
				var startPosition;
				var leftPosition;
				//value.appointmentStartTime = startPosition;

				var testme = 0;
				var testme2 = 0;

				angular.forEach(response.schedule, function (value, key) {

					appointmentStartTime = timestrToMins(value.startTime);
					dayStartTime = timestrToMins($scope.startTime);
					startPosition = appointmentStartTime - dayStartTime;
					leftPosition = 0;
					value.appointmentStartTime = startPosition;

					angular.forEach(value.services, function (v1, k1) {

						angular.forEach(v1.steps, function (v11, k11) {

							testme += timestrToMins(v11.duration);
							testme2 += timestrToMins(v11.duration);

						})

						v1.duration = testme2;
						testme2 = 0;

					})

					value.duration = testme + 1;
					newList.push(value);
					testme = 0;
				})


				/*
				angular.forEach(response.schedule, function (value, key) {
					debugger
					var appointmentStartTime = timestrToMins(value.startTime);
					var dayStartTime = timestrToMins($scope.startTime);
					var startPosition = appointmentStartTime - dayStartTime;
					var leftPosition = 0;//startPosition/5;
					value.appointmentStartTime = startPosition;

					var testme = 0;
					angular.forEach(value.services, function (v1, k1) {//this is nested angular.forEach loop
						angular.forEach(v1.steps, function (v11, k11) {//this is nested angular.forEach loop
							//debugger
							v11.name = v11.staffAssignedName;

							//v11.startPosition = startPosition;
							///console.log(leftPosition)
							v11.leftPosition = leftPosition;
							v11.durationIncrements = timestrToMins(v11.duration);
							testme += v11.durationIncrements;
							//console.log(timestrToMins(v11.duration) +" -- "+ testme)

							if(v11.staffAssignedName) {
								if (newHashList[v11.staffAssignedName]) {
									//newHashList[v11.staffAssignedName].push(v11)
									//newList[newHashList[v11.staffAssignedName].otherIndex].push(v11);
								} else {
									newHashList[v11.staffAssignedName] = [];
									//newHashList[v11.staffAssignedName].push(v11);
									newHashList[v11.staffAssignedName].otherIndex = newList.length;
									//var newItem = newList[newList.length] = [];
									//newItem.push(v11);
								}
							}else{
								leftPosition += timestrToMins(v11.duration);
							}

							startPosition += timestrToMins(v11.duration);
							//leftPosition += timestrToMins(v11.duration);
						});

						value.duration = testme + 42;
						newHashList.push(value)
						newList.push(value);
					});
				});
				*/
				$scope.scheduleData = newList;
			}

			function callbackError(response){

			}

			function timestrToMins(timestr) {
				var parts = timestr.split(":");
				return (Number(parts[0]) * 60) + (Number(parts[1]));
			}

			getSchedule();


		}

	)

	angular.module('clientsController')
		.controller('AppointmentDetailsModalCtrl', function($scope, $rootScope, $uibModal, $uibModalInstance, parentController) {

			$scope.close = function(){
				$uibModalInstance.dismiss('cancel');
			}
		})


}());
