<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function test(){
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
<button name='index_test' id='index_test' value='数据库连接测试' onclick='test();'>
</button></form>
</body>
</html>