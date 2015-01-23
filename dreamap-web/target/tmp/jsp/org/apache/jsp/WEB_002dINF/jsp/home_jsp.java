package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_url_value_nobody.release();
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <!-- <title>Dreamap ::PLN::</title> -->\r\n");
      out.write("  <title>PLN DrEamap</title>\r\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"//js.arcgis.com/3.10/js/dojo/dojo/resources/dojo.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"//js.arcgis.com/3.10/js/esri/css/esri.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"/resources/css/main.css\">\r\n");
      out.write("\r\n");
      out.write("  <script type=\"text/javascript\" src='");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("'></script>\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href='");
      if (_jspx_meth_c_url_1(_jspx_page_context))
        return;
      out.write("'>\r\n");
      out.write("\r\n");
      out.write("  <script type=\"text/javascript\" src=\"//js.arcgis.com/3.10\"></script>\r\n");
      out.write("  <script type=\"text/javascript\" src='");
      if (_jspx_meth_c_url_2(_jspx_page_context))
        return;
      out.write("'></script>\r\n");
      out.write("\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("    var cleanUrl = function (path) {\r\n");
      out.write("      var indexOfJSessionId = path.indexOf(\";jsessionid\");\r\n");
      out.write("      if (indexOfJSessionId != -1) {\r\n");
      out.write("        path = path.substring(0, indexOfJSessionId);\r\n");
      out.write("      }\r\n");
      out.write("      return path;\r\n");
      out.write("    };\r\n");
      out.write("\r\n");
      out.write("    app = {};\r\n");
      out.write("    app.config = {};\r\n");
      out.write("    app.config.loggedAuthorities = [];\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    app.config.loaderPath = cleanUrl('");
      if (_jspx_meth_c_url_3(_jspx_page_context))
        return;
      out.write("');\r\n");
      out.write("    app.config.logoutUrl = cleanUrl('");
      if (_jspx_meth_c_url_4(_jspx_page_context))
        return;
      out.write("');\r\n");
      out.write("    app.config.rootPath = cleanUrl('");
      if (_jspx_meth_c_url_5(_jspx_page_context))
        return;
      out.write("');\r\n");
      out.write("  </script>\r\n");
      out.write("\r\n");
      out.write("  <style>\r\n");
      out.write("    .edit-col {\r\n");
      out.write("      background-image: url(/resources/images/edit.png)\r\n");
      out.write("    }\r\n");
      out.write("    .view-col {\r\n");
      out.write("      background-image: url(/resources/images/lihat.png)\r\n");
      out.write("    }\r\n");
      out.write("    .approve {\r\n");
      out.write("      background-image: url(/resources/images/approve.png)\r\n");
      out.write("    }\r\n");
      out.write("    .reload {\r\n");
      out.write("      background-image: url(/resources/images/reload.png)\r\n");
      out.write("    }\r\n");
      out.write("    .upload-icon {\r\n");
      out.write("      background-image: url(/resources/images/image_add.png)\r\n");
      out.write("    }\r\n");
      out.write("    .upload-file {\r\n");
      out.write("      background-image: url(/resources/images/file.png)\r\n");
      out.write("    }\r\n");
      out.write("    .menu {\r\n");
      out.write("      background-image: url(/resources/images/menu.png)\r\n");
      out.write("    }\r\n");
      out.write("    .lock {\r\n");
      out.write("      background-image: url(/resources/images/lockout.png)\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"dbootstrap\">\r\n");
      out.write("<script>\r\n");
      out.write("  dojo.require(\"esri.map\");\r\n");
      out.write("  dojo.require(\"esri.layers.FeatureLayer\");\r\n");
      out.write("  dojo.require(\"esri.dijit.PopupTemplate\");\r\n");
      out.write("  dojo.require(\"dojo.number\");\r\n");
      out.write("\r\n");
      out.write("  var map;\r\n");
      out.write("\r\n");
      out.write("  function init() {\r\n");
      out.write("    map = new esri.Map(\"map\", {\r\n");
      out.write("      basemap: \"satellite\",\r\n");
      out.write("      center: [106.812604, -6.212850],\r\n");
      out.write("      zoom: 16,\r\n");
      out.write("      sliderStyle: 'small'\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  function resizeMap() {\r\n");
      out.write("    map.resize();\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  dojo.ready(init);\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setValue("/resources/js/extjs/ext-all-debug.js");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_url_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_1.setPageContext(_jspx_page_context);
    _jspx_th_c_url_1.setParent(null);
    _jspx_th_c_url_1.setValue("/resources/js/extjs/resources/css/ext-all.css");
    int _jspx_eval_c_url_1 = _jspx_th_c_url_1.doStartTag();
    if (_jspx_th_c_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_1);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_1);
    return false;
  }

  private boolean _jspx_meth_c_url_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_2.setPageContext(_jspx_page_context);
    _jspx_th_c_url_2.setParent(null);
    _jspx_th_c_url_2.setValue("/app.js");
    int _jspx_eval_c_url_2 = _jspx_th_c_url_2.doStartTag();
    if (_jspx_th_c_url_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
    return false;
  }

  private boolean _jspx_meth_c_url_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_3.setPageContext(_jspx_page_context);
    _jspx_th_c_url_3.setParent(null);
    _jspx_th_c_url_3.setValue("/resources/js/extjs/ux");
    int _jspx_eval_c_url_3 = _jspx_th_c_url_3.doStartTag();
    if (_jspx_th_c_url_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_3);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_3);
    return false;
  }

  private boolean _jspx_meth_c_url_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_4.setPageContext(_jspx_page_context);
    _jspx_th_c_url_4.setParent(null);
    _jspx_th_c_url_4.setValue("/j_spring_logout");
    int _jspx_eval_c_url_4 = _jspx_th_c_url_4.doStartTag();
    if (_jspx_th_c_url_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_4);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_4);
    return false;
  }

  private boolean _jspx_meth_c_url_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_5.setPageContext(_jspx_page_context);
    _jspx_th_c_url_5.setParent(null);
    _jspx_th_c_url_5.setValue("/");
    int _jspx_eval_c_url_5 = _jspx_th_c_url_5.doStartTag();
    if (_jspx_th_c_url_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_5);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_5);
    return false;
  }
}
