package br.com.caspinheiro.aulas.agendacontatos.singleton;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import br.com.caspinheiro.aulas.agendacontatos.util.AppDatabase;

public class SingletonDatabase {

    private static AppDatabase appDatabase = null;

    private SingletonDatabase(){}

    private static Migration migration1to2 = new Migration(1,2){

        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE tb_contato ADD nu_telefone_celular TEXT");
            database.execSQL("UPDATE tb_contato SET nu_telefone_celular = nu_telefone" );
            database.execSQL("UPDATE tb_contato SET nu_telefone = '' " );
        }
    };


    private  static Migration migration2to3 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE tb_contato ADD cd_tipo_contato INTEGER");
            database.execSQL("CREATE TABLE tb_tipo_contato ( cd_tipo_contato INTEGER PRIMARY KEY, ds_tipo_contato TEXT )");
            database.execSQL("INSERT INTO tb_tipo_contato ( cd_tipo_contato, ds_tipo_contato ) VALUES ( 1, 'Amigo' )");
            database.execSQL("INSERT INTO tb_tipo_contato ( cd_tipo_contato, ds_tipo_contato ) VALUES ( 2, 'Parente' )");
            database.execSQL("INSERT INTO tb_tipo_contato ( cd_tipo_contato, ds_tipo_contato ) VALUES ( 3, 'Trabalho' )");
        }
    };

    public static AppDatabase getInstance(Context context){
        if( appDatabase == null ){
            appDatabase = Room.databaseBuilder( context,
                AppDatabase.class, "contato.sqlite" )
                .addMigrations( migration1to2, migration2to3 ).build();
        }

        return appDatabase;
    }

}
