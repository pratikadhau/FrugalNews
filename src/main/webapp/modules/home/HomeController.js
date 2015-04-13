homeApp.controller("HomeController", [
		"$scope",
		"$rootScope",
		"$http",
		function($scope, $rootScope, $http) {
			$scope.activeTab = 'home'
			
			$http.get($rootScope.baseUrl + "/api/news").success(function(data) {
				$scope.newsList = data;
			});

			$http.get($rootScope.baseUrl + "/api/news/types").success(
					function(data) {
						$scope.newsTypes = data;
					});

			$scope.showSelectedNews = function(news) {
				$scope.selectedNews = news.newsDetail;
			}

			$scope.showsNews = function(newsType) {
				$http.get($rootScope.baseUrl + "/api/news/types/" + newsType)
						.success(function(data) {
							$scope.newsList = data;
							$scope.selectedNews = "";
							$scope.activeTab = newsType
						});
			}

			$scope.showsAllNews = function() {
				$http.get($rootScope.baseUrl + "/api/news").success(
						function(data) {
							$scope.newsList = data;
							$scope.selectedNews = "";
							$scope.activeTab = "home";
				});
			};
			
			$scope.isActive = function (newsType){
				return $scope.activeTab == newsType ? 'active' : '';
			}
		} ]);