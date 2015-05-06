package Interace;

import Rainhas.Astar;
import Rainhas.HillClimb;
import Rainhas.SimulatedAnnealing;
import Rainhas.State;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame 
{   private State input;
    private Astar astar;
    private HillClimb hillclimb;
    private SimulatedAnnealing simulatedannealing;
    private int iteration = 50; //Por padrão.
    private boolean start = false;
    
    public Principal() 
    {   initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        L0 = new javax.swing.JLabel();
        L1 = new javax.swing.JLabel();
        L2 = new javax.swing.JLabel();
        L3 = new javax.swing.JLabel();
        L4 = new javax.swing.JLabel();
        L5 = new javax.swing.JLabel();
        L6 = new javax.swing.JLabel();
        L7 = new javax.swing.JLabel();
        L56 = new javax.swing.JLabel();
        L57 = new javax.swing.JLabel();
        L15 = new javax.swing.JLabel();
        L14 = new javax.swing.JLabel();
        L13 = new javax.swing.JLabel();
        L12 = new javax.swing.JLabel();
        L11 = new javax.swing.JLabel();
        L10 = new javax.swing.JLabel();
        L9 = new javax.swing.JLabel();
        L8 = new javax.swing.JLabel();
        L58 = new javax.swing.JLabel();
        L23 = new javax.swing.JLabel();
        L22 = new javax.swing.JLabel();
        L21 = new javax.swing.JLabel();
        L20 = new javax.swing.JLabel();
        L19 = new javax.swing.JLabel();
        L18 = new javax.swing.JLabel();
        L17 = new javax.swing.JLabel();
        L16 = new javax.swing.JLabel();
        L59 = new javax.swing.JLabel();
        L31 = new javax.swing.JLabel();
        L30 = new javax.swing.JLabel();
        L29 = new javax.swing.JLabel();
        L28 = new javax.swing.JLabel();
        L27 = new javax.swing.JLabel();
        L26 = new javax.swing.JLabel();
        L25 = new javax.swing.JLabel();
        L24 = new javax.swing.JLabel();
        L60 = new javax.swing.JLabel();
        L39 = new javax.swing.JLabel();
        L38 = new javax.swing.JLabel();
        L37 = new javax.swing.JLabel();
        L36 = new javax.swing.JLabel();
        L35 = new javax.swing.JLabel();
        L34 = new javax.swing.JLabel();
        L33 = new javax.swing.JLabel();
        L32 = new javax.swing.JLabel();
        L61 = new javax.swing.JLabel();
        L47 = new javax.swing.JLabel();
        L46 = new javax.swing.JLabel();
        L45 = new javax.swing.JLabel();
        L44 = new javax.swing.JLabel();
        L43 = new javax.swing.JLabel();
        L42 = new javax.swing.JLabel();
        L41 = new javax.swing.JLabel();
        L40 = new javax.swing.JLabel();
        L62 = new javax.swing.JLabel();
        L63 = new javax.swing.JLabel();
        L54 = new javax.swing.JLabel();
        L53 = new javax.swing.JLabel();
        L52 = new javax.swing.JLabel();
        L51 = new javax.swing.JLabel();
        L50 = new javax.swing.JLabel();
        L49 = new javax.swing.JLabel();
        L48 = new javax.swing.JLabel();
        L55 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelFundo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("8 - Queen");
        getContentPane().setLayout(null);

        L0.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L0.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L0);
        L0.setBounds(10, 170, 50, 40);

        L1.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L1);
        L1.setBounds(60, 170, 50, 40);

        L2.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L2);
        L2.setBounds(110, 170, 50, 40);

        L3.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L3);
        L3.setBounds(160, 170, 50, 40);

        L4.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L4);
        L4.setBounds(210, 170, 50, 40);

        L5.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L5);
        L5.setBounds(260, 170, 50, 40);

        L6.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L6);
        L6.setBounds(310, 170, 50, 40);

        L7.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L7);
        L7.setBounds(360, 170, 50, 40);

        L56.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L56.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L56);
        L56.setBounds(10, 450, 50, 40);

        L57.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L57.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L57);
        L57.setBounds(60, 450, 50, 40);

        L15.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L15);
        L15.setBounds(360, 210, 50, 40);

        L14.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L14);
        L14.setBounds(310, 210, 50, 40);

        L13.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L13);
        L13.setBounds(260, 210, 50, 40);

        L12.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L12);
        L12.setBounds(210, 210, 50, 40);

        L11.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L11);
        L11.setBounds(160, 210, 50, 40);

        L10.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L10);
        L10.setBounds(110, 210, 50, 40);

        L9.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L9);
        L9.setBounds(60, 210, 50, 40);

        L8.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L8);
        L8.setBounds(10, 210, 50, 40);

        L58.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L58.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L58);
        L58.setBounds(110, 450, 50, 40);

        L23.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L23);
        L23.setBounds(360, 250, 50, 40);

        L22.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L22);
        L22.setBounds(310, 250, 50, 40);

        L21.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L21);
        L21.setBounds(260, 250, 50, 40);

        L20.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L20);
        L20.setBounds(210, 250, 50, 40);

        L19.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L19);
        L19.setBounds(160, 250, 50, 40);

        L18.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L18);
        L18.setBounds(110, 250, 50, 40);

        L17.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L17);
        L17.setBounds(60, 250, 50, 40);

        L16.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L16);
        L16.setBounds(10, 250, 50, 40);

        L59.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L59.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L59);
        L59.setBounds(160, 450, 50, 40);

        L31.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L31.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L31);
        L31.setBounds(360, 290, 50, 40);

        L30.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L30.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L30);
        L30.setBounds(310, 290, 50, 40);

        L29.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L29.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L29);
        L29.setBounds(260, 290, 50, 40);

        L28.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L28.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L28);
        L28.setBounds(210, 290, 50, 40);

        L27.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L27.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L27);
        L27.setBounds(160, 290, 50, 40);

        L26.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L26.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L26);
        L26.setBounds(110, 290, 50, 40);

        L25.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L25.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L25);
        L25.setBounds(60, 290, 50, 40);

        L24.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L24);
        L24.setBounds(10, 290, 50, 40);

        L60.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L60.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L60);
        L60.setBounds(210, 450, 50, 40);

        L39.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L39.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L39);
        L39.setBounds(360, 330, 50, 40);

        L38.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L38.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L38);
        L38.setBounds(310, 330, 50, 40);

        L37.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L37.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L37);
        L37.setBounds(260, 330, 50, 40);

        L36.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L36.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L36);
        L36.setBounds(210, 330, 50, 40);

        L35.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L35.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L35);
        L35.setBounds(160, 330, 50, 40);

        L34.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L34.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L34);
        L34.setBounds(110, 330, 50, 40);

        L33.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L33.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L33);
        L33.setBounds(60, 330, 50, 40);

        L32.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L32.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L32);
        L32.setBounds(10, 330, 50, 40);

        L61.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L61.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L61);
        L61.setBounds(260, 450, 50, 40);

        L47.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L47.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L47);
        L47.setBounds(360, 370, 50, 40);

        L46.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L46.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L46);
        L46.setBounds(310, 370, 50, 40);

        L45.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L45.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L45);
        L45.setBounds(260, 370, 50, 40);

        L44.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L44.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L44);
        L44.setBounds(210, 370, 50, 40);

        L43.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L43.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L43);
        L43.setBounds(160, 370, 50, 40);

        L42.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L42.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L42);
        L42.setBounds(110, 370, 50, 40);

        L41.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L41.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L41);
        L41.setBounds(60, 370, 50, 40);

        L40.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L40.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L40);
        L40.setBounds(10, 370, 50, 40);

        L62.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L62.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L62);
        L62.setBounds(310, 450, 50, 40);

        L63.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L63.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L63);
        L63.setBounds(360, 450, 50, 40);

        L54.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L54.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L54);
        L54.setBounds(310, 410, 50, 40);

        L53.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L53.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L53);
        L53.setBounds(260, 410, 50, 40);

        L52.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L52.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L52);
        L52.setBounds(210, 410, 50, 40);

        L51.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L51.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L51);
        L51.setBounds(160, 410, 50, 40);

        L50.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L50.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L50);
        L50.setBounds(110, 410, 50, 40);

        L49.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L49.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L49);
        L49.setBounds(60, 410, 50, 40);

        L48.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L48.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L48);
        L48.setBounds(10, 410, 50, 40);

        L55.setFont(new java.awt.Font("Ubuntu Mono", 1, 30)); // NOI18N
        L55.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(L55);
        L55.setBounds(360, 410, 50, 40);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel1.setText("Log:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(430, 140, 49, 30);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(430, 170, 262, 320);

        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cooltext1777210943.png"))); // NOI18N
        getContentPane().add(jLabelTitulo);
        jLabelTitulo.setBounds(140, 10, 380, 90);

        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/verde.jpg"))); // NOI18N
        getContentPane().add(jLabelFundo);
        jLabelFundo.setBounds(0, -20, 730, 540);

        jMenu1.setText("File");

        jMenuItem1.setText("New State");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Astar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Hill Climb");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Simulated Annealing");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("About");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Exit");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem7.setText("Hill Climb");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(717, 568));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public static void setText(String texto)
    {   jTextArea1.append(texto);        
    }
    
    public static void clearText()
    {   jTextArea1.setText("");       
    }        
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        input = new State();
        clearText();
        
        L0.setText("");
        L1.setText("");
        L2.setText("");
        L3.setText("");
        L4.setText("");
        L5.setText("");
        L6.setText("");
        L7.setText("");
        L8.setText("");
        L9.setText("");
        L10.setText("");
        L11.setText("");
        L12.setText("");
        L13.setText("");
        L14.setText("");
        L15.setText("");
        L16.setText("");
        L17.setText("");
        L18.setText("");
        L19.setText("");
        L20.setText("");
        L21.setText("");
        L22.setText("");
        L23.setText("");
        L24.setText("");
        L25.setText("");
        L26.setText("");
        L27.setText("");
        L28.setText("");
        L29.setText("");
        L30.setText("");
        L31.setText("");
        L32.setText("");
        L33.setText("");
        L34.setText("");
        L35.setText("");
        L36.setText("");
        L37.setText("");
        L38.setText("");
        L39.setText("");
        L40.setText("");
        L41.setText("");
        L42.setText("");
        L43.setText("");
        L44.setText("");
        L45.setText("");
        L46.setText("");
        L47.setText("");
        L48.setText("");
        L49.setText("");
        L50.setText("");
        L51.setText("");
        L52.setText("");
        L53.setText("");
        L54.setText("");
        L55.setText("");
        L56.setText("");
        L57.setText("");
        L58.setText("");
        L59.setText("");
        L60.setText("");
        L61.setText("");
        L62.setText("");
        L63.setText("");
        
        if (input.getBoardPos(0, 0) == -1)
            L0.setText("R");
        if (input.getBoardPos(0, 1) == -1)
            L1.setText("R");
        if (input.getBoardPos(0, 2) == -1)
            L2.setText("R");
        if (input.getBoardPos(0, 3) == -1)
            L3.setText("R");
        if (input.getBoardPos(0, 4) == -1)
            L4.setText("R");
        if (input.getBoardPos(0, 5) == -1)
            L5.setText("R");
        if (input.getBoardPos(0, 6) == -1)
            L6.setText("R");
        if (input.getBoardPos(0, 7) == -1)
            L7.setText("R");
        if (input.getBoardPos(1, 0) == -1)
            L8.setText("R");
        if (input.getBoardPos(1, 1) == -1)
            L9.setText("R");
        if (input.getBoardPos(1, 2) == -1)
            L10.setText("R");
        if (input.getBoardPos(1, 3) == -1)
            L11.setText("R");
        if (input.getBoardPos(1, 4) == -1)
            L12.setText("R");
        if (input.getBoardPos(1, 5) == -1)
            L13.setText("R");
        if (input.getBoardPos(1, 6) == -1)
            L14.setText("R");
        if (input.getBoardPos(1, 7) == -1)
            L15.setText("R");
        if (input.getBoardPos(2, 0) == -1)
            L16.setText("R");
        if (input.getBoardPos(2, 1) == -1)
            L17.setText("R");
        if (input.getBoardPos(2, 2) == -1)
            L18.setText("R");
        if (input.getBoardPos(2, 3) == -1)
            L19.setText("R");
        if (input.getBoardPos(2, 4) == -1)
            L20.setText("R");
        if (input.getBoardPos(2, 5) == -1)
            L21.setText("R");
        if (input.getBoardPos(2, 6) == -1)
            L22.setText("R");
        if (input.getBoardPos(2, 7) == -1)
            L23.setText("R");
        if (input.getBoardPos(3, 0) == -1)
            L24.setText("R");
        if (input.getBoardPos(3, 1) == -1)
            L25.setText("R");
        if (input.getBoardPos(3, 2) == -1)
            L26.setText("R");
        if (input.getBoardPos(3, 3) == -1)
            L27.setText("R");
        if (input.getBoardPos(3, 4) == -1)
            L28.setText("R");
        if (input.getBoardPos(3, 5) == -1)
            L29.setText("R");
        if (input.getBoardPos(3, 6) == -1)
            L30.setText("R");
        if (input.getBoardPos(3, 7) == -1)
            L31.setText("R");
        if (input.getBoardPos(4, 0) == -1)
            L32.setText("R");
        if (input.getBoardPos(4, 1) == -1)
            L33.setText("R");
        if (input.getBoardPos(4, 2) == -1)
            L34.setText("R");
        if (input.getBoardPos(4, 3) == -1)
            L35.setText("R");
        if (input.getBoardPos(4, 4) == -1)
            L36.setText("R");
        if (input.getBoardPos(4, 5) == -1)
            L37.setText("R");
        if (input.getBoardPos(4, 6) == -1)
            L38.setText("R");
        if (input.getBoardPos(4, 7) == -1)
            L39.setText("R");
        if (input.getBoardPos(5, 0) == -1)
            L40.setText("R");
        if (input.getBoardPos(5, 1) == -1)
            L41.setText("R");
        if (input.getBoardPos(5, 2) == -1)
            L42.setText("R");
        if (input.getBoardPos(5, 3) == -1)
            L43.setText("R");
        if (input.getBoardPos(5, 4) == -1)
            L44.setText("R");
        if (input.getBoardPos(5, 5) == -1)
            L45.setText("R");
        if (input.getBoardPos(5, 6) == -1)
            L46.setText("R");
        if (input.getBoardPos(5, 7) == -1)
            L47.setText("R");
        if (input.getBoardPos(6, 0) == -1)
            L48.setText("R");
        if (input.getBoardPos(6, 1) == -1)
            L49.setText("R");
        if (input.getBoardPos(6, 2) == -1)
            L50.setText("R");
        if (input.getBoardPos(6, 3) == -1)
            L51.setText("R");
        if (input.getBoardPos(6, 4) == -1)
            L52.setText("R");
        if (input.getBoardPos(6, 5) == -1)
            L53.setText("R");
        if (input.getBoardPos(6, 6) == -1)
            L54.setText("R");
        if (input.getBoardPos(6, 7) == -1)
            L55.setText("R");
        if (input.getBoardPos(7, 0) == -1)
            L56.setText("R");
        if (input.getBoardPos(7, 1) == -1)
            L57.setText("R");
        if (input.getBoardPos(7, 2) == -1)
            L58.setText("R");
        if (input.getBoardPos(7, 3) == -1)
            L59.setText("R");
        if (input.getBoardPos(7, 4) == -1)
            L60.setText("R");
        if (input.getBoardPos(7, 5) == -1)
            L61.setText("R");
        if (input.getBoardPos(7, 6) == -1)
            L62.setText("R");
        if (input.getBoardPos(7, 7) == -1)
            L63.setText("R");
               
        start = true;            
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JOptionPane.showMessageDialog(null,"Trabalho realizado por:\n- Felipe Prestes;\n- Gustavo Pinho;\n- Jean Antues.");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        clearText();
        if (start)
        {   astar = new Astar();
            astar.Astar(input);
        }
        else
            JOptionPane.showMessageDialog(null, "Por favor, gere um estado inicial antes de iniciar um algoritmo.");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        clearText();
        JOptionPane.showMessageDialog(null, "Lembrando que o Hill Climb não utiliza esse estado como start. O estado inicial utilizado será mostrado no log.");
        hillclimb = new HillClimb();
        hillclimb.HillClimb(iteration);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        clearText();
        if (start)
        {   simulatedannealing = new SimulatedAnnealing();
            simulatedannealing.SimulatedAnnealing(input);
        }
        else
            JOptionPane.showMessageDialog(null, "Por favor, gere um estado inicial antes de iniciar um algoritmo.");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        iteration = Integer.parseInt(JOptionPane.showInputDialog ("Digite um inteiro para o novo número de iterações do algoritmo Hill Climb:"));
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L0;
    private javax.swing.JLabel L1;
    private javax.swing.JLabel L10;
    private javax.swing.JLabel L11;
    private javax.swing.JLabel L12;
    private javax.swing.JLabel L13;
    private javax.swing.JLabel L14;
    private javax.swing.JLabel L15;
    private javax.swing.JLabel L16;
    private javax.swing.JLabel L17;
    private javax.swing.JLabel L18;
    private javax.swing.JLabel L19;
    private javax.swing.JLabel L2;
    private javax.swing.JLabel L20;
    private javax.swing.JLabel L21;
    private javax.swing.JLabel L22;
    private javax.swing.JLabel L23;
    private javax.swing.JLabel L24;
    private javax.swing.JLabel L25;
    private javax.swing.JLabel L26;
    private javax.swing.JLabel L27;
    private javax.swing.JLabel L28;
    private javax.swing.JLabel L29;
    private javax.swing.JLabel L3;
    private javax.swing.JLabel L30;
    private javax.swing.JLabel L31;
    private javax.swing.JLabel L32;
    private javax.swing.JLabel L33;
    private javax.swing.JLabel L34;
    private javax.swing.JLabel L35;
    private javax.swing.JLabel L36;
    private javax.swing.JLabel L37;
    private javax.swing.JLabel L38;
    private javax.swing.JLabel L39;
    private javax.swing.JLabel L4;
    private javax.swing.JLabel L40;
    private javax.swing.JLabel L41;
    private javax.swing.JLabel L42;
    private javax.swing.JLabel L43;
    private javax.swing.JLabel L44;
    private javax.swing.JLabel L45;
    private javax.swing.JLabel L46;
    private javax.swing.JLabel L47;
    private javax.swing.JLabel L48;
    private javax.swing.JLabel L49;
    private javax.swing.JLabel L5;
    private javax.swing.JLabel L50;
    private javax.swing.JLabel L51;
    private javax.swing.JLabel L52;
    private javax.swing.JLabel L53;
    private javax.swing.JLabel L54;
    private javax.swing.JLabel L55;
    private javax.swing.JLabel L56;
    private javax.swing.JLabel L57;
    private javax.swing.JLabel L58;
    private javax.swing.JLabel L59;
    private javax.swing.JLabel L6;
    private javax.swing.JLabel L60;
    private javax.swing.JLabel L61;
    private javax.swing.JLabel L62;
    private javax.swing.JLabel L63;
    private javax.swing.JLabel L7;
    private javax.swing.JLabel L8;
    private javax.swing.JLabel L9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
