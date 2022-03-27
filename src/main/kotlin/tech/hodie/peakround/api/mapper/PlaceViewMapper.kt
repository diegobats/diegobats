package tech.hodie.peakround.api.mapper

import org.springframework.stereotype.Component
import tech.hodie.peakround.api.dto.client.PlaceView
import tech.hodie.peakround.api.dto.client.SpotView
import tech.hodie.peakround.api.model.products.Place
import tech.hodie.peakround.api.model.products.Spot

@Component
class PlaceViewMapper: Mapper<Place, PlaceView> {
    override fun map(t: Place): PlaceView {
        val publicSpotsData = hashMapOf<String, HashMap<Int, SpotView>>()
        println(t.spots)
        t.spots?.forEach { (k, v) ->

            publicSpotsData[k] = publicListSpotData(v)
        }

        return PlaceView(t.name, t.icon, publicSpotsData, t.tags)
    }

    private fun publicListSpotData(map: HashMap<Int, Spot>?): HashMap<Int, SpotView> {

        val data = hashMapOf<Int, SpotView>()

        map?.forEach { (k, v) ->
            data[k] = SpotView(v.name, v.icon, v.source, v.tags)
        }

        return data
    }


}