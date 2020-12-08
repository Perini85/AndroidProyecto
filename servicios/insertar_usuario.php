<?php
include 'conexion.php';
//variable del usuario desde android y de la bd
$usu_usuario=$_POST['usuario'];
$usu_password=$_POST['password'];
$usu_nombres=$_POST['nombres'];
$usu_apellidos=$_POST['apellidos'];

//probar base datos
//$usu_usuario='cristobal@impo.cl';
//$usu_password='cris12354';
//$usu_nombres='cristobal';
//$usu_apellidos='jerez';

$sentencia="insert into usuario values ('$usu_usuario','$usu_password','$usu_nombres','$usu_apellidos')";

mysqli_query($conexion,$sentencia)or die (mysql_error());
mysql_close($conexion);
?>