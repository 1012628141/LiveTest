package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
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
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"/img/apple-icon.png\" />\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" href=\"/img/favicon.png\" />\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n");
      out.write("    <title>Live-直播源管理系统</title>\n");
      out.write("    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width\" />\n");
      out.write("    <!-- Bootstrap core CSS     -->\n");
      out.write("    <link href=\"/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <!--  Material Dashboard CSS    -->\n");
      out.write("    <link href=\"/css/material-dashboard.css\" rel=\"stylesheet\" />\n");
      out.write("    <!--     Fonts and icons     -->\n");
      out.write("    <link href=\"/css/mont.css\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/gont.css\" />\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"wrapper\">\n");
      out.write("        <div class=\"sidebar\" data-active-color=\"rose\" data-background-color=\"black\" data-image=\"/img/sidebar-1.jpg\">\n");
      out.write("            <!--\n");
      out.write("        Tip 1: You can change the color of active element of the sidebar using: data-active-color=\"purple | blue | green | orange | red | rose\"\n");
      out.write("        Tip 2: you can also add an image using data-image tag\n");
      out.write("        Tip 3: you can change the color of the sidebar with data-background-color=\"white | black\"\n");
      out.write("    -->\n");
      out.write("            <div class=\"logo\">\n");
      out.write("                <a href=\"/\" class=\"simple-text\">\n");
      out.write("                    Live-直播源管理系统\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"logo logo-mini\">\n");
      out.write("                <a href=\"/\" class=\"simple-text\">\n");
      out.write("                    Yd\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"sidebar-wrapper\">\n");
      out.write("                <div class=\"user\">\n");
      out.write("                    <div class=\"photo\">\n");
      out.write("                        <img src=\"/img/faces/avatar.jpg\" />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"info\">\n");
      out.write("                        <a data-toggle=\"collapse\" href=\"#collapseExample\" class=\"collapsed\">\n");
      out.write("                            dylan（管理员）\n");
      out.write("                            <b class=\"caret\"></b>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"collapse\" id=\"collapseExample\">\n");
      out.write("                            <ul class=\"nav\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#\">安全设置</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                    ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                    ");
      out.write("\n");
      out.write("                    ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                    ");
      out.write("\n");
      out.write("                    ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                    ");
      out.write("\n");
      out.write("                    ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                    ");
      out.write("\n");
      out.write("                    ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                            ");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                    ");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"main-panel\">\n");
      out.write("            <nav class=\"navbar navbar-transparent navbar-absolute\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"navbar-minimize\">\n");
      out.write("                        <button id=\"minimizeSidebar\" class=\"btn btn-round btn-white btn-fill btn-just-icon\">\n");
      out.write("                            <i class=\"material-icons visible-on-sidebar-regular\">more_vert</i>\n");
      out.write("                            <i class=\"material-icons visible-on-sidebar-mini\">view_list</i>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\">\n");
      out.write("                            <span class=\"sr-only\">切换菜单</span>\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                        </button>\n");
      out.write("                        <a class=\"navbar-brand\" href=\"#\"> 管理后台 </a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"collapse navbar-collapse\">\n");
      out.write("                        <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                            <!--<li>-->\n");
      out.write("                                <!--<a href=\"#pablo\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">-->\n");
      out.write("                                    <!--<i class=\"material-icons\">dashboard</i>-->\n");
      out.write("                                    <!--<p class=\"hidden-lg hidden-md\">管理后台</p>-->\n");
      out.write("                                <!--</a>-->\n");
      out.write("                            <!--</li>-->\n");
      out.write("                            <li class=\"dropdown\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                                    <i class=\"material-icons\">notifications</i>\n");
      out.write("                                    <span class=\"notification\">2</span>\n");
      out.write("                                    <p class=\"hidden-lg hidden-md\">\n");
      out.write("                                        通知\n");
      out.write("                                        <b class=\"caret\"></b>\n");
      out.write("                                    </p>\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"#\">您有直播源挂掉了</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"#\">服务器故障</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <!--<li>-->\n");
      out.write("                                <!--<a href=\"#pablo\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">-->\n");
      out.write("                                    <!--<i class=\"material-icons\">person</i>-->\n");
      out.write("                                    <!--<p class=\"hidden-lg hidden-md\">Profile</p>-->\n");
      out.write("                                <!--</a>-->\n");
      out.write("                            <!--</li>-->\n");
      out.write("                            <li class=\"separator hidden-lg hidden-md\"></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    ");
      out.write("\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, (java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${content}", java.lang.String.class, (PageContext)_jspx_page_context, null), out, true);
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <footer class=\"footer\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <nav class=\"pull-left\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"/\">\n");
      out.write("                                    管理后台主页\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">\n");
      out.write("                                    技术博客\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("                    <p class=\"copyright pull-right\">\n");
      out.write("                        &copy;\n");
      out.write("                        <script>\n");
      out.write("                            document.write(new Date().getFullYear())\n");
      out.write("                        </script>\n");
      out.write("                        <a href=\"/\">Living city .admin</a>, 直播源管理系统\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("<!--   Core JS Files   -->\n");
      out.write("<!--   Core JS Files   -->\n");
      out.write("<script src=\"/js/jquery-3.1.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"/js/jquery-ui.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"/js/material.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"/js/perfect-scrollbar.jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<!-- Forms Validations Plugin -->\n");
      out.write("<script src=\"/js/jquery.validate.min.js\"></script>\n");
      out.write("<!--  Plugin for Date Time Picker and Full Calendar Plugin-->\n");
      out.write("<script src=\"/js/moment.min.js\"></script>\n");
      out.write("<!--  Charts Plugin -->\n");
      out.write("\n");
      out.write("<!--  Plugin for the Wizard -->\n");
      out.write("<script src=\"/js/jquery.bootstrap-wizard.js\"></script>\n");
      out.write("<!--  Notifications Plugin    -->\n");
      out.write("<script src=\"/js/bootstrap-notify.js\"></script>\n");
      out.write("<!-- DateTimePicker Plugin -->\n");
      out.write("<script src=\"/js/bootstrap-datetimepicker.js\"></script>\n");
      out.write("<!-- Vector Map plugin -->\n");
      out.write("<script src=\"/js/jquery-jvectormap.js\"></script>\n");
      out.write("<!-- Sliders Plugin -->\n");
      out.write("<script src=\"/js/nouislider.min.js\"></script>\n");
      out.write("<!--  Google Maps Plugin    -->\n");
      out.write("\n");
      out.write("<!-- Select Plugin -->\n");
      out.write("<script src=\"/js/jquery.select-bootstrap.js\"></script>\n");
      out.write("<!--  DataTables.net Plugin    -->\n");
      out.write("<script src=\"/js/jquery.datatables.js\"></script>\n");
      out.write("<!-- Sweet Alert 2 plugin -->\n");
      out.write("<script src=\"/js/sweetalert2.js\"></script>\n");
      out.write("<!--\tPlugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->\n");
      out.write("<script src=\"/js/jasny-bootstrap.min.js\"></script>\n");
      out.write("<!--  Full Calendar Plugin    -->\n");
      out.write("<script src=\"/js/fullcalendar.min.js\"></script>\n");
      out.write("<!-- TagsInput Plugin -->\n");
      out.write("<script src=\"/js/jquery.tagsinput.js\"></script>\n");
      out.write("<!-- Material Dashboard javascript methods -->\n");
      out.write("<script src=\"/js/material-dashboard.js\"></script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("//    var i = 0;\n");
      out.write("//\n");
      out.write("//    function check() {\n");
      out.write("//        var source = $($('.source-list')[i]).data(\"url\");\n");
      out.write("//        $.ajax({\n");
      out.write("//            type: \"GET\",\n");
      out.write("//            url: \"webChannel/checkSource.do?sourceUri=\" + source,\n");
      out.write("//            success: function (data) {\n");
      out.write("//                var result = JSON.parse(data);\n");
      out.write("//                console.log(result);\n");
      out.write("//                if (result.code === 200) {\n");
      out.write("//                    $(\"td[link='\" + result.data + \"']\").html(\"有效\");\n");
      out.write("//                } else {\n");
      out.write("//                    $(\"td[link='\" + result.data + \"']\").html(\"失效\");\n");
      out.write("//                }\n");
      out.write("//                i ++;\n");
      out.write("//                check();\n");
      out.write("//            },\n");
      out.write("//            error: function () {\n");
      out.write("//                i ++;\n");
      out.write("//                $(\"td[link='\" + source + \"']\").html(\"检测失败\");\n");
      out.write("//                check();\n");
      out.write("//            }\n");
      out.write("//        });\n");
      out.write("//    }\n");
      out.write("    \n");
      out.write("    $(document).ready(function() {\n");
      out.write("\n");
      out.write("        var page = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${content}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\n");
      out.write("        if ( page === 'pages/checkChannel.jsp') {\n");
      out.write("            // 毛都不用干\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        if ( page === 'pages/livingChannel.jsp' ) {\n");
      out.write("            $('#datatables').DataTable({\n");
      out.write("                pageLength: 20,\n");
      out.write("                lengthChange: false,\n");
      out.write("                info: false,\n");
      out.write("                ordering: false,\n");
      out.write("                autoWidth: true,\n");
      out.write("                \"language\": {\n");
      out.write("                    \"paginate\": {\n");
      out.write("                        \"previous\": \"上一页\",\n");
      out.write("                        \"last\": \"最后一页\",\n");
      out.write("                        \"next\": \"下一页\"\n");
      out.write("                    },\n");
      out.write("                    \"search\": \"检索频道：\"\n");
      out.write("                },\n");
      out.write("                \"search\": {\n");
      out.write("                    \"caseInsensitive\": false\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            $('.card .material-datatables label').addClass('form-group');\n");
      out.write("\n");
      out.write("            // Add channel\n");
      out.write("            $('.btn-add-channel').on('click', function () {\n");
      out.write("                // Add new channel\n");
      out.write("                swal.queue([{\n");
      out.write("                    title: '请输入频道名称',\n");
      out.write("                    html:\n");
      out.write("                    '<div class=\"form-group\">' +\n");
      out.write("                    '<input id=\"input-field\" type=\"text\" class=\"form-control\" />' +\n");
      out.write("                    '</div>',\n");
      out.write("                    confirmButtonClass: 'btn btn-success',\n");
      out.write("                    confirmButtonText: '确认添加',\n");
      out.write("                    buttonsStyling: false,\n");
      out.write("                    showLoaderOnConfirm: true,\n");
      out.write("                    preConfirm: function () {\n");
      out.write("                        return new Promise(function (resolve) {\n");
      out.write("                            var value = $('#input-field').val();\n");
      out.write("                            if (value && value.trim()) {\n");
      out.write("                                $.ajax(\n");
      out.write("                                    {\n");
      out.write("                                        type: \"GET\",\n");
      out.write("                                        url: \"/webChannel/addChannel/\" + value,\n");
      out.write("                                        success: function (data) {\n");
      out.write("                                            swal.insertQueueStep(\"添加成功 !\");\n");
      out.write("                                            window.location.reload();\n");
      out.write("                                            resolve();\n");
      out.write("\n");
      out.write("                                            // 到最后一页\n");
      out.write("                                            var table = $('#datatables').DataTable();\n");
      out.write("                                            table.page( 'last' ).draw( false );\n");
      out.write("                                        },\n");
      out.write("                                        error: function () {\n");
      out.write("                                            swal.insertQueueStep(\"添加成功 !\");\n");
      out.write("                                            window.location.reload();\n");
      out.write("                                            resolve();\n");
      out.write("\n");
      out.write("                                            // 到最后一页\n");
      out.write("                                            var table = $('#datatables').DataTable();\n");
      out.write("                                            table.page( 'last' ).draw( false );\n");
      out.write("                                        }\n");
      out.write("                                    }\n");
      out.write("                                );\n");
      out.write("                            } else {\n");
      out.write("                                swal.insertQueueStep(\"不能添加空字符串！\");\n");
      out.write("                                resolve()\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                    }\n");
      out.write("                }])\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty navItem}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <ul class=\"nav\">\n");
        out.write("                        ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                    </ul>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_forEach_0.setVar("listValue");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${navItem}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVarStatus("loop");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <li class=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listValue.id == active ? \"active\": \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listValue.href}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                    <i class=\"material-icons\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listValue.icon}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</i>\n");
          out.write("                                    <p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listValue.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                                </a>\n");
          out.write("                            </li>\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
