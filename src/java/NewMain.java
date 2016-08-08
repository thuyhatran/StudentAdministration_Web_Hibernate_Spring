
import beans.Course;
import beans.Student;
import daoimplement.courseDao;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;


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
        
     
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = new Student();
       
        
     
        
//        student1 = stService.selectById(2);
//        
//        System.out.println(student1);
        
        
     
		
	//AuthorDao authorDAO = context.getBean("authorDao",AuthorDao.class);
//        studentDao stDAO = context.getBean(studentDao.class);
//        
//        student1 = stDAO.selectById(1);
//        
//        System.out.println("called by context: "+ student1);
//        System.out.println("getNewStudentID : "+ stDAO.getNewStudentID());
        
        courseDao crsDao = context.getBean("courseDao",courseDao.class);
        Course course = new Course(3,"Database");
        crsDao.update(course);
        
         
        List lsCourse = crsDao.select();
        
        for (Object crs:lsCourse)
            System.out.println(crs);
        
       
        
        context.close();
        
        
        
//        List<StudentsGrade> stGrad = stDAO.getGrades();
//        
//        for (StudentsGrade stG:stGrad)
//            System.out.println(stG);
        
        
// //  studentService stService = new studentService();
//       courseService crsService = new courseService();
//   //     resultService rlsService = new resultService();
//   
//   System.out.println("Service ");
//        
//        crsService.insert(course);
//        
//        List<Course> lsSRVCourse = crsService.select();
//        
//        for (Course crs2:lsSRVCourse)
//            System.out.println(crs2);
        
        
        
        
        
    }
    
}





//
//List user= 
//            getHibernateTemplate().find("select uid, username,email from USERS where uid<>0 AND obj_type=1");
//
//
//        List<USERS> l = new ArrayList<USERS>(); 
//        for (int i = 0; i < user.size(); i++) {
//            USERS du = new USERS(); 
//            Object[] obj = (Object[]) user.get(i);
//
//            Integer uid = (Integer) obj[0];
//            du.setUid(uid);
//            String username = (String) obj[1];
//            du.setUsername(username); 
//            String email = (String) obj[2];
//            du.setEmail(email); 
//            l.add(du);
//        }