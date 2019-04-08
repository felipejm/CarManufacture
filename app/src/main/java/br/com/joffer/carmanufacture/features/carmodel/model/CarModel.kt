package br.com.joffer.carmanufacture.features.carmodel.model

import io.reactivex.Observable

interface CarModel{

    interface Model

    interface Repository{
        companion object {
            val instance : CarModel.Repository = CarModelRepository()
        }
        fun fetch(manufaturer: String, page: Int, pageSize: Int): Observable<PageCarModel>
    }

    interface Interactor{
        companion object {
            val instance : CarModel.Interactor = CarModelInteractorImpl()
        }

        fun fetch(manufaturer: String, page: Int): Observable<PageCarModel>
    }
}