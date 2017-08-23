<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
    %{--<asset:stylesheet src="application.css"/>--}%
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="style.default.css"/>
    <asset:stylesheet src="styles.css"/>
    <asset:stylesheet src="custom.css"/>
    <asset:stylesheet src="font-awesome.min.css"/>
    <asset:javascript src="application.js"/>
    <asset:javascript src="bootstrap.min.js"/>
    <asset:javascript src="bootstrap.js"/>
    <asset:javascript src="front.js"/>
    <asset:javascript src="jquery.cookie.js"/>
    <asset:javascript src="jquery.validate.min.js"/>
    <asset:javascript src="tether.min.js"/>
    <asset:javascript src="" href="https://use.fontawesome.com/99347ac47f.js"/>
    <asset:javascript src="" href="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"/>
    <asset:javascript src="" href="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"/>
    <asset:stylesheet href="https://fonts.googleapis.com/css?family=Poppins:300,400,700"/>
    <asset:stylesheet href="https://file.myfontastic.com/da58YPMQ7U5HY8Rb6UxkNf/icons.css"/>
    <g:layoutHead/>
</head>

<body>
<div class="page home-page">
    <!-- Main Navbar-->
    <header class="header">
        <nav class="navbar">
            <div class="container-fluid">
                <div class="navbar-holder d-flex align-items-center justify-content-between">
                    <!-- Navbar Header-->
                    <div class="navbar-header">
                        <!-- Navbar Brand --><a href="index.html" class="navbar-brand">
                        <div class="brand-text brand-big hidden-lg-down"><span>
                            <g:message code="default.coding.label"/>
                        </span><strong>
                            <g:message code="default.challenge.label"/>
                        </strong>
                        </div>

                        <div class="brand-text brand-small"><strong>BD</strong></div></a>
                        <!-- Toggle Button--><a id="toggle-btn" href="#"
                                                class="menu-btn active"><span></span><span></span><span></span></a>
                    </div>
                    <!-- Navbar Menu -->
                    <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                        <!-- Logout    -->
                        <li class="nav-item">
                        %{--<a href="login.html" class="nav-link logout">Logout<i class="fa fa-sign-out"></i></a>--}%
                            <sec:ifLoggedIn>
                                <g:link controller='logout' class="nav-link logout">Logout<i
                                        class="fa fa-sign-out"></i></g:link>
                            </sec:ifLoggedIn>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <div class="page-content d-flex align-items-stretch">
        <!-- Side Navbar -->
        <nav class="side-navbar">
            <!-- Sidebar Header-->
            <div class="sidebar-header d-flex align-items-center">
                <div class="avatar">
                    <asset:image src="custom/vivek.jpg" class="img-fluid rounded-circle"/>
                </div>
                <sec:ifLoggedIn>
                    <div class="title">
                        <h1 class="h4"><sec:username/></h1>

                        <p>
                            <g:message code="grails.developer.label"/>
                        </p>
                    </div>
                </sec:ifLoggedIn>
            </div>

            <sec:ifLoggedIn>
                <span class="heading">
                    <g:message code="default.menu.label"/>
                </span>
                <ul class="list-unstyled">
                    <li class="active">
                        <g:link controller="shorten">
                            <i class="icon-home"></i>
                            <g:message code="shorten.url.label"/>
                        </g:link>
                    </li>
                    <li class="active">
                        <g:link controller="upload">
                            <i class="icon-home"></i>
                            <g:message code="upload.file.label"/>
                        </g:link>
                    </li>
                    <li class="active">
                        <g:link controller="convertTemperature">
                            <i class="icon-home"></i>
                            <g:message code="convert.temperature.label"/>
                        </g:link>
                    </li>
                </ul>
            </sec:ifLoggedIn>
        </nav>

        <div class="content-inner">
            <!-- Page Header-->
            <header class="page-header">
                <div class="container-fluid">
                    <h2 class="no-margin-bottom">
                        <g:message code="default.dashboard.lable"/>
                    </h2>
                </div>
            </header>

            <g:layoutBody/>

            <!-- Page Footer-->
            <footer class="main-footer">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-6">
                            <p>
                                <g:message code="default.coding.challenge.copyright"/>
                            </p>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
</div>

<script>
    (function (b, o, i, l, e, r) {
        b.GoogleAnalyticsObject = l;
        b[l] || (b[l] =
                function () {
                    (b[l].q = b[l].q || []).push(arguments)
                });
        b[l].l = +new Date;
        e = o.createElement(i);
        r = o.getElementsByTagName(i)[0];
        e.src = '//www.google-analytics.com/analytics.js';
        r.parentNode.insertBefore(e, r)
    }(window, document, 'script', 'ga'));
    ga('create', 'UA-XXXXX-X');
    ga('send', 'pageview');
</script>
</body>
</html>
