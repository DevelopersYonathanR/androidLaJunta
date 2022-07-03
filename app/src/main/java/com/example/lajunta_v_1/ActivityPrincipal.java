package com.example.lajunta_v_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.lajunta_v_1.fragments.FragmentPrincipal;
import com.example.lajunta_v_1.fragments.ListaAlimentosFragment;
import com.example.lajunta_v_1.fragments.ListaHabitacionesFragment;
import com.example.lajunta_v_1.fragments.ListaInsumosFragment;
import com.example.lajunta_v_1.fragments.ListaRegistroFragment;
import com.example.lajunta_v_1.fragments.ListaTrabajadorFragment;
import com.google.android.material.navigation.NavigationView;

public class ActivityPrincipal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;

    NavigationView navigationView;


    FragmentManager fragmentManager;

    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);


        //establece evento onclick al navegationView
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        //cargando los fragment
       /* fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new FragmentPrincipal());
        fragmentTransaction.commit();*/


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //para cerrar barra a la hora de seleccionar un item ejemplo inicio
        drawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {

            case R.id.itemInicio:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new FragmentPrincipal());
                fragmentTransaction.commit();
                break;

            case R.id.itemHabitaciones:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new ListaHabitacionesFragment());
                fragmentTransaction.commit();

                break;
            case R.id.itemAlimentos:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new ListaAlimentosFragment());
                fragmentTransaction.commit();
                break;

            case R.id.itemInsumos:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new ListaInsumosFragment());
                fragmentTransaction.commit();

                break;

            case R.id.idTrabajadores:
                break;

            case R.id.idListaRegistro:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new ListaRegistroFragment());
                fragmentTransaction.commit();
                break;
                case R.id.itemListaTrabajador:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new ListaTrabajadorFragment());
                fragmentTransaction.commit();
                break;

            case R.id.itemeSalir:

                Intent  i2 = new Intent(this, MainActivity.class);
                startActivity(i2);
                break;

        }

        return false;
    }
}