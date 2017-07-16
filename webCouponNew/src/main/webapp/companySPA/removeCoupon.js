var module = angular.module("companySPA");
module.controller("removeCouponCtrl", removeCouponCtrlCtor);

function removeCouponCtrlCtor($http, companyHttpService){
	
	var self = this;
	self.id = "";
	
	self.removeCoupon = function(){
		
		companyHttpService.getCoupon($http,self.id).then(function(response)
        		{
        	
        	var coupon = response.data;
        	companyHttpService.removeCoupon($http,coupon).then(function(response)
	        		{
	        	
        		var answer = "coupon "+ coupon.title + " was removed from the database";
	        	self.resault = answer;
	        	
	        		}, 
	        		function(response)
	        		{
	        			self.resault = response.data;
	        			
	        		});
        	
        		}, 
        		function(response)
        		{
        			self.resault = response.data;
        			
        		});

	};
}