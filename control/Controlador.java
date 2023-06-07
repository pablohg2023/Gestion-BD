package control;
import datos.Consultas;
import datos.Eliminar;
import datos.Insertar;
import datos.Update;
import usuario.PedirDatos;

import java.util.Scanner;

public class Controlador {

    public static void main(String[] args) {

        Scanner lector= new Scanner(System.in);

        int numero = 0;
        Producto miProducto;
        Cliente miCliente;
        ProductoCliente miProductoCliente;
        char continuar;
        String sql = "";
        int conexion = 0;
        String tabla = "";
        
        do {
            System.out.println("Elige la sentencia que quieres realizar");
            System.out.println("1.Insertar clientes");
            System.out.println("2.Insertar productos asociado a clientes");
            System.out.println("3.Borrar producto");
            System.out.println("4.Modificar");
            System.out.println("5.Asociar productos a clientes");
            System.out.println("6.Dar producto y enseñar clientes");
            System.out.println("7.Dar cliente y te da productos del cliente");
            System.out.println("8.Total de clientes");
            System.out.println("9.Producto mas comprado");
            System.out.println("10.Cliente sin producto");
            numero = lector.nextInt();
            lector.nextLine();

            switch(numero) {
                case 1:
                    miCliente = PedirDatos.pedirCliente();
                    sql = Insertar.insertarCliente(miCliente);
                    conexion = Conexion.insertarBD(sql);
                    System.out.println("Han cambiado " + conexion + " filas");
                    break;
                case 2:
                    miProducto = PedirDatos.pedirProducto();
                    sql = Insertar.insertarProducto(miProducto);
                    conexion = Conexion.insertarBD(sql);
                    tabla = Consultas.mostrarProducto();
                    miProducto = PedirDatos.idProducto();
                    tabla = Consultas.mostrarCliente();
                    miCliente = PedirDatos.idCliente();
                    sql = Insertar.insertarClienteProducto(miCliente,miProducto);
                    conexion = Conexion.insertarBD(sql);
                    break;
                case 3:
                    miProducto = PedirDatos.pedirProducto();
                    sql = Eliminar.eliminarProducto(miProducto);
                    conexion = Conexion.insertarBD(sql);
                    break;
                case 4:
                    System.out.println("Que tabla quieres actualizar:");
                    System.out.println("1. Clientes");
                    System.out.println("2. Productos");
                    numero = lector.nextInt();
                    lector.nextLine();
                    switch (numero){
                        case 1:
                            tabla = Consultas.mostrarCliente();
                            miCliente = PedirDatos.modificarCliente();
                            sql = Update.actualizarCliente(miCliente);
                            tabla = Consultas.mostrarCliente();
                            break;
                        case 2:
                            tabla = Consultas.mostrarProducto();
                            miProducto = PedirDatos.modificarProducto();
                            sql = Update.actualizarProducto(miProducto);
                            tabla = Consultas.mostrarProducto();
                            break;
                    }
                    break;
                case 5:
                    tabla = Consultas.mostrarProducto();
                    miProducto = PedirDatos.idProducto();
                    tabla = Consultas.mostrarCliente();
                    miCliente = PedirDatos.idCliente();
                    sql = Insertar.insertarClienteProducto(miCliente,miProducto);
                    conexion = Conexion.insertarBD(sql);
                    break;
                case 6:
                    tabla = Consultas.mostrarProducto();
                    miProducto = PedirDatos.pedirProducto();
                    sql = Consultas.darClientes(miProducto);
                    break;
                case 7:
                    tabla = Consultas.mostrarCliente();
                    miCliente = PedirDatos.pedirCliente();
                    sql = Consultas.darProductos(miCliente);
                    break;
                case 8:
                    sql = Consultas.totalClientes();
                    tabla = Consultas.mostrarCliente();
                    break;
                case 9:
                    sql = Consultas.productoUsado();
                    break;
                case 10:
                    sql = Consultas.clienteSinProducto();
                    break;
            }
            System.out.println("Si desea continuar en el menu pulse s, si no cualquier otra letra");
            continuar = lector.next().charAt(0);
            lector.nextLine();
        }while (continuar == 's' || continuar == 'S');
    }
}
