define(['angular', 'text!five/system/system.html'], function (angular, tpl) {
    //angular会自动根据controller函数的参数名，导入相应的服务
    return {
        controller: function ($rootScope,$scope,$location, $routeParams, $http, $interval) {

            if(!$rootScope.username){
                $location.path("/login")
            }


            $scope.formTitle=""
            $scope.reset = function() {

                $http({
                    method: 'GET',
                    headers:{'Content-Type': 'application/x-www-form-urlencoded'},
                    url: baseUrl+ '/ghprint-cms/logout.do?userAccount='+$scope.username
                }).then(function successCallback(response) {
                    console.log(response);
                    if(response.data.success){
                        $location.path("/Login")
                    }else{
                        console.log("注销失败")
                        $location.path("/Login")
                    }


                }, function errorCallback(response) {
                    console.log(response);
                    $location.path("/Login")
                });


            }

            //请求地址	http://localhost:8080/ghprint-cms/userinfo/deleteuserinfo.do
            $scope.deleUser= function(index) {
                $scope.tipsState = false;
                var arr = $scope.nameDatas[index]
                console.log(arr);
                $scope.deleindex = "";
                $http({
                    method: 'GET',
                    url: baseUrl+ "/ghprint-cms/userinfo/deleteuserinfo.do?userid="+arr.id,
                }).then(function successCallback(data) {
                    console.log(data);
                    $scope.formTitle="删除用户"
                    if(data.data.success){

                        $scope.controlUsertips="操作成功"

                    }else{
                        $scope.controlUsertips="操作失败"
                    }
                    $scope.windowState=true
                    searchUserList(1);
                }, function errorCallback(response) {
                    console.log(response);
                    $scope.formTitle="删除用户"
                    $scope.controlUsertips="操作失败，请检重新登录"
                    $scope.windowState=true
                });
            }


            $scope.modifyUserBox = function(index) {
                $scope.EdiUser=true;
                var arr= index;
                console.log(arr+"=============");
                $scope.modifyUserContent =angular.copy($scope.modifyUserContent=angular.copy(arr));


                //$scope.modifyUserContent=arr;

                console.log(arr.tSysUser.id+"==================$scope.modifyUserContent")
                console.log(arr.tSysUser.userid+"==================$scope.modifyUserContent")
                console.log(arr.tSysUser.username+"==================$scope.modifyUserContent")
                console.log(arr.tSysUser.email+"==================$scope.modifyUserContent")
                console.log(arr.tSysUser.phone+"==================$scope.modifyUserContent")
                console.log(arr.tSysUser.password+"==================$scope.modifyUserContent")
                console.log(arr.tSysUser.createtime+"==================$scope.modifyUserContent")

            }
            //修改用户信息
            $scope.modifyUser=false;
            $scope.modifyUserList = function(index) {
                var arr = $scope.modifyUserContent.tSysUser;
                if(arr.username||
                        arr.phone||
                    arr.userid||
                    arr.selected||
                    arr.email
                    ){
                    console.log("输入参数不齐");
                }else{
                $http({
                    method:'post',
                    url:baseUrl+ "/ghprint-cms/userinfo/updateuserinfo.do",
                    data: {
                        id:arr.id,
                        userid:arr.userid,
                        username:arr.username,
                        email:arr.email,
                        phone:arr.phone,
                        password: arr.password,
                        uid:arr.selected},
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

                        $scope.controlUsertips="操作成功"

                    }else{
                        $scope.controlUsertips="操作失败，请检查资料是否正确"
                    }
                    searchUserList(1);
                    $scope.formTitle="修改用户"
                    $scope.modifyUser=false
                    $scope.windowState=true

                }), function errorCallback(response) {
                    console.log(response);
                    $scope.formTitle="修改用户"
                    $scope.controlUsertips="操作失败，请检重新登录"
                    $scope.windowState=true
                }}
            }


            $scope.pagesearch = function(index){
                console.log(index+"当前页是第几页")
                searchUserList(index);
            }

            //分页变量
            //配置
            $scope.totalCount = 0;
            $scope.p_pernum = 10;
            //变量
            $scope.p_current = 1;
            $scope.p_all_page =0;
            function searchUserList(page) {
                $http({
                    method: 'GET',
                    url: baseUrl+ "/ghprint-cms/ userinfo/queryuserlist.do?page="+page+"&rows=3"
                }).then(function successCallback(response) {
                    console.log( response);

                    if(response.data.success){
                        $scope.nameDatas = response.data.rows;
                        //将此处的数据赋值到上面的分页变量
                        $scope.p_all_page = response.data.totalPage;
                        $scope.p_current = response.data.currentPage;
                        $scope.totalCount = response.data.totalCount;

                        console.log( $scope.p_all_page+"共几多页")
                        console.log( $scope.p_current+"当前页是第几页")
                        console.log( $scope.totalCount+"当前页是第几页")
                        //reloadPno();


                        //$scope.pages =
                    }else{
                        //查询用户列表列表失败
                        $scope.DataemptyState = true;

                    }


                }, function errorCallback(response) {
                    console.log(response);
                });
            }
            searchUserList(1);

            function callonUserList() {
                $http({
                    method: 'GET',
                    url: baseUrl+ "/ghprint-cms/userinfo/addpreuserinfo.do"
                }).then(function successCallback(response) {
                    console.log( response.data.result);

                    if(response.data.success){
                        //将数据取出：1
                        $scope.selectOption = response.data.result;
                        console.log($scope.selectOption)

                    }else{
                        //查询角色列表失败
                        console.log("查询角色失败，请联系管理员！")
                    }


                }, function errorCallback(response) {
                    console.log(response);
                });
            }
            callonUserList();




            $scope.deleUserBox=function(index){
                $scope.deleindex = index;
                $scope.tipsState=true;
                $scope.tipsTitle = "删除提示"
                $scope.tipsContent = "确定删除此用户？";

            }
            $scope.commitUser=function(){
                //新增用户
                console.log($scope.userid +"$scope.userid");
                console.log($scope.newUsername +"$scope.newUsername");
                console.log($scope.email +"$scope.email");
                console.log($scope.selected +"$scope.selected");
                console.log($scope.phone +"$scope.phone");
                if($scope.userid||
                        $scope.newUsername||
                        $scope.email||
                        $scope.phone||
                        $scope.selected){
                    $scope.newOrder=false
                    console.log($scope.selected+"==============seleted  ")

                    $http({
                        method:'post',
                        url:baseUrl+ "/ghprint-cms/userinfo/adduserinfo.do",
                        data: {
                            userid:$scope.userid,
                            username:$scope.newUsername,
                            email:$scope.email,
                            phone:$scope.phone,
                            password: $scope.password,
                            uid:$scope.selected},
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
                            $scope.controlUsertips="操作成功"
                        }else{
                            $scope.controlUsertips="操作失败"
                        }
                        $scope.formTitle="新增用户"

                        $scope.windowState=true
                        searchUserList(1);
                    }), function errorCallback(response) {
                        console.log(response);
                        $scope.formTitle="新增用户"
                        $scope.controlUsertips="操作失败，请检重新登录"
                        $scope.windowState=true
                    }
                 }else{
                    console.log("输入参数不齐");
}

            }


            $scope.count=3;
            $scope.username=$rootScope.username;

            $scope.EdiUser=false;
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


            //首页
            $scope.p_index = function(){
                searchUserList(1);
            }

            //尾页
            $scope.p_last = function(){
                searchUserList($scope.p_all_page);
            }

            //加载某一页
            $scope.backPage = function(){
                var currPage = $scope.p_current
                currPage--
                if(currPage==0){
                    currPage =1;
                }
                searchUserList(currPage);
            };

            $scope.nextPage = function(){
                var currPage = $scope.p_current
                currPage++
                if(currPage>=$scope.p_all_page){
                    currPage =$scope.p_all_page;
                }
                searchUserList(currPage);
            };

            //初始化页码
            var reloadPno = function(){
                $scope.pages=calculateIndexes($scope.p_current,$scope.p_all_page,8);
            };

            //分页算法
            var calculateIndexes = function (current, length, displayLength) {
                var indexes = [];
                var start = Math.round(current - displayLength / 2);
                var end = Math.round(current + displayLength / 2);
                if (start <= 1) {
                    start = 1;
                    end = start + displayLength - 1;
                    if (end >= length - 1) {
                        end = length - 1;
                    }
                }
                if (end >= length - 1) {
                    end = length;
                    start = end - displayLength + 1;
                    if (start <= 1) {
                        start = 1;
                    }
                }

                for (var i = start; i <= end; i++) {
                    indexes.push(i);
                    console.log("==========indexes"+indexes);
                }

                return indexes;
        };


    },
        tpl: tpl
    };
});