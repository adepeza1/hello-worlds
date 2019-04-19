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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
  


</head>
<style>
body{font-family: 'Quicksand', sans-serif;}
</style>
<body>
<body style="overflow:hidden;">

<!-- Top Bar -->
<div class="w3-bar  w3-theme w3-large w3-margin-top " >
    <span> Welcome, <?php echo $currUserID;?> <a href="login.html">(logout)</a></span>

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

<sql:setDataSource var="db" driver="oracle.jdbc.OracleDriver"
    url="jdbc:oracle:thin:@localhost:1521:xe"
    user="javaus"
    password="root" />

  
<div class="w3-twothird" style="margin-left:300px;">

  
  

<div class="container" style="margin-top:35px">
  <div class="form-group pull-right">
    <input type="text" id="formSearch" name="formSearch" class="search form-control" placeholder="Search forms..."/>
  </div>
    
<!-- Concern table -->

<div class="w3-content w3-margin-center" style="max-width:1400px;">
<div class="w3-row-padding">
  
<div class="w3-twothird" style="margin-left:30px;">
<div class="container">
  <h2>Add a Player</h2>
  <form action="" method="post" onsubmit="return isValidFields()">
    <div class="form-group">
      <label for="text">Player Name:</label>
      <input type="text" class="form-control" id="pname" placeholder="Enter Player name" name="name">
    </div>
    <div class="form-group">
      <label for="date">Player DOB:</label>
      <input type="date" class="form-control" id="dob" placeholder="Enter team name" name="tdob">
    </div>
    
    <div class="form-group">
      <label for="text">Player Email</label>
      <input type="text" class="form-control" id="email" placeholder="Enter player email" name="emai">
    </div>
        <div class="form-group">
      <label for="text">Player Gender</label><br>
      <input type="radio" name = "gender" value = "M">Male<br/>
	  <input type="radio" name = "gender" value = "F">Female<br/>
	  <input type="radio" name = "gender" value = "O">Other<br/>
    </div>
    <div class="form-group">
      <label for="tel">Player Contact</label>
      <input type="tel" class="form-control" id="contact" placeholder="Enter player contact" name="contact">
    </div>
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
   
    <button type="submit" name="register" class="btn btn-primary">Submit</button> <span id="errMsg" style="color:red;"></span>
  </form>
</div>



</div>
</div>
</div>
<%if(request.getParameter("register")!= null){%>
	<jsp:useBean id="player" class="com.to.Player" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="player"/>

<%
response.sendRedirect("addPlayer");

}%>
<script type="text/javascript" src="scripts/validatePlayer.js"></script>
</body>
</html>