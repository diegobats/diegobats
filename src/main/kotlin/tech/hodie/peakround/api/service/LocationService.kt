package tech.hodie.peakround.api.service

import org.springframework.stereotype.Service
import tech.hodie.peakround.api.dto.costumer.LocationForm
import tech.hodie.peakround.api.dto.costumer.PlaceView
import tech.hodie.peakround.api.mapper.costumer.PlaceViewMapper
import tech.hodie.peakround.api.model.place.Place
import tech.hodie.peakround.api.model.place.PlaceType
import tech.hodie.peakround.api.model.place.Spot
import tech.hodie.peakround.api.model.user.Owner
import java.util.HashMap

@Service
class LocationService(private val costumerService: CostumerService, private val placeViewMapper: PlaceViewMapper) {


    fun location(form: LocationForm): PlaceView {
        val place = customPlace(form)

        return placeViewMapper.map(place)
    }

    private fun customPlace(form: LocationForm): Place {
        val mockOwner = Owner(
            0,
            "user0",
            "mockUser",
            "MockDocumentId",
            "MockContact",
            "MockAddress",
            "MockPhone",
            "MockEmail",
            hashMapOf("userXYZ" to "facebook")
        )

        val mockSpot = Spot(
            1,
            "MockSpotName",
            mockOwner,
            "iconMock",
            "sourceMock"

        )

        val mockPlace = Place(
            1,
            "mockPlaceName",
            costumerService.costumer(form.id),
            PlaceType.LOCATION,
            "iconMock",
            getSpots(mockSpot),
            listOf()
        )
        return mockPlace
    }

    private fun getSpots(mockSpot: Spot): HashMap<String, HashMap<Int, Spot>>? {
        return hashMapOf("1KM" to hashMapOf(1 to mockSpot), "2KM" to hashMapOf(1 to mockSpot), "3KM" to hashMapOf(1 to mockSpot))
    }


}