var module = angular.module("AdminSPA");
module.controller("removeCompanyCrtl", removeCompanyCtrlCtor);

function removeCompanyCtrlCtor($scope, $http,adminHttpService)
{
	var self = this;
	
	var company = function(id, compName, password, email){
		this.id = id;
		this.compName = compName;
		this.password = password;
		this.email = email;
		
	};
	
	self.newCompany = new company();
	
	 self.removeCompany = function()
	 {		 
		 adminHttpService.removeCompany($http,this.newCompany).then(function(response)
	        		{
	        	var answer = "company "+ self.newCompany.compName + " was removed from the database";
	        	self.resault = answer;
	        	
	        		}, 
	        		function(response)
	        		{
	        			self.resault = response.data;
	        			
	        		});
		 
	 };

}
