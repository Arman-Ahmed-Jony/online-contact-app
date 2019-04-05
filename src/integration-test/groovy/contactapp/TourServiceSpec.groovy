package contactapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TourServiceSpec extends Specification {

    TourService tourService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Tour(...).save(flush: true, failOnError: true)
        //new Tour(...).save(flush: true, failOnError: true)
        //Tour tour = new Tour(...).save(flush: true, failOnError: true)
        //new Tour(...).save(flush: true, failOnError: true)
        //new Tour(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tour.id
    }

    void "test get"() {
        setupData()

        expect:
        tourService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Tour> tourList = tourService.list(max: 2, offset: 2)

        then:
        tourList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tourService.count() == 5
    }

    void "test delete"() {
        Long tourId = setupData()

        expect:
        tourService.count() == 5

        when:
        tourService.delete(tourId)
        sessionFactory.currentSession.flush()

        then:
        tourService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Tour tour = new Tour()
        tourService.save(tour)

        then:
        tour.id != null
    }
}
