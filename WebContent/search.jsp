<!DOCTYPE html>
<html>
<head>
  <title>Product App</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="style.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
  <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
  
<sql:setDataSource var="db" driver="oracle.jdbc.OracleDriver"
    url="jdbc:oracle:thin:@localhost:1521:xe"
    user="javaus"
    password="root" />


</head>
<style>
body{font-family: 'Quicksand', sans-serif;}
</style>
<body>
<body style="overflow:hidden;">

<!-- Top Bar -->
<div class="w3-bar  w3-theme w3-large w3-margin-top " >
    <span> Welcome,  <a href="login.html">(logout)</a></span>

   <span class="w3-bar-item w3-text-theme-d2 w3-right">Some Product App</span>
  <span class="w3-bar-item w3-text-theme-d2 w3-left"></span>
</div>
<!-- End of Top Bar -->

<!-- Name and Date -->

<div class="w3-col s8 w3-bar w3-text-grey" style="margin-left:5px">
      <p id="time"></p>
    </div>
<!-- End  -->

<!-- Left Column -->
<header class="w3-container w3-text-grey">

    <h5><i class="fa fa-user-circle "></i> MY ACCOUNT</h5>

 </header>

<ul class="menu">

    <li><a class="active" href="index.jsp"><i class="fa fa-home"></i> HOME</a></li>
  <li><a href="AddPlayer.jsp"> <i class="fa fa-user-circle"></i> ADD PLAYER</a></li>
  <li><a href="addTeam.jsp"><i class="fa fa-users"></i>  ADD TEAM</a></li>
  <li><a href="viewTeam.jsp"><i class="fa fa-address-card-o"></i>  VIEW TEAMS</a></li>
  <li><a href="viewPlayers.jsp"><i class="fa fa-id-card"></i>  VIEW PLAYERS</a></li>
  <li><a href="Update.jsp"><i class="fa fa-grav"></i>  UPDATE </a></li>
  <li><a href="search.jsp"><i class="fa fa-search"></i>  SEARCH</a></li>
  <li><a href="delete.jsp"><i class="fa fa-trash-o"></i>  DELETE</a></li>
</ul>
<script>
var d = new Date();
document.getElementById("time").innerHTML = d.toDateString();
</script>

<!-- Form table -->


  

<!-- Tabs -->
	<div class="container">
		<h2>SEARCH BY</h2>
		<br>
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li class="nav-item"><a class="nav-link active"
				data-toggle="tab" href="#home">ID</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#menu1">NAME</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#menu2">EMAIL</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#menu3">DOB</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#menu4">CONTACT</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#menu5">GENDER</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#menu6">TEAM NAME</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div id="home" class="container tab-pane active">
				<br>

				<form action="search" >
					<div class="form-group">
						<label for="text">Player ID:</label> <input type="text"
							class="form-control" id="pid" name="searchValue" placeholder="Enter Player ID"
							name="pid">
							<input type="hidden" name="criteria" value="1"/>
					</div>
					
					<button type="submit" class="btn btn-primary">Submit</button>
					<span id="errMsg" style="color: red;"></span>
				</form>
			</div>

			<div id="menu1" class="container tab-pane fade">
				<br>
				<form action="search" >
					<div class="form-group">
						<label for="text">Player Name:</label> <input type="text"
							class="form-control" id="pname" name="searchValue" placeholder="Enter Player Name"
							>
							<input type="hidden" name="criteria" value="2"/>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
					<span id="errMsg" style="color: red;"></span>
				</form>
			</div>

			<div id="menu2" class="container tab-pane fade">
				<br>
				<form action="search" onsubmit="return isValidFields()">
					<div class="form-group">
						<label for="text">Player Email:</label> <input type="text"
							class="form-control" id="email" name="searchValue" placeholder="Enter Player Email"
							name="email">
							<input type="hidden" name="criteria" value="3"/>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
					<span id="errMsg" style="color: red;"></span>
				</form>
			</div>
			
			<div id="menu3" class="container tab-pane fade">
				<br>
				<form action="search" onsubmit="return isValidFields()">
					<div class="form-group">
						<label for="text">Player DOB:</label> <input type="date"
							class="form-control" id="dob" name="searchValue" placeholder="Enter Player DOB"
							>
							<input type="hidden" name="criteria" value="4"/>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
					<span id="errMsg" style="color: red;"></span>
				</form>
			</div>

			<div id="menu4" class="container tab-pane fade">
				<br>
				<form action="search" onsubmit="return isValidFields()">
					<div class="form-group">
						<label for="text">Player Contact:</label> <input type="tel"
							class="form-control" id="contact"
							placeholder="Enter Player Contact" name="searchValue">
							<input type="hidden" name="criteria" value="5"/>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
					<span id="errMsg" style="color: red;"></span>
				</form>
			</div>

			<div id="menu5" class="container tab-pane fade">
				<br>
				<form action="search" onsubmit="return isValidFields()">
					<div class="form-group">
						<label for="text">Player Gender</label><br> <input
							type="radio" name="searchValue" value="M">Male<br /> <input
							type="radio" name="searchValue" value="F">Female<br /> <input
							type="radio" name="searchValue" value="O">Other<br />
							<input type="hidden" name="criteria" value="6"/>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
					<span id="errMsg" style="color: red;"></span>
				</form>
			</div>

			<div id="menu6" class="container tab-pane fade">
				<br>
				<form action="search" onsubmit="return isValidFields()">
			<div class="form-group">
							<label class="col-md-6 control-label" for="textinput">Team
								Name</label>
							<div class="col-md-6">
							<sql:query dataSource="${db}" var="result">
								SELECT teamnames from Teams
							</sql:query>
							<select id="teamName" name="teamname">
								<c:forEach var="row" items="${result.rows}">
									<option><c:out value="${row.teamnames}"></c:out></option>
								</c:forEach>
							</select>
							</div>
						</div>
						<input type="hidden" name="criteria" value="7"/>
					<button type="submit" class="btn btn-primary">Submit</button>
 					<span id="errMsg" style="color: red;"></span>
				</form>
			</div>

		</div>
	</div>



	<!-- End concern table -->
</body>
</html>

<!-- <!-- jQuery
<script>
$(document).ready(function(){
  $('#formSearch').keyup(function(){
    search_table($(this).val());
  });

  function search_table(value)
  {
    $('#forms_table tr').each(function(){
      var found = 'false';
      $(this).each(function(){
        if($(this).text().toLowerCase().indexOf(value.toLowerCase()) >= 0)
        {
          found = 'true'; 
        }
      });
      if(found == 'true')
      {
        $(this).show();
      }
      else
      {
        $(this).hide();
      }
    });
  }
});
</script>

<script>
$(document).ready(function(){
  $('#concernSearch').keyup(function(){
    search_table($(this).val());
  });

  function search_table(value)
  {
    $('#concerns_table tr').each(function(){
      var found = 'false';
      $(this).each(function(){
        if($(this).text().toLowerCase().indexOf(value.toLowerCase()) >= 0)
        {
          found = 'true'; 
        }
      });
      if(found == 'true')
      {
        $(this).show();
      }
      else
      {
        $(this).hide();
      }
    });
  }
});
</script>
 -->