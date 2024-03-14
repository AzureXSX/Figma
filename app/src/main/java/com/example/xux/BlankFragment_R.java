package com.example.xux;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment_R#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment_R extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment_R() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment_R.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment_R newInstance(String param1, String param2) {
        BlankFragment_R fragment = new BlankFragment_R();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blank__r, container, false);

        GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT,
                new int[] {Color.parseColor("#3934FFF3"), Color.parseColor("#392B27D2")});
        gradient.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        gradient.setGradientCenter(0.61f, 0.61f); //

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.add_layout);

        layout.setBackground(gradient);

        AppCompatButton btn = view.findViewById(R.id.boost_BTN);

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingInflatedId")
            @Override
            public void onClick(View v) {
                BoostBase main = (BoostBase) getActivity();
                if(!main.get_isOptimizedRocket()){
                    ProgressBar progressBar = view.findViewById(R.id.SHOW_PROGRESS);
                    new Thread(new Runnable() {
                        public void run() {
                            int progress = 0;

                            while (progress <= 100) {
                                // Update the progress bar
                                progressBar.setProgress(progress);

                                // Sleep for 200 milliseconds to simulate loading
                                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

                                // Increment the progress
                                int finalProgress = progress;


                                if(getActivity() != null) {
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            btn.setText(finalProgress + "%");
                                        }
                                    });
                                }

                                progress++;
                            }

                            main.set_isOptimizedRocket(true);
                        }
                    }).start();
                }
            }
        });

        return view;
    }
}