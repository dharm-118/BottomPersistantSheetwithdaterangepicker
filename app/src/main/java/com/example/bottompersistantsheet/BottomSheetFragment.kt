package com.example.bottompersistantsheet

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.util.Pair
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialStyledDatePickerDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var mDateRangePickerButton: MaterialButton
    private lateinit var mInputLayout : TextInputLayout
    private lateinit var mDisplay : TextInputEditText
    companion object{
        val TAG = BottomSheetFragment.javaClass.simpleName
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDateRangePickerButton = view.findViewById(R.id.uiDateRangePicker)
        mDisplay = view.findViewById(R.id.uiET1)
        mInputLayout = view.findViewById(R.id.uiIl1)
        val mDateRangePicker = MaterialDatePicker.Builder.dateRangePicker()
            .setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar) // for dialog i.e pop up
            .setTitleText("Select Dates For Transaction History")
            .setSelection(
                Pair(
                    MaterialDatePicker.thisMonthInUtcMilliseconds(),
                    MaterialDatePicker.todayInUtcMilliseconds()
                )
            ).build()
        mDateRangePickerButton.setOnClickListener {
            mDateRangePicker.show(fragmentManager!!, "DateRangePicker")
        }
        mDateRangePicker.addOnPositiveButtonClickListener {
            Log.d("TAG","Date String = ${mDateRangePicker.headerText}")
            mDisplay.setText(mDateRangePicker.headerText)

        }
    }
}



