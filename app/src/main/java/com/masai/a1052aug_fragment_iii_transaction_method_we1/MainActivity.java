package com.masai.a1052aug_fragment_iii_transaction_method_we1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnAddA;
    private Button mBtnRemoveA;
    private Button mBtnReplaceAWithBackstack;
    private Button mBtnReplaceAWithoutBackstack;
    private Button mBtnAddB;
    private Button mBtnReplaceWithA;
    private Button mBtnRemoveB;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getSupportFragmentManager();
    }

    private void initViews() {
        mBtnAddA = findViewById(R.id.btnAddA);
        mBtnAddB = findViewById(R.id.btnAddB);
        mBtnRemoveA = findViewById(R.id.btnRemoveA);
        mBtnRemoveB = findViewById(R.id.btnRemoveB);
        mBtnReplaceAWithBackstack = findViewById(R.id.btnReplaceAWithBackstack);
        mBtnReplaceAWithoutBackstack = findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        mBtnReplaceWithA = findViewById(R.id.btnReplaceBWithA);
        mBtnReplaceWithA.setOnClickListener(this);
        mBtnAddA.setOnClickListener(this);
        mBtnAddB.setOnClickListener(this);
        mBtnRemoveA.setOnClickListener(this);
        mBtnRemoveB.setOnClickListener(this);
        mBtnReplaceAWithBackstack.setOnClickListener(this);
        mBtnReplaceAWithoutBackstack.setOnClickListener(this);
        mBtnReplaceWithA.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnAddA:
                addA();
                break;

            case R.id.btnAddB:
                addB();
                break;

            case R.id.btnReplaceAWithBackstack:
                replaceAWithBWithBackstack();
                break;

            case R.id.btnReplaceAWithBWithoutBackstack:
                replaceAWithB();
                break;

            case R.id.btnRemoveA:
                removeA();
                break;

            case R.id.btnRemoveB:
                removeB();
                break;

            case R.id.btnReplaceBWithA:
                replaceBWithA();
                break;

        }
    }

    private void replaceAWithBWithBackstack() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.replace(R.id.flContainer, fragmentB, "fragmentB").addToBackStack("fragB").commit();
    }

    private void removeB() {
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("fragmentB");
        if (fragmentB != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(fragmentB).commit();
        }
    }

    private void removeA() {
        // FragmentA fragmentA = fragmentManager.findFragmentByTag("fragmentA"); error is shown so typecast
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("fragmentA");
        if (fragmentA != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(fragmentA).commit();
        }
    }

    private void replaceBWithA() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.replace(R.id.flContainer, fragmentB, "fragmentA").commit();
    }

    private void replaceAWithB() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.replace(R.id.flContainer, fragmentB, "fragmentB").commit();
    }

    private void addB() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.add(R.id.flContainer, fragmentB, "fragmentB").addToBackStack("addB").commit();
    }

    private void addA() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA(); //tag : is unique identifier
        transaction.add(R.id.flContainer, fragmentA, "fragmentA").addToBackStack("addA").commit();
    }

}