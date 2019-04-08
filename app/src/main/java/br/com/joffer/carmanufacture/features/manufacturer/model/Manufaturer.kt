package br.com.joffer.carmanufacture.features.manufacturer.model

import io.reactivex.Observable

interface Manufaturer{

    interface Model

    interface Repository{
        companion object {
            val instance : Manufaturer.Repository = ManufaturerRepository()
        }
        fun fetch(page: Int, pageSize: Int): Observable<PageManufaturer>
    }

    interface Interactor{
        companion object {
            val instance : Manufaturer.Interactor = ManufaturerInteractorImpl()
        }

        fun fetch(page: Int): Observable<PageManufaturer>
    }
}