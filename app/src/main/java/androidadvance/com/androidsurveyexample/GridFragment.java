package androidadvance.com.androidsurveyexample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GridFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GridFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GridFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int SURVEY_REQUEST = 1337;

    String[] web = {
            "About Us", "Order Food", "Open Table", "Photo","Survey" , "Video",
            "Events", "Loyalty Card","About Us", "Order Food", "Open Table", "Photo","Survey" , "Video",
            "Events", "Loyalty Card",
    };
    MyRecyclerViewAdapter adapter;
    int[] imageId = {
            R.drawable.about, R.drawable.order, R.drawable.open, R.drawable.photo,
            R.drawable.survay , R.drawable.vedio, R.drawable.event, R.drawable.loyal,
            R.drawable.about, R.drawable.order, R.drawable.open, R.drawable.photo,
            R.drawable.survay , R.drawable.vedio, R.drawable.event, R.drawable.loyal
    };
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public GridFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GridFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GridFragment newInstance(String param1, String param2) {
        GridFragment fragment = new GridFragment();
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
        // Inflate the layout for this fragment
      View inf=inflater.inflate(R.layout.fragment_grid, container, false);
        RecyclerView recyclerView = (RecyclerView)inf.findViewById(R.id.rvNumbers);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
        adapter = new MyRecyclerViewAdapter(getContext(), web,imageId);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return inf;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    @Override
    public void onItemClick(View view, int position) {
        // Toast.makeText(this,  adapter.getItem(position), Toast.LENGTH_SHORT).show();
        if( adapter.getItem(position).equals("Survey")){
            SurvayFragment nextFrag= new SurvayFragment();
            this.getFragmentManager().beginTransaction()
                    .replace(R.id.con, nextFrag,"1")
                    .addToBackStack(null)
                    .commit();
        }
        if(adapter.getItem(position).equals("About Us")){
            AboutFragment nextFrag= new AboutFragment();
            this.getFragmentManager().beginTransaction()
                    .replace(R.id.con, nextFrag,"1")
                    .addToBackStack(null)
                    .commit();

        }else  if(adapter.getItem(position).equals("Order Food")){
            OrderFragment nextFrag= new OrderFragment();
            this.getFragmentManager().beginTransaction()
                    .replace(R.id.con,nextFrag,"1")
                    .addToBackStack(null)
                    .commit();

        }

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private String loadSurveyJson(String filename) {
        try {
            InputStream is =getActivity().getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
