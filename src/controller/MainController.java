package controller;

import java.awt.CardLayout;

import view.ClientePanel;
import view.MainView;
import view.MenuPanel;

public class MainController {

    private MainView view;
    private MenuPanel menuPanel;
    private ClientePanel clientePanel;

    public MainController() {
        init();
        menuLateralBtnListeners();
    }

    private void init() {

        view = new MainView();
        menuPanel = new MenuPanel();
        clientePanel= new  ClientePanel();

        // SET MENUS
        view.getPanelContenedor().add(menuPanel, "menu");
        view.getPanelContenedor().add(clientePanel, "clientes");

        // Menu principal a mostrar por defecto
        view.getCardLayout().show(view.getPanelContenedor(), "menu");


        // INICIALIZACIÓN CONTROLLERS
        initControllers();

        view.setVisible(true);
    }

    // Action listener de los botones del menu
    public void menuLateralBtnListeners() {
        
        view.getBtnMenu().addActionListener((e) -> {
            view.getCardLayout().show(view.getPanelContenedor(), "menu");
        });
        
        view.getBtnClientes().addActionListener((e) -> {
            view.getCardLayout().show(view.getPanelContenedor(), "clientes");
        });
    }

    public void initControllers() {
        new ClienteController(clientePanel);
    }
    
}
