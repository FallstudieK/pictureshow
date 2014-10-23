<!DOCTYPE html>
<html>
<head>
<%@ page
language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%> 
<title>I-mag-Imago | Erinnerungen fürs Leben  </title>
<link rel="stylesheet" href="styles/layout.css" type="text/css" />
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


<div class="wrapper col1">
  <!--<div id="topbar">
    <div id="search">
      <form action="#" method="post">
        <fieldset>
          <legend>Site Search</legend>
          <input type="text" value="Search the site&hellip;"  onfocus="this.value=(this.value=='Search the site&hellip;')? '' : this.value ;" />
          <input type="submit" name="go" id="go" value="GO" />
        </fieldset>
      </form>
    </div>
  </div>-->
</div>
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
          <li><a href="ordner2.html">Deutschlandreise</a></li>
        </ul>

      </li>
      <li><a href="blogkommentar.html" style="color:#ffd700;">I-mag kommentieren</a></li>
      <li class="active"><a href="startseite.jsp" style="color:#ffd700;">Startseite</a></li>
    </ul>
    <br class="clear" />
  </div>
</div>
<div class="wrapper col5">
  <div id="container">
    <div id="content">
      <h2 style="color:#ffd700;">Willkommen bei I-mag-Imago</h2>
      <p style="color:#ffd700;">Bilder sind Quellen der Vergangenheit, die schöne Erinnerungen verewigen.</p>
      <p>Hier noch mehr Text...</p>
    </div>
    <div id="column">
      <div class="flickrbox">
        <!--Bilder in Kleinformat--><h2 class="title" style="color:#ffd700;">Minibilder</h2>
        <ul>
          <li><a href="ordner1.html"><img src="images/Chanis_pics/DSC_0001.JPG" width="80" height="80" alt="" /></a></li>
          <li><a href="#"><img src="images/demo/80x80.gif" width="80" height="80" alt="" /></a></li>
          <li class="last"><a href="#"><img src="images/demo/80x80.gif" width="80" height="80" alt="" /></a></li>
          <li><a href="#"><img src="images/demo/80x80.gif" width="80" height="80" alt="" /></a></li>
          <li><a href="#"><img src="images/demo/80x80.gif" width="80" height="80" alt="" /></a></li>
          <li class="last"><a href="#"><img src="images/demo/80x80.gif" width="80" height="80" alt="" /></a></li>
        </ul>
        <br class="clear" />
      </div>
    </div>
    <br class="clear" />
  </div>
</div>
<div class="wrapper col4">
  <div id="services">
    <ul>
      <li><a href="#"><strong>I-mag-Imago</strong><img width="100%" src="images/Chanis_pics/DSC_0001.JPG" style="position: width="100%";width: 234px; height:210px;" alt="" /></a></li>
      <li><a href="#"><strong>I-mag-Imago</strong><img width="100%" src="images/Chanis_pics/DSC_0001.JPG" style="position: width="100%";width: 234px; height:210px;" alt="" /></a></li>
      <li><a href="#"><strong>I-mag-Imago</strong><img width="100%" src="images/Chanis_pics/DSC_0001.JPG" style="position: width="100%";width: 234px; height:210px;" alt="" /></a></li>
      <li class="last"><a href="#"><strong>I-mag-Imago</strong><img width="100%" src="images/Chanis_pics/DSC_0001.JPG" style="position: width="100%";width: 234px; height:210px;" alt="" /></a></li>
      <li><a href="#"><strong>I-mag-Imago</strong><img width="100%" src="images/Chanis_pics/DSC_0001.JPG" style="position: width="100%";width: 234px; height:210px;" alt="" /></a></li>
      <li><a href="#"><strong>I-mag-Imago</strong><img width="100%" src="images/Chanis_pics/DSC_0001.JPG" style="position: width="100%";width: 234px; height:210px;" alt="" /></a></li>
      <li><a href="#"><strong>I-mag-Imago</strong><img width="100%" src="images/Chanis_pics/DSC_0001.JPG" style="position: width="100%";width: 234px; height:210px;" alt="" /></a></li>
      <li class="last"><a href="#"><strong>I-mag-Imago </strong><img width="100%" src="images/Chanis_pics/DSC_0001.JPG" style="position: width="100%";width: 234px; height:210px;" alt="" /></a></li>
    </ul>
    <br class="clear" />
  </div>
</div>

<%}
%>
</body>
</html>
