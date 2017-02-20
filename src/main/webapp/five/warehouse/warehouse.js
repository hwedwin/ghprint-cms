define(['angular', 'text!five/warehouse/warehouse.html'], function (angular, tpl) {
    //angular会自动根据controller函数的参数名，导入相应的服务
    return {
        controller: function ($rootScope,$scope,$location, $routeParams, $http, $interval) {
            $scope.selectOption = ["全部","公司", "纸箱", "成品"];

            $scope.orderDatas = [{"num":"12200424","client":"李锦记","材质":"PVC",
                                   "companyNum":"001","orderTime":"2016-06-08","stock":"300","orderState":"进行中",
                                    "productName":"500ml金色热缩套","weight":"248*5.5","atom":"pvc","phone":"13444444444",
                                    "company":"亨氏食品有限公司"},

                {"num":"12200424","client":"李锦记","材质":"PVC",
                    "companyNum":"001","orderTime":"2016-06-08","stock":"300","orderState":"进行中",
                    "productName":"500ml金色热缩套","weight":"248*5.5","atom":"pvc","phone":"13444444444",
                    "company":"李锦记"},

                {"num":"12200424","client":"李锦记","材质":"PVC",
                    "companyNum":"001","orderTime":"2016-06-08","stock":"300","orderState":"进行中",
                    "productName":"500ml金色热缩套","weight":"248*5.5","atom":"pvc","phone":"13444444444",
                    "company":"海天酱油"}


            ]


            $scope.company=[{"num":"3300550939","productName":"150ml天成一味特鲜酱油-2014配料表","color":"自动",
                "boxNum":"1","boxCount":"20000","lastCount":"510米","single":"20",
                "money":"100000"}]

            $scope.Finish=true;
            $scope.companyForm=false;
            $scope.count=3;
            $scope.username="张三";
            $scope.qualityFormShow=false;
            $scope.newOrder=false;
            $scope.selectedName = "";
            $scope.box=false;


            $scope.search = function(index) {
                if( $scope.selectedName=="成品"){
                    $scope.box=false;
                    $scope.Finish=true;
                    $scope.companyForm=false;
                }else if( $scope.selectedName=="纸箱"){
                    $scope.Finish=false;
                    $scope.box=true;
                    $scope.companyForm=false;
                }
            };

            $scope.app = function(index) {
                console.log("你点击了"+index)
            };

            $scope.searchPage = function(index) {
                console.log("你点击了第"+index+"页")
            };

            $scope.takequalityFormShow = function(a) {
                $scope.qualityFormShow=!$scope.qualityFormShow;
            };


            $scope.edit = function(a) {
                console.log("你点击了第"+a+"===========")
            };

            $scope.dele = function(a) {
                console.log("你点击了第"+a+"===========")
            };


            $scope.jump = function(a) {
                $location.path("/"+a)
            };

        },
        tpl: tpl
    };
});