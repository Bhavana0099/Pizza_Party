package com.zybooks.pizzaparty

import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8

/** This is a class that calculates the number of pizzas needed for a pizza party
 *  based on the party size and the hunger level.
 *  @param partySize defines the number of people attending the pizza party.
 *  @param hungerLevel defines the hunger level of the participants.
 */
class PizzaCalculator(partySize: Int, var hungerLevel: HungerLevel) {
    /** Ensures that the value of number of people attending
     * the pizza party is non-negative.
     */
    var partySize = 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    /**
     * Enum class consists of different levels of hunger .
     * Each hunger level is associated with a specific number of slices per person.
     * @property numSlices defines the number of slices per person for the hunger level.
     */
    enum class HungerLevel(var numSlices: Int) {
        LIGHT(2), MEDIUM(3), RAVENOUS(4)
    }

    /**
     * Calculates the total number of pizzas needed for the pizza party.
     * Returns the total number of pizzas needed.
     */
    val totalPizzas: Int
        get() {
            return ceil(partySize * hungerLevel.numSlices / SLICES_PER_PIZZA.toDouble()).toInt()
        }

    /**
     * @property partySize is initialized with the provided value.
     * @param partySize holds the number of people attending the pizza party.
     */
    init {
        this.partySize = partySize
    }
}