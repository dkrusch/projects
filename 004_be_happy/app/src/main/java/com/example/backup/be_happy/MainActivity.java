package com.example.backup.be_happy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.backup.be_happy.data.QuoteData;
import com.example.backup.be_happy.data.QuoteListAsyncResponse;
import com.example.backup.be_happy.data.QuoteViewPagerAdapter;
import com.example.backup.be_happy.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private QuoteViewPagerAdapter quoteViewPagerAdapter;
    private ViewPager viewPager;
    String quoteEmail;
    String authorEmail;
    Button emailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteViewPagerAdapter = new QuoteViewPagerAdapter(getSupportFragmentManager(), getFragments());

        viewPager = findViewById(R.id.viewPager);
        emailButton = (Button) findViewById(R.id.buttonEmail);
        viewPager.setAdapter(quoteViewPagerAdapter);

    }

    private List<Fragment> getFragments() {
        final List<Fragment> fragmentList = new ArrayList<>();
        new QuoteData().getQuotes(new QuoteListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {
                for (int i = 0; i < quotes.size(); i++) {
                    QuoteFragment quoteFragment = QuoteFragment.newInstance(
                            quotes.get(i).getQuote(),
                            quotes.get(i).getAuthor()
                    );
                    fragmentList.add(quoteFragment);
                }
                quoteViewPagerAdapter.notifyDataSetChanged();/// very important!!

            }
        });


        return fragmentList;
    }

    public void onClick(View view)
    {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"daniel.krusch@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Shared Quote");
        emailIntent.putExtra(Intent.EXTRA_TEXT, quoteEmail + " - " + authorEmail);
        startActivity(emailIntent);

        startActivity(emailIntent);
    }

}


