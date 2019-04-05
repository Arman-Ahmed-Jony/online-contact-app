package contactapp

import grails.gorm.services.Service

@Service(Admins)
interface AdminsService {

    Admins get(Serializable id)

    List<Admins> list(Map args)

    Long count()

    void delete(Serializable id)

    Admins save(Admins admins)

}