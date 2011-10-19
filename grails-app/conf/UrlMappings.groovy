
class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/" {
            controller = "home"
            action = "index"
        }

        // Exception mappings
        "500"(view: '/error')
    }
}
