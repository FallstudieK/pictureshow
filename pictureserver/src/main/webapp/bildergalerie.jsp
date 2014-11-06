<!DOCTYPE html>
<html>
<head>
<%@ page
language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%> 
    <title>I-mag-Imago | Erinnerungen fürs Leben</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="styles/layout.css" type="text/css"/>
</head>
<body id="top">
<%

    if ((session.getAttribute("user") == null) || (session.getAttribute("user") == "")) {

  %>
<meta charset="utf-8">
<script type="text/javascript">
alert("You are not logged in");
</script>
<div class="wrapper col1">
    <div id="topbar">
    </div>
</div>
<div class="wrapper col2">
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
    <div id="topbar">
        <!--<div id="search">
          <form action="#" method="post">
            <fieldset>
              <legend>Site Search</legend>
              <input type="text" value="Search the site&hellip;"  onfocus="this.value=(this.value=='Search the site&hellip;')? '' : this.value ;" />
          <input type="submit" name="go" id="go" value="GO" />
        </fieldset>
      </form>
    </div>-->
    </div>
</div>
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
<div class="wrapper col5">
    <div id="container">


        <style>
            .thumb {
            height: 75px;
            border: 1px solid #000;
            margin: 10px 5px 0 0;
            }
        </style>
        </form>
        <center>
            <form method="post" action="uploadFile" enctype="multipart/form-data">
                Wähle Bilder zum Hochladen:
                <input type="file" id="files" name="files[]" multiple/>
                <output id="list"></output>
                <br/><br/>

                <p id="titlep">
                    Titel: <br><input type="text" name="title"><br>
                </p>

                <br>
                <input type="submit" value="Upload"/>
            </form>
        </center>
    </div>
<%}
%>
</body>
</html>
