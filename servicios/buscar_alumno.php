<?php
include 'conexion.php';
//variable del usuario desde android y de la bd
$alumno=$_GET['alumno'];

$consulta="select * from alumno where nombres='$alumno'";
$resultado=mysqli_query($conexion,$consulta);

while($file=mysqli_fetch_assoc($resultado)){
	$row[]=$file;
}

print json_encode($row);


$resultado->close();

?>