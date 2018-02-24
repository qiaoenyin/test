
var xmlHttp;
function showHint(str) {
	if (str.length == 0) {
		document.getElementById("txtHint").innerHTML = "";
		return;
	}
	xmlHttp = GetXmlHttpObject();
	if (xmlHttp == null) {
		alert("您的浏览器不支持AJAX！");
		return;
	}
	var url = "gethint.asp";
	url = url + "?q=" + str;
	url = url + "&sid=" + Math.random();
	xmlHttp.onreadystatechange = stateChanged;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}

function stateChanged() {
	if (xmlHttp.readyState == 4) {
		document.getElementById("txtHint").innerHTML = xmlHttp.responseText;
	}
}

function GetXmlHttpObject() {
	var xmlHttp = null;
	try {
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	return xmlHttp;
}