package Controlador;

import DAO.DaoElementos;
import Modelo.Elemento;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.sql.SQLException;

public class ListarPorArea extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            ArrayList<Elemento> lista = null;
            DaoElementos daoE = new DaoElementos();
            String area = request.getParameter("valor1");
            System.out.println(area);
            lista = daoE.listarPorArea(area);
            String json = new Gson().toJson(lista);
            response.setContentType("application/json");
            response.getWriter().write(json);
            
        } catch (URISyntaxException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}