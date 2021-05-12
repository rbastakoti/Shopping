/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Backend.Entity;
import Backend.phonelist;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rajanbastakoti
 */

import Backend.*;


public class validation extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //generate an empty list   
        phonelist phonebox =new phonelist();
             
            /* TODO output your page here. You may use following sample code. */
            //create three objects using Entity class
            Entity galaxy= new Entity("Samsung","Galaxy","A21","350111234987",259.99);
            Entity iphone= new Entity("Apple","Iphone","11","235999876457",699.99);
            Entity lg = new Entity("LG","STYLO","6","555999246457",255.99);
            
            
            //Populate the empty list
            phonebox.addphones(galaxy);
            phonebox.addphones(iphone);
            phonebox.addphones(lg);
            
            
            //add the list object to the session
            HttpSession session = request.getSession();
            //checks if the session is empty
            if (session.getAttribute("phonebox") == null){
            session.setAttribute("phonebox", phonebox);
            }
            //next page is the display page
            String nextPage = "/testResult.jsp";
    
            getServletContext().getRequestDispatcher(nextPage).forward(request, response);
    }
        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
