var module = angular.module("companySPA");
module.controller("getAllCouponsByDateCtrl", getAllCouponsByDateCtrlCtor);

function getAllCouponsByDateCtrlCtor($http, companyHttpService){
	
	var self = this;
	var dateHolder = function(date){
		this.date = date;
	};
	
	self.newDate = new dateHolder;
	
	
	self.getCouponsByDate = function(){
		
		console.log(self.newDate);
		
		companyHttpService.getAllCouponsByDate($http,self.newDate).then(function(response)
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