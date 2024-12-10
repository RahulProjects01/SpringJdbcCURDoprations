package org.example;

import org.example.resources.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        String std_rollno = "10";
        String std_name = "Vishal";
        float std_marks = 98.787f;

        String insert_sql_query = "INSERT INTO student (rollno, name, marks) VALUES (?, ?, ?)";
        int count = jdbcTemplate.update(insert_sql_query, std_rollno, std_name, std_marks);

        if (count > 0) {
            System.out.println("Record inserted successfully.");
        } else {
            System.out.println("Record insertion failed.");
        }

        ((AnnotationConfigApplicationContext) context).close();
    }
}
