package application;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Admin {
	@FXML private Pane key_pane;
	@FXML private Pane admin_body;
	@FXML private PasswordField text_key;
	@FXML private JFXButton admin_signin;
	@FXML private Label status;
	public void show_Key_Pane(ActionEvent event)
	{
		if(text_key.getText().equals("admin"))
		{
			key_pane.setVisible(false);
			admin_body.setVisible(true);
		}
		else
		{
			status.setText("Status : Wrong Security Key. Please re-Enter...");
		}
	}
}
