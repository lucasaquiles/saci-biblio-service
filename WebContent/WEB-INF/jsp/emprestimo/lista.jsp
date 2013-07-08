<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
	table{
	
		padding:5px;
	}
	table tr{
		padding:5px;
	}
	table td{
		border:solid 1px #ccc;
	}
</style>
</head>
<body>

<table>

	<c:forEach items="${emprestimoList}" var="emprestimo">
		<tr>
			<td>${emprestimo.id}</td>
			<td>
				<table >
					<tr>
						<th>Livro</th>
					</tr>
					<c:forEach items="#{emprestimo.livros}" var="livro">
						<tr>
							<td>
								${ livro.titulo }
							</td>
							
							<td>
								 <a href="removeItem?id=${emprestimo.id}&livroId=${livro.id}">remover esse item?</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>