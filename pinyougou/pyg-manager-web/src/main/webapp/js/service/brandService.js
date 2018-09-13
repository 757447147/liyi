//服务层
app.service("brandService",function ($http) {
    //条件分页查询
    this.search = function(page,rows,searchEntity) {
        return $http.post("../brand/search.do?page=" + page + "&rows=" + rows, searchEntity);
    }

    //新增
    this.add = function (entity) {
        return $http.post("../brand/add.do",entity);
    }

    //更新
    this.update = function (entity) {
        return $http.post("../brand/update.do",entity);
    }

    //根据主键查询
    this.findOne = function (id) {
        return $http.get("../brand/findOne.do?id="+id);
    }

    //批量删除
    this.delete = function (ids) {
        return $http.get("../brand/delete.do?ids="+ids);

    }
    //查询品牌列表
    this.selectOptionList = function () {
        return $http.get("../brand/selectOptionList.do");
    };
});