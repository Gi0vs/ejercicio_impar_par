package e.bo.parimparapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.security.SecureRandom
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        val random = SecureRandom()
        random.setSeed(random.generateSeed(20))

        return random.nextInt(end - start + 1) + start
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var correctos = 0;
        var incorrectos=0;
        textView_numero_a_evaluar.text = rand(1,11).toString();
        btn_par.setOnClickListener{
            if (Integer.parseInt(textView_numero_a_evaluar.toString())%(2 ) ==0)
            {
                correctos++;
            }else{
                incorrectos++;
            }
            textView_numero_a_evaluar.text = rand(1,11).toString();
        }
        btn_impar.setOnClickListener{
            if (Integer.parseInt(textView_numero_a_evaluar.toString())%(2 )==0)
            {
                incorrectos++;
            }else{
                correctos++;
            }
            textView_numero_a_evaluar.text = rand(1,11).toString();
        }
        textView_contador_Incorrectos.text = incorrectos.toString();
        textView_contador_Correctos.text = correctos.toString();
    }
}