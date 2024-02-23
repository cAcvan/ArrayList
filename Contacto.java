public class Contacto {
    private String name, phoneNumber;

    public Contacto(String name, String phoneNumber){
        this.name=name;
        this.phoneNumber=phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static  Contacto createContact(String name, String phoneNumber){
        Contacto c = new Contacto(name, phoneNumber);
        return c;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
