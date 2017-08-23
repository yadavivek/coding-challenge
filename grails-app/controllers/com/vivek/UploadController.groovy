package com.vivek

import org.springframework.web.multipart.MultipartHttpServletRequest

class UploadController {

    def uploadService

    def index() {}

    def save() {
        try {
            if (request instanceof MultipartHttpServletRequest) {
                log.debug("In Upload controller trying to upload file.")
                List<Upload> uploadList = uploadService.uploadData(request)
                flash.success = "File uploaded successfully"
                render(view: 'index', model: [uploadList: uploadList])
            } else {
                flash.message = "Please upload correct file"
                render(view: 'index')
                flash.message = "Please upload correct file"
            }
        }
        catch (Exception e) {
            def errors = e.message[1..e.message.length() - 2].tokenize(",")
            flash.errors = errors
            render(view: 'index')
        }
    }
}
