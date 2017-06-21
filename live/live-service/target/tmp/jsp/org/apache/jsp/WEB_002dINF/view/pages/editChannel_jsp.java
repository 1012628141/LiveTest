package org.apache.jsp.WEB_002dINF.view.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editChannel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_1;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:split", org.apache.taglibs.standard.functions.Functions.class, "split", new Class[] {java.lang.String.class, java.lang.String.class});
  _jspx_fnmap_1= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:toLowerCase", org.apache.taglibs.standard.functions.Functions.class, "toLowerCase", new Class[] {java.lang.String.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
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
      out.write("    <title>Live-编辑频道信息</title>\n");
      out.write("    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width\" />\n");
      out.write("    <!-- Bootstrap core CSS     -->\n");
      out.write("    <link href=\"/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <!--  Material Dashboard CSS    -->\n");
      out.write("    <link href=\"/css/material-dashboard.css\" rel=\"stylesheet\" />\n");
      out.write("    <!--     Fonts and icons     -->\n");
      out.write("    <link href=\"http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons\" />\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<div class=\"wrapper\">\n");
      out.write("    <div class=\"main-panel\" style=\"width: 100%; float: none;\">\n");
      out.write("        <nav class=\"navbar navbar-transparent navbar-absolute\">\n");
      out.write("            <div class=\"navbar-minimize\">\n");
      out.write("                <button class=\"btn btn-round btn-white btn-fill btn-just-icon\">\n");
      out.write("                    <i class=\"material-icons visible-on-sidebar-regular\">more_vert</i>\n");
      out.write("                    <i class=\"material-icons visible-on-sidebar-mini\">view_list</i>\n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\"> 编辑频道信息 </a>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"content\" style=\"margin-top: 45px;\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <div class=\"card-header card-header-text\" data-background-color=\"rose\">\n");
      out.write("                                <h4 class=\"card-title\">TYPE: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${channel.typeid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" - ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${channel.channel}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" ( ID: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${channel.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" )</h4>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"card-content\">\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table\">\n");
      out.write("                                        <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th class=\"text-center\">#</th>\n");
      out.write("                                            <th>源地址</th>\n");
      out.write("                                            <th class=\"text-right\">状态</th>\n");
      out.write("                                            <th class=\"text-right\">操作</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"card-footer\">\n");
      out.write("                                <div style=\"float: right; padding-bottom: 10px;\">\n");
      out.write("                                    <button class=\"btn btn-primary btn-add-source\" data-id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${channel.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">新增频道源</button>\n");
      out.write("                                    <button class=\"btn btn-warning btn-change-type\" data-id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${channel.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">修改频道分类</button>\n");
      out.write("                                    <button class=\"btn btn-danger btn-remove-channel\" data-id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${channel.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">删除频道</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <footer class=\"footer\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <nav class=\"pull-left\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"/\">\n");
      out.write("                                管理后台主页\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("                <p class=\"copyright pull-right\">\n");
      out.write("                    &copy;\n");
      out.write("                    <script>\n");
      out.write("                        document.write(new Date().getFullYear())\n");
      out.write("                    </script>\n");
      out.write("                    <a href=\"/\">Living city .admin</a>, 直播源管理系统\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("<script src=\"/js/jquery-3.1.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"/js/jquery-ui.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"/js/material.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"/js/perfect-scrollbar.jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"/js/jquery.validate.min.js\"></script>\n");
      out.write("<script src=\"/js/moment.min.js\"></script>\n");
      out.write("<script src=\"/js/chartist.min.js\"></script>\n");
      out.write("<script src=\"/js/jquery.bootstrap-wizard.js\"></script>\n");
      out.write("<script src=\"/js/bootstrap-notify.js\"></script>\n");
      out.write("<script src=\"/js/bootstrap-datetimepicker.js\"></script>\n");
      out.write("<script src=\"/js/jquery-jvectormap.js\"></script>\n");
      out.write("<script src=\"/js/nouislider.min.js\"></script>\n");
      out.write("<!--  Google Maps Plugin    -->\n");
      out.write("<script src=\"https://maps.googleapis.com/maps/api/js\"></script>\n");
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
      out.write("<!-- Material Dashboard DEMO methods, don't include it in your project! -->\n");
      out.write("<script src=\"/js/demo.js\"></script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function() {\n");
      out.write("        // Bind actions\n");
      out.write("        $('.btn-remove-source').on('click', function () {\n");
      out.write("            var id = $(this).parent().parent().data(\"id\");\n");
      out.write("            var sid = $(this).parent().parent().data(\"sid\");\n");
      out.write("            // Remove this id source, with alert confirm.\n");
      out.write("            swal.queue([{\n");
      out.write("                title: '确认删除 ？',\n");
      out.write("                confirmButtonText: '确认删除',\n");
      out.write("                cancelButtonText: '取消',\n");
      out.write("                cancelButtonClass: 'btn btn-default',\n");
      out.write("                text: '将要删除该视频源，删除后客户端将不再显示...',\n");
      out.write("                type: 'warning',\n");
      out.write("                showCancelButton: true,\n");
      out.write("                showLoaderOnConfirm: true,\n");
      out.write("                allowOutsideClick: false,\n");
      out.write("                preConfirm: function () {\n");
      out.write("                    return new Promise(function (resolve) {\n");
      out.write("                        $.ajax(\n");
      out.write("                            {\n");
      out.write("                                type: \"POST\",\n");
      out.write("                                url: \"/webChannel/removeSource.do\",\n");
      out.write("                                contentType: \"application/json; charset=utf-8\",\n");
      out.write("                                dataType: \"json\",\n");
      out.write("                                data: JSON.stringify({\"channelId\": id, \"sourceId\": sid}),\n");
      out.write("                                success: function (data) {\n");
      out.write("                                    var result = JSON.parse(data);\n");
      out.write("                                    if (result.code === 200) {\n");
      out.write("                                        swal.insertQueueStep(\"删除成功 !\");\n");
      out.write("                                        window.location.reload();\n");
      out.write("                                    } else {\n");
      out.write("                                        swal.insertQueueStep(\"删除失败！\");\n");
      out.write("                                    }\n");
      out.write("                                    resolve()\n");
      out.write("                                },\n");
      out.write("                                error: function () {\n");
      out.write("                                    swal.insertQueueStep(\"删除失败！\");\n");
      out.write("                                    resolve()\n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("                        );\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("            }]);\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        // Add New sources\n");
      out.write("        $('.btn-add-source').on('click', function () {\n");
      out.write("            var id = $(this).data(\"id\");\n");
      out.write("            // Add new source\n");
      out.write("            swal.queue([{\n");
      out.write("                title: '请输入源地址，通常以m3u8或flv结尾',\n");
      out.write("                html:\n");
      out.write("                '<div class=\"form-group\">' +\n");
      out.write("                    '<input id=\"input-field\" type=\"text\" class=\"form-control\" />' +\n");
      out.write("                '</div>',\n");
      out.write("                confirmButtonClass: 'btn btn-warning',\n");
      out.write("                cancelButtonClass: 'btn btn-default',\n");
      out.write("                confirmButtonText: '确认添加',\n");
      out.write("                buttonsStyling: false,\n");
      out.write("                showLoaderOnConfirm: true,\n");
      out.write("                allowOutsideClick: false,\n");
      out.write("                cancelButtonText: '取消',\n");
      out.write("                showCancelButton: true,\n");
      out.write("                preConfirm: function () {\n");
      out.write("                    return new Promise(function (resolve) {\n");
      out.write("                        var value = $('#input-field').val();\n");
      out.write("                        if (value && value.trim()) {\n");
      out.write("                            $.ajax(\n");
      out.write("                                {\n");
      out.write("                                    type: \"POST\",\n");
      out.write("                                    url: \"/webChannel/addSource.do\",\n");
      out.write("                                    data: JSON.stringify({\"channelId\": id, \"sourceUri\": value}),\n");
      out.write("                                    contentType: \"application/json; charset=utf-8\",\n");
      out.write("                                    dataType: \"json\",\n");
      out.write("                                    success: function (data) {\n");
      out.write("                                        var result = JSON.parse(data);\n");
      out.write("                                        if (result.code === 200) {\n");
      out.write("                                            swal.insertQueueStep(\"添加成功 !\");\n");
      out.write("                                            window.location.reload();\n");
      out.write("                                        } else {\n");
      out.write("                                            swal.insertQueueStep(\"添加失败！\");\n");
      out.write("                                        }\n");
      out.write("                                        resolve()\n");
      out.write("                                    },\n");
      out.write("                                    error: function () {\n");
      out.write("                                        swal.insertQueueStep(\"添加失败！\");\n");
      out.write("                                        resolve()\n");
      out.write("                                    }\n");
      out.write("                                }\n");
      out.write("                            );\n");
      out.write("                        } else {\n");
      out.write("                            swal.insertQueueStep(\"不能新增空字符串！\");\n");
      out.write("                            resolve()\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("            }])\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        // Change channel type\n");
      out.write("        $('.btn-change-type').on('click', function () {\n");
      out.write("            var id = $(this).data(\"id\");\n");
      out.write("            // Add new source\n");
      out.write("            swal.queue([{\n");
      out.write("                title: '请输入新的分类ID',\n");
      out.write("                html:\n");
      out.write("                '<div class=\"form-group\">' +\n");
      out.write("                '<input id=\"input-field\" type=\"text\" class=\"form-control\" />' +\n");
      out.write("                '</div>',\n");
      out.write("                confirmButtonClass: 'btn btn-warning',\n");
      out.write("                confirmButtonText: '确认添加',\n");
      out.write("                buttonsStyling: false,\n");
      out.write("                showLoaderOnConfirm: true,\n");
      out.write("                cancelButtonText: '取消',\n");
      out.write("                cancelButtonClass: 'btn btn-default',\n");
      out.write("                showCancelButton: true,\n");
      out.write("                allowOutsideClick: false,\n");
      out.write("                preConfirm: function () {\n");
      out.write("                    return new Promise(function (resolve) {\n");
      out.write("                        var value = $('#input-field').val();\n");
      out.write("                        if (value && value.trim()) {\n");
      out.write("                            $.ajax(\n");
      out.write("                                {\n");
      out.write("                                    type: \"POST\",\n");
      out.write("                                    url: \"/webChannel/changeType.do\",\n");
      out.write("                                    contentType: \"application/json; charset=utf-8\",\n");
      out.write("                                    dataType: \"json\",\n");
      out.write("                                    data: JSON.stringify({\"channelId\": id, \"typeId\": value}),\n");
      out.write("                                    success: function (data) {\n");
      out.write("                                        var result = JSON.parse(data);\n");
      out.write("                                        if (result.code === 200) {\n");
      out.write("                                            swal.insertQueueStep(\"修改成功 !\");\n");
      out.write("                                            window.location.reload();\n");
      out.write("                                        } else {\n");
      out.write("                                            swal.insertQueueStep(\"修改失败！\");\n");
      out.write("                                        }\n");
      out.write("                                        resolve()\n");
      out.write("                                    },\n");
      out.write("                                    error: function () {\n");
      out.write("                                        swal.insertQueueStep(\"修改失败！\");\n");
      out.write("                                        resolve()\n");
      out.write("                                    }\n");
      out.write("                                }\n");
      out.write("                            );\n");
      out.write("                        } else {\n");
      out.write("                            swal.insertQueueStep(\"不能新增空字符串！\");\n");
      out.write("                            resolve()\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("            }])\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        // Delete channel\n");
      out.write("        $('.btn-remove-channel').on('click', function () {\n");
      out.write("            var id = $(this).data(\"id\");\n");
      out.write("\n");
      out.write("            swal.queue([{\n");
      out.write("                title: '确认删除此频道？',\n");
      out.write("                confirmButtonClass: 'btn btn-warning',\n");
      out.write("                confirmButtonText: '确认',\n");
      out.write("                buttonsStyling: false,\n");
      out.write("                showLoaderOnConfirm: true,\n");
      out.write("                cancelButtonText: '取消',\n");
      out.write("                cancelButtonClass: 'btn btn-default',\n");
      out.write("                showCancelButton: true,\n");
      out.write("                allowOutsideClick: false,\n");
      out.write("                preConfirm: function () {\n");
      out.write("                    return new Promise(function (resolve) {\n");
      out.write("                        $.ajax(\n");
      out.write("                            {\n");
      out.write("                                type: \"POST\",\n");
      out.write("                                url: \"/webChannel/removeChannel.do\",\n");
      out.write("                                contentType: \"application/json; charset=utf-8\",\n");
      out.write("                                dataType: \"json\",\n");
      out.write("                                data: JSON.stringify({\"channelId\": id}),\n");
      out.write("                                success: function (data) {\n");
      out.write("                                    var result = JSON.parse(data);\n");
      out.write("                                    if (result.code === 200) {\n");
      out.write("                                        swal.insertQueueStep(\"删除成功 !，请关闭该窗口！\");\n");
      out.write("                                    } else {\n");
      out.write("                                        swal.insertQueueStep(\"删除失败！\");\n");
      out.write("                                    }\n");
      out.write("                                    resolve();\n");
      out.write("                                },\n");
      out.write("                                error: function () {\n");
      out.write("                                    swal.insertQueueStep(\"删除失败！\");\n");
      out.write("                                    resolve()\n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("                        );\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("            }])\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${channel.source != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            ");
        if (_jspx_meth_c_set_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                            ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                        ");
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

  private boolean _jspx_meth_c_set_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ fn:split(channel.source, '|') }", java.lang.Object.class, (PageContext)_jspx_page_context, _jspx_fnmap_0));
    _jspx_th_c_set_0.setVar("sources");
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
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
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ sources }", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("s");
    _jspx_th_c_forEach_0.setVarStatus("loop");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                ");
          if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                            ");
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

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty s}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                    <tr data-sid=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loop.index}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" data-id=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${channel.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                                        <td class=\"text-center\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loop.index + 1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</td>\n");
        out.write("                                                        <td>\n");
        out.write("                                                            <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:toLowerCase(s)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_1));
        out.write("\" style=\"display: block; width: 70%; word-wrap: break-word; word-break: normal;\">\n");
        out.write("                                                                    ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:toLowerCase(s)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_1));
        out.write("\n");
        out.write("                                                            </a>\n");
        out.write("                                                        </td>\n");
        out.write("                                                        <td class=\"text-right\">\n");
        out.write("                                                            未知\n");
        out.write("                                                        </td>\n");
        out.write("                                                        <td class=\"td-actions text-right\">\n");
        out.write("                                                            <button type=\"button\" rel=\"tooltip\" class=\"btn btn-danger btn-remove-source\">\n");
        out.write("                                                                <i class=\"material-icons\">close</i>\n");
        out.write("                                                            </button>\n");
        out.write("                                                        </td>\n");
        out.write("                                                    </tr>\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
