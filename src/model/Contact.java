package model;

public class Contact {
    private String name;
    private String phone;

    public Contact(){

    }
    
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact [name=" + name + ", phone=" + phone + "]";
    }

    public boolean equals(Object obj){
        if(obj == null) return false;
        if(this == obj) return true; //this es la clase una vez instanseada 
        if(obj == null || getClass() != obj.getClass()){// si contacto es diferente de la clase persona, retorna falso
            return false;
        }

        //aqui obj y this son clase contacto
        Contact c = (Contact) obj; //casting 
        //c.phone; //ahora puedo acceder a las variables que tengo en la clase contacto
        return name != null && name.equals(c.getName());
    }
    

}
