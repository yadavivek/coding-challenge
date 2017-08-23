<g:if test='${flash.message}'>
    <div class='alert-danger'>${flash.message}</div>
</g:if>

<g:if test='${flash.success}'>
    <div class='alert-success'>${flash.success}</div>
</g:if>
<g:if test='${flash.error}'>
    <div class='alert-danger'>${flash.error}</div>
</g:if>
<g:if test='${flash.errors}'>
    <g:each in="${flash.errors}" var="error">
        <div class='alert-danger'>${error}</div>
    </g:each>
</g:if>

<g:if test="${errors}">
    <g:each in="${errors}" var="error">
        <div class='alert-danger'>${error}</div>
    </g:each>
</g:if>