(function() {


	angular.module('scheduleController', [])
		.controller('ScheduleCtrl', function($scope, $rootScope, $http, $uibModal, $state, SalonSoftSiteConfigService) {

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
				var dayStartTime = timestrToMins($scope.startTime);
				var startPositio;
				var positionIncrement;

				angular.forEach(response.schedule, function (appointment, key) {

					appointmentStartTime = timestrToMins(appointment.startTime);
					startPosition = appointmentStartTime - dayStartTime;
					positionIncrement = startPosition;

					angular.forEach(appointment.services, function (services, k1) {
						angular.forEach(services.steps, function (step, k11) {
							//debugger
							step.name = step.staffAssignedName;

							step.positionIncrement = positionIncrement;
							step.durationIncrements = timestrToMins(step.duration);

							if(step.staffAssignedName) {
								if (newHashList[step.staffAssignedName]) {
									newHashList[step.staffAssignedName].push(step)
									newList[newHashList[step.staffAssignedName].otherIndex].push(step);
								} else {
									newHashList[step.staffAssignedName] = [];
									newHashList[step.staffAssignedName].push(step);
									newHashList[step.staffAssignedName].otherIndex = newList.length;
									var newItem = newList[newList.length] = [];
									newItem.push(step);
								}
							}

							startPosition += timestrToMins(step.duration);
							positionIncrement = startPosition;
						});
					});
				});
				$scope.scheduleData = newList;
			}



			/*
			$scope.scheduleData = {};
			function callback(response) {
				var newList = [];
				var newHashList = [];
				angular.forEach(response.schedule, function (value, key) {
					debugger
					var appointmentStartTime = timestrToMins(value.startTime);
					var dayStartTime = timestrToMins($scope.startTime);
					var startPosition = appointmentStartTime - dayStartTime;
					var positionIncrement = startPosition/5;

					angular.forEach(value.services, function (v1, k1) {//this is nested angular.forEach loop
						angular.forEach(v1.steps, function (v11, k11) {//this is nested angular.forEach loop
							//debugger
							v11.name = v11.staffAssignedName;

							v11.startPosition = startPosition;
							v11.positionIncrement = positionIncrement;
							v11.durationIncrements = timestrToMins(v11.duration);

							if(v11.staffAssignedName) {
								if (newHashList[v11.staffAssignedName]) {
									newHashList[v11.staffAssignedName].push(v11)
									newList[newHashList[v11.staffAssignedName].otherIndex].push(v11);
								} else {
									newHashList[v11.staffAssignedName] = [];
									newHashList[v11.staffAssignedName].push(v11);
									newHashList[v11.staffAssignedName].otherIndex = newList.length;
									var newItem = newList[newList.length] = [];
									newItem.push(v11);
								}
							}

							startPosition += timestrToMins(v11.duration);
							positionIncrement = startPosition/5;
						});
					});
				});
				$scope.scheduleData = newList;
			}
			*/

			function callbackError(response){

			}

			function timestrToMins(timestr) {
				var parts = timestr.split(":");
				return (Number(parts[0]) * 60) + (Number(parts[1]));
			}

			getSchedule();


		}

	)


}());
