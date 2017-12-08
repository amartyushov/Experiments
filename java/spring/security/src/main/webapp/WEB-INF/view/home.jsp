<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<body>
    <h1>Spring MVC Hello World Example</h1>

    <form:form action="${pageContext.request.contextPath}/logout"
    			   method="POST">
    			   <!-- endpoint provided by Spring Security out of the box-->

    	<input type="submit" value="Logout" /> <!-- value="Logout" is just what will be written on the button-->
    </form:form>

</body>
</html>