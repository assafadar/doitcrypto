cryptoApp.controller('registerController', function($scope, $http, $location,$cookieStore){
    $scope.registerData={};

    $scope.register= function(){
        var registerDataJSON = JSON.stringify($scope.registerData);
        debugger;
        $http({
            method: 'POST',
            url: './leads/',
            data: registerDataJSON,
            headers: { 'Content-Type': 'application/json' }
        }).success(function(data){
            $location.path('/otp');
        }).error(function (data){
            console.log(data);
        	alert('Please check details and try again');
        })
    }
});