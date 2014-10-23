<!DOCTYPE html>
<html>
<head>
<%@ page
language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%> 
    <title>I-mag-Imago | Erinnerungen fürs Leben </title>
    <script type="text/javascript" src="javascript/fenster.js"></script>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles/design.css">
    <link rel="stylesheet" type="text/css" href="styles/special.css">
    <link rel="stylesheet" href="styles/layout.css" type="text/css"/>
</head>
<body id="top">
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
<div class="wrapper col4">
    <div id="services">
        <ul>
            <li><a href="#"><strong>Über den Wolken</strong><img onclick="oeffnefenster('1')" width="100%"
                                                             src="bilder/bild1.JPG" style="position: width="100%";width:
                234px; height:210px;" alt="" /></a></li>
            <li><a href="#"><strong>Schokimuseum</strong><img onclick="oeffnefenster('2')" width="100%"
                                                             src="bilder/bild2.JPG" style="position: width="100%";width:
                234px; height:210px;" alt="" /></a></li>
            <li><a href="#"><strong>Köln</strong><img onclick="oeffnefenster('3')" width="100%"
                                                             src="bilder/bild3.JPG" style="position: width="100%";width:
                234px; height:210px;" alt="" /></a></li>
            <li class="last"><a href="#"><strong>Haribo</strong><img onclick="oeffnefenster('4')" width="100%"
                                                                          src="bilder/bild6.JPG"
                                                                          style="position: width="100%";width: 234px;
                height:210px;" alt="" /></a></li>
            <li><a href="#"><strong>I-mag-Imago</strong><img width="100%"
                                                             src="C:\Users\boelkes\Pictures\Fotoshooting Jasmin\DSC02232.JPG"
                                                             style="position: width="100%";width: 234px; height:210px;"
                alt="" /></a></li>
            <li><a href="#"><strong>I-mag-Imago</strong><img width="100%"
                                                             src="C:\Users\boelkes\Pictures\Deutschland Wochenende\DSC_0351.JPG"
                                                             style="position: width="100%";width: 234px; height:210px;"
                alt="" /></a></li>
            <li><a href="#"><strong>I-mag-Imago</strong><img width="100%"
                                                             src="C:\Users\boelkes\Pictures\Deutschland Wochenende\DSC_9999.JPG"
                                                             style="position: width="100%";width: 234px; height:210px;"
                alt="" /></a></li>
            <li class="last"><a href="#"><strong>I-mag-Imago </strong><img width="100%"
                                                                           src="C:\Users\boelkes\Pictures\Deutschland Wochenende\EMail\DSC_0169.JPG"
                                                                           style="position: width="100%";width: 234px;
                height:210px;" alt="" /></a></li>
        </ul>
        <br class="clear"/>
    </div>
</div>
<div onclick="closeall()" id="weisseflaeche"></div>
<div onclick="closeall()" id="xbutton"></div>
<div onclick="back()" id="pfeillinks"></div>
<div onclick="next()" id="pfeilrechts"></div>
<div id="fst1" class="bildzoom" style="background-color:#ffd700;"><img src="bilder/bild1.JPG" height="500"/><p><b>Über den Wolken</p></div>
<div id="fst2" class="bildzoom" style="background-color:#ffd700;"><img src="bilder/bild2.JPG" width="800"/><p><b>Schokimuseum</p></div>
<div id="fst3" class="bildzoom" style="background-color:#ffd700;"><img src="bilder/bild3.JPG" width="800"/><p><b>Köln</p></div>
<div id="fst4" class="bildzoom" style="background-color:#ffd700;"><img src="bilder/bild6.JPG" height="500"/><p><b>Haribo</p></div>
</body>
</html>