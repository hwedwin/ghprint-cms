define(['angular', 'text!five/system/system.html'], function (angular, tpl) {
    //angular会自动根据controller函数的参数名，导入相应的服务
    return {
        controller: function ($rootScope,$scope,$location, $routeParams, $http, $interval) {
            $scope.selectOption = ["管理员", "仓库", "普通"];

            $scope.nameDatas = [{"account":"001","name":"李锦记","phone":"13555555555","role":"管理员"},

                {"account":"002","name":"李锦记","phone":"13555555551","role":"仓库"},

                {"account":"003","name":"可口可乐","phone":"13555555552","role":"普通人员"}

            ]


            $scope.count=3;
            $scope.username="张三";
            $scope.qualityFormShow=false;
            $scope.newOrder=false;

            $scope.app = function(index) {
                console.log("你点击了"+index)
            };

            $scope.searchPage = function(index) {
                console.log("你点击了第"+index+"页")
            };

            $scope.takequalityFormShow = function(a) {
                $scope.qualityFormShow=!$scope.qualityFormShow;
            };


            $scope.jump = function(a) {
                $location.path("/"+a)
            };

        },
        tpl: tpl
    };
});