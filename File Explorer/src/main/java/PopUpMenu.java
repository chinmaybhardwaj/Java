import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class PopUpMenu extends JPopupMenu {

    private static final String backupLocation = System.getProperty("user.home") + "/Desktop/Backup/";

    private boolean running = true;
    int SLEEP_TIME = 1000;

    private JMenuItem copyItem;
    private JMenuItem moveItem;

    public PopUpMenu(File file){
        // Copy Menu Item
        copyItem = new JMenuItem("Backup to drive");
        copyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.out.println("Menu Pressed " + file.getName());
//                copyFileWithProgress(file);
                copyFile(file);
            }
        });
        // Move Menu Item
        moveItem = new JMenuItem("Move to drive");
        moveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.out.println("Menu Pressed " + file.getName());
                //
                moveFile(file);
            }
        });
        //
        add(copyItem);
        add(moveItem);
    }

    /**
     *  Set Progress Detail in Top panel label
    * */
    private void setDescription(String text){
        OuterFrame.mTopPanel.setDetailText(text);
//        OuterFrame.rePaintFrame();
    }


    /**
     * Copy File using File Input/Output Stream
    * */
    private void copyFileWithProgress(File filein){
        System.out.println("copying file");
        setDescription("Copying File");
        try {
            File copyDirectory = new File(backupLocation);
            if (!copyDirectory.exists()) {
                copyDirectory.mkdir();
            }
        }
        catch (Exception e){
            setDescription(e.getMessage());
        }

//        File filein  = new File("test.big");
        File fileout = new File(backupLocation + filein.getName());
        FileInputStream fin  = null;
        FileOutputStream fout = null;
        long length  = filein.length();
        long counter = 0;
        int r = 0;
        byte[] b = new byte[1024];
        try {
            fin  = new FileInputStream(filein);
            fout = new FileOutputStream(fileout);
            while( (r = fin.read(b)) != -1) {
                counter += r;
                double progress = 1.0 * counter / length;
                System.out.println(progress * 100 + "%");
                setDescription("Copying File: " + progress * 100 + "%");
                fout.write(b, 0, r);
            }
            setDescription("File copied successful!");
        }
        catch(Exception e){
            e.printStackTrace();
            setDescription(e.getMessage());
        }
    }


    /**
    *  Copy file and replace if already exists
    * */
    private void copyFile(File file){
        setDescription("Copying " + file.getName());

        // Create Directory if not Exist
        try {
            File copyDirectory = new File(backupLocation);
            if (!copyDirectory.exists()) {
                copyDirectory.mkdir();
            }
            Thread.sleep(1000);
        }
        catch (Exception e){
            setDescription(e.getMessage());
        }

        if(file.isDirectory()){
            // Copy Directory
            File copyDirectory = new File(backupLocation + file.getName());
            if (!copyDirectory.exists()) {
                copyDirectory.mkdirs();
            }

            Thread threadCopyDir = new Thread() {
                public void run() {
                    while (running) {
                        try {
                            try {
                                FileUtils.copyDirectory(file, copyDirectory);
                                setDescription( file.getName() + " copied successfully!");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                                setDescription(ex.getMessage());
                                running = false;
                            }

                            Thread.sleep(SLEEP_TIME);// So that other thread also
                            // get the chance to
                            // execute.
                            running = false;
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            setDescription(ex.getMessage());
                            running = false;
                        }
                    }
                }
            };
            threadCopyDir.start();
        }
        else {
            // Copy File
            /*Files.copy(file.toPath(),
                    (new File(backupLocation + file.getName())).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);*/

            Thread threadCopyFile = new Thread() {
                public void run() {
                    while (running) {
                        try {
                            try {
                                FileUtils.copyFile(file, new File(backupLocation + file.getName()));
                                setDescription(file.getName() + " copied successfully!");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                                setDescription(ex.getMessage());
                               running = false;
                            }

                            Thread.sleep(SLEEP_TIME);// So that other thread also
                            // get the chance to
                            // execute.
                            running = false;
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            setDescription(ex.getMessage());
                            running = false;
                        }
                    }
                }
            };
            threadCopyFile.start();
        }
    }

    /**
     *  Move file by renaming
     * */
    private void moveFile(File file){
        setDescription("Moving File");
        try {
            File copyDirectory = new File(backupLocation);
            if (!copyDirectory.exists()) {
                copyDirectory.mkdir();
            }
        }
        catch (Exception e){
            setDescription(e.getMessage());
        }

        try{
            if(file.renameTo(new File(backupLocation + file.getName()))){
                System.out.println( file.getName() + " moved successfully!");
                setDescription( file.getName() + " moved successful!");
            }else{
                System.out.println("Failed to move File: " +  file.getName());
                setDescription("Failed to move File: " +  file.getName());
            }
        }catch(Exception e){
            e.printStackTrace();
            setDescription(e.getMessage());
        }
    }
}