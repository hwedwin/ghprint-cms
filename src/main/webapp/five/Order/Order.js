define(['angular', 'text!five/Order/Order.html'], function (angular, tpl) {
    //angular会自动根据controller函数的参数名，导入相应的服务
    return {
        controller: function ($rootScope,$scope,$location, $routeParams, $http, $interval) {

            if(!$rootScope.username){
                $location.path("/login")
            }


            //function formatDate(now) {
            //    var year=now.getYear();
            //    var month=now.getMonth()+1;
            //    var date=now.getDate();
            //    var hour=now.getHours();
            //    var minute=now.getMinutes();
            //    var second=now.getSeconds();
            //    return "20"+year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
            //}
            //
            //var d=new Date(1230999938);


            //console.log($rootScope.pagePostion);
            $scope.selectOrderOption = ["全部","编号", "交货日期", "产品名称","材料规格"];
            //$scope.newOrder.orderdate = "2017-04-04"
            $scope.count=3;
            $scope.username=$rootScope.username ;
            $scope.EditOrderBox=false;
            $scope.qualityFormShow=false;
            $scope.newOrderBox=false;


            //修改订单
            $scope.editCommit =  function () {
                $scope.EdiOrder.companyid = $scope.EdiOrder.companyid.id
                $scope.EdiOrder.standardid = $scope.EdiOrder.standardid.id
                $scope.EdiOrder.result = $scope.EdiOrder.result.choice

                var data  = $scope.EdiOrder
                    var url = baseUrl+'/ghprint-cms/orders/updateorder.do';
                $http({
                    method: 'POST',
                    url: url,
                    data: data
                }).then(function successCallback(response) {
                    console.log(response);
                    if(response.data.success){
                        $scope.tipsState=true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "操作成功";

                    }else{
                        $scope.EditOrderBox=false
                        $scope.tipsState=true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "系统报错，请联系管理员";
                    }
                }, function errorCallback(response) {
                    $scope.EditOrderBox=false

                    console.log(response);
                    $scope.tipsState=true;
                    $scope.tipsTitle = "操作提示";
                    $scope.tipsContent = "系统报错，请联系管理员";
                });
                }
            //修改订单准备接口
           $scope.editReady =  function (arr) {
                console.log(arr)
                if(arr.orderid){
                    var url = baseUrl+'/ghprint-cms/orders/editorder.do?orderId='+arr.oid;
                    $http({
                        method: 'GET',
                        url: url
                    }).then(function successCallback(response) {
                        console.log("response=======readyOrder========");
                        console.log(response);
                        if(response.data.success){

                            $scope.EdiOrder = response.data.result
                            $scope.EditOrderBox = true;
                            console.log("$scope.EditOrder.deline============"+$scope.EdiOrder.deline)
                            $scope.EdiOrder.deline  = getLocalTime($scope.EdiOrder.deline)

                            //订单状态
                            var orderstate = $scope.EdiOrder.result
                            parseInt(orderstate)
                            console.log("orderstate============="+orderstate)
                            //把获取到的变量作为数组中的坐标
                            $scope.EdiOrder.result = $scope.orderStateSelect[orderstate-1]

                            //客户ID
                            var companyid = $scope.EdiOrder.companyid
                            parseInt(companyid)
                            console.log("companyid============="+companyid)
                            //把获取到的变量作为数组中的坐标
                            $scope.EdiOrder.companyid = $scope.companySelect[companyid-1]

                            var standard = $scope.EdiOrder.standardid
                            parseInt(standard)
                            $scope.EdiOrder.standardid = $scope.standardSelect[standard-1]
                            //console.log("selectPrint============="+ $scope.formDatasArr.productionStandard.printingmode)
                            //$scope.standardSelect =response.data.result.standard;

                        }else{

                            $scope.tipsState=true;
                            $scope.tipsTitle = "操作提示";
                            $scope.tipsContent = "系统报错，请重试";

                        }
                    }, function errorCallback(response) {
                        console.log(response);

                        $scope.tipsState=true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "系统报错，请联系管理员";
                    });
                }
            else{
                    $scope.tipsState=true;
                    $scope.tipsTitle = "操作提示";
                    $scope.tipsContent = "系统报错，请联系管理员";
                }
            }


            /*订单初始化数据*/
            beginOrder();
            function beginOrder() {
                var url = baseUrl+'/ghprint-cms/orders/initorder.do?company=true&product=true&material=true&standard=true';
                $http({
                    method: 'GET',
                    url: url
                }).then(function successCallback(response) {
                    console.log("response===============");
                    console.log(response);
                    if(response.data.result.company ||response.data.result.product||response.data.result.material||response.data.result.standard){


                    $scope.companySelect = response.data.result.company;
                    $scope.productSelect =response.data.result.product;
                    $scope.materialSelect = response.data.result.material;
                    $scope.standardSelect =response.data.result.standard;
                    }else{
                        $scope.tipsState=true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "系统报错，请联系管理员";
                    }

                }, function errorCallback(response) {
                    console.log(response);

                    $scope.tipsState=true;
                    $scope.tipsTitle = "操作提示";
                    $scope.tipsContent = "系统报错，请联系管理员";
                });
            }

            /*根据id查询质量表*/
            $scope.searchForm  = function(index){
                console.log('index.standardid=================='+index.standardid)
                if(index.standardid){


                    $http({
                        method: 'GET',
                        url: baseUrl+ '/ghprint-cms/product/ PreUpdateproduct.do?pid='+index.standardid
                    }).then(function successCallback(response) {
                        console.log('response===========')
                        console.log(response)
                        $scope.formDatasArr = response.data.result;
                        $scope.showFormDetailBox = true;

                    /*选项默认值*/
                        //印刷方式
                        var selectPrint = $scope.formDatasArr.productionStandard.printingmode

                        parseInt(selectPrint)
                        console.log("selectPrint============="+selectPrint)
                        $scope.formDatasArr.productionStandard.printingmode = $scope.selectPrintOption[selectPrint-1]
                        console.log("selectPrint============="+ $scope.formDatasArr.productionStandard.printingmode)
                        //切片数量
                        var splitsum = $scope.formDatasArr.printingProcedureafter.splitsum
                        parseInt(splitsum)
                        console.log("splitsum============="+splitsum)
                        $scope.formDatasArr.printingProcedureafter.splitsum = $scope.splitsumOption[splitsum-1]
                        //成品型式
                        var readyProduct = $scope.formDatasArr.printingProcedureafter.productstyle
                        $scope.formDatasArr.printingProcedureafter.productstyle =$scope.selectProductStyleOption[readyProduct-1]

                        console.log("readyProduct====="+readyProduct);

                        //出卷方向
                        var direction =$scope.formDatasArr.printingProcedureafter.scrolldirection
                        parseInt(direction)
                        $scope.formDatasArr.printingProcedureafter.scrolldirection =$scope.selectDirectionOption[direction-1]


                        //包装
                        var pack = $scope.modifyContent.productionStandard.packaging
                        parseInt(pack)
                        console.log("packaing========="+pack)
                        $scope.formDatasArr.productionStandard.packaging =$scope.packageOption[pack-1]


                    }, function errorCallback(response) {
                        $scope.showFormDetailBox = false;

                        $scope.tipsState=true;
                        $scope.tipsTitle = "系统提示";
                        $scope.tipsContent = "系统出错，请重试";
                        console.log(response);
                    });
                }else{
                    $scope.tipsState=true;
                    $scope.tipsTitle = "系统提示";
                    $scope.tipsContent = "系统出错，请重试";
                    console.log(response);
                }

            }


            /*格式化时间*/
            function getLocalTime(nS) {
                return new Date(parseInt(nS) * 1000).toLocaleString().substr(0,17)
            }

            /*新增订单*/


            $scope.addOrderTest = function() {

            }
            $scope.addOrder = function() {
                    $scope.newOrderBox = false;
                $scope.newOrder.companyid =  $scope.newOrder.companyid.id;
                $scope.newOrder.productid = $scope.newOrder.productid.id;
                $scope.newOrder.stockid = $scope.newOrder.stockid.id;
                $scope.newOrder.standardid = $scope.newOrder.standardid.id
                $scope.newOrder.result = $scope.newOrder.result.choice

                console.log("$scope.newOrder.result========"+$scope.newOrder.result)

                var data = {
                    "companyid": $scope.newOrder.companyid,
                    "orderid": $scope.newOrder.orderid,
                    "deline": $scope.newOrder.deline,
                    "height": $scope.newOrder.height,
                    "materialsum": $scope.newOrder.materialsum,
                    "ordercount": $scope.newOrder.ordercount,
                    "orderdate": $scope.newOrder.orderdate,
                    "productid": $scope.newOrder.productid,
                    "productsum": $scope.newOrder.productsum,
                    "proportion": $scope.newOrder.proportion,
                    "purchasebuy": $scope.newOrder.purchasebuy,
                    "spellcount": $scope.newOrder.spellcount,
                    "standardid": $scope.newOrder.standardid,
                    "status": 1,
                    "stockcount": $scope.newOrder.stockcount,
                    "stockid": $scope.newOrder.stockid,
                    "thickness": $scope.newOrder.thickness,
                    "print": $scope.newOrder.print,
                    "open": $scope.newOrder.open,
                    "merge": $scope.newOrder.merge,
                    "cut": $scope.newOrder.cut,
                    "stable": $scope.newOrder.stable,
                    "repeat": $scope.newOrder.repeat,
                    "delivery": $scope.newOrder.delivery,
                    "logistics": $scope.newOrder.logistics,
                    "express": $scope.newOrder.express,
                    "expressnum": $scope.newOrder.expressnum,
                    "result": $scope.newOrder.result
                }

                console.log("data============="+data)

                var url = baseUrl+"/ghprint-cms/orders/addorder.do";
                $http({
                    method: 'POST',
                    url: url,
                    data: data

                }).then(function successCallback(response) {
                    console.log(response);
                    if(response.data.success){
                        $scope.tipsState=true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "操作成功";
                    }else{
                        $scope.tipsState=true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "系统报错，请重试";
                    }
                    $scope.newOrderBox  = false
                    searchOrderList(1,"","");

                }, function errorCallback(response) {
                    console.log(response);
                    $scope.tipsState=true;
                    $scope.tipsTitle = "操作提示";
                    $scope.tipsContent = "系统报错，建议重新登录";
                    $scope.newOrderBox  = false

                });
            }

            //查询订单
            searchOrderList(1,"","");
            function searchOrderList(page,key,value) {
                var modelUrl
                modelUrl = baseUrl+"/ghprint-cms/orders/selectorders.do?page="+page +"&rows=5+&key="+key +"&value="+value;
                console.log("modelUrl==========="+modelUrl);
                //console.log(url);
                $http({
                    method: 'GET',
                    url: modelUrl
                }).then(function successCallback(response) {
                    console.log( response);
                    if(response.data.success){

                        $scope.orderData = response.data.rows;
                        //将此处的数据赋值到上面的分页变量
                        $scope.p_all_page = response.data.totalPage;
                        $scope.p_current = response.data.currentPage;
                        $scope.totalCount = response.data.totalCount;

                        console.log( $scope.p_all_page+"共几多页")
                        console.log( $scope.p_current+"当前页是第几页")
                        console.log( $scope.totalCount+"共几多条记录")

                        reloadPno();

                    }else{
                        //$scope.DataemptyState = true;
                        $scope.tipsState=true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "系统报错，建议重新登录";

                    }



                }, function errorCallback(response) {
                    console.log(response);
                });
            }

            //注销
            $scope.reset = function() {

                $http({
                    method: 'GET',
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


            $scope.searchOnKey = function(index) {
                if( $scope.selectedName=="全部"){
                    $rootScope.selectedName= $scope.selectedName
                    $rootScope.selectValue =  $scope.selectValue
                    searchOrderList(1,$scope.searchKey,$scope.selectValue);
                }else if( $scope.selectedName=="材料规格"){
                    $rootScope.selectedName= $scope.selectedName
                    $rootScope.selectValue =  $scope.selectValue
                    searchOrderList(1,"specification",$scope.selectValue);
                }else if($scope.selectedName=="交货日期"){
                    $rootScope.selectedName= $scope.selectedName
                    $rootScope.selectValue =  $scope.selectValue
                    searchOrderList(1,"deline",$scope.selectdate);
                }else if($scope.selectedName=="编号"){
                    $rootScope.selectedName= $scope.selectedName
                    $rootScope.selectValue =  $scope.selectValue
                    searchOrderList(1,"orderid",$scope.selectValue);
                }else if($scope.selectedName=="产品名称"){
                    $rootScope.selectedName= $scope.selectedName
                    $rootScope.selectValue =  $scope.selectValue
                    searchOrderList(1,"stockname",$scope.selectValue);
                }else {

                    $scope.tipsState = true;
                    $scope.tipsTitle = "操作提示";
                    $scope.tipsContent = "系统报错，请联系管理员";
                }};

            $scope.searchPage = function(index) {
                console.log("你点击了第"+index+"页")
            };

            $scope.takequalityFormShow = function(a) {
                $scope.qualityFormShow=!$scope.qualityFormShow;
            };


           /* $scope.edit = function(a) {
                console.log("你点击了第"+a+"===========")
                $scope.EditOrder=!$scope.EditOrder;
            };*/

            $scope.dele = function(index) {
                $scope.deleTargetTipsBox=true;
                $scope.tipsTitle = "删除提示"
                $scope.tipsContent = "确定删除此记录？";
                console.log('index.oid=================='+index.oid)
                $scope.deleIndex = index.oid
            };


            $scope.deleConfirm = function() {
                var url
                    url = "/ghprint-cms/orders/delorder.do?orderId="+$scope.deleIndex;

                deleM(url);
            }

            $scope.jump = function(a) {
                $location.path("/"+a)
            };



            //分页
            //配置
            $scope.totalCount = 0;
            $scope.p_pernum = 10;
            //变量
            $scope.p_current = 1;
            $scope.p_all_page =0;

            $rootScope.selectedName="全部"
                $rootScope.searchKey = "";
                $rootScope.selectValue = ""

            //首页
            $scope.p_index = function(){
                if( $rootScope.selectedName=="全部"){
                    $rootScope.searchKey = "";
                    $rootScope.selectValue = ""
                    searchOrderList(1,$rootScope.searchKey,$rootScope.selectValue);
                }else if( $rootScope.selectedName=="材料规格"){
                    searchOrderList(1,"specification",$rootScope.selectValue);
                }else if($rootScope.selectedName=="交货日期"){
                    searchOrderList(1,"deline",$rootScope.selectdate);
                }else if($rootScope.selectedName=="编号"){
                    searchOrderList(1,"orderid",$rootScope.selectValue);
                }else if($rootScope.selectedName=="产品名称"){
                    searchOrderList(1,"stockname",$rootScope.selectValue);
                }else{

                    $scope.tipsState=true;
                    $scope.tipsTitle = "操作提示";
                    $scope.tipsContent = "系统报错，请联系管理员";
            }}



            /*
            *  $scope.selectOption = ["产品编号", "出货日期", "产品名称","客户名称"];
            * */
            //尾页
            $scope.p_last = function(p_all_page){

                if( $rootScope.selectedName=="全部"){
                    searchOrderList(p_all_page,"","");
                }else if( $rootScope.selectedName=="材料规格"){
                    searchOrderList(p_all_page,"specification",$rootScope.selectValue);
                }else if($rootScope.selectedName=="交货日期"){
                    searchOrderList(p_all_page,"deline",$rootScope.selectdate);
                }else if($rootScope.selectedName=="编号"){
                    searchOrderList(p_all_page,"orderid",$rootScope.selectValue);
                }else if($rootScope.selectedName=="产品名称"){
                    searchOrderList(p_all_page,"stockname",$rootScope.selectValue);
                }else{

                    $scope.tipsState=true;
                    $scope.tipsTitle = "操作提示";
                    $scope.tipsContent = "系统报错，请联系管理员";}
            }

            //加载某一页
            $scope.load_page = function(page){
                if( $rootScope.selectedName=="全部"){
                    searchOrderList(page,"","");
                }else if( $rootScope.selectedName=="材料规格"){
                    searchOrderList(page,"specification",$rootScope.selectValue);
                }else if($rootScope.selectedName=="交货日期"){
                    searchOrderList(page,"deline",$rootScope.selectdate);
                }else if($rootScope.selectedName=="编号"){
                    searchOrderList(page,"orderid",$rootScope.selectValue);
                }else if($rootScope.selectedName=="产品名称"){
                    searchOrderList(page,"stockname",$rootScope.selectValue);
                }else{

                    $scope.tipsState=true;
                    $scope.tipsTitle = "操作提示";
                    $scope.tipsContent = "系统报错，请联系管理员";}
            };

            //初始化页码
            var reloadPno = function(){
                $scope.pages=calculateIndexes($scope.p_current,$scope.p_all_page ,8);
            };

            function deleM(url) {
                console.log("ok============="+url)

                $http({
                    method: 'GET',
                    url: baseUrl+ url
                }).then(function successCallback(response) {
                    console.log( response.data.result);

                    if(response.data.success){
                        //将数据取出：1
                        $scope.deleTargetTipsBox = false
                        $scope.tipsState = true
                        $scope.tipsTitle = "删除提示"
                        $scope.tipsContent = "操作成功";

                        searchOrderList(1,"","");
                    }else{
                        //查询角色列表失败
                        $scope.tipsState=true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "系统报错，请联系管理员";                    }

                }, function errorCallback(response) {
                    console.log(response);
                    $scope.tipsState=true;
                    $scope.tipsTitle = "操作提示";
                    $scope.tipsContent = "系统报错，请联系管理员";
                });
            }



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

                console.log("start=============="+start)
                console.log("end=============="+end)
                for (var i = start; i <= end; i++) {
                    indexes.push(i);
                    console.log("==========indexes"+indexes);
                }
                console.log("==========ok?"+indexes);
                return indexes;
            };

            $scope.orderStateSelect = [{name:"进行中",choice:"1"},{name:"已完成",choice:"2"}]

//质量表显示的印刷方式 ，勿删
            $scope.selectPrintOption = [{name:"里印",choice:"1"},{name:"表印",choice:"2"}];

            $scope.selectOption = ["全部","产品名称"];
            //成品型式
            $scope.selectProductStyleOption = [{name:"切片",choice:"1"},{name:"卷装",choice:"2"},{name:"大纸芯12.5CM",choice:"3"},{name:"大纸芯15CM",choice:"4"},{name:"小纸芯",choice:"5"}];
            //出卷方向
            $scope.selectDirectionOption = [{name:"字头先出",choice:"1"},{name:"字尾先出",choice:"2"},{name:"合掌位在内",choice:"3"},{name:"随意",choice:"4"}];
            //包装
            $scope.packageOption =  [{name:"新箱",choice:"1"},{name:"箱内外膜包装",choice:"2"},{name:"箱外加井字打包带",choice:"3"},{name:"旧箱",choice:"4"},{name:"其它",choice:"5"}];
            //切片数量
            $scope.splitsumOption = [{name:"100",choice:"1"},{name:"200",choice:"2"},{name:"300",choice:"3"},{name:"500",choice:"4"},{name:"其它",choice:"5"}];

        },
        tpl: tpl
    };
});