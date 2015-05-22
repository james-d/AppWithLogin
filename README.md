# AppWithLogin
Basic example of a JavaFX Application with login and user-dependent data.

This example shows a login screen. When the user enters login details (for demonstration purposes, the only authentication 
requirement is that both username and password are non-empty), and presses "OK", a data screen is loaded, showing
user-dependent data (again, for this simple example, the data are just a collection of strings starting with the user name).
The data screen includes a logout button that returns the user to the login screen.

The application uses FXML files with corresponding controllers. The entry point is `Main.fxml`/`MainController`. `Main.fxml` is
structured with a `BorderPane` that uses an `fx:include` to place the content of `Login.fmxl` in the center. The controller for
`Login.fxml`, `LoginController` exposes a `ObjectProperty<User>` representing the currently-authenticated user (or `null` if
there is none). The `MainController` observes this property, and if it changes to a non-null value, loads the data view. If
it changes back to `null`, the login screen is displayed.

The controller for the data view similarly exposes a property representing the user. It observes this property and updates the
data if it changes to a non-null value. The logout button simply sets the user to `null`.

The main controller bidirectionally binds the user properties of the login controller and the data view controller. Thus setting
the user in the login controller will update the user in the data view, and similarly the logout facility in the data view will
reset the user property in the login controller.
