package android.lehman.quizcolors;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Class from QuizColors at android.lehman.quizcolors
 * Created by Paulo-Lehman on 5/6/2015.
 */
public class QuestionFragment extends Fragment {
    public QuestionFragment () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CategoryStrategy categoryStrategy;
        categoryStrategy = new CategoryColors();
        int index = 0;

        View rootView = inflater.inflate(R.layout.fragment_question, container, false);
        FrameLayout question = (FrameLayout)rootView.findViewById(R.id.question);
        question.setBackgroundColor(
                android.graphics.Color.parseColor(
                        ((Colors)categoryStrategy.getArrayList().get(index)).hexColor()
        ));

        return rootView;
    }

}
