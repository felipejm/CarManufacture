package br.com.joffer.carmanufacture.features.carmodel.model

import io.reactivex.Observable

private const val PAGE_SIZE = 15

class CarModelInteractorImpl: CarModel.Interactor{

    private val repository = CarModel.Repository.instance

    override fun fetch(manufaturer: String, page: Int): Observable<PageCarModel> {
        return repository.fetch(manufaturer, page, PAGE_SIZE)
    }
}