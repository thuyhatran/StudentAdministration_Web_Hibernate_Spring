/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimplement;


import model.Course;
import daointerface.courseInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.orm.hibernate4.HibernateTemplate;


/**
 *
 * @author Administrator
 */
public class courseDao implements courseInterface<Course>{
    
     HibernateTemplate template;  
  
   
    public void setTemplate(HibernateTemplate template) {  
        this.template = template;  
    }  
      
    
    //Get new course ID to create a new Course row
    @Override
    public int getNewCourseID() {    
        
        String hql = "SELECT max(course_id) FROM Course";
           
        List<Object> Id = template.find(hql); //query.list();
        
        int curID =1; 
        if (!(Id.get(0)==null)){
               
            curID = (Integer) Id.get(0)+1;
        }

        return curID;
              
    }

    //insert a new record
    @Override
    public void insert(Course entity) {
        template.save(entity);   
        System.out.println("Called save(course)");
    }

    // update a record
    @Override
    public void update(Course entity) {    
        template.update(entity); 
    }

    // Select a course that has course_id  = id
    @Override
    public Course selectById(int id) {
       
        Course crs =  template.get(Course.class, id);
       
        return crs; 
    }

    //Delete a course
    @Override
    public void delete(Course course) {        	
	template.delete(course);	
    }

    //Select all course in Course table
    @Override
    public List<Course> select() {
        
        List<Course> students = template.loadAll(Course.class);
        return students;
    }
    
    
    //Write all data of Course Table to a text file named filename
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
                Logger.getLogger(courseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

         //Get information from Database
      
        List<Course> courses = template.loadAll(Course.class);

        //write to file
        PrintWriter fout = null;
        try {
            fout = new PrintWriter( new BufferedWriter (new FileWriter(file)));
   
            for(Course crs:courses){
                int  course_id   = crs.getCourse_id();
                String course_name    = crs.getCourse_name();

                fout.println(course_id +","+course_name);
            }
            fout.close(); 
        } catch (IOException ex) {
            Logger.getLogger(courseDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////Import all data of Course Table from a text file named filename
    @Override
    public void insert_from_file(String filename) {
         File file = new File(filename);
       BufferedReader fin = null;
        
        if (!file.exists()){
            System.out.println("File not exists!");
        }else{
            System.out.println("Insert data from file ....");
            
            try {
                fin = new BufferedReader( new FileReader(file)); 
                String line = null;
                line = fin.readLine();           
                while (line!=null){
                    //slipt line data and add fields to Person object 

                    String[] components = line.split(",");
                    int course_id = Integer.parseInt(components[0]);
                    String course_name = components[1];    

                    Course course = new Course(course_id,course_name);

                    //insert to database
                    this.insert(course);

                    //read next line
                    line = fin.readLine();

                }
            
                //close file           
                fin.close();
                
                System.out.println("end of inserting");
                
            } catch (IOException ex) {
                Logger.getLogger(courseDao.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        }
    }

   
}    

  
    

