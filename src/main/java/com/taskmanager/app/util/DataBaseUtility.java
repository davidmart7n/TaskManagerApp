package com.taskmanager.app.util;

import com.taskmanager.app.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DataBaseUtility {

    public static void main(String[] args) {
        // Crear la configuración de Hibernate desde el archivo hibernate.cfg.xml
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Carga configuración desde el archivo XML
                .addAnnotatedClass(Task.class) // Registra las clases de entidad
                .buildSessionFactory();

        // Crear una sesión de Hibernate
        try (Session session = factory.openSession()) {
            // Inicia la transacción
            session.beginTransaction();

            // Ejemplo: Crear una nueva tarea
            Task newTask = new Task();
            newTask.setName("Deberes");
            newTask.setDescription("Matemáticas");
            newTask.setStatus("PENDIENTE");
            newTask.setDueDate(java.time.LocalDate.now()); // Asignar fecha de vencimiento
            session.merge(newTask); // Guarda o actualiza la tarea
            System.out.println(newTask);

            // Ejemplo: Consultar todas las tareas
            List<Task> tasks = session.createQuery("FROM Task", Task.class).getResultList();
            tasks.forEach(task -> System.out.println(task));

            // Finaliza la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
