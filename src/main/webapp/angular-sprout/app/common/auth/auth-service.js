Application.Services.service('auth', function (session, $q, AUTH_EVENTS) {

    this.login = function(credentials, $scope){
        var deferred = $q.defer();

        var request = gapi.client.booking.calendar.authUserSession({
            username: credentials.username,
            password: credentials.password
        });

        request.execute(function (resp) {
            $scope.$apply(function() {
                if (resp && resp.user) {
                    session.create(resp.user.id, resp.user.userType.type);
                    deferred.resolve(resp);
                } else {
                    deferred.reject('error');
                }
            });
        });
        return deferred.promise;
    };

    this.isAuthenticated = function () {
        return !!session.userId;
    };

    this.isAuthorized = function (authorizedRoles) {
        if (!angular.isArray(authorizedRoles)) {
            authorizedRoles = [authorizedRoles];
        }
        return (this.isAuthenticated() && authorizedRoles.indexOf(session.userRole) !== -1);
    };

 })
.service('session', function () {
    this.create = function (userId, userRole) {
        console.log('creating session');
        console.log(userId);
        console.log(userRole);
        this.userId = userId;
        this.userRole = userRole;
    };
    this.destroy = function () {
        this.userId = null;
        this.userRole = null;
    };
    return this;
});