package com.example.android.todolist;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;

import com.example.android.todolist.database.AppDatabase;

//  (1) Make this class extend ViewModel ViewModelProvider.NewInstanceFactory
public class AddTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private AppDatabase mDb;
    private int mTaskId;
    //  (2) Add two member variables. One for the database and one for the taskId

    //  (3) Initialize the member variables in the constructor with the parameters received
    public AddTaskViewModelFactory(AppDatabase database, int taskId){
        mDb=database;
        mTaskId=taskId;
    }

    // Note: This can be reused with minor modifications
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new AddTaskViewModel(mDb, mTaskId);
    }
}
