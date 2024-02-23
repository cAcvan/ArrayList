import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelefonoMovil {
    private String myNumber;
    private List<Contacto> myContacts;
    private boolean flag=false;

    public TelefonoMovil(String myNumber){
        this.myNumber=myNumber;
        myContacts = new ArrayList<Contacto>();
    }

    private int findContact(Contacto c){
        int index=-1;
        for(int i=0;i<myContacts.size();i++) {
            if (myContacts.get(i).equals(c)) {
                index = i;
            }
        }
        return index;
    }


    private int findContact(String name){
        int index = -1;
        for(int i=0;i<myContacts.size();i++){
            if(myContacts.get(i).getName().equals(name)){
                index = i;
            }
        }
        return index;
    }

    public boolean addNewContact(Contacto c,TelefonoMovil t){
        if(t.findContact(c)!=-1)
            return false;
        else{
            myContacts.add(c);
            return true;
        }
    }

    public boolean updateContact(Contacto a, Contacto b){
        if(a!=b){
            myContacts.set(myContacts.indexOf(a),b);
            return true;
        }else
            return false;
    }

    public boolean removeContact(Contacto c, TelefonoMovil t){
        if(t.findContact(c)!=-1){
            myContacts.remove(c);
            return true;
        }else
            return false;
    }

    public Contacto queryContact(String name, TelefonoMovil t){
        if(t.findContact(name)!=-1){
            return myContacts.get(t.findContact(name));
        }else
            return null;
    }

    public void printContacts(){
        System.out.println("Lista de contactos:");
        int cont=1;
        for(Contacto c : myContacts){
            System.out.println(cont + "." + c.getName() + " -> " + c.getPhoneNumber() + '.');
            cont++;
        }
    }

    public static void menu(){
        System.out.println("----------MENU----------");
        System.out.println("0.Salir.");
        System.out.println("1.Imprimir contactos.");
        System.out.println("2.Agregar contactos.");
        System.out.println("3.Actualizar contacto.");
        System.out.println("4.Eliminar contacto.");
        System.out.println("5.Buscar contacto.");
        System.out.println("6.Volver a imprimir la lista de opciones.");
    }

    public void opciones(int opcion, String numero, TelefonoMovil t){
        Scanner sc = new Scanner(System.in);

        String name, phoneNumber;

        switch (opcion){
            case 0:
                System.out.println("Adiós.");
                    break;
            case 1:
                if(!flag){
                    System.out.println("No hay contactos.");
                }else{
                    t.printContacts();
                }
                    break;
            case 2:
                System.out.println("Ahora añadirás un nuevo contacto.");
                System.out.println("Ingresa el nombre del contacto:");
                name = sc.next();
                if(t.findContact(name)!=-1){
                    System.out.println("No se ha añadido el contacto " + name + " porque ya existe.");
                }else{
                    System.out.println("Ingresa el núemero de teléfono:");
                    phoneNumber = sc.next();
                    if(phoneNumber.length()!=9){
                        System.out.println("Número de teléfono no válido.");
                    }else{
                        Contacto c = new Contacto(name,phoneNumber);
                        t.addNewContact(c,t);
                        System.out.println("Se ha añadido un contacto.");
                        flag=true;
                    }
                }
                    break;
            case 3:
                if(flag){
                    System.out.println("Ahora actualizarás un contacto.");
                    System.out.println("Ingresa el contacto ya existente: Nombre");
                    name = sc.next();
                    if(t.findContact(name)!=-1){
                        Contacto a = t.queryContact(name,t);
                        System.out.println("Ahora vas a ingresar el nuevo contacto.");
                        System.out.println("Ingresa el nombre:");
                        String newName = sc.next();
                        if(t.findContact(newName)!=-1){
                            System.out.println("No se ha añadido el contacto " + newName + " porque ya existe.");
                        }else {
                            System.out.println("Teléfono:");
                            String newPhoneNumber = sc.next();
                            if (newPhoneNumber.length() != 9) {
                                System.out.println("Núemro de teléfono no válido.");
                            } else {
                                Contacto b = new Contacto(newName, newPhoneNumber);
                                t.updateContact(a, b);
                            }
                        }
                    }else{
                        System.out.println("No se ha añadido el contacto " + name + " porque ya existe.");
                    }
                }else
                    System.out.println("No hay contactos.");
                        break;
            case 4:
                if(flag){
                    System.out.println("Ahora vas a eliminar un contacto.");
                    System.out.println("Ingresa el nombre del contacto:");
                    name = sc.next();
                    Contacto a = queryContact(name,t);
                    t.removeContact(a,t);
                }else
                    System.out.println("No hay contactos.");
                        break;
            case 5:
                if(flag){
                    System.out.println("Ahora vas a buscar un contacto.");
                    System.out.println("Ingresa el nombre del contacto que quieres buscar: ");
                    name = sc.next();
                    Contacto a = t.queryContact(name,t);
                    if(a!=null)
                        System.out.println("Contacto: " + a.getName() + "->" + a.getPhoneNumber());
                    else
                        System.out.println("No existe el contacto " + name);
                }else
                    System.out.println("No hay contactos.");
                        break;
            case 6:
                TelefonoMovil.menu();
                    break;
            default:
                System.out.println("Esa opción no está disponible.");
        }
    }
}
