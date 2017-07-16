var module = angular.module("AdminSPA");
module.controller("getAllCompanyCrtl", getAllCompanyCtrlCtor);

function getAllCompanyCtrlCtor($http,adminHttpService)
{
	var self = this;

	adminHttpService.getAllCompany($http).then(function(response){
		
		self.arr = response.data;
			},
			function(response)
			{
				self.resault = response.data;

			});
	
	self.reverseSort = false;
	self.sortColumn = "Name";
	
	self.sortData = function(column){
		if (self.sortColumn == column){
			self.reverseSort = !self.reverseSort;
		}
		else {
			self.reverseSort = false;
		}
		
		self.sortColumn = column;
	};
	
	self.getSortClass = function(column){
		if (self.sortColumn == column){
			return self.reverseSort ? 'arrow-down' : 'arrow-up'
		}
		
		return '';
	};


}