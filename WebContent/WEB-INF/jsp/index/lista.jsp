<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Usuário</title>
</head>
<body>
	<c:forEach items="${usuarioList}" var="usuario">
		<tr>
			<td>${usuario.nome}</td>
			<td>${usuario.matricula}</td>
			<td><a href="edita?id=${usuario.id}">Editar</a></td>
			<td><a href="remove?id=${usuario.id}">Remover</a></td>
		</tr>
	</c:forEach>
	
</body>
</html>