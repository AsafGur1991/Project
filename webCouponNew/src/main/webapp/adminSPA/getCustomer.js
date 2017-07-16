var module = angular.module("AdminSPA");
module.controller("getCustomerCrtl", getCustomerCtrlCtor);

function getCustomerCtrlCtor($http, adminHttpService)
{
	var self = this;
	self.id = "";
	
	 self.getCustomer = function()
	 {
		 console.log(self.id);
		 
		 adminHttpService.getCustomer($http,self.id).then(function(response)
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
