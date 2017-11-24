<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

    <!-- When Spring MVC loads the form is calls student.getFirstName() and student.getLastName() and student.getCountryOptions() -->
	<form:form action="processForm" modelAttribute="student">

		    First name: <form:input path="firstName" />

		    <br><br>

		    Last name: <form:input path="lastName" />

		    <br><br>

		    Country:

        		<form:select path="country">
        			<form:options items="${student.countryOptions}" />
        		</form:select>

        		<form:select path="countryFromFile">
                 <form:options items="${countryOptionsFromFile}" />
                </form:select>

        		<br><br>

        		Favourite language:
        		<form:radiobuttons path="favouriteLanguage" items="${student.favouriteLanguages}"/>
        		<br><br>

        		Favourite OS:
                <form:checkboxes path="favouriteOS" items="${student.favouriteOSs}"/>
                <br><br>

		    <input type="submit" value="Submit" />
		<!-- When you push submit: Spring MVC calls student.setFirstName() and student.setLastName() and student.setCountry() -->

	</form:form>


</body>

</html>












