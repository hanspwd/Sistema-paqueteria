package controller;

import java.awt.CardLayout;
import view.ClientePanel;
import view.MainView;
import view.MenuPanel;

public class MainController {

    CardLayout cardLayout;
    private MainView view = new MainView();

    public MainController(MainView view) {
        this.view = view;
        init();
        menuLateralBtnListeners();
    }

    private void init() {
        view.getPanelContenedor().add(new MenuPanel(), "menu");
        view.getPanelContenedor().add(new ClientePanel(), "clientes");
        
        view.getCardLayout().show(view.getPanelContenedor(), "menu");
        view.setVisible(true);
    }
   
    public void menuLateralBtnListeners() {
        
        view.getBtnMenu().addActionListener((e) -> {
            view.getCardLayout().show(view.getPanelContenedor(), "menu");
        });
        
        view.getBtnClientes().addActionListener((e) -> {
            view.getCardLayout().show(view.getPanelContenedor(), "clientes");
        });


    }
    
}
