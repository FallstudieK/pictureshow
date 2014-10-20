
<% @page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <title>I-mag-Imago | Login</title>
    <link rel="stylesheet" href="styles/layout.css" type="text/css" />
</head>

<body id="top">

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

<div id="loginregister">
    <form name="input" method="POST" action="http://localhost:8087/pictureserver/login2">     <!--Method="post" or "get" what is the difference? which on eto use here?
                                                                                            Target URL needs to change!!-->

    <p id="textfeld">
        Benutzer: <br><input type="text" name="user"><br>
    </p>

    <p id="textfeld">
        Passwort: <br><input type="password" name="password"><br>
    </p>

    <p>
        <input id="button" type="submit" value="Einloggen">
    </p>
</form>
</div>

</body>
</html>
