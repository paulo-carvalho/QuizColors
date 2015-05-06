package android.lehman.quizcolors;

import android.app.Fragment;
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
        View rootView = inflater.inflate(R.layout.fragment_question, container, false);

        FrameLayout question = (FrameLayout)rootView.findViewById(R.id.question);
        question.getBackground().setColorFilter(android.graphics.Color.parseColor("#00ff00"), PorterDuff.Mode.DARKEN);

//        for (Category category : Category.values()) {
//            Button myButton = new Button(getActivity().getApplicationContext());
//            myButton.setText(category.name());
//
//            LinearLayout linearLayout = (LinearLayout)rootView.findViewById(R.id.categoryLinearLayout);
//            LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//            linearLayout.addView(myButton, layoutParams);
//        }

        return rootView;
    }

}
