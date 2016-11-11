package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Laptop;

public final class Update_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>        \n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"./resources/bootstrap/css/bootstrap.css\"/>\n");
      out.write("        <script type=\"text/javascript\" src=\"./resources/jquery/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"./resources/bootstrap/js/bootstrap.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--menu-->\n");
      out.write("        <nav id=\"nav_bar\" class=\"navbar navbar-inverse\">\n");
      out.write("            <div class=\"container-fluid\">                \n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <!--icon for collapsed menu items-->\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#mainNavBar\">\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <!--logo -->\n");
      out.write("                    <a href=\"index.jsp\" class=\"navbar-brand\">LAPTOP WORLD</a>\n");
      out.write("                </div>                \n");
      out.write("                <!--menu items -->\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"mainNavBar\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                        <li><a href=\"showServlet\">List</a></li>                        \n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <!-- right align -->\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li><a href=\"#\">Logout</a></li>   \n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <!--end of menu-->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Update</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1>Update Item</h1>\n");
      out.write("            <!--error-->\n");
      out.write("            <div class=\"row\">\n");
      out.write("                ");
 if (request.getAttribute("err") != null) {
      out.write("\n");
      out.write("                <p class=\"alert-warning col-md-5\">");
      out.print(request.getAttribute("err"));
      out.write("</p>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("                ");
 if (request.getAttribute("err1") != null) {
      out.write("\n");
      out.write("                <p class=\"alert-warning col-md-5\">");
      out.print(request.getAttribute("err1"));
      out.write("</p>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </div>            \n");
      out.write("\n");
      out.write("            <!--end of error-->\n");
      out.write("            <form action=\"updateServlet\" method=\"post\" class=\"col-md-3\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"lapId\">Laptop ID</label>\n");
      out.write("                    <input type=\"text\"\n");
      out.write("                           disabled=\"true\"\n");
      out.write("                           id=\"lapId\"\n");
      out.write("                           name=\"lapId\"\n");
      out.write("                           class=\"form-control\"\n");
      out.write("                           value=\"");
      out.print(request.getAttribute("editLap") == null ? "" : request.getAttribute("editLapId"));
      out.write("\"\n");
      out.write("                           />\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"lapName\">Laptop Name</label>\n");
      out.write("                    <input type=\"text\"\n");
      out.write("                           id=\"lapName\"\n");
      out.write("                           name=\"lapName\"\n");
      out.write("                           class=\"form-control\"\n");
      out.write("                           value=\"");
      out.print(request.getAttribute("editLap") == null ? "" : request.getAttribute("editLapName"));
      out.write("\"\n");
      out.write("                           />\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"price\">Price</label>\n");
      out.write("                    <input type=\"number\"\n");
      out.write("                           id=\"price\"\n");
      out.write("                           name=\"price\"\n");
      out.write("                           class=\"form-control\"\n");
      out.write("                           value=\"");
      out.print(request.getAttribute("editLap") == null ? "" : request.getAttribute("editPrice"));
      out.write("\"\n");
      out.write("                           />                \n");
      out.write("                </div>\n");
      out.write("                <input type=\"submit\" value=\"Update\" class=\"btn btn-primary\"/> \n");
      out.write("                <input type=\"reset\" value=\"Reset\" class=\"btn btn-default\"/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
