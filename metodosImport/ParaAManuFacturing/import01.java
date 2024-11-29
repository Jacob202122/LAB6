public void import01(File file) throws ReplicateException {
        if(file == null){
            throw new ReplicateException(ReplicateException.ERROR_FILE);
        }
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;

            while ((line = br.readLine()) != null){
                String[] parts = line.split(":");
                String posicion = parts[0].trim();
                String[] pos = posicion.replace("Posición (", "").replace(")", "").split(", ");

                int fila = Integer.parseInt(pos[0].trim());
                int columna = Integer.parseInt(pos[1].trim());
                String type = parts[1].trim();
                if (type.equals("Cell")){
                    lattice[fila][columna] = new Cell(this, fila,columna, true);
                } else if (type.equals("TouristCells")){
                    lattice[fila][columna] = new TouristCells(this,fila,columna);
                } else if (type.equals("Poison")){
                    lattice[fila][columna] = new Poison(this,fila,columna);
                } else if(type.equals("twinsCell")){
                    lattice[fila][columna] = new TwinsCell(this,fila,columna);
                }
            }
        }catch (IOException e){
            throw new ReplicateException(ReplicateException.NOT_FOUND_FILE);
        }

    }
