package com.vivek

import com.vivek.co.UploadCO
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

@Transactional
class UploadService {

    def messageSource
    Locale locale = Locale.default
    private int maxUploadSizeInMb = 10 * 1024 * 1024; // 10 MB

    def uploadData(MultipartHttpServletRequest request) {
        log.debug("In Upload Service uploadData")
        String fileName = request.getFileNames()[0]
        MultipartFile uploadedFile = request.getFile(fileName)

        if (uploadedFile.empty) {
            log.error("File is Empty.")
            throw new Exception([messageSource.getMessage("upload.file.empty.label", null, Locale.default)].toString())
        }

        if (uploadedFile.getSize() > maxUploadSizeInMb) {
            log.error("File size can't exceed 10 MB.")
            throw new Exception([messageSource.getMessage("upload.file.size.error", null, Locale.default)].toString())
        }

        InputStream inputStream = uploadedFile.inputStream
        int index = 1
        List<Upload> uploadList = []
        try {
            inputStream.eachLine { String line ->
                if (line)
                    uploadList.add(parsLine(line, index++))
            }
        } catch (NumberFormatException nfe) {
            log.error("Number is too long. Please provide a valid number")
            throw new RuntimeException([messageSource.getMessage("uploadCO.coin.size.error", null, locale)].toString())
        }
        catch (RuntimeException ex) {
            log.error("Caught Exception while trying to save data in DB.")
            throw ex
        }
        return uploadList
    }

    private Upload parsLine(String line, int index) {
        log.info("Parsing line one by one. line is: $line at index $index")
        String[] detail = line.split(",")
        UploadCO uploadCO = new UploadCO(usernameId: detail[0], coin: detail[1] as Long, username: detail[2])
        log.debug("Upload CO data: $uploadCO")

        if (!uploadCO.validate()) {
            log.error("Data was not validated.")
            List<String> errors = []
            errors.add(messageSource.getMessage("upload.index.error", [index].toArray(), locale))
            uploadCO.errors.each {
                errors.add(messageSource.getMessage("uploadCO.${it.fieldError.field}.${it.fieldError.code}", null, locale))
            }
            log.error("validation errors are: $errors")
            throw new RuntimeException(errors.toString())
        }
        Upload upload = new Upload(uploadCO.properties)
        return upload.save(failOnError: true)
    }
}