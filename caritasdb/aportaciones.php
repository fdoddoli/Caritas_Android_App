<?php
    include('db_connect.php');

    $user = $_GET["user"];
    $response = array();
     
    if($resultset=getSQLResultSet("SELECT CONCAT(OPE_DONANTES.nombre, '\n', OPE_DONANTES.a_paterno, ' ', OPE_DONANTES.a_materno) AS nombre_completo,
        COUNT(*) AS cantidad_donaciones,
        SUM(OPE_DONATIVOS_DONANTE.importe) AS total_aportaciones
        FROM OPE_DONANTES
        JOIN OPE_DONATIVOS_DONANTE
        ON OPE_DONANTES.id_donante = OPE_DONATIVOS_DONANTE.id_donante
        AND OPE_DONANTES.email = '$user'
        JOIN OPE_BITACORA_PAGOS_DONATIVOS
        ON OPE_DONATIVOS_DONANTE.id_donativo = OPE_BITACORA_PAGOS_DONATIVOS.id_donativo
        GROUP BY nombre_completo, OPE_DONATIVOS_DONANTE.id_donante;")) {
     
        while ($row = $resultset->fetch_array(MYSQLI_NUM)) {

            $product = array();
            $product["nombre_completo"] = $row[0];
            $product["cantidad_donaciones"] = $row[1];
            $product["total_aportaciones"] = $row[2];
     
            array_push($response, $product);
        } 

        echo json_encode($response, JSON_UNESCAPED_UNICODE);
    }
?>