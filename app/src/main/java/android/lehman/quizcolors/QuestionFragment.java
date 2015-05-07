package android.lehman.quizcolors;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.Date;
import java.util.Random;

/**
 * Class from QuizColors at android.lehman.quizcolors
 * Created by Paulo-Lehman on 5/6/2015.
 */
public class QuestionFragment extends Fragment {
    private final int COUNT_ALTERNATIVES = 4;
    private final int COUNT_QUESTIONS = 20;

    public QuestionFragment () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CategoryStrategy categoryStrategy;
        categoryStrategy = new CategoryColors();
        Button answers[];
        Random random = new Random(new Date().getTime());
        int index = 0,
            correctAnswer = 0;
        int indexTextColor[];

//      funcionality non-appliable for now
//        int colorOrder[] = new int[COUNT_QUESTIONS];
//        for(int i=0; i<COUNT_QUESTIONS; i++) {
//
//        }

        index = random.nextInt(Colors.COUNT_COLORS);
        correctAnswer = random.nextInt(COUNT_ALTERNATIVES);

        View rootView = inflater.inflate(R.layout.fragment_question, container, false);

        FrameLayout question = (FrameLayout)rootView.findViewById(R.id.question);
        question.setBackgroundColor(
                android.graphics.Color.parseColor(
                        ((Colors) categoryStrategy.getArrayListAt(index)).hexColor()
                ));

        answers = new Button[COUNT_ALTERNATIVES];
        answers[0] = (Button)rootView.findViewById(R.id.answer1);
        answers[1] = (Button)rootView.findViewById(R.id.answer2);
        answers[2] = (Button)rootView.findViewById(R.id.answer3);
        answers[3] = (Button)rootView.findViewById(R.id.answer4);

        //setting text with "correct answer"
        answers[correctAnswer].setText(((Colors) categoryStrategy.getArrayListAt(index)).nameColor());
        answers[correctAnswer].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.container, new ResultFragment()).commit();
            }
        });

        indexTextColor = new int[COUNT_ALTERNATIVES];
        for(int i=0; i < indexTextColor.length; i++) {
            do {
                indexTextColor[i] = random.nextInt(Colors.COUNT_COLORS);
            } while(indexTextColor[i] == index);
        }

//        for(int i=0; i < answers.length; i++) {
//            if(i != correctAnswer) {
////                answers[i].setText(((Colors) categoryStrategy.getArrayListAt(indexTextColor[i])).nameColor());
//                answers[i].setText(indexTextColor[i]);
//            }
//        }

        return rootView;
    }
}
