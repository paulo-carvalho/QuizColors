package android.lehman.quizcolors;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;

/**
 * Class from QuizColors at android.lehman.quizcolors
 * Created by Paulo-Lehman on 5/6/2015.
 * The ArrayList is necessary to access Colors by index, as
 * we can't index as in C++
 */
public class CategoryColors implements CategoryStrategy {

    private ArrayList<Colors> colorsArrayList = new ArrayList<>();

    public CategoryColors() {
        for (Colors color : Colors.values()) {
            colorsArrayList.add(color);
        }
    }

    public CategoryColors(ArrayList<Colors> colorsArrayList) {
        this.colorsArrayList = colorsArrayList;
    }

    /*
     * Implementing Strategy Interface
     * */
    @Override
     public String getStrategy() {
        return Category.Colors.name();
    }

    @Override
    public ArrayList<Colors> getArrayList() {
        return colorsArrayList;
    }

    @Override
    public void setArrayList(ArrayList colorsArrayList) {
        if(this.colorsArrayList.getClass() == colorsArrayList.getClass())
            this.colorsArrayList = colorsArrayList;
    }

    @Override
    public Enum getArrayListAt(int index) {
        return colorsArrayList.get(index);
    }
}
