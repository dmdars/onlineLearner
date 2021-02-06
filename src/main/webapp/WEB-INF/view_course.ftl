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

        .button
        {
            border: none;
            outline: none;
            height: 25px;
            line-height: 20px;
            width: 200px;          /*Breite des Buttons*/
            color: white;         /*Farbe der Eingabeschrift*/
            font-size: 17px;
            border-radius: 15px; /*macht R�nder des Buttons rund*/
            /* margin-right: 100px;*/
        }

        .button:hover
        {
            color: black;
        }

        .wrapper
        {
            width:960px;
            margin:0 auto;
            text-align:center;
            background-color: #fff;
            border-radius: 0 0 10px 10px;
            padding: 20px;
            box-shadow: 1px -2px 14px rgba(0, 0, 0, 0.4);
        }

        #header
        {
            text-align:left;
            color: #fff;
            background-color: #2c5b9c;
            height: 3.5em;
            padding: 1em 0em 1em 1em;

        }

        .Abstand
        {
            text-align:center;
            background-color: white;
            padding: 0px 0px 0px 0px;    /*Abstand zwischen AProjekte und OProjekte */
        }

        .Abstand2
        {
            text-align:center;
            background-color: white;
            padding: 50px 0px 40px 0px;    /*Abstand zwischen AProjekte und OProjekte */
        }

        td, th
        {
            border: 1px solid black;
            text-align: center;
            padding: 8px;
        }

        .row:after 
        {
            content: "";
            display: table;
            clear: both;
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
            border-radius: 15px; /*macht R�nder des Buttons rund*/
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

            function myFunction3()
            {
                window.open("new_enroll.html");
            }
        </script>

        <div class="wrapper">
            <div id="header">
                <h1> Online Learner </h1>
            </div><br>
            <#list kurs as course>
            <h1> Informationen </h1>
            <h2> ${course.name} </h2>
            <p class = Abstand> </p> 
                <div id = "Daten">
                    <p>
                        <p>Ersteller: ${course.bname} </p>
                        <p>${course.beschreibungstext}</p>
                        <p>Anz. freier Plätze: ${course.freiePlaetze}</p> 
                    </p>
                </div>
             </#list>

            <div style = "float:center;" id ="Ebutton" >
                <a href = "newEnroll"><button class="button" type ="submit" name="" onclick="myFunction3()">Einschreiben</button><a>
            </div><br>   

            <h1>Liste der Aufgaben</h1><br>

			<table style="width:100%">
                <tr>
                    <th>Aufgabe</th>
                    <th>Meine Abgabe</th>
                    <th>Bewertungsnote</th>
                </tr>
                <#list aufgabe as ag>
	                <tr>
	                    <td>${ag.name}</td>
	                    <td>${ag.abgabetext}</td>
	                    <td>${ag.note}</td>
	                </tr>
	            </#list>
            </table>
			
            <!-- <p class = Abstand> </p>
            <input id = "Löschen" class="button" type = "submit" name="" value="Projekt Löschen">
            <br> -->

        </div>
    </body>
</html>