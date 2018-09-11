//控制层
app.controller("brandController",function ($scope,$controller,brandService) {

    //继承baseController
    $controller("baseController",{$scope:$scope});

    //初始化查询条件
    $scope.searchEntity = {};
    //条件分页查询
    $scope.search = function(page,rows){
        brandService.search(page,rows,$scope.searchEntity)
            .success(function (response) {
                //更新记录列表
                $scope.list=response.rows;
                //更新总记录数
                $scope.paginationConf.totalItems=response.total;
            });
    };

    //分页查询
    /* $scope.findPage = function(page,rows){
         $http.get("../brand/findPage.do?page="+page+"&rows="+rows)
             .success(function (response) {
                 //更新记录列表
                 $scope.list=response.rows;
                 //更新总记录数
                 $scope.paginationConf.totalItems=response.total;
             })
     };*/

    //查询所有
    /* $scope.findAll = function () {
         $http.get("../brand/findAll.do")
             .success(function (response) {
                 $scope.list = response;
             })
     };*/

    //保存品牌
    $scope.save = function () {
        var obj;

        if($scope.entity.id!=null){
            obj = brandService.update($scope.entity);
        }else {
            obj = brandService.add($scope.entity);
        }
        obj.success(function (response) {
            if(response.success){
                $scope.reloadList();
                alert(response.message);
            }else{
                alert(response.message);
            }
        })
    };

    //根据id查询品牌并回显数据
    $scope.findOne = function (id) {
        brandService.findOne(id)
            .success(function (response) {
                $scope.entity = response;
            })
    };


    //批量删除
    $scope.delete = function () {
        if($scope.selectedIds.length==0){
            alert("请选择！")
            return;
        }
        if(confirm("确定要删除选中的记录吗？")){
            brandService.delete($scope.selectedIds).success(function (response) {
                if(response.success){
                    $scope.reloadList();
                    alert(response.message);
                    $scope.selectedIds = [];
                }else {
                    alert(response.message);
                }
            })
        }

    };
})