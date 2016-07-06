
import Service.resultService;
import Service.studentService;
import beans.Results;
import beans.Student;
import beans.StudentGradeTest;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thuyha
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Student meeting1 = new Student();
        Student meeting2 = new Student(2,"tata","toto");
        
        studentService stService = new studentService();
        meeting1 = stService.selectById(1);
        
        System.out.println(meeting1);
        
        //stService.insert(meeting2);
        
        
//        resultService stResult = new resultService();
//        
//        Results rs1 = new Results(1,1,70,90);
        
        //session.save(rs1);
        
        // stResult.insert(rs1);
//         Student st2 = stService.selectById(1);
//         st2.setResults((Set<Results>) rs1);
//         stService.update(st2);
        
//resultService rslSer = new resultService();
//            rslSer.deleteStudent(5);
         
//    Student student = (Student) session.get(Student.class, 2);
//        
//        System.out.println("Student name: " + student.getFirst_name());
//        
//        Set<Results> results = student.getResults();
//                            
//        for (Results rls:results){
//            System.out.println("mark1 : " + rls.getMark1());
//            System.out.println("mark2 : " + rls.getMark2());
//        }
        
        
        String hql = "from Student as st join st.results as rls  " ;
        Query query = session.createQuery(hql);  
       List<Object[]> studentGrade = query.list();
       
       System.out.println("studentGrade size " + studentGrade.size()); 
       
        for (Object ob:studentGrade ){
            
             System.out.println(ob.toString());

        }
        
        
        
       
        
     //  meeting1.getResults().add(rs1);
       
//        
//        //session.save(rs1);
//        
//        
//        session.saveOrUpdate(meeting1);
//        session.save(meeting2);
//        
       
        
        session.getTransaction().commit();

        session.close();
        
        sessionFactory.close();
        
        
        
    }
    
}
