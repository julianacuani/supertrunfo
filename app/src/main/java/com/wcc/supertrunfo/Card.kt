package com.wcc.supertrunfo

import com.wcc.supertrunfo.entities.Driver
import com.wcc.supertrunfo.entities.Player
import com.wcc.supertrunfo.entities.Vehicle

class Card (
        val vehicle: Vehicle,
        val driver: Driver,
        val player: Player
)  {

    val label: String = "Card ${player.name}"
    val maxVelocity = initMaxVelocity()
    val accelerationTime = vehicle.acclerationTime
    val passengers = initPassengers()
    val xP = initXP()

    private fun initPassengers(): Int {
        return vehicle.passengers * (1 + driver.defensiveDriving)
    }

    private fun initMaxVelocity(): Int {
        return when(vehicle.type){
            "car" -> carMaxVelocity()
            "motorcycle" -> motorcycleMaxVelocity()
            else -> bikeMaxVelocity()
        }
    }

    private fun bikeMaxVelocity(): Int {
        return vehicle.maxAcceleration * driver.boldness
    }

    private fun motorcycleMaxVelocity(): Int {
        return 1/vehicle.weight * vehicle.maxAcceleration

    }

    private fun carMaxVelocity(): Int {
        return if (vehicle.style == "sedã") {
            vehicle.maxAcceleration
        } else{
            vehicle.maxAcceleration + 10
        }
    }

    private fun initXP(): Int{
        return when(vehicle.type){
            "car" -> driver.carXP
            "motorcycle" ->driver.motorcycleXP
            else ->driver.bikeXP
        }
    }
}
