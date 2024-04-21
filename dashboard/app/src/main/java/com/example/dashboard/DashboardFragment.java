package com.example.dashboard;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        setupCardViewNavigation(view, R.id.calendarCard, R.id.action_dashboardFragment_to_calendarFragment);
        setupCardViewNavigation(view, R.id.addClientCard, R.id.action_dashboardFragment_to_addclientFragment);
        setupCardViewNavigation(view, R.id.addCarManualCard, R.id.action_dashboardFragment_to_addcarmanualFragment);
        setupCardViewNavigation(view, R.id.plannedRepairsCard, R.id.action_dashboardFragment_to_plannedrepairsFragment);
        setupCardViewNavigation(view, R.id.carsCard, R.id.action_dashboardFragment_to_carsFragment);
        setupCardViewNavigation(view, R.id.cameraCard, R.id.action_dashboardFragment_to_cameraFragment);

        return view;
    }

    private void setupCardViewNavigation(View rootView, int cardViewId, int navActionId) {
        CardView cardView = rootView.findViewById(cardViewId);
        cardView.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(navActionId);
        });
    }

}