<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- for looping -->

<!DOCTYPE html>

<html>

<head>
	<title>Student Confirmation</title>
</head>

<body>

The student is confirmed: ${student.firstName} ${student.lastName}

<br><br>

Country: ${student.country}

<br>
Country from file: ${student.countryFromFile}

<br>
Favourite Language: ${student.favouriteLanguage}

<br>
Favourite OS:
<ul>
    <c:forEach var="temp" items="${student.favouriteOS}">
        <li>
            ${temp}
        </li>
    </c:forEach>
</ul>



</body>

</html>







