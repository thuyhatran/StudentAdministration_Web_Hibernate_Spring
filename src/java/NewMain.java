
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
* TEST FILE - for test only
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
//        
        Student student1 = new Student();
       
        
        studentService stService = new studentService();
        courseService crsService = new courseService();
        resultService rlsService = new resultService();
        
//        student1 = stService.selectById(2);
//        
//        System.out.println(student1);
        




//        Student st6 = stService.selectById(2);
////        
//// 
//      Course course = crsService.selectById(3);
////        //new category, need save to get the id first
////       
//
//        ResultsPK resultPK = new ResultsPK();
//        resultPK.setCourse(course);
//        resultPK.setStudent(st6);
//        
//        Results result = rlsService.selectById(st6.getStudent_id(), course.getCourse_id());
//        
//        System.out.println("In Main: " +result);
//        
//        
//      //rlsService.delete(6, 4);
//        st6.getResults().remove(result);
//       // course.getResults().remove(result);
//        System.out.println("remove result");
//        
//        for (Results rls:st6.getResults())
//            System.out.println("In Main: " +rls);
//        
//        stService.update(st6);
//        //crsService.update(course);
//        //rlsService.delete(2, 3);
//         for (Results rls:st6.getResults())
//            System.out.println("In Main After: " +rls);
//         
//        System.out.println("st6 update result");

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
        String hql = "Select st.student_id,st.first_name,st.last_name, st.gender, "
                + "crs.course_name,  rls.mark1, rls.mark2 "
                + "from Student as st left outer join  st.results as rls  left join rls.pk.course as crs"
                + " where st.student_id = 5";
             
      
       Query query = session.createQuery(hql);  
       List<Object[]> studentGrades = query.list();
       
       System.out.println("studentGrade size " + studentGrades.size()); 
       
        for (Object[] obj:studentGrades){
            int student_id = (int)obj[0];
            String first_name =  (String) obj[1];
            String last_name =  (String) obj[2];
            String gender = (String) obj[3];
            String course_name = (String)obj[4];
            int  mark1 = 0;//(int) obj[5];
            int  mark2 = 0;//(int) obj[6];
                
           System.out.println("Student Grade = " + student_id + "  " + first_name 
                   + "  " + last_name+ "  " + gender + "  " + course_name + "  " + obj[5] + "  " + mark2);
           
            if (obj[4]==null)
               System.out.println("mark  = null ");
               

          // System.out.println(obj);          
        }
        
        
 
        
       
        
        session.getTransaction().commit();

        session.close();
        
        sessionFactory.close();
        
        
        
    }
    
}
