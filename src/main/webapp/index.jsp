<!DOCTYPE html>
<!--
    Author: Amber Custer
    Date: 11/15/2020
-->
<html>
    <head>
        <title>Roll the Dice!</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
    <div class="container">
        <header>
            <h1>Choose Your Weapon - Roll the Dice!</h1>
        </header>
        <main>

            <ul>
                <%-- Links that send the number of sides chosen in a URL parameter --%>
                <li>
                    <a href="diceController?sides=4"><img src="images/4-0.png" alt="a blank 4 sided die"><br/>4 sided</a>
                </li>
                <li>
                    <a href="diceController?sides=6"><img src="images/6-0.png" alt="a blank 6 sided die"><br/>6 sided</a>
                </li>
                <li>
                    <a href="diceController?sides=8"><img src="images/8-0.png" alt="a blank 6 sided die"><br/>8 sided</a>
                </li>
                <li>
                    <a href="diceController?sides=10"><img src="images/10-0.png" alt="a blank 10 sided die"><br/>10 sided</a>
                </li>
                <li>
                    <a href="diceController?sides=12"><img src="images/12-0.png" alt="a blank 12 sided die"><br/>12 sided</a>
                </li>
                <li>
                    <a href="diceController?sides=20"><img src="images/20-0.png" alt="a blank 20 sided die"><br/>20 sided</a>
                </li>
            </ul>
        </main>
        <footer>
            <p>Created By: Amber Custer, Ross Degrand, Subheksha Karki</p>
        </footer>
    </div>
    </body>
</html>
