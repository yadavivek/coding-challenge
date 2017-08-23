package com.vivek

class Phone {

    String number
    boolean isActivate = false
    Customer customer

    Date dateCreated
    Date lastUpdated

    static constraints = {
        number nullable: false, blank: false, unique: true, matches:"^\\d{10}\$"
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Phone phone = (Phone) o

        if (customer != phone.customer) return false
        if (id != phone.id) return false
        if (number != phone.number) return false

        return true
    }

    int hashCode() {
        int result
        result = (number != null ? number.hashCode() : 0)
        result = 31 * result + (customer != null ? customer.hashCode() : 0)
        result = 31 * result + (id != null ? id.hashCode() : 0)
        return result
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", version=" + version +
                ", number=" + number +
                ", isActivate=" + isActivate +
                '}';
    }
}
