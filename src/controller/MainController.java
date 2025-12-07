package controller;

import java.awt.CardLayout;

import view.ClientePanel;
import view.EnvioPanel;
import view.MainView;
import view.MenuPanel;

public class MainController {

    private MainView view;
    private MenuPanel menuPanel;
    private ClientePanel clientePanel;
    private EnvioPanel envioPanel;

    public MainController() {
        init();
        menuLateralBtnListeners();
    }

    private void init() {

        view = new MainView();
        menuPanel = new MenuPanel();
        clientePanel = new ClientePanel();
        envioPanel = new EnvioPanel();
        

        // SET MENUS
        view.getPanelContenedor().add(menuPanel, "menu");
        view.getPanelContenedor().add(clientePanel, "clientes");
        view.getPanelContenedor().add(envioPanel, "envios");

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
        
        view.getBtnEnvios().addActionListener((e) -> {
            view.getCardLayout().show(view.getPanelContenedor(), "envios");
        });
    }

    public void initControllers() {
        new ClienteController(clientePanel);
        new EnvioController(envioPanel);
    }
    
}
