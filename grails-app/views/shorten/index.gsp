<%@ page import="com.vivek.UrlType" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="shorten.url.label"/></title>
</head>

<body>

<section class="form">
    <div class="container-fluid">
        <div class="col-lg-6">
            <div class="articles card">

                <div class="card-header d-flex align-items-center">
                    <h3 class="h4">
                        <g:message code="shorten.url.label"/>
                    </h3>
                </div>

                <div class="card-body">
                    <p>
                        <g:message code="shorten.url.description"/>
                    </p>
                    <g:formRemote id="sendUrl" name="sendUrl" url="[controller: 'shorten', action: 'save']"
                                  update="result">
                        <div class="form-group">
                            <label class="form-control-label">Url</label>
                            <input placeholder="Insert Url here" class="form-control" type="text" name="url">

                        </div>
                        <input id="urlType" type="hidden" name="urlType" value="">

                        <div class="form-group">
                            <g:submitButton class="btn btn-primary" name="short" value="Shorten a long URL"
                                            onclick="addField('${UrlType.LONG.name()}')"/>
                            <g:submitButton class="btn btn-primary" name="long" value="Expand a short URL"
                                            onclick="addField('${UrlType.SHORT.name()}')"/>
                        </div>
                    </g:formRemote>
                </div>

                <div class="card-body">
                    <div class="item d-flex align-items-center">
                        <div id="result" class="text">
                            <div id="spinner" style="display:none;">
                                <asset:image src="custom/spinner-gif-17.gif"/>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>
</body>
</html>