package com.vivek

/**
 * Created by vivek on 19/8/17.
 */
enum UrlType {
    SHORT("Short"), LONG("Long")

    String value

    UrlType(String name) {
        this.value = value
    }


    @Override
    public String toString() {
        return value
    }
}
