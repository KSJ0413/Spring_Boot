<!--<%@ page contentType="text/html; charset=UTF-8" %>-->
<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>-->
<!--<%@ taglib prefix="util" uri="/ELFunctions" %>-->

<!DOCTYPE html>
<html lang="en">

<head>
<script src="/js/list/asd.js" defer></script>
 <script src="https://code.jquery.com/jquery-latest.min.js"></script>
  <title>자동차등록</title>
  <meta charset="utf-8">

  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" type="text/css" href="/css/support/create.css">
  <link rel="stylesheet" type="text/css" href="/css/support/style.css">
  <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
</head>

<body>

   <span class="on" id="bluetooth">${dto.cdto.bluetooth}</span>
   <span class="on" id="rear_sensor">${dto.cdto.rear_sensor}</span>
   <span class="on" id="rear_camera">${dto.cdto.rear_camera}</span>
   <span class="on" id="black_box">${dto.cdto.black_box}</span>
   <span class="on" id="heated_seat">${dto.cdto.heated_seat}</span>
   <span class="on" id="heated_handle">${dto.cdto.heated_handle}</span>
   <span class="on" id="ventilated_seat">${dto.cdto.ventilated_seat} </span>
   <span class="on" id="navigation">${dto.cdto.navigation}</span>
   <span class="on" id="non_smoking_vehicle">${dto.cdto.non_smoking_vehicle} </span>
   <span class="on" id="smart_key"> ${dto.cdto.smart_key}</span>
   <span class="on" id="sunroof"> ${dto.cdto.sunroof} </span>
   <span class="on" id="rear_warning_light">${dto.cdto.rear_warning_light} </span>
   <span class="on" id="lane_departure_prevention"> ${dto.cdto.lane_departure_prevention}</span>


<script>
 var bluetooth = document.querySelector("#bluetooth").value;
  var rear_sensor = document.querySelector("#rear_sensor").value;
   var rear_camera = document.querySelector("#rear_camera").value;
    var category = document.querySelector("#category").value;
    var black_box = document.querySelector("#black_box").value;
     var heated_seat = document.querySelector("#heated_seat").value;
      var heated_handle = document.querySelector("#ventilated_seat").value;
      var heated_handle = document.querySelector("#navigation").value;
      var heated_handle = document.querySelector("#non_smoking_vehicle").value;
      var heated_handle = document.querySelector("#smart_key").value;
      var heated_handle = document.querySelector("#sunroof").value;
      var heated_handle = document.querySelector("#rear_warning_light").value;
      var heated_handle = document.querySelector("#lane_departure_prevention").value;

if(bluetooth =""){
bluetooth.style.background="red";
}else{
bluetooth.style.background="blue";
}



</script>

</body>

</html>