<div id="spinner" style="display:none; z-index: 100">
    <asset:image src="custom/spinner-gif-17.gif"/>
</div>

<g:hasErrors bean="${shortenUrlCO}">
    <ul class="errors" role="alert">
        <g:eachError bean="${shortenUrlCO}" var="error">
            <li class="alert-danger"
                <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                    error="${error}"/></li>
        </g:eachError>
    </ul>
</g:hasErrors>

<g:if test="${status != 200}">
    <ul class="errors" role="alert">
        <li class="alert-danger">${message}</li>
    </ul>
</g:if>