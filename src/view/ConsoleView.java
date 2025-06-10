package view;
import model.Contact;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public int displayMenu(){
        System.out.println("--------- Menu --------- ");
        System.out.println("1. Agregar Persona");
        System.out.println("2. Buscar persona");
        System.out.println("3. Eliminar contacto de la lista");
        System.out.println("4. Salir");
        int opcion = validarOpcion(scanner, 1, 4); //metodo que valida la entrada de numeros en el rango 1-5
        return opcion;                                     //valida el ingreso de numeros, no permite ingresar letras o caracteres especiales
    }

    public Contact inputPerson(){
        System.out.println("Ingrese los siguientes datos: ");
        String name = validarIngresoNombre(scanner); 
        int age = validarIngresoEdad(scanner);
        return new Contact(name, age); 
    }

     //inputAge sirve para ingresar la edad a buscar 
    public int inputPhone(){
        System.out.println("Ingrese la edad que desea buscar -->");
        int edad = scanner.nextInt(); //valida el ingreso de numeros 
        return edad;
    }
    //ingresamos el nombre que se desea buscar
    public String inputName(){
        System.out.println("Ingrese el Nombre que desea buscar -->");
        String nombre = validarIngresoNombre(scanner);
        return nombre;
    }

    public int validarOpcion(Scanner scanner, int min, int max){
        int num;                                                 

        do { 
            System.out.println("Ingrese una opcion: ");

            if(scanner.hasNextInt()){ //validar ingreso de numeros
                num = scanner.nextInt(); 
                scanner.nextLine(); //limpia el buffer de entrada del Scanner

                if((num < min) || (num > max)){ //condición cuando se ingresa un valor fuera de los mostrados en el menú
                    System.out.println("Ingrese una opcion valida desde -> " +min+" hasta " +max);
                }else{
                    return num;
                }
            } else{
                System.out.println("Ingrese unicamente numeros, NO letras NI caracteres especiales");
                scanner.nextLine(); //limpiar token invalido ingresado, para evitar que scanner se trabe 
            }   
        } while (true); //se cumple infinitamente hasta que se ingrese una opcion valida
    }

    public String validarIngresoNombre(Scanner scanner){
        String nombre;

        do { 
            System.out.println("Nombre --> ");
            nombre = scanner.nextLine().trim(); //acepta el ingreso de nombres con espacios

            if(nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")){ //valida el ingreso de un string valido, con letras de todo el alfabeto
                return nombre;                                 //valida tildes, Ñ - ñ
            } else {
                System.out.println("Ingrese unicamente letras, no numeros, no caracteres especiales");
            }
        } while (true);//se cumple infinitamente hasta que se ingrese una cadena de caracteres válida
    }

    /*
     * Validar el ingreso de edad, para asignar valores a persons y para
     * ingresar la edad que se desea buscar 
     * Valida un rango de edad con 0, cuando la persona tiene meses de edad, hasta 110 anios
     */
    public int validarIngresoEdad(Scanner scanner){
        int edad;

        do { 
            System.out.println("Edad --> ");

            if(scanner.hasNextInt()){ //valida el ingreso de numeros
                edad = scanner.nextInt();

                if((edad < 0) || (edad > 110)){ //ingresa al if si la edad ingresada esta fuera del rango
                    System.out.println("Ingrese un rango de edad desde 0(si aun no ha cumplido un año) hasta 110");
                    scanner.nextLine(); 
                }else{
                    return edad;
                }
            } else{
                System.out.println("Ingrese unicamente numeros, no letras ni caracteres especiales");
                scanner.nextLine(); //limpiar token invalido ingresado, para evitar que scanner se trabe 
            }   
        } while (true);
    }
}
