<?php
include 'conexion.php';
$nombres=$_POST['nombres'];//variable del usuario desde android y de la bd
$alum_password=$_POST['password'];

//$usu_usuario="aroncal@gmail.com";
//$usu_password="12345678";

$sentencia=$conexion->prepare("SELECT * FROM alumnos WHERE nombres=? AND alum_password=?");
$sentencia->bind_param('ss',$usu_usuario,$usu_password);
$sentencia->execute();

$resultado = $sentencia->get_result();
if ($fila = $resultado->fetch_assoc()) {
         echo json_encode($fila,JSON_UNESCAPED_UNICODE);     
}
$sentencia->close();
$conexion->close();
?>
