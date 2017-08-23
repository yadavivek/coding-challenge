package com.vivek

class Upload {

    String usernameId
    long coin
    String username

    Date dateCreated
    Date lastUpdated

    static constraints = {
        usernameId nullable: false, blank: false, matches: "^\\d{10}\$"
        coin nullable: false, min: 1l, max: Long.MAX_VALUE
        username nullable: false, blank: false
    }
}