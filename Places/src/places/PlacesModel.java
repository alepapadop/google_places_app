/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package places;


import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.String.valueOf;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author alepapadop
 */
public class PlacesModel {
    
    private static final String _api_key = "AIzaSyBA5RDhO-sMoQuVltIkxvSnMW_RuPSAZqY";
    
    
    
    private ArrayList<PlacesData>  _places_data_array = null;
    
    private String _status_reply = null;
    
    final static String _results_array = "results";
    final static String _types = "types";
    final static String _vicinity = "vicinity";
    final static String _name = "name";
    final static String _rating = "rating";
    final static String _status = "status";
    final static String _open_now = "open_now";
    final static String _opening_hours = "opening_hours";
    final static String _photos = "photos";
    final static String _photo_reference = "photo_reference";
    final static String _geometry = "geometry";
    final static String _location = "location";
    final static String _lat = "lat";
    final static String _lng = "lng";
    
    private void SetStatusReply(String status_reply)
    {
        _status_reply = status_reply;
    }
    
    public String GetStatusReply()
    {
        return _status_reply;
    }
    
    private void InitPlacesDataArray()
    {
        ArrayList<PlacesData> places_data_array = new ArrayList<>();
        SetPlacesDataArray(places_data_array);
    }
    
    private void SetPlacesDataArray(ArrayList<PlacesData> array)
    {
        _places_data_array = array;
    }
    
    public ArrayList<PlacesData> GetPlacesDataArray()
    {
        return _places_data_array;
    }
    
    private void SetPlacesDataArrayVal(PlacesData places_data)
    {
        ArrayList<PlacesData> places_data_array = GetPlacesDataArray();
        
        if (places_data_array != null && places_data != null) {
            places_data_array.add(places_data);
        }
    }
    
    public PlacesData GetPlacesDataArrayIndex(int index)
    {
        ArrayList<PlacesData> places_data_array = GetPlacesDataArray();
        PlacesData  places_data = null;
        
        if (places_data_array != null && !places_data_array.isEmpty()) {
            try {
                places_data = places_data_array.get(index);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        return places_data;
    }
    
    private String GetApiKey()
    {
        return _api_key;
    }
    
    public void Query(double latitude, double longitude, double radius, boolean open_now, ArrayList<String> types)
    {                                
        String url = QueryURL(latitude, longitude, radius, open_now, types);
        String json_string = Connect(url);
        
        //System.out.println(url);
        if (json_string != null) {
            Parse(json_string);
        }
    }
    
    private String QueryURL(double latitude, double longitube, double radius, boolean open_now, ArrayList<String> types)
    {
        String query;
        String base_str = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
        String location_str = "location=" + latitude + "," + longitube;
        String radius_str = "radius=" + (int)radius;
        String open_now_str = "opennow=" + valueOf(open_now).toLowerCase();
        String types_str = "types=";
        String key_str = "key=" + GetApiKey();
        String glu_str = "&";        
        
        for (int i = 0; i < types.size(); ++i) {
            if (i == 0) {
                types_str = types_str + types.get(i);
            } else {
                types_str = types_str + "|" + types.get(i);
            }
        }
        
        query = base_str + 
                location_str + glu_str + 
                radius_str + glu_str + 
                open_now_str + glu_str + 
                types_str + glu_str +
                key_str;
        
        return query;
    }
    
    private String Connect(String s)
    {
        String json_string = null;
        try {
            String input;
            StringBuilder sb = new StringBuilder();
            URL places_url = new URL(s);
            URLConnection conn = places_url.openConnection();
            BufferedReader in;
            
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));            
            while ((input = in.readLine()) != null) {
                sb.append(input);
                //System.out.println(input);
            }
            in.close();
            json_string = sb.toString();
        } catch (Exception e) {
            json_string = null;
            System.out.println(e.getMessage());
        }
        
        return json_string;
    }
                
    
    
    private void Parse(String json_string)
    {
        try {
            JSONObject obj = new JSONObject(json_string);

            if (obj.has(_status)) {
                SetStatusReply(obj.getString(_status));
            }

            if (obj.has(_results_array)) {
                JSONArray array = obj.getJSONArray(_results_array);                

                for (int i = 0; i < array.length(); ++i) {            
                    JSONObject results_obj_array = array.getJSONObject(i);
                    PlacesData places_data = new PlacesData();

                    if (results_obj_array.has(_vicinity)) {
                        places_data.SetAddress(results_obj_array.getString(_vicinity));
                    }
                    if (results_obj_array.has(_opening_hours) && results_obj_array.getJSONObject(_opening_hours).has(_open_now)) {
                        places_data.SetOpenNow(results_obj_array.getJSONObject(_opening_hours).getBoolean(_open_now));
                    }
                    if (results_obj_array.has(_name)) {
                        places_data.SetName(results_obj_array.getString(_name));
                    }
                    if (results_obj_array.has(_rating)) {
                        places_data.SetRating(results_obj_array.getDouble(_rating));
                    }

                    if (results_obj_array.has(_types)) {
                        JSONArray  types_array = results_obj_array.getJSONArray(_types);
                        for (int j = 0; j < types_array.length(); ++j) {                
                            places_data.SetTypeVal(types_array.get(j).toString());
                        }
                    }
                    
                    if (results_obj_array.has(_photos)) {
                        JSONArray photos_array = results_obj_array.getJSONArray(_photos);
                        
                        for (int j = 0; j < photos_array.length(); ++j) {
                            if (photos_array.getJSONObject(j).has(_photo_reference)) {
                                places_data.SetPhoto(photos_array.getJSONObject(j).getString(_photo_reference));                                
                            }
                        }                        
                    }
                    
                    if (results_obj_array.has(_geometry) && 
                        results_obj_array.getJSONObject(_geometry).has(_location) && 
                        results_obj_array.getJSONObject(_geometry).getJSONObject(_location).has(_lat) &&
                        results_obj_array.getJSONObject(_geometry).getJSONObject(_location).has(_lng)) {
                        
                            places_data.SetLatitude(results_obj_array.getJSONObject(_geometry).getJSONObject(_location).getDouble(_lat));
                            places_data.SetLongtitude(results_obj_array.getJSONObject(_geometry).getJSONObject(_location).getDouble(_lng));
                        
                    }
                    
                    SetPlacesDataArrayVal(places_data);
                }                        
            }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    
    public Image ImageRequest(String reference)
    {
        String base_url = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=200&maxheight=200";
        String reference_url = "&photoreference=" + reference;
        String key_url = "&key=" + GetApiKey();
        String url = base_url + reference_url + key_url;
        Image image;
        
        System.out.println(url);
        
        try {            
            URL img_url = new URL(url);
            image = ImageIO.read(img_url);          
            
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            image = null;
        }
        return image;
    }
    
    private void DebugPlacesDataArray()
    {
        for (PlacesData i : _places_data_array) {
            System.out.println("**************");
            System.out.println("Name " + i.GetName());
            System.out.println("Open now " + i.GetOpenNow().toString());
            System.out.println("Address " + i.GetAddress());
            System.out.println("Rating " + i.GetRating());           
            System.out.println("**************");
        }
    }
    
    public PlacesModel() 
    {
        InitPlacesDataArray();
    }
}
