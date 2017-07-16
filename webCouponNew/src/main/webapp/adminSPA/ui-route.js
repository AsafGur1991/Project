var app = angular.module("AdminSPA",['ui.router',"ngCookies"])
.config(['$urlRouterProvider','$stateProvider',function($urlRouterProvider,$stateProvider){
	$urlRouterProvider.otherwise('/');
	
	$stateProvider
	.state('/',{
		url:"/",
		templateUrl: 'home.html'
		
	})
	.state('home',{
		templateUrl: 'home.html'
		
	})
	.state('createCompany',{
		templateUrl: 'createCompany.html',
		controller :'createCompanyCtrl as a'
	})
	.state('removeCompany',{
		templateUrl: 'removeCompany.html',
		controller :'removeCompanyCrtl as b'
	})
	.state('updateCompany',{
		templateUrl: 'updateCompany.html',
		controller :'updateCompanyCrtl as c'
	})
	.state('getCompany',{
		templateUrl: 'getCompany.html',
		controller :'getCompanyCrtl as d'
	})
	.state('getAllCompanys',{
		templateUrl: 'getAllCompanys.html',
		controller :'getAllCompanyCrtl as e'
	})
	.state('createCustomer',{
		templateUrl: 'createCustomer.html',
		controller :'createCustomerCrtl as f'
	})
	.state('removeCustomer',{
		templateUrl: 'removeCustomer.html',
		controller :'removeCustomerCrtl as g'
	})
	.state('updateCustomer',{
		templateUrl: 'updateCustomer.html',
		controller :'updateCustomerCrtl as h'
	})
	.state('getCustomer',{
		templateUrl: 'getCustomer.html',
		controller :'getCustomerCrtl as i'
	})
	.state('getAllCustomers',{
		templateUrl: 'getAllCustomer.html',
		controller :'getAllCustomerCrtl as j'
	})
	
	
}])