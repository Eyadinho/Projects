//Eyad Kathir
// this code allows the user to perform image morphing between two images

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.util.Scanner;

public class MainMenu extends javax.swing.JFrame {
    private int rows = 1000, cols = 667;
    private int numImgs = 0; 
    int counter = 0;
    private File file1, file2;
    private int[] startingImg = new int[rows*cols*3];
    private int[] endingImg = new int[rows*cols*3];
    private int[] middleImg = new int[rows*cols*3];
    private int[][] imgList = new int[9][];

    public MainMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        file1Label = new javax.swing.JLabel();
        file2Label = new javax.swing.JLabel();

        fileName1 = new javax.swing.JTextField();
        fileName2 = new javax.swing.JTextField();

        button = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        quit = new javax.swing.JButton();

        numsLabel = new javax.swing.JLabel();
        imgNum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setText("Morphing Images");

        file1Label.setText("Starting Image:");

        button.setText("Choose Ending Image");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExecuted(evt);
            }
        });

        file2Label.setText("Ending Image:");

        button2.setText("Choose Starting Image");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2Executed(evt);
            }
        });

        numsLabel.setText("Num of Images:");

        imgNum.setText("9");

        button3.setText("Choose Number of Images");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3Executed(evt);
            }
        });

        submit.setText("Generate Morphing Sequences");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPressed(evt);
            }
        });

        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(titleLabel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(numsLabel)
                                    .addComponent(file1Label))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fileName1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(imgNum))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(file2Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fileName2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button)
                            .addComponent(button2)
                            .addComponent(button3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(submit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quit)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(titleLabel)
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numsLabel)
                    .addComponent(imgNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(file1Label)
                    .addComponent(fileName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(file2Label)
                    .addComponent(fileName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(quit))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int[] readTheFile(File file) throws IOException {
        
        Scanner scan1 = new Scanner(file);
        int position = 1;
        int[] startingImage = new int[rows*cols*3];
        
        while (scan1.hasNext()) {
            if(position <= 4){
              scan1.nextLine();
            }else
                startingImage[position-5]= scan1.nextInt();
               position++;
        }
        return startingImage;
    }
    public void imageMorphing(int start, int end) throws IOException {
        
        //middle array to hold averaged pixel values
        int middle = (start+end)/2; 
        //Assign starting/ending arrays to first/last arrays in imgList
        int[] startingImg = (int[])imgList[start];
        int[] endingImg = (int[])imgList[end];
        
//        for(int num1 : startingImg){
//            System.out.println(num1);
//        }
//        
        //Base case
        if(start + 1 == end){ return;}
        
        //Averaging images
        for (int i = 0; i < startingImg.length; i++) {
             middleImg[i] = (startingImg[i]+endingImg[i])/2;
        }
        
        counter++;
        imgList[middle] = middleImg;
        
//        for (int num : middleImg){
//            System.out.println(num);
//        }
       // Write file
        writeFile(middleImg,counter); 
        
        // Recursive call
        imageMorphing(start, middle);
        imageMorphing(middle, end);
    }
    
    private void writeFile(int[] arr, int count) throws IOException {
           
      try {
            String fileName = "image"+count+".PPM";
             File file = new File(fileName);
        if (file.createNewFile()) {
            
            System.out.println("File created: " + fileName);
            FileWriter mw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(mw);
            bw.append("P3 \n"+rows+" "+cols+"\n"+255);
            bw.newLine();
         
            for(int j=0;j<middleImg.length;j++){
                
               bw.append(Integer.toString(middleImg[j])+"\n");
            }
              bw.close();
//        for (int i = 0; i < middleImg.length; i++) {
//             mw.write(middleImg[i]);
//        }
            
        mw.close();
        
        System.out.println("Successfully wrote to the file.");
        
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error has occurred.");
      e.printStackTrace();
    }
    }
    private void button2Executed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        file1 = fileChooser.getSelectedFile();
        String f1Path=file1.getAbsolutePath();
        fileName1.setText(f1Path);
                                                                            
    }

    private void buttonExecuted(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        JFileChooser fileChooser2 = new JFileChooser();
        fileChooser2.showOpenDialog(null);
        file2 = fileChooser2.getSelectedFile();
        String f2Path=file2.getAbsolutePath();
        fileName2.setText(f2Path);
                                        
    }

    private void quitPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        System.exit(0);
    }

    private void submitPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
       
       try{

                imgList[0] = readTheFile(file1);
                imgList[8] = readTheFile(file2);
                
                imageMorphing(0,8);
            }catch(IOException e){
                e.printStackTrace();
            }

    }//GEN-LAST:event_submitActionPerformed

    private void button3Executed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed

        numImgs = Integer.parseInt(imgNum.getText());
        System.out.println(numImgs);
    }//GEN-LAST:event_button3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel file1Label;
    private javax.swing.JLabel file2Label;
    private javax.swing.JLabel numsLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField fileName1;
    private javax.swing.JTextField fileName2;
    private javax.swing.JTextField imgNum;
    private javax.swing.JButton button;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton quit;
    private javax.swing.JButton submit;

}
