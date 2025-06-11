import model.Contact;

public class App {
    public static void main(String[] args) throws Exception {
        controller.MenuController menuController = new controller.MenuController();
        menuController.showMenu();

        Contact c1 = new Contact("Juan", "123");
        Contact c4 = new Contact("Juan");
    }
}
