<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html ng-app="bookingsApp">
<head>
    <title>Bookings</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="app/css/font-awesome.min.css" type="text/css" />
	<link rel="stylesheet" href="app/css/app.css" type="text/css" />
	<link rel="stylesheet" href="app/css/custom.css" type="text/css" />

</head>
<body>
<script type="text/javascript">
var jsAtt = '${username}';
var jsAtt2 = '${password}';

</script>

<div id="wrapper">

	<header id="header">

		<h1 id="site-logo">
			<a href="/">
				<img src="/img/logo.png" alt="Site Logo" />
			</a>
		</h1>

		<a href="javascript:;" data-toggle="collapse" data-target=".top-bar-collapse" id="top-bar-toggle" class="navbar-toggle collapsed">
			<i class="fa fa-cog"></i>
		</a>

		<a href="javascript:;" data-toggle="collapse" data-target=".sidebar-collapse" id="sidebar-toggle" class="navbar-toggle collapsed">
			<i class="fa fa-reorder"></i>
		</a>

	</header> <!-- header -->

	<nav id="top-bar" class="collapse top-bar-collapse">

		<ul class="nav navbar-nav pull-left">
			<li class="">
				<a href="/">
					<i class="fa fa-home"></i>
					Home
				</a>
			</li>

			<li class="dropdown">
		    	<a class="dropdown-toggle" data-toggle="dropdown" href="javascript:;">
		        	Dropdown <span class="caret"></span>
		    	</a>

		    	<ul class="dropdown-menu" role="menu">
			        <li><a href="javascript:;"><i class="fa fa-user"></i>&nbsp;&nbsp;Example #1</a></li>
			        <li><a href="javascript:;"><i class="fa fa-calendar"></i>&nbsp;&nbsp;Example #2</a></li>
			        <li class="divider"></li>
			        <li><a href="javascript:;"><i class="fa fa-tasks"></i>&nbsp;&nbsp;Example #3</a></li>
		    	</ul>
		    </li>

		</ul>

		<ul class="nav navbar-nav pull-right">
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="">
					<i class="fa fa-user"></i>
		        	Rod Howard
		        	<span class="caret"></span>
		    	</a>

		    	<ul class="dropdown-menu" role="menu">
			        <li>
			        	<a href="./page-profile.html">
			        		<i class="fa fa-user"></i>
			        		&nbsp;&nbsp;My Profile
			        	</a>
			        </li>
			        <li>
			        	<a href="./page-calendar.html">
			        		<i class="fa fa-calendar"></i>
			        		&nbsp;&nbsp;My Calendar
			        	</a>
			        </li>
			        <li>
			        	<a href="./page-settings.html">
			        		<i class="fa fa-cogs"></i>
			        		&nbsp;&nbsp;Settings
			        	</a>
			        </li>
			        <li class="divider"></li>
			        <li>
			        	<a href="./page-login.html">
			        		<i class="fa fa-sign-out"></i>
			        		&nbsp;&nbsp;Logout
			        	</a>
			        </li>
		    	</ul>
		    </li>
		</ul>

	</nav>

	<div id="sidebar-wrapper">
		<nav id="sidebar">
			<ul id="main-nav" class="open-active">
				<li class="">
					<a href="./index.html">
						<i class="fa fa-dashboard"></i>
						Dashboard
					</a>
				</li>
				<li class="dropdown">
					<a href="">
						<i class="fa fa-file-text"></i>
						Example Pages
						<span class="caret"></span>
					</a>
					<ul class="sub-nav">
						<li>
							<a href="./page-profile.html">
								<i class="fa fa-user"></i>
								Profile
							</a>
						</li>
						<li>
							<a href="./page-invoice.html">
								<i class="fa fa-money"></i>
								Invoice
							</a>
						</li>
					</ul>
				</li>

				<li class="dropdown">
					<a href="">
						<i class="fa fa-tasks"></i>
						Form Elements
						<span class="caret"></span>
					</a>

					<ul class="sub-nav">
						<li>
							<a href="./form-regular.html">
								<i class="fa fa-location-arrow"></i>
								Regular Elements
							</a>
						</li>
						<li>
							<a href="./form-extended.html">
								<i class="fa fa-magic"></i>
								Extended Elements
							</a>
						</li>
					</ul>
				</li>

				<li class="dropdown">
					<a href="">
						<i class="fa fa-desktop"></i>
						UI Features
						<span class="caret"></span>
					</a>
					<ul class="sub-nav">
						<li>
							<a href="./ui-buttons.html">
								<i class="fa fa-hand-o-up"></i>
								Buttons
							</a>
						</li>
						<li>
							<a href="./ui-tabs.html">
								<i class="fa fa-reorder"></i>
								Tabs &amp; Accordions
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>

		<div id="content" ng-controller="MainController">

		      Choose:


		      <div ng-view></div>
		      <hr />

		      <pre>$location.path() = {{$location.path()}}</pre>
		      <pre>$route.current.templateUrl = {{$route.current.templateUrl}}</pre>
		      <pre>$route.current.params = {{$route.current.params}}</pre>
		      <pre>$route.current.scope.name = {{$route.current.scope.name}}</pre>
		      <pre>$routeParams = {{$routeParams}}</pre>
	    </div>
    </div>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://code.angularjs.org/1.2.4/angular.js"></script>
	<script src="http://code.angularjs.org/1.2.4/angular-route.js"></script>
    <script src="app/js/ui-bootstrap-custom-0.9.0.min.js"></script>
    <script src="app/js/ui-bootstrap-custom-tpls-0.9.0.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script src="app/js/app.js"></script>
    <script src="app/js/init.js"></script>
    <script src="app/js/controllers.js"></script>

    <script src="https://apis.google.com/js/client.js?onload=init"></script>
</body>
</html>