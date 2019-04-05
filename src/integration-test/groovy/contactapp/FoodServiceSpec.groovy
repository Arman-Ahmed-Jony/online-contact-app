package contactapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FoodServiceSpec extends Specification {

    FoodService foodService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Food(...).save(flush: true, failOnError: true)
        //new Food(...).save(flush: true, failOnError: true)
        //Food food = new Food(...).save(flush: true, failOnError: true)
        //new Food(...).save(flush: true, failOnError: true)
        //new Food(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //food.id
    }

    void "test get"() {
        setupData()

        expect:
        foodService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Food> foodList = foodService.list(max: 2, offset: 2)

        then:
        foodList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        foodService.count() == 5
    }

    void "test delete"() {
        Long foodId = setupData()

        expect:
        foodService.count() == 5

        when:
        foodService.delete(foodId)
        sessionFactory.currentSession.flush()

        then:
        foodService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Food food = new Food()
        foodService.save(food)

        then:
        food.id != null
    }
}
