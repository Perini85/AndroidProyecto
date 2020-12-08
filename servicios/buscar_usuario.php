<?php
include 'conexion.php';
//variable del usuario desde android y de la bd
$usuario=$_GET['usuario'];

$consulta="select * from usuario where usu_usuario='$usuario'";
$resultado=mysqli_query($conexion,$consulta);

while($file=mysqli_fetch_assoc($resultado)){
	$row[]=$file;
}

print json_encode($row);


$resultado->close();

?>