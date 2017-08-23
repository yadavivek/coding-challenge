<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name='layout' content='main'/>
    <title><g:message code="default.register.label"/></title>
</head>

<body>
<section class="forms">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-header d-flex align-items-center">
                        <h3 class="h4">
                            <g:message code="default.register.label"/>
                        </h3>
                    </div>

                    <div class="card-body">
                    <p>
                        <g:hasErrors bean="${userCO}">
                            <ul class="errors" role="alert">
                                <g:eachError bean="${userCO}" var="error">
                                    <li class="alert-danger"
                                        <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                                            error="${error}"/></li>
                                </g:eachError>
                            </ul>
                        </g:hasErrors>
                        <g:if test="${flash.message}">
                            <ul>
                                <li>
                                    <span class="alert-danger">
                                        ${flash.message}
                                    </span>
                                </li>
                            </ul>
                        </g:if>
                    </p>
                        <g:form id="register-form" action="save">
                            <div class="form-group">
                                <label class="form-control-label">
                                    <g:message code="default.username.label"/>
                                </label>
                                <input id="username" placeholder="Email Address" type="text" name="username"
                                       value="${userCO?.username}" class="form-control">
                            </div>

                            <div class="form-group">
                                <label class="form-control-label">
                                    <g:message code="default.password.label"/>
                                </label>
                                <input id="password" type="password" placeholder="Password" name="password"
                                       value="${userCO?.password}" class="form-control">
                            </div>

                            <div class="form-group">
                                <label class="form-control-label">
                                    <g:message code="default.confirm.password.label"/>
                                </label>
                                <input id="confirm-passowrd" type="password" placeholder="Confirm Password"
                                       name="confirmPassword" value="${userCO?.confirmPassword}" class="form-control">
                            </div>

                            <div class="form-group">
                                <input id="register" type="submit" value="Register" class="btn btn-primary">
                            </div>
                        </g:form>
                        <div>
                            <g:message code="default.already.account.label"/>
                            <g:link controller="shorten" class="signup">
                                <g:message code="default.login.label"/>
                            </g:link>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>