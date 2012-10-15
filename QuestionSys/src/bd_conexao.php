<?php
//Conexão com banco de dados do site
$host      = "localhost";
$user     = "root";
$user_pass = "";
$banco     = "bd_questoes";

$conectar = mysql_connect($host,$user,$user_pass);

/* Testa conexão
if($conectar==true){
echo "Conectado com sucesso!";
}else{
echo "Falha na conexão!";  
}
*/
?>
	<!--SELECT DISTINCT pgs.perguntas, pgs.id_perguntas, rps.respostas, ps.pesos
										FROM respostas rps
										INNER JOIN perguntas pgs ON (pgs.id_perguntas = rps.id_perguntas)
										INNER JOIN pesos ps ON (ps.id_respostas = rps.id_respostas)
										LIMIT 0,2-->