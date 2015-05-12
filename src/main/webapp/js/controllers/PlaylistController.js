app.controller('PlaylistController', ['$scope','$sce', 'PlaylistFactory','$routeParams', function($scope,$sce, PlaylistFactory,$routeParams) {

    var playlist = PlaylistFactory($routeParams.id);
    playlist.list(function(value){
        $scope.playlist = $sce.trustAsHtml( value.key);
    });

    parts = $routeParams.id.split("-");
    mp3String = "elektro_beats_"+parts[2]+parts[1]+parts[0]+".mp3";

    mp3Url="http://http-stream.rbb-online.de/rad/musik/elektro_beats/"+mp3String;

    $scope.audioUrl = $sce.trustAsResourceUrl(mp3Url);

    $scope.date=$routeParams.id;
}]);


