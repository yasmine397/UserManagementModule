package com.example.usermanagementmodule;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForgotFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForgotFragment extends Fragment {

    private EditText etF;
    private FirebaseServices fbs;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam2;

    public ForgotFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForgotFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForgotFragment newInstance(String param1, String param2) {
        ForgotFragment fragment = new ForgotFragment();
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
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot, container, false);
    }


        @Override
        public void onStart() {
            super.onStart();
            connect();
        }
        public void connect()
        {
            fbs=FirebaseServices.getInstance();
            etF=getView().findViewById(R.id.etEmailForgotPassword);

            Button btnR = getView().findViewById(R.id.btnResetForgrotPassword);
            btnR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (etF.getText().toString().isEmpty()) {
                        Toast.makeText(getActivity(), "Some fields are empty!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    fbs.getAuth().sendPasswordResetEmail(etF.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getActivity(), "Email sent!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getActivity(), "Something went wrong!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            });
        }
}