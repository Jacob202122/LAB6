public void import02(File file) throws ReplicateException {
        if(file == null){
            throw new ReplicateException(ReplicateException.ERROR_FILE);
        }

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(":");

                if (parts.length != 2) {
                    throw new ReplicateException(ReplicateException.FORMAT_ERROR + line);
                }
                String posicion = parts[0].trim();
                String[] pos = posicion.replace("Posición (", "").replace(")", "").split(", ");

                if (pos.length != 2) {
                    throw new ReplicateException(ReplicateException.ERROR_POSITION + line);
                }

                int fila = Integer.parseInt(pos[0].trim());
                int columna = Integer.parseInt(pos[1].trim());

                if (fila < 0 || fila >= SIZE || columna < 0 || columna >= SIZE) {
                    throw new ReplicateException( ReplicateException.FUERA_DE_RANGO + "(" + fila + ", " + columna + ")");
                }

                String type = parts[1].trim();
                if (type.equals("Cell")){
                    lattice[fila][columna] = new Cell(this, fila,columna, true);
                } else if (type.equals("TouristCells")){
                    lattice[fila][columna] = new TouristCells(this,fila,columna);
                } else if (type.equals("Poison")){
                    lattice[fila][columna] = new Poison(this,fila,columna);
                } else if(type.equals("twinsCell")){
                    lattice[fila][columna] = new TwinsCell(this,fila,columna);
                } else{
                    throw new ReplicateException(ReplicateException.INVALID_TYPE + type);
                }
            }
        }catch (IOException e){
            throw new ReplicateException(ReplicateException.OPTION_NAME_IMPORT);
        }

    }
