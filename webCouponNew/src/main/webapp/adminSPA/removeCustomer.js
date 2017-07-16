var module = angular.module("AdminSPA");
module.controller("removeCustomerCrtl", removeCustomerCtrlCtor);

function removeCustomerCtrlCtor($http,adminHttpService)
{
	var self = this;
	
	var customer = function(id, custName, password){
		this.id = id;
		this.custName = custName;
		this.password = password;
	};
	
	self.newCustomer = new customer();
	
	 self.removeCustomer = function()
	 {		 
		 adminHttpService.removeCustomer($http,self.newCustomer).then(function(response)
	        		{
	        	var answer = "customer "+ self.newCustomer.custName + " was removed from the database";
	        	self.resault = answer;
	        	
	        		}, 
	        		function(response)
	        		{
	        			self.resault = response.data;
	        			
	        		});
		 
	 };

}
