<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="folhaDeEstilo.css">
<title>Trab-Compiladores</title>
</head>

<body>
<a href="admin.php"><h5>Administra&ccedil;&atilde;o</5h></a>
<h1>Question&aacute;rio</h1>
<?php 
include("bd_conexao.php");
mysql_select_db($banco,$conectar);

if(isset($_GET['idques']))
{
	$idques = ($_GET['idques']);
}else
	{
		$idques = 5;
	}
				
 $perguntas_respostas = mysql_query("SELECT * 
									FROM perguntas
									WHERE id_questionarios = '.$idques.'") or die (mysql_error());
		  	  
	while ($exibir_per_rep = mysql_fetch_array($perguntas_respostas))
    {	
		echo '<table border="1" width="600px;">
 	  	  	 <tr>
		  	 <th scope="col"  bgcolor="#009699"><br /><u>'.$exibir_per_rep['perguntas'].'</u></th>
		  	 </tr>';  
		  $respostas = mysql_query("SELECT DISTINCT rps.respostas, rps.id_respostas, ps.pesos, ps.id_pesos
									FROM respostas rps
									INNER JOIN pesos ps ON (ps.id_respostas = rps.id_respostas)
									WHERE rps.id_perguntas = ".$exibir_per_rep['id_perguntas']."
									AND rps.id_questionarios = 0")or die (mysql_error());
		  
		  
		  						
		  echo '<form method="post" action="criacao.php?calc_peso=cpeso&iduser=9&idques=5" >';	//pegar id usuario e id questionario vindo do login
		  while ($exibe_respostas = mysql_fetch_array($respostas))
		  {
			echo '<tr>
				  <th scope="col" bgcolor="#0099FF">'.$exibe_respostas['id_respostas'].')  '.$exibe_respostas['respostas'].'</th>
				  </tr>
				  <tr>';
		  }
		echo '<th bgcolor="#9999FF">Indique a resposta correta: 
		      <input type="text" id="idresp" name="idresp" size="1" maxlength="2" value="'.$exibir_per_rep['id_pesos'].'"/></th>
		   	  </table>
			  <center><input type="submit" value="<<.Enviar resposta.>>" /></center>
			  </form>
			  <hr>';
	}	 	
?>
</body>
</html>