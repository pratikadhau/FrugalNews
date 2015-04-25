homeApp.controller("HomeController", [
		"$scope",
		"$rootScope",
		"$http",
		function($scope, $rootScope, $http) {
			_readNews = {};
			$scope.readNews ={};
			$scope.activeTab = 'Headline'
			$scope.readNews ={};
			$scope.summaryView = true;
			$http.get($rootScope.baseUrl + "/api/news").success(function(data) {
				$scope.newsList = []
				$scope.allNews = data;
				$scope.allNews.forEach(function(e,i,a) {
					$scope.readNews[e.newsId]=false;
					if(e.newsType == 'Headline')
					$scope.newsList.push(e);
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
				var _allNews = $scope.allNews;
				var _filteredNews = [];
				_allNews.forEach(function(e,i,a) {
					if(e.newsType == newsType){
						_filteredNews.push(e);
					}
				});	
				$scope.newsList = _filteredNews;
				$scope.selectedNews = "";
				$scope.activeTab = newsType
				$scope.summaryView = true;
			}

			
			$scope.isActive = function (newsType){
				return $scope.activeTab == newsType ? 'active' : '';
			}
			
			$scope.goToSummaryView = function() {
				$scope.summaryView = true
			}
			
		} ]);