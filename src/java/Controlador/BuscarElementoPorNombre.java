/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DaoElementos;
import DAO.DaoUsuario;
import Modelo.Elemento;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;


/**
 *
 * @author maria
 */
public class BuscarElementoPorNombre extends HttpServlet {
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
         
        String nombre=request.getParameter("Busqueda");
            
            DaoElementos dao;
         try {
             
             
             dao = new DaoElementos();
             ArrayList<Elemento> c=new ArrayList<Elemento>();
            c=dao.listarTodo();
           
            String json = new Gson().toJson(c);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(json);
            } catch (URISyntaxException ex) {
             Logger.getLogger(BuscarElementoPorNombre.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(BuscarElementoPorNombre.class.getName()).log(Level.SEVERE, null, ex);
         }
         }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
//         
//        
//        try {
//            String nombre=request.getParameter("Busqueda");
//            
//            DaoElementos dao = new DaoElementos();
//            Elemento el = new Elemento();
//            el=dao.buscarPorNombre(nombre);
//            String json = new Gson().toJson(el);
//            response.setContentType("application/json");
//            response.getWriter().write(json);  
//              
//            
//           
////            String Enciclopedia = request.getParameter("Enciclopedia");
////            String Diccionarios = request.getParameter("Diccionarios");
////            String Espanol = request.getParameter("Espanol");
////            String Matematicas = request.getParameter("Matematicas");
////            String Fisica = request.getParameter("Fisica");
////            String Quimica = request.getParameter("Quimica");
////            String Sociales = request.getParameter("Sociales");
////            String Ingles = request.getParameter("Ingles");
////            String Ciencias = request.getParameter("Ciencias");
////            String Preescolar = request.getParameter("Preescolar");
////            String Filosofia = request.getParameter("Filosofia");
////            String Religion = request.getParameter("Religion");
////            String Etica = request.getParameter("Etica");
////            String Informatica = request.getParameter("Informatica");
////            String Atlas = request.getParameter("Atlas");
////            String Salud = request.getParameter("Salud");
////            String Dibujo = request.getParameter("Dibujo");
////            String Institucionales = request.getParameter("Institucionales");
////            String MaterialDidactico = request.getParameter("Material Didactico");
////            String Multimedia = request.getParameter("Multimedia");
////            String Equipo = request.getParameter("Equipo");
////            ArrayList<Elemento> lista = null;
////            DaoElementos daoE = new DaoElementos();
////            
////            if (Enciclopedia != null) {
////                lista = daoE.listarPorArea(Enciclopedia);
////                request.setAttribute("elementos", lista);
////                response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Diccionarios != null) {
////                lista = daoE.listarPorArea(Diccionarios);
////                request.setAttribute("elementos", lista);
////                response.setContentType("application/json");
////                response.getWriter().write(json);
////               
////            }
////            if (Espanol != null) {
////                lista = daoE.listarPorArea("Español");
////                request.setAttribute("elementos", lista);
////                  response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Matematicas != null) {
////                lista = daoE.listarPorArea(Matematicas);
////                request.setAttribute("elementos", lista);
////                  response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Fisica != null) {
////                lista = daoE.listarPorArea(Fisica);
////                request.setAttribute("elementos", lista);
////                  response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Quimica != null) {
////                lista = daoE.listarPorArea(Quimica);
////                request.setAttribute("elementos", lista);
////                  response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Sociales != null) {
////                lista = daoE.listarPorArea(Sociales);
////                request.setAttribute("elementos", lista);
////                 response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Ingles != null) {
////                lista = daoE.listarPorArea(Ingles);
////                request.setAttribute("elementos", lista);
////                 response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Ciencias != null) {
////                lista = daoE.listarPorArea(Ciencias);
////                request.setAttribute("elementos", lista);
////                 response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Preescolar != null) {
////                lista = daoE.listarPorArea(Preescolar);
////                request.setAttribute("elementos", lista);
////                  response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Filosofia != null) {
////                lista = daoE.listarPorArea(Filosofia);
////                request.setAttribute("elementos", lista);
////                  response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Religion != null) {
////                lista = daoE.listarPorArea(Religion);
////                request.setAttribute("elementos", lista);
////                  response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Etica != null) {
////                lista = daoE.listarPorArea(Etica);
////                request.setAttribute("elementos", lista);
////                response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Informatica != null) {
////                lista = daoE.listarPorArea(Informatica);
////                request.setAttribute("elementos", lista);
////                  response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Atlas != null) {
////                lista = daoE.listarPorArea(Atlas);
////                request.setAttribute("elementos", lista);
////                 response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Salud != null) {
////                lista = daoE.listarPorArea(Salud);
////                request.setAttribute("elementos", lista);
////                response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Dibujo != null) {
////                lista = daoE.listarPorArea(Dibujo);
////                request.setAttribute("elementos", lista);
////                 response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Institucionales != null) {
////                lista = daoE.listarPorArea(Institucionales);
////                request.setAttribute("elementos", lista);
////                  response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (MaterialDidactico != null) {
////                lista = daoE.listarPorArea(MaterialDidactico);
////                request.setAttribute("elementos", lista);
////                  response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Multimedia != null) {
////                lista = daoE.listarPorArea(Multimedia);
////                request.setAttribute("elementos", lista);
////                  response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////            }
////            if (Equipo != null) {
////                lista = daoE.listarPorArea(Equipo);
////                request.setAttribute("elementos", lista);
////                 response.setContentType("application/json");
////                response.getWriter().write(json);
////                
////        } 
//
//    }    catch (URISyntaxException ex) {
//             Logger.getLogger(BuscarElementoPorNombre.class.getName()).log(Level.SEVERE, null, ex);
//         } catch (SQLException ex) {
//             Logger.getLogger(BuscarElementoPorNombre.class.getName()).log(Level.SEVERE, null, ex);
         }}
