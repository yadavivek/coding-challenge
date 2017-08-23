import com.vivek.*

class BootStrap {

    def init = { servletContext ->

        /*RoleEnum.values().each {
            new Role(authority: it).save()
        }

        User user = new User(username: "vivek", password: "yadav").save()

        new UserRole(user: user, role: Role.findByAuthority(RoleEnum.ROLE_USER.name())).save()*/

        (1..5).each {
            Customer customer = Customer.get(it)
            if(!customer) {
                customer = new Customer(name: "vivek").save()
                (1..4).each {
                    Long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
                    while (Phone.findByNumber(number)) {
                        number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
                    }
                    new Phone(number: number, customer: customer).save()
                }
            }
        }
    }
    def destroy = {
    }
}
