package br.com.joffer.carmanufacture.features.builtdates.model

import io.reactivex.Observable

private const val PAGE_SIZE = 15

class BuiltDateInteractorImpl: BuiltDateModel.Interactor{

    private val repository = BuiltDateModel.Repository.instance

    override fun fetch(manufaturer: String, mainType: String, page: Int): Observable<PageBuiltDate> {
        return repository.fetch(manufaturer, mainType, page, PAGE_SIZE)
    }
}