<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Livro</title>
</head>
<body>
	<c:forEach items="${livroList}" var="livro">
		<tr>
			<td>${livro.titulo}</td>
			<td>${livro.quantidade}</td>
			<td><a href="livro/edita?id=${livro.id}">Editar</a></td>
			<td><a href="livro/remove?id=${livro.id}">Remover</a></td>
		</tr>
	</c:forEach>
	
</body>
</html>