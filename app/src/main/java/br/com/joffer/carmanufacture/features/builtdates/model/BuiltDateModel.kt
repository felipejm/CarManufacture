package br.com.joffer.carmanufacture.features.builtdates.model

import io.reactivex.Observable

interface BuiltDateModel{

    interface Model

    interface Repository{
        companion object {
            val instance : BuiltDateModel.Repository = BuiltDateRepository()
        }
        fun fetch(manufaturer: String, mainType: String, page: Int, pageSize: Int): Observable<PageBuiltDate>
    }

    interface Interactor{
        companion object {
            val instance : BuiltDateModel.Interactor = BuiltDateInteractorImpl()
        }

        fun fetch(manufaturer: String, mainType: String, page: Int): Observable<PageBuiltDate>
    }
}