<?php
$name = $_POST['name'];
$email = $_POST['email'];
$phone = $_POST['phone'];
$service = $_POST['service'];
$date = $_POST['date'];
$time = $_POST['time'];

echo "<div class='row'>
		<div class='col-6'><strong>Name:</strong></div>
		<div class='col-6'>$name</div>
	</div>";
echo "<div class='row'>
		<div class='col-6'><strong>Email:</strong></div>
		<div class='col-6'>$email</div>
	</div>";
echo "<div class='row'>
		<div class='col-6'><strong>Phone:</strong></div>
		<div class='col-6'>$phone</div>
	</div>";
echo "<div class='row'>
		<div class='col-6'><strong>Service:</strong></div>
	
