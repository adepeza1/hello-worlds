var message="";
function isValidUser(){
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var b = false;
	
	if(username == ""|| password==""){
		message="Userid and password is required";
	}
	else{
		message="";
		b=true;
	}
	if(b==true){
		b=isValiduserId(username);
		if(b==true){
			b=isValidPassword(password);
		}
		
	}
	
	document.getElementById("errMsg").innerText=message;
	return b;
	
	function isValiduserId(username){
		var b1 = false;
		if(username.match(/^[a-zA-Z]{3,5}$/)){
			b1=true;
			
		}
		else{
			message="Invalid Userid/Passowrd"
		}
		return b1;
		
	}
	function isValidPassword(password){
		var b2=false;
		if(password.match(/^[a-zA-Z]{6,10}$/)){
			b2=true;
		}
		else{
			message="Invalid Userid/Passowrd"
		}
		return b2;
	}
}