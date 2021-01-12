<!DOCTYPE html>
<html>
    <head>
        <title>OnlineLearner</title>
    </head>

    <style type="text/css">
        * {
            margin:0;
            padding:0;
        }

        body
        {
            text-align:center;
            background: #efe4bf none repeat scroll 0 0;
        }

        .Profilbox
        {
            width: 330px;
            height: 210px;
            background: lightgray;             /*Farbe der großen Box*/
            color: #0f6674;
            top: 38%;
            left: 63%;    /*  Positionierung */
            position: absolute;
            transform: translate(-75%, -50%);  /* Anpassung der obigen Positionierung */
            padding: 80px 310px;  /*Größe des Paddings*/
        }

        #Schrift
        {
            margin-left: -280px;         /*richtige Einrückung in der Profilbox*/
            margin-top:-60px;
            color: black;
            font-size: 17px;
        }

        .Profilbox #Daten
        {
            margin-left: 0px;         /*richtige Einrückung in der Profilbox*/
            margin-top:240px;
            color: black;
            font-size: 17px;
        }

        .Profilbox a:hover
        {
            cursor: pointer;
            color: green;
        }

        .Tech
        {
            width: 150px;
            height: 150px;
            position: absolute;
            top: 10px;            /*nach oben verschieben mit minus*/
            left: calc(50% - 100px); /*sodass mittig */
        }

        .button
        {
            border: none;
            outline: none;
            height: 25px;
            line-height: 20px;
            width: 200px;          /*Breite des Buttons*/
            color: white;         /*Farbe der Eingabeschrift*/
            font-size: 17px;
            border-radius: 15px; /*macht Ränder des Buttons rund*/
            /* margin-right: 100px;*/
        }

        #Spenden
        {
            background: green;  /* Farbe des Hintergunds des Buttons*/

        }

        #Löschen
        {
            background: red;  /* Farbe des Hintergunds des Buttons*/
            margin-left: 90px; /*Abstand der Buttons*/
        }

        #Editieren
        {
            background: blue;  /* Farbe des Hintergunds des Buttons*/
            margin-left: 90px; /*Abstand der Buttons*/
        }

        #Kommentieren
        {
            background: darkblue;  /* Farbe des Hintergunds des Buttons*/
            margin-left: 90px; /*Abstand der Buttons*/
        }

        .button:hover
        {
            color: black;
        }

        .Projekt
        {
            position: absolute;
            top: 170px;            /*nach oben verschieben mit minus*/
            left: calc(46% - 100px); /*sodass mittig */
        }

        #ProjektE
        {
            position: absolute;
            top: 210px;            /*nach oben verschieben mit minus*/
            left: calc(47% - 100px); /*sodass mittig */
        }

        .ProjektB
        {
            position: absolute;
            top: 235px;            /*nach oben verschieben mit minus*/
            left: calc(47.5% - 100px); /*sodass mittig */
        }

        .wrapper
        {
            width:960px;
            margin:0 auto;
            text-align:left;
            background-color: #fff;
            border-radius: 0 0 10px 10px;
            padding: 20px;
            box-shadow: 1px -2px 14px rgba(0, 0, 0, 0.4);
        }

        #header{
            color: #fff;
            background-color: #2c5b9c;
            height: 3.5em;
            padding: 1em 0em 1em 1em;

        }

        .Abstand
        {
            background-color: white;
            padding: 180px 0px 40px 0px;    /*Abstand zwischen AProjekte und OProjekte */
        }

        .Abstand2
        {
            background-color: white;
            padding: 50px 0px 40px 0px;    /*Abstand zwischen AProjekte und OProjekte */
        }

        #Kommentare
        {
            background-color: grey;
            padding: 250px 0px 0px 0px;  /*grauer Bereich*/
        }

        #Spender
        {
            background-color: grey;
            padding: 250px 0px 0px 0px;   /*grauer Bereich*/
        }

        .centerBlock
        {
            margin:0 auto;
        }
    </style>

    <body>
        <div class="wrapper">
            <div id="header">
                <h1> Online Learner </h1>
            </div><br>
            
            <h1> Informationen </h1><br>
            
            <p class = Abstand> </p>

            <div class = "Profilbox">
                <div id = "Schrift">
                    <img src = "PNG/tech.png" class = "Tech">
                    <div class ="Projekt"><h2>"Name des Projekts"</h2></div>
                        <a href="viewProfile" id = "ProjektE"><h4>"Name des Projekterstellers"</h4></a> <br>
                    <div class ="ProjektB">"Beschreibung des Projekts"</div>
                    <div id = "Daten">
                        <ul>
                            <li> Finanzierungslimit: 40 Euro</li>
                            <li> Aktuelle Spendesumme: 29,5 Euro</li>
                            <li> Status: offen</li>
                            <li> Vorgänger-Projekt:  <a href="#" >"Ubunut Light"</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <p class = Abstand> </p>

            <h1>Aktionsleiste</h1><br>
            <a href = "newProjectFund"><input id = "Spenden" class="button" type = "submit" name="" value="Spenden"></a>
            <input id = "Löschen" class="button" type = "submit" name="" value="Projekt Löschen">
            <a href = "editProject"><input id = "Editieren" class="button" type = "submit" name="" value="Projekt Editieren"></a>
            <br>
            <p class = Abstand2> </p>

            <h1>Liste der Spender</h1><br>
            <div id = "Spender">
            </div> <br>

            <p class = Abstand2> </p>

            <h1>Kommentare</h1><br>
            <div id = "Kommentare">
            </div> <br>

            <div style = "float:right;" id ="Ebutton" >
                <a href = "newComment"><input id = "Kommentieren" class="button" type ="button" name="" value = "Kommentieren">
                </a>
            </div><br>
        </div>
    </body>
</html>