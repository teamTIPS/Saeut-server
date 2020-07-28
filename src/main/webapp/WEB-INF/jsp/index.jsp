<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h2>Hello World! here is index.jsp</h2>

	<a class="nav-link js-scroll-trigger"
		href="<c:url value="/shop/signon.do"><c:param name="id" value="chaong2"/></c:url>">
		<font color="black">LOGIN</font></a>


</html>
