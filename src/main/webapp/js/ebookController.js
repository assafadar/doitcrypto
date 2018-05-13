cryptoApp.controller('ebookController', function($scope, $http){
    console.log('Ebook download');

    $scope.subscribe = function(){
        var subscribeDataJSON = JSON.stringify($scope.subscribeData);
        debugger;
        $http({
            method: 'POST',
            url: './leads/subscribe',
            data: subscribeDataJSON,
            headers: { 'Content-Type': 'application/json' } 
        }).success(function(data){
            alert(
                'Download will start automatically'
            );
        }).error(function (data){
            console.log(data);
            alert('Bad requeset please try again');
        })
    }
});
