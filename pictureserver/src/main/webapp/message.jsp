<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>I-mag-Imago | Erinnerungen fürs Leben  </title>
<link rel="stylesheet" href="styles/layout.css" type="text/css" />
    <script type="text/javascript" src="javascript/fenster.js"></script>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles/design.css">
    <link rel="stylesheet" type="text/css" href="styles/special.css">
    <link rel="stylesheet" href="styles/layout.css" type="text/css"/>
</head>
<body id="top">

<%

    if ((session.getAttribute("user") == null) || (session.getAttribute("user") == "")) {

  %>

<script type="text/javascript">
alert("You are not logged in");
</script>
<div class="wrapper col1">
    <div id="topbar">
    </div>
</div>
<div class="wrapper col2">
<meta charset="utf-8">
    <div id="header">
        <div id="logo">
            <h1><a href="#" style="color:#ffd700;">I-mag-Imago </a></h1>
            <p style="color:#ffd700;">Erinnerungen fürs Leben</p>
        </div>
        <ul id="topnav">
            <li><a href="Register.html" style="color:#ffd700;">Registrierung</a></li>
        </ul>
        <br class="clear" />
    </div>
</div>
<div>
<br>
<br>
<br>
<br>
<br>
<center><u><a href="Login.html" style="color:#ffd700;">Jetzt einloggen!</a></u></center>
</div>
<%} else {
%>

<title>Upload Result</title>
</head>

<div class="wrapper col2">
  <div id="header">
    <div id="logo">
      <h1><a href="#" style="color:#ffd700;">I-mag-Imago </a></h1>
      <p style="color:#ffd700;">Erinnerungen fürs Leben</p>
    </div>
    <ul id="topnav">
      <li><a href="bildergalerie.jsp" style="color:#ffd700;">Bildergalerie</a>
        <ul>
        <li><a href="localhost:8087/pictureserver/Bilderanzeigen" style="color:#ffd700;">Bilder anzeigen</a></li>
          <li><a href="AlbumAnlegen.jsp"> Neues Album</a></li>
          <li><a href="bildergalerie.jsp">Fotos hochladen</a></li>
          <li><a href="ordner2.jsp">Deutschlandreise</a></li>
        </ul>

      </li>
      <li><a href="blogkommentar.jsp" style="color:#ffd700;">I-mag kommentieren</a></li>
      <li class="active"><a href="startseite.jsp" style="color:#ffd700;">Startseite</a></li>
       <li class="active"><a href="logout" style="color:#ffd700;">Logout</a></li>
    </ul>
    <br class="clear" />
  </div>
</div>
    <center>
    <a style="color:#ffd700;">
        <h2>${message}</h2></a>
    </center>
</body>
</html>


<%}
%>
</body>
</html>
