<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar Livro</title>
</head>
<body>
	<form action="adiciona" >
		<fieldset>
			<legend>Adicionar Livro</legend>
				<label for="titulo">Titulo:</label>
				<input id="titulo" type="text" name="livro.titulo"/>
				
				<label for="descricao">Descrição:</label>
				<input id="descricao" name="livro.descricao"/>
				
				<label for="quantidade">Quantidade:</label>
				<input id="quantidade" type="text" name="livro.quantidade"/>
				<button type="submit">Enviar</button>
		</fieldset>
	</form>
	
</body>
</html>