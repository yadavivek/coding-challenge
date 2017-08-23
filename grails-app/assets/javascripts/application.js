// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require front.js
//= require tether.min.js
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function ($) {
        $('#spinner').ajaxStart(function () {
            $(this).fadeIn();
        }).ajaxStop(function () {
            $(this).fadeOut();
        });
    })(jQuery);
}

function addField(urlType) {
    $("#urlType").val(urlType);
}

var showSpinner = function () {
    $("#spinner").fadeIn('fast');
};

// Global handlers for AJAX events
$(document)
    .on("ajaxSend", showSpinner)
    .on("ajaxStop", function () {
        $("#spinner").fadeOut('fast');
    })
    .on("ajaxError", function (event, jqxhr, settings, exception) {
        $("#spinner").hide();
    });