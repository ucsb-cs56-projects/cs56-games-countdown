public class SQLInjectionMG extends MiniGame
{
    SQLInjectionMG(long timer)
    {
        super(timer);
    };

    private String response;

    private static String[] possibleAnswers = {"a", "b", "c", "d"};

    //in terminal for now, so no gui yet
    protected void drawStuff()
    {
         class NewJPanel extends javax.swing.JPanel {

            /**
             * Creates new form NewJPanel
             */
            public NewJPanel() {
                initComponents();
            }

            @SuppressWarnings("unchecked")

            private void initComponents() {

                jScrollPane2 = new javax.swing.JScrollPane();
                jEditorPane1 = new javax.swing.JEditorPane();
                jPanel1 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTextArea1 = new javax.swing.JTextArea();
                jPanel2 = new javax.swing.JPanel();
                jFormattedTextField1 = new javax.swing.JFormattedTextField();

                jScrollPane2.setViewportView(jEditorPane1);

                jTextArea1.setColumns(20);
                jTextArea1.setRows(5);
                jScrollPane1.setViewportView(jTextArea1);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(94, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(13, Short.MAX_VALUE))
                );

                jFormattedTextField1.setText("Enter the injection!");
                jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jFormattedTextField1ActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(73, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(19, Short.MAX_VALUE))
                );
            }// </editor-fold>

            private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
            }


            // Variables declaration - do not modify
            private javax.swing.JEditorPane jEditorPane1;
            private javax.swing.JFormattedTextField jFormattedTextField1;
            private javax.swing.JPanel jPanel1;
            private javax.swing.JPanel jPanel2;
            private javax.swing.JScrollPane jScrollPane1;
            private javax.swing.JScrollPane jScrollPane2;
            private javax.swing.JTextArea jTextArea1;
            // End of variables declaration
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
        System.out.println("You've come across a website with a form for a username and password.\n" +
                "After further inspection, you were able to discover that how the website\n" +
                "stores and accesses its username and password:\n\n" + "uName = getRequestString('username');\n" +
                        "uPass = getRequestString('userpassword');\n\n" +
                "sql: 'SELECT * FROM Users WHERE Name = ' + uName + ' AND Pass = ' + uPass + '\n\n" +
                "To beat this challenge you need to login 'without' a username or password.");
    }

    protected void getInput()
    {

//        while (timer_ != 0)
//            validateInput();

    }

    protected void validateInput()
    {
//        player_won_ = false;
//        for (int i = 0; i < possibleAnswers.length(); i++)
//        {
//            if (possibleAnswers[i] == response)
//            {
//                player_won_ = true;
//                return;
//            }
//        }
//        if (!player_won_)
//        {
//            System.out.println("Incorrect. Please try again.");
//            getInput();
//        }
    }

    public void giveHint()
    {

    }

    public void decrementTimer()
    {

    }

    protected void miniGameWon(){}
}
