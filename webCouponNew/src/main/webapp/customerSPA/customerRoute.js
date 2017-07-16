/**
 * 
 */ 

var app = angular.module("customerSPA", ["ui.router","ngCookies"]) 
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
	.state('getCoupon',{
		templateUrl: 'getCoupon.html',
		controller :'getCouponCtrl as a'
	})
	.state('getAllCoupons',{
		templateUrl: 'getAllCoupons.html',
		controller :'getAllCouponsCtrl as b'
	})
	.state('purchaseCoupon',{
		templateUrl: 'purchaseCoupon.html',
		controller :'purchaseCouponCtrl as c'
	})
	.state('getAllPurchasedCoupons',{
		templateUrl: 'getAllPurchasedCoupons.html',
		controller :'getAllPurchsedCouponsCtrl as d'
	})
	.state('getAllPurchasedCouponsByType',{
		templateUrl: 'getAllPurchasedCouponsByType.html',
		controller :'getAllPurchasedCouponsByTypeCtrl as e'
	})
	.state('getAllPurchasedCouponsByPrice',{
		templateUrl: 'getAllPurchasedCouponsByPrice.html',
		controller :'getAllCouponsByPriceCtrl as f'
	})
		
	
}])