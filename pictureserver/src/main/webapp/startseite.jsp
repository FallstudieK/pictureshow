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
    <script type="text/javascript" src="javascript/fenster.js"></script>
    <script type="text/javascript" src="styles/jquery.min.js"></script>
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
      <li><a href="#" style="color:#ffd700;">Bildergalerie</a>
        <ul>
        <li><a href="localhost:8087/pictureserver/Bilderanzeigen" style="color:#ffd700;">Bilder anzeigen</a></li>
          <li><a href="AlbumAnlegen.jsp"> Neues Album</a></li>
          <li><a href="bildergalerie.jsp">Fotos hochladen</a></li>
          <li><a href="Ordner2.jsp"> Beispielordner</a></li>
          <li><a href="AlbenAnzeigen.jsp"> Alben anzeigen</a></li>
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
      <h2 style="color:#ffd700;">Willkommen bei I-mag-Imago</h2>
      <p style="color:#ffd700;"><p>Bilder sind wichtige Quellen der Vergangenheit, die wertvolle Momente verewigen und schöne Erinnerungen wieder zum Leben erwecken.</p>
      <p>- Deshalb mag-I-Imago -</p>
    </div>
    <div id="column">
     <div class="flickrbox">
             <!--Bilder in Kleinformat--><h2 class="title" style="color:#ffd700;">Meine Alben</h2>
             <ul> <div id="data1"> </div>
             <!--  <li><a href="ordner1.html"><img src="bilder/ordner.png" width="80" height="80" alt="" /></a></li>
               <li><a href="#"><img src="bilder/ordner.png" width="80" height="80" alt="" /></a></li>
               <li class="last"><a href="#"><img src="bilder/ordner.png" width="80" height="80" alt="" /></a></li>
              <li><a href="#"><img src="bilder/bild4.JPG" width="80" height="80" alt="" /></a></li>
               <li><a href="#"><img src="bilder/bild5.JPG" width="80" height="80" alt="" /></a></li>
               <li class="last"><a href="#"><img src="bilder/bild6.JPG" width="80" height="80" alt="" /></a></li>-->
             </ul>
             <br class="clear" />
           </div>
         </div>

    <br class="clear" />
  </div>
</div>

<script>
ladeAlben();
function ladeAlben()
{
// Removing all children from an element
var element = document.getElementById("data1");
while (element.firstChild) {
  element.removeChild(element.firstChild);}
var res= "FolderService";
$.getJSON(res, function(data) {
    $.each(data, function(i, folder) {
    var foldername = folder.fname;
   // alert(foldername);
    var link ="Albenanzeige.jsp?ordner="+foldername;
if (document.getElementById(foldername)) {}
else {
 $("#data1").append($('<li><div><img src="bilder/ordner.png" width="80" height="80" alt="" /></div><div><a href="'+ link + '">'+ foldername+'</a></div></li>'));
         }
    });
});
}
</script>
<div class="wrapper col4">
    <div id="services">
        <ul>
       <div id="bildurl"><div id="data"> </div></div>

        <script>
        ladeAlbum();
        function ladeAlbum(album)
        {
        // Removing all children from an element
        var element = document.getElementById("data");
        while (element.firstChild) {
          element.removeChild(element.firstChild);}
        var res= "BilderService?album="+album;
        $.getJSON(res, function(data) {
            $.each(data, function(i, bild) {
            var bildurl ="http://localhost:8087/pictureserver/rest/api/bild/"+bild.username+"/"+bild.title;
           // alert(bildurl);
        if (document.getElementById(bildurl)) {}
        else {
         $("#data").append("<li><a href=\"#\"><strong>"+bild.title+"</strong><img id=\"Bilder\" src=\""+bildurl+"\" style=\"height:200px;\" alt=\""+bildurl+"\" ></a></li>");
                 }
            });
        });
        }
        </script>
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
<div id="fst3" class="bildzoom" style="background-color:#ffd700;"><img src="bilder/bild5.JPG" width="800"/><p><b>Köln</p></div>
<div id="fst4" class="bildzoom" style="background-color:#ffd700;"><img src="bilder/bild6.JPG" height="500"/><p><b>Haribo</p></div>

<%}
%>
</body>
</html>
