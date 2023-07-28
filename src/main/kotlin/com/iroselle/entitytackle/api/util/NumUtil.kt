package com.iroselle.entitytackle.api.util

/**
 * For example:
 *      if now is 1 and max is 100, return 0.01
 *      if now is 20 and max is 200, return 0.1
 * return value min is 0.0, max is 1.0
 */
fun toProgress(now: Int, max: Int): Double {
    // Ensure that max is greater than zero to avoid division by zero
    if (max <= 0) {
        throw IllegalArgumentException("Max must be greater than zero.")
    }

    // Calculate the progress percentage
    val progress = now.toDouble() / max.toDouble()

    // Limit the progress within the range of 0.0 to 1.0
    return progress.coerceIn(0.0, 1.0)
}