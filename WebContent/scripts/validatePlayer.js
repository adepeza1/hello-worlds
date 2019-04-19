var message = "";
function isValidFields() {
	//alert("hii")
	var b=false;
	var pname = document.getElementById("pname").value;
	var email = document.getElementById("email").value;
	var contact = document.getElementById("contact").value;

	if (pname == "" || email == "" || contact == "") {
	
		message = "All fields required";
	} else {
		message = "";
		b = true;
	}
	if (b == true) {
		b=(isValidPlayerName(pname) && isValidEmail(email) && isValidContact(contact));
		
	}

	document.getElementById("errMsg").innerText = message;
	return b;
}
	function isValidPlayerName(pname) {
		var b1 = false;
		if (pname.match(/^[a-zA-Z]{2,12}$/)) {
			b1 = true;

		} else {
			message = "Invalid Name"
		}
		return b1;

	}
	function isValidEmail(email) {
		b2 = false;
		if (email.match(/^(.*)@(.*)$/)) {
			b2 = true;
		} else {
			message = "Invalid email"
		}
		return b2;
	}
	function isValidContact(contact) {
		b2 = false;
		if (contact.match(/^[0-9]{10}$/)) {
			b2 = true;
		} else {
			message = "Invalid contact"
		}
		return b2;
	}
