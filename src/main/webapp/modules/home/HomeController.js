homeApp.controller("HomeController", [
		"$scope",
		"$http",
		function($scope, $http) {
			$http.get("http://localhost:8080/FrugalNews/api/news").success(
					function(data) {
						$scope.newsList = data;
					});
		} ]
);