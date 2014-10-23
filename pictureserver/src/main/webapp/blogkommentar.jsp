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
        <div id="content">
            <h2 style="color:#ffd700;">Write A Comment</h2>

            <div id="respond">
                <form action="#" method="post">
                    <p>
                        <input type="text" name="name" id="name" value="" size="22"/>
                        <label for="name">
                            <small>Name (required)</small>
                        </label>
                    </p>
                    <!--
                    <p>
                      <input type="text" name="email" id="email" value="" size="22" />
                      <label for="email"><small>Mail (required)</small></label>
                    </p>
                    -->
                    <p>
                        <textarea name="comment" id="comment" cols="100%" rows="10"></textarea>
                        <label for="comment" style="display:none;">
                            <small>Comment (required)</small>
                        </label>
                    </p>
                    <p>
                        <input name="submit" type="submit" id="submit" value="Submit Form"/>
                        &nbsp;
                        <input name="reset" type="reset" id="reset" tabindex="5" value="Reset Form"/>
                    </p>
                </form>
            </div>
        </div>
        <div id="column">
            <div class="subnav">
                <h2>Benutzer Navigation</h2>
                <ul>
                    <li><a href="bildergalerie.jsp">Bildergalerie</a>
                        <ul>
                            <li><a href="ordner2.jsp">Deutschlandreise</a></li>
                            <li><a href="ordner2.html">Ordner 2</a></li>
                            <li><a href="ordner3.html">Ordner 2</a></li>
                            <!-- <ul>
                               <li><a href="#">Unterordner 1</a></li>
                               <li><a href="#">Unterordner 2</a></li>
                             </ul>
                           </li>-->
                        </ul>
                    </li>
                    <li><a href="startseite.jsp">Startseite</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<%}
%>
</body>
</html>
