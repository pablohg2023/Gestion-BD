package control;

public class ProductoCliente {

    private int productoID;
    private int clienteID;

    public ProductoCliente() {
        super();
    }

    public ProductoCliente(int productoID, int clienteID) {
        super();
        this.productoID = productoID;
        this.clienteID = clienteID;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    @Override
    public String toString() {
        return "ProductoCliente [productoID=" + productoID + ", clienteID=" + clienteID + "]";
    }

}