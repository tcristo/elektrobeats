app.factory('PlaylistFactory',[
    '$http',
    /** This is the factory method that Angular will execute only ONCE **/
        function PlaylistFactory($http) {
        /** This is the function that will be injected into the directive, and called multiple times by the programmer **/
        return function(date) {
            /** this is the new object that will be created and used by the programmer **/
            return new Playlist($http, date);
        };
    }]);


function Playlist($http, date) {

    /** The public method for getting the project price **/
    this.list = function(callback) {
        $http.get('api/playlist?date='+date)
            .success(function(value) {
                callback(value);
            });
    };

};