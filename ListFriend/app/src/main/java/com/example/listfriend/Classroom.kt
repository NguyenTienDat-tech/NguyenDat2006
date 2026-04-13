package com.example.listfriend

data class Classroom (
    val name: String,
    val members: List<HITer>,
    var isExpanded: Boolean = false
)