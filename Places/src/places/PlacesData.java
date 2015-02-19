/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package places;

import java.util.ArrayList;

/**
 *
 * @author alepapadop
 */
public class PlacesData {
    
    private Boolean _open_now = null;
    private String  _address = null;
    private ArrayList<String>  _type = null;    
    private Double  _rating = null;
    private String  _photo = null;
    private String  _name = null;
    private Double  _latitude = null;
    private Double _longtitude = null;    

    public Boolean GetOpenNow() {
        return _open_now;
    }

    public void SetOpenNow(Boolean _open_now) {
        this._open_now = _open_now;
    }

    public String GetAddress() {
        return _address;
    }

    public void SetAddress(String _address) {
        this._address = _address;
    }

    public ArrayList<String> GetType() {
        return _type;
    }

    public void SetType(ArrayList<String> _type) {
        this._type = _type;
    }

    public Double GetRating() {
        return _rating;
    }

    public void SetRating(Double _rating) {
        this._rating = _rating;
    }

    public String GetPhoto() {
        return _photo;
    }

    public void SetPhoto(String _photo) {
        this._photo = _photo;
    }

    public String GetName() {
        return _name;
    }

    public void SetName(String _name) {
        this._name = _name;
    }
    
    public Double GetLatitude() {
        return _latitude;
    }

    public void SetLatitude(Double _latitude) {
        this._latitude = _latitude;
    }

    public Double GetLongtitude() {
        return _longtitude;
    }

    public void SetLongtitude(Double _longtitude) {
        this._longtitude = _longtitude;
    }
    
    private void InitTypesArray()
    {
        ArrayList<String> type = new ArrayList<>();
        SetType(type);
    }
    
    public void SetTypeVal(String type)
    {
        ArrayList<String>   array = GetType();
        if (array != null) {
            array.add(type);
        }
    }
    
    public String GetTypeIndex(int index)
    {
        ArrayList<String>   array = GetType();
        String ret_val = null;
        try {
            if (array !=null) {
                ret_val = array.get(index);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return ret_val;        
    }
    
    public PlacesData()
    {
        InitTypesArray();
    }
        
}
