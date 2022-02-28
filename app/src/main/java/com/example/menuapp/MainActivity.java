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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            case R.id.mnuLocation:
                Toast.makeText(this, "Set location", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnuUpload:
                Toast.makeText(this, "Upload item", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);

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
        dialog=builder.create();
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
        dialog.show();
    }

}