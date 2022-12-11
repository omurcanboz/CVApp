package com.edu.miu.cvapp.model

import java.io.Serializable

data class Work(
    val title: String,
    val position: String,
    val duration: String,
    val image: Int
) : Serializable