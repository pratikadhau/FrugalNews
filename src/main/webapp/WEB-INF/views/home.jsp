<!DOCTYPE HTML>
<html>
	<head>
		<title>Sample Application</title>
	<head>
		<script src="js/angular.min.js"></script>
		<script src="js/angular-route.min.js"></script>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<script src="modules/HomeModule.js"></script>
		<script src="modules/home/HomeController.js"></script>
		<script type="text/javascript">
			var APP_URL = '${appUrl}'
		</script>
	</head>
	
	<body ng-app="homeApp">
				<div ng-view></div>
	</body>
</html>