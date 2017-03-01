/**
 * Created by kenkozheng on 2015/7/10.
 * 更适合团队配合的配置版router
 * 彻底解耦，按需加载，router的配置可以放到服务器直出，更便于团队合作
 */
define(['angular', 'require', 'app', 'flexible', 'angular-route'], function (angular, require, app) {

            app.config(['$routeProvider', '$controllerProvider',
                function($routeProvider, $controllerProvider) {

                    var routeMap = {       //在主页引入
                        '/login': {
                            path: 'five/Login/login.js',
                            controller: 'LoginController'
                        },
                        '/Home': {
                            path: 'five/Home/Home.js',
                            controller: 'HomeController'
                        },
                            '/warehouse': {
                                path: 'five/warehouse/warehouse.js',
                                controller: 'WarehouseController'
                            },
                            '/qualityForm': {
                                path: 'five/qualityForm/qualityForm.js',
                                controller: 'HomeController'
                            },
                            '/system': {
                                path: 'five/system/system.js',
                                controller: 'SystemController'
                            }
                    };
            var defaultRoute = '/login';              //默认跳转到某个路由

            $routeProvider.otherwise({redirectTo: defaultRoute});
            for (var key in routeMap) {
                $routeProvider.when(key, {
                    template: '',
                    controller: routeMap[key].controller,
                    resolve:{
                        keyName: requireModule(routeMap[key].path, routeMap[key].controller)
                    }
                });
            }

            function requireModule(path, controller) {
                return function ($route, $q) {
                    var deferred = $q.defer();
                    require([path], function (ret) {
                        $controllerProvider.register(controller, ret.controller);
                        $route.current.template = ret.tpl;
                        deferred.resolve();
                    });
                    return deferred.promise;
                }
            }

        }]);

    return app;
});