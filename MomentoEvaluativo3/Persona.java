public abstract class Persona {
    private String nombre;
    private String id;
    private String email;
    
    public Persona(String nombre, String id, String email) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//Metodo abstracto que cada subclase debe sobreescribir
    public abstract void mostrarInformacion();
    
}
