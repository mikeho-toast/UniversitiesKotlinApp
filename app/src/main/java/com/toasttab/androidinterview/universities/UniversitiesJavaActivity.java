package com.toasttab.androidinterview.universities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.toasttab.androidinterview.R;
import com.toasttab.androidinterview.app.BaseDaggerAppCompatActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class UniversitiesJavaActivity extends BaseDaggerAppCompatActivity {

    @Inject
    UniversitiesService universitiesService;

    private ListView universitiesList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universities);
        setTitle(R.string.universities_java_activity);

        universitiesList = findViewById(R.id.universitiesList);

        new AsyncTask<Void, Void, List<University>>() {

            @Override
            protected List<University> doInBackground(Void... voids) {
                try {
                    return universitiesService.listUniversities("United States", null)
                            .execute().body();
                } catch (IOException e) {
                    // well shucks
                    return null;
                }
            }

            @Override
            protected void onPostExecute(List<University> universities) {
                if (universities != null) {
                    ArrayList<String> names = new ArrayList<>();
                    for (University university : universities) {
                        names.add(university.getName());
                    }

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                            UniversitiesJavaActivity.this,
                            android.R.layout.simple_list_item_1,
                            android.R.id.text1,
                            names
                    );

                    universitiesList.setAdapter(arrayAdapter);
                }
            }
        }.execute();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void navigateToWebView(@NotNull University university) {

    }
}
