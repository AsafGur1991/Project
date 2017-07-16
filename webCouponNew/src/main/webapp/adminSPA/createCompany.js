var module = angular.module("AdminSPA");
module.controller("createCompanyCtrl", createCompanyCtrlCtor);

function createCompanyCtrlCtor($http, adminHttpService)
{
	var self = this;
	
	var company = function(compName, password, email){
		this.compName = compName;
		this.password = password;
		this.email = email;
		
	};
	
	self.newCompany = new company();
    
    self.createCompany = function()
    {        
    	adminHttpService.createCompany($http, self.newCompany).then(function(response)
        		{
        	var answer = "company "+ self.newCompany.compName + " was added to the database";
        	self.resault = answer;
        	
        		}, 
        		function(response)
        		{
        			console.log(response);
        			self.resault = response.data;
        			
        		});
    };
    
}
       
        







