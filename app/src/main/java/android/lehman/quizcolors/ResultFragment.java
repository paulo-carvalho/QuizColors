package android.lehman.quizcolors;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Class from QuizColors at android.lehman.quizcolors
 * Created by Paulo-Lehman on 5/6/2015.
 */
public class ResultFragment extends Fragment {

    public ResultFragment () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_result, container, false);
        Bundle bundle = getArguments();
        TextView finalScore = (TextView)rootView.findViewById(R.id.finalScore);
        finalScore.setText(
                String.valueOf(bundle.getInt(QuestionFragment.PARAM_SCORE)) + "/" + QuestionFragment.COUNT_QUESTIONS
        );

        Button playAgain = (Button)rootView.findViewById(R.id.playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                //TODO: not working, back button closes app
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.container, new CategoryFragment()).commit();
            }
        });

        Button mainMenu = (Button)rootView.findViewById(R.id.mainMenu);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                //TODO: not working, back button closes app
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.container, new MainFragment()).commit();
            }
        });

        return rootView;
    }
}
