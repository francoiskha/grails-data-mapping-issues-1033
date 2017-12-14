package kha

import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
class ASpec extends Specification {


    @Rollback
    void "simple save with deepValidation by default"(){
        new A(b:new B(id:1,notNullableMember:"I'm not null, I'll be saved")).save(validate:true)
        expect:
        A.all.size() == 1

    }


    @Rollback
    void "deepValidation should not be performed"(){
        new A(b:new B(id:1,notNullableMember:null)).save(validate:true,deepValidate:false)
        expect:
        A.all.size() == 2
        
    }
    
}
