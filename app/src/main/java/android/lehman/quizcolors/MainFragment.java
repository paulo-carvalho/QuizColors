package android.lehman.quizcolors;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {
    public MainFragment () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button start = (Button)rootView.findViewById(R.id.buttonStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                //TODO: not working, back button closes app
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.container, new CategoryFragment()).commit();
            }
        });

        return rootView;
    }
}
