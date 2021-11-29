<?php
    include('db_connect.php');

    $user = $_GET["user"];
    $response = array();
     
    if($resultset=getSQLResultSet("SELECT DATE_FORMAT(OPE_BITACORA_PAGOS_DONATIVOS.fecha_pago, \"%d-%m-%Y\") AS fecha,
        CASE OPE_DONATIVOS_DONANTE.id_frecuencia
            WHEN 1 THEN 'Donación de Pago Único'
            WHEN 2 THEN 'Donación Diaria'
            WHEN 3 THEN 'Donación Semanal'
            WHEN 4 THEN 'Donación Mensual'
            WHEN 5 THEN 'Donación Anual'
            ELSE 'Frecuencia Desconocida'
        END AS donativo,
        OPE_DONATIVOS_DONANTE.importe AS aportacion,
        CASE OPE_DONATIVOS_DONANTE.id_frecuencia
            WHEN 1 THEN 'inact'
            ELSE 'act'
        END AS actividad
        FROM OPE_BITACORA_PAGOS_DONATIVOS
        JOIN OPE_DONATIVOS_DONANTE
        ON OPE_BITACORA_PAGOS_DONATIVOS.id_donativo = OPE_DONATIVOS_DONANTE.id_donativo
        AND OPE_DONATIVOS_DONANTE.id_donante IN
        (SELECT id_donante FROM OPE_DONANTES WHERE email = '$user')
        ORDER BY OPE_BITACORA_PAGOS_DONATIVOS.fecha_pago DESC;")) {
     
        while ($row = $resultset->fetch_array(MYSQLI_NUM)) {

            $product = array();
            $product["fecha"] = $row[0];
            $product["donativo"] = $row[1];
            $product["aportacion"] = $row[2];
            $product["actividad"] = $row[3];
     
            array_push($response, $product);
        } 

        echo json_encode($response, JSON_UNESCAPED_UNICODE);
    }
?>