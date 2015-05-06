package android.lehman.quizcolors;

import java.util.ArrayList;

/**
 * Class from QuizColors at android.lehman.quizcolors
 * Created by Paulo-Lehman on 5/6/2015.
 */
public interface CategoryStrategy {

    //tell strategy used
    String getStrategy();

    //get enum elements
    ArrayList getArrayList();

    //set enum elements
    void setArrayList(ArrayList arrayList);

    //get element in a specific position
    Enum getArrayListAt(int index);
}
