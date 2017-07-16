var module = angular.module("customerSPA");
module.controller("purchaseCouponCtrl", purchaseCouponCtrlCtor);

function purchaseCouponCtrlCtor($http, customerHttpService){
	
	var self = this;
	
	self.id = "";
	
	self.purchaseCoupon = function(){
		
		console.log(self.id);
		customerHttpService.getCoupon($http, self.id).then(function(response){
			
			var coupon = response.data;
			console.log(coupon);
			customerHttpService.purchaseCoupon($http, coupon).then(function(response){
				
				self.resault = response.data;
			},
			function(response){
				self.resault = response.data;
			});
			
		},
		function(response){
			
			self.resault = response.data;
		
		});
		
		
		
	};
}
	