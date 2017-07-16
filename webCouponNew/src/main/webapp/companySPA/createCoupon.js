var module = angular.module("companySPA");
module.controller("createCouponCtrl", createCouponCtrlCtor);

function createCouponCtrlCtor($http, companyHttpService, $window)
{
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
	
	var coupon = function(id, title, startDate, endDate, amount, coupontype, message, price, image){
		this.id = id;
		this.title = title;
	    this.startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.coupontype = coupontype;
		this.message = message;
		this.price = price;
		this.image = image;
		
	};
	
	
	
	self.newCoupon = new coupon();
	
    self.createCoupon = function()
    {
    	self.newCoupon.image = $window.pic;
    	console.log(self.newCoupon);
    	
    	companyHttpService.createCoupon($http, self.newCoupon).then(function(response)
        		{
        	var answer = "coupon "+ self.newCoupon.title + " was added to the database";
        	self.resault = answer;
        	
        		}, 
        		function(response)
        		{
        			self.resault = response.data;
        			
        		});
    };
    
}
       
        







