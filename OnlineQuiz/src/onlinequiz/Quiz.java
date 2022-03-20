/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinequiz;
import java.sql.*;  
/**
 *
 * @author student
 */
public class Quiz extends javax.swing.JFrame {

    /**
     * Creates new form Quiz
     */
    public Quiz() {
        initComponents();
        buttonGroup = new javax.swing.ButtonGroup(); 
        option1Label.setActionCommand("1");
        option2Label.setActionCommand("2");
        option3Label.setActionCommand("3");
        option4Label.setActionCommand("4");
        buttonGroup.add(option1Label);
        buttonGroup.add(option2Label);
        buttonGroup.add(option3Label);
        buttonGroup.add(option4Label);
        flag = true;
        score = 0;
        displayQuestion(1);
        prevButton.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void displayQuestion(int queNum)
    {
        try
        {
            String connectString="jdbc:mysql://localhost:3306/onlinequiz";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(connectString,"root","");
            Statement st=con.createStatement();
            String query = "SELECT * FROM quiz where id ="+queNum;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            questionNumberLabel.setText(Integer.toString(queNum));
            while (rs.next())
             {
                questionArea.setText(rs.getString("question"));
                option1Label.setText(rs.getString("option1"));
                option2Label.setText(rs.getString("option2"));
                option3Label.setText(rs.getString("option3"));
                option4Label.setText(rs.getString("option4"));
                correctAnswer[queNum] = rs.getInt("correctoption");
             }
            con.close();
            
            
        }
        catch(Exception ex)
        {
            System.out.println("Error: "+ ex.getMessage());
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        option4Label = new javax.swing.JRadioButton();
        option3Label = new javax.swing.JRadioButton();
        option1Label = new javax.swing.JRadioButton();
        option2Label = new javax.swing.JRadioButton();
        nextButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        timerLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionArea = new javax.swing.JTextArea();
        questionNumberLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        answer = new int[11];
        for (int i=0; i<11; i++)
             answer[i] =0;
        correctAnswer = new int[11];
        for (int i=0; i<11; i++)
             correctAnswer[i] =0;
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        option4Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4LabelActionPerformed(evt);
            }
        });

        option3Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3LabelActionPerformed(evt);
            }
        });

        option1Label.setText("");
        option1Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1LabelActionPerformed(evt);
            }
        });

        option2Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2LabelActionPerformed(evt);
            }
        });

        nextButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
          
        prevButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prevButton.setText("Prev");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        finishButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        finishButton.setText("Finish Test");
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        questionArea.setEditable(false);
        questionArea.setColumns(20);
        questionArea.setRows(5);
        jScrollPane1.setViewportView(questionArea);

        questionNumberLabel.setText("1");

        jLabel1.setText("Time Left:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                 .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(option3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(option4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(option2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(questionNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(option1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(questionNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(option2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(164, 164, 164)
                    .addComponent(option1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(210, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void option4LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4LabelActionPerformed
        // TODO add your handling code here:
        //answer = 4;
    }//GEN-LAST:event_option4LabelActionPerformed

    private void option3LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3LabelActionPerformed
        // TODO add your handling code here:
        //answer = 3;
    }//GEN-LAST:event_option3LabelActionPerformed

    private void option1LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1LabelActionPerformed
        //answer = 1;// TODO add your handling code here:
    }//GEN-LAST:event_option1LabelActionPerformed

    private void option2LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2LabelActionPerformed
        //answer = 2;// TODO add your handling code here:
    }//GEN-LAST:event_option2LabelActionPerformed
    
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        questionNumber = Integer.parseInt(questionNumberLabel.getText());
        
        if(option1Label.isSelected() || option2Label.isSelected() || option3Label.isSelected() ||option4Label.isSelected())
        {
            answer[questionNumber] = Integer.parseInt(buttonGroup.getSelection().getActionCommand());
           
        }
        prevButton.setVisible(true);
        if(questionNumber < 10)
        {
            questionNumber=questionNumber+1;
            if(questionNumber==10)
                nextButton.setVisible(false);
            else
                nextButton.setVisible(true);
            displayQuestion(questionNumber);
            if(answer[questionNumber] !=0)
            {
                if(answer[questionNumber] == 1)
                {
                    option1Label.setSelected(true);
                }
                else if(answer[questionNumber] == 2)
                {
                    option2Label.setSelected(true);
                }
                else if(answer[questionNumber] == 3)
                {
                    option3Label.setSelected(true);
                }
                else if(answer[questionNumber] == 4)
                {
                    option4Label.setSelected(true);
                }
            }
            else
                buttonGroup.clearSelection();
        
        }
        else
        {
            calScore();
            displayScore();
        }
        
        
    }//GEN-LAST:event_nextButtonActionPerformed
    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        
        questionNumber = Integer.parseInt(questionNumberLabel.getText());
        
        if(questionNumber != 0)
        {
            //questionNumber = Integer.parseInt(questionNumberLabel.getText());
        
            if(option1Label.isSelected() || option2Label.isSelected() || option3Label.isSelected() ||option4Label.isSelected())
            {
                answer[questionNumber] = Integer.parseInt(buttonGroup.getSelection().getActionCommand());

            }
        }
        questionNumber-=1;
        buttonGroup.clearSelection();
        
        if(questionNumber==1)
                prevButton.setVisible(false);
            else
                prevButton.setVisible(true);
        if(answer[questionNumber] !=0)
        {
            if(answer[questionNumber] == 1)
            {
                option1Label.setSelected(true);
            }
            else if(answer[questionNumber] == 2)
            {
                option2Label.setSelected(true);
            }
            else if(answer[questionNumber] == 3)
            {
                option3Label.setSelected(true);
            }
            else if(answer[questionNumber] == 4)
            {
                option4Label.setSelected(true);
            }
        }
        if(questionNumber <= 10)
        {            
            displayQuestion(questionNumber);
        }
        else
        {
            displayScore();
        }
    }
    private void calScore()
    {
        score=0;
        for(int i=1; i<11; i++)
        {
            
            if((answer[i] == correctAnswer[i]) && (answer[i]!=0))
            {
                score = score+4;
                //System.out.println("corrct");
            }
            else if(answer[i] != 0 && ((answer[i] != correctAnswer[i])))
                score = score-1;
        }
        
    }
       private void displayScore()
       {
           questionArea.setText("Your Score is: "+score);
           questionNumberLabel.setText("");
           timerLabel.setText("");
           option1Label.setVisible(false);
           option2Label.setVisible(false);
           option3Label.setVisible(false);
           option4Label.setVisible(false);
           finishButton.setText("close");
           nextButton.setVisible(false);
           prevButton.setVisible(false);
       }
       private void finishTest()
       {
           
            questionNumber = Integer.parseInt(questionNumberLabel.getText());
            if(option1Label.isSelected() || option2Label.isSelected() || option3Label.isSelected() ||option4Label.isSelected())
            {
                answer[questionNumber] = Integer.parseInt(buttonGroup.getSelection().getActionCommand());

            }
            calScore();
            displayScore();
            timerLabel.setText( " 0 min 0 sec ");
                
        
        flag = false;
       }
    private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishButtonActionPerformed
        // TODO add your handling code here:
        if(finishButton.getText() == "close")
        {
            System.exit(0);            
        }
       
        finishTest();
            
    }//GEN-LAST:event_finishButtonActionPerformed
    public void tick()
    {
        sec = sec-1;
        if(sec == -1)
        {
            sec = 59;
            min = min-1;
        }
        if(min == -1)
        {
            min = 59;
            hour = hour-1;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
     
            Quiz obj = new Quiz();
                obj.setVisible(true);
                obj.min = 0;
                obj.sec=60;
                for(int i=60; i>=0; i--)
                {
                    if(obj.flag)
                    {
                         obj.timerLabel.setText(obj.min+"min "+obj.sec+"sec");
                        try
                        {
                            Thread.sleep(1000);
                            obj.tick();
                        }
                        catch(Exception e)
                        {
                            System.out.println("here");
                        }
                    }
                    else
                    {
                        obj.timerLabel.setText("0 min 0 sec");
                    }
                }
                obj.calScore();
                obj.displayScore();
                obj.timerLabel.setText(" 0 min 0 sec");
                    
       }
    private int answer[], correctAnswer[];
    private int score;
    private int hour=0, min = 20, sec=0, questionNumber = 1;
    private javax.swing.ButtonGroup buttonGroup;
    private String option1Display, option2Display, option3Display, option4Display, question;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton finishButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton prevButton;
    private javax.swing.JRadioButton option1Label;
    private javax.swing.JRadioButton option2Label;
    private javax.swing.JRadioButton option3Label;
    private javax.swing.JRadioButton option4Label;
    private javax.swing.JTextArea questionArea;
    private javax.swing.JLabel questionNumberLabel;
    private javax.swing.JLabel timerLabel;
    private boolean flag;
    // End of variables declaration//GEN-END:variables
}