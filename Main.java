import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(String name, String phone, String email) {
        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        System.out.println("Contact '" + name + "' added successfully!");
    }

    public void viewContacts() {
        System.out.println("\nContact List:");
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName() + ", Phone: " + contact.getPhone() + ", Email: " + contact.getEmail());
        }
    }

    public void editContact(String name) {
        Contact contactToEdit = findContact(name);
        if (contactToEdit != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter new phone number: ");
            String newPhone = scanner.nextLine();
            System.out.print("Enter new email address: ");
            String newEmail = scanner.nextLine();
            contactToEdit.setPhone(newPhone);
            contactToEdit.setEmail(newEmail);
            System.out.println("Contact '" + name + "' updated successfully!");
        } else {
            System.out.println("Contact '" + name + "' not found.");
        }
    }

    public void deleteContact(String name) {
        Contact contactToDelete = findContact(name);
        if (contactToDelete != null) {
            contacts.remove(contactToDelete);
            System.out.println("Contact '" + name + "' deleted successfully!");
        } else {
            System.out.println("Contact '" + name + "' not found.");
        }
    }

    private Contact findContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContact Manager Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String email = scanner.nextLine();
                    contactManager.addContact(name, phone, email);
                    break;

                case "2":
                    contactManager.viewContacts();
                    break;

                case "3":
                    System.out.print("Enter the name of the contact to edit: ");
                    String editName = scanner.nextLine();
                    contactManager.editContact(editName);
                    break;

                case "4":
                    System.out.print("Enter the name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    contactManager.deleteContact(deleteName);
                    break;

                case "5":
                    System.out.println("Exiting Contact Manager. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
