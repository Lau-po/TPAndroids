package ovh.poulin.tab;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by poulinl on 10/02/16.
 */
public class Modele{
    //private Map<Integer,Integer> tablets = new ArrayMap<Integer,Integer>();
    private String[] students;
    private String[] tabletsArr;
    private int[] tablets;

    public Modele(Context c){
        this.tabletsArr = c.getResources().getStringArray(R.array.tablets);
        this.students = c.getResources().getStringArray(R.array.students);
        this.tablets = new int[tabletsArr.length];
        for(int i = 0; i < tabletsArr.length ; i++){
            this.tablets[i] = 0;
        }
    }

    public Modele(Bundle inState){
        tablets = inState.getIntArray("TABLETS_ARRAY");
        students = inState.getStringArray("TABLETS_NAMES");
        students = inState.getStringArray("STUDENTS_NAMES");

    }

    public int getCount(){
        return tablets.length;
    }

    public String getStudent(int i){
        return students[tablets[i]];
    }

    public String getTerminal(int i){
        return tabletsArr[i];
    }

    public boolean setStudent(int i,int e){
        for(int j = 0; j < tabletsArr.length ; j++){
            if(tablets[i] == e){
                return false;
            }
        }
        tablets[i] = e;
        return true;
    }

    public void save(Bundle OutState){
        OutState.putIntArray("TABLETS_ARRAY", tablets);
        OutState.putStringArray("TABLETS_NAMES", tabletsArr);
        OutState.putStringArray("STUDENTS_NAMES",students);
    }
}
