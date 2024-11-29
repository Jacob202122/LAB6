public void export00(File file) throws ReplicateException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file));){

            for (int fila = 0; fila < SIZE; fila++) {
                for (int columna = 0; columna < SIZE; columna++) {
                    if (lattice[fila][columna] != null) {
                        bw.write("Posición (" + fila + ", " + columna + "): " + lattice[fila][columna].getClass().getSimpleName() + "\n");
                    }
                }
            }

        } catch (IOException e){
            throw new ReplicateException(ReplicateException.OPTION_NAME_EXPORT);
        }
    }
