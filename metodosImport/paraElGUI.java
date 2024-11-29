private void optionImport() {
        aManufacturing.borrarCeldas();
        try{
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Importar");

            int selection = jFileChooser.showOpenDialog(this);
            if(selection == JFileChooser.APPROVE_OPTION){
                File selectedFile = jFileChooser.getSelectedFile();
                aManufacturing.import02(selectedFile);
                photo.repaint();
                JOptionPane.showMessageDialog(this, "Archivo importado");
            }
        } catch (ReplicateException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        } catch(Exception e){
            JOptionPane.showMessageDialog(this,"Ocurrió un error " + e.getMessage());
            e.printStackTrace();
        }
    }
