package com.example.chayen.pincodesample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import in.arjsna.passcodeview.PassCodeView;


public class ConfirmPINCode extends Fragment {

//    private OnFragmentInteractionListener mListener;

    public ConfirmPINCode() {
        // Required empty public constructor
    }

    private PassCodeView confirmPinPassCodeView;
    private static String confirmpincode;

    public static ConfirmPINCode newInstance(String code) {
        ConfirmPINCode fragment = new ConfirmPINCode();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        confirmpincode = code;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_confirm_pincode, container, false);
        confirmPinPassCodeView = (PassCodeView)rootview.findViewById(R.id.confirmPinCodePassCodeView);
//        TextView promptView = (TextView) rootview.findViewById(R.id.text_confirmPINcode);
        confirmPinPassCodeView.setEmptyDrawable(R.drawable.empty_dot_line);
        confirmPinPassCodeView.setFilledDrawable(R.drawable.filled_dot_line);
        confirmPinPassCodeView.setKeyTextColor(getResources().getColor(R.color.colorGray));

        bindEvents();

        return rootview;
    }

    private void bindEvents() {
        confirmPinPassCodeView.setOnTextChangeListener(new PassCodeView.TextChangeListener() {
            @Override public void onTextChanged(String text) {
                if (text.length() == 6) {
                    if(text.equals(confirmpincode)){
                        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        Toast.makeText(getActivity().getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                    }else{
                        confirmPinPassCodeView.setError(true);
                    }
                }
            }
        });
    }


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    public interface OnFragmentInteractionListener {
//
//        void onFragmentInteraction(Uri uri);
//    }
}
