(function()	{
	var app = angular.module("customerSPA");
	app.service("customerHttpService", customerHttpService);
	
	function customerHttpService($http)
	{
		var self = this;
		
		self.getCoupon = function($http, id)
		{
			var promise =  $http.get("http://localhost:8080/webCouponNew/webapi/customer/get/coupon/" + id);
			return promise;
		}
		
		self.getAllCoupons = function($http)
		{
			var promise =  $http.get("http://localhost:8080/webCouponNew/webapi/customer/get/all/coupons" );
			return promise;
		}
		
		self.purchaseCoupon = function($http, coupon)
		{
			var promise =  $http.post("http://localhost:8080/webCouponNew/webapi/customer/purchase/coupon", coupon);
			return promise;
		}
		
		self.getAllPurchasedCoupons = function($http)
		{
			var promise =  $http.get("http://localhost:8080/webCouponNew/webapi/customer/get/all/purchased/coupons" );
			return promise;
		}
		
		self.getAllCouponsByType = function($http, couponType)
		{
			var promise =  $http.get("http://localhost:8080/webCouponNew/webapi/customer/get/all/purchased/coupons/type/" + couponType );
			return promise;
		}
		
		self.getAllCouponsByPrice = function($http, price)
		{
			var promise =  $http.get("http://localhost:8080/webCouponNew/webapi/customer/get/all/purchased/coupons/price/" + price );
			return promise;
		}
		
			
		
		
		
	}

		})();
  