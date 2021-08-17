package ir.ah.app.bumgard.data.repository.search.factory


import ir.ah.app.bumgard.data.model.*
import java.util.ArrayList

object DummyFactory {



    fun hotelListGenerator():List<Hotel>{
        val hotelList:ArrayList<Hotel> = arrayListOf()
        for (i in 0..10){
            val hotel =Hotel(i,i,i,"test","",null,null)
            hotelList.add(hotel)
        }
        return hotelList
    }



    fun cityListGenerator():List<City>{
        val cityList:ArrayList<City> = arrayListOf()
        for (i in 0..10){
            val city =City(i,i,"London","",55.5,55.5, hotelListGenerator())
            cityList.add(city)
        }
        return cityList
    }

    val DummyCityResponse = CityResponse(cityListGenerator(),1,1,1)
    val DummyHotelResponse =HotelResponse(hotelListGenerator(),1,1,1)




}