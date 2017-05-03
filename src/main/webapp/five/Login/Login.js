define(['angular', 'text!five/Login/Login.html'], function (angular, tpl) {
    //angular会自动根据controller函数的参数名，导入相应的服务
    return {
        controller: function ($rootScope,$scope,$location, $routeParams, $http, $interval) {

            $scope.errorCall=false;

            //$scope.formData:{$scope.login_phone:""}
            //登录
            $scope.login=function(){
                //手机号码判断
                if(!$scope.login_phone){
                    alert('请输入联系人电话号码');
                    return false;
                }
                if(!$scope.login_pw){
                    alert('请输入登录密码');
                    return false;
                }


                $http({
                    method:'post',
                    url:'http://localhost:8080/ghprint-cms/login.do',
                    data:{userAccount:$scope.login_phone,userPassword:$scope.login_pw},
                    headers:{'Content-Type': 'application/x-www-form-urlencoded'},
                    transformRequest: function(obj) {
                        var str = [];
                        for(var p in obj){
                            str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                        }
                        return str.join("&");
                    }
                }).then(function successCallback(req) {
                    console.log(req);
                    if(req.data.success){
                        console.log(req.data.result.username);
                        $rootScope.username = req.data.result.username
                        $location.path("/Order")
                    }else{
                        $scope.errorCall=true;
                        $scope.errorMSG=req.data.errorMsg;
                    }
                }), function errorCallback(response) {
                    console.log(response);
                    $location.path("/Login")
                }


            };

        },
        tpl: tpl
    };
});