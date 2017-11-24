<!DOCTYPE html>
<html>
    <head>
        <title> Registration form</title>
    </head>

    <body>
        <form action="processForm" method="GET">
            <input type="text" name="studentName" placeholder="insert name"/>
            <input type="submit"/>
        </form>

        <form action="processFormUppercase" method="GET">
            <input type="text" name="studentName" placeholder="insert name and get it as upper case"/>
            <input type="submit"/>
        </form>

        <form action="processFormUppercaseWithRequestParam" method="GET">
            <input type="text" name="studentName" placeholder="using request params"/>
            <input type="submit"/>
        </form>
    </body>
</html>