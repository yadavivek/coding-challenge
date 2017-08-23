package com.vivek

import grails.plugins.rest.client.RestBuilder

/**
 * Created by vivek on 19/8/17.
 */

class RestAPIBuilder {

    private static RestBuilder builder
    private static RestAPIBuilder restAPIBuilder = null

    private RestAPIBuilder() {
        createBuilder()
    }

    public static RestAPIBuilder getInstance() {
        if (restAPIBuilder == null) {
            restAPIBuilder = new RestAPIBuilder()
        }
        return restAPIBuilder
    }

    public static RestBuilder getBuilder() {
        if (!builder) {
            createBuilder()
        }
        return builder
    }

    private static void createBuilder() {
        if (!builder) {
            builder = new RestBuilder(connectTimeout: 1000, readTimeout: 20000)
        }
    }
}