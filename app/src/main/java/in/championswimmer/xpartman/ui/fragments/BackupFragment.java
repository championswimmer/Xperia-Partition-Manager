package in.championswimmer.xpartman.ui.fragments;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import in.championswimmer.xpartman.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BackupFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class BackupFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View mView;
    Spinner backupPartitionSpinner;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BackupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BackupFragment newInstance(String param1, String param2) {
        BackupFragment fragment = new BackupFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public BackupFragment() {
        // Required empty public constructor
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
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_backup, container, false);
        backupPartitionSpinner = (Spinner) mView.findViewById(R.id.backup_partition_spinner);
        backupPartitionSpinner.setAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_spinner_item,
                android.R.id.text1,
                new String[] {"A", "b"} // TODO: Get read partition list from PartitionMap
        ));
        return mView;
    }


}
