package com.example.menuapp;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText stName,stFaculty,stPhone;
    StudentDBHelper studentDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentDBHelper = new StudentDBHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuAdd:
                Toast.makeText(this, "Add item", Toast.LENGTH_SHORT).show();
                showMyDialogue();
                break;
            case R.id.mnuView:
                //Toast.makeText(this, "View Item", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,RecyclerActivity.class));
                break;
            case R.id.mnuProduct:
                startActivity(new Intent(MainActivity.this,CustomRecycler.class));

                break;
            case R.id.mnuAddStudent:
                showStudentForm();
                break;
            case R.id.mnuViewStudent:
                startActivity(new Intent(MainActivity.this,StudentRV.class));
                break;

        }
        return super.onOptionsItemSelected(item);

    }

    private void showStudentForm() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Student Data");
        builder.setMessage("Enter student data correctly");
        View view=LayoutInflater.from(this).inflate(R.layout.studentform,null);
        builder.setView(view);
        stName=view.findViewById(R.id.stName);
        stFaculty=view.findViewById(R.id.stFaculty);
        stPhone=view.findViewById(R.id.stPhone);

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //save data in database
                saveStudent();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //codes to cancel
            }
        });
        builder.show();

    }

    private void saveStudent() {
        if (stName.getText().toString().isEmpty()
                ||stFaculty.getText().toString().isEmpty()||stPhone.getText().toString().isEmpty()){

            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            stName.requestFocus();
            stName.setError("The name is required");
            stFaculty.setError("The faculty is required");
            stPhone.setError("The phone is required");

        }
        else {
            studentDBHelper.insertData(new Student(stName.getText().toString(),stFaculty.getText().toString(),stPhone.getText().toString()));
            stName.setText("");
            stFaculty.setText("");
            stPhone.setText("");

        }

    }

    private void showMyDialogue() {
        AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        myDialog.setTitle("Warning");
        myDialog.setMessage("Do you really to add this item?");
        myDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ///perfom a lot task
                //call the custom dialog box that will allow us to enter data
                showDataForm();
            }
        });
        myDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Perform a lot task
            }
        });
        myDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        myDialog.setCancelable(false);
        myDialog.show();
    }

    private void showDataForm() {
        AlertDialog dialog;
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        View view =inflater.inflate(R.layout.dataform,null,false);
        TextInputEditText editName=view.findViewById(R.id.editName);
        TextInputEditText editEmail=view.findViewById(R.id.editEmail);
        TextInputEditText editPhone=view.findViewById(R.id.editPhone);
        builder.setView(view);

        builder.setTitle("Data entry");
        builder.setMessage("Enter all data as required");
        builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, ""+editName.getText()+"\n"
                        +editEmail.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialog=builder.create();
        dialog.show();
    }

}