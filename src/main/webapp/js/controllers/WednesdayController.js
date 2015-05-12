/**
 * Created by cristo on 11.05.2015.
 */
app.controller('WednesdayController', ['$scope', 'WednesdayFactory', '$routeParams', function($scope,WednesdayFactory,$routeParams) {
    var wednesday = WednesdayFactory($routeParams.id);
    wednesday.days(function(value){
        $scope.wednesdays = value;
    });
}]);