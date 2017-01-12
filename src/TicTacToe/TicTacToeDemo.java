/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import accessories.Node;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author Rahul
 */


/*  1 = X
    -1 = O
    0 = not filled yet

    1 = human turn
    2 = ai turn

    1 = X = human win
    -1 = O = ai win

in context to ai
    1 = win
    0 = draw
    -1 = lost

depth starts at 1
odd depth = human turn
even depth = ai turn

*/


public class TicTacToeDemo extends javax.swing.JFrame {
    
    boolean value = true;
    boolean[][] clicked = new boolean[3][3];
    int depth = 1;
    JButton[][] btnList;
    
    {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                clicked[i][j]=false;
            }
        }
    }
    
    /**
     * Creates new form TicTacToeDemo
     */
    public TicTacToeDemo() {
        initComponents();
        btnList = new JButton[3][3];
        btnList[0][0] = btn11;
        btnList[0][1] = btn12;
        btnList[0][2] = btn13;
        btnList[1][0] = btn21;
        btnList[1][1] = btn22;
        btnList[1][2] = btn23;
        btnList[2][0] = btn31;
        btnList[2][1] = btn32;
        btnList[2][2] = btn33;
        
  
    }
    
    public int[][] getGameState(){
        int [][]arr = new int[3][3];
        arr[0][0] = getBtnValue(btn11);
        arr[0][1] = getBtnValue(btn12);
        arr[0][2] = getBtnValue(btn13);
        arr[1][0] = getBtnValue(btn21);
        arr[1][1] = getBtnValue(btn22);
        arr[1][2] = getBtnValue(btn23);
        arr[2][0] = getBtnValue(btn31);
        arr[2][1] = getBtnValue(btn32);
        arr[2][2] = getBtnValue(btn33);
        return arr;
    }
    
    public void setGameState(int[][] gstate){
        depth++;
        int[][] arr = getGameState();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(arr[i][j]!=gstate[i][j]){
                    btnList[i][j].setText(value ? "X" : "O");
                    clicked[i][j]=true;
                    value = !value;
                    if(check()){
                        JOptionPane.showMessageDialog(this,(value? "O": "X") + " IS THE WINNER!! :D");
                        for(int a=0;a<3;a++){
                            for(int b=0;b<3;b++){
                                clicked[a][b]=true;
                            }
                        }
                    }
                    else{
                        checkDraw();
                    }
                }
            }
        }
        
    }
    
    public int getBtnValue(JButton btn){
       if(btn.getText().equals("X"))
           return 1;
       else if(btn.getText().equals("O"))
           return -1;
       else
            return 0;
    }
    
    public boolean check(){
        return (btn11.getText().equals(btn22.getText()) && btn11.getText().equals(btn33.getText()) && !btn11.getText().equals("")) || (btn11.getText().equals(btn12.getText()) && btn11.getText().equals(btn13.getText()) && !btn11.getText().equals("")) || (btn11.getText().equals(btn21.getText()) && btn11.getText().equals(btn31.getText()) && !btn11.getText().equals("")) || (btn21.getText().equals(btn22.getText()) && btn21.getText().equals(btn23.getText()) && !btn21.getText().equals("")) || (btn31.getText().equals(btn32.getText()) && btn31.getText().equals(btn33.getText()) && !btn31.getText().equals("")) || (btn12.getText().equals(btn22.getText()) && btn12.getText().equals(btn32.getText()) && !btn32.getText().equals("")) || (btn13.getText().equals(btn33.getText()) && btn13.getText().equals(btn23.getText()) && !btn23.getText().equals("")) || (btn13.getText().equals(btn22.getText()) && btn13.getText().equals(btn31.getText()) && !btn31.getText().equals(""));
    }
    
    public void checkDraw(){
        boolean temp=true;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(clicked[i][j]==false){
                    temp=false;
                    break;
                }
            }
        }
        if(temp){
            JOptionPane.showMessageDialog(this, "THE MATCH WAS A DRAW! ;)");
            
        }
    }
    
    public void resetUI(){
        depth=1;
        value = true;
         for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                clicked[i][j]=false;
            }
        }
        btn11.setText("");
        btn12.setText("");
        btn13.setText("");
        btn21.setText("");
        btn22.setText("");
        btn23.setText("");
        btn31.setText("");
        btn32.setText("");
        btn33.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        btn23 = new javax.swing.JButton();
        btn31 = new javax.swing.JButton();
        btn32 = new javax.swing.JButton();
        btn33 = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAIChance = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn11.setName("btn11"); // NOI18N
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });

        btn12.setName("btn12"); // NOI18N
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });

        btn13.setName("btn13"); // NOI18N
        btn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn13ActionPerformed(evt);
            }
        });

        btn21.setName("btn21"); // NOI18N
        btn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn21ActionPerformed(evt);
            }
        });

        btn22.setName("btn22"); // NOI18N
        btn22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn22ActionPerformed(evt);
            }
        });

        btn23.setName("btn33"); // NOI18N
        btn23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn23ActionPerformed(evt);
            }
        });

        btn31.setName("btn31"); // NOI18N
        btn31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn31ActionPerformed(evt);
            }
        });

        btn32.setName("btn32"); // NOI18N
        btn32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn32ActionPerformed(evt);
            }
        });

        btn33.setName("btn33"); // NOI18N
        btn33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn33ActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        jLabel1.setText("                     TIC TAC TOE");

        btnAIChance.setText("AI");
        btnAIChance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAIChanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnQuit))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAIChance, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn23, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn31, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn32, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn33, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn13, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnQuit)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAIChance, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        
        if(clicked[0][0]==false){
            value=!value;
            if(value){
                btn11.setText("O");
            }
            else{
                btn11.setText("X");
            }
            if(check()){
                JOptionPane.showMessageDialog(this, btn11.getText()+" IS THE WINNER!! :D");
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        clicked[i][j]=true;
                    }
                }
                return;
            }
                clicked[0][0]=true;
                checkDraw();
                depth++;
                int gstate[][] = getGameState();
                Node tree = new Node(gstate, depth);
                setGameState(tree.getBestNode().getGamestate());
        }
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        
        if(clicked[0][1]==false){
            value=!value;
            if(value){
                btn12.setText("O");
            }
            else{
                btn12.setText("X");
            }
            if(check()){
                JOptionPane.showMessageDialog(this, btn12.getText()+" IS THE WINNER!! :D");
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        clicked[i][j]=true;
                    }
                }
                return;
            }
            clicked[0][1]=true;
            checkDraw();
            depth++;
            int gstate[][] = getGameState();
            Node tree = new Node(gstate, depth);
            setGameState(tree.getBestNode().getGamestate());
        }
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed
        
        if(clicked[1][0]==false){
            value=!value;
            if(value){
                btn21.setText("O");
            }
            else{
                btn21.setText("X");
            }
            if(check()){
                JOptionPane.showMessageDialog(this, btn21.getText()+" IS THE WINNER!! :D");
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        clicked[i][j]=true;
                    }
                }
                return;
            }
            clicked[1][0]=true;
            checkDraw();
            
            int gstate[][] = getGameState();
            depth++;
            Node tree = new Node(gstate, depth);
            setGameState(tree.getBestNode().getGamestate());
        }
    }//GEN-LAST:event_btn21ActionPerformed

    private void btn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn13ActionPerformed
        
        if(clicked[0][2]==false){
            value=!value;
            if(value){
                btn13.setText("O");
            }
            else{
                btn13.setText("X");
            }
            if(check()){
                JOptionPane.showMessageDialog(this, btn13.getText()+" IS THE WINNER!! :D");
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        clicked[i][j]=true;
                    }
                }
                return;
            }
            clicked[0][2]=true;
            checkDraw();
            int gstate[][] = getGameState();
            depth++;
            Node tree = new Node(gstate, depth);
            setGameState(tree.getBestNode().getGamestate());
        }
    }//GEN-LAST:event_btn13ActionPerformed

    private void btn22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn22ActionPerformed
        
        if(clicked[1][1]==false){
            value=!value;
            if(value){
                btn22.setText("O");
            }
            else{
                btn22.setText("X");
            }
            if(check()){
                JOptionPane.showMessageDialog(this, btn22.getText()+" IS THE WINNER!! :D");
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        clicked[i][j]=true;
                    }
                }
                return;
            }
            clicked[1][1]=true;
            checkDraw();
            int gstate[][] = getGameState();
            depth++;
            Node tree = new Node(gstate, depth);
            setGameState(tree.getBestNode().getGamestate());
        }
    }//GEN-LAST:event_btn22ActionPerformed

    private void btn23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn23ActionPerformed
        
        if(clicked[1][2]==false){
            value=!value;
            if(value){
                btn23.setText("O");
            }
            else{
                btn23.setText("X");
            }
            if(check()){
                JOptionPane.showMessageDialog(this, btn23.getText()+" IS THE WINNER!! :D");
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        clicked[i][j]=true;
                    }
                }
                return;
            }
            clicked[1][2]=true;
            checkDraw();
            int gstate[][] = getGameState();
            depth++;
            Node tree = new Node(gstate, depth);
            setGameState(tree.getBestNode().getGamestate());
        }
    }//GEN-LAST:event_btn23ActionPerformed

    private void btn31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn31ActionPerformed
        
        if(clicked[2][0]==false){
            value=!value;
            if(value){
                btn31.setText("O");
            }
            else{
                btn31.setText("X");
            }
            if(check()){
                JOptionPane.showMessageDialog(this, btn31.getText()+" IS THE WINNER!! :D");
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        clicked[i][j]=true;
                    }
                }
                return;
            }
            clicked[2][0]=true;
            checkDraw();
            int gstate[][] = getGameState();
            depth++;
            Node tree = new Node(gstate, depth);
            setGameState(tree.getBestNode().getGamestate());
        }
    }//GEN-LAST:event_btn31ActionPerformed

    private void btn32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn32ActionPerformed
        
        if(clicked[2][1]==false){
            value=!value;
            if(value){
                btn32.setText("O");
            }
            else{
                btn32.setText("X");
            }
            if(check()){
                JOptionPane.showMessageDialog(this, btn32.getText()+" IS THE WINNER!! :D");
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        clicked[i][j]=true;
                    }
                }
                return;
            }
            clicked[2][1]=true;
            checkDraw();
            int gstate[][] = getGameState();
            depth++;
            Node tree = new Node(gstate, depth);
            setGameState(tree.getBestNode().getGamestate());
        }
    }//GEN-LAST:event_btn32ActionPerformed

    private void btn33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn33ActionPerformed
        
        if(clicked[2][2]==false){
            value=!value;
            if(value){
                btn33.setText("O");
            }
            else{
                btn33.setText("X");
            }
            if(check()){
                JOptionPane.showMessageDialog(this, btn33.getText()+" IS THE WINNER!! :D");
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        clicked[i][j]=true;
                    }
                }
                return;
            }
            clicked[2][2]=true;
            checkDraw();
            int gstate[][] = getGameState();
            depth++;
            Node tree = new Node(gstate, depth);
            setGameState(tree.getBestNode().getGamestate());
        }
    }//GEN-LAST:event_btn33ActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        
        int choice=JOptionPane.showConfirmDialog(this, "Are you sure you want to quit ?","ExitDialogBox",0);
        if(choice==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        
        resetUI();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAIChanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAIChanceActionPerformed
        // TODO add your handling code here:
        if(depth==1){
            int gstate[][] = getGameState();
            Node tree = new Node(gstate, depth);
            setGameState(tree.getBestNode().getGamestate());
        }else{
            for(int i=0;i<2;i++){
                int gstate[][] = getGameState();
                Node tree = new Node(gstate, depth);
                setGameState(tree.getBestNode().getGamestate());
            }
        }
    }//GEN-LAST:event_btnAIChanceActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btn23;
    private javax.swing.JButton btn31;
    private javax.swing.JButton btn32;
    private javax.swing.JButton btn33;
    private javax.swing.JButton btnAIChance;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
