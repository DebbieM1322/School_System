<?php 



session_start();
include ("connection.php");
include ("functions.php");
$user_data = check_login($con);

?>



<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>School System</title>
	<link rel="stylesheet" href="styles.css">
	<style>
	
	table {
                border-collapse: collapse;
            }
            th {
                background-color:#92a6e2;
                Color:white;
            }
            th, td {
                width:150px;
                text-align:center;
                border:1px solid black;
                padding:0px
              
            }
            .geeks {
                border-right:hidden;
            }
            .gfg {
                border-collapse:separate;
                border-spacing:0 15px;
            }
	</style>
	
	<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$(".hamburger").click(function(){
			   $(".wrapper").toggleClass("collapse");
			});
		});
	</script>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
	<script type="text/javascript">
	
	function displayStudentList(dropdown) {
    let actionList = document.getElementById("action_list").value;
    if (actionList === 'Fetch') {
        	document.getElementById("student_list").style.display = "block";
	   document.getElementById("subject_list").style.display = "none";
	   document.getElementById("class_list").style.display = "none";
	   document.getElementById("status_list").style.display = "none";
	   document.getElementById("Sex").style.display = "none";
	   document.getElementById("teachers_list").style.display = "none";
	   document.getElementById("AllS").style.display = "none";
	   document.getElementById("Age").style.display = "none";
	   document.getElementById("Snumber").style.display = "none";
    }
    if (actionList === 'Count') {
        document.getElementById("student_list").style.display = "none";
	   document.getElementById("subject_list").style.display = "block";
	   document.getElementById("class_list").style.display = "block";
	   document.getElementById("status_list").style.display = "none";
	   document.getElementById("Sex").style.display = "none";
	   document.getElementById("teachers_list").style.display = "none";
	   document.getElementById("AllS").style.display = "none";
	   document.getElementById("Age").style.display = "none";
	   document.getElementById("Snumber").style.display = "none";
    }
    if (actionList === 'Percentage') {
        document.getElementById("student_list").style.display = "none";
	   document.getElementById("subject_list").style.display = "block";
	   document.getElementById("class_list").style.display = "block";
	   document.getElementById("status_list").style.display = "block";
	   document.getElementById("Sex").style.display = "none";
	   document.getElementById("teachers_list").style.display = "none";
	   document.getElementById("AllS").style.display = "none";
	   document.getElementById("Age").style.display = "none";
	   document.getElementById("Snumber").style.display = "none";
    }
}


function studentAc(dropdown){
	 let studentl = document.getElementById("student_list").value;
	
	if (studentl === 'All'){
   document.getElementById("Sex").style.display = "none";
   document.getElementById("subject_list").style.display = "block";
   document.getElementById("class_list").style.display = "none";
   document.getElementById("student_list").style.display = "none";
   document.getElementById("status_list").style.display = "none";
   document.getElementById("teachers_list").style.display = "none";
   document.getElementById("AllS").style.display = "block";
   document.getElementById("Age").style.display = "block";
	   

	  
	   
	 }
	 if(studentl === 'NameS'){
		  document.getElementById("Sex").style.display = "block";
   document.getElementById("subject_list").style.display = "block";
   document.getElementById("class_list").style.display = "block";
   document.getElementById("student_list").style.display = "block";
   document.getElementById("status_list").style.display = "none";
   document.getElementById("teachers_list").style.display = "none";
   document.getElementById("AllS").style.display = "none";
   document.getElementById("Age").style.display = "none";
	   
	  
	 }
	  if(studentl === 'Teachers'){
	      document.getElementById("Sex").style.display = "none";
   document.getElementById("subject_list").style.display = "block";
   document.getElementById("class_list").style.display = "none";
   document.getElementById("student_list").style.display = "block";
   document.getElementById("status_list").style.display = "none";
   document.getElementById("teachers_list").style.display = "none";
   document.getElementById("AllS").style.display = "none";
   document.getElementById("Age").style.display = "none";
   document.getElementById("Snumber").style.display = "block";
	   
	  }
	 
	
	
}
</script>
</head>
<body>

	<div class="wrapper">
  <div class="top_navbar">
    <div class="hamburger">
       <div class="one"></div>
       <div class="two"></div>
       <div class="three"></div>
    </div>
    <div class="top_menu">
	<a class="fas fa-user" href="logout.php" >Logout</a>
        
    </div>
  </div>
  
 <div class="sidebar">
      <ul>
        <li><a href="index2.php">
          
          <span class="title">Home</span></a></li>
        <li><a href="students.php">
          
          <span class="title">Students</span>
          </a></li>
        <li><a href="teachers.php">
          
          <span class="title">Teachers</span>
          </a></li>
        <li><a href="subjects.php" class="active">
          
          <span class="title">Subjects</span>
          </a></li>
        <li><a href="classes.php">
         
          <span class="title">Classes</span>
          </a></li>
    </ul>
  </div>
  
  <div class="main_container">
    <form action="submit.php" method="post">
        <select name="action_list" id="action_list"  onchange="displayStudentList()">
            <option value="" id="action">--Select Action--</option>
            <option value="Fetch">Fetch</option>
            <option value="Count">Count</option>
            <option value="Percentage">Percentage</option>
        </select>
        <select name="student_name" id ="student_list"  onChange="studentAc()" style="display:none;">  
            <!--onchange="getNext(this.value);" -->
            <option value="">--Select  Action --</option>
            <option value="All">All Students</option>
            <option value="NameS">Student Name</option>
			 <option value="Teachers">Teachers</option>
        </select>
		<br>
  			
  				<select name="subject_name" id= "subject_list" style="display:none;">
  				<option value="pick">--Select Subject--</option>
  				<?php
  				$sql = mysqli_query($con, "SELECT DISTINCT subject_name From subject_srms order by  subject_id");
  				$row = mysqli_num_rows($sql);
  				while ($row = mysqli_fetch_array($sql)){
  				echo "<option value='". $row['subject_name'] ."'>" .$row['subject_name'] ." </option>";
  				
  			
  				}
  				?>
  				<option value="pick">All</option>
  				</select>
  			
  			
  			<br>
  			
  				<select name="class_name" class="form-control" id= "class_list" style="display:none;">
  					<option value="pick">--Select Student Class--</option>
  					<?php
  					$sql = mysqli_query($con, "SELECT DISTINCT  class_name From class_srms order by  class_id");
  					$row = mysqli_num_rows($sql);
  					while ($row = mysqli_fetch_array($sql)){
  					echo "<option value='". $row['class_name'] ."'>" .$row['class_name'] ."</option>" ;
  					}
  					?>
  					<option value="Fetch">All</option>
  				</select>
  			
  			<br>
  				<select name="teacher_name" class="form-control"  id= "teachers_list"  onChange=";" style="display:none;">
  				<option value="" id="action">--Select Teachers--</option>
  				<option value="Fetch">All</option>
  				</select>
  			
  			
  			<br>
  			
  					<select name="student_status" class="form-control" id= "status_list" onChange=";" style="display:none;">
  					<option value="pick">--Select Student Status--</option>
  						<?php
  						$sql = mysqli_query($con, "SELECT DISTINCT student_status From student_srms order by  student_id");
  						$row = mysqli_num_rows($sql);
  						while ($row = mysqli_fetch_array($sql)){
  						echo "<option value='". $row['student_status'] ."'>" .$row['student_status'] ."</option>" ;
  						}
  						?>
  					</select>				
  			   		
  			<br>
  		<div id="AllS" style="display:none;">
  				<h4>Select Student Score up to:</h4>
  				<input type="text" id="marks" name="marks"> <br>
  				<br>
  				<h4>Does student has dept?</h4>
  				<label class="container">Yes
  					  <input type="radio" checked="checked" name="student_dept" value="True">
  					  <span class="checkmark"></span>
  				</label>
  				<label class="container">No
  					  <input type="radio" name="student_dept" value="False">
  					  <span class="checkmark"></span>
  				</label>
  				<br><br>
  				<h4>Completed project</h4>
  				<label class="container">Yes
  					  <input type="radio" checked="checked" name="project" value="yes">
  					  <span class="checkmark"></span>
  				</label>
  				<label class="container">No
  					  <input type="radio" name="project" value="no">
  					  <span class="checkmark"></span>
  				</label>
  				<br><br>
  		
  		</div>
  		
  		<br>
  		<div id="Age"  style="display:none;">
  			<h4>Select Student Age up to:</h4>
  				<input type="text" id="student_age" name="student_age"> <br>
  				<br>
  		</div>
  		
  		<div id="Snumber" style="display:none;">
  			<h4>Number Of Students:</h4>
  			<input type="sn" id="sn" name="student_id"><br>
  			<br>
  		</div>
  		<div id="Sex" onChange=";" style="display:none;">
  			<h4>Sex</h4>
  			<label class="container">Male
  				  <input type="radio" checked="checked" name="student_gender" value="Male">
  				  <span class="checkmark"></span>
  			</label>
  			<label class="container">Female
  				  <input type="radio" name="student_gender" value="Female">
  				  <span class="checkmark"></span>
  			</label>	
  				<br>
  				<br>
  				
  		</div>		
  		<br>
  		<input type="submit" name="submit" value="Submit" >
		
	
		
    </form>
</div>
</body>
</html>