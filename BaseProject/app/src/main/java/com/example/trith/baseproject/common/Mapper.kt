package com.example.trith.baseproject.common

/**
 * Created by tri.th on 24/08/2018.
 */
abstract class Mapper<InType, OutType> {

    abstract fun map(from: InType): OutType

    abstract fun reverseMap(to: OutType): InType

    fun map(listFrom: List<InType>): List<OutType> {
        return listFrom.map(this::map)
    }

    fun reverseMap(listTo: List<OutType>): List<InType> {
        return listTo.map(this::reverseMap)
    }
}