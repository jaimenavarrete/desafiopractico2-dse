package com.desafiopractico2.DesafioPractico2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class Consultas {
	public static EntityManager entidad;
	
	public static void agregarEstudiante() {
		Estudiantes estudiante = new Estudiantes();
		
		estudiante.setCarnet(JOptionPane.showInputDialog(null, "Digite el carnet: "));
		estudiante.setNombre(JOptionPane.showInputDialog(null, "Digite el nombre: "));
		estudiante.setApellido(JOptionPane.showInputDialog(null, "Digite el apellido: "));
		estudiante.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la edad: ")));
		estudiante.setEmail(JOptionPane.showInputDialog(null, "Digite el email: "));
		estudiante.setTelefono(JOptionPane.showInputDialog(null, "Digite el teléfono: "));
		estudiante.setMateriasInscritas(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de materias inscritas: ")));

		entidad.getTransaction().begin();
		entidad.persist(estudiante);
		entidad.getTransaction().commit();
		
		JOptionPane.showMessageDialog(null, "Estudiante registrado..");
	}
	
	public static void verEstudiantes() {
		List<Estudiantes> lstEstudiantes= new ArrayList<Estudiantes>();
		Query query= entidad.createQuery("SELECT e FROM Estudiantes e");
		
		lstEstudiantes = query.getResultList();
		
		int i = 1;
		for (Estudiantes e : lstEstudiantes) {
			JOptionPane.showMessageDialog(null, "Estudiante #" + i + "\n\n"
					+ "Carnet: " + e.getCarnet() + "\n"
					+ "Nombre: " + e.getNombre() + "\n"
					+ "Apellido: " + e.getApellido() + "\n"
					+ "Edad: " + e.getEdad() + "\n"
					+ "Email: " + e.getEmail() + "\n"
					+ "Telefono: " + e.getTelefono() + "\n"
					+ "Materias inscritas: " + e.getMateriasInscritas() + "\n");
			
			i++;
		}
	}
	
	public static void editarEstudiante() {
		String carnet = JOptionPane.showInputDialog(null, "Ingrese el carnet del estudiante a editar: ");
		Estudiantes estudiante = entidad.find(Estudiantes.class, carnet);

		estudiante.setNombre(JOptionPane.showInputDialog(null, "Digite el nombre: "));
		estudiante.setApellido(JOptionPane.showInputDialog(null, "Digite el apellido: "));
		estudiante.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la edad: ")));
		estudiante.setEmail(JOptionPane.showInputDialog(null, "Digite el email: "));
		estudiante.setTelefono(JOptionPane.showInputDialog(null, "Digite el teléfono: "));
		estudiante.setMateriasInscritas(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de materias inscritas: ")));

		entidad.getTransaction().begin();
		entidad.merge(estudiante);
		entidad.getTransaction().commit();
		
		JOptionPane.showMessageDialog(null, "Estudiante editado..");
	}
	
	public static void eliminarEstudiante() {
		String carnet = JOptionPane.showInputDialog(null, "Ingrese el carnet del estudiante a eliminar: ");
		Estudiantes estudiante = entidad.find(Estudiantes.class, carnet);
		
		if (estudiante != null) {
			entidad.getTransaction().begin();
			entidad.remove(estudiante);
			entidad.getTransaction().commit();
			
			JOptionPane.showMessageDialog(null, "Estudiante eliminado..");
		} else {
			JOptionPane.showMessageDialog(null, "Estudiante no encontrado..");
		}
	}
	
	public static void cerrar() {
		entidad.close();HibernateUtil.shutdown();
	}
}
