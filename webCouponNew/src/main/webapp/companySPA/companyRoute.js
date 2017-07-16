/**
 * 
 */ 

var app = angular.module("companySPA", ["ui.router","ngCookies"]) 
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
	.state('createCoupon',{
		templateUrl: 'createCoupon.html',
		controller :'createCouponCtrl as a'
	})
	.state('removeCoupon',{
		templateUrl: 'removeCoupon.html',
		controller :'removeCouponCtrl as b'
	})
	.state('updateCoupon',{
		templateUrl: 'updateCoupon.html',
		controller :'updateCouponCtrl as c'
	})
	.state('getCoupon',{
		templateUrl: 'getCoupon.html',
		controller :'getCouponCtrl as d'
	})
	.state('getAllCoupons',{
		templateUrl: 'getAllCoupons.html',
		controller :'getAllCouponsCtrl as e'
	})
	.state('getAllCouponsByType',{
		templateUrl: 'getAllCouponsByType.html',
		controller :'getAllCouponsByTypeCtrl as f'
	})
	.state('getAllCouponsByPrice',{
		templateUrl: 'getAllCouponsByPrice.html',
		controller :'getAllCouponsByPriceCtrl as g'
	})
	.state('getAllCouponsByDate',{
		templateUrl: 'getAllCouponsByDate.html',
		controller :'getAllCouponsByDateCtrl as h'
	})
	
	
	
}])