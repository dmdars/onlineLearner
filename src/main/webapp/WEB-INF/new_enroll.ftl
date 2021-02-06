<!DOCTYPE html>
<head>
    <title>OnlineLearner</title>
    <style type="text/css">
        * {
            margin:0;
            padding:0;
        }

        body{
            text-align:center;
            background: #efe4bf none repeat scroll 0 0;
        }

        .title{
            text-align: left;
            color: white;
        }

        #course_name
        {
            text-align: Center;
            color: grey;
        }

        #Rückung2
        {
            text-indent: 250px;    
            color: grey;    /*Texteinrückung in die Mitte*/
        }

        .Profilbox{
            width: 330px;
            height: 230px;
            background: lightgray;             /*Farbe der großen Box*/
            color: #0f6674;
            margin: 0 auto;  /* Anpassung der obigen Positionierung */
            padding: 80px 310px;  /*Größe des Paddings*/
        }

        #Schrift{
            margin-left: -280px;         /*richtige Einrückung in der Profilbox*/
            margin-top:-60px;
            color: grey;
            font-size: 17px;
        }
        .Profilbox a:hover
        {
            cursor: pointer;
            color: green;
        }
        #Box     /* für die große Beschreibungsbox */
        {
            position: absolute;
            top: 280px; /*nach oben verschieben mit minus*/
            left: calc(47% - 100px); /*sodass mittig */
        }
        #Anonym     /* für die große Beschreibungsbox */
        {
            position: absolute;
            top: 270px; /*nach oben verschieben mit minus*/
            left: calc(50% - 100px); /*sodass mittig */
        }
        .Tech{
            width: 150px;
            height: 150px;
            position: absolute;
            top: 10px;            /*nach oben verschieben mit minus*/
            left: calc(50% - 100px); /*sodass mittig */
        }

        .button{
            position: absolute;
            top: 300px;            /*nach oben verschieben mit minus*/
            left: calc(49% - 100px); /*sodass mittig */

            border: none;
            outline: none;
            height: 30px;
            line-height: 25px;
            width: 250px;          /*Breite des Buttons*/

            color: white;         /*Farbe der Eingabeschrift*/
            font-size: 20px;
            border-radius: 15px; /*macht Ränder des Buttons rund*/
            /* margin-right: 100px;*/
        }
        #Spenden{
            background: #2c5b9c;  /* Farbe des Hintergunds des Buttons*/

        }

        #Spenden:hover{
            background: green;  /* Farbe des Hintergunds des Buttons*/
            color: white;
        }
        .Profilbox #Betrag
        {
            border: none;
            border-bottom: 1px solid #1e7e34;
            background: white; /*macht weiße Hintergrundfläche der Eingabe transparent*/
            height: 30px;
            color: black;    /*Farbe der Eingabeschrift*/
            font-size: 16px;
        }

        .Spendebetrag{
            position: absolute;
            top: 230px;            /*nach oben verschieben mit minus*/
            left: calc(35% - 100px); /*sodass mittig */
        }

        .wrapper{
          width:960px;
          height: 450px;
          margin:0 auto;
          text-align:left;
          background-color: #fff ;
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

        #ErrorB
        {
            margin-left: 420px;         /*richtige Einrückung in der Profilbox*/
            margin-top: -26px;
            font-size: 22px;
        }

        .centerBlock{
            margin:0 auto;
        }
        
        .wrapperbox{
          width:920px;
          height:200px;
          margin: 20px 20px 0 0;
          text-align:left;
          background-color: #fff ;
          border-radius: 0 0 10px 10px;
          padding: 20px;
          box-shadow: 1px -2px 14px rgba(0, 0, 0, 0.4);
        }

        .Abstand
        {
            background-color: white;
            padding: 0px 0px 0px 0px;    /*Abstand zwischen Bereichen/Kategorien */
        }
        
        .Leerzeile
        {
            text-indent: 40px;
            font-size: 16px;
        }

        .form1{
            margin: 20px 10px 10px 0px;
        }
    </style>
    <script>
        function myFunction()
        {
            const B = document.getElementById('Betrag');
            const ErrorB = document.getElementById('ErrorB');
            if (B.value <= 0) {
                ErrorB.style.color = 'red';
                ErrorB.innerText = "Spende zu niedrig/keine Spende!";           //die error-message steht da, wo id=error definiert ist!
            }else{
                window.open("viewProject");
            }
        }
    </script>

    <body>
        <div class="wrapper">
            <div id="header">
                <h1 class = "title">  Online Learner </h1>
            </div>
            <div class="wrapperbox">
            <#--  <#assign name as kname>  -->
                <h1 id= "course_name"> ${name} </h1>
            <#--  </#assign>  -->
                <form class = "form1" id = "form" action ="new_enroll"  method="post">
                    <p class = "abstand"> </p>
                    <table>
                            <tr>
                                <th> <h2 id = "Rückung2"> Einschreibschlüssel </h2></th>
                                <td class = "Leerzeile">
                                    <input id = "Einschreibschlüssel" type ="text"  name ="Einschreibschlüssel" Placeholder ="">
                                    <p id = "errorE">  </p>
                                </td>
                            </tr>
                    </table>
                     <a href = "view_main"> <button class="button" id = "spenden.hover" type = "submit" name=""  > Einschreiben </button></a>
                </form>
            </div>
        </div>
    </body>
</html>