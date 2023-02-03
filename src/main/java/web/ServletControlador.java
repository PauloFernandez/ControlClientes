package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
              throws ServletException, IOException{
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch(accion){
                case "editar": 
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
     private void editarCliente(HttpServletRequest request, HttpServletResponse response) 
             throws ServletException, IOException{
        //Primero tenemos que recuperamos el valor de idCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente")); // este valor lo obtenemos de listadoCliente.jsp
      
        //llamamos al metodo encontrar de la clase ClienteDaoJDBC pasandole por parametro el objeto idCliente 
        //apoyandonos del constructor de la clase Cliente con un atributo (idCliente)
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
        
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);   
    }
     
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //Primero tenemos que recuperamos los valores del formulario editarCliente.jsp 
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        
        //Creamos el objeto del cliente (modelo) usando el constructor de la clase Cliente que tiene solo el id
        Cliente cliente = new Cliente(idCliente);
        
        //Eliminamos el objeto a la base de datos
        int registrosModificados = new ClienteDaoJDBC().eliminar(cliente);
        System.out.println("Registros Modificados = " +registrosModificados);
        
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);    
    }
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        List<Cliente> clientes = new ClienteDaoJDBC().lista();
        System.out.print("clientes = "+clientes );
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
//con el metodo "sendRedirect" redirigimos la informacion asia clientes.jsp notificando al navegador para que cuando se refresque
//se actualice 
        response.sendRedirect("clientes.jsp"); 
        
//Con el metodo "forward" enviamos la informacion asia clientes.jsp pero de manera interna por eso la pagina de navegacion 
//no cambia, osea que cuando se refresca no save que esta pasando y ejecuta la ultima accion solicitada
//    VER EXPLICACION EN EL VIDEO Nro 260 DEL CURSO GlobalMentoring
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);   
    }
    
    private double calcularSaldoTotal(List<Cliente> clientes){
        double saldoTotal =0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;   
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
              throws ServletException, IOException{
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch(accion){
                case "insertar": 
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        //Primero tenemos que recuperamos los valores del formulario agregarCliente.jsp 
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }
        
        //Creamos el objeto del cliente (modelo) usando el constructor de la clase Cliente que tiene todos los objetos menos el id
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        
        //Insertamos el nuevo objeto a la base de datos
        int registrosInsertados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("Registros Insertados = " +registrosInsertados);
        
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
     private void modificarCliente(HttpServletRequest request, HttpServletResponse response) 
             throws ServletException, IOException{
        //Primero tenemos que recuperamos los valores del formulario editarCliente.jsp 
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }
        
        //Creamos el objeto del cliente (modelo) usando el constructor de la clase Cliente que tiene todos los objetos menos el id
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
        
        //Modificamos el objeto a la base de datos
        int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("Registros Modificados = " +registrosModificados);
        
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
}
