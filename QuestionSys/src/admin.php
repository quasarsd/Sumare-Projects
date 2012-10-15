<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="folhaDeEstilo.css">
<title>Administra&ccedil;&atilde;o do question&aacute;rio</title>
</head>

<body>
<h5><a href="questionario.php">Voltar</a></h5>
<h1>Administra&ccedil;&atilde;o do question&aacute;rio</h1>
<h2>Formulario de cria&ccedil;&atilde;o de question&aacute;rio</h2>

<form method="post" action="criacao.php?pgt=npgt" >
    <h4>Pergunta: </h4>
    <input type="text" id="pergunta" name="pergunta" size="80" />
    <input type="submit" value="Postar" />
    <input type="reset" value="Apagar" />
</form>

<?php 
if(isset($_GET['idper']))
{
	$idper = $_GET['idper'];
}else
	$idper = 'erro';
?>

	  <form method="post" action="criacao.php?resp=nresp" >

        	<h4>Resposta: </h4>
			<input type="text" id="resposta" name="resposta" size="80" />

        	<h4>Peso: </h4>
        	<input type="text" id="peso_resp" name="peso_resp" size="3" maxlength="3" />

     <input type="submit" value="Postar" />
     <input type="reset" value="Apagar" />
     </form>

<?php
include("bd_conexao.php");
mysql_select_db($banco,$conectar);

 $perguntas_respostas = mysql_query("SELECT * 
									FROM perguntas") or die (mysql_error());
 echo'<table border="1" width="600px;">
 	  <tr>';
		  	  
	while ($exibir_per_rep = mysql_fetch_array($perguntas_respostas))
    {
	echo '<tr>
    	  <th colspan="2" scope="col" bgcolor="#99CC66"><br /><u>'.$exibir_per_rep['perguntas'].'</u></th>
  		  </tr>';
	  
	  $respostas = mysql_query("SELECT DISTINCT rps.respostas, ps.pesos
								FROM respostas rps
								INNER JOIN pesos ps ON (ps.id_respostas = rps.id_respostas)
								WHERE rps.id_perguntas = ".$exibir_per_rep['id_perguntas']."")or die (mysql_error());
								
	  while ($exibe_respostas = mysql_fetch_array($respostas))
	  {
	  	echo '<tr>
			  <td scope="col"  bgcolor="#0099FF">'.$exibe_respostas['respostas'].'</td>';
	  
		echo '<td bgcolor="#9999FF">'.$exibe_respostas['pesos'].'</td>
			  </tr>';
	  }
	}
	 	echo'</table>';
?>
</body>
</html>