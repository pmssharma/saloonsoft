(function() {


angular.module('homeContentController', [])
	.controller('HomeContentCtrl', function($scope, $rootScope, $http, $uibModal, $state) {

		$scope.showHeader = true;
		function setHeaderVisibility(){
			if($state.current.name == 'loggedIn.home.schedule' || $state.current.name == 'loggedIn.home.clients'){
				$scope.showHeader = true;
			}else{
				$scope.showHeader = false;
			}
		}
		setHeaderVisibility()
		$rootScope.$on('$stateChangeSuccess',
			function(event, toState, toParams, fromState, fromParams){
				$scope.radioModel = $state.current.name;
				setHeaderVisibility()
			}
		);

		$scope.radioModel = $state.current.name;

		$scope.showClients = function(row){

			$state.go('loggedIn.home.clients')
			$scope.radioModel = $state.current.name;

		}
		$scope.showSchedule = function(row){

			$state.go('loggedIn.home.schedule')
			$scope.radioModel = $state.current.name;
		}



		$scope.newApp = function(row){

			$uibModal.open({
				templateUrl: 'newBooking.html.inline',
				controller: 'HomeContentCtrls',
				size: 'lg',
				resolve: {
					parentController : function () {
						return $scope;
					}
				}
			});

		}





		$scope.today = function() {
			$scope.dt = new Date();
		};
		$scope.today();

		$scope.clear = function() {
			$scope.dt = null;
		};

		$scope.inlineOptions = {
			customClass: getDayClass,
			minDate: new Date(),
			showWeeks: true
		};

		$scope.dateOptions = {
			//dateDisabled: disabled,
			formatYear: 'yy',
			maxDate: new Date(2020, 5, 22),
			minDate: new Date(),
			startingDay: 1
		};

		// Disable weekend selection
		function disabled(data) {
			var date = data.date,
				mode = data.mode;
			return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
		}

		$scope.open1 = function() {
			$scope.popup1.opened = true;
		};

		$scope.setDate = function(year, month, day) {
			$scope.dt = new Date(year, month, day);
		};

		$scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
		$scope.format = $scope.formats[0];
		$scope.altInputFormats = ['M!/d!/yyyy'];

		$scope.popup1 = {
			opened: false
		};

		var tomorrow = new Date();
		tomorrow.setDate(tomorrow.getDate() + 1);
		var afterTomorrow = new Date();
		afterTomorrow.setDate(tomorrow.getDate() + 1);
		$scope.events = [
			{
				date: tomorrow,
				status: 'full'
			},
			{
				date: afterTomorrow,
				status: 'partially'
			}
		];

		function getDayClass(data) {
			var date = data.date,
				mode = data.mode;
			if (mode === 'day') {
				var dayToCheck = new Date(date).setHours(0,0,0,0);

				for (var i = 0; i < $scope.events.length; i++) {
					var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

					if (dayToCheck === currentDay) {
						return $scope.events[i].status;
					}
				}
			}

			return '';
		}
	}

)

	angular.module('homeContentController')
		.controller('HomeContentCtrls', function($scope,$q, $log, $http, $uibModal, $uibModalInstance, parentController) {

			$scope.clients = [
				{ id: 1, name: 'Client 1',
					history : [{
						name: 'Cut & Blow',
						id : 1,
						steps : [{
							name: 'Cut',
							id: ''
						},{
							name: 'Wash',
							id: ''
						},{
							name: 'Wait',
							id: ''
						},{
							name: 'Tint',
							id: ''
						}]
					},{
						name: 'Tint and straighten',
						id : 2,
						steps : [{
							name: 'Cut',
							id: ''
						},{
							name: 'Blow',
							id: ''
						}]
					},{
						name: 'Tint and Flick',
						id : 2,
						steps : [{
							name: 'Cut',
							id: ''
						},{
							name: 'Blow',
							id: ''
						}]
					},{
						name: 'Colour',
						id : 2,
						steps : [{
							name: 'Cut',
							id: ''
						},{
							name: 'Blow',
							id: ''
						}]
					}]},
				{ id: 2, name: 'Client 2',
					history : [{
						name: 'Tint',
						id : 1,
						steps : [{
							name: 'Cut',
							id: ''
						},{
							name: 'Blow',
							id: ''
						}]
					},{
						name: 'Colour',
						id : 2,
						steps : [{
							name: 'Tint',
							id: ''
						},{
							name: 'Wash',
							id: ''
						},{
							name: 'Wait',
							id: ''
						},{
							name: 'Massage',
							id: ''
						}]
					}]},
				{ id: 3, name: 'Client 3'}];
			$scope.formClientItem;
			$scope.clientChange = function(item){

			}

			$scope.stylists = [
				{ id: 1, name: 'Stylist 1'},
				{ id: 2, name: 'Stylist 2'}];
			$scope.formStylistItem;

			$scope.services = [
				{ id: 1, name: 'Brazilian',
					steps : [{
						name: 'Step 1',
						id: ''
					},{
						name: 'Step 2',
						id: ''
					},{
						name: 'Step 3',
						id: ''
					}]},
				{ id: 2, name: 'European',
					steps : [{
						name: 'Cut',
						id: ''
					},{
						name: 'Wash',
						id: ''
					},{
						name: 'Wait',
						id: ''
					},{
						name: 'Tint',
						id: ''
					}]},
				{ id: 3, name: 'Simple cut  ',
					steps : [{
						name: 'Cut',
						id: ''
					},{
						name: 'Step',
						id: ''
					},{
						name: 'Wait',
						id: ''
					},{
						name: 'Steppy',
						id: ''
					}
					]
				}
			];
			$scope.formStylistItem;
			$scope.serviceChange = function(){
				this.addService();
			}

			$scope.isCollapsed = true;
			$scope.checkSlotVisibility = function(){
				if($scope.selectedServices.length > 0){
					$scope.showSlots = true;
					$scope.isCollapsed = false;
				}else{
					$scope.showSlots = false;
					$scope.isCollapsed = true;
				}
			}
			$scope.handleSelectedHistory = function(item){
				$scope.selectedServices.push(angular.copy(item));
				return false;
			}

			$scope.formServiceItem;
			$scope.selectedServices = [];
			$scope.addService = function(){
				if(this.formServiceItem) {
					$scope.selectedServices.push(angular.copy(this.formServiceItem));
					this.formServiceItem = null
				}
				$scope.checkSlotVisibility();
			}
			$scope.deleteService = function(item){
				debugger
				var index = $scope.selectedServices.indexOf(item);
				if (index !== -1) $scope.selectedServices.splice(index, 1);

				$scope.checkSlotVisibility();

				event.preventDefault();
			}
			$scope.deleteServiceStep = function(step, steps, service){
				if(steps.length > 1) {
					var index = steps.indexOf(step);
					if (index !== -1) steps.splice(index, 1);
				}else{
					var index = $scope.selectedServices.indexOf(service);
					if (index !== -1) $scope.selectedServices.splice(index, 1);
				}

				$scope.checkSlotVisibility();

				event.preventDefault();
			}





			$scope.parent = parentController;
			$scope.parents = {}

			$scope.p1 = true;
			$scope.p2 = false;
			$scope.p3 = false;

			$scope.checkAvailability = function(){
				$scope.p2 = true;
				$scope.p3 = false;
				$scope.p1 = false;
			}
			$scope.bookAppointmentDate = function(){
				$scope.p3 = true;
				$scope.p2 = false;
				$scope.p1 = false;
			}
			$scope.back = function(){
				$scope.p1 = true;
				$scope.p3 = false;
				$scope.p2 = false;
			}

			$scope.showSlots = false;
			$scope.findASlot = function(){
				$scope.showSlots = true;
			}


			$scope.today = function() {
				$scope.dt = new Date();
			};
			$scope.today();

			$scope.clear = function() {
				$scope.dt = null;
			};

			$scope.inlineOptions = {
				customClass: getDayClass,
				minDate: new Date(),
				showWeeks: true
			};

			$scope.dateOptions = {
				//dateDisabled: disabled,
				formatYear: 'yy',
				maxDate: new Date(2020, 5, 22),
				minDate: new Date(),
				startingDay: 1
			};

			// Disable weekend selection
			function disabled(data) {
				var date = data.date,
					mode = data.mode;
				return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
			}

			$scope.open1 = function() {
				$scope.popup1.opened = true;
			};

			$scope.setDate = function(year, month, day) {
				$scope.dt = new Date(year, month, day);
			};

			$scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
			$scope.format = $scope.formats[0];
			$scope.altInputFormats = ['dd-MMMM-yyyy'];

			$scope.popup1 = {
				opened: false
			};

			var tomorrow = new Date();
			tomorrow.setDate(tomorrow.getDate() + 1);
			var afterTomorrow = new Date();
			afterTomorrow.setDate(tomorrow.getDate() + 1);
			$scope.events = [
				{
					date: tomorrow,
					status: 'full'
				},
				{
					date: afterTomorrow,
					status: 'partially'
				}
			];

			function getDayClass(data) {
				var date = data.date,
					mode = data.mode;
				if (mode === 'day') {
					var dayToCheck = new Date(date).setHours(0,0,0,0);

					for (var i = 0; i < $scope.events.length; i++) {
						var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

						if (dayToCheck === currentDay) {
							return $scope.events[i].status;
						}
					}
				}

				return '';
			}



			$scope.scheduleData = {
				"ownerName": "Sandy"
			};
			$scope.startHour = 7;
			$scope.startTime = "7:00";
			$scope.numberOfHours = 12;
			$scope.getNumber = function(num) {
				$scope.startHour = $scope.startHour - 1;
				$scope.startHour++;
				return new Array(num);
			}
			function timestrToMins(timestr) {
				var parts = timestr.split(":");
				return (Number(parts[0]) * 60) + (Number(parts[1]));
			}

			$scope.bookAppointmentTime = function(){

			}
			//--------------

			//--------------



			$scope.closeLoginFail = function(){
				$uibModalInstance.dismiss('cancel');
			}
		}
	)



}());
