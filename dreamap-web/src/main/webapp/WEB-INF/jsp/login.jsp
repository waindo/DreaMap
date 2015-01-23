<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title id="page-title">DrEAMAP - Distribution Enterprise Asset Management Map</title>
    <link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico"/>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="<c:url value="/resources/styles/bootstrap.css" />" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/resources/styles/login-style.css" />">

    <script type="text/javascript" src='<c:url value="/resources/js/extjs/ext-all-debug.js"/>'></script>

</head>

<body onload="document.login-form.j_username.focus();">


<div class="container">
    <div class="row text-center">
        <div class="col-md-12">
            <img class="media-object" src="<c:url value="/resources/img/dreamap_logo.png" />" alt="">
            <h5 style="color: #0088cc;">( Distribution Enterprise Asset Management Map )</h5>
            <br />
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <strong>User Authentication</strong>
                </div>
                <div class="panel-body">
                    <form id="login-form" class="login-form" accept-charset="UTF-8" action="j_spring_security_check" class="span10" method="post" autocomplete="off">
                        <fieldset>
                            <div class="span4"/>
                            <c:if test="${not empty param.error}">
                                <h5 style="color: red;">${SPRING_SECURITY_LAST_EXCEPTION.message}</h5>
                            </c:if>
                            <div class="span4"/>
                            <div class="form-group input-group">
                                <span class="input-group-addon">
                                    <i class="icon-user"></i>
                                </span>
                                <input type="text" name="j_username" class="form-control" placeholder="Your Username" required="required" tabindex="1" />
                            </div>

                            <div class="form-group input-group">
                                <span class="input-group-addon">
                                    <i class="icon-lock"></i>
                                </span>
                                <input type="password" name="j_password" class="form-control" placeholder="Your Password" required="required" tabindex="2" />
                            </div>

                            <%--<div class="form-group">--%>
                                <%--<label class="checkbox-inline">--%>
                                    <%--<input type="checkbox" /> Remember me--%>
                                <%--</label>--%>
                            <%--</div>--%>

                            <button type="submit" class="btn btn-primary pull-right">
                                <i class="icon-key" tabindex="3"></i>
                                Login
                            </button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
