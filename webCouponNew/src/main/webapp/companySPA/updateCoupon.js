var module = angular.module("companySPA");
module.controller("updateCouponCtrl", updateCouponCtrlCtor);

function updateCouponCtrlCtor($http, companyHttpService){
	
	var self = this;
	
	var coupon = function(id, title, endDate, price)
	{
		this.id = id;
		this.title = title;
		this.endDate = endDate;
		this.price = price;
	};
	
	self.newCoupon = new coupon();
	
	self.updateCoupon = function(){
	companyHttpService.updateCoupon($http,self.newCoupon).then(function(response)
    		{
    	var answer = "coupon "+ self.newCoupon.title + " has been updated";
    	self.resault = answer;
    	
    		}, 
    		function(response)
    		{
    			self.resault = response.data;
    			
    		});

	};
}