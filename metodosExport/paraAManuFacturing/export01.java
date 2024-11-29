public void export01(File file) throws ReplicateException {
        if(file == null){
            throw new ReplicateException(ReplicateException.ERROR_FILE);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file));){

            for (int fila = 0; fila < SIZE; fila++) {
                for (int columna = 0; columna < SIZE; columna++) {
                    if (lattice[fila][columna] != null) {
                        bw.write("Posición (" + fila + ", " + columna + "): " + lattice[fila][columna].getClass().getSimpleName() + "\n");
                    }
                }
            }

        } catch (IOException e){
            throw new ReplicateException(ReplicateException.NOT_FOUND_FILE);
        }
    }
