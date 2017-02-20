define(['angular', 'text!five/Login/Login.html'], function (angular, tpl) {
    //angular会自动根据controller函数的参数名，导入相应的服务
    return {
        controller: function ($rootScope,$scope,$location, $routeParams, $http, $interval) {

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

                var reslut = {
                    "success": true,
                    "result": "TSysUser{id=1, userid='zhangsan', username='张三', email='zhangsan@126.com', phone='13800138000', password='null', createtime=Sat Jan 07 00:00:00 CST 2017}",
                    "errorCode": "000000",
                    "errorMsg": "操作成功"
                }

                if(reslut.success){
                    $location.path("/Home")
                }

            };

        },
        tpl: tpl
    };
});