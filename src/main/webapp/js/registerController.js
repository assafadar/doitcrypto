cryptoApp.controller('registerController', function($scope, $http, $location,$cookieStore){
    $scope.registerData={};

    $scope.register= function(){
        if(validateFormData($scope.registerData)){
            var registerDataJSON = JSON.stringify($scope.registerData);
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
        else{
            alert('Data Is Not Valid Please Try again.');
        }
    }
    function validateFormData(data){
        if(isNaN(data.phone)){
            return false;
        }
        else {
            return true;
        }
    }
    
});