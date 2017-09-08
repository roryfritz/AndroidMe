package com.hyperdev.androidme.activities;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyperdev.androidme.R;
import java.util.ArrayList;
import java.util.List;



public class BodyPartFragment extends Fragment {

    private List<Integer> bodyPartNum;
    private int listPosition;
    private static final String listParts = "parts_list";
    private static final String numParts = "parts_number";
    public BodyPartFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null){
            bodyPartNum = savedInstanceState.getIntegerArrayList(listParts);
            listPosition = savedInstanceState.getInt(numParts);
        }
        View rootView = inflater.inflate(R.layout.b_parts_fragment, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageFrag);
        if(bodyPartNum !=null){
            imageView.setImageResource(bodyPartNum.get(listPosition));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listPosition < bodyPartNum.size()-1){
                        listPosition++;
                    }else {
                        listPosition = 0;
                    }
                    imageView.setImageResource(bodyPartNum.get(listPosition));
                }
            });
        }
        return rootView;
    }

    public void setPartList(List<Integer> partList) {

        this.bodyPartNum = partList;
    }

    public void setListPosition(int mListPosition) {

        this.listPosition = mListPosition;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(listParts, (ArrayList<Integer>)bodyPartNum);
        outState.putInt(numParts,listPosition);
    }
}

