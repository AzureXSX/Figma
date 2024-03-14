package com.example.xux;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment_F#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment_F extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment_F() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment_F.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment_F newInstance(String param1, String param2) {
        BlankFragment_F fragment = new BlankFragment_F();
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
        View view = inflater.inflate(R.layout.fragment_blank__f, container, false);

        final TextView textView = view.findViewById(R.id.OutputValues); // Replace with your TextView's ID

        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                LinearGradient gradient = new LinearGradient(
                        0, 0, textView.getWidth(), textView.getHeight(),
                        Color.parseColor("#F31935"), Color.parseColor("#FF8F3E"), Shader.TileMode.CLAMP
                );
                textView.getPaint().setShader(gradient);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    textView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });

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
                if(!main.get_isOptimizedFan()){
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

                            main.set_isOptimizedFan(true);
                        }
                    }).start();
                }
            }
        });

        return view;
    }
}