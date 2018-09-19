<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/18 0018
  Time: 上午 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增用户</title>
    <%--加载jqury文件--%>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            alert("11");
            $("#submit").click(function () {
                var userName = $("#userName").val();
                var note = $("#note").val();
                if($.trim(userName)==''){
                    alert("用户名不能为空！");
                    return;
                }
                var params = {
                    userName : userName,
                    note : note
                }
                $.post({
                    url : "./insert",
                    //此处需要告知传递参数类型为JSON，不能缺少
                    contentType : "application/json",
                    //将JSON转化为字符串传递
                    data : JSON.stringify(params),
                    //成功后的方法
                    success : function (result) {
                        if(result == null || result.id == null){
                            alert("插入失败");
                            return;
                        }
                        alert("插入成功");
                    }
                });
            });
        })
    </script>
</head>
<body>
    <div style="margin: 20px 0;"></div>
    <form id="isertForm">
        <table>
            <tr>
                <td>用户名称：</td>
                <td><input id="userName" name="userName"/></td>
            </tr>
            <tr>
                <td>备注</td>
                <td><input id="note" name="note"></td>
            </tr>
            <tr>
                <td></td>
                <td align="right"><input id="submit" type="button" value="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
