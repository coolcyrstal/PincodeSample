package com.example.chayen.pincodesample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import in.arjsna.passcodeview.PassCodeView;


public class CreatePINCode extends Fragment {


//    private OnFragmentInteractionListener mListener;

    public CreatePINCode() {
        // Required empty public constructor
    }

    private PassCodeView createPinPassCodeView;
    private String pincode;

    public static CreatePINCode newInstance() {
        CreatePINCode fragment = new CreatePINCode();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_create_pincode, container, false);

        createPinPassCodeView = rootview.findViewById(R.id.createPinCodePassCodeView);
//        TextView promptView = rootview.findViewById(R.id.textCreatePinCode);
        createPinPassCodeView.setEmptyDrawable(R.drawable.empty_dot_line);
        createPinPassCodeView.setFilledDrawable(R.drawable.filled_dot_line);
        createPinPassCodeView.setKeyTextColor(getResources().getColor(R.color.colorGray));

        bindEvents();

        return rootview;
    }

    private void bindEvents() {
        createPinPassCodeView.setOnTextChangeListener(new PassCodeView.TextChangeListener() {
            @Override public void onTextChanged(String text) {
                if (text.length() == 6) {
                    pincode = text;
                    Fragment fragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.register_pin);
                    if (!(fragment instanceof ConfirmPINCode)) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.register_pin, ConfirmPINCode.newInstance(pincode), "Confirm PIN code page")
                                .addToBackStack(null)
                                .commit();
                    }else Toast.makeText(getActivity().getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
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


//    public interface OnFragmentInteractionListener {
//
//        void onFragmentInteraction(Uri uri);
//    }
}
