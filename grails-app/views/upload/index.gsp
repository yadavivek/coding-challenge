<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="upload.file.label"/></title>
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
                            <g:render template="../template/message"/>
                        </p>
                        <g:uploadForm action="save" method="post" id="upload_file_form">
                            <div class="form-group">
                                <label class="form-control-label">
                                    <g:message code="upload.file.label"/>
                                </label>
                                <input type="file" class="required" name="upload_file" id="upload_file"/>
                            </div>

                            <div class="form-group">
                                <g:submitButton name="submit" class="btn btn-primary"/>
                            </div>
                        </g:uploadForm>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<g:if test="${uploadList}">
    <section class="table">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6">
                    <div class="card">
                        <div class="card-header d-flex align-items-center">
                            <h3 class="h4">Result</h3>
                        </div>

                        <div class="card-body">
                            <table class="table table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>Username Id</th>
                                    <th>Coin</th>
                                    <th>Username</th>
                                </tr>
                                </thead>
                                <tbody>
                                <g:each in="${uploadList}" var="val">
                                    <tr>
                                        <td>${val.usernameId}</td>
                                        <td>${val.coin}</td>
                                        <td>${val.username}</td>
                                    </tr>
                                </g:each>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</g:if>

</body>
</html>