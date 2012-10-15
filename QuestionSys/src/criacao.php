<?php
include("bd_conexao.php");
mysql_select_db($banco,$conectar);



if(isset($_GET['pgt'])=='npgt')
{	
	$pergunta = ($_POST['pergunta']);

	$nova_pergunta = mysql_query("INSERT INTO perguntas (perguntas) VALUES ('$pergunta');") or die (mysql_error());
	//$id_per = mysql_insert_id();
	
	header('Location:admin.php');
}

elseif(isset($_GET['resp'])=='nresp')
{		
		$resposta = ($_POST['resposta']);
		$peso = ($_POST['peso_resp']);
		
		$ultima_pergunta = mysql_query("SELECT id_perguntas
										FROM perguntas
										ORDER BY id_perguntas DESC
										LIMIT 1");
										while($id_per =  mysql_fetch_array($ultima_pergunta))
										{

		$nova_resposta = mysql_query("INSERT INTO respostas(id_perguntas, respostas) VALUES (".$id_per['id_perguntas'].",'$resposta');");
		$id_resposta = mysql_insert_id();
										
		
		$novo_peso = mysql_query("INSERT INTO pesos(id_perguntas, id_respostas, pesos) VALUES (".$id_per['id_perguntas'].", '$id_resposta', '$peso');");
										}
		header('Location:admin.php');
}

elseif(isset($_GET['calc_peso'])=='cpeso')
{		
		if(isset($_POST['idresp']))
		{
			$id_resposta = ($_POST['idresp']);
		}else
			{
			$id_resposta = "erro";
			}
			
			$id_questionarios = ($_GET['idques']);
			$id_usuarios = ($_GET['iduser']);
			$peso = 1;
			
			$pega_pesos = mysql_query("SELECT ps.pesos, pgs.id_perguntas
										FROM pesos ps
										INNER JOIN perguntas pgs ON(pgs.id_perguntas = ps.id_perguntas)
										WHERE id_respostas = ".$id_resposta."");
			while($id_pes = mysql_fetch_array($pega_pesos))
			{

				$nova_escolha = mysql_query("INSERT INTO escolhas(id_usuarios, id_questionarios, id_perguntas, id_respostas, id_pesos) VALUES ('$id_usuarios', '$id_questionarios', ".$id_pes['id_perguntas'].", '$id_resposta', ".$id_pes['pesos'].");");
			}
			header('Location:questionario.php');
}
else
		echo "Erro no envio!<br /><a href= 'javascript:history.back()'>Voltar</a>";
?>