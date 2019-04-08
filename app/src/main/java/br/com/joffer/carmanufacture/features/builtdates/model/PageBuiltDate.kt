package br.com.joffer.carmanufacture.features.builtdates.model

data class PageBuiltDate(val page: Int,
                         val pageSize: Int,
                         val totalPageCount: Int,
                         val wkda: Map<String, String>): BuiltDateModel.Model