package DAO;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUsuario {

    private Connection conexion;

    public DaoUsuario() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
    }

    public ArrayList validarRegistro(String usuario, String clave, String colegio, String correo) {
        ArrayList<Boolean> arr1 = new ArrayList<>();
        boolean res = false;
        boolean res2 = false;
        try {
            String consulta = "select * from usuarios where identificador=? and colegio=? and correo=? and clave='null'";
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            statement.setString(1, usuario);
            statement.setString(2, colegio);
            statement.setString(3, correo);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                res = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (res == true) {
            res2 = modificarClave(usuario, clave);
        }
        arr1.add(res);
        return arr1;

    }

   
    public boolean modificarClave(String usuario, String clave) {
        boolean resultado = false;

        try {
            String consulta = "update usuarios set clave=? where identificador=?";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.setString(1, clave);
            statement.setString(2, usuario);
            resultado = statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }
    public boolean modificarFoto(String usuario, String clave) {
        boolean resultado = false;

        try {
            String consulta = "update usuarios set imagen=? where identificador=?";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.setString(1, clave);
            statement.setString(2, usuario);
            resultado = statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

    public Usuario validarUsuario(String usuario, String clave) {
        Usuario respuesta = new Usuario();
        String consulta = "select * from usuarios where identificador= '" + usuario + "' and clave='" + clave + "'";
        try {
            //Statement
            Statement statement
                    = this.conexion.createStatement();
            //Ejecucion
            ResultSet resultado
                    = statement.executeQuery(consulta);
            //----------------------------
            //Recorrido sobre el resultado
            while (resultado.next()) {
                Usuario user = new Usuario();
                user.setIdentificador(resultado.getString("identificador"));
                user.setNombreSol(resultado.getString("nombreSol"));
                user.setTipo(resultado.getString("tipo"));
                user.setCursoArea(resultado.getString("cursoArea"));
                user.setColegio(resultado.getString("colegio"));
                user.setClave(resultado.getString("clave"));
                user.setImagenUsuario(resultado.getString("imagen"));
                respuesta = user;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

}
