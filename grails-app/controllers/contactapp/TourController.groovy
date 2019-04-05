package contactapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TourController {

    TourService tourService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tourService.list(params), model:[tourCount: tourService.count()]
    }

    def show(Long id) {
        respond tourService.get(id)
    }

    def create() {
        respond new Tour(params)
    }

    def save(Tour tour) {
        if (tour == null) {
            notFound()
            return
        }

        try {
            tourService.save(tour)
        } catch (ValidationException e) {
            respond tour.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tour.label', default: 'Tour'), tour.id])
                redirect tour
            }
            '*' { respond tour, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tourService.get(id)
    }

    def update(Tour tour) {
        if (tour == null) {
            notFound()
            return
        }

        try {
            tourService.save(tour)
        } catch (ValidationException e) {
            respond tour.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tour.label', default: 'Tour'), tour.id])
                redirect tour
            }
            '*'{ respond tour, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tourService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tour.label', default: 'Tour'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tour.label', default: 'Tour'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
