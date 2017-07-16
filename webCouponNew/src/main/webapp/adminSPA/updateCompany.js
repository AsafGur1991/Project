var module = angular.module("AdminSPA");
module.controller("updateCompanyCrtl", updateCompanyCtrlCtor);

function updateCompanyCtrlCtor($http,adminHttpService)
{
	var self = this;
	
	var company = function(id, compName, password, email){
		this.id = id;
		this.compName = compName;
		this.password = password;
		this.email = email;
		
	};
	
	self.newCompany = new company();
	
	self.updateCompany = function(){
				
		adminHttpService.updateCompany($http,self.newCompany).then(function(response)
        		{
        	var answer = "company "+ self.newCompany.compName + " has been updated";
        	self.resault = answer;
        	
        		}, 
        		function(response)
        		{
        			self.resault = response.data;
        			
        		});
	};
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*var self = this;
	
	var company = function(compId, compName, password, email){
		this.id = compId;
		this.compName = compName;
		this.password = password;
		this.email = email;
		
	};
	
	self.newCompany = new company();
	
	self.updateCompany = function()
	 {	 
		console.log(self.newCompany);
		
		/* adminHttpService.updateCompany($http,self.newCompany).then(function(response)
	        		{
	        	var answer = "company "+ self.newCompany.compName + " has been updated";
	        	self.resault = answer;
	        	
	        		}, 
	        		function(response)
	        		{
	        			self.resault = response.data;
	        			
	        		});
	 };
	
}*/