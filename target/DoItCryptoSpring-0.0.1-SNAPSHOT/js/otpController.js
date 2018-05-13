cryptoApp.controller('otpController', function($scope,$cookieStore,$location, $http){

    $scope.submitOTP = function(){
        var otpJSON = JSON.stringify($scope.otp);
        debugger;
        $http({
            method: 'POST',
            url: './leads/otp',
            data: otpJSON,
            headers: {'Content-Type' : 'application/json'}
        }).success(function(data){
            $location.path("/thank-you");
        }).error(function(data){
            alert('Please try again');
        })
    }
});