var module = angular.module("AdminSPA");
module.controller("createCustomerCrtl", createCustomerCrtlCtor);

function createCustomerCrtlCtor($http,adminHttpService)
{
	var self = this;
	
	var customer = function(custName, password){
		this.custName = custName;
		this.password = password;
		
	};
	
	var newCustomer = new customer();
    

    self.createCustomer = function()
    {    	
        adminHttpService.createCustomer($http,self.newCustomer).then(function(response)
        		{
        	var answer = "customer "+ self.newCustomer.custName + " was added to the database";
        	self.resault = answer;
        	
        		}, 
        		function(response)
        		{
        			self.resault = response.data;
        			
        		});
       
        

    };


}