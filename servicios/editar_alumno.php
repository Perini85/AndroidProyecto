<?php
include 'conexion.php';
//variable del usuario desde android y de la bd
$nombres=$_POST['nombres'];
$apellidos=$_POST['apellidos'];
$direccion=$_POST['direccion'];
$contacto=$_POST['contacto'];

//probar base datos
//$usu_usuario='cristobal@impo.cl';
//$usu_password='cris12';
//$usu_nombres='tobal';
//$usu_apellidos='jerez';

$sentencia="UPDATE alumnos SET nombres='$nombres',apellidos='$apellidos',direccion='$direccion',contacto='$contacto' where nombres='$nombres' ";

mysqli_query($conexion,$sentencia)or die (mysql_error());
//mysql_close($conexion);
?>