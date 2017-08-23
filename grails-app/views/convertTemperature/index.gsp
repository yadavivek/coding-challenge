<%--
  Created by IntelliJ IDEA.
  User: vivek
  Date: 22/8/17
  Time: 11:43 AM
--%>

<%@ page import="com.vivek.TemperatureUnitType; com.vivek.TemperatureUnit" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="convert.temperature.label"/></title>
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
                        <g:formRemote name="convert" url="[controller: 'convertTemperature', action: 'convert']"
                                      action='convert'
                                      update="result" method='POST'>
                            <div class="form-group">
                                <label class="form-control-label">
                                    <g:message code="convert.temerature.temperature.label"/>
                                </label>
                                <input type='text' placeholder="Temperature" class='form-control' name='temperature'
                                       id='temperature'/>
                            </div>

                            <div class="form-group">
                                <label class="form-control-label">
                                    <g:message code="convert.temerature.from.label"/>
                                </label>
                                <g:select name="fromUnit" from="${TemperatureUnitType}" optionKey="key"
                                          optionValue="value"
                                          noSelection="['': 'Please select temperature']"/>
                            </div>

                            <div class="form-group">
                                <label class="form-control-label">
                                    <g:message code="convert.temerature.to.label"/>
                                </label>
                                <g:select name="toUnit" from="${TemperatureUnitType}" optionKey="key"
                                          optionValue="value"
                                          noSelection="['': 'Please select temperature']"/>
                            </div>

                            <div class="form-group">
                                <input type='submit' id="submit" class="btn btn-primary" value='Submit'/>
                            </div>
                        </g:formRemote>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-6">
                <div id="result">
                    <div id="spinner" style="display:none;">
                        <asset:image src="custom/spinner-gif-17.gif"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>