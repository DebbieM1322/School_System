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

<?php
if(isset($_POST['action_list'])){
    $action_list = $_POST['action_list'];
	$student_name = $_POST['student_name'];
    switch ($action_list) {
        case 'Fetch':
				if(isset($_POST['student_name'])){
					$student_name = $_POST['student_name'];
					$subject_name=$_POST['subject_name'];
					$student_status=$_POST['student_status'];
					$student_age=$_POST['student_age'];
					$student_dept=$_POST['student_dept'];
					$class_name=$_POST['class_name'];
					$marks=$_POST['marks'];
					$project=$_POST['project'];
					$student_gender=$_POST['student_gender'];
					
				
					switch ($student_name) {
						case 'All':
							echo $student_age;
							if(isset($_POST['student_age'])){
								
								echo "<table border='1'>
								<tr>
								<th>Students Name(s)</th>
								</tr>";
							$query="SELECT student_srms.student_name FROM student_srms 
							JOIN subject_srms on subject_srms.subject_id=student_srms.subject_id
							WHERE student_age >='$student_age' AND subject_srms.subject_name='$subject_name'";
			
									$data= mysqli_query($con,$query) or die ('error');
									echo "<br>";
								
									
									
									if (mysqli_num_rows($data)>0){
									
										while($row=mysqli_fetch_assoc($data)){
										{
											echo "<tr>";
											//echo "<td>". $insights->data[N]->values[M]->value. "</td>";
											echo "<td>" . $row['student_name'] . "</td>";
											echo "</tr>";
											}
											echo "</table>";}
												
										
									}
									else {
										echo "Error";
											}
							}
							else{
								echo "all1";

							echo "<table border='1'>
								<tr>
								<th>Students Name(s)</th>
								</tr>";
							$query="SELECT DISTINCT student_name FROM student_srms 
							JOIN marks_srms on marks_srms.student_id=student_srms.student_id
							JOIN class_srms on class_srms.student_id=student_srms.student_id 
							WHERE marks_srms.marks >='$marks' and class_srms.project ='$project'
								AND student_srms.student_dept = '$student_dept'";
			
									$data= mysqli_query($con,$query) or die ('error');
									echo "<br>";
								
									
									
									if (mysqli_num_rows($data)>0){
									
										while($row=mysqli_fetch_assoc($data)){
										{
											echo "<tr>";
											//echo "<td>". $insights->data[N]->values[M]->value. "</td>";
											echo "<td>" . $row['student_name'] . "</td>";
											echo "</tr>";
											}
											echo "</table>";}
												
										
									}
									
									else {
										echo "Error";
											}
								}
							break;
						case 'NameS':
							echo "<table border='1'>
								<tr>
								<th>Students Name(s)</th>
								</tr>";
							$query="SELECT student_srms.student_name,subject_srms.subject_name FROM student_srms JOIN subject_srms on subject_srms.subject_id=student_srms.subject_id JOIN class_srms on class_srms.class_id=student_srms.class_id WHERE class_srms.class_name='$class_name' AND student_gender='$student_gender'";
			
									$data= mysqli_query($con,$query) or die ('error');
									echo "<br>";
								
									
									
									if (mysqli_num_rows($data)>0){
									
										while($row=mysqli_fetch_assoc($data)){
										{
											echo "<tr>";
											//echo "<td>". $insights->data[N]->values[M]->value. "</td>";
											echo "<td>" . $row['student_name'] . "</td>";
											echo "</tr>";
											}
											echo "</table>";}
												
										
									}
									else {
										echo "Error";
											}
							break;
							
						 case 'Teachers':
							echo "<table border='1'>
								<tr>
								<th>Teachers Name(s)</th>
								</tr>";
							$query="SELECT teacher_name FROM teachers
									JOIN class_srms on class_srms.class_id=teachers.class_id
									WHERE class_srms.class_name='$class_name' AND student_id=0'";
									$data= mysqli_query($con,$query) or die ('error');
									echo "<br>";
								
									
									
									if (mysqli_num_rows($data)>0){
									
										while($row=mysqli_fetch_assoc($data)){
										{
											echo "<tr>";
											//echo "<td>". $insights->data[N]->values[M]->value. "</td>";
											echo "<td>" . $row['teacher_name'] . "</td>";
											echo "</tr>";
											}
											echo "</table>";}
												
										
									}
									else {
										echo "Error";
											}
							break;	
						default:
									   echo 'Error <br/>';

							break;
					}
				}
            break;
        case 'Count':
		
					$student_name = $_POST['student_name'];
					$subject_name=$_POST['subject_name'];
					$student_status=$_POST['student_status'];
					$student_age=$_POST['student_age'];
					$student_dept=$_POST['student_dept'];
					$class_name=$_POST['class_name'];
					$marks=$_POST['marks'];
					$project=$_POST['project'];
					$student_gender=$_POST['student_gender'];
					echo "<table border='1'>
								<tr>
								<th>Number of Students</th>
								</tr>";
								$query="SELECT COUNT(student_name) AS NumberOfStudents FROM student_srms JOIN subject_srms on subject_srms.subject_id=student_srms.subject_id  JOIN class_srms on class_srms.class_id=student_srms.class_id WHERE class_srms.class_name='$class_name' AND subject_srms.subject_name='$subject_name'";
					
						$data= mysqli_query($con,$query) or die ('error');
						if (mysqli_num_rows($data)>0){
						
							while($row=mysqli_fetch_assoc($data)){
							{
								echo "<tr>";
								echo "<td>" . $row['NumberOfStudents'] . "</td>";
								echo "</tr>";
								}
								echo "</table>";}
									
							
						}
						else {
							echo "wrng";
						}
			
		 case 'Percentage':
					$student_name = $_POST['student_name'];
					$subject_name=$_POST['subject_name'];
					$student_status=$_POST['student_status'];
					$student_age=$_POST['student_age'];
					$student_dept=$_POST['student_dept'];
					$class_name=$_POST['class_name'];
					$marks=$_POST['marks'];
					$project=$_POST['project'];
					$student_gender=$_POST['student_gender'];
					echo "<table border='1'>
								<tr>
								<th>Percentage of Students</th>
								</tr>";
								$query="SELECT CONCAT ((SELECT (COUNT(student_name)/(SELECT COUNT(student_name) AS PercentageofStudents FROM student_srms)*100) AS NumberOfStudents FROM student_srms 
							JOIN subject_srms on subject_srms.subject_id=student_srms.subject_id
							JOIN class_srms on class_srms.class_id=student_srms.class_id
							WHERE student_status='$student_status' AND subject_srms.subject_name='$subject_name' AND class_srms.class_name='$class_name'),'%')";
					
						$data= mysqli_query($con,$query) or die ('error');
						if (mysqli_num_rows($data)>0){
						
							while($row=mysqli_fetch_assoc($data)){
							{
								echo "<tr>";
								echo "<td>" . $row['PercentageofStudents'] . "</td>";
								echo "</tr>";
								}
								echo "</table>";}
									
							
						}
						else {
							echo "wrng";
						}
            break;	
        default:
                       echo 'v blalala <br/>';

            break;
    }
}
?>

</div>
</body>
</html>