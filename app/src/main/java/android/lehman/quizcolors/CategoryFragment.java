package android.lehman.quizcolors;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;

/**
 * Class from QuizColors at android.lehman.quizcolors
 * Created by Paulo-Lehman on 5/6/2015.
 */
public class CategoryFragment extends Fragment {
    Category categories;

    public CategoryFragment () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);

        for (Category category : Category.values()) {
            Button myButton = new Button(getActivity().getApplicationContext());
            myButton.setText(category.toString());

            LinearLayout linearLayout = (LinearLayout)rootView.findViewById(R.id.categoryLinearLayout);
            LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            linearLayout.addView(myButton, layoutParams);
        }

        return rootView;
    }
}
