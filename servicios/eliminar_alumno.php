<?php
include 'conexion.php';
//variable del usuario desde android y de la bd
$nombres=$_POST['nombres'];


//probar base datos
//$usu_usuario='crist@info.cl';


$sentencia="delete from alumnos where nombres='$nombres' ";

mysqli_query($conexion,$sentencia)or die (mysql_error());
//mysql_close($conexion);
?>