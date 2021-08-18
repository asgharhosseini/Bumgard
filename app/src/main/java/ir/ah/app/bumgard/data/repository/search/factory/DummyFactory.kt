package ir.ah.app.bumgard.data.repository.search.factory


import ir.ah.app.bumgard.data.model.*
import java.util.ArrayList

object DummyFactory {




    val cityName= listOf<String>(
        "Paris",
        "London",
        "New York",
        "Amsterdam",
        "Las Vegas",
        "Barcelona",
        "Rome",
        "Madrid",
        "Dubai",
        "Berlin",
        "Venice",
        "Orlando",
    )
    val cityImage= listOf<String>(
        "https://www.hotelscombined.com/rimg/dimg/bd/d1/2f268866-city-36014-162f82486f9.jpg",
        "https://www.hotelscombined.com/rimg/dimg/8a/d8/29dcb2f0-city-28501-17579c53c1d.jpg",
        "https://www.hotelscombined.com/rimg/dimg/8c/a9/d1b21b20-city-15830-16eb6a60801.jpg",
        "https://www.hotelscombined.com/rimg/dimg/8e/a5/73e3f2e4-ctry-174-16751ec4a2e.jpg",
        "https://www.hotelscombined.com/rimg/dimg/60/fa/63274ccd-city-35107-162881ffb3b.jpg",
        "https://www.hotelscombined.com/rimg/dimg/bf/3b/3dfae4b9-lm-4502-1553ae30bd0.jpg",
        "https://www.hotelscombined.com/rimg/dimg/05/fd/515362c8-lm-3638-165cdb13a57.jpg",
        "https://www.hotelscombined.com/rimg/dimg/ff/2a/e1b64f74-city-32213-16287fed57a.jpg",
        "https://www.hotelscombined.com/rimg/dimg/9b/f7/7ab79f27-city-6080-158d0e1464c.jpg",
        "https://www.hotelscombined.com/rimg/dimg/66/73/57707be7-city-9109-162d3eba142.jpg",
        "https://www.hotelscombined.com/rimg/dimg/60/32/beb3f45f-city-8997-556ed2ea.jpg",
        "https://www.hotelscombined.com/rimg/dimg/b0/34/b3ba72de-city-9900-16ed2ee666d.jpg",
    )

    val hotelName= listOf<String>(
        "Park Plaza Westminster",
        "St Giles",
        "The Landmark",
        "Ascot Hyde Park Hotel",
        "The Z Hotel Holborn",
        "The Strand Palace Hotel",
        "OYO The Arch Wembley",
        "Park Grand",
        "The Tower Hotel",
        "Radisson Blu Edwardian",
        "Euston Square Hotel",
        "St. James' Court, A Taj Hotel",
        "Radisson Blu Edwardian",
        "Park Grand",
        "Best Rates Guaranteed",
        "Washington Mayfair Hotel",
    )
    val hotelImage= listOf<String>(
        "https://content.r9cdn.net/rimg/kimg/15/4e/0c846ad5-15e113fef94.jpg",
        "https://content.r9cdn.net/rimg/himg/f1/90/26/leonardo-215550756-FACADE-NIGHT-VIEW_O-465708.jpg",
        "https://content.r9cdn.net/rimg/himg/dc/74/98/leonardo-2694933-Marble_Hall_Sept18_1_O-502859.jpg",
        "https://content.r9cdn.net/rimg/himg/2d/d8/70/hotelsdotcom-195317-4f444cad_w-506037.jpg",
        "https://content.r9cdn.net/rimg/himg/73/d5/c5/revato-3604121-13298534-037133.jpg",
        "https://content.r9cdn.net/rimg/himg/97/61/b6/ice-63054-65987937_3XL-694841.jpg",
        "https://content.r9cdn.net/rimg/himg/f1/4b/ad/revato-1501055-12532854-249243.jpg",
        "https://content.r9cdn.net/rimg/himg/b9/25/3a/revato-3772-13549724-763092.jpg",
        "https://content.r9cdn.net/rimg/himg/65/dd/be/leonardo-67120291-Suite_-_1111_Rooms_08-01-18_4_O-731306.jpg",
        "https://content.r9cdn.net/rimg/himg/fd/55/90/ice-191475402-63965301_3XL-564583.jpg",
        "https://content.r9cdn.net/rimg/himg/5f/4e/ff/leonardo-2113712-Bar_O-076817.jpg",
        "https://content.r9cdn.net/rimg/himg/29/3e/06/leonardo-1297763-St._James__Court_A_Taj_Hotel_-_Lobby_O-464992.jpg",
        "https://content.r9cdn.net/rimg/himg/73/44/bb/ice-116489-72044921_3XL-407583.jpg",
        "https://content.r9cdn.net/rimg/himg/90/a5/f3/revato-6177-230314-078868.jpg",
        "https://content.r9cdn.net/rimg/himg/b0/68/6d/revato-7180-5805193-343288.jpg",
    )


    fun hotelListGenerator():List<Hotel>{
        val hotelList:ArrayList<Hotel> = arrayListOf()
        for (i in 0..10){
            val hotel =Hotel(i,i,i, hotelName[i], hotelImage[i],null,null)
            hotelList.add(hotel)
        }
        return hotelList
    }



    fun cityListGenerator():List<City>{
        val cityList:ArrayList<City> = arrayListOf()
        for (i in 0..10){
            val city =City(i,i, cityName[i], cityImage[i], 55.5,55.5, hotelListGenerator())
            cityList.add(city)
        }
        return cityList
    }

    val DummyCityResponse = CityResponse(cityListGenerator(),1,1,1)
    val DummyHotelResponse =HotelResponse(hotelListGenerator(),1,1,1)




}