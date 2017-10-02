$(document).ready(function() {
	$("#transmit").click(function(){
		transmítTwitter();
	});
});

function transmítTwitter(){
	var button = $(this);
	button.attr("disabled", true);

	// 通信実行
	$.ajax({
		type:"post",
		url:"/connect/twitter",

		success: function() {
			window.location.href = "/logout";
		},
		error: function() {         // HTTPエラー時
			alert("Server Error. Pleasy try again later.");
		},
		complete: function() {
			button.attr("disabled", false);
		}
	});

}
