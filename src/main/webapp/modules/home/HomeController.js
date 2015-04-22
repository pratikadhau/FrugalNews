homeApp.controller("HomeController", [
		"$scope",
		"$rootScope",
		"$http",
		function($scope, $rootScope, $http) {
			_readNews = {};
			$scope.readNews ={};
			$scope.activeTab = 'home'
				$scope.isSummaryView = true;
			$http.get($rootScope.baseUrl + "/api/news").success(function(data) {
				$scope.newsList = data;
			});

			$http.get($rootScope.baseUrl + "/api/news/types").success(
					function(data) {
						$scope.newsTypes = data;
					});

			
			$scope.showSelectedNews = function(news) {
				$scope.selectedNews = news;
				$scope.isSummaryView=false;
				$scope.readNews[news.newsId] = true
			}
			
			$scope.showsNews = function(newsType) {
				$http.get($rootScope.baseUrl + "/api/news/types/" + newsType)
						.success(function(data) {
							$scope.newsList = data;
							$scope.selectedNews = "";
							$scope.activeTab = newsType
						});
				$scope.isSummaryView=true
			}

			$scope.showsAllNews = function() {
					$http.get($rootScope.baseUrl + "/api/news").success(
							function(data) {
								$scope.newsList = data;
								$scope.newsList.forEach(function (e,i,a){
									_readNews[e.newsId]=false; 
								});
								$scope.readNews =_readNews;
								$scope.selectedNews = "";
								$scope.activeTab = "home";
							});
			};
			
			$scope.isActive = function (newsType){
				return $scope.activeTab == newsType ? 'active' : '';
			}
			
			$scope.goToSummary = function(){
				$scope.isSummaryView = true;
			}
			
		} ]);