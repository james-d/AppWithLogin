package application;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class DataViewController {
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
    private ListView<String> dataView ;
    
    public void initialize() {
        user.addListener((obs, oldUser, newUser) -> populateDataView(newUser));
    }
    
    @FXML
    private void logout() {
        user.set(null);
    }
    
    private void populateDataView(User user) {
        dataView.getItems().clear();
        if (user == null) {
            return ;
        } 
        
        // In real life, execute query on database dependent on user, etc...
        for (int i = 1 ; i <= 20; i++) {    
            dataView.getItems().add(user.getUserName() + " item "+i);
        }
    }
}
