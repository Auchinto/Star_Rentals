package application;


import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.sqlite.SQLiteException;

import com.jfoenix.controls.*;

import javafx.event.*;
import javafx.fxml.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SampleController {
	    @FXML 		private AnchorPane basepane; 
	    @FXML	    private ImageView applogin;
	    @FXML	    private ImageView aboutus;
	    @FXML	    private ImageView contactus;
	    @FXML	    private ImageView storeGallery;
	    @FXML	    private TabPane log_tab;
	    @FXML	    private Pane pane_abt_us;
	    @FXML	    private Pane pane_con_us;
	    @FXML	    private Pane pane_gal;
	    @FXML 		private TextField admin_username;
	    @FXML		private PasswordField admin_password;
	    @FXML 		private TextField customer_username;
	    @FXML		private PasswordField customer_password;
	    @FXML		private Label status;
	    @FXML		private TextField email;
	    @FXML		private TextField pref_username;
	    @FXML		private PasswordField pref_password;
	    @FXML		private StackPane stackPane;
	    @FXML		private JFXToggleButton toggle_admin;
	    public LoginModel lm = new LoginModel();
	    
	    Image log_hover = new Image("/application/appLOGIN_hover.png");
		Image log_press = new Image("/application/appLOGIN_press.png");
		Image log_release = new Image("/application/appLOGIN.png");
		public void mouseEnter_login()
		{
			applogin.setImage(log_hover);
			
		}
		public void mousePress_login()
		{
			applogin.setImage(log_press);
			log_tab.setVisible(true);
			pane_abt_us.setVisible(false);
			pane_con_us.setVisible(false);
			pane_gal.setVisible(false);

		}
		public void mouseRelease_login()
		{
			applogin.setImage(log_release);
			
		}
		
		Image ab_hover = new Image("/application/aboutUS_hover.png");
		Image ab_press = new Image("/application/aboutUS_press.png");
		Image ab_release = new Image("/application/aboutUS.png");
		public void mouseEnter_ab()
		{
			aboutus.setImage(ab_hover);
		}
		public void mousePress_ab()
		{
			aboutus.setImage(ab_press);
			log_tab.setVisible(false);
			pane_abt_us.setVisible(true);
			pane_con_us.setVisible(false);
			pane_gal.setVisible(false);

		}
		public void mouseRelease_ab()
		{
			aboutus.setImage(ab_release);
			
		}
		
		Image con_hover = new Image("/application/contactUS_hover.png");
		Image con_press = new Image("/application/contactUS_press.png");
		Image con_release = new Image("/application/contactUS.png");
		public void mouseEnter_con()
		{
			contactus.setImage(con_hover);
		}
		public void mousePress_con()
		{
			contactus.setImage(con_press);
			log_tab.setVisible(false);
			pane_abt_us.setVisible(false);
			pane_con_us.setVisible(true);
			pane_gal.setVisible(false);

		}
		public void mouseRelease_con()
		{
			contactus.setImage(con_release);
		}
		
		Image gal_hover = new Image("/application/storeGallery_hover.png");
		Image gal_press = new Image("/application/storeGallery_press.png");
		Image gal_release = new Image("/application/storeGallery.png");
		public void mouseEnter_gal()
		{
			storeGallery.setImage(gal_hover);
		}
		public void mousePress_gal()
		{
			storeGallery.setImage(gal_press);
			log_tab.setVisible(false);
			pane_abt_us.setVisible(false);
			pane_con_us.setVisible(false);
			pane_gal.setVisible(true);

		}
		public void mouseRelease_gal()
		{
			storeGallery.setImage(gal_release);
		}
	   
		public void Login_Admin(ActionEvent event) throws IOException
		{
			try {
				if((!admin_username.getText().equals(""))&&(!admin_password.getText().equals("")))
				{	
					if(lm.isLoginAdmin(admin_username.getText(), admin_password.getText()))
					{			
						AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Admin.fxml"));
						basepane.getChildren().setAll(pane);
					}
					else
					{
						status.setText("Exception : Username or Password - incorrect");
					}
				}
				else
				{
					status.setText("Exception : Username or Password field - empty");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//status.setText("Either Username or Password is incorrect");
				//e.printStackTrace();
				String to_be_replaced_1 = "C";
				String to_be_replaced_2 = "]";
				String replaced_with = "'";
				String replaced_with_2 = "}";
				String input = e.toString();
				Pattern pattern = Pattern.compile(to_be_replaced_1);
				Matcher matcher = pattern.matcher(input);
				input = matcher.replaceAll(replaced_with);
				System.out.println(input);
				pattern = Pattern.compile(to_be_replaced_2);
				matcher = pattern.matcher(input);
				input = matcher.replaceAll(replaced_with_2);
				System.out.println(input);
				
				pattern = Pattern.compile("'(.*?)}");
				matcher = pattern.matcher(input);
				
				if(matcher.find())
				{	status.setText("Exception : SQLITE_C"+matcher.group(1));
					System.out.print("Exception : SQLITE_C"+matcher.group(1)); 
				}
			}
		}
		
		public void Login_Customer(ActionEvent event) throws IOException
		{
			try {
				if((!customer_username.getText().equals(""))&&(!customer_password.getText().equals("")))
				{	
					if(lm.isLoginCustomer(customer_username.getText(), customer_password.getText()))
					{
						AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Customer.fxml"));
						basepane.getChildren().setAll(pane);
					}
					else
					{
						status.setText("Exception : Username or Password - incorrect");
					}
				}
				else
				{
					status.setText("Exception : Username or Password field - empty");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//status.setText("Either Username or Password is incorrect");
				//e.printStackTrace();
				
				String to_be_replaced_1 = "C";
				String to_be_replaced_2 = "]";
				String replaced_with = "'";
				String replaced_with_2 = "}";
				String input = e.toString();
				Pattern pattern = Pattern.compile(to_be_replaced_1);
				Matcher matcher = pattern.matcher(input);
				input = matcher.replaceAll(replaced_with);
				System.out.println(input);
				pattern = Pattern.compile(to_be_replaced_2);
				matcher = pattern.matcher(input);
				input = matcher.replaceAll(replaced_with_2);
				System.out.println(input);
				
				pattern = Pattern.compile("'(.*?)}");
				matcher = pattern.matcher(input);
				
				if(matcher.find())
				{	status.setText("Exception : SQLITE_C"+matcher.group(1));
					System.out.print("Exception : SQLITE_C"+matcher.group(1)); 
				}
			}
		}
		
		public void loadDialog(String title, String message)
		{
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle(title);
			window.setMinWidth(250);
			window.setMinHeight(100);
			Label lbl = new Label();
			lbl.setText(message);
			
			Button closeButton = new Button("Continue");
			closeButton.setOnAction(e -> window.close());
			
			VBox layout = new VBox();
			layout.getChildren().addAll(lbl, closeButton);
			layout.setAlignment(Pos.CENTER);
			
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		}
		
		public void Sign_Up(ActionEvent event) throws IOException
		{
			try 
			{
				lm.Register(email.getText(), pref_username.getText(), pref_password.getText(), toggle_admin.isSelected());	
				loadDialog("Register Status","You have been successfully registered.");
				AnchorPane pane = null;
				if(toggle_admin.isSelected()) 
				{	
					pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Admin.fxml"));
				}
				else pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Customer.fxml"));
				basepane.getChildren().setAll(pane);
			} catch (SQLiteException e) {
				// TODO Auto-generated catch block
				System.out.print(e);
				
				String to_be_replaced_1 = "C";
				String to_be_replaced_2 = "]";
				String replaced_with = "'";
				String replaced_with_2 = "}";
				String input = e.toString();
				Pattern pattern = Pattern.compile(to_be_replaced_1);
				Matcher matcher = pattern.matcher(input);
				input = matcher.replaceAll(replaced_with);
				System.out.println(input);
				pattern = Pattern.compile(to_be_replaced_2);
				matcher = pattern.matcher(input);
				input = matcher.replaceAll(replaced_with_2);
				System.out.println(input);
				
				pattern = Pattern.compile("'(.*?)}");
				matcher = pattern.matcher(input);
				
				if(matcher.find())
				{	status.setText("Exception : SQLITE_C"+matcher.group(1));
					System.out.print("Exception : SQLITE_C"+matcher.group(1)); 
				}
				
			}catch(SQLException e)
			{
				
			}
		}
		
		
}
