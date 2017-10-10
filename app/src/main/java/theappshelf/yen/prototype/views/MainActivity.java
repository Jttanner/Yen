package theappshelf.yen.prototype.views;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import theappshelf.yen.R;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    String databaseName = "YenDB.db";

    //SimpleServerProxy serverProxy = new SimpleServerProxy();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Yen: Money Manager");

        setContentView(R.layout.activity_main);

        setupPage(0,0);

    }

    private void dbConnect(){
        //serverProxy.openDBConnection(this);
    }

    private void addToEarned(int increase){
        View view = new View(this);

    }

    private void setupTextEntry(String item, String description, int viewID){
        //RelativeLayout entry = (RelativeLayout) findViewById(R.id.settings_layout);

        //format strings
        TextView textView = (TextView) findViewById(viewID);
        //textView.setId(textID++);
        String info = item + description;
        SpannableString ss1 = new SpannableString(info);
        ss1.setSpan(new RelativeSizeSpan(1.5f), 0, item.length(), 0);
        textView.setText(ss1);
    }

    private void updateSpentValue(int newValue){
        setupTextEntry("Spent: ", Integer.toString(newValue), R.id.spentText);
    }

    private void updateEarnedValue(int newValue){
        setupTextEntry("Earned: ", Integer.toString(newValue), R.id.earnedText);
    }

    private void resetInput(){
        ((EditText) findViewById(R.id.inputInfo)).setText("0");
    }

    protected void setupPage(int existingSpent, int existingEarned){

        setupTextEntry("Earned: ", Integer.toString(existingEarned), R.id.earnedText);

        setupTextEntry("Spent: ", Integer.toString(existingSpent), R.id.spentText);

        findViewById(R.id.addSpentButton).setOnClickListener(new View.OnClickListener(){
            //TODO: either get values from database or format correctly before parseint, null checking

            @Override
            public void onClick(View v) {
                String formattedString = ((TextView)findViewById(R.id.spentText)).getText().toString().substring(7);
                int baseValue = Integer.parseInt(formattedString);
                int changedValue = 0;
                try{
                    changedValue = Integer.parseInt(((EditText)findViewById(R.id.inputInfo)).getText().toString());
                }catch (Exception e){
                    Toast.makeText(getBaseContext(), "Invalid input.  Must be a number with no letters or symbols", Toast.LENGTH_LONG).show();
                }

                if (changedValue > 0){
                    updateSpentValue(baseValue + changedValue);
                    resetInput();
                } else{
                    Toast.makeText(getBaseContext(), "to remove a previous transaction, go into the transaction list. (No Negative Input Error)", Toast.LENGTH_LONG).show();
                }

            }

        });

        findViewById(R.id.addEarnedButton).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String formattedString = ((TextView)findViewById(R.id.earnedText)).getText().toString().substring(8);
                int baseValue = Integer.parseInt(formattedString);
                int changedValue = 0;
                try{
                    changedValue = Integer.parseInt(((EditText)findViewById(R.id.inputInfo)).getText().toString());
                } catch(Exception e){
                    Toast.makeText(getBaseContext(), "Invalid input.  Must be a number with no letters or symbols", Toast.LENGTH_LONG).show();
                }
                if (changedValue > 0){
                    updateEarnedValue(baseValue + changedValue);
                    resetInput();
                } else{
                    Toast.makeText(getBaseContext(), "to remove a previous transaction, go into the transaction list. (No Negative Input Error)", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

}
