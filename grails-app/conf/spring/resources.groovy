import com.vivek.Customer
import com.vivek.Phone
import grails.rest.render.json.JsonCollectionRenderer
import grails.rest.render.json.JsonRenderer

// Place your Spring DSL code here
beans = {

    /*phoneRender(JsonRenderer, Phone) {
        excludes = ['class', 'id', 'dateCreated', 'lastUpdated']
    }

    phonesRender(JsonCollectionRenderer, Phone) {
        excludes = ['class', 'id', 'dateCreated', 'lastUpdated']
    }

    customerRender(JsonRenderer, Customer) {
        excludes = ['class', 'phones', 'dateCreated', 'lastUpdated']
    }

    customersRender(JsonCollectionRenderer, Customer) {
        excludes = ['class', 'phones', 'dateCreated', 'lastUpdated']
    }*/
}
