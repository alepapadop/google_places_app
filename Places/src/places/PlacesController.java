/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package places;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author alepapadop
 */
public class PlacesController {
    private static final PlacesView     _places_view        = new PlacesView();
    private static final PlacesModel    _places_model       = new PlacesModel();
    private static PlacesController     _places_controller  = null;
    
    
    
    private PlacesView GetPlacesView()
    {
        return _places_view;
    }
    
    private PlacesModel GetPlacesModel()
    {
        return _places_model;
    }
    
    public void SetPlacesController(PlacesController places_controller)
    {
        _places_controller = places_controller;
    }
    
    public PlacesController GetPlacesController()
    {
        return _places_controller;
    }
    
    private void SetActionListeners()
    {
        GetPlacesView().ButtonActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Double latitude = GetPlacesView().GetLatitudeDouble();
                    Double longitude = GetPlacesView().GetLongtitudeDouble();
                    Double radius = GetPlacesView().GetRadiosDouble();
                    Boolean open_now = GetPlacesView().GetOpenNowBoolean();
                    ArrayList<String> types = GetPlacesView().GetSelectedTypes();
                    int error_code = PlacesView.ErrorCode.OK.ordinal();                                        
                    
                    if (!GetPlacesModel().GetPlacesDataArray().isEmpty()) {
                        GetPlacesModel().GetPlacesDataArray().clear();
                    }
                    
                    if (GetPlacesView().GetPoiList().getModel().getSize() != 0) {                         
                            DefaultListModel list_model = (DefaultListModel)GetPlacesView().GetPoiList().getModel();
                            list_model.removeAllElements();
                            GetPlacesView().ClearFields();
                    }                             
                    
                    if (latitude == null) {
                        error_code = PlacesView.ErrorCode.LATITUDE_EMPTY.ordinal();
                    } else if (longitude == null) {
                        error_code = PlacesView.ErrorCode.LONGITUDE_EMPTY.ordinal();
                    } else if (radius == null) {
                        error_code = PlacesView.ErrorCode.RADIUS_EMPTY.ordinal();
                    } else if (types.isEmpty()) {
                        error_code = PlacesView.ErrorCode.TYPES_EMPTY.ordinal();
                    }
                    
                    if (error_code != PlacesView.ErrorCode.OK.ordinal()) {
                        GetPlacesView().ErrorWindow(error_code);
                    } else {
                        GetPlacesModel().Query(latitude, longitude, radius, open_now, types);
                        GetPlacesView().PopulatePoiList(GetPlacesModel().GetPlacesDataArray(), GetPlacesModel().GetStatusReply());
                    }
                                        
                }
            }
        );
        
        GetPlacesView().PoiListSelectionListener(
            new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    boolean abjust = lse.getValueIsAdjusting();
                    if (!abjust) {
                        JList list = (JList)lse.getSource();
                        int index = list.getSelectedIndex();
                        
                        PlacesData places_data = GetPlacesModel().GetPlacesDataArrayIndex(index);
                        
                        if (places_data != null) {
                            GetPlacesView().SetPoiListData(places_data);

                            if (places_data.GetPhoto() != null) {
                                Image img = GetPlacesModel().ImageRequest(places_data.GetPhoto());
                                GetPlacesView().ShowImage(img);
                            }
                        }
                    }
                }
            }
        );
    }
    
    public PlacesController()
    {
        GetPlacesView().PlacesViewStart();        
        SetActionListeners();
    }    
}
