<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Livro</title>
</head>
<body>
	<form action="altera">
	<fieldset>
	<legend>Editar Livro</legend>
	
	
	<input type="hidden" name="emprestimo.id" value="${emprestimo.id}" />
	
	<label>QUantidade de itens ${ emprestimo.livros }</label>
	
	<button type="submit">Enviar</button>
	</fieldset>
	</form>


</body>
</html>