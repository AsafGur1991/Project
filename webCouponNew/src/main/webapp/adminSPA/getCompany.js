var module = angular.module("AdminSPA");
module.controller("getCompanyCrtl", getCompanyCtrlCtor);

function getCompanyCtrlCtor($http,adminHttpService)
{
	var self = this;
	
	self.id = "";
	
	 self.getCompany = function()
	 {		 		 
		 adminHttpService.getCompany($http,self.id).then(
				 function(response)
	        		{
	        	
	        	self.arr = response.data;
	        	
	        		}, 
	        		function(response)
	        		{
	        			self.resault = response.data;
	        			
	        		});
		 
	 };

	
}
