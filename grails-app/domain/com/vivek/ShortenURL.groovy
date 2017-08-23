package com.vivek

class ShortenURL {

    String longUrl
    String shortUrl

    User user

    Date dateCreated
    Date lastUpdated

    static constraints = {
        shortUrl nullable: false
        longUrl nullable: false
        user(unique: ['longUrl', 'shortUrl'])
    }


    @Override
    public String toString() {
        return "ShortenURL{" +
                "id=" + id +
                ", version=" + version +
                ", longUrl='" + longUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }
}
