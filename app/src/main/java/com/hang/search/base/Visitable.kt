package com.hang.search.base

interface Visitable<T> {
    fun type(typeFactory: T): Int
}