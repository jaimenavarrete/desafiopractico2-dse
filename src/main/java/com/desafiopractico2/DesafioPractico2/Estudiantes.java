package com.desafiopractico2.DesafioPractico2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Estudiantes")
public class Estudiantes  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "carnet", unique = true)
     private String carnet;
	
	@Column(name = "nombre", nullable = false)
     private String nombre;
	
	@Column(name = "apellido", nullable = false)
     private String apellido;
	
	@Column(name = "edad", nullable = false)
     private int edad;
	
	@Column(name = "email", nullable = false)
     private String email;
	
	@Column(name = "telefono", nullable = false)
     private String telefono;
	
	@Column(name = "materiasInscritas", nullable = false)
     private int materiasInscritas;

    public Estudiantes() {
    }

	
    public Estudiantes(String carnet, String nombre, String apellido, int edad, int materiasInscritas) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.materiasInscritas = materiasInscritas;
    }
    public Estudiantes(String carnet, String nombre, String apellido, int edad, String email, String telefono, int materiasInscritas) {
       this.carnet = carnet;
       this.nombre = nombre;
       this.apellido = apellido;
       this.edad = edad;
       this.email = email;
       this.telefono = telefono;
       this.materiasInscritas = materiasInscritas;
    }
   
    public String getCarnet() {
        return this.carnet;
    }
    
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public int getMateriasInscritas() {
        return this.materiasInscritas;
    }
    
    public void setMateriasInscritas(int materiasInscritas) {
        this.materiasInscritas = materiasInscritas;
    }
}