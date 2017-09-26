package ServerProxy;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by jontt on 8/27/2017.
 */

public class SimpleServerProxy extends SQLiteOpenHelper {

    private static final String databaseName = "YenDB.db";
    private static final int databaseVersion = 2;

    public SimpleServerProxy(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, databaseName, factory, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE IF NOT EXISTS Users (UserID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "UserName TEXT NOT NULL," +
                "Password TEXT NOT NULL," +
                "SecurityQuestionA TEXT NOT NULL," +
                "SecurityQuestionB TEXT NOT NULL," +
                "SecurityAnswerA TEXT NOT NULL," +
                "SecurityAnswerB TEXT NOT NULL);";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDB(){

    }


    /*
    private SQLiteDatabase database;

    public String getDatabaseName() {
        return databaseName;
    }

    public void openDBConnection(Context context){
        database.openOrCreateDatabase(databaseName, null , null);
    }

    public void closeDBConnection(){
        database.close();
    }
*/
}
