<?php
	include("bd_conexao.php");
	mysql_select_db($banco,$conectar);

	$usuario	  = ($_POST['nome']);
	$email 		  = ($_POST['email']);
	$questionario = ($_POST['questionario']);

	$nova_pergunta = mysql_query("INSERT INTO usuarios(nome, email, id_questionarios) VALUES ('$usuario', '$email', '$questionario');") or die (mysql_error());
	//$id_per = mysql_insert_id();
	
 header('Location:index.php?msg=Cadastro Realizado com Sucesso!');

?>