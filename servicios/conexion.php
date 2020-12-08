<?php
$hostname='localhost';
$database='sistema_academico';
$username='root';
$password='';

$conexion=new mysqli($hostname,$username,$password,$database);
if($conexion->connect_errno){
    echo "El sitio web está experimentado problemas";
}else
{echo "conectado";}

?>