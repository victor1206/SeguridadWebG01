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
import sysseguridadg01.entidadesdenegocio.Rol;

/**
 *
 * @author victo
 */
public class RolDALTest {
    
    public RolDALTest() {
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
     * Test of obtenerCampos method, of class RolDAL.
     */
    /*@Test
    public void testObtenerCampos() {
        System.out.println("obtenerCampos");
        String expResult = "";
        String result = RolDAL.obtenerCampos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of crear method, of class RolDAL.
     */
    @Test
    public void test1Crear() throws Exception {
        System.out.println("crear");
        Rol pRol = new Rol();
        pRol.setId(0);
        pRol.setNombre("Test Rol Nuevo");
        int expResult = 1;
        int result = RolDAL.crear(pRol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class RolDAL.
     */
    @Test
    public void test2Modificar() throws Exception {
        System.out.println("modificar");
        Rol pRol = new Rol();
        pRol.setId(17);
        pRol.setNombre("Test Modificar");
        int expResult = 1;
        int result = RolDAL.modificar(pRol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of asignarDatosResultSet method, of class RolDAL.
     */
    /*@Test
    public void testAsignarDatosResultSet() throws Exception {
        System.out.println("asignarDatosResultSet");
        Rol pRol = null;
        ResultSet pResultSet = null;
        int pIndex = 0;
        int expResult = 0;
        int result = RolDAL.asignarDatosResultSet(pRol, pResultSet, pIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of obtenerPorId method, of class RolDAL.
     */
    @Test
    public void test3ObtenerPorId() throws Exception {
        System.out.println("obtenerPorId");
        Rol pRol = new Rol();
        pRol.setId(17);
        //Rol expResult = null;
        Rol result = RolDAL.obtenerPorId(pRol);
        assertEquals(pRol.getId(), result.getId());
        //assertTrue(pRol.getId() == result.getId());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodos method, of class RolDAL.
     */
    @Test
    public void test4ObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        ArrayList<Rol> result = RolDAL.obtenerTodos();
        assertTrue(result.size() > 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of querySelect method, of class RolDAL.
     */
    /*@Test
    public void testQuerySelect() throws Exception {
        System.out.println("querySelect");
        Rol pRol = null;
        ComunDB.UtilQuery pUtilQuery = null;
        RolDAL.querySelect(pRol, pUtilQuery);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of buscar method, of class RolDAL.
     */
    @Test
    public void test5Buscar() throws Exception {
        System.out.println("buscar");
        Rol pRol = new Rol();
        pRol.setNombre("a");
        ArrayList<Rol> result = RolDAL.buscar(pRol);
        assertTrue(result.size() > 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of eliminar method, of class RolDAL.
     */
    @Test
    public void test6Eliminar() throws Exception {
        System.out.println("eliminar");
        Rol pRol = new Rol();
        pRol.setId(17);
        int expResult = 1;
        int result = RolDAL.eliminar(pRol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
