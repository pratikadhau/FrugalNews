var homeApp = angular.module("homeApp", [ "ngRoute" ]);
homeApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		controller : "HomeController",
		templateUrl : "modules/home/home.html"
	});
} ]);


