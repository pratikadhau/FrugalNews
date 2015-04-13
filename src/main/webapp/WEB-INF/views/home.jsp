<!DOCTYPE HTML>
<html>
	<head>
		<title>Sample Application</title>
	<head>
		<script src="js/angular.min.js"></script>
		<script src="js/angular-route.min.js"></script>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/frugal-news.css">
		<script src="modules/HomeModule.js"></script>
		<script src="modules/home/HomeController.js"></script>
		<script type="text/javascript">
			var APP_URL = '${appUrl}'
		</script>
	</head>
	
	<body ng-app="homeApp" class="container">
		<div class="text-primary">
    		<h1>Frugal News</h1>
		</div>
		<div ng-view></div>
	</body>
</html>