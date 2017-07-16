var module = angular.module("customerSPA");
module.controller("getAllCouponsCtrl", getAllCouponsCtrlCtor);

function getAllCouponsCtrlCtor($http, customerHttpService){
	
	var self = this;

	customerHttpService.getAllCoupons($http).then(function(response){
		
		console.log(response.data);
		self.arr = response.data;
			},
			function(response)
			{
				self.resault = response.data;

			});
	
	self.reverseSort = false;
	self.sortColumn = "Title";
	
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