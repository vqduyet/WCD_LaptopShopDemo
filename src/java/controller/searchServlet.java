/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAL;

/**
 *
 * @author Duyet
 */
public class searchServlet extends HttpServlet {

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

        List list = null;
        String errMsg = null;

        String minS = request.getParameter("min");
        String maxS = request.getParameter("max");
        String lapName = request.getParameter("sName");
        String radValue = request.getParameter("radioSearch").toString();
        String radValueBack = null;
        DAL dal = new DAL();

        try {
            if (radValue.equalsIgnoreCase("searchPrice")) {
                radValueBack = "searchPrice";
                if (!(minS.equals("") || maxS.equals(""))) {
                    int minPrice = Integer.parseInt(minS);
                    int maxPrice = Integer.parseInt(maxS);
                    list = dal.searchByPrice(minPrice, maxPrice);
                } else if (!minS.equals("") && maxS.equals("")) {
                    int minPrice = Integer.parseInt(minS);
                    list = dal.searchByPriceMin(minPrice);
                } else if (minS.equals("") && !maxS.equals("")) {
                    int maxPrice = Integer.parseInt(maxS);
                    list = dal.searchByPriceMax(maxPrice);
                } else if ((minS.equals("") && maxS.equals(""))) {
                    list = dal.showAll();
                }
            } else if (radValue.equalsIgnoreCase("searchName")) {
                radValueBack = "searchName";
                if(!lapName.equals("")){
                    list = dal.searchByName(lapName);
                }
                else {
                    list = dal.showAll();
                }
            }
        } catch (NumberFormatException e) {
            errMsg = "Search boxes only accept integer numbers.<br/>";
        } catch (Exception e) {
            errMsg += e.getMessage();
        }
        request.setAttribute("radValue", radValueBack);
        request.setAttribute("err", errMsg);
        request.setAttribute("list", list);
        request.getRequestDispatcher("Show.jsp").forward(request, response);
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
