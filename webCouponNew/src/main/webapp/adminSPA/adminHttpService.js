(function()	{
	var app = angular.module("AdminSPA");
	app.service("adminHttpService", adminHttpService);
	
	function adminHttpService($http)
	{
		var self = this;
		
		self.createCompany = function($http, company)
		{
			var promise =  $http.post("http://localhost:8080/webCouponNew/webapi/admin/create/company", company);
			return promise;
		}
		
		self.removeCompany = function($http, company)
		{
			var promise =  $http.post("http://localhost:8080/webCouponNew/webapi/admin/remove/company", company);
			return promise;
		}
		
		self.updateCompany = function($http, company)
		{
			var promise =  $http.post("http://localhost:8080/webCouponNew/webapi/admin/update/company", company);
			return promise;
		}
		
		self.getCompany = function($http, compId)
		{
			var promise =  $http.get("http://localhost:8080/webCouponNew/webapi/admin/get/company/" + compId);
			return promise;
		}
		
		self.getAllCompany = function($http)
		{
			var promise =  $http.get("http://localhost:8080/webCouponNew/webapi/admin/get/all/company");
			return promise;
		}
		
		self.createCustomer = function($http, customer)
		{
			var promise =  $http.post("http://localhost:8080/webCouponNew/webapi/admin/create/customer", customer);
			return promise;
		}
		
		self.removeCustomer = function($http, customer)
		{
			var promise =  $http.post("http://localhost:8080/webCouponNew/webapi/admin/remove/customer", customer);
			return promise;
		}
		
		self.updateCustomer = function($http, customer)
		{
			var promise =  $http.post("http://localhost:8080/webCouponNew/webapi/admin/update/customer", customer);
			return promise;
		}
		
		self.getCustomer = function($http, custId)
		{
			var promise =  $http.get("http://localhost:8080/webCouponNew/webapi/admin/get/customer/" + custId);
			return promise;
		}
		
		self.getAllCustomer = function($http)
		{
			var promise =  $http.get("http://localhost:8080/webCouponNew/webapi/admin/get/all/customer");
			return promise;
		}
		
		self.logout = function($http)
		{
			$http.get("http://localhost:8080/webCouponNew/logoutServlet");
			
		}
		
		
		
		
		
	}

		})();
  
  