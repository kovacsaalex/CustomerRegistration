package fileChooser;

import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
 *
 * @author alexkovacs
 */
public class FileChooser {

    public String fileChooser() {
        JButton open = new JButton();
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new java.io.File("/Users/alexkovacs/Documents/xNetbeans/BigPicture/readFile"));
        fc.setDialogTitle("Fájl beolvasás");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
            //
        }

        return fc.getSelectedFile().getAbsolutePath();
    }

}
