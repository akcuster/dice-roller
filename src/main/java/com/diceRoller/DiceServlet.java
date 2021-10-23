package com.diceRoller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * @author Ross Degrand
 * @author Amber Custer
 * DiceServlet is the com.diceRoller.controller for the dice rolling application
 *
 */
@WebServlet(
        name = "diceServlet",
        urlPatterns = { "/diceController" }
)
public class DiceServlet extends HttpServlet {
    // Create a list variable to hold DiceRoller javaBeans
    List<DiceRoller> myRolls;

    /**
     * Instantiates a new ArrayList and assigns it to the myRolls variable the first time the servlet is accessed
     * @throws ServletException if there's a problem initializing the servlet
     */
    public void init() throws ServletException {
        myRolls = new ArrayList<>();
    }

    /**
     *  Handles HTTP GET requests. Gets the number of dice sides, instantiates a new DiceRoller javaBean and passes
     *  in diceSides to the constructor as a parameter, and adds the new DiceRoller to myRolls. Then checks if the
     *  clear parameter is set to true, If it is, the myRolls ArrayList is cleared and it redirects to the homepage.
     *  If it is not set to true, it sets the number rolled, the dice image, and the myRolls ArrayList into the
     *  attributes and forwards to the output page.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Get the number of sides from the url parameter and assign the number to diceSides
        int diceSides = getNumberOfSidesFromRequest(request);
        // Instantiate a new DiceRoller, passing in the number of sides to the constructor, and assigning it to diceRoller
        DiceRoller diceRoller = new DiceRoller(diceSides);
        // Add the new Dice Roller javaBean to the ArrayList
        myRolls.add(diceRoller);

        // Check if "clear rolls" has been pressed and only run this code if it returns true
        if(shouldResetCount(request)){
            // clear the ArrayList
            myRolls.clear();
            // redirect back to the homepage
            String url = "index.jsp";
            response.sendRedirect(url);
            // Only run this code if "clear rolls" does not return true
        } else {
            // Set the attributes
//            request.setAttribute("numberRolled", diceRoller.getNumberRolled());
//            request.setAttribute("diceImage", diceRoller.getDiceImage());
//            request.setAttribute("diceRollerList", myRolls);
            session.setAttribute("numberRolled", diceRoller.getNumberRolled());
            session.setAttribute("diceImage", diceRoller.getDiceImage());
            request.setAttribute("diceRollerList", myRolls);

            // Forward to the output page
            String url = "/NumberRolledBeanView.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

    }

    /**
     * Gets the number of sides from the URL parameter
     * @param request the HTTP request
     * @return the number of sides
     */
    int getNumberOfSidesFromRequest(HttpServletRequest request){
        // Check that the sides parameter is not null
        if(request.getParameter("sides")!=null)
        {
            // Convert sides value to an integer and return the amount
            return Integer.parseInt(request.getParameter("sides"));
            // If the sides parameter is null, return 1 because the random number generator will only accept positive values
        } else {
            return 1;
        }

    }

    /**
     * Gets the clear parameter from the URL
     * @param request the HTTP request
     * @return a boolean depending on whether or not "clear rolls" has been pressed
     */
    boolean shouldResetCount(HttpServletRequest request){
        // Check that clear is not null
        if (request.getParameter("clear")!=null) {
            // Convert the clear value (true) to a boolean
            return Boolean.parseBoolean(request.getParameter("clear"));
        } else {
            // return false if the "clear rolls" button has not been pressed
            return false;
        }

    }
}

