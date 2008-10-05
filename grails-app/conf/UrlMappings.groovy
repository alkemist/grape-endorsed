class UrlMappings {
    
    static groovyContstraints = [matches: /^\d.*/]
    static moduleContstraints = [matches: /^(?!images|css|js)[a-zA-Z].*/]
    
    static mappings = {
        "/$groovy/$module/ivy.xml"(controller:"main", action: "ivy")
        "/$groovy/$module"(controller:"main", action: "moduleVersion") {
            constraints {
                groovy(this.groovyContstraints)
            }
        }
        "/$groovy"(controller: "main", action: "show") {
            constraints {
                groovy(this.groovyContstraints)
            }
        }
        "/"(controller: "main")
        "/$module"(controller:"main", action: "module") {
            constraints {
                module(this.moduleContstraints)
            }
        }
        "/$module/$moduleVersion"(controller:"main", action: "moduleVersion") {
            constraints {
                module(this.moduleContstraints)
            }
        }
        "/$module/$moduleVersion/ivy.xml"(controller:"main", action: "ivy") {
            constraints {
                module(this.moduleContstraints)
            }
        }
        "/$controller/$action/$id?"{
            constraints {
                // apply constraints here
            }
        }
        "500"(view: "/error")
    }
}
