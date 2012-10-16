<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Prova</title>
</head>
<body>
<form method="post">
Pergunta <input type="text" id="pergunta" name="pergunta"style=" width : 500px;"/>
<br />
Peso 
<select id="peso">
	<option>0.5</option>	
	<option>01</option>	
	<option>02</option>	
	<option>03</option>	
	<option>04</option>	
	<option>05</option>	
	<option>06</option>
	<option>07</option>
	<option>08</option>
	<option>09</option>
	<option>10</option>
</select>
<br /><br />

<table>
<tr><td>Respostas</td></tr>
<tr><td>#</td><td>Descrição</td><td>Correta</td></tr>
<tr>
	<td>1</td>
	<td><input type="text" name="descricao" /></td>
	<td><input type="checkbox" name="correta" /></td>
</tr>
<tr>
	<td>2</td>
	<td><input type="text" name="descricao" /></td>
	<td><input type="checkbox" name="correta" /></td>
</tr>
<tr>
	<td>3</td>
	<td><input type="text" name="descricao" /></td>
	<td><input type="checkbox" name="correta" /></td>
</tr>
<tr>
	<td>4</td>
	<td><input type="text" name="descricao" /></td>
	<td><input type="checkbox" name="correta" /></td>
</tr>
</table>
<input type="submit" value="Incluir"  />

</form>

</body>
</html>