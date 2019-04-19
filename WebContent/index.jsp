<?php 

  session_start();
  if (isset($_SESSION['username']))
  {
    $currUserID = $_SESSION['username'];
  }
  else
  {
    header("Location: logout.php");
  }
?>

<!DOCTYPE html>
<html lang="en">
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


</head>
<style>
body{font-family: 'Quicksand', sans-serif;}
</style>
<body style="overflow:hidden;">

<!-- Top Bar -->
<div class="w3-bar  w3-theme w3-large w3-margin-top " >
<form action="logout" method="post">
    <span> Welcome, </span>
    <input type="submit" value="logout"><span id="errMsg" style="color:red;"></span>
    	</form>

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
<!-- 
<div class="w3-content " style="max-width:1400px;">
<div class="w3-row-padding">
  
<div class="w3-twothird" style="margin-left:100px; margin-top:30px;">

  <img src="track.gif" alt="Girl in a jacket"width="450" height="300">
  <img src="football.jpg" alt="Girl in a jacket"width="400" height="400">
  <img src="ufc.jpg" alt="Girl in a jacket"width="400" height="400">
  </div>
  </div>
  </div> -->
  <div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:10px">
    <!-- First Photo Grid-->
  <div class="w3-row-padding w3-padding-16 w3-center" id="food">
    <div class="w3-quarter">
      <img src="swim.jpg" alt="Sandwich" style="width:100%;height:350px">
      <h3>The Perfect Sandwich, A Real NYC Classic</h3>
      <p>Just some random text, lorem ipsum text praesent tincidunt ipsum lipsum.</p>
    </div>
    <div class="w3-quarter">
      <img src="football.jpg" alt="Steak" style="width:100%;height:350px">
      <h3>Let Me Tell You About This Steak</h3>
      <p>Once again, some random text to lorem lorem lorem lorem ipsum text praesent tincidunt ipsum lipsum.</p>
    </div>
    <div class="w3-quarter">
      <img src="ufc1.jpg" alt="Cherries" style="width:100%;height:350px">
      <h3>Cherries, interrupted</h3>
      <p>Lorem ipsum text praesent tincidunt ipsum lipsum.</p>
      <p>What else?</p>
    </div>
    <div class="w3-quarter">
      <img src="gymnastics.jpg" alt="Pasta and Wine" style="width:100%;height:350px">
      <h3>Once Again, Robust Wine and Vegetable Pasta</h3>
      <p>Lorem ipsum text praesent tincidunt ipsum lipsum.</p>
    </div>
  </div>
</div>
</body>
</html>

<!--jQuery-->
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