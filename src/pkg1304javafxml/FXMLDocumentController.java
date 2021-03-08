/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1304javafxml;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Gergö Szijarto
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private TextField textFieldToConvert;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Button btnConvert;
    @FXML
    private Button btnBits;
    @FXML
    private Button btnBytes;
    @FXML
    private Button btdKilobytes;
    @FXML
    private Button btnMegabytes;
    @FXML
    private Button btnGigabytes;
    @FXML
    private Button btnTerabytes;
    @FXML
    private Label lblUnit;
    @FXML
    private Label lblConvertUnit;
    @FXML
    private MenuItem menuExit;

    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Label lblResult;
    @FXML
    private MenuItem menuReset;

    private String unitResult;
    @FXML
    private TextField textFieldResult;
    @FXML
    private Menu menubarHelp;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox.getItems().addAll(
                "bit",
                "B",
                "KB",
                "MB",
                "GB",
                "TB");
    }

    @FXML
    private void handleButtonConvert(ActionEvent event) {
        lblResult.setText(unitResult);
        if (lblUnit.getText() == null) {
            JOptionPane.showMessageDialog(null,
                    "Please choose a Unit you want to convert your number to!",
                    "Warning!",
                    JOptionPane.WARNING_MESSAGE);
        }

        if (lblConvertUnit.getText() == null && textFieldToConvert.getLength() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Please choose a unit for your value!",
                    "Warning!",
                    JOptionPane.WARNING_MESSAGE);
        }
        /*
        if (textFieldToConvert.getLength() > 0 && lblConvertUnit.getText() == "") {
            System.out.println("idk");
        } */

        convert();
    }

    @FXML
    private void handleButtonBits(ActionEvent event) {
        lblConvertUnit.setText(comboBox.getValue());
        lblUnit.setText("Bits");
        unitResult = "bit";
    }

    @FXML
    private void handleButtonBytes(ActionEvent event) {
        lblConvertUnit.setText(comboBox.getValue());
        lblUnit.setText("Bytes");
        unitResult = "B";
    }

    @FXML
    private void handleButtonKilobytes(ActionEvent event) {
        lblConvertUnit.setText(comboBox.getValue());
        lblUnit.setText("Kilobytes");
        unitResult = "KB";
    }

    @FXML
    private void handleButtonMegabytes(ActionEvent event) {
        lblConvertUnit.setText(comboBox.getValue());
        lblUnit.setText("Megabytes");
        unitResult = "MB";
    }

    @FXML
    private void handleButtonGigabytes(ActionEvent event) {
        lblConvertUnit.setText(comboBox.getValue());
        lblUnit.setText("Gigabytes");
        unitResult = "GB";
    }

    @FXML
    private void handleButtonTerabytes(ActionEvent event) {
        lblConvertUnit.setText(comboBox.getValue());
        lblUnit.setText("Terabytes");
        unitResult = "TB";
    }

    @FXML
    private void fileExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void writeComboBoxValueOnLabel(ActionEvent event) {
        lblConvertUnit.setText(comboBox.getValue());
    }

    @FXML
    private void fileReset(ActionEvent event) {
        lblConvertUnit.setText("");
        lblResult.setText("");
        lblUnit.setText("");
        textFieldToConvert.setText("");
        comboBox.setValue("");
        textFieldResult.setText("");
    }

    private void convert() {
        String convertFromString = lblConvertUnit.getText();
        String convertToString = lblUnit.getText();
        String value = textFieldToConvert.getText();
        double d = 0;
        double finalValue = 0;

        try {
            d = Double.parseDouble(value);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Please enter a number you want to convert!",
                    "Warning!",
                    JOptionPane.WARNING_MESSAGE);

        }

        switch (convertFromString) {
            case "bit": // convert  from bit
                switch (convertToString) {
                    case "Bytes":
                        finalValue = d / 8;
                        break;
                    case "Kilobytes":
                        finalValue = d / 800;
                        break;
                    case "Megabytes":
                        finalValue = d / 8000000;
                        break;
                    case "Gigabytes":
                        error();
                        break;
                    case "Terabytes":
                        error();
                        break;
                    default:
                        finalValue = d;
                        break;
                }
                break;
            case "B": // convert from byte
                switch (convertToString) {
                    case "Bits":
                        finalValue = d * 8;
                        break;
                    case "Kilobytes":
                        finalValue = d / 100;
                        break;
                    case "Megabytes":
                        finalValue = d / 1000000;
                        break;
                    case "Gigabytes":
                        finalValue = d / 1000000000;
                        break;
                    case "Terabytes":
                        error();
                        break;
                    default:
                        finalValue = d;
                        break;
                }

                break;
            case "KB": // convert from kilobyte
                switch (convertToString) {
                    case "Bits":
                        finalValue = d * 8000;
                        break;
                    case "Bytes":
                        finalValue = d * 1000;
                        break;
                    case "Megabytes":
                        finalValue = d / 1000;
                        break;
                    case "Gigabytes":
                        finalValue = d / 1000000;
                        break;
                    case "Terabytes":
                        finalValue = d / 1000000000;
                        break;
                    default:
                        finalValue = d;
                        break;
                }
                break;

            case "MB": // convert from megabyte
                switch (convertToString) {
                    case "Bits":
                        finalValue = d * 8000000;
                        break;
                    case "Bytes":
                        finalValue = d * 1000000;
                        break;
                    case "Kilobytes":
                        finalValue = d * 1000;
                        break;
                    case "Gigabytes":
                        finalValue = d / 1000;
                        break;
                    case "Terabytes":
                        finalValue = d / 1000000;
                        break;
                    default:
                        finalValue = d;
                        break;
                }
                break;

            case "GB": // convert from gigabyte
                switch (convertToString) {
                    case "Bits":
                        error();
                        break;
                    case "Bytes":
                        finalValue = d * 1000000000;
                        break;
                    case "Kilobytes":
                        finalValue = d * 1000000;
                        break;
                    case "Megabytes":
                        finalValue = d * 1000;
                        break;
                    case "Terabytes":
                        finalValue = d / 1000;
                        break;
                    default:
                        finalValue = d;
                        break;
                }
                break;
            case "TB": // convert from terabyte
                switch (convertToString) {
                    case "Bits":
                        error();
                        break;
                    case "Bytes":
                        error();
                        break;
                    case "Kilobytes":
                        finalValue = d * 1000000000;
                        break;
                    case "Megabytes":
                        finalValue = d * 1000000;
                        break;
                    case "Gigabytes":
                        finalValue = d * 1000;
                        break;
                    default:
                        finalValue = d;
                        break;
                }
                break;
        }

        String resultString = String.valueOf(finalValue);
        textFieldResult.setText(resultString);
    }

    private void error() {
        textFieldResult.setText("");
        JOptionPane.showMessageDialog(null,
                "This conversion could not be executed.",
                "Warning!",
                JOptionPane.WARNING_MESSAGE);
    }

    @FXML
    private void helpClicked(ActionEvent event) throws IOException {
        showPage("Help");
    }

    private void showPage(String pageNameString) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("FXML" + pageNameString + ".fxml"));
        Parent root1 = (Parent) fXMLLoader.load();
        Stage stage = new Stage();
        stage.setTitle(pageNameString);
        stage.setScene(new Scene(root1));
        stage.show();
    }

}
