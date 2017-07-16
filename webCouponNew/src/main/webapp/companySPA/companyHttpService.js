(function()	{
	var app = angular.module("companySPA");
	app.service("companyHttpService", companyHttpService);
	
	function companyHttpService($http)
	{
		var self = this;
		
		self.createCoupon = function($http, coupon)
		{
			var promise =  $http.post("http://localhost:8080/webCouponNew/webapi/company/create/coupon", coupon);
			return promise;
		}
		
		self.getCoupon = function($http, id)
		{
			var promise =  $http.get("http://localhost:8080/webCouponNew/webapi/company/get/coupon/" + id);
			return promise;
		}
		
		self.removeCoupon = function($http, coupon)
		{
			var promise =  $http.post("http://localhost:8080/webCouponNew/webapi/company/remove/coupon", coupon);
			return promise;
		}
		
		self.updateCoupon = function($http, coupon)
		{
			var promise =  $http.post("http://localhost:8080/webCouponNew/webapi/company/update/coupon", coupon);
			return promise;
		}
		
		self.getAllCoupons = function($http)
		{
			var promise =  $http.get("http://localhost:8080/webCouponNew/webapi/company/get/all/coupons" );
			return promise;
		}
		
		self.getAllCouponsByType = function($http, couponType)
		{
			var promise =  $http.get("http://localhost:8080/webCouponNew/webapi/company/get/all/coupons/type/" + couponType);
			return promise;
		}
		
		self.getAllCouponsByPrice = function($http, price)
		{
			var promise =  $http.get("http://localhost:8080/webCouponNew/webapi/company/get/all/coupons/price/" + price);
			return promise;
		}
		
		self.getAllCouponsByDate = function($http, date)
		{
			var promise =  $http.post("http://localhost:8080/webCouponNew/webapi/company/get/all/coupons/date", date);
			return promise;
		}
		
		
		
		
		
		
		
	}

		})();
  