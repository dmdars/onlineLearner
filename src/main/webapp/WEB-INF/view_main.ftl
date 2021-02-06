<!DOCTYPE html>
  <head>
  </head>
  <title>view_main</title>
  <style type="text/css">
      * {
          margin:0;
          padding:0;
      }

      body{
          text-align:center;
          background: #efe4bf none repeat scroll 0 0;
      }                                                                                         

      h1 {
          text-align: center;
          text-transform: uppercase;
          color: #fff;
      }

      h2 {
          text-align: left;
          color: #2c5b9c;
      }

      h3{
          text-align: left;
          color: grey;
      }

      p{
        text-align: left;
        color: grey;
      }

      .wrapper{
          width:960px;
          height: 650px;
          margin:0 auto;
          text-align:left;
          background-color: #fff ;
          border-radius: 0 0 10px 10px;
          padding: 20px;
          box-shadow: 1px -2px 14px rgba(0, 0, 0, 0.4);
      }

      .box {
        position: relative;
        background: #2c5b9c;
        width: 240px;
        height: 100px;
        margin: 20px 20px 0 0;
        float: left;
        overflow:hidden;
        box-shadow: 1px -2px 8px rgba(0, 0, 0, 0.4);
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

      .slider {
          width: 920px;
          height: 200px;
          display: flex;
          overflow-x: auto;
          -webkit-overflow-scrolling: touch;
      }

      .slide {
          width: 300px;
          flex-shrink: 0;
          height: 50%;
      }

      .button {
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

      .button:hover {
            background: green;
            color: white;
      }

      #header {
          color: #fff;
          background-color: #2c5b9c;
          height: 3.5em;
          padding: 1em 0em 1em 1em;
      }

      #Ebutton {
              /* funktioniert in input-Bereich !!!*/
            padding: 20px 0px 25px 0px;  /*damit ein Abstand nach unten vorhanden ist*/
        }
  </style>

  <body>
    <div class="wrapper">
      <div id="header">
          <h1> Online Learner </h1>
      </div>
        <div class = "wrapperbox">
          <h2> Meine Kurs </h2>
          <div class="slider">
            <#list ukurs as ucourse>
            <#assign kname = ucourse.name, bname = ucourse.bname>
              <div class="slide">
                <a href = "new_enroll"  name = "kname" value = "${kname}">
                  <div class = "box" float = "right">
                    <h3> ${kname} </h3>
                    <p> Ersteller: ${bname}
                    <br>Freie Plätze: ${ucourse.freiePlaetze}
                    </p>
                  </div>
                <a>
              </div>
            </#list>     
          </div>
        </div>
        <div class = "wrapperbox">
          <h2> Verfügbare Kurs </h2>
          <div class="slider">
            <#list kurs as course>
              <div class="slide">
                <a href = "view_kurs_table">
                  <div class = "box" float = "right">
                    <h3> ${course.name} </h3>
                    <p> Ersteller: ${course.ersteller}
                    <br>Freie Plätze: ${course.freiePlaetze}
                    </p>
                  </div>
                </a>
              </div>
            </#list>     
          </div>
        </div>
        <div style = "float:right;" id ="Ebutton">
          <a href = "new_course"><input class="button" type ="button" name="" value = "Kurs erstellen"><a>
        </div> 
      </div>
    </div>
  </body>
</html>