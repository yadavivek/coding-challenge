<div class="articles card">

    <div class="card-header d-flex align-items-center">
        <h2 class="h3">Result</h2>
    </div>

    <div class="card-body no-padding">
        <div id="spinner" style="display:none;">
            <asset:image src="custom/spinner-gif-17.gif"/>
        </div>

        <div class="item d-flex align-items-center">
            <div class="text">
                <g:if test='${result}'>
                    <div>${result}</div>
                </g:if>
                <g:render template="../template/message" model="[errors: errors]"/>
            </div>
        </div>
    </div>
</div>