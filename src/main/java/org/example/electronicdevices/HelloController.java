package org.example.electronicdevices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private ToggleGroup device;

    @FXML
    private RadioButton rbSmartphone;

    @FXML
    private RadioButton rbLaptop;

    @FXML
    private RadioButton rbTablet;

    @FXML
    private TextField textName;

    @FXML
    private TextField textPrice;

    @FXML
    private TextField textWeight;

    @FXML
    private Label label;

    @FXML
    private Label firstLabel;

    @FXML
    private Label secondLabel;

    @FXML
    private TextField textFirst;

    @FXML
    private TextField textSecond;

    @FXML
    private ListView<Device> listView;

    ObservableList<Device> devices = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listView.setItems(devices);
        device.selectedToggleProperty().addListener((observable, oldValue, newValue) -> updateAdditionalFields());
        updateAdditionalFields(); // Call to set the initial state
    }

    @FXML
    void onAddClick(ActionEvent event) {

        if (rbSmartphone.isSelected()) {
            Smartphone smartphone = new Smartphone();

            smartphone.setName(textName.getText());
            smartphone.setType(Devicetype.SMARTPHONE);
            smartphone.setPrice(Double.parseDouble(textPrice.getText()));
            smartphone.setWeight(Double.parseDouble(textWeight.getText()));
            smartphone.setScreenSize(Double.parseDouble(textFirst.getText()));
            smartphone.setResolution(Double.parseDouble(textSecond.getText()));

            devices.add(smartphone);
        } else if (rbLaptop.isSelected()) {
            Laptop laptop = new Laptop();

            laptop.setName(textName.getText());
            laptop.setType(Devicetype.LAPTOP);
            laptop.setPrice(Double.parseDouble(textPrice.getText()));
            laptop.setWeight(Double.parseDouble(textWeight.getText()));
            laptop.setRamSize(Integer.parseInt(textFirst.getText()));
            laptop.setProcessorType(textSecond.getText());

            devices.add(laptop);
        } else if (rbTablet.isSelected()) {
            Tablet tablet = new Tablet();

            tablet.setName(textName.getText());
            tablet.setType(Devicetype.TABLET);
            tablet.setPrice(Double.parseDouble(textPrice.getText()));
            tablet.setWeight(Double.parseDouble(textWeight.getText()));
            tablet.setBatteryLife(Double.parseDouble(textFirst.getText()));
            tablet.setHasStylus(Boolean.parseBoolean(textSecond.getText()));

            devices.add(tablet);
        }
        clearTextFields();
    }

    @FXML
    protected void onListClicked() {
        int id = listView.getSelectionModel().getSelectedIndex();
        if(id >= 0 ) {
            label.setText(devices.get(id).toString());
        }

    }

    @FXML
    private void onRemoveClick() {
        int id = listView.getSelectionModel().getSelectedIndex();
        if(id >= 0 ) {
            label.setText(devices.get(id).getName() + " is removed.");
            devices.remove(id);
        }
    }

    private void updateAdditionalFields() {
        if (rbSmartphone.isSelected()) {
            firstLabel.setText("Screen Size");
            secondLabel.setText("Camera Resolution");
            textFirst.setPromptText("Enter screen size (double)");
            textSecond.setPromptText("Enter camera resolution (double)");
        } else if (rbLaptop.isSelected()) {
            firstLabel.setText("RAM Size");
            secondLabel.setText("Processor Type");
            textFirst.setPromptText("Enter RAM size (int)");
            textSecond.setPromptText("Enter processor type (String)");
        } else if (rbTablet.isSelected()) {
            firstLabel.setText("Battery Life");
            secondLabel.setText("Has Stylus");
            textFirst.setPromptText("Enter battery life (double)");
            textSecond.setPromptText("Enter if has stylus (true/false)");
        }
    }

    private void clearTextFields() {
        textName.clear();
        textPrice.clear();
        textWeight.clear();
        textFirst.clear();
        textSecond.clear();
    }
}