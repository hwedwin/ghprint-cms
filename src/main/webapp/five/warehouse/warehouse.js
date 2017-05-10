define(['angular', 'text!five/warehouse/warehouse.html'], function (angular, tpl) {
    //angular会自动根据controller函数的参数名，导入相应的服务
    return {
        controller: function ($rootScope,$scope,$location, $routeParams, $http, $interval) {
            if(!$rootScope.username){
                $location.path("/login")
            }

            //做法：先把3个模块的增删改查函数分开

            //$scope.newProduct.customerid = ""
            //纸箱新增变量
            //$scope.newPaperBox.boxsize = ""
            //     $scope.newPaperBox.count =""
            //     $scope.newPaperBox.packages = ""
            //     $scope.newPaperBox.price =""
            //     $scope.newPaperBox.amount =""

            //排序
            $scope.desc = 0;//默认排序条件升序

                    $scope.sort='stockid';
            //设置tab效果
            $scope.ProductTab = true
            $scope.BoxTab = false
            $scope.AtomTab = false
            //不同的模块搜索变量
            $scope.searchKey3="";
            $scope.selectValue3="";
            //$scope.searchKey2="";
            //$scope.selectValue2="";
            $scope.searchKey="",
                $scope.selectValue = ""
            $scope.selectOption1 = ["全部","编码","材料ID", "材料名称", "颜色"];
            $scope.selectOption2 = ["全部","单价", "金额", "纸箱规格"];
            $scope.selectOption3 = ["全部","供应商", "材料名称", "金额"];


//            控制tab样式
            $scope.getClass = function(tabState){
                if($scope.BoxTab &&tabState=='1'){
                    return 'tab1'
                }
                else if($scope.AtomTab&&tabState=='2'){
                    return 'tab1'
                }else if( $scope.ProductTab&&tabState=='3'){
                    return 'tab1'
                }else{

                }
                return 'tab'
            }
//            显示Tab
            $scope.showTab = function(index){
                if(index=='1'){
                    $scope.ProductTab = false
                    $scope.BoxTab = true
                    $scope.AtomTab = false
                }else if(index=='2'){
                    $scope.ProductTab = false
                    $scope.BoxTab = false
                    $scope.AtomTab = true
                }else if(index=='3'){
                    $scope.ProductTab = true
                    $scope.BoxTab = false
                    $scope.AtomTab = false
                }
                else{
                    $scope.tipsState = true;
                    $scope.tipsTitle = "系统提示";
                    $scope.tipsContent = "操作失败，请重试";
                }
            }
//修改库存add
            $scope.addAtomSum = function(index){
                var mid = $scope.AtomData[index].id
                console.log("packages===="+mid)
                var url= baseUrl+"/ghprint-cms/materialstocks/addstocksum.do?mid="+mid+"&sum=1";
                console.log(url);
                $http({
                    method: 'GET',
                    url: url,
                }).then(function successCallback(response) {
                    console.log(response);
                    if(response.data.success){
                        $scope.AtomData[index].materialsum = response.data.result
                    }else{
                        $scope.tipsState = true;
                        $scope.tipsTitle = "系统提示";
                        $scope.tipsContent = "操作失败，请重试";
                    }


                }, function errorCallback(response) {
                    console.log(response);
                    $scope.tipsState = true;
                    $scope.tipsTitle = "系统提示";
                    $scope.tipsContent = "系统报错，建议重新登录";
                });
            }


            $scope.addBoxSum = function(index){
                //var stocksum = $scope.companyData[index].stocksum
                var sid = $scope.paperBoxData[index].id
                console.log("packages===="+sid)
                var url= baseUrl+"/ghprint-cms/cartonstocks/addstocksum.do?cid="+sid+"&sum=1";
                console.log(url);
                $http({
                    method: 'GET',
                    url: url,
                }).then(function successCallback(response) {
                    console.log(response);
                    if(response.data.success){
                        $scope.paperBoxData[index].packages = response.data.result
                    }else{
                        $scope.tipsState = true;
                        $scope.tipsTitle = "系统提示";
                        $scope.tipsContent = "操作失败，请重试";
                    }


                }, function errorCallback(response) {
                    console.log(response);
                    $scope.tipsState = true;
                    $scope.tipsTitle = "系统提示";
                    $scope.tipsContent = "系统报错，建议重新登录";
                });
            }
            $scope.addProductSum = function(index){
                //var stocksum = $scope.companyData[index].stocksum
                var sid = $scope.companyData[index].id
                console.log("stocksum===="+sid)
                var url= baseUrl+"/ghprint-cms/prostocks/addstocksum.do?sid="+sid+"&sum=1";
                console.log(url);
                $http({
                    method: 'GET',
                    url: url,
                }).then(function successCallback(response) {
                    console.log(response);
                    if(response.data.success){
                        $scope.companyData[index].stocksum = response.data.result
                    }else{
                        $scope.tipsState = true;
                        $scope.tipsTitle = "系统提示";
                        $scope.tipsContent = "操作失败，请重试";
                    }


                }, function errorCallback(response) {
                    console.log(response);
                    $scope.tipsState = true;
                    $scope.tipsTitle = "系统提示";
                    $scope.tipsContent = "系统报错，建议重新登录";
                });
            }

//修改库存cut
            $scope.cutAtomSum = function(index){
                var mid = $scope.AtomData[index].id
                console.log("AtomData packages===="+mid)
                var url= baseUrl+"/ghprint-cms/materialstocks/substocksum.do?mid="+mid+"&sum=1";
                console.log(url);
                $http({
                    method: 'GET',
                    url: url,
                }).then(function successCallback(response) {
                    console.log(response);
                    if(response.data.success){
                        $scope.AtomData[index].materialsum = response.data.result
                    }else{
                        $scope.tipsState = true;
                        $scope.tipsTitle = "系统提示";
                        $scope.tipsContent = "操作失败，请重试";
                    }


                }, function errorCallback(response) {
                    console.log(response);
                    $scope.tipsState = true;
                    $scope.tipsTitle = "系统提示";
                    $scope.tipsContent = "系统报错，建议重新登录";
                });
            }


            $scope.cutBoxSum = function(index){
                var sid = $scope.paperBoxData[index].id
                console.log("stocksum===="+sid)
                var url= baseUrl+"/ghprint-cms/cartonstocks/substocksum.do?cid="+sid+"&sum=1";
                console.log(url);
                $http({
                    method: 'GET',
                    url: url,
                }).then(function successCallback(response) {
                    console.log(response);
                    if(response.data.success){
                        $scope.paperBoxData[index].packages = response.data.result
                    }else{
                        $scope.tipsState = true;
                        $scope.tipsTitle = "系统提示";
                        $scope.tipsContent = "操作失败，请重试";
                    }


                }, function errorCallback(response) {
                    console.log(response);
                    $scope.tipsState = true;
                    $scope.tipsTitle = "系统提示";
                    $scope.tipsContent = "系统报错，建议重新登录";
                });
            }

            $scope.cutProductSum = function(index){
                //var stocksum = $scope.companyData[index].stocksum
                var sid = $scope.companyData[index].id
                console.log("stocksum===="+sid)
                var url= baseUrl+"/ghprint-cms/prostocks/substocksum.do?sid="+sid+"&sum=1";
                console.log(url);
                $http({
                    method: 'GET',
                    url: url,
                }).then(function successCallback(response) {
                    console.log(response);
                    if(response.data.success){
                        $scope.companyData[index].stocksum = response.data.result
                    }else{
                        $scope.tipsState = true;
                        $scope.tipsTitle = "系统提示";
                        $scope.tipsContent = "操作失败，请重试";
                    }


                }, function errorCallback(response) {
                    console.log(response);
                    $scope.tipsState = true;
                    $scope.tipsTitle = "系统提示";
                    $scope.tipsContent = "系统报错，建议重新登录";
                });
            }

            //修改
            $scope.modifyProduct = function(model){
                if(model=='1'){
                    var data =$scope.ModifyGoodsContent
                    var url = baseUrl+ "/ghprint-cms/prostocks/updateprostocks.do";
                    ModifyProduct1(model,data,url);
                }else if(model=='2'){
                    var data =$scope.ModifyBoxContent
                    var url = baseUrl+ "/ghprint-cms/cartonstocks/updatecartonstocks.do";
                    ModifyProduct1(model,data,url);
                }else if(model=='3'){
                    var data =$scope.ModifyAtomContent
                    var url = baseUrl+ "/ghprint-cms/materialstocks/updatematerialstocks.do";
                    ModifyProduct1(model,data,url);

                }
                //取得对应的sid
                //请求数据

            //    显示请求回来的数据
            //    将请求的数据赋给输入框
            //    确定无误时，提交数据，返回后台情况
            }

            function  ModifyProduct1(model,data,url){

                console.log(url);
                $http({
                    method: 'POST',
                    url: url,
                    data:data
                }).then(function successCallback(response) {
                    console.log(response);
                    $scope.Modifycompany= $scope.ModifyBoxCount= $scope.ModifyGoods=false
                    if(response.data.success){
                        $scope.tipsState = true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "操作成功";

                        if(model=='1'){
                            searchProductList(1, "", "");

                        }else if(model=='2'){
                            searchBoxList(1, "", "");
                        }else if(model=='3'){
                            searchAtomList(1, "", "");

                        }
                    }else{
                        $scope.tipsState = true;
                        $scope.tipsTitle = "系统提示";
                        $scope.tipsContent = "更新失败，请重试";
                    }



                }, function errorCallback(response) {
                    console.log(response);
                    $scope.ModifyGoods=false
                    $scope.tipsState = true;
                    $scope.tipsTitle = "系统提示";
                    $scope.tipsContent = "系统报错，建议重新登录";
                });
            }

            function  getProductDetail(sid,model,url){


                    console.log(url);
                $http({
                    method: 'GET',
                    url: url
                }).then(function successCallback(response) {
                    console.log(response);
                    if(model =='1'){
                        $scope.ModifyGoodsContent = response.data.result}
            else if(model=='2'){
                        $scope.ModifyBoxContent = response.data.result

                }else if(model=='3'){
                        $scope.ModifyAtomContent = response.data.result

                    }

                    }, function errorCallback(response) {
                        $scope.tipsState = true;
                        $scope.tipsTitle = "系统提示";
                        $scope.tipsContent = "系统报错，建议重新登录";
                        console.log(response);
                    });
            }

            //增加
            $scope.addProductMethod = function(index){
                var url
                var data

                console.log("click===========before")
                if(index =='1'){   //成品
                    url = "/ghprint-cms/prostocks/addprostocks.do"
                    data = {
                        "customerid": $scope.newProduct.customerid,
                        "stockid": $scope.newProduct.stockId,
                        "stockname": $scope.newProduct.stockname,
                        "color": $scope.newProduct.color,
                        "count": $scope.newProduct.count,
                        "boxcount": $scope.newProduct.boxcount,
                        "remain": $scope.newProduct.remain,
                        "stocksum": $scope.newProduct.stocksum,
                        "price": $scope.newProduct.price,
                        "amount": $scope.newProduct.amount

                    }
                }else if(index =='2'){   //纸箱
                    url = "/ghprint-cms/cartonstocks/addcartonstocks.do"
                    data = {
                        "boxsize": $scope.newPaperBox.boxsize,
                        "count": $scope.newPaperBox.count,
                        "packages": $scope.newPaperBox.packages,
                        "price": $scope.newPaperBox.price,
                        "amount": $scope.newPaperBox.amount

                    }

                }else if(index =='3'){
                    url = "/ghprint-cms/materialstocks/addmaterialstocks.do",
                        data = {
                            "amount": $scope.newAtom.newAmount,
                            "infeed": $scope.newAtom.newInfeed,
                            "materialsum": $scope.newAtom.newStockSum,
                            "name": $scope.newAtom.newAtomName,
                            "packages": $scope.newAtom.newPackages,
                            "ply": $scope.newAtom.newPLY,
                            "portrait": $scope.newAtom.newPortrait,
                            "price": $scope.newAtom.newPrice,
                            "provider": $scope.newAtom.newProvider,
                            "specification": $scope.newAtom.newSpecification

                        }
                }else{
                    $scope.tipsState = true;
                    $scope.tipsTitle = "操作提示";
                    $scope.tipsContent = "系统报错，建议重新登录";
                    return
                }


                if(index =='1'){

                    if(!$scope.newProduct.customerid){//检验customerid 是否为空  但会报错？
                        $scope.customeridError = true
                    }else{
                        $scope.customeridError = false
                        addProduct(index,url,data)}
                }else if(index =='2'){
                    addProduct(index,url,data)
                }else if(index =='3'){
                    addProduct(index,url,data)
                }else{
                    console.log("系统出错")
                }


            }
            //新增请求
            function    addProduct(model,url,data) {

                console.log("click========")
                $http({

                    //调接口参数
                    dataType:JSON,
                    method: 'POST',
                    headers: {'Content-type': 'application/json;charset=UTF-8'},
                    url: baseUrl + url,
                    data: data
                }).then(function successCallback(response) {
                    //console.log(angular.toJSON(data))
                    console.log("新增库存==========="+response);

                    $scope.goods = $scope.BoxCount = $scope.company = $scope.CountForm = false;
                    if (response.data.success) {
                        $scope.tipsState = true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "操作成功";
                    } else {
                        $scope.tipsState = true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "操作不成功";
                    }

                    if(model=='1'){
                        searchProductList(1,"","");
                    }
                    else if(model=='2'){
                        searchBoxList(1,"","");
                    }else if(model=='3'){
                        searchAtomList(1,"","");
                    }else{
                        $scope.tipsState = true;
                        $scope.tipsTitle = "系统提示提示";
                        $scope.tipsContent = "数据出错，建议重新登陆";
                    }
                    //searchqualityList(1, "", "");

                }, function errorCallback(response) {
                    $scope.goods = $scope.BoxCount = $scope.company = $scope.CountForm = false;
                    console.log(response);
                    $scope.tipsState = true;
                    $scope.tipsTitle = "操作提示";
                    $scope.tipsContent = "系统报错，建议重新登录";
                });
            }



            //    纸箱查询请求
            searchBoxList(1,"","");
            function searchBoxList(page,key,value) {

                console.log("key=============="+key)
                console.log("value=============="+value)
                //纸箱查询列表接口

                var url = baseUrl+ "/ghprint-cms/cartonstocks/selectstocks.do?page="+page+"&rows=5&key="+key+"&value="+value;
                console.log(url);
                $http({
                    method: 'GET',
                    url: url
                }).then(function successCallback(response) {
                    console.log("纸箱==========");
                    console.log( response);
                    if(response.data.success){

                        $scope.paperBoxData = response.data.rows;
                        //将此处的数据赋值到上面的分页变量
                        $scope.p_all_page2 = response.data.totalPage;
                        $scope.p_current2 = response.data.currentPage;
                        $scope.totalCount2 = response.data.totalCount;

                        console.log( "$scope.p_all_page2========="+$scope.p_all_page2+"共几多页")
                        console.log( $scope.p_current2+"当前页是第几页")
                        console.log( $scope.totalCount2+"共几多条记录")
                        //reloadPno2();

                    }else{
                        //$scope.DataemptyState = true;
                        $scope.tipsState=true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "系统报错，建议重新登录";

                    }

                    //if($scope.selectValue2&&$scope.selectValue2){
                    //
                    //}


                }, function errorCallback(response) {
                    console.log(response);
                });
            }

            searchAtomList(1,"","");
            //原材料查询
            function searchAtomList(page,key,value) {
                var url = baseUrl+"/ghprint-cms/materialstocks/selectstocks.do?page="+page+"&rows=5&key="+key+"&value="+value;
                console.log(url);
                $http({
                    method: 'GET',
                    url: url
                }).then(function successCallback(response) {
                    console.log( response);
                    if(response.data.success){

                        $scope.AtomData = response.data.rows;
                        //将此处的数据赋值到上面的分页变量
                        $scope.p_all_page3 = response.data.totalPage;
                        $scope.p_current3 = response.data.currentPage;
                        $scope.totalCount3 = response.data.totalCount;

                        //reloadPno3();

                    }else{
                        //$scope.DataemptyState = true;
                        $scope.tipsState=true;
                        $scope.tipsTitle = "操作提示";
                        $scope.tipsContent = "系统报错，建议重新登录";

                    }

                   /* if($scope.searchKey3&&$scope.selectValue3){
                        $rootScope.searchKey3 = $scope.searchKey3
                        $rootScope.selectValue3 = $scope.selectValue3
                    }*/



                }, function errorCallback(response) {
                    console.log(response);
                });
            }

            //初始搜索条件为全部
            $rootScope.selectedName = $rootScope.selectedName2 = $rootScope.selectedName3 ='全部'
            //    成品查询请求
            searchProductList(1,"","");
            function searchProductList(page,key,value) {
                var modelUrl
                    modelUrl = "/ghprint-cms/prostocks/selectstocks.do?page="

                var url = baseUrl+ modelUrl+page+"&rows=5&key="+key+"&value="+value;
                console.log(url);
                $http({
                    method: 'GET',
                    url: url
                }).then(function successCallback(response) {
                    console.log( response);
                    if(response.data.success){

                            $scope.companyData = response.data.rows;
                            //将此处的数据赋值到上面的分页变量
                            $scope.p_all_page = response.data.totalPage;
                            $scope.p_current = response.data.currentPage;
                            $scope.totalCount = response.data.totalCount;

                            console.log( $scope.p_all_page+"共几多页")
                            console.log( $scope.p_current+"当前页是第几页")
                            console.log( $scope.totalCount+"共几多条记录")

                            //reloadPno();

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


            $scope.deleTips=false;
            $scope.companyForm=true;
            $scope.newProductFormShow = false

            $scope.count=3;
            $scope.username=$rootScope.username;
            $scope.qualityFormShow=false;
            $scope.CountForm=false;
            $scope.selectedName = "";
            $scope.box=false;
            $scope.goods=false;
            $scope.BoxCount=false;
            $scope.company=false;
            $scope.tipsTitle = "删除提示"
            $scope.tipsContent ="确定删除此记录"
            $scope.showBox = function(index) {
                $scope.CountForm=true;
                $scope.formIndex = index;
                console.log("showBox"+index)
                //1公司  2成品   3纸箱
                if( index=="1"){
                    $scope.goods=true;
                    $scope.company=false;
                    $scope.BoxCount=false;
                }else if( index=="3"){
                    $scope.company=true;
                    $scope.BoxCount=false;
                    $scope.goods=false;
                }else if(index=="2"){
                    $scope.BoxCount=true;
                    $scope.company=false;
                    $scope.goods=false;
                }
            }

            $scope.searchAtomOnKey = function() {
                console.log("$scope.selectedName3======="+$scope.selectedName3)

                if( $scope.selectedName3=="全部"){
                    $rootScope.searchKey3 = "";
                    $rootScope.selectValue3 = ""
                    $rootScope.selectedName3 = ""
                    $rootScope.selectValue3 = ""
                    searchAtomList(1,"","");
                }else if( $scope.selectedName3=="供应商"){
                    $rootScope.selectedName3 =  $scope.selectedName3
                    $rootScope.selectValue3 = $scope.selectValue3
                    searchAtomList(1,"provider",$rootScope.selectValue3);
                }else if($scope.selectedName3=="材料名称"){
                    $rootScope.selectedName3 =  $scope.selectedName3
                    $rootScope.selectValue3 = $scope.selectValue3
                    searchAtomList(1,"name",$rootScope.selectValue3);
                }else if($scope.selectedName3=="金额"){
                    $rootScope.selectedName3 = "amount"
                    $rootScope.selectValue3 = $scope.selectValue3
                    searchAtomList(1,"amount",$rootScope.selectValue3);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            };


            $scope.searchOnKeyBox = function() {
                console.log("$scope.selectedName2======="+$scope.selectedName2)

                if( $scope.selectedName2=="全部"){
                    $scope.selectValue2 = ""

                    $rootScope.searchKey3 = "";
                    $rootScope.selectedName2 = ""
                    searchBoxList(1,"","");
                }else if( $scope.selectedName2=="纸箱规格"){
                    $rootScope.selectedName2=$scope.selectedName2
                    $rootScope.selectValue2 = $scope.selectValue2
                    searchBoxList(1,"boxsize",$scope.selectValue2);
                }else if($scope.selectedName2=="单价"){
                    $rootScope.selectedName2=$scope.selectedName2
                    $rootScope.selectValue2 = $scope.selectValue2
                    searchBoxList(1,"price",$scope.selectValue2forNum);
                }else if($scope.selectedName2=="金额"){
                    $rootScope.selectedName2=$scope.selectedName2
                    $rootScope.selectValue2 = $scope.selectValue2
                    searchBoxList(1,"amount",$scope.selectValue2forNum);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            };


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


            $scope.searchOnKey = function(index) {

                if( $scope.selectedName=="全部"){
                    $scope.searchKey = "";
                    $scope.selectValue = ""
                    searchProductList(1,$scope.searchKey,$scope.selectValue);
                }else if( $scope.selectedName=="材料ID"){
                    $rootScope.selectedName=$scope.selectedName
                    $rootScope.selectValue = $scope.selectValue
                    searchProductList(1,"stockid",$scope.selectValue);
                }else if($scope.selectedName=="材料名称"){
                    $rootScope.selectedName=$scope.selectedName
                    $rootScope.selectValue = $scope.selectValue
                    searchProductList(1,"stockname",$scope.selectValue);
                }else if($scope.selectedName=="颜色"){
                    $rootScope.selectedName=$scope.selectedName
                    $rootScope.selectValue = $scope.selectValue
                    searchProductList(1,"color",$scope.selectValue);
                }else if($scope.selectedName=="编码"){
                    $rootScope.selectedName=$scope.selectedName
                    $rootScope.selectValue = $scope.selectValue
                    searchProductList(1,"id",$scope.selectValue);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            };

            $scope.app = function(index) {
                console.log("你点击了"+index)
            };

            $scope.searchPage = function(index) {
                console.log("你点击了第"+index+"页")
            };



            $scope.edit = function(index,model) {
                console.log("====index========="+index)
                var url
                var sid
                if(model=='1'){
                    $scope.ModifyGoods=true;
                    sid = index.id
                    console.log("sid--------------------"+sid)
                    url= baseUrl+ "/ghprint-cms/prostocks/editprostocks.do?sid="+sid;


                }else if(model=='2'){
                    $scope.ModifyBoxCount = true;
                    sid = index.id
                    console.log("sid--------------------"+sid)
                    url= baseUrl+ "/ghprint-cms/cartonstocks/editcartonstocks.do?cid="+sid;

                }else if(model=='3'){
                    //sid = $scope.paperBoxData[index].id
                    //url= baseUrl+ "/ghprint-cms/cartonstocks/editcartonstocks.do?cid="+sid;
                    $scope.Modifycompany = true;
                    sid = index.id
                    console.log("sid--------------------"+sid)
                    url= baseUrl+ "/ghprint-cms/materialstocks/editmaterialstocks.do?mid="+sid;
                }else{
                    console.log("系统出错，请联系管理员")
                }

                getProductDetail(sid,model,url);
            };

            $scope.dele = function(index,boxIndex) {
                console.log("ok===============" + index)

                $scope.deleTargetTipsBox=true;
                $scope.tipsTitle = "删除提示"
                $scope.tipsContent = "确定删除此记录？";
                $scope.boxIndex = index
                $scope.deleIndex = boxIndex

            };

            $scope.deleConfirm = function() {
                var url
                if($scope.boxIndex =='1'){
                    var sid = $scope.deleIndex.id
                    url = "/ghprint-cms/prostocks/delprostocks.do?sid="+sid;
                    console.log("url================"+url)
                }else if($scope.boxIndex =='2'){
                    var cid = $scope.deleIndex.id
                    url = "/ghprint-cms/cartonstocks/delcartonstocks.do?cid="+cid;
                    console.log("url================"+url)
                }else if($scope.boxIndex =='3'){
                    var mid = $scope.deleIndex.id
                    url = "/ghprint-cms/materialstocks/delmaterialstocks.do?mid="+mid;
                }else{
                    console.log("尚未开发")

                    return
                }



                console.log("ok=============before")
                deleM(url,$scope.boxIndex);
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

            //首页
            $scope.p_index = function(){
                if( $rootScope.selectedName=="全部"){
                    $rootScope.searchKey = "";
                    $rootScope.selectValue = ""
                    searchProductList(1,"","");
                }else if( $rootScope.selectedName=="材料ID"){
                    searchProductList(1,"stockid",$rootScope.selectValue);
                }else if($rootScope.selectedName=="材料名称"){
                    searchProductList(1,"stockname",$rootScope.selectValue);
                }else if($rootScope.selectedName=="颜色"){
                    searchProductList(1,"color",$rootScope.selectValue);
                }else if($rootScope.selectedName=="编码"){
                    searchProductList(1,"id",$rootScope.selectValue);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            }

            //尾页
            $scope.p_last = function(){
                if( $rootScope.selectedName=="全部"){
                    $rootScope.searchKey = "";
                    $rootScope.selectValue = ""
                    searchProductList($scope.p_all_page2,"","");
                }else if( $rootScope.selectedName=="材料ID"){
                    searchProductList($scope.p_all_page2,"stockid",$rootScope.selectValue);
                }else if($rootScope.selectedName=="材料名称"){
                    searchProductList($scope.p_all_page2,"stockname",$scope.selectValue);
                }else if($rootScope.selectedName=="编码"){
                    searchProductList($scope.p_all_page2,"id",$rootScope.selectValue);
                }else if($scope.selectedName=="颜色"){
                    searchProductList($scope.p_all_page2,"color",$rootScope.selectValue);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            }

            //加载某一页
            $scope.backPage = function(){
                console.log("backPage")
                var currPage = $scope.p_current
                currPage--
                if(currPage==0){
                    currPage =1;
                }
                if( $rootScope.selectedName=="全部"){
                    $rootScope.searchKey = "";
                    $rootScope.selectValue = ""
                    searchProductList(currPage,"","");
                }else if( $rootScope.selectedName=="材料ID"){
                    searchProductList(currPage,"stockid",$rootScope.selectValue);
                }else if($rootScope.selectedName=="材料名称"){
                    searchProductList(currPage,"stockname",$rootScope.selectValue);
                }else if($rootScope.selectedName=="颜色"){
                    searchProductList(currPage,"color",$rootScope.selectValue);
                }else if($rootScope.selectedName=="编码"){
                    searchProductList(currPage,"id",$rootScope.selectValue);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            };

            $scope.nextPage = function(){
                var currPage = $scope.p_current
                currPage++
                if(currPage>=$scope.p_all_page){
                    currPage =$scope.p_all_page;
                }
                if( $rootScope.selectedName=="全部"){
                    $rootScope.searchKey = "";
                    $rootScope.selectValue = ""
                    searchProductList(currPage,"","");
                }else if( $rootScope.selectedName=="材料ID"){
                    searchProductList(currPage,"stockid",$rootScope.selectValue);
                }else if($rootScope.selectedName=="材料名称"){
                    searchProductList(currPage,"stockname",$rootScope.selectValue);
                }else if($rootScope.selectedName=="颜色"){
                    searchProductList(currPage,"color",$rootScope.selectValue);
                }else if($rootScope.selectedName=="编码"){
                    searchProductList(currPage,"id",$rootScope.selectValue);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            };

            //初始化页码
            var reloadPno = function(){
                $scope.pages=calculateIndexes($scope.p_current,$scope.p_all_page ,8);
            };

            function deleM(url,model) {
                console.log("ok=============")

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

                        if(model=='1'){

                            searchProductList(1,"","");
                        }else if(model=='2'){
                            searchBoxList(1,"","")
                        }else if(model=='3'){
                            searchAtomList(1,"","")
                        }
                    }else{
                        //查询角色列表失败
                        console.log("查询角色失败，请联系管理员！")
                    }

                }, function errorCallback(response) {
                    console.log(response);
                });
            }

            //=============2=======================




            //配置
            $scope.totalCount2 = 0;
            $scope.p_pernum2 = 10;
            //变量
            $scope.p_current2 = 1;
            $scope.p_all_page2 =0;

            //首页
            $scope.p_index2 = function(){
                if( $rootScope.selectedName2=="全部"){
                    $rootScope.searchKey2 = "";
                    $rootScope.selectValue2 = ""
                    searchBoxList(1,"","");
                }else if( $rootScope.selectedName2=="纸箱规格"){
                    searchBoxList(1,"boxsize",$rootScope.selectValue2);
                }else if($rootScope.selectedName2=="单价"){
                    searchBoxList(1,"price",$rootScope.selectValue2forNum);
                }else if($rootScope.selectedName2=="金额"){
                    searchBoxList(1,"amount",$rootScope.selectValue2forNum);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            }

            //尾页
            $scope.p_last2 = function(){
                if( $rootScope.selectedName2=="全部"){
                    $rootScope.searchKey2 = "";
                    $rootScope.selectValue2 = ""
                    searchBoxList($scope.p_all_page2,"","");
                }else if( $rootScope.selectedName2=="纸箱规格"){
                    searchBoxList($scope.p_all_page2,"boxsize",$rootScope.selectValue2);
                }else if($rootScope.selectedName2=="单价"){
                    searchBoxList($scope.p_all_page2,"price",$scope.selectValue2forNum);
                }else if($rootScope.selectedName2=="金额"){
                    searchBoxList($scope.p_all_page2,"amount",$rootScope.selectValue2forNum);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            }

            //加载某一页
            $scope.backPage2 = function(){
                var currPage = $scope.p_current
                currPage--
                if(currPage<=0){
                    currPage =1;
                }
                if( $rootScope.selectedName2=="全部"){
                    $rootScope.searchKey2 = "";
                    $rootScope.selectValue2 = ""
                    searchBoxList(currPage,"","");
                }else if( $rootScope.selectedName2=="纸箱规格"){
                    searchBoxList(currPage,"boxsize",$rootScope.selectValue2);
                }else if($rootScope.selectedName2=="单价"){
                    searchBoxList(currPage,"price",$rootScope.selectValue2forNum);
                }else if($rootScope.selectedName2=="金额"){
                    searchBoxList(currPage,"amount",$rootScope.selectValue2forNum);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            };
            $scope.nextPage2 = function(){
                var currPage = $scope.p_current
                currPage++
                if(currPage>=$scope.p_all_page){
                    currPage =$scope.p_all_page;
                }
                if( $rootScope.selectedName2=="全部"){
                    $rootScope.searchKey2 = "";
                    $rootScope.selectValue2 = ""
                    searchBoxList(currPage,"","");
                }else if( $rootScope.selectedName2=="纸箱规格"){
                    searchBoxList(currPage,"boxsize",$rootScope.selectValue2);
                }else if($rootScope.selectedName2=="单价"){
                    searchBoxList(currPage,"price",$rootScope.selectValue2forNum);
                }else if($rootScope.selectedName2=="金额"){
                    searchBoxList(currPage,"amount",$rootScope.selectValue2forNum);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            };

            //初始化页码
            var reloadPno2 = function(){
                $scope.pages2=calculateIndexes($scope.p_current2,$scope.p_all_page2 ,8);
            };

            //============3=================
            //配置
            $scope.totalCount3 = 0;
            $scope.p_pernum3 = 10;
            //变量
            $scope.p_current3 = 1;
            $scope.p_all_page3 =0;

            //首页
            $scope.p_index3 = function(){
                if( $rootScope.selectedName3=="全部"){
                    $rootScope.selectedName3 = "";
                    $rootScope.selectValue3 = ""
                    searchAtomList(1,"","");
                }else if( $rootScope.selectedName3=="供应商"){
                    searchAtomList(1,"provider",$rootScope.selectValue3);
                }else if($rootScope.selectedName3=="材料名称"){
                    searchAtomList(1,"name",$rootScope.selectValue3);
                }else if($rootScope.selectedName3=="金额"){
                    searchAtomList(1,"amount",$rootScope.selectValue3);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            }

            //尾页
            $scope.p_last3 = function(){
                if( $rootScope.selectedName3=="全部"){
                    $rootScope.searchKey3 = "";
                    $rootScope.selectValue3 = ""
                    searchAtomList($scope.p_all_page3,"","");
                }else if( $rootScope.selectedName3=="供应商"){
                    searchAtomList($scope.p_all_page3,"provider",$rootScope.selectValue3);
                }else if($rootScope.selectedName3=="材料名称"){
                    searchAtomList($scope.p_all_page3,"name",$rootScope.selectValue3);
                }else if($rootScope.selectedName3=="金额"){
                    searchAtomList($scope.p_all_page3,"amount",$rootScope.selectValue3);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            }

            //加载某一页
            $scope.backPage3 = function(page){
                var currPage = $scope.p_current
                currPage--
                if(currPage<=0){
                    currPage =1;
                }
                if( $rootScope.selectedName3=="全部"){
                    $rootScope.searchKey3 = "";
                    $rootScope.selectValue3 = ""
                    searchAtomList(currPage,"","");
                }else if( $rootScope.selectedName3=="供应商"){
                    searchAtomList(currPage,"provider",$rootScope.selectValue3);
                }else if($rootScope.selectedName3=="材料名称"){
                    searchAtomList(currPage,"name",$rootScope.selectValue3);
                }else if($rootScope.selectedName3=="金额"){
                    searchAtomList(currPage,"amount",$rootScope.selectValue3);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            };
            $scope.nextPage3 = function(){
                var currPage = $scope.p_current
                currPage++
                if(currPage>=$scope.p_all_page){
                    currPage =$scope.p_all_page;
                }



                if( $rootScope.selectedName3=="全部"){
                    $rootScope.searchKey3 = "";
                    $rootScope.selectValue3 = ""
                    searchAtomList(currPage,"","");
                }else if( $rootScope.selectedName3=="供应商"){
                    searchAtomList(currPage,"provider",$rootScope.selectValue3);
                }else if($rootScope.selectedName3=="材料名称"){
                    searchAtomList(currPage,"name",$rootScope.selectValue3);
                }else if($rootScope.selectedName3=="金额"){
                    searchAtomList(currPage,"amount",$rootScope.selectValue3);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            };

            //初始化页码
            var reloadPno3 = function(){
                $scope.pages3=calculateIndexes($scope.p_current3,$scope.p_all_page3,8);
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
                    console.log("==========indexes"+indexes);
                }
                console.log("==========ok?"+indexes);
                return indexes;
            };




        //    ===========只能输入小数后两位==================
            function clearNoNum(obj){
                obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数
                if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额
                    obj.value= parseFloat(obj.value);
                }
            }
        },
        tpl: tpl
    };
});