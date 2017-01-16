package mx.alfredoul.refreshindicator;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout sfiMinIndicadorDeRefresh;  // declaramos variables globales
    ListView lstMiLista;
    Adapter adaptador; //creamos objeto tipo adaptador para poder visualizar la vista y viasualizar lo que esta en strings

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sfiMinIndicadorDeRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMinIndicadorDeRefresh); //no es necesario instanciar el objeto porque se declaro desde el XML y ya vive en memoria por o que no se requiere new()
        lstMiLista = (ListView) findViewById(R.id.lstMiLista);

        String[] planetas = getResources().getStringArray(R.array.planetas); // traemos la lista de planetas a nuestro arreglo
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));

        sfiMinIndicadorDeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {  //ya tenemos un nuevo metodo onRefresh
                refrescandoContenido();
            }
        });
    }

    //creamos el método que ejecutara la acción cuando refresquemos
    public void refrescandoContenido() {
            String[] planetas = getResources().getStringArray(R.array.planetas); //solo carga nuevamente el array
            lstMiLista.setAdapter (new ArrayAdapter(this, android.R.layout.simple_list_item_1,planetas)); //lo desplegamos
            sfiMinIndicadorDeRefresh.setRefreshing(false); // no se ejecuta ninguna acción mas
    }

}
