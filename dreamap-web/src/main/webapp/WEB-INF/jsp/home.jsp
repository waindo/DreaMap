<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<html>
<head>
  <!-- <title>Dreamap ::PLN::</title> -->
  <title>PLN DrEamap</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="//js.arcgis.com/3.10/js/dojo/dojo/resources/dojo.css">
  <link rel="stylesheet" type="text/css" href="//js.arcgis.com/3.10/js/esri/css/esri.css">
  <link rel="stylesheet" type="text/css" href="/resources/css/main.css">

  <script type="text/javascript" src='<c:url value="/resources/js/extjs/ext-all-debug.js"/>'></script>
  <link rel="stylesheet" type="text/css" href='<c:url value="/resources/js/extjs/resources/css/ext-all.css"/>'>

  <script type="text/javascript" src="//js.arcgis.com/3.10"></script>
  <script type="text/javascript" src='<c:url value="/app.js"/>'></script>

  <script type="text/javascript">
    var cleanUrl = function (path) {
      var indexOfJSessionId = path.indexOf(";jsessionid");
      if (indexOfJSessionId != -1) {
        path = path.substring(0, indexOfJSessionId);
      }
      return path;
    };

    app = {};
    app.config = {};
    app.config.loggedAuthorities = [];
    <%--app.config.appFolder = cleanUrl('<c:url value="/app"/>');--%>
    app.config.loaderPath = cleanUrl('<c:url value="/resources/js/extjs/ux"/>');
    app.config.logoutUrl = cleanUrl('<c:url value="/j_spring_logout"/>');
    app.config.rootPath = cleanUrl('<c:url value="/"/>');
  </script>

  <style>
    .edit-col {
      background-image: url(/resources/images/edit.png)
    }
    .view-col {
      background-image: url(/resources/images/lihat.png)
    }
    .approve {
      background-image: url(/resources/images/approve.png)
    }
    .reload {
      background-image: url(/resources/images/reload.png)
    }
    .upload-icon {
      background-image: url(/resources/images/image_add.png)
    }
    .upload-file {
      background-image: url(/resources/images/file.png)
    }
    .menu {
      background-image: url(/resources/images/menu.png)
    }
    .lock {
      background-image: url(/resources/images/lockout.png)
    }
  </style>

</head>
<body class="dbootstrap">
<script>
  dojo.require("esri.map");
  dojo.require("esri.layers.FeatureLayer");
  dojo.require("esri.dijit.PopupTemplate");
  dojo.require("dojo.number");

  var map;

  function init() {
    map = new esri.Map("map", {
      basemap: "satellite",
      center: [106.812604, -6.212850],
      zoom: 16,
      sliderStyle: 'small'
    });

  }

  function resizeMap() {
    map.resize();
  }

  dojo.ready(init);
</script>
</body>
</html>