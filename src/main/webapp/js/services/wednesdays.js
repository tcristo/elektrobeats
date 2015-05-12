/**
 * Created by cristo on 11.05.2015.
 */
app.factory('WednesdayFactory',[
    '$http',
    /** This is the factory method that Angular will execute only ONCE **/
        function WednesdayFactory($http) {
        /** This is the function that will be injected into the directive, and called multiple times by the programmer **/
        return function(year) {
            /** this is the new object that will be created and used by the programmer **/
            return new Wednesday($http, year);
        };
    }]);


function Wednesday($http, year) {

    /** The public method for getting the project price **/
    this.days = function(callback) {
        $http.get('api/wednesdays?year='+year)
            .success(function(value) {
                callback(value);
            });
    };

};