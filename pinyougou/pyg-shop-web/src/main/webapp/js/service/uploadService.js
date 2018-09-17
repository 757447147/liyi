app.service("uploadService",function ($http) {

    this.uploadFile = function () {
        var formData = new FormData();
        formData.append("file", file.files[0]);
        return $http({
            url:"../upload.do",
            method:"post",
            data:formData,
            //因为angularJs对于post和get请求默认的Content-Type是application/json。
            //通过将其设为undefined，这样浏览器会把Content-Type转换并设置为multipart/form-data
            //但是js又不能直接设置multipart/form-data
            headers:{"Content-Type": undefined},
            transformRequest: angular.identity
        });
    };
});