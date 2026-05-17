public class Profesor extends Persona {
    private String telefono;
    //Codigo de la materia que dicta el profesor
    private String codigoMateria;

    public Profesor(String nombre, String id, String email, String telefono, String codigoMateria) {
        super(nombre, id, email);
        this.telefono = telefono;
        this.codigoMateria = null; //Sin materia asignada
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    @Override
    public void mostrarInformacion(){
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Email: " + getEmail());
        System.out.println("Telefono: " + getTelefono());

        if(codigoMateria != null){
            System.out.println("Materia: " + codigoMateria);
        } else{
            System.out.println("Materia: (Sin asignar)");
        }
    }

    
}
