define(['angular', 'text!five/warehouse/warehouse.html'], function (angular, tpl) {
    //angular会自动根据controller函数的参数名，导入相应的服务
    return {
        controller: function ($rootScope,$scope,$location, $routeParams, $http, $interval) {
            //if(!$rootScope.username){
            //    $location.path("/login")
            //}

            //做法：先把3个模块的增删改查函数分开

            //$scope.newProduct.customerid = ""
            //纸箱新增变量
            //$scope.newPaperBox.boxsize = ""
            //     $scope.newPaperBox.count =""
            //     $scope.newPaperBox.packages = ""
            //     $scope.newPaperBox.price =""
            //     $scope.newPaperBox.amount =""
            //不同的模块搜索变量
            $scope.searchKey3="";
            $scope.selectValue3="";
            $scope.searchKey2="";
            $scope.selectValue2="";
            $scope.searchKey="",
                $scope.selectValue = ""
            $scope.selectOption1 = ["全部","编码","材料ID", "材料名称", "颜色"];
            $scope.selectOption2 = ["全部","单价", "金额", "纸箱规格"];
            $scope.selectOption3 = ["全部","供应商", "材料名称", "金额"];
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

                        console.log( $scope.p_all_page2+"共几多页")
                        console.log( $scope.p_current2+"当前页是第几页")
                        console.log( $scope.totalCount2+"共几多条记录")
                        reloadPno2();

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

                        reloadPno3();

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

                            reloadPno1();

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
                    $scope.searchKey3 = "";
                    $scope.selectValue3 = ""
                    searchAtomList(1,"","");
                }else if( $scope.selectedName3=="供应商"){
                    $scope.searchKey = "provider"
                    searchAtomList(1,"provider",$scope.selectValue3);
                }else if($scope.selectedName3=="材料名称"){
                    $scope.searchKey = "name"
                    searchAtomList(1,"name",$scope.selectValue3);
                }else if($scope.selectedName3=="金额"){
                    $scope.searchKey = "amount"
                    searchAtomList(1,"amount",$scope.selectValue3);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            };


            $scope.searchOnKeyBox = function() {
                console.log("$scope.selectedName2======="+$scope.selectedName2)

                if( $scope.selectedName2=="全部"){
                    $scope.searchKey = "";
                    $scope.selectValue = ""
                    searchBoxList(1,"","");
                }else if( $scope.selectedName2=="纸箱规格"){
                    $scope.searchKey = "boxsize"
                    searchBoxList(1,"boxsize",$scope.selectValue2);
                }else if($scope.selectedName2=="单价"){
                    $scope.searchKey = "price"
                    searchBoxList(1,"price",$scope.selectValue2forNum);
                }else if($scope.selectedName2=="金额"){
                    $scope.searchKey = "amount"
                    searchBoxList(1,"amount",$scope.selectValue2forNum);
                }else{

                    console.log("系统出错，请联系管理员")
                }
            };


            $scope.searchOnKey = function(index) {

                if( $scope.selectedName=="全部"){
                    $scope.searchKey = "";
                    $scope.selectValue = ""
                    searchProductList(1,$scope.searchKey,$scope.selectValue);
                }else if( $scope.selectedName=="材料ID"){
                    $scope.searchKey = "stockid"
                    searchProductList(1,"stockid",$scope.selectValue);
                }else if($scope.selectedName=="材料名称"){
                    $scope.searchKey = "stockname"
                    searchProductList(1,"stockname",$scope.selectValue);
                }else if($scope.selectedName=="颜色"){
                    $scope.searchKey = "color"
                    searchProductList(1,"color",$scope.selectValue);
                }
                console.log("系统出错，请联系管理员")
            };

            $scope.app = function(index) {
                console.log("你点击了"+index)
            };

            $scope.searchPage = function(index) {
                console.log("你点击了第"+index+"页")
            };



            $scope.edit = function(index,model) {

                var url
                var sid
                if(model=='1'){
                    $scope.ModifyGoods=true;
                    sid = $scope.companyData[index].id
                    console.log("sid--------------------"+sid)
                    url= baseUrl+ "/ghprint-cms/prostocks/editprostocks.do?sid="+sid;


                }else if(model=='2'){
                    $scope.ModifyBoxCount = true;
                    sid = $scope.paperBoxData[index].id
                    url= baseUrl+ "/ghprint-cms/cartonstocks/editcartonstocks.do?cid="+sid;

                }else if(model=='3'){
                    //sid = $scope.paperBoxData[index].id
                    //url= baseUrl+ "/ghprint-cms/cartonstocks/editcartonstocks.do?cid="+sid;
                    $scope.Modifycompany = true;
                    sid = $scope.AtomData[index].id
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
                    var sid = $scope.companyData[$scope.deleIndex].id
                    url = "/ghprint-cms/prostocks/delprostocks.do?sid="+sid;
                    console.log("url================"+url)
                }else if($scope.boxIndex =='2'){
                    var cid = $scope.paperBoxData[$scope.deleIndex].id
                    url = "/ghprint-cms/cartonstocks/delcartonstocks.do?cid="+cid;
                    console.log("url================"+url)
                }else if($scope.boxIndex =='3'){
                    var mid = $scope.AtomData[$scope.deleIndex].id
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
                if($scope.searchKey&&$scope.selectValue){

                    searchProductList(1,$scope.searchKey,$scope.selectValue);
                }else{
                    searchProductList(1,"","");

                }
            }

            //尾页
            $scope.p_last = function(){
                if($scope.searchKey&&$scope.selectValue){

                    searchProductList($scope.p_all_page,$scope.searchKey,$scope.selectValue);
                }else{
                    searchProductList($scope.p_all_page,"","");
                }
            }

            //加载某一页
            $scope.load_page = function(page){
                if($scope.searchKey && $scope.selectValue){
                    searchProductList(page,$scope.searchKey,$scope.selectValue);
                }else{
                    searchProductList(page,"","");}
            };

            //初始化页码
            var reloadPno1 = function(){
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
                if($scope.searchKey2&&$scope.selectValue2){

                    searchBoxList($scope.searchKey2,$scope.selectValue2);
                }else{
                    searchBoxList(1,"","");

                }
            }

            //尾页
            $scope.p_last2 = function(){
                if($scope.searchKey2&&$scope.selectValue2){

                    searchBoxList($scope.p_all_page2,$scope.searchKey2,$scope.selectValue2);
                }else{
                    searchBoxList($scope.p_all_page2,"","");
                }
            }

            //加载某一页
            $scope.load_page2 = function(page){
                if($scope.searchKey && $scope.selectValue2){
                    searchBoxList(page,$scope.searchKey2,$scope.selectValue2);
                }else{
                    searchBoxList(page,"","");}
            };

            //初始化页码
            var reloadPno2 = function(){
                $scope.pages=calculateIndexes($scope.p_current2,$scope.p_all_page2 ,8);
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
                if($scope.searchKey3&&$scope.selectValue3){

                    searchAtomList(1,$scope.searchKey3,$scope.selectValue3);
                }else{
                    searchAtomList(1,"","");
                }
            }

            //尾页
            $scope.p_last3 = function(){
                if($scope.searchKey3&&$scope.selectValue3){

                    searchAtomList($scope.p_all_page3,$scope.searchKey3,$scope.selectValue3);
                }else{
                    searchAtomList($scope.p_all_page3,"","");
                }
            }

            //加载某一页
            $scope.load_page3 = function(page){
                if($scope.searchKey3&&$scope.selectValue3){

                    searchAtomList(page,$scope.searchKey3,$scope.selectValue3);
                }else{
                    searchAtomList(page,"","");
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