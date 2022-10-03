<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Sign in</title>
	<link href="static/StyleLogin.css" rel="stylesheet">
	
</head>
<body style="background-color:grey">

	<div class="wrapper">
        <div class="logo">
            <img src="https://th.bing.com/th/id/R.9547261541e93756194b51bc704ead65?rik=qD5meRokAuRdjg&riu=http%3a%2f%2fcdn.onlinewebfonts.com%2fsvg%2fdownload_500737.png&ehk=Xs1fs7%2bPRy3NfKUAq24hlUh7gXjS%2bo20XLO2hTziTO0%3d&risl=&pid=ImgRaw&r=0" alt="">
        </div>
        <div class="text-center mt-4 name">
            @Mail
        </div>
        <form class="p-3 mt-3" action="SignIn" method="post">
        	 <div class="form-field d-flex align-items-center">
                <span class="far fa-user"></span>
                <input type="text" name="firstName" id="firstName" placeholder="First Name">
            </div>
            <div class="form-field d-flex align-items-center">
                <span class="fas fa-key"></span>
                <input type="text" name="lastname" id="lastname" placeholder="Last Name">
            </div>
            <div class="form-field d-flex align-items-center">
                <span class="far fa-user"></span>
                <input type="email" name="email" id="email" pattern=".+@smpt\.local"  placeholder="Mail">
            </div>
            <div class="form-field d-flex align-items-center">
                <span class="fas fa-key"></span>
                <input type="password" name="pwd" id="pwd" placeholder="Password">
            </div>
            <div class="form-field d-flex align-items-center">
                <span class="fas fa-key"></span>
                <input type="password" name="pwd2" id="pwd2" placeholder="Retry Password">
            </div>   
            <button class="btn mt-3">Sing In</button>
        </form>
        <div class="text-center fs-6">
            <a href="#">Forget password?</a> or <a href="#">Sign up</a>
        </div>
    </div>
</body>
</html>
