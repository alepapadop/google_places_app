/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package places;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.X_AXIS;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author alepapadop
 */
public class PlacesView {
    
    private JFrame _frame = null;
    private JPanel _panel = null;
    
    private JPanel _input_panel = null;    
    private JPanel _input_panel_1 = null;
    private JPanel _input_panel_2 = null;
    private JPanel _input_panel_3 = null;
    private JPanel _input_panel_4 = null;
    
    private JPanel _output_panel = null;
    private JPanel _output_panel_1 = null;
    private JPanel _output_panel_2 = null;
    private JPanel _output_panel_3 = null;
        
    private JFormattedTextField _longitute = null;
    private JFormattedTextField _latitude = null;
    private JFormattedTextField _radios = null;    
    private JFormattedTextField _distance = null;
    private JFormattedTextField _address = null;
    private JFormattedTextField _rating = null;
    
    private JButton _button = null;
    
    private JCheckBox _check_box = null;
    
    private JList _categories_list = null;
    private JList _poi_list = null;
    
    private JScrollPane _categories_scroll = null;
    private JScrollPane _poi_scroll = null;
    
    private JLabel  _image_label = null;
    
    final private String _types[] = new String[]{"Lodging", 
                                                 "food", 
                                                 "cafe", 
                                                 "night_club", 
                                                 "car_rental", 
                                                 "museum", 
                                                 "church", 
                                                 "hospital", 
                                                 "pharmacy", 
                                                 "police", 
                                                 "post_office"};
    
    public static enum ErrorCode {
        LATITUDE_EMPTY,
        LONGITUDE_EMPTY,
        RADIUS_EMPTY,
        TYPES_EMPTY,
        OK    
    }
    
    final private String _error_msg[] = new String[]{"Latitude field is empty",
                                                     "Longitude field is empty",
                                                     "Radius field is empty",
                                                     "No selected types"};
    
    public static enum ReplyCode {
        OK,
        UNKNOWN_ERROR,
        ZERO_RESULTS,
        OVER_QUERY_LIMIT,
        REQUEST_DENIED,
        INVALID_REQUEST,
        NOT_FOUND        
    }
    
    final private String _reply_code[] = new String[]{"OK",
                                                      "UNKNOWN_ERROR",
                                                      "ZERO_RESULTS",
                                                      "OVER_QUERY_LIMIT",
                                                      "REQUEST_DENIED",
                                                      "INVALID_REQUEST",
                                                      "NOT_FOUND"};
    
    private JFrame GetFrame() {
        return _frame;
    }

    private void SetFrame(JFrame _frame) {
        this._frame = _frame;
    }
    
    public JLabel GetImageLabel()
    {
        return _image_label;
    }
    
    public void SetImageLabel(JLabel label)
    {
        _image_label = label;
    }
    
    private JPanel GetInputPanel() {
        return _input_panel;
    }

    private void SetInputPanel(JPanel _input_panel) {
        this._input_panel = _input_panel;
    }

    private JPanel GetInputPanel1() {
        return _input_panel_1;
    }

    private void SetInputPanel1(JPanel _input_panel_1) {
        this._input_panel_1 = _input_panel_1;
    }

    private JPanel GetInputPanel2() {
        return _input_panel_2;
    }

    private void SetInputPanel2(JPanel _input_panel_2) {
        this._input_panel_2 = _input_panel_2;
    }

    private JPanel GetInputPanel3() {
        return _input_panel_3;
    }

    private void SetInputPanel3(JPanel _input_panel_3) {
        this._input_panel_3 = _input_panel_3;
    }

    private JPanel GetInputPanel4() {
        return _input_panel_4;
    }

    private void SetInputPanel4(JPanel _input_panel_4) {
        this._input_panel_4 = _input_panel_4;
    }

    private JPanel GetOutputPanel() {
        return _output_panel;
    }

    private void SetOutputPanel(JPanel _output_panel) {
        this._output_panel = _output_panel;
    }

    private JPanel GetOutputPanel1() {
        return _output_panel_1;
    }

    private void SetOutputPanel1(JPanel _output_panel_1) {
        this._output_panel_1 = _output_panel_1;
    }

    private JPanel GetOutputPanel2() {
        return _output_panel_2;
    }

    private void SetOutputPanel2(JPanel _output_panel_2) {
        this._output_panel_2 = _output_panel_2;
    }

    private JPanel GetOutputPanel3() {
        return _output_panel_3;
    }

    private void SetOutputPanel3(JPanel _output_panel_3) {
        this._output_panel_3 = _output_panel_3;
    }

    private JFormattedTextField GetLongitute() {
        return _longitute;
    }

    private void SetLongitute(JFormattedTextField _longitute) {
        this._longitute = _longitute;
    }

    private JFormattedTextField GetLatitude() {
        return _latitude;
    }

    private void SetLatitude(JFormattedTextField _latitude) {
        this._latitude = _latitude;
    }

    private JFormattedTextField GetRadios() {
        return _radios;
    }

    private void SetRadios(JFormattedTextField _radios) {
        this._radios = _radios;
    }

    private JButton GetButton() {
        return _button;
    }

    private void SetButton(JButton _button) {
        this._button = _button;
    }

    private JCheckBox GetCheckBox() {
        return _check_box;
    }

    private void SetCkeckBox(JCheckBox _ckeck_box) {
        this._check_box = _ckeck_box;
    }

    private JScrollPane GetCategoriesScroll() {
        return _categories_scroll;
    }

    private void SetCategoriesScroll(JScrollPane _categories_scroll) {
        this._categories_scroll = _categories_scroll;
    }

    public JScrollPane GetPoiScroll() {
        return _poi_scroll;
    }

    private void SetPoiScroll(JScrollPane _poi_scroll) {
        this._poi_scroll = _poi_scroll;
    }
    
    private JPanel GetPanel() {
        return _panel;
    }

    private void SetPanel(JPanel _panel) {
        this._panel = _panel;
    }
    
    private JFormattedTextField GetDistance() {
        return _distance;
    }

    private void SetDistance(JFormattedTextField _distance) {
        this._distance = _distance;
    }

    private JFormattedTextField GetAddress() {
        return _address;
    }

    private void SetAddress(JFormattedTextField _address) {
        this._address = _address;
    }

    private JFormattedTextField GetRating() {
        return _rating;
    }

    private void SetRating(JFormattedTextField _rating) {
        this._rating = _rating;
    }
    
    private JList GetCategoriesList() {
        return _categories_list;
    }

    private void SetCategoriesList(JList _categories_list) {
        this._categories_list = _categories_list;
    }

    public JList GetPoiList() {
        return _poi_list;
    }

    private void SetPoiList(JList _poi_list) {
        this._poi_list = _poi_list;
    }
    
    private void PlacesViewPopulateInputPanel1()
    {
        JPanel              input_panel_1   = GetInputPanel1();
        JFormattedTextField longtitude      = GetLongitute();
        JFormattedTextField latitude        = GetLatitude();
        JFormattedTextField radios          = GetRadios();
        GridLayout          layout          = new GridLayout(3,2);
        JLabel              label;
        
        input_panel_1.setLayout(layout);
        input_panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        label = new JLabel("Longtitude:");
        input_panel_1.add(label);
        input_panel_1.add(longtitude);

        label = new JLabel("Latitude:");
        input_panel_1.add(label);
        input_panel_1.add(latitude);
                
        label = new JLabel("Radios:");
        input_panel_1.add(label);
        input_panel_1.add(radios);
        
    }
    
    private void PlacesViewPopulateInputPanel2()
    {
        JPanel      input_panel_2       = GetInputPanel2();
        BoxLayout   layout              = new BoxLayout(input_panel_2, BoxLayout.Y_AXIS);
        JLabel      label               = new JLabel("Categories");
        JScrollPane categories_scroll   = GetCategoriesScroll();
        JList       categories_list     = GetCategoriesList();
        
        
        categories_scroll.getViewport().add(categories_list);        
        input_panel_2.setLayout(layout);
        input_panel_2.add(label);
        input_panel_2.add(categories_scroll);        
        
    }
    
    private void PlacesViewPopulateInputPanel3()
    {
        JPanel      input_panel_3   = GetInputPanel3();
        BoxLayout   layout          = new BoxLayout(input_panel_3, BoxLayout.Y_AXIS);
        JCheckBox   check_box       = GetCheckBox();
                
        input_panel_3.setLayout(layout);        
        input_panel_3.add(check_box);
        
    }
    
    private void PlacesViewPopulateInputPanel4()
    {
        JPanel      input_panel_4   = GetInputPanel4();
        BoxLayout   layout          = new BoxLayout(input_panel_4, BoxLayout.Y_AXIS);
        JButton     button          = GetButton();
        
        input_panel_4.setLayout(layout);
        input_panel_4.add(button);
        
    }
    
    private void PlacesViewPopulateOutputPanel1()
    {
        JPanel          output_panel_1  = GetOutputPanel1();
        BoxLayout       layout          = new BoxLayout(output_panel_1, BoxLayout.Y_AXIS);
        JScrollPane     poi_scroll      = GetPoiScroll();
        JLabel          label           = new JLabel("Points of interest");
        JList           poi_list        = GetPoiList();
        
        poi_scroll.getViewport().add(poi_list);
        output_panel_1.setLayout(layout);
        output_panel_1.add(label);
        output_panel_1.add(poi_scroll);
        
    }
    
    private void PlacesViewPopulateOutputPanel2()
    {
        JPanel          output_panel_2  = GetOutputPanel2();
        BoxLayout       layout          = new BoxLayout(output_panel_2, BoxLayout.Y_AXIS);
        JLabel          label           = GetImageLabel();
        
        output_panel_2.setLayout(layout);
        output_panel_2.add(label);
                        
    }
    
    private void PlacesViewPopulateOutputPanel3()
    {
        JPanel                  output_panel_3      = GetOutputPanel3();        
        GridLayout              layout              = new GridLayout(3,2);
        JFormattedTextField     distance            = GetDistance();
        JFormattedTextField     address             = GetAddress();
        JFormattedTextField     rating              = GetRating();
        JLabel                  label;
        
        output_panel_3.setLayout(layout);
        
        label = new JLabel("Distance");
        output_panel_3.add(label);
        output_panel_3.add(distance);
        
        label = new JLabel("Address");
        output_panel_3.add(label);
        output_panel_3.add(address);
        
        label = new JLabel("Rating");
        output_panel_3.add(label);
        output_panel_3.add(rating);
        
    }
    
    private void PlacesViewPopulateInputPanel()
    {
        JPanel      input_panel     = GetInputPanel();
        JPanel      input_panel_1   = GetInputPanel1();
        JPanel      input_panel_2   = GetInputPanel2();
        JPanel      input_panel_3   = GetInputPanel3();
        JPanel      input_panel_4   = GetInputPanel4();
        BoxLayout   layout          = new BoxLayout(input_panel, BoxLayout.Y_AXIS);
        
        PlacesViewPopulateInputPanel1();
        PlacesViewPopulateInputPanel2();
        PlacesViewPopulateInputPanel3();
        PlacesViewPopulateInputPanel4();
        
        input_panel.setLayout(layout);
        input_panel.add(input_panel_1);
        input_panel.add(input_panel_2);
        input_panel.add(input_panel_3);
        input_panel.add(input_panel_4);
        
    }
    
    private void PlacesViewPopulateOutputPanel()
    {
        JPanel      output_panel        = GetOutputPanel();
        JPanel      output_panel_1      = GetOutputPanel1();
        JPanel      output_panel_2      = GetOutputPanel2();
        JPanel      output_panel_3      = GetOutputPanel3();        
        BoxLayout   layout              = new BoxLayout(output_panel, BoxLayout.Y_AXIS);
        
        PlacesViewPopulateOutputPanel1();
        PlacesViewPopulateOutputPanel2();
        PlacesViewPopulateOutputPanel3();
        
        output_panel.setLayout(layout);
        output_panel.add(output_panel_1);
        output_panel.add(output_panel_2);
        output_panel.add(output_panel_3);
                
    }
    
    private void PlacesViewPopulatePanel()
    {
        JPanel      panel           = GetPanel();
        JPanel      input_panel     = GetInputPanel();
        JPanel      output_panel    = GetOutputPanel();
        BoxLayout   layout          = new BoxLayout(panel, BoxLayout.X_AXIS);
        
        PlacesViewPopulateInputPanel();
        PlacesViewPopulateOutputPanel();
        
        panel.setLayout(layout);
        panel.add(input_panel);
        panel.add(output_panel);
                
    }
    
    private void PlacesViewPopulateFrame()
    {
        JFrame      frame   = GetFrame();
        JPanel      panel   = GetPanel();
        
        PlacesViewPopulatePanel();
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void PlacesViewInit()
    {
        SetFrame(new JFrame());
        SetPanel(new JPanel());
        SetInputPanel(new JPanel());
        SetInputPanel1(new JPanel());
        SetInputPanel2(new JPanel());
        SetInputPanel3(new JPanel());
        SetInputPanel4(new JPanel());
        SetOutputPanel(new JPanel());
        SetOutputPanel1(new JPanel());
        SetOutputPanel2(new JPanel());
        SetOutputPanel3(new JPanel());        
        SetLongitute(new JFormattedTextField());
        SetLatitude(new JFormattedTextField());
        SetRadios(new JFormattedTextField());
        SetCkeckBox(new JCheckBox());
        SetCategoriesScroll(new JScrollPane());
        SetPoiScroll(new JScrollPane());
        SetButton(new JButton());
        SetDistance(new JFormattedTextField());
        SetAddress(new JFormattedTextField());
        SetRating(new JFormattedTextField());
        SetCategoriesList(new JList());
        SetPoiList(new JList());
        SetImageLabel(new JLabel());
        
        PlacesViewPopulateFrame();
        
        AddCategoriesListData();
        CategoriesListProperties();
        PoiListProperties();
        SetPropertiesToOutput();
        SetPropertiesButton();
        SetPropertiesCheckBox();
    }
    
    private String GetStringFromJFormattedTextField(JFormattedTextField text_field)
    {
        String str = text_field.getText();
        
        if (str.trim().length() == 0) {
            str = null;
        }
        
        return str;
    }
    
    private Double GetDoubleFromJFormattedTextField(JFormattedTextField text_field)
    {
        String str = GetStringFromJFormattedTextField(text_field);
        Double val = null;
        
        if (str != null) {
            val = Double.valueOf(str);
        }
        return val;
    }
    
    private void CategoriesListProperties()
    {
        JList list = GetCategoriesList();
        
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);        
    }        
    
    private void AddCategoriesListData()
    {
        DefaultListModel list_model = new DefaultListModel();
        
        for (int i = 0; i < _types.length; ++i) {
            list_model.addElement(_types[i]);            
        }
        GetCategoriesList().setModel(list_model);
    }
    
    private void PoiListProperties()
    {
        JList list = GetPoiList();
        
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
    }
    
    private void SetPropertiesToOutput()
    {
        GetRating().setEditable(false);
        GetDistance().setEditable(false);
        GetAddress().setEditable(false);
    }
    
    private void SetPropertiesButton()
    {
        GetButton().setText("POI");
        GetButton().setSize(100, 100);
    }
    
    private void SetPropertiesCheckBox()
    {
        GetCheckBox().setText("Open Now");
    }
    
    public Double GetLatitudeDouble()
    {
        return GetDoubleFromJFormattedTextField(GetLatitude());
    }
    
    public Double GetLongtitudeDouble()
    {
        return GetDoubleFromJFormattedTextField(GetLongitute());
    }
    
    public Double GetRadiosDouble()
    {
        return GetDoubleFromJFormattedTextField(GetRadios());
    }
    
    public boolean GetOpenNowBoolean()
    {
        return GetCheckBox().isSelected();
    }
    
    public ArrayList<String>  GetSelectedTypes()
    {
        ArrayList<String> selected_types = new ArrayList<>();
                
        int selected[] = GetCategoriesList().getSelectedIndices();                
        
        for (int i = 0; i < selected.length; ++i) {
            selected_types.add((_types[selected[i]]).toLowerCase());
        }
        
        return selected_types;
    }
    
    public void PlacesViewStart()
    {
        PlacesViewInit();
        
    }

    public void ErrorWindow(int error_code)
    {
        JFrame frame = new JFrame();
        
        JOptionPane.showMessageDialog(frame,
                                     _error_msg[error_code],
                                     "Error",
                                      JOptionPane.ERROR_MESSAGE);
    }
    
    private void ErrorReplyWindow(String reply_code)
    {
        JFrame frame = new JFrame();
        
        JOptionPane.showMessageDialog(frame,
                                     "The remote location says: " + reply_code,
                                     "Error",
                                     JOptionPane.ERROR_MESSAGE);
    }
    
    public void PopulatePoiList(ArrayList<PlacesData> places_data, String reply_code)
    {
        if (reply_code.equals("OK")) {
            DefaultListModel list_model = new DefaultListModel();
            
            // dummy code because google returns places in distances > radius
            ArrayList<PlacesData> places_data_to_remove = new ArrayList<>();            
            for (PlacesData i : places_data) {                
                if (i.GetLatitude() != null && i.GetLongtitude() != null) {
                    Double distance = Haversine(i.GetLatitude(), 
                                                i.GetLongtitude(),
                                                GetLatitudeDouble(), 
                                                GetLongtitudeDouble());
                    
                    if (distance <= GetRadiosDouble()) {                
                        list_model.addElement(i.GetName());
                    } else {                        
                        places_data_to_remove.add(i);
                    }                    
                }                                                
            }
            
            for (PlacesData i : places_data_to_remove) {
                places_data.remove(i);
            }
            
            GetPoiList().setModel(list_model);
            
        } else {
            ErrorReplyWindow(reply_code);
        }
    }
    
    public void SetPoiListData(PlacesData places_data)
    {
        if (places_data != null) {
            if (places_data.GetRating() != null) {
                GetRating().setText(places_data.GetRating().toString());
            } else {
                GetRating().setText("No Rating");
            }

            if (places_data.GetAddress() != null) {
                GetAddress().setText(places_data.GetAddress());
            } else {
                GetAddress().setText("No Address");
            }

            if (places_data.GetLatitude() != null && places_data.GetLongtitude() != null) {
                Double distance = Haversine(places_data.GetLatitude(), 
                                            places_data.GetLongtitude(),
                                            GetLatitudeDouble(), 
                                            GetLongtitudeDouble());
                //System.out.println("distance " + distance);
                GetDistance().setText(distance.toString());

            } else {
                GetDistance().setText("No Distance");
            }
        }
    }
    
    public void ClearFields()
    {
        GetDistance().setText("");
        GetRating().setText("");
        GetAddress().setText("");
        GetImageLabel().setIcon(new ImageIcon());
    }
    
    private Double Haversine(double lat1, double lon1, double lat2, double lon2) {
        double _R = 6372.8;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
 
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return _R * c * 1000;
    }
    
    public void ShowImage(Image img)
    {
        if (img != null) {
            GetImageLabel().setIcon(new ImageIcon(img));
        }
    }
    
    public void ButtonActionListener(ActionListener listener)
    {
        GetButton().addActionListener(listener);
    }
    
    public void PoiListSelectionListener(ListSelectionListener listener)
    {
        GetPoiList().addListSelectionListener(listener);
    }
    
}
