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
                border-collapse:collapse;
                border-spacing:0 15px;
            }
	</style>
	
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
    <div class="item">
  
				<table>
				<tr>
						<th> Student Name</th> 
						<th> Student Email</th>
						<th> Student Gender</th>
						<th> Student Dept</th> 
						<th> Student Status</th> 
						<th> Student Age</th> 
					</tr> 
				</table>
				<table class = "gfg">
					<?php
						 $query="SELECT student_name, student_email, student_gender, student_dept,student_status, student_age FROM student_srms";
						
						 
						$data= mysqli_query($con,$query) or die ('error');
						if (mysqli_num_rows($data)>0){
						
							while($row=mysqli_fetch_assoc($data)){
								$name=$row['student_name'];
								$student_email=$row['student_email'];
								$student_gender=$row['student_gender'];
								$student_dept=$row['student_dept'];
								$student_status=$row['student_status'];
								$student_age=$row['student_age'];
							?>
							<tr> 
								<td> <?php echo $name;?></td>  
								<td> <?php echo $student_email;?></td>  
								<td> <?php echo $student_gender;?></td>  
								<td> <?php echo $student_dept;?></td> 
								<td> <?php echo $student_status;?></td>
								<td> <?php echo $student_age;?></td> <br>
							</tr>
						<?php							
							}
						}
						else {
							?>
							<tr> 
								<td>Records Not found</td>
							</tr>
							<?php
						}
					
					
					?>
				</table>
  </div>
</div>
	
</body>
</html>