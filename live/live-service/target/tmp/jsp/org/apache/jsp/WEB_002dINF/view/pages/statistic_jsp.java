package org.apache.jsp.WEB_002dINF.view.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class statistic_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      response.setContentType("text/html; charset=utf-8");
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
      out.write("<div class=\"row\">\n");
      out.write("    <div class=\"col-lg-3 col-md-6 col-sm-6\">\n");
      out.write("        <div class=\"card card-stats\">\n");
      out.write("            <div class=\"card-header\" data-background-color=\"green\">\n");
      out.write("                <i class=\"material-icons\">store</i>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card-content\">\n");
      out.write("                <p class=\"category\">频道</p>\n");
      out.write("                <h3 class=\"card-title\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${channelCount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("（个）</h3>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card-footer\">\n");
      out.write("                <div class=\"stats\">\n");
      out.write("                    <i class=\"material-icons\">date_range</i> 数据库拥有源的频道\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-lg-3 col-md-6 col-sm-6\">\n");
      out.write("        <div class=\"card card-stats\">\n");
      out.write("            <div class=\"card-header\" data-background-color=\"orange\">\n");
      out.write("                <i class=\"material-icons\">weekend</i>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card-content\">\n");
      out.write("                <p class=\"category\">直播源</p>\n");
      out.write("                <h3 class=\"card-title\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sourceCount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("（个）</h3>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card-footer\">\n");
      out.write("                <div class=\"stats\">\n");
      out.write("                    <i class=\"material-icons text-danger\">warning</i>\n");
      out.write("                    <a href=\"#pablo\">查看全部直播源</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-lg-3 col-md-6 col-sm-6\">\n");
      out.write("        <div class=\"card card-stats\">\n");
      out.write("            <div class=\"card-header\" data-background-color=\"rose\">\n");
      out.write("                <i class=\"material-icons\">equalizer</i>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card-content\">\n");
      out.write("                <p class=\"category\">实时用户活跃</p>\n");
      out.write("                <h3 class=\"card-title\">0（万）</h3>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card-footer\">\n");
      out.write("                <div class=\"stats\">\n");
      out.write("                    <i class=\"material-icons\">local_offer</i> 使用YDTrack统计中\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-lg-3 col-md-6 col-sm-6\">\n");
      out.write("        <div class=\"card card-stats\">\n");
      out.write("            <div class=\"card-header\" data-background-color=\"blue\">\n");
      out.write("                <i class=\"fa fa-twitter\"></i>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card-content\">\n");
      out.write("                <p class=\"category\">本日新增用户</p>\n");
      out.write("                <h3 class=\"card-title\">+0（万）</h3>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card-footer\">\n");
      out.write("                <div class=\"stats\">\n");
      out.write("                    <i class=\"material-icons\">update</i> 实时更新\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>");
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
