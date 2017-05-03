define(['angular', 'text!five/qualityForm/qualityForm.html'], function (angular, tpl) {
    //angular会自动根据controller函数的参数名，导入相应的服务
    return {
        controller: function ($rootScope,$scope,$location, $routeParams, $http, $interval) {
            if(!$rootScope.username){
                $location.path("/login")
            }


            //查看详情
            $scope.showFormDetailBox =false;
            $scope.showFormDetail = function(index) {
                $scope.showFormDetailBox =true;
                $scope.formDatasArr= $scope.formDatas[index];
                $scope.EditForm(index,1)
            }

            //修改
            $scope.EditForm = function(index,showBox) {
                if(showBox!=1){

                    $scope.EditFormshow=true;
                }
                $scope.formDatasArr= $scope.formDatas[index];
                console.log("$scope.formDatas[index].printingProcedure.pid========="+$scope.formDatas[index].pid);
                $scope.shareIndex = index;
                console.log( "formDatasArr==============="+$scope.formDatasArr)
                var modifyArr =  $scope.formDatasArr;
                $scope.modifyContent =angular.copy($scope.modifyContent=angular.copy(modifyArr));
                //获取对应的pid调查询详情接口
                $http({
                    method: 'GET',
                    url: baseUrl+ '/ghprint-cms/product/ PreUpdateproduct.do?pid='+$scope.formDatas[index].pid
                }).then(function successCallback(response) {
                    console.log(response);
                    if(response.data.success){
                        $scope.formDatasArr = $scope.modifyContent = response.data.result
                        //印刷方式
                        var selectPrint = $scope.modifyContent.productionStandard.printingmode
                        parseInt(selectPrint)
                        console.log("selectPrint============="+selectPrint)
                        $scope.formDatasArr.productionStandard.printingmode = $scope.selectPrintOption[selectPrint-1]
                        $scope.modifyContent.productionStandard.printingmode = $scope.selectPrintOption[selectPrint-1]
                        console.log("selectPrint============="+ $scope.formDatasArr.productionStandard.printingmode)
                        //切片数量
                        var splitsum = $scope.modifyContent.printingProcedureafter.splitsum
                        parseInt(splitsum)
                        console.log("splitsum============="+splitsum)
                        $scope.formDatasArr.printingProcedureafter.splitsum = $scope.splitsumOption[splitsum-1]
                        $scope.modifyContent.printingProcedureafter.splitsum = $scope.splitsumOption[splitsum-1]
                        //成品型式
                        var readyProduct = $scope.modifyContent.printingProcedureafter.productstyle
                        $scope.formDatasArr.printingProcedureafter.productstyle =$scope.selectProductStyleOption[readyProduct-1]
                        $scope.modifyContent.printingProcedureafter.productstyle =$scope.selectProductStyleOption[readyProduct-1]

                        console.log("readyProduct====="+readyProduct);

                        //出卷方向
                        var direction =$scope.modifyContent.printingProcedureafter.scrolldirection
                        parseInt(direction)
                        $scope.formDatasArr.printingProcedureafter.scrolldirection =$scope.selectDirectionOption[direction-1]
                        $scope.modifyContent.printingProcedureafter.scrolldirection =$scope.selectDirectionOption[direction-1]


                        //包装
                        var pack = $scope.modifyContent.productionStandard.packaging
                        parseInt(pack)
                        console.log("packaing========="+pack)
                        $scope.formDatasArr.productionStandard.packaging =$scope.packageOption[pack-1]
                        $scope.modifyContent.productionStandard.packaging =$scope.packageOption[pack-1]


                    }else{
                        console.log("数据获取失败")
                        $scope.tipsState=true;
                        $scope.tipsTitle = "系统提示";
                        $scope.tipsContent = "数据获取失败，请重试";
                        $scope.EditFormshow=false;
                    }


                }, function errorCallback(response) {
                    $scope.tipsState=true;
                    $scope.tipsTitle = "系统提示";
                    $scope.tipsContent = "系统出错，请重试";
                    console.log(response);
                });

                //获取到的数据赋给输入框，修改了什么到时候直接传上去后台

                //$scope.PrintMethod = $scope.selectPrintOption[(modifyArr.productionStandard.printingmode)];
                //$scope.packing = $scope.selectPrintOption[modifyArr.productionStandard.packaging];

            }



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

            //新增状态值
            $scope.newOrder = false;
            //修改提交
            $scope.EditFormCommit = function(index){
                //取消数据双向绑定
                var arr= $scope.modifyContent;
                //$scope.EditFormContent =angular.copy($scope.EditFormContent=angular.copy(arr));
                var timestamp=new Date().getTime();   //获取时间戳，建单时间

                if(arr.productionStandard.printingmode){
                    $scope.modifyContent.productionStandard.printingmode=  $scope.modifyContent.productionStandard.printingmode.choice

                }if(arr.printingProcedureafter.splitsum){
                    $scope.modifyContent.printingProcedureafter.splitsum = $scope.modifyContent.printingProcedureafter.splitsum.choice

                }if(arr.printingProcedureafter.scrolldirection){
                    $scope.modifyContent.printingProcedureafter.scrolldirection = $scope.modifyContent.printingProcedureafter.scrolldirection.choice

                }if(arr.productionStandard.packaging){

                    $scope.modifyContent.productionStandard.packaging = $scope.modifyContent.productionStandard.packaging.choice
                }if(arr.printingProcedureafter.productstyle){

                    $scope.modifyContent.printingProcedureafter.productstyle = $scope.modifyContent.printingProcedureafter.productstyle.choice
                }




                  $http({

                      //调接口参数
                      method: 'POST',
                      url: baseUrl+ "/ghprint-cms/product/updateproduct.do",
                      headers: {'Content-type': 'application/json;charset=UTF-8'},
                      data:$scope.modifyContent

                  }).then(function successCallback(response) {
                      console.log( response);
                      $scope.EditFormshow=false;

                      if(response.data.success){
                          //$scope.qualityFormShow=false;
                          $scope.tipsState=true;
                          $scope.tipsTitle = "操作提示";
                          $scope.tipsContent = "操作成功";
                      }else{
                          $scope.tipsState=true;
                          $scope.tipsTitle = "操作提示";
                          $scope.tipsContent = "操作不成功";
                          /*        $scope.DataemptyState = true;  */
                      }
                      $scope.formDatas="";
                      searchqualityList(1,"","");

                  }, function errorCallback(response) {
                      console.log(response);
                      $scope.EditFormshow=false
                      $scope.tipsState=true;
                      $scope.tipsTitle = "操作提示";
                      $scope.tipsContent = "系统报错，建议重新登录";
                  });


        }
            $scope.deleTargetTips = function(index){
                $scope.deleTargetTipsBox=true;
                $scope.deleindex = index;
                $scope.tipsTitle = "删除提示"
                $scope.tipsContent = "确定删除此记录？";
            }

            $scope.deleForm = function(){
                //取消确认提示框
                $scope.deleTargetTipsBox=false;
                //传入索引

                var pid = $scope.formDatas[$scope.deleindex].pid;
                console.log($scope.formDatas[$scope.deleindex].pid +"================$scope.formDatas[$scope.deleindex].pid")
                $http({
                    method: 'GET',
                    url: baseUrl+ "/ghprint-cms/product/delproduct.do?pid="+pid
                }).then(function successCallback(response) {
                    console.log( response.data.result);

                    if(response.data.success){
                        //将数据取出：1
                        $scope.tipsState = true
                        $scope.tipsTitle = "删除提示"
                        $scope.tipsContent = "操作成功";
                    }else{
                        //查询角色列表失败f
                        console.log("查询角色失败，请联系管理员！")
                    }
                    searchqualityList(1,"","");

                }, function errorCallback(response) {
                    console.log(response);
                });

            }
            $scope.searchOnKey = function(){
                var urlKey;
                 if($scope.selectedName=='产品名称'){
                    $rootScope.selectedName= $scope.selectedName
                     $rootScope.selectValue =  $scope.selectValue
                    urlKey = "productname"
                     searchqualityList(1,urlKey,$rootScope.selectValue);
                 }else if($scope.selectedName=='全部'){
                     $rootScope.selectedName= ""
                     $rootScope.selectValue =""
                     searchqualityList(1,"","");
                 }else{
                     $scope.formTitle="错误提示"
                     $scope.controlUsertips="参数不齐"
                     $scope.windowState=true
                 }
            }


            //新增生产质量列表
            //$scope.newForm.customerInfo=""
           $scope.addForm = function(){
               var timestamp=new Date().getTime();   //获取时间戳，建单时间
               //从输入数据转到上传参数
        /*       if(
                   $scope.newForm.printingProcedure.printamount||
                   $scope.newForm.printingData.bankuncount||
                $scope.newForm.customerInfo.companycode||
                $scope.newForm.productionStandard.createauthor
                    ){
                console.log("参数不齐")
                $scope.formTitle="错误提示"
                $scope.controlUsertips="参数不齐"
                $scope.windowState=true

            }*/
               //必填：printamount  backun   box  印刷数量
                console.log("准备请求新增接口");
                $http({

                    //调接口参数
                    method: 'POST',
                    url: baseUrl+ "/ghprint-cms/product/addproduct.do",
                    data:{
                        "customerInfo":{
                            "companycode":$scope.newForm.customerInfo.companycode,
                            "companyname":$scope.newForm.customerInfo.companyname,
                        },
                        "printingData":{
                            "bankuncount":$scope.newForm.printingData.bankuncount,
                            "color":$scope.newForm.printingData.color,
                            "printnote":$scope.newForm.printingData.printnote,
                            "printsize":$scope.newForm.printingData.printsize,
                            "spellcount":$scope.newForm.printingData.spellcount,
                            "templatelength":$scope.newForm.printingData.templatelength,
                            "templatenum":$scope.newForm.printingData.templatenum,
                            "templateperimeter":$scope.newForm.printingData.templateperimeter
                        },
                        "printingProcedure":{
                            "printamount":$scope.newForm.printingProcedure.printamount,
                            "printdirect":$scope.newForm.printingProcedure.printdirect,
                            "printmeter":$scope.newForm.printingProcedure.printmeter,
                            "printweight":$scope.newForm.printingProcedure.printweight,
                            "procedurenote":$scope.newForm.printingProcedure.procedurenote,
                            "specification":$scope.newForm.printingProcedure.specification,
                            "wastage":$scope.newForm.printingProcedure.wastage
                        },
                        "printingProcedureafter":{
                            "boxsize":$scope.newForm.printingProcedureafter.boxsize,
                            "boxway":$scope.newForm.printingProcedureafter.boxway,
                            "foldplace":$scope.newForm.printingProcedureafter.foldplace,
                            "glueplace":$scope.newForm.printingProcedureafter.glueplace,
                            "hemcount":$scope.newForm.printingProcedureafter.hemcount,
                            "interfacecount":$scope.newForm.printingProcedureafter.interfacecount,
                            "mergesize":$scope.newForm.printingProcedureafter.mergesize,
                            "mould":$scope.newForm.printingProcedureafter.mould,
                            "proceduresum":$scope.newForm.printingProcedureafter.proceduresum,
                            "productstyle":$scope.newForm.printingProcedureafter.productStyle,
                            "qualitycheck":$scope.newForm.printingProcedureafter.qualitycheck,
                            "repeatscrollsize":$scope.newForm.printingProcedureafter.repeatscrollsize,
                            "scrolldirection":$scope.newForm.printingProcedureafter.scrolldirection,//出卷方向
                            "scrolllength":$scope.newForm.printingProcedureafter.scrolllength,
                            "splithigh":$scope.newForm.printingProcedureafter.splithigh,
                            "splitsizr":$scope.newForm.printingProcedureafter.splitsizr,
                            "splitsum":$scope.newForm.printingProcedureafter.splitsum,
                            "tearlineplace":$scope.newForm.printingProcedureafter.tearlineplace,
                            "tearlinesize":$scope.newForm.printingProcedureafter.tearlinesize,
                            "transparentkeep":$scope.newForm.printingProcedureafter.transparentkeep
                        },
                        "productInfo":{
                            "customerid":$scope.newForm.customerInfo.clientID,
                            "productcode":$scope.newForm.productInfo.productcode,
                            "productmaterial":$scope.newForm.printingProcedure.specification,
                            "productname":$scope.newForm.productInfo.productname,
                            "specification":$scope.newForm.printingProcedure.specification,
                            "weight":""
                        },
                        "productionStandard":{
                            "codeid":$scope.newForm.productionStandard.codeid,//产品编号
                            "createauthor":$scope.newForm.productionStandard.createauthor,
                            "createtime":timestamp,
                            "crosswiseshrink":$scope.newForm.productionStandard.crosswiseshrink,
                            "material":$scope.newForm.printingProcedure.specification,
                            "note":"合掌912米/卷、复卷成品米数不可收901米/卷",
                            "packaging":$scope.newForm.productionStandard.packaging,  //包装
                            "portraitshrink":$scope.newForm.productionStandard.portraitshrink,
                            "printingmode":$scope.newForm.productionStandard.PrintMethod//印刷方式
                        }


                    }
                }).then(function successCallback(response) {
                    //console.log(angular.toJSON(data))
                    console.log( response);
                    $scope.qualityFormShow=false;
                    if(response.data.success){
                        $scope.tipsState=true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "操作成功";
                    }else{
                        $scope.tipsState=true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "操作不成功";
                /*        $scope.DataemptyState = true;  */
                    }

                    searchqualityList(1,"","");

                }, function errorCallback(response) {
                    console.log(response);
                    $scope.qualityFormShow=false;
                    $scope.tipsState=true;
                    $scope.tipsTitle = "操作提示";
                    $scope.tipsContent = "系统报错，建议重新登录";
                });
            }


            $scope.searchqualitySpitList = function(index){
                console.log(index+"当前页是第几页")
                searchqualityList(index,"","");
            }

            searchqualityList(1,"","");
            function searchqualityList(page,key,value) {
               var url = baseUrl+ "/ghprint-cms/product/queryproductlist.do?key="+key+"&value="+value+"&page="+page+"&rows=5";
                console.log(url);
                $http({
                    method: 'GET',
                    url: url
                }).then(function successCallback(response) {
                    console.log( response);
                    if(response.data.success){
                        $scope.formDatas = response.data.rows;
                        //将此处的数据赋值到上面的分页变量
                        $scope.p_all_page = response.data.totalPage;
                        $scope.p_current = response.data.currentPage;
                        $scope.totalCount = response.data.totalCount;

                        console.log( $scope.p_all_page+"共几多页")
                        console.log( $scope.p_current+"当前页是第几页")
                        console.log( $scope.totalCount+"共几多条记录")
                        reloadPno();
                    }else{
                        $scope.DataemptyState = true;
                        $scope.tipsState=true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "系统报错，建议重新登录";

                    }



                }, function errorCallback(response) {
                    console.log(response);
                });
            }
           //印刷方式
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






            $scope.count=3;
            $scope.username=$rootScope.username;
            $scope.qualityFormShow=false;

            $scope.app = function(index) {
                console.log("你点击了"+index)
            };

            $scope.searchPage = function(index) {
                console.log("你点击了第"+index+"页")
            };



            $scope.jump = function(a) {
                $location.path("/"+a)
                $rootScope.selectedName = ""
            };




            //分页
            //配置
            $scope.totalCount = 0;
            $scope.p_pernum = 10;
            //变量
            $scope.p_current = 1;
            $scope.p_all_page =0;
            //首页
            $scope.p_index = function(){
                var urlKey;
                if($rootScope.selectedName=='产品名称'){
                    urlKey = "productname"
                    searchqualityList(1,urlKey,$rootScope.selectValue);
                }else if($rootScope.selectedName=='全部'){
                    $rootScope.selectedName= ""
                    $rootScope.selectValue =""
                    searchqualityList(1,"","");
                }else{
                    $scope.formTitle="错误提示"
                    $scope.controlUsertips="参数不齐"
                    $scope.windowState=true
                }
            }

            //尾页
            $scope.p_last = function(){
                var urlKey;
                if($rootScope.selectedName=='产品名称'){
                    urlKey = "productname"
                    searchqualityList($scope.p_all_page,urlKey,$rootScope.selectValue);
                }else if($rootScope.selectedName=='全部'){
                    $rootScope.selectedName= ""
                    $rootScope.selectValue =""
                    searchqualityList($scope.p_all_page,"","");
                }else{
                    $scope.formTitle="错误提示"
                    $scope.controlUsertips="参数不齐"
                    $scope.windowState=true
                }
            }

            //加载某一页
            $scope.load_page = function(page){
                var urlKey;
                if($rootScope.selectedName=='产品名称'){

                    urlKey = "productname"
                    searchqualityList(page,urlKey,$rootScope.selectValue);
                }else if($rootScope.selectedName=='全部'){
                    $rootScope.selectedName= ""
                    $rootScope.selectValue =""
                    searchqualityList(page,"","");
                }else{
                    $scope.formTitle="错误提示"
                    $scope.controlUsertips="参数不齐"
                    $scope.windowState=true
                }
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

                console.log("start=============="+start)
                console.log("end=============="+end)
                for (var i = start; i <= end; i++) {
                    indexes.push(i);
                }
                return indexes;
            };

        },
        tpl: tpl
    };
});