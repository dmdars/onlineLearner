<html>
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <#--  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">  -->


<title>Online Learner</title>
<body>
  <h1> 
    <p class="text-center">  Online Learner </P> 
  </h1> 
 <div class="album py-5 bg-light">
    <div class="container">
        <h3> 
        <p class="text-left">  Meine Kurse </P> 
        </h3>
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <div class="col">
          <div class="card shadow-sm">
            <div class="card-body">
              <table class="table table-dark table-striped">
                <tr>
                    <th>Firstname</th>  <th>Lastname</th>
                </tr>
                <#list users as user>
                <tr>
                    <td>${user.firstname}</td> <td>${user.lastname}</td>
                </tr>
                </#list>
              </table>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card shadow-sm">
            <div class="card-body">
              <table class="table table-dark table-striped">
                <tr>
                    <th>Firstname</th>  <th>Lastname</th>
                </tr>
                <#list users as user>
                <tr>
                    <td>${user.firstname}</td> <td>${user.lastname}</td>
                </tr>
                </#list>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
 <div class="album py-5 bg-light">
    <div class="container">
        <h3> 
        <p class="text-left">  Verfügbare Kurse </P> 
        </h3>
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <div class="col">
          <div class="card shadow-sm">
            <div class="card-body">
              <table class="table table-dark table-striped">
                <tr>
                    <th>Firstname</th>  <th>Lastname</th>
                </tr>
                <#list users as user>
                <tr>
                    <td>${user.firstname}</td> <td>${user.lastname}</td>
                </tr>
                </#list>
              </table>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card shadow-sm">
            <div class="card-body">
              <table class="table table-dark table-striped">
                <tr>
                    <th>Firstname</th>  <th>Lastname</th>
                </tr>
                <#list users as user>
                <tr>
                    <td>${user.firstname}</td> <td>${user.lastname}</td>
                </tr>
                </#list>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

<div class="position-relative">
  <div class="position-absolute bottom-0 start-0">
    <button type="button" class="btn btn-primary">Kurs Erstellen</button>
  </div>
</div>
  <#--  <form name="user" action="hello" method="post">
    Firstname: <input type="text" name="firstname" /> <br/>
    Lastname: <input type="text" name="lastname" /> <br/>
    <input type="submit" value="Save" />
  </form>  -->

      <!-- Option 2: Separate Popper and Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>

</body>
</html>