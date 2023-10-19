/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sysseguridadg01.accesoadatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victo
 */
public class ComunDBTest {
    
    public ComunDBTest() {
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
     * Test of obtenerConexion method, of class ComunDB.
     */
    @Test
    public void testObtenerConexion() throws Exception {
        System.out.println("obtenerConexion");
        boolean expResult = false;
        Connection result = ComunDB.obtenerConexion();
        assertEquals(expResult, result.isClosed());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createStatement method, of class ComunDB.
     */
    @Test
    public void testCreateStatement() throws Exception {
        System.out.println("createStatement");
        Connection pCon = null;
        Statement expResult = null;
        Statement result = ComunDB.createStatement(pCon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPreparedStatement method, of class ComunDB.
     */
    @Test
    public void testCreatePreparedStatement() throws Exception {
        System.out.println("createPreparedStatement");
        Connection pCon = null;
        String pSql = "";
        PreparedStatement expResult = null;
        PreparedStatement result = ComunDB.createPreparedStatement(pCon, pSql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerResulSet method, of class ComunDB.
     */
    @Test
    public void testObtenerResulSet_Statement_String() throws Exception {
        System.out.println("obtenerResulSet");
        Statement pStatement = null;
        String pSql = "";
        ResultSet expResult = null;
        ResultSet result = ComunDB.obtenerResulSet(pStatement, pSql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerResulSet method, of class ComunDB.
     */
    @Test
    public void testObtenerResulSet_PreparedStatement() throws Exception {
        System.out.println("obtenerResulSet");
        PreparedStatement pPreparedStatement = null;
        ResultSet expResult = null;
        ResultSet result = ComunDB.obtenerResulSet(pPreparedStatement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
