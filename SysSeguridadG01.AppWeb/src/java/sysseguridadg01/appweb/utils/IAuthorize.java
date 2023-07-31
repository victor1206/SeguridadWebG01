/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sysseguridadg01.appweb.utils;

/**
 *
 * @author victo
 */
import java.io.IOException;
import jakarta.servlet.ServletException;
/*
Esta interfaz la utlizaramos para usar una expresion lambda, 
al momento de autorizar un usuario al servlet
*/
public interface IAuthorize {
    void authorize() throws ServletException, IOException;
}
