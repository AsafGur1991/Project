var module = angular.module("companySPA");
module.controller("getCouponCtrl", getCouponCtrlCtor);

function getCouponCtrlCtor($http, companyHttpService){
	
	var self = this;
	self.id = "";
	
	self.getCoupon = function()
	 {
		 console.log(self.id);
		 
		 companyHttpService.getCoupon($http,self.id).then(function(response)
	        		{
	        	console.log(response.data);
	        	self.arr = response.data;
	        	
	        		}, 
	        		function(response)
	        		{
	        			self.resault = response.data;
	        			
	        		});
		 
	 };
}