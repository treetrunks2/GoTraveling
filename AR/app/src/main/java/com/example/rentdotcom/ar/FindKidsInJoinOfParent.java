package com.example.rentdotcom.ar;
/**
 * Created by sookmyung on 2017-10-01.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class FindKidsInJoinOfParent extends AppCompatActivity {
    private ListView childListView;
    private KidListAdapter kidListAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parentofjoininkidsfind);

        childListView = findViewById(R.id.listView);
        kidListAdapter = new KidListAdapter(this, R.layout.test_list);
        childListView.setAdapter(kidListAdapter);
        for(final KidEntry entry : getNewsEntries()) {
            kidListAdapter.add(entry);
        }
    }

    private List<KidEntry> getNewsEntries() {
        final List<KidEntry> entries = new ArrayList<KidEntry>();
        entries.add(new KidEntry("김진소리","부모 : 장동건, 고소영   ",new GregorianCalendar(2010, 11, 1).getTime(), R.drawable.news_icon_1));
        entries.add(new KidEntry("이민정","부모 : 박태환, 이민정   ",new GregorianCalendar(2011, 2, 10).getTime(), R.drawable.news_icon_2));
        entries.add(new KidEntry("양여명","부모 : 연정훈, 한가인   ",new GregorianCalendar(2012, 1, 1).getTime(), R.drawable.news_icon_3));
        entries.add(new KidEntry("최현아","부모 : 우효광, 추자현   ",new GregorianCalendar(2013, 3, 1).getTime(), R.drawable.news_icon_2));
        entries.add(new KidEntry("김이슬","부모 : 정지훈, 김태희   ",new GregorianCalendar(2012, 7, 1).getTime(), R.drawable.news_icon_4));
        entries.add(new KidEntry("나희수","부모 : 기성용, 한혜진   ",new GregorianCalendar(2009, 8, 1).getTime(), R.drawable.news_icon_3));
        entries.add(new KidEntry("이아영","부모 : 류수영, 박하선   ",new GregorianCalendar(2009, 10, 1).getTime(), R.drawable.news_icon_3));
        entries.add(new KidEntry("김연아","부모 : 민우혁, 이세미   ",new GregorianCalendar(2009, 12, 1).getTime(), R.drawable.news_icon_5));
        entries.add(new KidEntry("박나래","부모 : 김재욱, 서현진   ",new GregorianCalendar(2009, 12, 1).getTime(), R.drawable.news_icon_5));
        return entries;
    }


}
