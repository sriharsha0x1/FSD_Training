package com.example.studentdemo;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc =
                new Scanner(System.in);

        StudentDAO dao =
                new StudentDAO();

        while(true) {

            System.out.println("\n1.Add");

            System.out.println(
                    "2.Find By Id");

            System.out.println(
                    "3.Find All");

            System.out.println(
                    "4.Update");

            System.out.println(
                    "5.Delete");

            System.out.println(
                    "6.Exit");

            int ch =
                    sc.nextInt();

            switch(ch) {

            case 1:

                System.out.println(
                "Enter id name email course age:");

                int id =
                        sc.nextInt();

                String name =
                        sc.next();

                String email =
                        sc.next();

                String course =
                        sc.next();

                int age =
                        sc.nextInt();

                dao.save(

                new Student(

                id,

                name,

                email,

                course,

                age

                ));

                System.out.println(
                        "Student Added");

                break;

            case 2:

                System.out.println(
                        "Enter Id:");

                int searchId =
                        sc.nextInt();

                Student s =
                        dao.findById(
                                searchId);

                if(s!=null)

                    System.out.println(
                            s);

                else

                    System.out.println(
                    "Student Not Found");

                break;

            case 3:

                List<Student> students =

                        dao.findAll();

                for(Student st :

                    students)

                {

                    System.out.println(
                            st);

                }

                break;

            case 4:

                System.out.println(
                        "Enter Id:");

                int updateId =
                        sc.nextInt();

                Student st =
                        dao.findById(
                                updateId);

                if(st!=null)
                {

                    System.out.println(
                    "Enter New Name:");

                    st.setStudentName(
                            sc.next());

                    System.out.println(
                    "Enter New Email:");

                    st.setEmail(
                            sc.next());

                    System.out.println(
                    "Enter New Course:");

                    st.setCourse(
                            sc.next());

                    System.out.println(
                    "Enter New Age:");

                    st.setAge(
                            sc.nextInt());

                    dao.update(st);

                    System.out.println(
                            "Updated");

                }

                else

                    System.out.println(
                    "Student Not Found");

                break;

            case 5:

                System.out.println(
                        "Enter Id:");

                int deleteId =
                        sc.nextInt();

                dao.delete(deleteId);

                System.out.println(
                        "Deleted");

                break;

            case 6:

                Utility
                .getSessionFactory()
                .close();

                sc.close();

                System.exit(0);

            default:

                System.out.println(
                        "Invalid Choice");
            }

        }

    }

}