<?php
error_reporting(-1);
$myfile=fopen("../passwords.txt", 'a+') or die("Unable");
$login=$_POST['usrname'];
$password=$_POST['psw'];
while(!feof($myfile))
{
    $str = htmlentities(fgets($myfile));
    $row = strpos($str, ";");
    $str = substr($str, 0, $row);
    if(strcmp($login,$str)==0){
        echo "<script type=\"text/javascript\">alert(\"Пользователь с таким именем существует\");</script>";
        echo("<script>window.location = '../register.html';</script>");
        fclose($myfile);
        exit();
    }
}
$wlogin=fwrite($myfile, $login.';'.$password."\n");
fclose($myfile);
header("Location: ../register.html");
exit();
?>