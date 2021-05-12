/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Backend.Entity;
import Backend.Errorsphone;
import Backend.ValidateErrors;
import Backend.phonelist;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rajanbastakoti
 */
public class ErrorValid extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession session = request.getSession();
            String nextpage = "/input.jsp";
            //getting values from the form
            String brand = request.getParameter("brand");
            String family = request.getParameter("family");
            String model = request.getParameter("model");
            String price = request.getParameter("price");
            String imei = request.getParameter("imei");
            
            
        
            Errorsphone error = new Errorsphone();
        //finding if the errors are true or false
        boolean isBrandMissing = ValidateErrors.validateBrand(brand, error);
        boolean isFamilyValid = ValidateErrors.validateFamily(family, error);
        boolean isModelValid = ValidateErrors.validateModel(model, error);
        boolean isImeiValid = ValidateErrors.validateImei(imei, error);
        boolean isPriceValid = ValidateErrors.validatePrice(price, error);
        //check if there is no error
        if (isBrandMissing && isFamilyValid && isPriceValid && isModelValid && isImeiValid){
            phonelist phonebox = (phonelist) session.getAttribute("phonebox");
            if (phonebox == null){
                phonebox = new phonelist();
            }
            
        Entity addingphone = new Entity(brand, family, model, imei, Double.parseDouble(price));
        phonebox.addphones(addingphone);
        //add data to database if error free
        phonelist.basePhones(brand, family, imei, model, price);
        //load data in database
        phonebox.loadPhones();
        
            
        nextpage = "/testResult.jsp";
        session.setAttribute("phonebox", phonebox);
        session.setAttribute("currentphone", phonebox.searchByIMEI(imei));
                
                
        
        
        }
        else{
            request.setAttribute("error", error);
        }
        //forward to the desired next page
        getServletContext().getRequestDispatcher(nextpage).forward(request,response);
      }
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

