var module = angular.module("customerSPA");
module.controller("getCouponCtrl", getCouponCtrlCtor);

function getCouponCtrlCtor($http, customerHttpService){
	
	var self = this;
	self.id = "";
	
	self.getCoupon = function()
	 {
		 console.log(self.id);
		 
		 customerHttpService.getCoupon($http,self.id).then(function(response)
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