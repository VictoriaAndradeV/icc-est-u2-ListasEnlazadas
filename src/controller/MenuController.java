package controller;

import view.ConsoleView;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView consoleView;

    public MenuController(ContactManager contactManager, ConsoleView consoleView) {
        this.contactManager = contactManager;
        this.consoleView = consoleView;
    }

    public void showMenu() {
        int option;
        do {
            consoleView.printMenu();
            option = consoleView.readOption();

            switch (option) {
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
                    consoleView.printMessage("Saliendo del programa...");
                    break;
                default:
                    consoleView.printMessage("Opción inválida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    public void addContact() {
        String name = consoleView.readInput("Ingrese el nombre:");
        String phone = consoleView.readInput("Ingrese el número:");
        Contact<String, String> contact = new Contact<>(name, phone);
        contactManager.addContact(contact);
    }

    public void findContact() {
        String name = consoleView.readInput("Ingrese el nombre a buscar:");
        Contact<?, ?> contact = contactManager.findContactByName(name);
        if (contact != null) {
            consoleView.printMessage("Contacto encontrado: " + contact);
        } else {
            consoleView.printMessage("Contacto no encontrado.");
        }
    }

    public void deleteContact() {
        String name = consoleView.readInput("Ingrese el nombre a eliminar:");
        contactManager.deleteContactByName(name);
        consoleView.printMessage("Contacto eliminado si existía.");
    }

    public void printList() {
        contactManager.printList();
    }
}