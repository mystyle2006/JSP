/**
 * 
 */

function loginConfirm(){
	if(document.login_form.id.value.length == 0){
		alert("Please enter your username");
		login_form.id.focus();
		return;
	}
	if(document.login_form.pw.value.length == 0){
		alert("Please enter your password");
		login_form.pw.focus();
		return;
	}

	document.login_form.submit();
}

function infoConfirm(){
	if(document.join_form.id.value.length == 0){
		alert("Please enter your username");
		join_form.id.focus();
		return;
	}
	if(document.join_form.pw.value.length == 0){
		alert("Please enter your password");
		join_form.pw.focus();
		return;
	}
	if(document.join_form.pw.value != document.join_form.confirm_pw.value){
		alert("These passwords don't match");
		join_form.pw.value = "";
		join_form.confirm_pw.value = "";
		join_form.pw.focus();
		return;
	}
	if(document.join_form.name.value.length == 0){
		alert("Please enter your name");
		join_form.name.focus();
		return;
	}
	if(document.join_form.adres.value.length == 0){
		alert("Please enter your address");
		join_form.adres.focus();
		return;
	}
	if(document.join_form.city.value.length == 0){
		alert("Please enter your city");
		join_form.city.focus();
		return;
	}
	if(document.join_form.state.value.length == 0){
		alert("Please enter your state");
		join_form.state.focus();
		return;
	}
	
	document.join_form.submit();
}

function updateInfoConfirm(){
	if(document.edit_form.adres.value.length == 0){
		alert("Please enter address");
		join_form.pw.focus();
		return;
	}
	if(document.edit_form.name.value.length == 0){
		alert("Please enter name");
		join_form.pw.focus();
		return;
	}
	if(document.edit_form.adres.value.length == 0){
		alert("Please enter address");
		join_form.pw.focus();
		return;
	}
	if(document.edit_form.city.value.length == 0){
		alert("Please enter city");
		join_form.pw.focus();
		return;
	}
	if(document.edit_form.state.value.length == 0){
		alert("Please enter state");
		join_form.pw.focus();
		return;
	}
	document.edit_form.submit();
}