package contactapp

import grails.gorm.services.Service

@Service(Tour)
interface TourService {

    Tour get(Serializable id)

    List<Tour> list(Map args)

    Long count()

    void delete(Serializable id)

    Tour save(Tour tour)

}