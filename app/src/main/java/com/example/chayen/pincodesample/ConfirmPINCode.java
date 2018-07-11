package com.example.chayen.pincodesample;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
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

    private PassCodeView confirm_PIN_passcodeview;
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
        confirm_PIN_passcodeview = (PassCodeView)rootview.findViewById(R.id.confirm_pin_code_passcodeview);
        TextView promptView = (TextView) rootview.findViewById(R.id.text_confirmPINcode);
        confirm_PIN_passcodeview.setEmptyDrawable(R.drawable.empty_dot_line);
        confirm_PIN_passcodeview.setFilledDrawable(R.drawable.fill_dot_line);
        confirm_PIN_passcodeview.setKeyTextColor(getResources().getColor(R.color.colorWhite));

        bindEvents();

        return rootview;
    }

    private void bindEvents() {
        confirm_PIN_passcodeview.setOnTextChangeListener(new PassCodeView.TextChangeListener() {
            @Override public void onTextChanged(String text) {
                if (text.length() == 6) {
                    if(text.equals(confirmpincode)){
                        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        Toast.makeText(getActivity().getApplicationContext(), text.toString(), Toast.LENGTH_SHORT).show();
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
