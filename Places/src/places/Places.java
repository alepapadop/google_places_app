/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package places;

/**
 *
 * @author alepapadop
 */
public class Places {

    private static Places _places = null;
    
    private void SetPlaces(Places places)
    {
        _places = places;
    }
    
    public Places GetPlaces()
    {
        return _places;
    }
    
    public Places()
    {
        PlacesController places_controller = new PlacesController();
        places_controller.SetPlacesController(places_controller);
    }
    
    public static void main(String[] args) {
        Places places = new Places();
        places.SetPlaces(places);
    }
    
}
