package android.lehman.quizcolors;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Date;
import java.util.Random;

/**
 * Class from QuizColors at android.lehman.quizcolors
 * Created by Paulo-Lehman on 5/6/2015.
 */
public class QuestionFragment extends Fragment {
    private final int COUNT_ALTERNATIVES = 4;
    protected static final int COUNT_QUESTIONS = 20;

    //parameter key to store/load score (0~20)
    protected static final String PARAM_SCORE = "score";

    //parameter key to send index(1~20) to QuestionFragment itself
    protected final String PARAM_INDEXQUESTIONS = "index";

    //time to switch questions
    protected final int TIME_DELAYFRAGMENT = 1500;

    protected int score = 0;
    protected int indexQuestions = 0;

    public QuestionFragment () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CategoryStrategy categoryStrategy;
        categoryStrategy = new CategoryColors();
        final Button answers[];
        Random random = new Random(new Date().getTime());
        int index = 0,
            correctAnswer = 0;
        int indexTextColor[];

        Bundle bundle = getArguments();
        indexQuestions = bundle.getInt(PARAM_INDEXQUESTIONS);
        score = bundle.getInt(PARAM_SCORE);

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

        //array with random indexes of Color enum, different from the correct answer
        indexTextColor = new int[COUNT_ALTERNATIVES];
        for(int i=0; i < indexTextColor.length; i++) {
            do {
                indexTextColor[i] = random.nextInt(Colors.COUNT_COLORS);
            } while(indexTextColor[i] == index);
        }

        //all options are "wrong", the next step choose randomly one to be the right
        for(int i=0; i < answers.length; i++) {
            answers[i].setText(((Colors) categoryStrategy.getArrayListAt(indexTextColor[i])).nameColor());
            answers[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final View VIEW = v;
                    new CountDownTimer(TIME_DELAYFRAGMENT, TIME_DELAYFRAGMENT-1000) {

                        public void onTick(long millisUntilFinished) {
                            VIEW.setBackgroundColor(Color.parseColor("#FF0000"));
                        }

                        public void onFinish() {
                            Bundle bundle = new Bundle();
                            bundle.putInt(PARAM_SCORE, score);
                            bundle.putInt(PARAM_INDEXQUESTIONS, ++indexQuestions);

                            if(indexQuestions < COUNT_QUESTIONS) {
                                QuestionFragment questionFragment = new QuestionFragment();
                                questionFragment.setArguments(bundle);

                                final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                //TODO: not working, back button closes app
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.replace(R.id.container, questionFragment).commit();
                            } else {
                                ResultFragment resultFragment = new ResultFragment();
                                resultFragment.setArguments(bundle);

                                final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                //TODO: not working, back button closes app
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.replace(R.id.container, resultFragment).commit();
                            }
                        }
                    }.start();
                }
            });
        }

        //setting button option with "correct answer"
        answers[correctAnswer].setText(((Colors) categoryStrategy.getArrayListAt(index)).nameColor());
        answers[correctAnswer].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View VIEW = v;
                new CountDownTimer(TIME_DELAYFRAGMENT, TIME_DELAYFRAGMENT-1000) {

                    public void onTick(long millisUntilFinished) {
                        VIEW.setBackgroundColor(Color.parseColor("#00FF00"));
                    }

                    public void onFinish() {
                        Bundle bundle = new Bundle();
                        bundle.putInt(PARAM_SCORE, ++score);
                        bundle.putInt(PARAM_INDEXQUESTIONS, ++indexQuestions);

                        if (indexQuestions < COUNT_QUESTIONS) {
                            QuestionFragment questionFragment = new QuestionFragment();
                            questionFragment.setArguments(bundle);

                            final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                            //TODO: not working, back button closes app
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.replace(R.id.container, questionFragment).commit();
                        } else {
                            ResultFragment resultFragment = new ResultFragment();
                            resultFragment.setArguments(bundle);

                            final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                            //TODO: not working, back button closes app
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.replace(R.id.container, resultFragment).commit();
                        }
                    }
                }.start();
            }
        });

        return rootView;
    }
}
