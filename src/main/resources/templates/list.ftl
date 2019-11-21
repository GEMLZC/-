<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>员工列表</title>
</head>
<body>
<h3><a href="/emp/input">新增</a></h3>
<form action="/emp/list" method="post">
    关键字:<input type="text" name="keyword" value="${(qo.keyword)! }"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    薪资：<input type="text" name="minSalary" value="${(qo.minSalary)! }"/>&nbsp;&nbsp;-&nbsp;&nbsp;
    <input type="text" name="maxSalary" value="${(qo.maxSalary)! }"/>&nbsp;&nbsp;
    <input type="button" onclick="sub1()" value="查询"/>
    <table border="1">
        <tr>
            <th>员工序号</th>
            <th>员工名称</th>
            <th>员工邮箱</th>
            <th>员工年龄</th>
            <th>员工薪资</th>
            <th>操作</th>
        </tr>
        <#list result.list as e>
             <tr>
                 <td>${e_index+1}</td>
                 <td>${e.name !}</td>
                 <td>${e.email !}</td>
                 <td>${e.age !}</td>
                 <td>${e.salary !}</td>
                 <td><a href="/emp/input?id=${e.id! }">编辑</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                     <a href="javascript:deleteData(${e.id!})">删除</a></td>
             </tr>
        </#list>
    </table>
    <a href="javascript:sub(1)">首页</a>&nbsp;&nbsp;&nbsp;
    <a href="javascript:sub(${(result.prePage)! })">上一页</a>&nbsp;&nbsp;&nbsp;
    <a href="javascript:sub(${(result.nextPage)! })">下一页</a>&nbsp;&nbsp;&nbsp;
    <a href="javascript:sub(${(result.pages)! })">尾页</a>&nbsp;&nbsp;&nbsp;
    当前第${(result.pageNum)! }页/共${(result.pages)! }页&nbsp;&nbsp;&nbsp;
    共条${(result.total)! }数据&nbsp;&nbsp;&nbsp;
    <input type="number" min="1" max="${(result.pages)! }" name="currentPage" id="pageNo" value="${(result.pageNum)!}"/>&nbsp;&nbsp;&nbsp;
    <input type="submit" value="提交"/>
</form>
<script type="text/javascript">
    function sub(pageNo) {
        document.getElementById('pageNo').value = pageNo;
        document.forms[0].submit();
    }

    function sub1() {
        document.getElementById('pageNo').value = 1;
        document.forms[0].submit();
    }

    function deleteData(id) {
        if (!confirm("你确定要删除吗？"))
            return false;
        location.href = "http://localhost:8080/emp/remove?id=" + id;
    }
</script>
</body>
</html>