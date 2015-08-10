package englishmuffin.example.com.englishmuffin;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private List<Words> word = new ArrayList<Words>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateWordList();
        populateListView();
    }


    private void populateWordList() {
        word.add(new Words("solar system", "a group of planets and other bodies that revolve around a star"));
        word.add(new Words("renovate", "to renew or rebuild so that something is in good condition"));
        word.add(new Words("informal", "casual and relaxed and doesn’t follow any particular rules or conventions"));
        word.add(new Words("cautious", "like careful, means you're on guard"));
        word.add(new Words("descriptive", "vivid and specific, and helps someone imagine a scene he didn't witness"));
    }

    private void populateListView() {
        ArrayAdapter<Words> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.listViewMain);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Words> {
        public MyListAdapter() { super(MainActivity.this, R.layout.item_view, word); }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }

            final Words currentWord = word.get(position);

            TextView word = (TextView) itemView.findViewById(R.id.txtWord);
            word.setText(currentWord.getWord());

            final TextView define = (TextView) itemView.findViewById(R.id.txtDefinition);
            define.setText("");

            Button button = (Button) itemView.findViewById(R.id.defineButton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(define.getText()=="")
                        define.setText(currentWord.getDefine());
                    else{
                        define.setText("");
                    }
                }
            });



            //  MediaStore.Audio audio = (MediaStore.Audio) findViewById(R.id.)
            return itemView;
        }
    }
}
