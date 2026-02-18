
public class Clase {
    
    private int id;
    private String curso;
    private String profesor;
    private int estudiantes;

    public Clase(int id, String curso, String profesor, int estudiantes) {
        this.id = id;
        this.curso = curso;
        this.profesor = profesor;
        this.estudiantes = estudiantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(int estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Clase [id=" + id + ", curso=" + curso + ", profesor=" + profesor + ", estudiantes=" + estudiantes + "]";
    }
    
    
}
