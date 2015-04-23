homeApp.controller("HomeController", [
		"$scope",
		"$rootScope",
		"$http",
		function($scope, $rootScope, $http) {
			_readNews = {};
			$scope.readNews ={};
			$scope.activeTab = 'home'
			$scope.readNews ={};
			$scope.summaryView = true;
			$http.get($rootScope.baseUrl + "/api/news").success(function(data) {
				$scope.newsList = data;
				$scope.newsList.forEach(function(e,i,a) {
					$scope.readNews[e.newsId]=false
				})
			});

			$http.get($rootScope.baseUrl + "/api/news/types").success(
					function(data) {
						$scope.newsTypes = data;
					});

			
			$scope.showSelectedNews = function(news) {
				$scope.selectedNews = news;
				$scope.readNews[news.newsId] = true
				$scope.summaryView = false;
			}
			
			$scope.showsNews = function(newsType) {
				$http.get($rootScope.baseUrl + "/api/news/types/" + newsType)
						.success(function(data) {
							$scope.newsList = data;
							$scope.selectedNews = "";
							$scope.activeTab = newsType
						});
				$scope.summaryView = true;
			}

			$scope.showsAllNews = function() {
				$http.get($rootScope.baseUrl + "/api/news").success(
						function(data) {
							$scope.newsList = data;
							$scope.newsList.forEach(function(e,i,a) {
								$scope.readNews[e.newsId]=false
							})
							$scope.selectedNews = "";
							$scope.activeTab = "home";
				});
				$scope.summaryView = true;
			};
			
			$scope.isActive = function (newsType){
				return $scope.activeTab == newsType ? 'active' : '';
			}
			
			$scope.goToSummaryView = function() {
				$scope.summaryView = true
			}
			
		} ]);