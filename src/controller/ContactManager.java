package controller;

import model.Contact;
import model.LinkedList;
import model.NodeGeneric;

public class ContactManager {
    private LinkedList<Contact> contacts;

    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    public void addContact(Contact contact) {
        contacts.appendToTail(contact);
    }

    public Contact findContactByName(String name) {
        NodeGeneric<Contact> current = contacts.getHead();
        while (current != null) {
            if (current.getData().getName().equals(name)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public void deleteContactByName(String name) {
        NodeGeneric<Contact> current = contacts.getHead();
        NodeGeneric<Contact> prev = null;

        while (current != null) {
            if (current.getData().getName().equals(name)) {
                if (prev == null) {
                    contacts.setHead(current.getNext());
                } else {
                    prev.setNext(current.getNext());
                }
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    public void printList() {
        contacts.print();
    }
}