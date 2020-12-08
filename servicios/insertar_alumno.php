<?php
include 'conexion.php';
//variable del usuario desde android y de la bd
$nombres=$_POST['nombres'];
$apellidos=$_POST['apellidos'];
$direccion=$_POST['direccion'];
$contacto=$_POST['contacto'];

//probar base datos
//$usu_usuario='cristobal@impo.cl';
//$usu_password='cris12354';
//$usu_nombres='cristobal';
//$usu_apellidos='jerez';

$sentencia="insert into alumnos values ('$nombres','$apellidos','$direccion','$contacto')";

mysqli_query($conexion,$sentencia)or die (mysql_error());
mysql_close($conexion);
?>