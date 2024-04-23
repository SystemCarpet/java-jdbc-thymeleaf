package co.edu.sena.credifamiliacf.model;

import java.time.LocalDate;

public class Client {
    // Atributos (propiedades)
    private int numeroDocumento; // Llave primaria
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private City ciudad;
    private String correoElectronico;
    private String telefono;
    private String ocupacion; // Empleado, Independiente, Pensionado
    private Boolean viabilidad;

    // Constructor
    public  Client(){};
    public Client(int numeroDocumento, String nombre, String apellidos, LocalDate fechaNacimiento,
                  City ciudad, String correoElectronico, String telefono, String ocupacion) {
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.ocupacion = ocupacion;
    }

    public Boolean getViabilidad() {
        return viabilidad;
    }

    public void setViabilidad(Boolean viabilidad) {
        this.viabilidad = viabilidad;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public City getCiudad() {
        return ciudad;
    }

    public void setCiudad(City ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    //crud
}
