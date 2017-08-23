<html>
<head>
    <meta name='layout' content='main'/>
    <title><g:message code="springSecurity.login.title"/></title>
</head>

<body>
<section class="forms">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-header d-flex align-items-center">
                        <h3 class="h4">
                            <g:message code="default.login.label"/>
                        </h3>
                    </div>

                    <div class="card-body">
                    <p>
                        <g:if test='${flash.message}'>
                            <div class='alert-danger'>${flash.message}</div>
                        </g:if>
                    </p>
                        <form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
                            <div class="form-group">
                                <label class="form-control-label">
                                    <g:message code="default.username.label"/>
                                </label>
                                <input type='text' placeholder="Username" class='form-control' name='j_username'
                                       id='username'/>
                            </div>

                            <div class="form-group">
                                <label class="form-control-label">
                                    <g:message code="default.password.label"/>
                                </label>
                                <input type='password' placeholder="Password" class="form-control" name='j_password'
                                       id='password'/>
                            </div>

                            <div class="form-group">
                                <input type='submit' id="submit" class="btn btn-primary"
                                       value='${message(code: "springSecurity.login.button")}'/>
                            </div>
                        </form>
                        <small>
                            <g:message code="default.account.question.label"/>
                        </small>
                        <g:link controller="register">
                            <g:message code="default.signup.label"/>
                        </g:link>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script type='text/javascript'>
    <!--
    (function () {
        document.forms['loginForm'].elements['j_username'].focus();
    })();
    // -->
</script>
</body>
</html>
