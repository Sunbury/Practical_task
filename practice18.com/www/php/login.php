<?php
error_reporting(-1);
$myfile=fopen("../passwords.txt", 'r');
$chloe="chloe";
$chloepsw="price";
$adm="root";
$pname=$_POST['name'];
$ppsw=$_POST['psw'];
if ($_SERVER["REQUEST_METHOD"] == "POST") {
	while(!feof($myfile))
	{
    	$str = htmlentities(fgets($myfile));
		$str = substr($str, 0, -1);
		if ($pname === $chloe && $ppsw === $chloepsw) {
    		header("Location: ../calculator.html");
    		exit();
		} elseif ($pname === $adm && $ppsw === $adm) {
			header("Location: ../calculator.html");
			exit();
		} elseif (strcmp($str, $pname . ";" . $ppsw) == 0) {
			header("Location: ../calculator.html");
			exit();
		} else {
			header("Location: ../index.html");
		}
	}
}
fclose($myfile);
exit();
?>