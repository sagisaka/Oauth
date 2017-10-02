$(document).ready(function() {
	$("#logout").click(function(){
		logout();
	});
});

function logout(){
	$.ajax({
		type: 'GET',
		url:  '/api/Oauth/logout',
		success: function() {
			window.location.href = "/logout";
		},
		error: function() {         // HTTPエラー時
			alert("Server Error. Pleasy try again later.");
		}
	});
}
