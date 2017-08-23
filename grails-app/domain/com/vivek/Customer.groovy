package com.vivek

class Customer {

    String name

    Date dateCreated
    Date lastUpdated

    static constraints = {
        name nullable: false, blank: false
    }

    static hasMany = [phones: Phone]

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Customer customer = (Customer) o

        if (id != customer.id) return false
        if (name != customer.name) return false

        return true
    }

    int hashCode() {
        int result
        result = (name != null ? name.hashCode() : 0)
        result = 31 * result + (id != null ? id.hashCode() : 0)
        return result
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                '}';
    }
}
