<?php
include("bd_conexao.php");
mysql_select_db($banco,$conectar);

if(isset($_GET['ok'])=='ok')
{
	//echo 'Fun��o logar ok';
	
		$nome = ($_POST['nome']);
		$email = ($_POST['email']);
	
	$verifica_login = mysql_query('SELECT *
									FROM usuarios
									WHERE nome = "'.($_POST['nome']).'" AND email = "'.($_POST['email']).'"') or die(mysql_error());
										while($qtd_usuario =  mysql_fetch_array($verifica_login))
										{
											if($qtd_usuario > 0){
																//echo '<br />'.$qtd_usuario['nome'].'<br />'.$qtd_usuario['email'];
																
																header("Location:questionario.php?idques=".$qtd_usuario['id_questionarios']."&iduser=".$qtd_usuario['id_usuarios']."");
																}
																else
																	header("Location:index.php?noticia=Usuario n�o encontrado");
										}
																			
										
}else{
		echo 'Erro ao logar!';
	}


?>