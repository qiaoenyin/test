<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="../js/clienthint.js"></script>
</head>
<body>
	<form>
		First Name:<input type="text" id="txt1" onkeyup="showHint(this.value)" />
	</form>
	<p>
		Suggestions: <span id="txtHint"></span>
	</p>
</body>
</html>