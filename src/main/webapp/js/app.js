var app = angular.module("PlaylistApp", ['ngRoute']);

app.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
}
]);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            controller: "HomeController",
            templateUrl: "views/home.html"
        })
        .when('/year/:id', {
            controller: 'WednesdayController',
            templateUrl: 'views/year.html'
        })
        .when('/playlist/:id', {
            controller: 'PlaylistController',
            templateUrl: 'views/playlist.html'
        })
        .otherwise({
            redirectTo: '/'
        });
});
