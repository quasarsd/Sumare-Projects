<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="folhaDeEstilo.css">
<title>Administra&ccedil;&atilde;o</title>
</head>

<body>
<?php
	include("logo.php");
?>
<table border="1">
<form method="post" action="login.php?ok=ok" >
  <tr>
    <th colspan="2" scope="col" align="center">Logar</th>
  </tr>
  <tr>
    <th scope="row">Nome</th>
    <td><input type="text" id="nome" name="nome" /></td>
  </tr>
  <tr>
    <th scope="row">Email</th>
    <td><input type="text" id="email" name="email" /></td>
  </tr>
  <tr>
    <td colspan="2" align="center">
    <input type="submit" value="Entrar" />
    <input type="reset" value="Limpar" />
    </td>
    </tr>
</form>
</table>
<center>
<a href="index.php?cadastro=ok">Cadastro</a>

<?php
include("bd_conexao.php");
mysql_select_db($banco,$conectar);

if(isset($_GET['msg']) != '')
{
	echo '<br /><font color="#FFFFFF">'.$_GET['msg'].'</font>';
}

if(isset($_GET['cadastro']) == 'ok')
{
	echo '<form action="cadastro.php" method="post" name="cadastro">
			<label>Nome: </label>
			<input type="text" id="nome" name="nome" />
			<br />
            <label>Email: </label>
            <input type="text" id="email" name="email" />';
	$lista_questionario = mysql_query("SELECT *
 								   FROM questionarios")or die (mysql_error());
	
	echo '<br />
          <label>Questionarios: </label>
		  <select name="questionario" styleId=="questionario">';
	while ($exibe_questionario = mysql_fetch_array($lista_questionario))
	{
		echo '<option value="'.$exibe_questionario['id_questionarios'].'">'.$exibe_questionario['nome_questionario'].'</option>';
	}
	echo '</select>';
	echo '<br />
		   <input type="submit" value="Cadastrar" />
		  </form>';
}

?>

</center>

</body>
</html>