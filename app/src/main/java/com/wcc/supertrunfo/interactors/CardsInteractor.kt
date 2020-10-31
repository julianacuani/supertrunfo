package com.wcc.supertrunfo.interactors

import com.wcc.supertrunfo.data.SuperTrunfoDataBase
import com.wcc.supertrunfo.entities.Vehicle

class CardsInteractor {
    private val database = SuperTrunfoDataBase()
    val cardOne: Card = generateCard()
    val cardTwo: Card = generateCard()

    private fun generateCard(): Card {
        val driver = database.getAllDrivers().random()
        val vehicle =database.getAllVehicles().random()

        return Card(vehicle, driver)
    }
}