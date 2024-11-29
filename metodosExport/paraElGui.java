private void optionExport(){
        try{
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Exportar");

            int selection = jFileChooser.showOpenDialog(this);
            if(selection == JFileChooser.APPROVE_OPTION){
                File selectedFile = jFileChooser.getSelectedFile();
                aManufacturing.export01(selectedFile);
            }
        } catch (ReplicateException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
