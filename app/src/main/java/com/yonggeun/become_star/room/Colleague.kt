package com.yonggeun.become_star.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Colleague(
    var Job: String? = null,
    var Colleague_Type: String? = null,
    @PrimaryKey
    var Colleague_Name: String,
    var First_Impact: String? = null,
    var Possession_infiniteCard: Int? = null
)