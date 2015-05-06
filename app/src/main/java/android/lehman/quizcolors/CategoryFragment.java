package android.lehman.quizcolors;

import android.app.Fragment;
import android.app.FragmentTransaction;
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

    private final String PARAM_QUESTIONFRAGMENT = "category";

    public CategoryFragment () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);

        for (final Category category : Category.values()) {
            Button categoryStart = new Button(getActivity().getApplicationContext());
            categoryStart.setText(category.name());

            LinearLayout linearLayout = (LinearLayout)rootView.findViewById(R.id.categoryLinearLayout);
            LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            linearLayout.addView(categoryStart, layoutParams);

            categoryStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString(PARAM_QUESTIONFRAGMENT, category.name());

                    QuestionFragment questionFragment = new QuestionFragment();
                    questionFragment.setArguments(bundle);

                    final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.replace(R.id.container, questionFragment).commit();
                }
            });
        }

        return rootView;
    }
}
