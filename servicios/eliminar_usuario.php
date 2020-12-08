<?php
include 'conexion.php';
//variable del usuario desde android y de la bd
$usu_usuario=$_POST['usuario'];


//probar base datos
//$usu_usuario='crist@info.cl';


$sentencia="delete from usuario where usu_usuario='$usu_usuario' ";

mysqli_query($conexion,$sentencia)or die (mysql_error());
//mysql_close($conexion);
?>