<!DOCTYPE html>
<html>
    <head>
        <title>OnlineLearner</title>
    </head>    

    <style>

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

        #Überschrift
        {
            text-align: center;
            color: black;
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

        .wrapper input[type = "text"]          /*für alle Input-Texte*/
        {
            border-bottom: 1px solid black;
            background: white;                /*transparent macht weiße Hintergrundfläche der Eingabe transparent*/
            outline: #2c5b9c;
            height: 20px;
            color: black;    /*Farbe der Eingabeschrift*/
            font-size: 16px;
        }

        .wrapper #Beschreibung              /* für die große Beschreibungsbox */
        {
            border-bottom: 1px solid black;
            background: white;
            outline: #2c5b9c;
            height: 100px;
            width:  300px;
            color: black;    /*Farbe der Eingabeschrift*/
            font-size: 16px;
        }
        
        .wrapper #Rückung1
        {
            text-indent: 292px;        /*Texteinrückung in die Mitte*/
        }

        .wrapper #Rückung2
        {
            text-indent: 150px;        /*Texteinrückung in die Mitte*/
        }

        .wrapper #Rückung3
        {
            text-indent: 170px;        /*Texteinrückung in die Mitte*/
        }

        .wrapper #Rückung4
        {
            text-indent: 160px;        /*Texteinrückung in die Mitte*/
        }

        #header
        {
            color: #fff;
            background-color: #2c5b9c;
            height: 3.5em;
            padding: 1em 1em 1em 1em;
        }

        .Leerzeile
        {
            text-indent: 40px;
            font-size: 16px;
        }

        .Abstand
        {
            background-color: white;
            padding: 0px 0px 0px 0px;    /*Abstand zwischen Bereichen/Kategorien */
        }

        .Abstand2
        {
            background-color: white;
            padding: 0px 0px 0px 0px;    /*Abstand zwischen Bereichen/Kategorien */
        }

        .Abstand3
        {
            background-color: white;
            padding: 0px 0px 0px 0px;    /*Abstand zwischen Bereichen/Kategorien */
        }

        .button
        {
            border: none;
            outline: none;
            height: 25px;
            line-height: 20px;
            width: 200px;          /*Breite des Buttons*/
            background: #2c5b9c;  /* Farbe des Hintergunds des Buttons*/
            color: white;         /*Farbe der Eingabeschrift*/
            font-size: 17px;
            border-radius: 15px; /*macht Ränder des Buttons rund*/
            /* margin-right: 100px;*/
        }

        .button:hover
        {
            background: lightcoral;
            color: darkblue;
        }

        #Ebutton
        {
            /* funktioniert in input-Bereich !!!*/
            padding: 0px 0px 50px 0px;  /*damit ein Abstand nach unten vorhanden ist*/
        }

        .centerBlock
        {
            margin:0 auto;
        }
    </style>

    <body>
        <script type = "text/javascript">

            function myFunction2()
            {
                const FP = document.getElementById('freierPl');
                const N = document.getElementById('KName');
                const ErrorN = document.getElementById('errorN');
                const ErrorFP = document.getElementById('errorFP');

                if (N.value.length > 50 )
                {
                    ErrorN.style.color = 'red';
                    ErrorN.innerText = "Name zu lang";    //die error-message steht da, wo id=error definiert ist!
                }

                if(FP.value > 100) 
                {
                    ErrorFP.style.color = 'red';                //Implementierung fehlt, da Daten fehlen
                    ErrorFP.innerHTML = "Der Wert ist größer als 100";
                }

                if(N.value.length < 50 && E.value < 100) //nur value für V und K funktioniert nicht
                {    
                    window.open("onlineLearner_start.html");
                }
            }
        </script>

        <form id = "form" action ="view_main"  method="GET">
            <div class="wrapper">
                <div id="header">
                    <h1> Online Learner </h1>
                </div><br>

                <h1 id = "Überschrift"> Kurs erstellen </h1>

                <p class = "Abstand"></p>

                <table>
                    <tr>
                        <th> <h2 id = "Rückung1"> Name </h2> </th>
                        <td class = "Leerzeile">
                            <input id = "KName" type = "text" name ="" Placeholder ="Name des Kurs">
                            <p id = "errorN">  </p>
                        </td>
                    </tr>
                </table>

                <p class = "Abstand2"></p>

                <table>
                    <tr>
                        <th> <h2 id = "Rückung2"> Einschreibschlüssel </h2></th>
                        <td class = "Leerzeile">
                            <input id = "Einschreibschlüssel" type ="text"  name ="" Placeholder ="Einschreibschlüssel">
                            <p id = "errorE">  </p>
                        </td>
                    </tr>
                </table>

                <p class = "Abstand3"></p>

                <table>
                    <tr>
                        <th> <h2 id = "Rückung3"> Anz. freier Plätze </h2></th>
                        <td class = "Leerzeile">
                            <input type="number" id="freierPl" name="freierPl">
                        </td>
                    </tr>
                </table>
                <p id = "errorFP">  </p>

                <p class = "Abstand3"></p>

                <table>
                    <tr>
                        <th> <h2 id = "Rückung4"> Beschreibungstext </h2></th>
                        <td class = "Leerzeile">
                            <textarea id = "Beschreibung" rows = '4' cols = "50" Placeholder = "Beschreibung"></textarea>
                        </td>
                    </tr>
                </table>

                <p class = "Abstand3"></p>

                <div style = "float:right;" id ="Ebutton" >
                    <a href = "newProject"><button class="button" type ="submit" name="" onclick="myFunction2()">Erstellen</button><a>
                </div><br>
            </div>
        </form>
    </body>
</html>