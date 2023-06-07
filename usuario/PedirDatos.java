package usuario;

import control.Cliente;
import control.Producto;

import java.util.Scanner;

public class PedirDatos {

    // Metodo que te pide el nombre del producto para insertar, modificar o eliminar en la base de datos
    public static Producto pedirProducto(){

        Scanner lector = new Scanner(System.in);
        Producto miProducto = new Producto();

        try {
            System.out.println("Ingresa el nombre del producto");
            miProducto.setNombre(lector.nextLine());
        }catch (Exception e){
            System.out.println("ERROR al ingresar el producto");

            lector.close();
        }
        return miProducto;
    }

    // Metodo que te pide el nombre del producto para insertar, modificar o eliminar en la base de datos
    public static Cliente pedirCliente(){

        Scanner lector = new Scanner(System.in);
        Cliente miCliente = new Cliente();

        try {
            System.out.println("Ingresa el nombre del cliente");
            miCliente.setNombre(lector.nextLine());
        }catch (Exception e){
            System.out.println("ERROR al ingresar el cliente");

            lector.close();
        }
        return miCliente;
    }

    // Metodo que te pide el id del cliente para modificar en la base de datos y te pide el nombre nuevo
    public static Cliente modificarCliente() {

        Scanner lector = new Scanner(System.in);

        Cliente miCliente = new Cliente();

        try {
            System.out.println("Ingresa el id del cliente que quieres modificar");
            miCliente.setId(lector.nextInt());
            lector.nextLine();
            System.out.println("Ingresa el nombre del cliente nuevo");
            miCliente.setNombre(lector.nextLine());
        } catch (Exception e) {
            System.out.println("ERROR al ingresar el cliente");

            lector.close();
        }
        return miCliente;
    }

    // Metodo que te pide el id del producto para modificar en la base de datos y te pide el nombre nuevo
    public static Producto modificarProducto() {

        Scanner lector = new Scanner(System.in);

        Producto miProducto = new Producto();

        try {
            System.out.println("Ingresa el id del producto que quieres modificar");
            miProducto.setId(lector.nextInt());
            lector.nextLine();
            System.out.println("Ingresa el nombre del producto nuevo");
            miProducto.setNombre(lector.nextLine());
        } catch (Exception e) {
            System.out.println("ERROR al ingresar el producto");

            lector.close();
        }
        return miProducto;
    }

    // Metodo que te pide el id del producto para insertar en la tabla que asocia al cliente con el producto
    public static Producto idProducto() {

        Scanner lector = new Scanner(System.in);

        Producto miProducto = new Producto();

        try {
            System.out.println("Ingresa el id del producto que quieres añadir");
            miProducto.setId(lector.nextInt());
            lector.nextLine();
        } catch (Exception e) {
            System.out.println("ERROR al ingresar el producto");

            lector.close();
        }
        return miProducto;
    }

    // Metodo que te pide el id del producto para insertar en la tabla que asocia al producto con el cliente
    public static Cliente idCliente() {

        Scanner lector = new Scanner(System.in);

        Cliente miCliente = new Cliente();

        try {
            System.out.println("Ingresa el id del cliente al que le quieres añadir el producto");
            miCliente.setId(lector.nextInt());
            lector.nextLine();
        } catch (Exception e) {
            System.out.println("ERROR al ingresar el producto");

            lector.close();
        }
        return miCliente;
    }

}
