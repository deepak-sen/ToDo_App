package com.example.todomvvm.addedittask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.todomvvm.R;
import com.example.todomvvm.database.AppDatabase;
import com.example.todomvvm.database.Repository;
import com.example.todomvvm.database.TaskEntry;
import com.example.todomvvm.tasks.DatePickerFragment;
import com.example.todomvvm.tasks.LoginActivity;
import com.example.todomvvm.tasks.TimePickerFragment;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class AddEditTaskActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    // Extra for the task ID to be received in the intent
    public static final String EXTRA_TASK_ID = "extraTaskId";
    // Extra for the task ID to be received after rotation
    public static final String INSTANCE_TASK_ID = "instanceTaskId";
    // Constants for priority
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_MEDIUM = 2;
    public static final int PRIORITY_LOW = 3;
    // Constant for default task id to be used when not in update mode
    private static final int DEFAULT_TASK_ID = -1;
    // Constant for logging
    private static final String TAG = AddEditTaskActivity.class.getSimpleName();
    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    // Fields for views
    EditText mEditText;
    private TextView oEditText;
    RadioGroup mRadioGroup;
    Button mButton ;
    Button datePick;
    TextView datetext;
    private ImageButton mvoicePick;
    int day, month, year, hour, minute;
    int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;
    private int mTaskId = DEFAULT_TASK_ID;


    AddEditTaskViewModel viewModel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_task);

         datePick = (Button) findViewById(R.id.datePick);
         datetext = (TextView) findViewById(R.id.dateText);

         datePick.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Calendar c = Calendar.getInstance();
                 year = c.get(Calendar.YEAR);
                 month = c.get(Calendar.MONTH);
                 day = c.get(Calendar.DAY_OF_MONTH);

                 DatePickerDialog datePickerDialog =  new DatePickerDialog(AddEditTaskActivity.this, AddEditTaskActivity.this, year, month, day);
                 datePickerDialog.show();




             }
         });


        initViews();

        if (savedInstanceState != null && savedInstanceState.containsKey(INSTANCE_TASK_ID)) {
            mTaskId = savedInstanceState.getInt(INSTANCE_TASK_ID, DEFAULT_TASK_ID);
        }

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra(EXTRA_TASK_ID)) {
            mButton.setText(R.string.update_button);

            if (mTaskId == DEFAULT_TASK_ID) {
                // populate the UI

                mTaskId = intent.getIntExtra(EXTRA_TASK_ID, DEFAULT_TASK_ID);
                AddEditTaskViewModelFactory factory = new AddEditTaskViewModelFactory(getApplication(), mTaskId);
                viewModel = ViewModelProviders.of(this, factory).get(AddEditTaskViewModel.class);

                viewModel.getTask().observe(this, new Observer<TaskEntry>() {
                    @Override
                    public void onChanged(TaskEntry taskEntry) {
                        viewModel.getTask().removeObserver(this);
                        populateUI(taskEntry);
                    }
                });

            }
        } else {
            AddEditTaskViewModelFactory factory = new AddEditTaskViewModelFactory(getApplication(), mTaskId);
            viewModel = ViewModelProviders.of(this, factory).get(AddEditTaskViewModel.class);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(INSTANCE_TASK_ID, mTaskId);
        super.onSaveInstanceState(outState);
    }




    /**
     * initViews is called from onCreate to init the member variable views
     */
    private void initViews() {
        mEditText = findViewById(R.id.editTextTaskDescription);
        oEditText = (TextView) findViewById(R.id.editTextTaskDescription);
        mvoicePick = findViewById(R.id.voiceBtn);

        mvoicePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        mButton = findViewById(R.id.saveButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditText.length()==0)
                {
                    mEditText.setError("Enter Description");
                }

                else {
                    Toast.makeText(AddEditTaskActivity.this, "New Task Added!", Toast.LENGTH_SHORT).show();
                }
                onSaveButtonClicked();
            }
        });
    }

    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say Something");

                try {
                       startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
                }
                catch (Exception e){
                    Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
    }

    /**
     * populateUI would be called to populate the UI when in update mode
     *
     * @param task the taskEntry to populate the UI
     */
    private void populateUI(TaskEntry task) {
        if(task == null){
            return;
        }
        mEditText.setText(task.getDescription());
        oEditText.setText(task.getDescription());

        setPriorityInViews(task.getPriority());



    }

    /**
     * onSaveButtonClicked is called when the "save" button is clicked.
     * It retrieves user input and inserts that new task data into the underlying database.
     */
    public void onSaveButtonClicked() {
        // Not yet implemented
        String description = mEditText.getText().toString();
        int priority = getPriorityFromViews();
        String select = datetext.getText().toString();
        Date date = new Date();
        TaskEntry todo = new TaskEntry(description, priority, select, date);
        if(mTaskId == DEFAULT_TASK_ID)
            viewModel.insertTask(todo);
        else{
            todo.setId(mTaskId);
            viewModel.updateTask(todo);
        }
        finish();

    }

    /**
     * getPriority is called whenever the selected priority needs to be retrieved
     */
    public int getPriorityFromViews() {
        int priority = 1;
        int checkedId = ((RadioGroup) findViewById(R.id.radioGroup)).getCheckedRadioButtonId();
        switch (checkedId) {
            case R.id.radButton1:
                priority = PRIORITY_HIGH;
                break;
            case R.id.radButton2:
                priority = PRIORITY_MEDIUM;
                break;
            case R.id.radButton3:
                priority = PRIORITY_LOW;
        }
        return priority;
    }


    /**
     * setPriority is called when we receive a task from MainActivity
     *
     * @param priority the priority value
     */
    public void setPriorityInViews(int priority) {
        switch (priority) {
            case PRIORITY_HIGH:
                ((RadioGroup) findViewById(R.id.radioGroup)).check(R.id.radButton1);
                break;
            case PRIORITY_MEDIUM:
                ((RadioGroup) findViewById(R.id.radioGroup)).check(R.id.radButton2);
                break;
            case PRIORITY_LOW:
                ((RadioGroup) findViewById(R.id.radioGroup)).check(R.id.radButton3);
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
     yearFinal = year;
     monthFinal = month + 1;
     dayFinal = dayOfMonth;


     Calendar c = Calendar.getInstance();
     hour = c.get(Calendar.HOUR_OF_DAY);
     minute = c.get(Calendar.MINUTE);

     TimePickerDialog timePickerDialog = new TimePickerDialog(AddEditTaskActivity.this, AddEditTaskActivity.this, hour, minute, false);
      timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
       hourFinal = hourOfDay;
       minuteFinal = minute;

        datetext.setText("Date: " +yearFinal + "/" +
                monthFinal + "/" +
                dayFinal + "\n" +
                "Time: " +hourFinal + ":" +
                minuteFinal);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_CODE_SPEECH_INPUT:{
                if(requestCode == RESULT_OK && null!=data){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    oEditText.setText(result.get(0));
                }
                break;
            }
        }
    }
}
