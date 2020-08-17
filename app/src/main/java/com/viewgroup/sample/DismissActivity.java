package com.viewgroup.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.viewgroup.Creator;
import com.viewgroup.SwipeDismissLayout;

import java.util.ArrayList;

import static com.viewgroup.sample.Helper.PREFERENCES_NAME_DRAG_FROM;
import static com.viewgroup.sample.Helper.PREFERENCES_PARENT_DRAG;


public class DismissActivity extends BaseActivity {

    private int previousDragSelection = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dismiss);




        ArrayList<String> dragDirections = new ArrayList<>();
        dragDirections.add("TOP");
        dragDirections.add("START");
        dragDirections.add("BOTTOM");
        dragDirections.add("END");

        Spinner spinner =((Spinner)findViewById(R.id.spinner_drag_from));
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, dragDirections);
        spinner.setAdapter(spinnerAdapter);
        int selection = Helper.loadPreference(this, PREFERENCES_PARENT_DRAG, PREFERENCES_NAME_DRAG_FROM, 0);
        previousDragSelection = selection;
        spinner.setSelection(selection);
        SwipeDismissLayout.DragFrom dragFrom = SwipeDismissLayout.DragFrom.TOP;
        switch (selection){
            case 0:
                dragFrom = SwipeDismissLayout.DragFrom.TOP;
                break;
            case 1:
                dragFrom = SwipeDismissLayout.DragFrom.START;
                break;
            case 2:
                dragFrom = SwipeDismissLayout.DragFrom.BOTTOM;
                break;
            case 3:
                dragFrom = SwipeDismissLayout.DragFrom.END;
                break;
        }

        Creator.createSwipeDismissLayout(this, true, dragFrom);

        ((Spinner)findViewById(R.id.spinner_drag_from)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Helper.savePreference(DismissActivity.this, PREFERENCES_PARENT_DRAG, PREFERENCES_NAME_DRAG_FROM, position);
                if (position != previousDragSelection) {
                    DismissActivity.this.recreate();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
