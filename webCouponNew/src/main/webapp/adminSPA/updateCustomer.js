var module = angular.module("AdminSPA");
module.controller("updateCustomerCrtl", updateCustomerCtrlCtor);

function updateCustomerCtrlCtor($http, adminHttpService)
{
	var self = this;
	
	var customer = function(id, custName, password){
		this.id = id;
		this.custName = custName;
		this.password = password;
	};
	
	self.newCustomer = new customer();
	
	self.updateCustomer = function()
	 {
		 console.log(self.newCustomer);
		 
		 adminHttpService.updateCustomer($http,self.newCustomer).then(function(response)
	        		{
	        	var answer = "customer "+ self.newCustomer.custName + " has been updated";
	        	self.resault = answer;
	        	
	        		}, 
	        		function(response)
	        		{
	        			self.resault = response.data;
	        			
	        		});
	 };
	
}