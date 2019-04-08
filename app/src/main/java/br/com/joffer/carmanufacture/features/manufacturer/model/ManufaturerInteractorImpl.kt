package br.com.joffer.carmanufacture.features.manufacturer.model

import io.reactivex.Observable

private const val PAGE_SIZE = 15

class ManufaturerInteractorImpl: Manufaturer.Interactor{

    private val repository = Manufaturer.Repository.instance

    override fun fetch(page: Int): Observable<PageManufaturer> {
        return repository.fetch(page, PAGE_SIZE)
    }
}