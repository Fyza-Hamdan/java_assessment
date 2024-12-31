package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student
    extends Person
    implements Evaluation
{
    private double average;

    private final List<Course> courses = new ArrayList<>();

    private final Map<String, Course> approvedCourses = new HashMap<>();

    private final Map<String, Double> courseGrades = new HashMap<>();

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public void enrollToCourse( Course course )
    {
        //TODO implement this method
        if (course != null && !isAttendingCourse(course.getCode())) {
            courses.add(course);
        }

    }

    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }

    public boolean isCourseApproved( String courseCode )

    {
        //TODO implement this method
        return approvedCourses.containsKey(courseCode);

    }

    public void setGrade(String courseCode, double grade) {
        courseGrades.put(courseCode, grade);
    }

    public Double getGrade(String courseCode) {
        return courseGrades.get(courseCode);
    }


    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve. 
    public List<Course> findPassedCourses( Course course )
    {
        List<Course> passedCourses = new ArrayList<>();
        for (String courseCode : courseGrades.keySet()) {
            Double grade = courseGrades.get(courseCode);
            if (grade != null && grade >= 60) {
                Course passedCourse = approvedCourses.get(courseCode);
                if (passedCourse != null) {
                    passedCourses.add(passedCourse);
                }
            }
        }

        //TODO implement this method
        //return null;
        return passedCourses;
    }

    public boolean isAttendingCourse( String courseCode )
    {
        //TODO implement this method
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getAverage()
    {
        return average;
    }

    @Override
    public List<Course> getApprovedCourses()
    {
        //TODO implement this method
        return new ArrayList<>(approvedCourses.values());
        //return null;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
