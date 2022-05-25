package cm.pfe.calculatrice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class MainActivity extends AppCompatActivity {


    TextView calculTV; //Notre textView qui va contenir la formule
    TextView resultsTV; //Notre textview qui va contenir le resultat du calcul

    String calcul = ""; //C'est dans cette variable qe l'on va stocker tous les caractères que l'utilisateur aura choisi
    String formule = ""; //Nous allons utiliser cette variable pour stocker le calcul afin de l'exécuter




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculTV = (TextView)findViewById(R.id.calculTextView); //On va lier notre variable textView au textVeiw de notre interface qui contiendra la formule
        resultsTV = (TextView)findViewById(R.id.resultTextView);  //On va lier notre variable textView au textVeiw de notre interface qui contiendra le resultat du calcul
    }


//******************* cette méthode permet de modifier le contenu de notre texview qui contient la formule entré par l'utilisateur******************
    private void setcalcul(String givenValue)
    {
        calcul = calcul + givenValue; //On ajoute l'element passé en paramètre à notre variable qui contient le calcul de l'utilisateur
        calculTV.setText(calcul); //On écrit la valeur de la variable xorkings dans notre textView qui contient le clacul
    }



//******************** Cette méthode s'éxécute lorsqu'on clique sur egal (=)**************************
    public void equalsOnClick(View view)
    {


        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino"); //On initialise un moteur de script. "rhino" est le nom du moteur de Script
       // checkForPowerOf();
        formule = calcul; // La variable formule prend comme valuer ce qui se trouve dans le champs de formule

        if(formule.equals("")){
            Toast.makeText(this, "Aucun Calcul", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            result = (double)engine.eval(formule); //On demande au moteur de Script d'éxécuter ce qui se trouve dans la variable formule
        } catch (ScriptException e)
        {
            Toast.makeText(this, "Entrées Invalides", Toast.LENGTH_SHORT).show(); //En cas d'erreur
        }

        if(result != null)
            resultsTV.setText(String.valueOf(result.doubleValue())); // On affiche la valeur obtenu après le calcul dans le champ destiné au résultat

    }





//************************ Lorsqu'on clique sur le bouton effacer (C) ***************************
    public void clearOnClick(View view)
    {
        calculTV.setText(""); // On attribu à notre champ de texte qui contient la formule la valeur ("") donc il ne contiendra plus aucun caractère
        calcul = ""; //On initialise la valeur de notre variable pour qu'elle ne contienne plus aucun élément
        resultsTV.setText(""); //On fait de meme pour le textView du résultat, il ne contiendra plus aucune valeur
    }




//**********************Lorsqu'on clique sur le bouton diviser (/) ***********************

    public void divisionOnClick(View view)
    {
        setcalcul("/"); //Voir la méthode setCalcul
    }

    //**********************Lorsqu'on clique sur le bouton 7  ***********************
    public void sevenOnClick(View view)
    {
        setcalcul("7");
    }

    //**********************Lorsqu'on clique sur le bouton 8 ***********************
    public void eightOnClick(View view)
    {
        setcalcul("8");
    }
    //**********************Lorsqu'on clique sur le bouton 9  ***********************
    public void nineOnClick(View view)
    {
        setcalcul("9");
    }

    //**********************Lorsqu'on clique sur le bouton de multiplication (*) ***********************
    public void timesOnClick(View view)
    {
        setcalcul("*");
    }

    //**********************Lorsqu'on clique sur le bouton 4 ***********************
    public void fourOnClick(View view)
    {
        setcalcul("4");
    }

    //**********************Lorsqu'on clique sur le bouton 5 ***********************
    public void fiveOnClick(View view)
    {
        setcalcul("5");
    }

    //**********************Lorsqu'on clique sur le bouton 6 ***********************
    public void sixOnClick(View view)
    {
        setcalcul("6");
    }

    //**********************Lorsqu'on clique sur le bouton de soustraction (-) ***********************
    public void minusOnClick(View view)
    {
        setcalcul("-");
    }

    //**********************Lorsqu'on clique sur le bouton 1 ***********************
    public void oneOnClick(View view)
    {
        setcalcul("1");
    }

    //**********************Lorsqu'on clique sur le bouton 2 ***********************
    public void twoOnClick(View view)
    {
        setcalcul("2");
    }

    //**********************Lorsqu'on clique sur le bouton 3 ***********************
    public void threeOnClick(View view)
    {
        setcalcul("3");
    }

    //**********************Lorsqu'on clique sur le bouton  d'addition (+) ***********************
    public void plusOnClick(View view)
    {
        setcalcul("+");
    }

    //**********************Lorsqu'on clique sur le bouton de virgule (.) ***********************
    public void decimalOnClick(View view)
    {
        setcalcul(".");
    }

    //**********************Lorsqu'on clique sur le bouton 0 ***********************
    public void zeroOnClick(View view)
    {
        setcalcul("0");
    }
}
