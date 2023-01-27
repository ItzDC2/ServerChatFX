package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import iesdomingoperezminik.es.Cliente;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ServerChatController implements Initializable {

	//model
	private ListProperty<String> clientes = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<String> mensajes = new SimpleListProperty<>(FXCollections.observableArrayList());
	
    @FXML
    private TextArea chatArea;

    @FXML
    private ListView<String> clientesList;

    @FXML
    private TextField inputField;

    @FXML
    private BorderPane view;

	
	public ServerChatController() {
		FXMLLoader loader  = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
		loader.setController(this); 
		try {
			loader.load();
		} catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		clientesList.itemsProperty().bind(clientes);
	}
	
	public BorderPane getView() {
		return view;
	}
	
}
