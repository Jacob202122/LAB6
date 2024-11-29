package domain;

public class ReplicateException extends Exception {
    public static final String OPTION_NAME_OPEN = "Open en construccion";
    public static final String OPTION_NAME_SAVE = "Save en construccion";
    public static final String OPTION_NAME_IMPORT = "Error al importar";
    public static final String OPTION_NAME_EXPORT = "Error al exportar";
    public static final String ERROR_FILE = "El archivo no existe";
    public static final String NOT_FOUND_FILE = "Archivo no encontrado";
    public static final String FUERA_DE_RANGO = "Fuera de rango en la linea: ";
    public static final String FORMAT_ERROR = "Error de formato en la linea: ";
    public static final String ERROR_POSITION = "Error de posición en la linea: ";
    public static final String INVALID_TYPE = "Tipo incorrecto en la linea: ";


    public ReplicateException(String message) {
        super(message);

    }
}
