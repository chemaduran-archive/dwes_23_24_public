package _4_di._3_di_interface;

// Esta clase nos sirve para crear "clientes" con
// las dependencias ya creadas del "servicio".

// Si quiero crear nuevos servicios o modificarlos,
// solamente tengo que modificar esta clase

public class ServiceInjector {
    public Client getClient() {
//        Service servicio = new ServiceFoo("foo");
        Service servicio = new ServiceBar("bar");
        return new Client(servicio);
    }
}
