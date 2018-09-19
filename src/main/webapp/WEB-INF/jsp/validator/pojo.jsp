<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/18 0018
  Time: 下午 5:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSR-303</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            //请求验证的POJO
            var pojo = {
                id : null,
                date : '2018-08-08',
                doubleValue : 999999.09,
                integer : 100,
                range : 1000,
                email : 'email',
                size : 'adv1212',
                regexp : 'a,b,c,d'
            }
            $.post({
                url : "./validate",
                //传递参数类型 JSON ，不能缺少
                contentType : "application/json",
                //将json转化为字符串传递
                data : JSON.stringify(pojo),
                //成功后的方法
                success : function () {

                }
            });
        });
    </script>
</head>
<body>

</body>
</html>
