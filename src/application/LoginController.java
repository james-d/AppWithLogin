package application;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private final ObjectProperty<User> user = new SimpleObjectProperty<>();

    public final ObjectProperty<User> userProperty() {
        return this.user;
    }

    public final application.User getUser() {
        return this.userProperty().get();
    }

    public final void setUser(final application.User user) {
        this.userProperty().set(user);
    }
    
    @FXML
    private TextField userNameField ;
    @FXML
    private PasswordField passwordField ;
    
    @FXML
    private Label errorLabel ;
    
    @FXML
    private void ok() {
        String userName = userNameField.getText();
        String password = passwordField.getText();
        if (authenticate(userName, password)) {
            setUser(new User(userName));
            errorLabel.setText("");
        } else {
            errorLabel.setText("Incorrect login details");
        }
        clearFields();
    }
    
    @FXML
    private void cancel() {
        setUser(null);
        clearFields();
        errorLabel.setText("");
    }
    
    private boolean authenticate(String userName, String password) {
        // in real life, do real authentication...
        if (userName.isEmpty() || password.isEmpty()) {
            return false ;
        }
        return true ;
    }
    
    private void clearFields() {
        userNameField.setText("");
        passwordField.setText("");
    }
}
