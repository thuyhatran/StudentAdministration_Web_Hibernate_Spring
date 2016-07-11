
import Service.resultService;
import Service.studentService;
import Service.courseService;
import beans.Course;
import beans.Results;
import beans.ResultsPK;
import beans.Student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
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
        
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        
        Student student1 = new Student();
        Student meeting2 = new Student(2,"tata","toto");
        
        studentService stService = new studentService();
        courseService crsService = new courseService();
        resultService rlsService = new resultService();
        
//        student1 = stService.selectById(1);
//        
//        System.out.println(student1);
        
        //stService.insert(meeting2); 
//        resultService stResult = new resultService();
        
//         Student st6 = stService.selectById(6);
//        
// 
//        Course course3 = crsService.selectById(2);
//        //new category, need save to get the id first
//       
//        
//        System.out.println("session.save(course3) ");
//        //Course course3 = (Course)session.get(Course.class, 8);
//        
//        Results result6 = new Results();
//        
//        result6.setStudent(st6);
//        result6.setCourse(course3);
//        result6.setMark1(50);
//        result6.setMark2(80);
//        
//        rlsService.insert(result6);
//        
//          System.out.println("setMark1 ");
//          
//        st6.getResults().add(result6);
//        
//      stService.update(st6);
//        
//        System.out.println("    session.save(st6); ");
        
//       Student st = (Student) session.get(Student.class, 1);  



        Student st6 = stService.selectById(6);
//        
// 
      Course course = crsService.selectById(4);
//        //new category, need save to get the id first
//       

        ResultsPK resultPK = new ResultsPK();
        resultPK.setCourse(course);
        resultPK.setStudent(st6);
        
        Results result = rlsService.selectById(st6.getStudent_id(), course.getCourse_id());
        
        System.out.println("In Main: " +result);
        
        
       rlsService.delete(6, 4);
        st6.getResults().remove(result);
         course.getResults().remove(result);
        System.out.println("remove result");
        
        for (Results rls:st6.getResults())
            System.out.println("In Main: " +rls);
        
        stService.update(st6);
        crsService.update(course);
        rlsService.delete(6, 4);
         for (Results rls:st6.getResults())
            System.out.println("In Main After: " +rls);
         
        System.out.println("st6 update result");
        
//SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//         Results result6 = (Results) session.get(Results.class, resultPK, LockOptions.NONE);
//         System.out.println(result6);
//
//           session.delete(result6);
//     
////         Results result = rlsService.selectById(1, 1);
////         System.out.println(result);
//         
//         
////            String hql = "FROM Results "
////                + "where pk.student = " + st + " and pk.course = " + crs ;
////         
//////        String hql = "FROM Results "
//////                + "where student_id = " + st_id + " and course_id = " + crs_id ;
////        Query query = getCurrentSession().createQuery(hql);
////        List<Results> results = query.list();
////        
////        Results result = null;
////        
////        if (!(results.get(0)==null)){
////            result = results.get(0) ;      
////        }
//
//        
//         
//        
//        // stResult.insert(rs1);
////         Student st2 = stService.selectById(1);
////         st2.setResults((Set<Results>) rs1);
////         stService.update(st2);
//        
////resultService rslSer = new resultService();
////            rslSer.deleteStudent(5);
//         
////    Student student = (Student) session.get(Student.class, 2);
////        
////        System.out.println("Student name: " + student.getFirst_name());
////        
////        Set<Results> results = student.getResults();
////                            
////        for (Results rls:results){
////            System.out.println("mark1 : " + rls.getMark1());
////            System.out.println("mark2 : " + rls.getMark2());
////        }
//
//    
////       Student st4 = stService.selectById(4);
////       Course cr1 = crsService.selectById(1);
//       
////       Results rls1 = new Results(2,3,79,80);
////       rlsService.insert(rls1);
////       
////           System.out.println("Insert finished"); 
////           
////        Set<Results> results = new HashSet<Results>();
////        
////       results.add(rls1);
//////       
////       st4.setResults(results);
////       stService.update(st4);
//////        
//////      //  session.saveOrUpdate(st4);
////
////    results = st4.getResults();
////    
////    for (Results rls:results)
////        System.out.println(rls.getStudent_id() + "  " +rls.getMark1()+ " course_id " +rls.getCourse_id());
////
////     System.out.println("setResults finished" + results); 
//      
//        
////       String hql = "Select st, rls, crs from Student as st join st.results as rls join rls.course as crs" ;
////       Query query = session.createQuery(hql);  
////       List<Object[]> studentGrade = query.list();
////       
////       System.out.println("studentGrade size " + studentGrade.size()); 
//       
////        for (Object obj:studentGrade ){
////            
////            Object[] fields = (Object[]) obj;
////            
////            System.out.println("Student = " + fields[0]+ " (result = " + fields[1] + ")" + " (course = " + fields[2] + ")");
////
////        }
////               
////        String hql = "Select st.student_id,st.first_name,st.last_name, st.gender, "
////                + "crs.course_name, rls.mark1, rls.mark2 "
////                + "from Student as st join st.results as rls join rls.pk.course as crs";
////             
////      
////        Query query = session.createQuery(hql);  
////       List<Object[]> studentGrades = query.list();
////       
////       System.out.println("studentGrade size " + studentGrades.size()); 
////       
////        for (Object[] obj:studentGrades){
////            int student_id = (int)obj[0];
////            String first_name =  (String) obj[1];
////            String last_name =  (String) obj[2];
////            String gender = (String) obj[3];
////            String course_name = (String)obj[4];
////            int  mark1 = (int) obj[5];
////            int  mark2 = (int) obj[6];
////                
////           System.out.println("Student Grade = " + student_id + "  " + first_name 
////                   + "  " + last_name+ "  " + gender + "  " + course_name + "  " + mark1 + "  " + mark2);
////           
////          // System.out.println(obj);          
////        }
////        
//        
//
//     //  student1.getResults().add(rs1);
//       
////        
////        //session.save(rs1);
////        
////        
////        session.saveOrUpdate(student1);
////        session.save(meeting2);
////        
//       
//        
//        session.getTransaction().commit();
//
//        session.close();
//        
//        sessionFactory.close();
        
        
        
    }
    
}
