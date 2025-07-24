package com.lab.lab1.l1c2;

import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;

public class DisplayRoom {
    public static void main(String[] args)  {
        ObjectInputStream in= null;
        try {
            in = new ObjectInputStream(new FileInputStream("src/com/lab/lab1/l1c2/students.dat"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Student.students=(ArrayList<Student>) in.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Student st: Student.students){
            String eli;
            if (st.isEligibleForScholarShip){
                eli="Yes";
            }else{
                eli="No";
            }
            System.out.println("NAME:"+st.studentName+"\nID:"+st.studId+"\nStatus:"+st.getResult()+"\nEligible for Scholarship:"+eli+"\n\n");
        }
    }

}
