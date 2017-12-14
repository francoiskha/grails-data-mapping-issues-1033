package kha

class B {

    String notNullableMember
    
    static constraints = {
        notNullableMember nullable:false // setting it explicitly for the sake of explanation
    }
}
