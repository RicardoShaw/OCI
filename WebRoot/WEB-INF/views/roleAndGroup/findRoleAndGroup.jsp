<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'addRole.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <h2>Student Information</h2>
   
   
<form:form method="POST" action="find" commandName="roleAndGroupSearcher">
<form:errors path="*" cssClass="errorStyle" element="div" />
<table>
<tr>
        <td>groupname：</td>
        <td><form:input path="groupName" /></td>
        <td><form:errors path="groupName" cssClass="error" /></td>
	
        <td>rolename：</td>
        <td><form:input path="roleName" /></td>
        <td><form:errors path="roleName" cssClass="error" /></td>

        <td colspan="2">
            <input type="submit" value="查询"/>
        </td>
   </tr>
</table>  
</form:form>
   
   

<table>
	<c:forEach var="roleAndGroup" items="${roleAndGroups}">
	<tr>
		<td><c:out value="${roleAndGroup.roleGroupId}"></c:out></td>
		<td><c:out value="${roleAndGroup.group.groupId}"></c:out></td>
		<td><c:out value="${roleAndGroup.group.groupName}"></c:out></td>
		
		<td><c:out value="${roleAndGroup.role.roleId}"></c:out></td>
		<td><c:out value="${roleAndGroup.role.roleName}"></c:out></td>

		<td><a href="update/${roleAndGroup.roleGroupId}">更新</a>	
		<td><a href="delete/${roleAndGroup.roleGroupId}">删除</a>	
	</tr>
	</c:forEach>
</table>
  </body>
</html>
