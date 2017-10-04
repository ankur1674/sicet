package ankur.com.sicet;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ListView;

import ankur.com.connmanager.manager;

/**
 * A simple {@link Fragment} subclass.
 */
public class SheetFragment extends Fragment {

    String[] studentNames;

    public SheetFragment() {
        // Required empty public constructor
       studentNames = new manager().getNames();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sheet, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
       // CheckedTextView checkView = (CheckedTextView) getView().findViewById(R.id.simpleCheckedTextView);
        // or  (ImageView) view.findViewById(R.id.foo);
        ListView listView = (ListView) getView().findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter( getActivity().getApplicationContext(), studentNames);
        listView.setAdapter(customAdapter);
    }
}




