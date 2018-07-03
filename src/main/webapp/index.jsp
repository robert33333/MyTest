<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 6/29/18
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AplicatieWebBazaDate</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>

<body>
<h1>Simple PostgreSQL DataBase Java Web App </h1>


<button id="butonGET" onclick="myFuncGet()">GET</button>
<label for="inputGET">Intrudu PK</label><input id="inputGET" type="text">
<br>
<button id="butonUPDATE" onclick="myFuncUpdate()">UPDATE</button>
<label for="inputUPDATE">Intrudu PK</label><input id="inputUPDATE" type="text">
<label for="inputUpdateValue">Intrudu Value</label><input id="inputUpdateValue" type="input">
<br>
<button id="butonInsert" onclick="myFuncInsert()">INSERT</button>
<label for="inputINSERT">Intrudu PK</label><input id="inputINSERT" type="text">
<label for="inputInsertValue">Intrudu Value</label><input id="inputInsertValue" type="input">
<br>
<button id="butonDELETE" onclick="myFuncDelete()">DELETE</button>
<label for="inputDELETE">Intrudu PK</label><input id="inputDELETE" type="text">

<div id="snackbar">Some text some message..</div>

</body>

<script src="js/script.js" type="text/javascript"></script>
</html>
