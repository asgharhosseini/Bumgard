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
            val city =City(i,i,"London $i",
                "http://bmtehran.ir/wp-content/uploads/2018/08/50-%D8%B1%D8%B3%D8%AA%D9%88%D8%B1%D8%A7%D9%86-%D8%A8%D8%B1%D8%AA%D8%B1-%D8%A7%DB%8C%D8%B1%D8%A7%D9%86-%D8%A8%D9%87%D8%AA%D8%B1%DB%8C%D9%86-%D8%B1%D8%B3%D8%AA%D9%88.jpg",
                55.5,55.5, hotelListGenerator())
            cityList.add(city)
        }
        return cityList
    }

    val DummyCityResponse = CityResponse(cityListGenerator(),1,1,1)
    val DummyHotelResponse =HotelResponse(hotelListGenerator(),1,1,1)




}