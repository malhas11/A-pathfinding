package astar;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import astar.mapSpots.MapSpot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saadm
 */
public class theMain extends javax.swing.JFrame {

    /**
     * Creates new form theMain
     */
      boolean hasonce = false;        //booleans for number of clicks
    boolean hastwice = true;
    final int grid_size = 20;
    private JButton[][] squares;        //buttons for the grid view
    private Color[] colors;
    private double[][] puzzle = { {1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1},
                                  {3,3,1,3,1,1,1,2,2,2,2,2,2,1,1,1,1,1,1,1},
                                  {3,3,3,3,3,3,1,1,2,3,3,3,2,1,1,1,1,1,1,1},
                                  {3,3,3,3,3,3,1,1,2,3,3,3,3,2,1,1,1,1,1,1},
                                  {1,1,3,1,1,1,1,1,2,2,3,3,3,2,1,1,2,2,1,1},
                                  {1,3,3,1,2,2,1,1,1,2,2,2,2,2,1,2,2,2,1,1},
                                  {3,2,1,1,2,2,1,1,1,1,1,1,1,1,1,2,2,1,1,1},
                                  {1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3},
                                  {1,1,2,3,3,2,2,1,1,1,1,1,1,1,1,1,1,3,3,3},
                                  {1,2,3,3,3,3,2,2,1,1,1,1,3,3,3,3,3,3,3,1},
                                  {1,2,3,2,2,2,3,2,3,1,1,1,3,3,3,3,1,1,1,1},
                                  {1,2,2,1,1,1,3,3,3,3,1,1,3,3,3,1,1,1,1,1},
                                  {1,1,3,3,3,3,3,3,3,3,1,1,1,1,1,1,1,1,1,1},
                                  {3,3,3,3,3,3,3,3,3,1,1,4,1,1,1,1,1,1,1,4},
                                  {1,1,3,3,3,3,1,1,1,2,2,4,4,1,1,1,1,1,1,4},
                                  {1,1,1,1,1,1,1,1,1,1,2,1,4,4,4,1,1,4,4,4},
                                  {1,2,2,2,2,2,1,1,1,2,1,1,1,4,4,4,4,4,4,4},
                                  {2,2,1,1,1,1,1,1,1,1,1,1,1,4,4,4,4,4,4,4},
                                  {1,1,1,1,1,1,1,1,1,1,1,4,4,4,4,4,4,4,4,4},
                                  {1,1,1,1,1,1,1,1,1,1,1,4,4,4,4,4,4,4,4,4}}; // this is the grid view! 
    
    private spot start;             //the start end and current positions
    private spot end;
    private spot current;
    private int x;
    private int y;
    
    public theMain() {
        initComponents();
        initGUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gridMap = new javax.swing.JPanel();
        StartLabel = new javax.swing.JLabel();
        EndLabel = new javax.swing.JLabel();
        modeSelection = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gridMap.setName("gridMap"); // NOI18N
        gridMap.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout gridMapLayout = new javax.swing.GroupLayout(gridMap);
        gridMap.setLayout(gridMapLayout);
        gridMapLayout.setHorizontalGroup(
            gridMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        gridMapLayout.setVerticalGroup(
            gridMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        StartLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        EndLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        modeSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhattan", "Euclidean", "Chebyshev" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(661, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EndLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modeSelection, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StartLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(gridMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(289, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(StartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EndLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(modeSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(gridMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(theMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(theMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(theMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(theMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new theMain().setVisible(true);
            }
        });
    }
       private void initGUI() {
        start = new spot(0, 0);
        end = new spot(0, 0);
        current = new spot(0, 0);
        
        colors = new Color[4];
        colors[0] = Color.decode("#f4f2f5");//6a686
        colors[1] = Color.decode("#9c9898");
        colors[2] = Color.decode("#6a6868");            //colors for buttons different depends on the value
        colors[3] = Color.decode("#12110e");
        
        GridLayout gridLayout = new GridLayout(20, 20);

        gridMap.setLayout(gridLayout);
        gridMap.setBackground(Color.DARK_GRAY);
        squares = new JButton[grid_size][grid_size];
        
        for(int i = 0; i < grid_size; i++){
            for(int j = 0; j < grid_size; j++){     //for loop for creating the grid in the frame and adding the buttons
                squares[i][j] = new JButton();
            //    vertices[i][j].putClientProperty("col", i);
             //   vertices[i][j].putClientProperty("row", j);
               // vertices[i][j].addActionListener(new myActionListener());

          //      viewGrid[i][j] = new spot(i, j);
             //   cp.add(vertices[i][j]);
                 if(puzzle[i][j] == 1){
                   squares[i][j].setBackground(colors[0]);
                 
               } else if(puzzle[i][j] == 2){
                   squares[i][j].setBackground(colors[1]);
                  
               } else if(puzzle[i][j] == 3){
                   squares[i][j].setBackground(colors[2]);
                  
               } else if(puzzle[i][j] == 4){
                   squares[i][j].setBackground(colors[3]);
               }
                 gridMap.add(squares[i][j]);
            }
        }
    
        
        for (int i = 0; i < grid_size; i++) {
            for (int j = 0; j < grid_size; j++) {
                squares[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {           //action listener for the buttons
                        Point point = ((JButton)ae.getSource()).getLocation();
                        current = new spot((int) (point.x / 25), (int) (point.y / 25));
                        if (hasonce == false){
                            hasonce = true;
                            hastwice = true;
                        
                            start();
                        } else {
                            if(hastwice == true){
                                end();
                            }
                        }
                    }
                });
            }
        }
        
        
      
        
       
    }
    public void start(){
            start = current;
                StartLabel.setText(start.x + ", " + start.y);       //getting start and end under it
                squares[start.y][start.x].setBackground(Color.RED);         
    }
    public void end(){
         end = current;
                EndLabel.setText(end.x + ", " + end.y);
                squares[end.y][end.x].setBackground(Color.BLUE);            
                run();
    }
    public void run(){
        mapSpots map = new mapSpots(puzzle, false);
                int route = modeSelection.getSelectedIndex();
                List<MapSpot> path = map.findPath(start.x, start.y, end.x, end.y, route);         //when second button is clicked then the program runs the algorithm first
                
                Color squareColor = Color.RED;                                                          ///then adding the path 
                if (route == 0) {
                    squareColor = Color.RED;
                } else if (route == 1) {
                    squareColor = Color.BLUE;
                } else {
                    squareColor = Color.GREEN;
                }
                for (int i = 0; i < path.size(); i++) {
                    
                    squares[path.get(i).getY()][path.get(i).getX()].setBackground(squareColor);
                }
    }
 
    
    class spot {
        public int x;
        public int y;
        public spot() {
            x = 0;
            y = 0;          //this is the position
        }
        public spot(int i, int j) {
            x = i;
            y = j;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EndLabel;
    private javax.swing.JLabel StartLabel;
    private javax.swing.JPanel gridMap;
    private javax.swing.JComboBox<String> modeSelection;
    // End of variables declaration//GEN-END:variables
}
