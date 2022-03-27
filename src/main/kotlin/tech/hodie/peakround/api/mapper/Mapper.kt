package tech.hodie.peakround.api.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
