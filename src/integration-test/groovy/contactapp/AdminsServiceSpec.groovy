package contactapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AdminsServiceSpec extends Specification {

    AdminsService adminsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Admins(...).save(flush: true, failOnError: true)
        //new Admins(...).save(flush: true, failOnError: true)
        //Admins admins = new Admins(...).save(flush: true, failOnError: true)
        //new Admins(...).save(flush: true, failOnError: true)
        //new Admins(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //admins.id
    }

    void "test get"() {
        setupData()

        expect:
        adminsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Admins> adminsList = adminsService.list(max: 2, offset: 2)

        then:
        adminsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        adminsService.count() == 5
    }

    void "test delete"() {
        Long adminsId = setupData()

        expect:
        adminsService.count() == 5

        when:
        adminsService.delete(adminsId)
        sessionFactory.currentSession.flush()

        then:
        adminsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Admins admins = new Admins()
        adminsService.save(admins)

        then:
        admins.id != null
    }
}
