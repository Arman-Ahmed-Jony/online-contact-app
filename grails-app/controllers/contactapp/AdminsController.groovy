package contactapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AdminsController {

    AdminsService adminsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond adminsService.list(params), model:[adminsCount: adminsService.count()]
    }

    def show(Long id) {
        respond adminsService.get(id)
    }

    def create() {
        respond new Admins(params)
    }

    def save(Admins admins) {
        if (admins == null) {
            notFound()
            return
        }

        try {
            adminsService.save(admins)
        } catch (ValidationException e) {
            respond admins.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'admins.label', default: 'Admins'), admins.id])
                redirect admins
            }
            '*' { respond admins, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond adminsService.get(id)
    }

    def update(Admins admins) {
        if (admins == null) {
            notFound()
            return
        }

        try {
            adminsService.save(admins)
        } catch (ValidationException e) {
            respond admins.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'admins.label', default: 'Admins'), admins.id])
                redirect admins
            }
            '*'{ respond admins, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        adminsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'admins.label', default: 'Admins'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'admins.label', default: 'Admins'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
