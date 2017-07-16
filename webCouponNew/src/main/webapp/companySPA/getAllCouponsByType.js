var module = angular.module("companySPA");
module.controller("getAllCouponsByTypeCtrl", getAllCouponsByTypeCtrlCtro);

function getAllCouponsByTypeCtrlCtro($http, companyHttpService){
	
	var self = this;
	
	self.types = [
		{typeValue : "resturants", typeName : "resturants"},
		{typeValue : "electricity", typeName : "electricity"},
		{typeValue : "food", typeName : "food"},
		{typeValue : "health", typeName : "health"},
		{typeValue : "sports", typeName : "sports"},
		{typeValue : "camping", typeName : "camping"},
		{typeValue : "travelling", typeName : "travelling"}
		
	];
	
	self.couponType = "";
	self.getCouponsByType = function(){
		
		companyHttpService.getAllCouponsByType($http, self.couponType).then(function(response)
        		{
			
        	self.arr = response.data;
        	
        		}, 
        		function(response)
        		{
        			self.resault = response.data;
        			
        		});
		
	};
	
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