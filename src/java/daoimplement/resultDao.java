/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimplement;


import Service.courseService;
import Service.studentService;
import model.Course;
import model.Results;
import model.Student;
import daointerface.resultsInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class resultDao implements resultsInterface<Results> {
    

    
    HibernateTemplate template;  
    
    public void setTemplate(HibernateTemplate template) {  
        this.template = template;  
    }  
 
    //insert a new record
    @Override
    public void insert(Results entity) {
       template.save(entity);
    }

    // update a record
    @Override
    public void update(Results entity) {
         template.update(entity);
    }

    // Select a record in result that have student_id = st_id and course_id = crs_id
    @Override
    public Results selectById(int st_id, int crs_id) {
 
        String hql = "FROM Results "
                + "where pk.student.student_id = " + st_id + " and pk.course.course_id = " + crs_id ;
        
        List<Object> results = template.find(hql);//query.list();
        
        Results result = null;
        
        if (!(results.get(0)==null)){
            result = (Results)results.get(0) ;      
        }

        return result; 
    }

    // Select all results that have student_id = st_id
    public List<Results> selectStudent(int st_id){
        
        String hql = "FROM Results "
                + "where pk.student.student_id = " + st_id  ;
     
        List<Object> objs =  template.find(hql); //query.list();
         
        List<Results> results = new ArrayList<>();
        for (Object obj:objs ){
            Results rls = (Results) obj;
            results.add(rls);
        }
        return results;         
    }
    
    // Select all results that have course_id  = crs_id
    public List<Results> selectCourse(int crs_id){
        
        String hql = "FROM Results "
                + "where pk.course.course_id = " + crs_id  ;
               
        List<Object> objs =  template.find(hql); //query.list();
         
        List<Results> results = new ArrayList<>();
        for (Object obj:objs ){
            Results rls = (Results) obj;
            results.add(rls);
        }               
        return results;         
    }
    
    //Delete a record result
    @Override
    public void delete(Results result) {        	
        template.delete(result);
    }

    
    //Select all records of Results
    @Override
    public List<Results> select() {
                 
        List<Results> results = template.loadAll(Results.class);
        return results;
    }
    

    // Write results table to a text file
    @Override
    public void write_to_file(String filename) {
        
        //Create a file       
        File file = new File(filename);
        if (!file.exists()){
            File citydir = new File(file.getParent());
            if (!citydir.exists())
                citydir.mkdirs();
            
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
            }         
        }
        
        
        //Get information from Database       
        List<Results> results = template.loadAll(Results.class);
        
        //write to file   
        PrintWriter fout = null;
        
        try {
            fout = new PrintWriter( new BufferedWriter (new FileWriter(file)));
 
            for(Results rlst:results){
                int student_id  = rlst.getStudent().getStudent_id();
                int course_id   = rlst.getCourse().getCourse_id();
                int mark1      = rlst.getMark1();
                int mark2      = rlst.getMark2();

                fout.println(student_id+","+course_id +","+mark1+","+mark2);               
            }
            fout.close();
          } catch (IOException ex) {
            Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Import data from text file to Results table
    @Override
    public void insert_from_file(String filename) {
       File file = new File(filename);
       BufferedReader fin = null;
        
        if (!file.exists()){
            System.out.println("File not exists!");
        }else{
           
           try {
               System.out.println("Insert data from file ....");
               
               fin = new BufferedReader( new FileReader(file));
               
               String line = null;

               line = fin.readLine();
     
               while (line!=null){
                   //slipt line data and add fields to Person object
                   
                   String[] components = line.split(",");
                   
                   int student_id = Integer.parseInt(components[0]);
                   int course_id = Integer.parseInt(components[1]);
                   int mark1 = Integer.parseInt(components[2]);
                   int mark2 = Integer.parseInt(components[3]);
                   System.out.println("Student " + student_id + " " + course_id + " "+ mark1 + " " +  mark2 );
                   
                   resultDao rlsDao = new resultDao();
                   studentService stService = new studentService();
                   courseService crsService = new courseService();
                   
                   Student st = stService.selectById(student_id);
                   Course crs = crsService.selectById(course_id);
                   
                   System.out.println("Student " + st);
                   
                   System.out.println(" Course " + crs);
                   
                   if ((st==null) || (crs==null))
                       System.out.println("Student or Course is null");
                   else{
                       
                       Results rsl = new Results(mark1,mark2);
                       rsl.setStudent(st);
                       rsl.setCourse(crs);
                       
                       System.out.println("Result: " + rsl);
                       //insert to database
                       this.insert(rsl);
                   }  
                   //read next line
                   
                   line = fin.readLine();
               }
                
               //close file
               
               fin.close();
       
               System.out.println("end of inserting");
           } catch (FileNotFoundException ex) {
               Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
           }
                  
        }
    }

    
}
