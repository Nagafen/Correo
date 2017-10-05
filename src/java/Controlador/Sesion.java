package Controlador;

import DAO.DaoUsuario;
import Modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class Sesion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                String usuario = (String) session.getAttribute("user");
                String password = (String) session.getAttribute("pass");
                Usuario user;
                DaoUsuario daoU = new DaoUsuario();
                user = daoU.validarUsuario(usuario, password);
                String json = new Gson().toJson(user);
                response.setContentType("application/json");
                response.getWriter().write(json);
                System.out.println();
//                DataInputStream input;
//                BufferedInputStream bis;
//                BufferedOutputStream bos;
//                int in;
//                byte[] byteArray;
//                //Fichero a transferir
//                final String filename = daoU.validarUsuario(usuario, password).getImagenUsuario();
//                final File localFile = new File(filename);
//                System.out.println(localFile.exists());
//                Socket client = new Socket("localhost",8080);
//                bis = new BufferedInputStream(new FileInputStream(localFile));
//                bos = new BufferedOutputStream(client.getOutputStream());
//                //Enviamos el nombre del fichero
//                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//                dos.writeUTF(localFile.getName());
//                //Enviamos el fichero
//                byteArray = new byte[8192];
//                while ((in = bis.read(byteArray)) != -1) {
//                    bos.write(byteArray, 0, in);
//                }

            } else {
                response.getWriter().write("false");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
