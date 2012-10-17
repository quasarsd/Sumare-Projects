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