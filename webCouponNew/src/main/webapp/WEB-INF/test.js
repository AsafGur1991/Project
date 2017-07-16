var module = angular.module("customerSPA");
module.controller("headerCtrl", headerCtrlCtor);

function headerCtrlCtor($cookies, $window, $http){
	this.user = $cookies.get("userName");
	
	this.logout = function(){
		alert("goodbye");
		 $http.get("http://localhost:8080/webCouponNew/logoutServlet").then(function(response){
			 console.log(response);
			 $window.location.href = "http://localhost:8080/webCouponNew/login.html"
		 },
		 function(response){
			 
		 });
		
	};
	
}