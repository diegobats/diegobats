package tech.hodie.peakround.api.service

import org.springframework.stereotype.Service
import tech.hodie.peakround.api.dto.client.LocationForm
import tech.hodie.peakround.api.dto.client.PlaceView
import tech.hodie.peakround.api.mapper.PlaceViewMapper
import tech.hodie.peakround.api.model.products.Place
import tech.hodie.peakround.api.model.products.PlaceType
import tech.hodie.peakround.api.model.products.Spot
import tech.hodie.peakround.api.model.users.Owner
import java.util.HashMap

@Service
class LocationService(private val costumerService: CostumerService, private val placeViewMapper: PlaceViewMapper) {


    fun location(form: LocationForm): PlaceView {
        val place = customPlace(form)

        return placeViewMapper.map(place)
    }

    private fun customPlace(form: LocationForm): Place {
        val mockOwner = Owner(
            324,
            "user2138",
            "myLocation",
            "mockOwnerUserId",
            "rg12345",
            "contactMock",
            "addressMock",
            "phoneMock",
            "emailMock"
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