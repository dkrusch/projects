package com.example.backup.be_happy.data;

import com.example.backup.be_happy.model.Quote;

import java.util.ArrayList;

/**
 * Created by paulodichone on 11/8/17.
 */

public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Quote> quotes);
}
