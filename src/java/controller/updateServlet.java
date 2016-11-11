/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAL;
import model.Laptop;

/**
 *
 * @author Duyet
 */
public class updateServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();

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

        String lapID = request.getParameter("id");
        DAL dal = new DAL();
        Laptop laptop = dal.getById(lapID);
        request.setAttribute("editLap", laptop);
        request.setAttribute("editLapId", laptop.getLapID());
        request.setAttribute("editLapName", laptop.getLapName());
        request.setAttribute("editPrice", laptop.getPrice());
        request.getRequestDispatcher("Update.jsp").forward(request, response);
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

        String errMsg = null;
        String err1 = null;
        boolean status = false;
        try {
            String lapID = request.getParameter("lapId");
            String lapName = request.getParameter("lapName");
            int price = Integer.parseInt(request.getParameter("price"));
            DAL dal = new DAL();
            status = dal.update(lapID, lapName, price);
        } catch (NumberFormatException e) {
            err1 = "Price: please input valid price.";
        } catch (Exception e) {
        }
        if (status) {
            request.getRequestDispatcher("showServlet").forward(request, response);
        } else {
            errMsg = "Cannot update this product, please double-check the input";
            request.setAttribute("err", errMsg);
            request.setAttribute("err1", err1);
            request.getRequestDispatcher("Update.jsp").forward(request, response);
        }

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
