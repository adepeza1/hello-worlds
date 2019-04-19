var message = "";
function isValidFields() {
	//alert("hii")
	var b=false;
	var teamid = document.getElementById("teamid").value;
	var teamname = document.getElementById("teamname").value;
	var coach = document.getElementById("coach").value;

	if (teamid == "" || teamname == "" || coach == "") {
	
		message = "All fields required";
	} else {
		message = "";
		b = true;
	}
	if (b == true) {
		b=isValidTeamId(teamid)&&isValidTeamName(teamname)&&isValidCoachName(coach);
		// b=isValidPassword(password);
	}

	document.getElementById("errMsg").innerText = message;
	return b;
}
	function isValidTeamId(teamid) {
		var b1 = false;
		if (teamid.match(/^[0-9]{3}$/)) {
			b1 = true;

		} else {
			message = "Invalid Id"
		}
		return b1;

	}
	function isValidTeamName(teamname) {
		b2 = false;
		if (teamname.match(/^[a-zA-Z]{3,15}$/)) {
			b2 = true;
		} else {
			message = "Invalid Team name"
		}
		return b2;
	}
	function isValidCoachName(coach) {
		b2 = false;
		if (coach.match(/^[a-zA-Z]{2,15}$/)) {
			b2 = true;
		} else {
			message = "Invalid coach name"
		}
		return b2;
	}

