var cryptoApp = angular.module("cryptoApp", ["ngRoute","ngCookies"]);

cryptoApp.config(function($routeProvider){
    $routeProvider

    .when("/",{
        templateUrl: "templates/join-now.htm",
        controller: "registerController"
    })

    .when("/thank-you",{
        templateUrl:"templates/thank-you.htm"
    })

    .when("/magazines",{
        templateUrl:"templates/magazines.htm",
        controller:"ebookController"
    })

    .when("/otp",{
        templateUrl:"templates/otp.htm",
        controller:"otpController"
    })

    .when("/why-crypto",{
        templateUrl:"templates/why-crypto.htm"
    })
});