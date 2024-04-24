package com.example.dashboard.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dashboard.FetchJsonTask;
import com.example.dashboard.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CameraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CameraFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText editTextRegistrationNumber, editTextUsername;
    private TextView textViewResult;
    private Button buttonFetch;


    public CameraFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CameraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CameraFragment newInstance(String param1, String param2) {
        CameraFragment fragment = new CameraFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);
        editTextRegistrationNumber = view.findViewById(R.id.editTextRegistrationNumber);
        editTextUsername = view.findViewById(R.id.editTextUsername);
        textViewResult = view.findViewById(R.id.text_view_result);
        buttonFetch = view.findViewById(R.id.button_fetch);

        buttonFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String registrationNumber = editTextRegistrationNumber.getText().toString();
                String username = editTextUsername.getText().toString();
                String urlString = "https://www.regcheck.org.uk/api/reg.asmx/CheckPoland?RegistrationNumber=" + registrationNumber + "&username=" + username;
                new FetchJsonTask(new FetchJsonTask.Listener() {
                    @Override
                    public void onResultReceived(String result) {
                        textViewResult.setText(result);
                    }
                }).execute(urlString);
            }
        });

        return view;
    }
}