package com.vivek.util

import org.springframework.http.HttpStatus

class CodingUtil {

    public static Map<String, Object> getResponseBody(
            def result, HttpStatus status, String logMessage, List<String> validationErrors) {
        Map<String, Object> responseBody = new HashMap<String, Object>()
        HttpStatus defaultNoErrorStatus = HttpStatus.OK
        responseBody.put("result", result)
        responseBody.put("status", (status?.value() ?: defaultNoErrorStatus.value()))
        responseBody.put("info", (logMessage?.replace('"', '\'') ?: status.reasonPhrase.replace('"', '\'') ?: defaultNoErrorStatus.reasonPhrase.replace('"', '\'')))
        if (validationErrors) {
            responseBody.put("validationErrors", validationErrors.toArray())
            responseBody.remove("result")
        }
        return responseBody
    }
}
