<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>I-mag-Imago | Neues Album</title>
    <link rel="stylesheet" href="styles/layout.css" type="text/css" />
</head>
<body>
<%

    if ((session.getAttribute("user") == null) || (session.getAttribute("user") == "")) {

  %>

<script type="text/javascript">
alert("You are not logged in");
</script>
<!--link zu jetzt einloggen-->
<%} else {
%>
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
            <li><a href="#" style="color:#ffd700;">Bildergalerie</a>
                <ul>
                    <li><a href="bildergalerie.jsp">Fotos hochladen</a></li>
                </ul>
            </li>
            <li><a href="blogkommentar.html" style="color:#ffd700;">I-mag kommentieren</a></li>
            <li class="active"><a href="startseite.jsp" style="color:#ffd700;">Startseite</a></li>
        </ul>
        <br class="clear" />
    </div>
</div>

<div id="loginregister">
    <form name="input" method="Get" action="http://localhost:8087/pictureserver/CreateAlbum">     <!--Method="post" or "get" what is the difference? which on eto use here? Target URL needs to change!!-->


<p id="titlep">
    Titel: <br><input type="text" name="title"><br>
</p>

<p id="beschreibungp">
    Beschreibung: <br><input type="text" name="description"><br>
<!-- </p>
        <form method="post" action="uploadFile" enctype="multipart/form-data">
            Select file to upload in this album:
            <input type="file" id="files" name="files[]" multiple />
            <output id="list"></output>
            <!-- <input type="file" name="uploadFile" multiple/>
            <br/><br/>
        </form> -->
<p>
    <input id="Album" type="submit" value="Album anlegen">
</p>
</form>
</div>
<%}
%>
</body>
</html>