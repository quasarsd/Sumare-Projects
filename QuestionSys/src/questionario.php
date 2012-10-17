<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="folhaDeEstilo.css">
<title>Trab-Compiladores</title>
</head>
<body>

<?php
	include("logo.php");

if((isset($_GET['idques'])) and (isset($_GET['iduser'])))
{
	$idques = ($_GET['idques']);
	$iduser = ($_GET['iduser']);
}else
	{
		$idques = '';
		$iduser = '';
	}
?>

<h5><a href="admin.php">Administra&ccedil;&atilde;o</a></5h>
<?php 
include("bd_conexao.php");
mysql_select_db($banco,$conectar);

//------Exibe SOMATORIO DO PESO DAS escolhas ---------------	
	$escolhas = mysql_query("SELECT sum(esc.pesos) AS somatorio, qst.nome_questionario AS titulo_questionario
							FROM escolhas esc
							INNER JOIN questionarios qst ON (qst.id_questionarios = esc.id_questionarios)
							WHERE esc.id_usuarios = '.$iduser.' AND esc.id_questionarios = '.$idques.'")or die (mysql_error());
	while ($exibe_escolhas = mysql_fetch_array($escolhas))
	{
	echo '<h1>'. $exibe_escolhas['titulo_questionario'].' </h1>';
	if($exibe_escolhas['somatorio']>=30)
	{
		echo '<h3><font color="#0000FF" style="font-family:Geneva, Arial, Helvetica, sans-serif">Excelente!<br />Resutado Final: <u>'.$exibe_escolhas['somatorio'].' pontos</u></font></h3>';
	}elseif($exibe_escolhas['somatorio']>=11 && $exibe_escolhas['somatorio']<=29)
	{
		echo '<h3><font color="#0000FF" style="font-family:Geneva, Arial, Helvetica, sans-serif">Razoavel<br />Resutado Final: <u>'.$exibe_escolhas['somatorio'].'pontos</u></font></h3>';
	}elseif($exibe_escolhas['somatorio']>=0 && $exibe_escolhas['somatorio']<=10)
	{
		echo '<h3><font color="#0000FF" style="font-family:Geneva, Arial, Helvetica, sans-serif">Ruim<br />Resutado Final: <u>'.$exibe_escolhas['somatorio'].'pontos</u></font></h3>';
	}
	}
//---fim---Exibe SOMATORIO DO PESO DAS escolhas ---------------		


				
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
									AND rps.id_questionarios = '.$idques.'")or die (mysql_error());
		  
		  
		  						
		  echo '<form method="post" action="criacao.php?calc_peso=cpeso&amp;iduser='.$iduser.'&amp;idques='.$idques.'" >';
		  while ($exibe_respostas = mysql_fetch_array($respostas))
		  {
			echo '<tr>
				 <th scope="col" bgcolor="#0099FF"><input type="radio" name="idresp" id="idresp" value="'.$exibe_respostas['id_respostas'].'">'.$exibe_respostas['respostas'].'
				  </th>
				  </tr>
				  <tr>';
		  }
		  
		/*$resposta_escolhida = mysql_query("SELECT * 
										   FROM escolhas
										   WHERE id_questionarios = '.$idques.' AND id_usuarios = '.$iduser.' AND id_perguntas = 1")or die (mysql_error());
		  		  while ($verifica_resposta = mysql_fetch_array($resposta_escolhida))
		  {
			echo $verifica_resposta['id_respostas'].'<br />';
		  }*/
		  
		  
		echo '</table>
			  <center><input type="submit" value="<<.Enviar resposta.>>" /></center>
			  </form>
			  <hr>';
	}
?>

</body>
</html>