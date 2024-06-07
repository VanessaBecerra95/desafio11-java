package cl.praxis.recliclaJeans;
import java.util.Scanner;
import java.util.ArrayList;

public class ProductoServicio {
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    private Scanner scanner = new Scanner(System.in);

    public ProductoServicio(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ProductoServicio() {
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void listarProductos() {
        if (listaProductos.isEmpty() || listaProductos == null) {
            System.out.println("No hay productos en la lista.");
            return;
        }
        for (Producto producto : listaProductos) {
            System.out.println("Datos del Producto: ");
            System.out.println("Nombre articulo: " + producto.getArticulo());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Descripcion: " + producto.getDescripcion());
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Marca: " + producto.getMarca());
            System.out.println("Color: " + producto.getColor());
            System.out.println("Talla: " + producto.getTalla());
            System.out.println("---------------------------------");
        }
    }

    public void editarProducto() {
        System.out.println("Editar Producto");
        System.out.println("Ingrese el número 1 para editar los datos ingresados del Producto");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
            System.out.print("Ingrese el código del producto: ");
            String codigo = scanner.nextLine();
            Producto producto = buscarProductoPorCodigo(codigo);

            if (producto != null) {
                descripcionProducto(producto);

                System.out.print("Ingrese la opción a editar de los datos del producto: ");
                int opcionEditar = scanner.nextInt();
                scanner.nextLine();

                switch (opcionEditar) {
                    case 1:
                        System.out.print("Ingrese el nuevo nombre del artículo: ");
                        producto.setArticulo(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Ingrese el nuevo precio del producto: ");
                        producto.setPrecio(scanner.nextLine());
                        break;
                    case 3:
                        System.out.print("Ingrese la nueva descripción del producto: ");
                        producto.setDescripcion(scanner.nextLine());
                        break;
                    case 4:
                        System.out.print("Ingrese el nuevo código del producto: ");
                        producto.setCodigo(scanner.nextLine());
                        break;
                    case 5:
                        System.out.print("Ingrese la nueva talla del producto: ");
                        producto.setTalla(scanner.nextLine());
                        break;
                    case 6:
                        System.out.print("Ingrese la nueva marca del producto: ");
                        producto.setMarca(scanner.nextLine());
                        break;
                    case 7:
                        System.out.print("Ingrese el nuevo color del producto: ");
                        producto.setColor(scanner.nextLine());
                        break;
                    default:
                        System.out.println("Opción no válida, intente con un número entre 1 y 7.");
                }
                System.out.println("Producto editado: " + producto);
            } else {
                System.out.println("Producto con código " + codigo + " no encontrado.");
            }
        }
    }

    private void descripcionProducto(Producto producto) {
        System.out.println("1.-El nombre del articulo actual es: " + producto.getArticulo());
        System.out.println("2.-El código del producto: " + producto.getCodigo());
        System.out.println("3.-El color del producto: " + producto.getColor());
        System.out.println("4.-La descripción del producto: " + producto.getDescripcion());
        System.out.println("5.-La marca del producto: " + producto.getMarca());
        System.out.println("6.-El precio del producto: " + producto.getPrecio());
        System.out.println("7.-La talla del producto: " + producto.getTalla());
    }

    private Producto buscarProductoPorCodigo(String codigo) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }
}
