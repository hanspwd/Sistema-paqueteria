/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package syspaqueteria;

import controller.MainController;
import view.MainView;

public class Main {
    
    public static void main(String[] args) {
        MainView view = new MainView();
        MainController controller = new MainController(view);
    }
    
}
