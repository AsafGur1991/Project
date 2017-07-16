var module = angular.module("customerSPA");
module.controller("getAllPurchsedCouponsCtrl", getAllPurchsedCouponsCtrlCtor);

function getAllPurchsedCouponsCtrlCtor($http, customerHttpService){
	
	var self = this;

	customerHttpService.getAllPurchasedCoupons($http).then(function(response){
		
		console.log(response.data);
		self.arr = response.data;
			},
			function(response)
			{
				self.resault = response.data;

			});

}