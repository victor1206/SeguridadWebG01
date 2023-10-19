/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sysseguridadg01.accesoadatos;

import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sysseguridadg01.entidadesdenegocio.Usuario;

/**
 *
 * @author victo
 */
public class UsuarioDALTest {
    
    public UsuarioDALTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of crear method, of class UsuarioDAL.
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        Usuario pUsuario = new Usuario();
        pUsuario.setIdRol(2);
        pUsuario.setNombre("Victor");
        pUsuario.setApellido("Rivas");
        pUsuario.setPassword("123456");
        pUsuario.setLogin("Rivas");
        pUsuario.setEstatus(Byte.parseByte("1"));
        int expResult = 1;
        int result = UsuarioDAL.crear(pUsuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of modificar method, of class UsuarioDAL.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("crear");
        Usuario pUsuario = new Usuario();
        pUsuario.setId(10);
        pUsuario.setIdRol(2);
        pUsuario.setNombre("Victor");
        pUsuario.setApellido("Rivas");
        pUsuario.setLogin("Rivas");
        pUsuario.setEstatus(Byte.parseByte("1"));
        int expResult = 1;
        int result = UsuarioDAL.modificar(pUsuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminar method, of class UsuarioDAL.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        Usuario pUsuario = new Usuario();
        pUsuario.setId(10);
        int expResult = 1;
        int result = UsuarioDAL.eliminar(pUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of asignarDatosResultSet method, of class UsuarioDAL.
     */
    @Test
    public void testAsignarDatosResultSet() throws Exception {
        System.out.println("asignarDatosResultSet");
        Usuario pUsuario = null;
        ResultSet pResultSet = null;
        int pIndex = 0;
        int expResult = 0;
        int result = UsuarioDAL.asignarDatosResultSet(pUsuario, pResultSet, pIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPorId method, of class UsuarioDAL.
     */
    @Test
    public void testObtenerPorId() throws Exception {
        System.out.println("obtenerPorId");
        Usuario pUsuario = new Usuario();
        pUsuario.setId(10);
        Usuario result = UsuarioDAL.obtenerPorId(pUsuario);
        assertEquals(pUsuario.getId(), result.getId());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodos method, of class UsuarioDAL.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        ArrayList<Usuario> expResult = null;
        ArrayList<Usuario> result = UsuarioDAL.obtenerTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of querySelect method, of class UsuarioDAL.
     */
    @Test
    public void testQuerySelect() throws Exception {
        System.out.println("querySelect");
        Usuario pUsuario = null;
        ComunDB.UtilQuery pUtilQuery = null;
        UsuarioDAL.querySelect(pUsuario, pUtilQuery);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class UsuarioDAL.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        Usuario pUsuario = null;
        ArrayList<Usuario> expResult = null;
        ArrayList<Usuario> result = UsuarioDAL.buscar(pUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class UsuarioDAL.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        Usuario pUsuario = null;
        Usuario expResult = null;
        Usuario result = UsuarioDAL.login(pUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarPassword method, of class UsuarioDAL.
     */
    @Test
    public void testCambiarPassword() throws Exception {
        System.out.println("cambiarPassword");
        Usuario pUsuario = null;
        String pPasswordAnt = "";
        int expResult = 0;
        int result = UsuarioDAL.cambiarPassword(pUsuario, pPasswordAnt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarIncluirRol method, of class UsuarioDAL.
     */
    @Test
    public void testBuscarIncluirRol() throws Exception {
        System.out.println("buscarIncluirRol");
        Usuario pUsuario = null;
        ArrayList<Usuario> expResult = null;
        ArrayList<Usuario> result = UsuarioDAL.buscarIncluirRol(pUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
