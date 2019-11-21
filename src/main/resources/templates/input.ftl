<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>保存新增</title>
</head>
<body>
	<form action="/emp/save" method="post">
		<input type="hidden" name="id" value="${(emp.id)!}"/>
		员工名称:<input type="text" name="name" value="${(emp.name)! }"/><br/>
        <#if !emp??>
			员工密码：<input type="password" name="password" value=""${(emp.password)!}/><br/>
        </#if>
		员工邮箱：<input type="text" name="email" value="${(emp.email)! }"/><br/>
		员工年龄：<input type="text" name="age" value="${(emp.age)! }"/><br/>
		员工薪资：<input type="text" name="salary" value="${(emp.salary)! }"/><br/>
		<input type="submit"  value="保存"/>
	</form>
</body>
</html>