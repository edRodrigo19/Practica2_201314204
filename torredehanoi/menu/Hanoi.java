package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


 
public class Hanoi extends JFrame implements ActionListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	private JLabel labelNroDiscos;
    private JLabel labelInformacion;
    private JLabel spinnerNroDiscos;
    private JButton botonIniciar;
    private Graficos dibujo;
    public Hanoi() {
        super("TUTORIAL TORRES DE HANOI");
        configurarVentana();
        inicializarComponentes();
        this.setVisible(true);
    }

    JMenuBar barra;
    JMenu menu;
    JMenuItem boton1, boton2;
    
	private void configurarVentana() {
        this.setSize(900, 650);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
    	
    	met();
    	paintComponents(getGraphics());
    	JPanel panelInferior = new JPanel();

        labelNroDiscos = new JLabel(" ");
        panelInferior.add(labelNroDiscos);

        spinnerNroDiscos = new JLabel("5 Discos");
        
        panelInferior.add(spinnerNroDiscos);

        botonIniciar = new JButton("Iniciar");
        botonIniciar.addActionListener(this);
        panelInferior.add(botonIniciar);

        labelInformacion = new JLabel("Movimientos Completados");
        labelInformacion.setForeground(Color.red);
        labelInformacion.setVisible(false);
        panelInferior.add(labelInformacion);

        add(panelInferior, BorderLayout.SOUTH);
        dibujo = new Graficos(5, this);
        add(dibujo, BorderLayout.CENTER);
       
        menu.add(boton1);
        menu.add(boton2);
        barra.add(menu);
        setJMenuBar(barra);
    }

    public void actionPerformed(ActionEvent e) {
        if (botonIniciar.getText().equals("Pausar")) {
            dibujo.pausarAnimacion();
            botonIniciar.setText("Continuar");
        } else {
            if (botonIniciar.getText().equals("Iniciar De Nuevo")) {
                dibujo = new Graficos(Integer.parseInt(spinnerNroDiscos.getSize().toString()), this);
                add(dibujo, BorderLayout.CENTER);
                botonIniciar.setText("Iniciar");
                labelInformacion.setVisible(false);
                this.setVisible(true);
            } else {
                dibujo.iniciarAnimacion();
                botonIniciar.setText("Pausar");
            }
        }
        
        if(e.getSource()==boton1){
        	 llamarMenu();
        	}
        if (e.getSource()==boton2){	
        	
        	System.exit(1);
        }
        
    }
      

	public void stateChanged(ChangeEvent e) {
        dibujo.pausarAnimacion();
        botonIniciar.setText("Iniciar");
        labelInformacion.setVisible(false);
        dibujo = new Graficos(Integer.parseInt(spinnerNroDiscos.getSize().toString()), this);
        add(dibujo, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void resolucionCompletada() {
        botonIniciar.setText("Iniciar De Nuevo");
        labelInformacion.setVisible(true);
    }
    
    public void met(){
    	 
    	    barra = new JMenuBar();
    	    menu = new JMenu("Opciones");
    	    boton1 = new JMenuItem("Regresar");
    	    boton2 = new JMenuItem("Salir");
    	    boton1.addActionListener(this);
    	    boton2.addActionListener(this);
    }
    
    public static void llamarMenu(){
    	String[] args=null;
    	TorredeHanoi.main(args);
	}
                                   
}