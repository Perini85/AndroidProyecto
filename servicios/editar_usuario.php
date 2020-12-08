<?php
include 'conexion.php';
//variable del usuario desde android y de la bd
$usu_usuario=$_POST['usuario'];
$usu_password=$_POST['password'];
$usu_nombres=$_POST['nombres'];
$usu_apellidos=$_POST['apellidos'];

//probar base datos
//$usu_usuario='cristobal@impo.cl';
//$usu_password='cris12';
//$usu_nombres='tobal';
//$usu_apellidos='jerez';

$sentencia="UPDATE usuario SET usu_password='$usu_password',usu_nombres='$usu_nombres',usu_apellidos='$usu_apellidos' where usu_usuario='$usu_usuario' ";

mysqli_query($conexion,$sentencia)or die (mysql_error());
//mysql_close($conexion);
?>