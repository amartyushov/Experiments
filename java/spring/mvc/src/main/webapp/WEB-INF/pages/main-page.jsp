<!DOCTYPE html>
<html>
    <body>
        <h2> Spring mcv demo <h2/>
        <hr>

        <a href="register"> Registration form </a> <!-- for href use @RequestMapping values-->
        <br>
        <a href="parentMapping/register"> with a parentMapping </a> <!-- for href use @RequestMapping values-->

        <br>
        <a href="student/showForm"> student registration (@ModelAttribute) </a>

        <br>
        <a href="customer/showForm"> customer registration with validation</a>
    <body/>
<html/>