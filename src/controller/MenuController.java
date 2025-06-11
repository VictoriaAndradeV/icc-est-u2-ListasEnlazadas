package controller;

import model.Contact;
import view.ConsoleView;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView consoleView;

    public MenuController() {
        this.contactManager = new ContactManager();
        this.consoleView = new ConsoleView();
    }

    public void showMenu() {
        int opcion;
        do {
            consoleView.displayMenu();
            opcion = Integer.parseInt(consoleView.getInput(""));

            switch (opcion) {
                case 1:
                    addContact();
                    break;
                case 2:
                    findContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    printList();
                    break;
                case 5:
                    consoleView.showMessage("Saliendo del sistema...");
                    break;
                default:
                    consoleView.showMessage("Opción no válida");
            }
        } while (opcion != 5);
    }

    //administra el menu
    private void addContact() {
        String name = consoleView.getInput("Ingrese el nombre: ");
        String phone = consoleView.getInput("Ingrese el teléfono: ");

        Contact<String, String> contact = new Contact<>(name, phone);
        contactManager.addContact(contact);
        consoleView.showMessage("Contacto agregado ");
    }

    private void findContact() {
        String name = consoleView.getInput("Ingrese el nombre a buscar: ");
        Contact<?, ?> contact = contactManager.findContactByName(name);
        if (contact != null) {
            consoleView.showMessage("Contacto encontrado: " + contact);
        } else {
            consoleView.showMessage("Contacto NO encontrado");
        }
    }

    private void deleteContact() {
        String name = consoleView.getInput("Ingrese el nombre a eliminar: ");
        contactManager.deleteContactByName(name);
        consoleView.showMessage("Contacto eliminado ");
    }

    private void printList() {
        consoleView.showMessage("\n--- Lista de Contactos ---");
        contactManager.printList();
    }
}