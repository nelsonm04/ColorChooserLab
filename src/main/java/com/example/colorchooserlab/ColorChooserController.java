package com.example.colorchooserlab;// Fig. 13.9: ColorChooserController.java
// Controller for the ColorChooser app
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

public class ColorChooserController {
    // instance variables for interacting with GUI components
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;

    // instance variables for managing
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;

    public void initialize() {
        redTextField.textProperty().bindBidirectional(redSlider.valueProperty(), new NumberStringConverter());
        greenTextField.textProperty().bindBidirectional(greenSlider.valueProperty(), new NumberStringConverter());
        blueTextField.textProperty().bindBidirectional(blueSlider.valueProperty(), new NumberStringConverter());
        alphaTextField.textProperty().bindBidirectional(alphaSlider.valueProperty(), new NumberStringConverter());

        redSlider.valueProperty().addListener((obs, oldVal, newVal) -> updateColor());
        greenSlider.valueProperty().addListener((obs, oldVal, newVal) -> updateColor());
        blueSlider.valueProperty().addListener((obs, oldVal, newVal) -> updateColor());
        alphaSlider.valueProperty().addListener((obs, oldVal, newVal) -> updateColor());
    }

    // Method to update the rectangle's color
    private void updateColor() {
        red = (int) redSlider.getValue();
        green = (int) greenSlider.getValue();
        blue = (int) blueSlider.getValue();
        alpha = alphaSlider.getValue();

        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
    }
}
