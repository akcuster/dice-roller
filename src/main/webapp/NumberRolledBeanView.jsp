<%@ page import="java.util.ArrayList" %>
<%@ page import="com.diceRoller.DiceRoller" %>
<!DOCTYPE html>
<!--
    Author: Amber Custer
    Date: 11/15/2020
-->
<html>
    <head>
        <title>Dice Roller</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/styles.css">
    </head>

    <body>
    <div class="container">
        <header>
            <h1>You rolled a ${numberRolled}</h1>
        </header>
        <main class="output">
            <div class="roll">
                <img src="${diceImage}" alt="A many sided die">

                <a class="button" href="index.jsp">Roll Again?</a>
            </div>
            <div class="table">
                <table>
                    <tr><th>Number of Sides</th><th>Number Rolled</th></tr>
                    <%--
                        Get the ArrayList of DiceRoller javaBeans, loop through them, and for each one output the
                        number of sides and the number rolled to a table
                    --%>
                    <%
                        ArrayList<DiceRoller> diceRolls = (ArrayList<DiceRoller>)request.getAttribute("diceRollerList");
                        for (DiceRoller dice : diceRolls) {
                            out.println("<tr><td>" + dice.getNumberSides() + "</td>");
                            out.println("<td>" + dice.getNumberRolled() + "</td></tr>");
                        }
                    %>
                </table>
                <%-- a link that sends the clear parameter set to true to the controller  --%>
                <a class="button" href="diceController?clear=true">Clear all rolls?</a>
            </div>
        </main>
        <footer>
            <p>Created By: Amber Custer, Ross Degrand, Subheksha Karki</p>
        </footer>
    </div>
    </body>
</html>
