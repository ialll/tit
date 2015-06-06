<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryform/2.8/jquery.form.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.core.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.widget.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.tabs.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/json2.js" />"></script>
<script type="text/javascript">
MvcUtil = {};
MvcUtil.showSuccessResponse = function (text, element) {
	MvcUtil.showResponse("success", text, element);
};
MvcUtil.showErrorResponse = function showErrorResponse(text, element) {
	MvcUtil.showResponse("error", text, element);
};
MvcUtil.showResponse = function(type, text, element) {
	var responseElementId = element.attr("id") + "Response";
	var responseElement = $("#" + responseElementId);
	if (responseElement.length == 0) {
		responseElement = $('<span id="' + responseElementId + '" class="' + type + '" style="display:none">' + text + '</span>').insertAfter(element);
	} else {
		responseElement.replaceWith('<span id="' + responseElementId + '" class="' + type + '" style="display:none">' + text + '</span>');
		responseElement = $("#" + responseElementId);
	}
	responseElement.fadeIn("slow");
};
MvcUtil.xmlencode = function(xml) {
	//for IE 
	var text;
	if (window.ActiveXObject) {
	    text = xml.xml;
	 }
	// for Mozilla, Firefox, Opera, etc.
	else {
	   text = (new XMLSerializer()).serializeToString(xml);
	}			
	    return text.replace(/\&/g,'&'+'amp;').replace(/</g,'&'+'lt;')
        .replace(/>/g,'&'+'gt;').replace(/\'/g,'&'+'apos;').replace(/\"/g,'&'+'quot;');
};
function test(){
	var link = $('#index_test');
	$.ajax({
		url: link.attr("href"),
		dataType: "text",
		beforeSend: function(req) { req.setRequestHeader("Accept", "text/plain;charset=UTF-8"); }, 
		success: function(text) { MvcUtil.showSuccessResponse(text, link); },
		error: function(xhr) { MvcUtil.showErrorResponse(xhr.responseText, link); }});
}
</script>
</head>
<body>
<form >
<button name='index_test' id='index_test' onclick='javscript:test();'>		<a 
				href="<c:url value="/DBtest/direct" />">数据库连接测试</a>
</button></form>
</body>
</html>