package com.desafiopractico2.DesafioPractico2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class MainApp {	
	public static void main(String[] args) {
		Consultas.entidad = HibernateUtil.getEntityManagerFactory().createEntityManager();
		
		int opcion = 0;
		
		while (opcion != 5) {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Crear estudiante \n"
					+ "2. Ver estudiantes \n"
					+ "3. Actualizar estudiante \n"
					+ "4. Eliminar estudiante \n"
					+ "5. Salir \n"
					+ "Elija la opción a realizar: "));
			
			switch (opcion) {
				case 1:
						Consultas.agregarEstudiante();
					break;
				case 2:
						Consultas.verEstudiantes();
					break;
				case 3:
						Consultas.editarEstudiante();
					break;
				case 4:
						Consultas.eliminarEstudiante();
					break;
				case 5:
						Consultas.cerrar();
					break;
	
				default:
					JOptionPane.showMessageDialog(null, "Opción no válida");
					break;
			}
		}
		
		Consultas.entidad.close();
	}
	
	
}
