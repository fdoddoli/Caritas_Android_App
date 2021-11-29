<?php
    include('db_connect.php');

    $user = $_GET["user"];
    $pass = $_GET["pass"];
    $response = array();
     
    if($resultset=getSQLResultSet("SELECT id_donante FROM OPE_DONANTES WHERE email LIKE '$user' AND contrasena LIKE '$pass';")) {
     
        while ($row = $resultset->fetch_array(MYSQLI_NUM)) {

            $product = array();
            $product["id"] = $row[0];
     
            array_push($response, $product);
        } 

        echo json_encode($response, JSON_UNESCAPED_UNICODE);
    }
?>