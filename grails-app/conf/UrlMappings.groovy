class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'shorten')
        "500"(view: '/error')
        "404"(controller: "errors", action: "notFound")

        "/phone"(controller: 'phone')
        "/phone/$customerId"(controller: 'phone')
        "/phone/activate/$number"(controller: 'phone', action: 'activate')
    }
}
